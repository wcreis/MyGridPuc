package com.produto.persistencia;

import java.io.Serializable;
import java.util.List;

import com.produto.util.ProdutoException;

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
	 * @throws ProdutoException
	 */
	public T incluir(T object) throws ProdutoException;
	
	/**
	 * Altera um objeto T na base de dados
	 * @param object
	 * @return
	 * @throws ProdutoException
	 */
	public T alterar(T object) throws ProdutoException;
	
	/**
	 * Consulta um objeto T da base de dados
	 * @param id
	 * @return
	 * @throws ProdutoException
	 */
	public T consultar(Integer id) throws ProdutoException;
	
	/**
	 * Exclui um objeto T  da base de dados
	 * @param id
	 * @throws ProdutoException
	 */
	public void excluir(Integer id) throws ProdutoException;
	
	/**
	 * Lista os objetos T da base de dados
	 * @return
	 * @throws ProdutoException
	 */
	public List<T> listar() throws ProdutoException;
}
