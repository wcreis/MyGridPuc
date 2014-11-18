package br.com.mygridpuc.web.seguranca;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mygridpuc.web.entidade.Usuario;
import br.com.mygridpuc.web.persistencia.UsuarioDAO;
import br.com.mygridpuc.web.util.MyGridPucException;

/**
 * Classe que define as operacoes da camada de negocio de Usuario
 * 
 * @author Wesley Reis
 *
 */
@Service
@Transactional
public class AutenticadorServiceImpl implements AutenticadorService {
	
	private UsuarioDAO usuarioDAO;
	
	/**
	 * @return the usuarioDAO
	 */
	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	/**
	 * @param usuarioDAO the usuarioDAO to set
	 */
	@Autowired
	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
	
	
	/* (non-Javadoc)
	 * @see br.com.mygridpuc.web.seguranca.AutenticadorService#consultarPorLogin(java.lang.String)
	 * 
	 * Método responsável pela consulta de login
	 * 
	 */
	@Override
	public UserDetails  consultarPorLogin(String login) throws MyGridPucException {
		Usuario usuario = new Usuario();
		usuario.setEmailUsuario(login);
		
		usuario = getUsuarioDAO().consultarPorLogin(login);
		return buildUserFromUserEntity(usuario);
	}
	
	 private User buildUserFromUserEntity(Usuario usuario) {
	        User springUser = null;

	        try {
	            // convert model user to spring security user
	            String login = usuario.getEmailUsuario();
	            String senha = usuario.getSenhaUsuario();
	            boolean enabled = true;
	            boolean accountNonExpired = true;
	            boolean credentialsNonExpired = true;
	            boolean accountNonLocked = true;

	            Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	            authorities.add(new GrantedAuthorityImpl(usuario.getTipoUsuario()));

	            springUser = new User(login, senha, enabled,
	                    accountNonExpired, credentialsNonExpired, accountNonLocked,
	                    authorities);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return springUser;
	    }

}
