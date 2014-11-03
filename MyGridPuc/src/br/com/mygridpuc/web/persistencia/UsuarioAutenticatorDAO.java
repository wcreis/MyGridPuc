package br.com.mygridpuc.web.persistencia;

import br.com.mygridpuc.web.entidade.Usuario;

public interface UsuarioAutenticatorDAO {
	
	public Usuario consultarPorLogin(Usuario u);

}
