package br.com.mygridpuc.web.negocio;

import java.util.List;

import br.com.mygridpuc.web.entidade.Disciplina;
import br.com.mygridpuc.web.util.MyGridPucException;

public interface DisciplinaService {

	/**
	 * Inclui uma disciplina
	 * @param 
	 * @return
	 * @throws MyGridPucException
	 */
	public Disciplina incluir(Disciplina disciplina) throws MyGridPucException;
	
	/**
	 * Altera uma disciplina
	 * @param pessoa
	 * @return
	 * @throws MyGridPucException
	 */
	public Disciplina alterar(Disciplina disciplina) throws MyGridPucException;
	
	/**
	 * Exclui uma disciplina
	 * @param id
	 * @throws MyGridPucException
	 */
	public void excluir(Integer id) throws MyGridPucException;
	
	/**
	 * Consulta uma disciplina pelo identificador
	 * @param id
	 * @return
	 * @throws MyGridPucException
	 */
	public Disciplina consultar(Integer id) throws MyGridPucException;
	
	/**
	 * Consulta uma disciplina pelo Codigo da Mesma
	 * @param codDisc
	 * @return
	 * @throws MyGridPucException
	 */
	public Disciplina consultar(String codDisc) throws MyGridPucException;
	
	/**
	 * Lista todas as disciplina cadastradas
	 * @return
	 * @throws MyGridPucException
	 */
	public List<Disciplina> listar() throws MyGridPucException;
	
}
