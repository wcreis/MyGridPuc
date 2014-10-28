/**
 * 
 */
package br.com.mygridpuc.web.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.mygridpuc.web.entidade.Matriz;
import br.com.mygridpuc.web.persistencia.MatrizDAO;
import br.com.mygridpuc.web.util.MyGridPucException;

/**
 * Classe que define as operacoes da camada de negocio de matriz
 * @author David Rodrigues
 *
 */

@Service
@Transactional
public class MatrizServiceImpl implements MatrizService{
	private MatrizDAO matrizDAO;

	public MatrizDAO getMatrizDAO() {
		return matrizDAO;
	}

	@Autowired
	public void setMatrizDAO(MatrizDAO matrizDAO) {
		this.matrizDAO = matrizDAO;
	}

	/**
	 * Inclui um matriz
	 * @param matriz
	 * @return
	 * @throws MyGridPucException
	 */
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public Matriz incluir(Matriz matriz) throws MyGridPucException {
		return matrizDAO.incluir(matriz);
	}

	/**
	 * Altera um matriz
	 * @param matriz
	 * @return
	 * @throws MyGridPucException
	 */
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public Matriz alterar(Matriz matriz) throws MyGridPucException {
		return getMatrizDAO().alterar(matriz);
	}

	/**
	 * Exclui um matriz
	 * @param matriz
	 * @return
	 * @throws MyGridPucException
	 */
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public void excluir(Integer id) throws MyGridPucException {
		getMatrizDAO().excluir(id);
		
	}

	/**
	 * Consulta um matriz
	 * @param matriz
	 * @return
	 * @throws MyGridPucException
	 */
	@Transactional(readOnly=true, propagation = Propagation.SUPPORTS)
	public Matriz consultar(Integer id) throws MyGridPucException {
		Matriz matriz = getMatrizDAO().consultar(id);
		return matriz;
	}

	/**
	 * Lista um matriz
	 * @param matriz
	 * @return
	 * @throws MyGridPucException
	 */
	@Transactional(readOnly=true, propagation = Propagation.SUPPORTS)
	public List<Matriz> listar() throws MyGridPucException {
		return getMatrizDAO().listar();
	}
	
}
