package br.com.mygridpuc.web.persistencia;

import br.com.mygridpuc.web.entidade.Curso;
import br.com.mygridpuc.web.util.MyGridPucException;

/**
 * Interface que define as operacoes da camada de persistencia de Curso
 * 
 * @author David Rodrigues
 *
 */
public interface CursoDAO extends GenericoDAO<Curso, Integer>{

	public Curso consultarPorCodCurso(String codCurso)throws MyGridPucException;
}
