package br.com.mygridpuc.web.persistencia;

import br.com.mygridpuc.web.entidade.Usuario;
import br.com.mygridpuc.web.util.MyGridPucException;

/**
 * Interface que define as operacoes da camada de persistencia
 * 
 * @author David Rodrigues
 *
 */
public interface UsuarioDAO extends GenericoDAO<Usuario, Integer> {
	
	public Usuario consultarPorLogin(String login) throws MyGridPucException;

}
