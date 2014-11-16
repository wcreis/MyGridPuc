package br.com.mygridpuc.web.seguranca;

import org.springframework.security.core.userdetails.UserDetails;

import br.com.mygridpuc.web.util.MyGridPucException;

	/**
	 * Interface que define as operacoes da camada de negocio de Autenticação de usuario.
	 * @author Wesley Reis
	 *
	 */
	public interface AutenticadorService {
	
	/**
	 * Consulta um usuario pelo login.
	 * @param login
	 * @return UserDetails
	 * @throws MyGridPucException
	 */
	public UserDetails  consultarPorLogin(String login) throws MyGridPucException;

}
