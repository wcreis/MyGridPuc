package br.com.mygridpuc.web.negocio;

import java.util.List;

import br.com.mygridpuc.web.entidade.Periodo;
import br.com.mygridpuc.web.util.MyGridPucException;

/**
 * Interface que define as operacoes da camada de negocio de periodo
 * @author Wesley Reis
 *
 */
public interface PeriodoService {

	/**
	 * Inclui um Periodo
	 * @param periodo
	 * @return
	 * @throws MyGridPucException
	 */
	public Periodo incluir(Periodo periodo) throws MyGridPucException;
	
	/**
	 * Altera um periodo
	 * @param periodo
	 * @return
	 * @throws MyGridPucException
	 */
	public Periodo alterar(Periodo periodo) throws MyGridPucException;
	
	/**
	 * Exclui um periodo
	 * @param id
	 * @throws MyGridPucException
	 */
	public void excluir(Integer id) throws MyGridPucException;
	
	/**
	 * Consulta um periodo pelo identificador
	 * @param id
	 * @return
	 * @throws MyGridPucException
	 */
	public Periodo consultar(Integer id) throws MyGridPucException;
	
	/**
	 * Lista todos os periodo cadastrados
	 * @return
	 * @throws MyGridPucException
	 */
	public List<Periodo> listar() throws MyGridPucException;
	
	/**
	 * Lista todos os periodos cadastrados de uma Matriz
	 * @return
	 * @throws MyGridPucException
	 */
	public List<Periodo> listar(Integer idMatriz) throws MyGridPucException;
}
