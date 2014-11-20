package br.com.mygridpuc.web.persistencia;

import br.com.mygridpuc.web.entidade.Disciplina;
import br.com.mygridpuc.web.util.MyGridPucException;

/**
 * Interface que define as operacoes da camada de persistencia
 * 
 * @author David Rodrigues
 *
 */
public interface DisciplinaDao extends GenericoDAO<Disciplina, Integer> {

	public Disciplina consultarPorCodigo(String codDisc) throws MyGridPucException;

}
