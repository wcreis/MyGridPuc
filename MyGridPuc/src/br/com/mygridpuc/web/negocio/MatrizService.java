package br.com.mygridpuc.web.negocio;

import java.util.List;

import br.com.mygridpuc.web.entidade.Matriz;
import br.com.mygridpuc.web.util.MyGridPucException;

/**
 * Interface que define as operacoes da camada de negocio de matriz
 * @author David Rodrigues
 *
 */
public interface MatrizService {

	/**
	 * Inclui um matriz
	 * @param matriz
	 * @return
	 * @throws MyGridPucException
	 */
	public Matriz incluir(Matriz matriz) throws MyGridPucException;
	
	/**
	 * Altera um matriz
	 * @param matriz
	 * @return
	 * @throws MyGridPucException
	 */
	public Matriz alterar(Matriz matriz) throws MyGridPucException;
	
	/**
	 * Exclui um matriz
	 * @param id
	 * @throws MyGridPucException
	 */
	public void excluir(Integer id) throws MyGridPucException;
	
	/**
	 * Consulta um matriz pelo identificador
	 * @param id
	 * @return
	 * @throws MyGridPucException
	 */
	public Matriz consultar(Integer id) throws MyGridPucException;
	
	/**
	 * Lista todas as matriz cadastradas
	 * @return
	 * @throws MyGridPucException
	 */
	public List<Matriz> listar() throws MyGridPucException;
}
