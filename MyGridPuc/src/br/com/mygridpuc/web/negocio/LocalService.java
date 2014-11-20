package br.com.mygridpuc.web.negocio;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.mygridpuc.web.entidade.Local;
import br.com.mygridpuc.web.util.MyGridPucException;

/**
 * Interface que define as operacoes da camada de negocio de local
 * 
 * @author David Rodrigues
 *
 */
public interface LocalService {

	/**
	 * Inclui um local
	 * @param local
	 * @return
	 * @throws MyGridPucException
	 */
	public Local incluir(Local local) throws MyGridPucException;
	
	/**
	 * Altera um local
	 * @param local
	 * @return
	 * @throws MyGridPucException
	 */
	public Local alterar(Local local) throws MyGridPucException;
	
	/**
	 * Exclui um local
	 * @param id
	 * @throws MyGridPucException
	 */
	public void excluir(Integer id) throws MyGridPucException;
	
	/**
	 * Consulta um local pelo identificador
	 * @param id
	 * @return
	 * @throws MyGridPucException
	 */
	public Local consultar(Integer id) throws MyGridPucException;
	
	
	/**
	 * Consulta os locais pelo Id da Turma
	 * @param Lista de Locais
	 * @return
	 * @throws MyGridPucException
	 */
	@Transactional(readOnly=true, propagation = Propagation.SUPPORTS)
	public List<Local> listar(Integer idTurma) throws MyGridPucException;

	/**
	 * Lista todas os local cadastradas
	 * @return
	 * @throws MyGridPucException
	 */
	public List<Local> listar() throws MyGridPucException;
}
