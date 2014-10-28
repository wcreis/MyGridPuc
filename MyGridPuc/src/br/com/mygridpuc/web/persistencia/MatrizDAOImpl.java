package br.com.mygridpuc.web.persistencia;

import org.springframework.stereotype.Repository;

import br.com.mygridpuc.web.entidade.Matriz;

/**
 * Classe que define as operacoes da camada de persistencia de Matriz
 * @author David Rodrigues
 *
 */
@Repository
public class MatrizDAOImpl extends GenericoDAOImpl<Matriz, Integer> implements MatrizDAO{

}
