package com.produto.negocio;

import java.util.List;

import com.produto.entidade.Produto;
import com.produto.util.ProdutoException;


/**
 * Interface que define as operacoes da camada de negocio de Pessoa
 * @author David Rodrigues
 *
 */
public interface ProdutoService {

	/**
	 * Inclui um produto
	 * @param pessoa
	 * @return
	 * @throws ProdutoException
	 */
	public Produto incluir(Produto produto) throws ProdutoException;
	
	/**
	 * Altera um produto
	 * @param pessoa
	 * @return
	 * @throws ProdutoException
	 */
	public Produto alterar(Produto produto) throws ProdutoException;
	
	/**
	 * Exclui um produto
	 * @param id
	 * @throws ProdutoException
	 */
	public void excluir(Integer id) throws ProdutoException;
	
	/**
	 * Consulta um produto pelo identificador
	 * @param id
	 * @return
	 * @throws ProdutoException
	 */
	public Produto consultar(Integer id) throws ProdutoException;
	
	/**
	 * Lista todas os produtos cadastradas
	 * @return
	 * @throws ProdutoException
	 */
	public List<Produto> listar() throws ProdutoException;
}
