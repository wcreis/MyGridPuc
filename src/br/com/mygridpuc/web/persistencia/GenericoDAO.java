package br.com.mygridpuc.web.persistencia;

import java.io.Serializable;
import java.util.List;

import br.com.mygridpuc.web.util.MyGridPucException;

/**
 * Interface que define as operacoes da camada de persistencia generica
 * @author David Rodrigues
 *
 */
public interface GenericoDAO<T, ID extends Serializable> {
	
	/**
	 * Retorna a classe a ser persistida
	 * @return
	 */
	public Class<T> getObjectClass();
	
	/**
	 * Inclui um objeto T na base de dados
	 * @param object
	 * @return
	 * @throws MyGridPucException
	 */
	public T incluir(T object) throws MyGridPucException;
	
	/**
	 * Altera um objeto T na base de dados
	 * @param object
	 * @return
	 * @throws MyGridPucException
	 */
	public T alterar(T object) throws MyGridPucException;
	
	/**
	 * Consulta um objeto T da base de dados
	 * @param id
	 * @return
	 * @throws MyGridPucException
	 */
	public T consultar(Integer id) throws MyGridPucException;
	
	/**
	 * Exclui um objeto T  da base de dados
	 * @param id
	 * @throws MyGridPucException
	 */
	public void excluir(Integer id) throws MyGridPucException;
	
	/**
	 * Lista os objetos T da base de dados
	 * @return
	 * @throws MyGridPucException
	 */
	public List<T> listar() throws MyGridPucException;
}
