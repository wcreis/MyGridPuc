package br.com.mygridpuc.web.negocio;

import java.util.List;

import br.com.mygridpuc.web.entidade.Disciplina;
import br.com.mygridpuc.web.util.MyGridPucException;

public interface DisciplinaService {

	/**
	 * Inclui um curso
	 * @param pessoa
	 * @return
	 * @throws MyGridPucException
	 */
	public Disciplina incluir(Disciplina curso) throws MyGridPucException;
	
	/**
	 * Altera um curso
	 * @param pessoa
	 * @return
	 * @throws MyGridPucException
	 */
	public Disciplina alterar(Disciplina curso) throws MyGridPucException;
	
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
	public Disciplina consultar(Integer id) throws MyGridPucException;
	
	/**
	 * Lista todas os cursos cadastradas
	 * @return
	 * @throws MyGridPucException
	 */
	public List<Disciplina> listar() throws MyGridPucException;
	
}
