/**
 * 
 */
package br.com.mygridpuc.web.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.mygridpuc.web.entidade.Local;
import br.com.mygridpuc.web.persistencia.LocalDAO;
import br.com.mygridpuc.web.util.MyGridPucException;

/**
 * Classe que define as operacoes da camada de negocio de local
 * 
 * @author David Rodrigues / Wesley Reis
 *
 */

@Service
@Transactional
public class LocalServiceImpl implements LocalService{
	private LocalDAO localDAO;

	public LocalDAO getLocalDAO() {
		return localDAO;
	}

	@Autowired
	public void setLocalDAO(LocalDAO localDAO) {
		this.localDAO = localDAO;
	}

	/**
	 * Inclui um local
	 * @param local
	 * @return
	 * @throws MyGridPucException
	 */
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public Local incluir(Local local) throws MyGridPucException {
		return localDAO.incluir(local);
	}

	/**
	 * Altera um local
	 * @param local
	 * @return
	 * @throws MyGridPucException
	 */
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public Local alterar(Local local) throws MyGridPucException {
		return getLocalDAO().alterar(local);
	}

	/**
	 * Exclui um local
	 * @param local
	 * @return
	 * @throws MyGridPucException
	 */
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public void excluir(Integer id) throws MyGridPucException {
		getLocalDAO().excluir(id);
		
	}

	/**
	 * Consulta um local
	 * @param local
	 * @return
	 * @throws MyGridPucException
	 */
	@Transactional(readOnly=true, propagation = Propagation.SUPPORTS)
	public Local consultar(Integer id) throws MyGridPucException {
		Local local = getLocalDAO().consultar(id);
		return local;
	}

	
	/**
	 * Consulta os locais pelo Id da Turma
	 * @param Lista de Locais
	 * @return
	 * @throws MyGridPucException
	 */
	@Transactional(readOnly=true, propagation = Propagation.SUPPORTS)
	public List<Local> listar(Integer idTurma) throws MyGridPucException {
		return getLocalDAO().consultarPorIdTurma(idTurma);
	}

	
	/**
	 * Lista um local
	 * @param local
	 * @return
	 * @throws MyGridPucException
	 */
	@Transactional(readOnly=true, propagation = Propagation.SUPPORTS)
	public List<Local> listar() throws MyGridPucException {
		return getLocalDAO().listar();
	}
	
}
