package br.com.mygridpuc.web.seguranca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;

import br.com.mygridpuc.web.util.MyGridPucException;

@Controller
@Scope("request")
public class ProvedorAutenticacao implements AuthenticationProvider{
	
	@Autowired
	private AutenticadorService usuarioService;
	
	@Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException{
        // Login
        String login = (String) authentication.getPrincipal();

        // Excecao de usuario nao autenticado
        if(login == null || login.trim().length()==0){
            throw new AuthenticationServiceException("Erro na localização do LOGIN!!!");
        }

        //Aqui eu pego as informações do usuário pelo próprio spring security
        UserDetails usuario = null;
		try {
			usuario = getUsuarioService().consultarPorLogin(login);
		} catch (MyGridPucException e1) {
			e1.printStackTrace();
		}

        try{
             //Se o usuário não for null, eu o autentico no sistema
            if(usuario != null){
                return new TokenAutenticacao(usuario.getUsername(), usuario.getPassword(), usuario.getAuthorities());

            }else{
                throw new AuthenticationServiceException("Usuário não autenticado.");
            }

        }catch(AuthenticationServiceException e){
            throw e;
        }catch(Throwable e){
            throw new AuthenticationServiceException("Ocorreu um erro no ato da autenticação.", e);
        }
    }

    @Override
    public boolean supports(Class<? extends Object> authentication){
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication)
                && authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

	public AutenticadorService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(AutenticadorService usuarioService) {
		this.usuarioService = usuarioService;
	}
    
}
