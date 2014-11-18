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

import br.com.mygridpuc.web.entidade.Turma;
import br.com.mygridpuc.web.persistencia.TurmaDAO;
import br.com.mygridpuc.web.util.MyGridPucException;

/**
 * Classe que define as operacoes da camada de negocio de turma
 * @author David Rodrigues / Wesley Reis
 *
 */

@Service
@Transactional
public class TurmaServiceImpl implements TurmaService{
	private TurmaDAO turmaDAO;

	public TurmaDAO getTurmaDAO() {
		return turmaDAO;
	}

	@Autowired
	public void setTurmaDAO(TurmaDAO turmaDAO) {
		this.turmaDAO = turmaDAO;
	}

	/**
	 * Inclui um turma
	 * @param turma
	 * @return
	 * @throws MyGridPucException
	 */
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public Turma incluir(Turma turma) throws MyGridPucException {
		return turmaDAO.incluir(turma);
	}

	/**
	 * Altera um turma
	 * @param turma
	 * @return
	 * @throws MyGridPucException
	 */
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public Turma alterar(Turma turma) throws MyGridPucException {
		return getTurmaDAO().alterar(turma);
	}

	/**
	 * Exclui um turma
	 * @param turma
	 * @return
	 * @throws MyGridPucException
	 */
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public void excluir(Integer id) throws MyGridPucException {
		getTurmaDAO().excluir(id);
		
	}

	/**
	 * Consulta um turma
	 * @param turma
	 * @return
	 * @throws MyGridPucException
	 */
	@Transactional(readOnly=true, propagation = Propagation.SUPPORTS)
	public Turma consultar(Integer id) throws MyGridPucException {
		Turma turma = getTurmaDAO().consultar(id);
		Hibernate.initialize(turma.getListLocais());
		return turma;
	}

	
	/**
	 * Consulta a Turma pelo Id da Disciplina
	 * @param Turma
	 * @return
	 * @throws MyGridPucException
	 */
	@Transactional(readOnly=true, propagation = Propagation.SUPPORTS)
	public Turma consultarPorIdDisciplinaETurma(Integer idDisciplina, String codTurma) throws MyGridPucException {
		Turma turma = getTurmaDAO().consultarPorIdDisciplina(idDisciplina, codTurma);
		Hibernate.initialize(turma.getListLocais());
		return turma;
	}

	
	/**
	 * Lista um turma
	 * @param turma
	 * @return
	 * @throws MyGridPucException
	 */
	@Transactional(readOnly=true, propagation = Propagation.SUPPORTS)
	public List<Turma> listar() throws MyGridPucException {
		return getTurmaDAO().listar();
	}
	
}
