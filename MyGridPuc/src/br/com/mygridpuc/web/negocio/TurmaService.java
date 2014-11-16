package br.com.mygridpuc.web.negocio;

import java.util.List;

import br.com.mygridpuc.web.entidade.Turma;
import br.com.mygridpuc.web.util.MyGridPucException;

/**
 * Interface que define as operacoes da camada de negocio de turma
 * @author Wesley Reis
 *
 */
public interface TurmaService {

	/**
	 * Inclui uma turma
	 * @param turma
	 * @return
	 * @throws MyGridPucException
	 */
	public Turma incluir(Turma turma) throws MyGridPucException;
	
	/**
	 * Altera uma turma
	 * @param turma
	 * @return
	 * @throws MyGridPucException
	 */
	public Turma alterar(Turma turma) throws MyGridPucException;
	
	/**
	 * Exclui uma turma
	 * @param id
	 * @throws MyGridPucException
	 */
	public void excluir(Integer id) throws MyGridPucException;
	
	/**
	 * Consulta uma turma pelo identificador
	 * @param id
	 * @return
	 * @throws MyGridPucException
	 */
	public Turma consultar(Integer id) throws MyGridPucException;
	
	
	/**
	 * Consulta as turmas pelo Id da Disciplina
	 * @param Lista de Turmas
	 * @return
	 * @throws MyGridPucException
	 */
	public Turma consultarPorIdDisciplinaETurma(Integer idDisciplina, String turma) throws MyGridPucException;

	/**
	 * Lista todas os turma cadastradas
	 * @return
	 * @throws MyGridPucException
	 */
	public List<Turma> listar() throws MyGridPucException;
}
