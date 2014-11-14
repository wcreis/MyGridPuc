package br.com.mygridpuc.web.negocio;

import java.util.List;

import br.com.mygridpuc.web.entidade.Usuario;
import br.com.mygridpuc.web.util.MyGridPucException;

	/**
	 * Interface que define as operacoes da camada de negocio de usuario.
	 * @author Wesley Reis
	 *
	 */
	public interface UsuarioService {

	/**
	 * Inclui um usuario
	 * @param usuario
	 * @return
	 * @throws MyGridPucException
	 */
	public Usuario incluir(Usuario usuario) throws MyGridPucException;
	
	/**
	 * Altera um usuario
	 * @param usuario
	 * @return
	 * @throws MyGridPucException
	 */
	public Usuario alterar(Usuario usuario) throws MyGridPucException;
	
	/**
	 * Exclui um usuario
	 * @param id
	 * @throws MyGridPucException
	 */
	public void excluir(Integer id) throws MyGridPucException;
	
	/**
	 * Consulta um usuario pelo identificador
	 * @param id
	 * @return Usuario
	 * @throws MyGridPucException
	 */
	public Usuario consultar(Integer id) throws MyGridPucException;
	
	/**
	 * Lista todas os usuarios cadastradoas
	 * @return List<Usuario>
	 * @throws MyGridPucException
	 */
	public List<Usuario> listar() throws MyGridPucException;
}
