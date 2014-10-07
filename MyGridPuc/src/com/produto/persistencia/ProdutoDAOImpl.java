package com.produto.persistencia;

import org.springframework.stereotype.Repository;

import com.produto.entidade.Produto;

/**
 * Classe que define as operacoes da camada de persistencia de Pessoa
 * @author David Rodrigues
 *
 */

@Repository
public class ProdutoDAOImpl extends GenericoDAOImpl<Produto, Integer> implements ProdutoDAO{

}
