package br.com.mygridpuc.web.persistencia;

import java.io.Serializable;
import java.util.List;

import br.com.mygridpuc.web.util.MyGridPucException;

/**
 * Interface que define as operacoes da camada de persistencia de Matriz
 * @author David Rodrigues
 *
 */
public interface MatrizDAO <Matriz>{

	/**
	 * Retorna a classe a ser persistida
	 * @return
	 */
	public Class<Matriz> getObjectClass();
	
	/**
	 * Inclui um objeto Matriz na base de dados
	 * @param object
	 * @return
	 * @throws MyGridPucException
	 */
	public Matriz incluir(Matriz object) throws MyGridPucException;
	
	/**
	 * Altera um objeto Matriz na base de dados
	 * @param object
	 * @return
	 * @throws MyGridPucException
	 */
	public Matriz alterar(Matriz object) throws MyGridPucException;
	
	/**
	 * Consulta um objeto Matriz da base de dados
	 * @param id
	 * @return
	 * @throws MyGridPucException
	 */
	public Matriz consultar(Integer id) throws MyGridPucException;
	
	/**
	 * Exclui um objeto Matriz  da base de dados
	 * @param id
	 * @throws MyGridPucException
	 */
	public void excluir(Integer id) throws MyGridPucException;
	
	/**
	 * Lista os objetos Matriz da base de dados
	 * @return
	 * @throws MyGridPucException
	 */
	public List<Matriz> listar() throws MyGridPucException;
	
	/**
	 * Lista os objetos Matriz da base de dados
	 * @return
	 * @throws MyGridPucException
	 */
	public List<Matriz> listar(Integer idCurso) throws MyGridPucException;

}
