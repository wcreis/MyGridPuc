package br.com.mygridpuc.web.persistencia;

import java.util.List;

import br.com.mygridpuc.web.entidade.Local;
import br.com.mygridpuc.web.util.MyGridPucException;

/**
 * Interface que define as operacoes da camada de persistencia de local
 * @author David Rodrigues
 *
 */
public interface LocalDAO extends GenericoDAO<Local, Integer>{
	
	public List<Local> consultarPorIdTurma(Integer idTurma) throws MyGridPucException;

}
