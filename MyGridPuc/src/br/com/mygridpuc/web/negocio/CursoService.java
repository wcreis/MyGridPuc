package br.com.mygridpuc.web.negocio;

import java.util.List;

import br.com.mygridpuc.web.entidade.Curso;
import br.com.mygridpuc.web.util.MyGridPucException;

/**
 * Interface que define as operacoes da camada de negocio de curso
 * @author David Rodrigues
 *
 */
public interface CursoService {

	/**
	 * Inclui um curso
	 * @param pessoa
	 * @return
	 * @throws MyGridPucException
	 */
	public Curso incluir(Curso curso) throws MyGridPucException;
	
	/**
	 * Altera um curso
	 * @param pessoa
	 * @return
	 * @throws MyGridPucException
	 */
	public Curso alterar(Curso curso) throws MyGridPucException;
	
	/**
	 * Exclui um curso
	 * @param id
	 * @throws MyGridPucException
	 */
	public void excluir(Integer id) throws MyGridPucException;
	
	/**
	 * Consulta um curso pelo identificador
	 * @param id
	 * @return
	 * @throws MyGridPucException
	 */
	public Curso consultar(Integer id) throws MyGridPucException;
	
	/**
	 * Consulta um curso pelo Codigo do Curso
	 * @param codCurso
	 * @return
	 * @throws MyGridPucException
	 */
	public Curso consultar(String codCurso) throws MyGridPucException;
	
	/**
	 * Lista todas os cursos cadastradas
	 * @return
	 * @throws MyGridPucException
	 */
	public List<Curso> listar() throws MyGridPucException;
}
