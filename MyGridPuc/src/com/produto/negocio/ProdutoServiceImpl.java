package com.produto.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.produto.entidade.Produto;
import com.produto.persistencia.ProdutoDAO;
import com.produto.util.ProdutoException;

/**
 * Classe que define as operacoes da camada de negocio de Pessoa
 * @author David Rodrigues
 *
 */

@Service
@Transactional
public class ProdutoServiceImpl implements ProdutoService{
	
	private ProdutoDAO produtoDAO;
	
	public ProdutoDAO getProdutoDAO() {
		return produtoDAO;
	}

	@Autowired
	public void setProdutoDAO(ProdutoDAO produtoDAO) {
		this.produtoDAO = produtoDAO;
	}


	/**
	 * Inclui um produto
	 * @param produto
	 * @return
	 * @throws ProdutoException
	 */
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public Produto incluir(Produto produto) throws ProdutoException {
		return getProdutoDAO().incluir(produto);
	}

	/**
	 * Altera uma produto
	 * @param produto
	 * @return
	 * @throws ProdutoException
	 */
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public Produto alterar(Produto produto) throws ProdutoException {
//		Produto produtoExistente = consultar(produto.getIdProduto());
		return getProdutoDAO().alterar(produto);
	}

	/**
	 * Exclui um produto
	 * @param produto
	 * @throws ProdutoException
	 */
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public void excluir(Integer id) throws ProdutoException {
//		Produto produtoExistente = consultar(id);
		getProdutoDAO().excluir(id);
	}

	/**
	 * Consulta um produto pelo identificador
	 * @param id
	 * @return
	 * @throws ProdutoException
	 */
	@Transactional(readOnly=true, propagation = Propagation.SUPPORTS)
	public Produto consultar(Integer id) throws ProdutoException {
		Produto produto = getProdutoDAO().consultar(id);
		return produto;
	}

	/**
	 * Lista todas os produtos cadastradas
	 * @return
	 * @throws ProdutoException
	 */
	@Transactional(readOnly=true, propagation = Propagation.SUPPORTS)
	public List<Produto> listar() throws ProdutoException {
		return getProdutoDAO().listar();
	}

}
