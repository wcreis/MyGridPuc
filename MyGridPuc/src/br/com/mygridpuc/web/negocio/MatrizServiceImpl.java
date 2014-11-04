/**
 * 
 */
package br.com.mygridpuc.web.negocio;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.mygridpuc.web.entidade.Matriz;
import br.com.mygridpuc.web.entidade.Periodo;
import br.com.mygridpuc.web.persistencia.MatrizDAO;
import br.com.mygridpuc.web.persistencia.PeriodoDAO;
import br.com.mygridpuc.web.util.MyGridPucException;

/**
 * Classe que define as operacoes da camada de negocio de matriz
 * @author David Rodrigues / Wesley Reis
 *
 */

@Service
@Transactional
public class MatrizServiceImpl implements MatrizService{
	
	private MatrizDAO matrizDAO;
	
	private PeriodoDAO periodoDAO;



	public MatrizDAO getMatrizDAO() {
		return matrizDAO;
	}

	@Autowired
	public void setMatrizDAO(MatrizDAO matrizDAO) {
		this.matrizDAO = matrizDAO;
	}
	
	public PeriodoDAO getPeriodoDAO() {
		return periodoDAO;
	}

	@Autowired
	public void setPeriodoDAO(PeriodoDAO periodoDAO) {
		this.periodoDAO = periodoDAO;
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
		
		Matriz matrizExistente = this.consultar(matriz.getIdMatriz());
		
		for(Periodo p : matrizExistente.getListaPeriodos()){
			if(!matrizExistente.getListaPeriodos().contains(p)){
				getPeriodoDAO().excluir(p.getIdPeriodo());
			}
		}
		
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
		
		Matriz matrizExistente = this.consultar(id);
		
		for(Periodo p : matrizExistente.getListaPeriodos()){
				getPeriodoDAO().excluir(p.getIdPeriodo());
		}
		
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
		
		Hibernate.initialize(matriz.getListaPeriodos());
		
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
