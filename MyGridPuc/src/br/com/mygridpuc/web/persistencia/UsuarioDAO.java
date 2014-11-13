package br.com.mygridpuc.web.persistencia;

import br.com.mygridpuc.web.entidade.Usuario;
import br.com.mygridpuc.web.util.MyGridPucException;

public interface UsuarioDAO extends GenericoDAO<Usuario, Integer> {
	
	public Usuario consultarPorLogin(String login) throws MyGridPucException;

}
