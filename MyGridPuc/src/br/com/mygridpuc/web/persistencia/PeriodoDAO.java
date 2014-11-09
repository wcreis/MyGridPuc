package br.com.mygridpuc.web.persistencia;

import java.util.List;

import br.com.mygridpuc.web.entidade.Periodo;
import br.com.mygridpuc.web.util.MyGridPucException;

/**
 * Interface que define as operacoes da camada de persistencia de Periodo
 * @author Wesley Reis
 *
 */
@SuppressWarnings("hiding")
public interface PeriodoDAO <Periodo>{
	/**
	 * Retorna a classe a ser persistida
	 * @return
	 */
	public Class<Periodo> getObjectClass();
	
	/**
	 * Inclui um objeto Periodo na base de dados
	 * @param periodo
	 * @return
	 * @throws MyGridPucException
	 */
	public Periodo incluir(Periodo periodo) throws MyGridPucException;
	
	/**
	 * Altera um objeto Periodo na base de dados
	 * @param periodo
	 * @return
	 * @throws MyGridPucException
	 */
	public Periodo alterar(Periodo periodo) throws MyGridPucException;
	
	/**
	 * Consulta um objeto Periodo da base de dados
	 * @param id
	 * @return
	 * @throws MyGridPucException
	 */
	public Periodo consultar(Integer id) throws MyGridPucException;
	
	/**
	 * Exclui um objeto Periodo  da base de dados
	 * @param id
	 * @throws MyGridPucException
	 */
	public void excluir(Integer id) throws MyGridPucException;
	
	/**
	 * Lista os objetos Periodo da base de dados
	 * @return
	 * @throws MyGridPucException
	 */
	public List<Periodo> listar() throws MyGridPucException;
	
	/**
	 * Lista os objetos Periodo da base de dados
	 * @return
	 * @throws MyGridPucException
	 */
	public List<Periodo> listar(Integer idPeriodo) throws MyGridPucException;


}
