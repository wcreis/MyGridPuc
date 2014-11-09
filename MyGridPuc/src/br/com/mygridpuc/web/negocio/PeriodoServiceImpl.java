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

import br.com.mygridpuc.web.entidade.Disciplina;
import br.com.mygridpuc.web.entidade.Periodo;
import br.com.mygridpuc.web.persistencia.DisciplinaDao;
import br.com.mygridpuc.web.persistencia.PeriodoDAO;
import br.com.mygridpuc.web.util.MyGridPucException;

/**
 * Classe que define as operacoes da camada de negocio de periodo
 * @author David Rodrigues / Wesley Reis
 *
 */

@Service
@Transactional
public class PeriodoServiceImpl implements PeriodoService{
	


	private PeriodoDAO<Periodo> periodoDAO;
	
	private DisciplinaDao disciplinaDAO;

	public PeriodoDAO<Periodo> getPeriodoDAO() {
		return periodoDAO;
	}
	@Autowired
	public void setPeriodoDAO(PeriodoDAO<Periodo> periodoDAO) {
		this.periodoDAO = periodoDAO;
	}
	
	public DisciplinaDao getDisciplinaDAO() {
		return disciplinaDAO;
	}

	@Autowired
	public void setDisciplinaDAO(DisciplinaDao disciplinaDAO) {
		this.disciplinaDAO = disciplinaDAO;
	}

	/**
	 * Inclui um periodo
	 * @param periodo
	 * @return
	 * @throws MyGridPucException
	 */
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public Periodo incluir(Periodo periodo) throws MyGridPucException {
		return periodoDAO.incluir(periodo);
	}

	/**
	 * Altera um periodo
	 * @param periodo
	 * @return
	 * @throws MyGridPucException
	 */
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public Periodo alterar(Periodo periodo) throws MyGridPucException {
		
		Periodo periodoExistente = this.consultar(periodo.getIdPeriodo());
		
		for(Disciplina d : periodoExistente.getListaDiscilinas()){
			if(!periodoExistente.getListaDiscilinas().contains(d)){
				getDisciplinaDAO().excluir(d.getIdDisciplina());
			}
		}
		
		return getPeriodoDAO().alterar(periodo);
	}

	/**
	 * Exclui um periodo
	 * @param periodo
	 * @return
	 * @throws MyGridPucException
	 */
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public void excluir(Integer id) throws MyGridPucException {
		
		Periodo periodoExistente = this.consultar(id);
		
		for(Disciplina d : periodoExistente.getListaDiscilinas()){
				getDisciplinaDAO().excluir(d.getIdDisciplina());
		}
		
		getPeriodoDAO().excluir(id);
		
	}

	/**
	 * Consulta um periodo
	 * @param periodo
	 * @return
	 * @throws MyGridPucException
	 */
	@Transactional(readOnly=true, propagation = Propagation.SUPPORTS)
	public Periodo consultar(Integer id) throws MyGridPucException {
		Periodo periodo = getPeriodoDAO().consultar(id);
		
		Hibernate.initialize(periodo.getListaDiscilinas());
		
		return periodo;
	}

	/**
	 * Lista um periodo
	 * @param periodo
	 * @return
	 * @throws MyGridPucException
	 */
	@Transactional(readOnly=true, propagation = Propagation.SUPPORTS)
	public List<Periodo> listar() throws MyGridPucException {
		return getPeriodoDAO().listar();
	}

	@Override
	public List<Periodo> listar(Integer idMatriz) throws MyGridPucException {
		return null;
	}
	
}
