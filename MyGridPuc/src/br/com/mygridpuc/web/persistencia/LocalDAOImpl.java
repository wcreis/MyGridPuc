package br.com.mygridpuc.web.persistencia;

import org.springframework.stereotype.Repository;

import br.com.mygridpuc.web.entidade.Local;

/**
 * Classe que define as operacoes da camada de persistencia de local
 * @author David Rodrigues
 *
 */
@Repository
public class LocalDAOImpl extends GenericoDAOImpl<Local, Integer> implements LocalDAO{

}
