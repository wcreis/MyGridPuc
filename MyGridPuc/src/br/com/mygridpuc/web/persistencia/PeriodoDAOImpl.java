package br.com.mygridpuc.web.persistencia;

import org.springframework.stereotype.Repository;

import br.com.mygridpuc.web.entidade.Periodo;

/**
 * Classe que define as operacoes da camada de persistencia de Periodo
 * @author Wesley Reis
 *
 */
@Repository
public class PeriodoDAOImpl extends GenericoDAOImpl<Periodo, Integer> implements PeriodoDAO{

}
