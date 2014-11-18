package br.com.mygridpuc.web.seguranca;

import java.util.Collection;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

/**
 * Classe responsável pelo token de autenticação
 * 
 * @author David Rodrigues
 *
 */
public class TokenAutenticacao extends UsernamePasswordAuthenticationToken{
	private static final long serialVersionUID = -40848295909492318L;

	//CONSTRUCTOR
    public TokenAutenticacao(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities){
        super(principal, credentials, authorities);
    }
}
