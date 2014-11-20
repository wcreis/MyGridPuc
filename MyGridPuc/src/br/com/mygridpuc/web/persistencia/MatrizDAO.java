package br.com.mygridpuc.web.persistencia;

import java.util.List;

import br.com.mygridpuc.web.entidade.Matriz;
import br.com.mygridpuc.web.util.MyGridPucException;

/**
 * Interface que define as operacoes da camada de persistencia de Matriz
 * 
 * @author David Rodrigues
 *
 */
public interface MatrizDAO extends GenericoDAO<Matriz, Integer>{

	/**
	 * Lista os objetos Matriz da base de dados
	 * @return
	 * @throws MyGridPucException
	 */
	public List<Matriz> listar(Integer idCurso) throws MyGridPucException;
	
	/**
	 * Lista os objetos Matriz da base de dados
	 * @return
	 * @throws MyGridPucException
	 */
	public Matriz listar(Integer idCurso, String anoSemestre) throws MyGridPucException;

}
