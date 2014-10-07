/**
 * 
 */
package br.com.mygridpuc.web.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.mygridpuc.web.entidade.Curso;
import br.com.mygridpuc.web.persistencia.CursoDAO;
import br.com.mygridpuc.web.util.MyGridPucException;

/**
 * Classe que define as operacoes da camada de negocio de curso
 * @author David Rodrigues
 *
 */

@Service
@Transactional
public class CursoServiceImpl implements CursoService{
	private CursoDAO cursoDAO;

	public CursoDAO getCursoDAO() {
		return cursoDAO;
	}

	@Autowired
	public void setCursoDAO(CursoDAO cursoDAO) {
		this.cursoDAO = cursoDAO;
	}

	/**
	 * Inclui um curso
	 * @param curso
	 * @return
	 * @throws MyGridPucException
	 */
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public Curso incluir(Curso curso) throws MyGridPucException {
		return cursoDAO.incluir(curso);
	}

	/**
	 * Altera um curso
	 * @param curso
	 * @return
	 * @throws MyGridPucException
	 */
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public Curso alterar(Curso curso) throws MyGridPucException {
		return getCursoDAO().alterar(curso);
	}

	/**
	 * Exclui um curso
	 * @param curso
	 * @return
	 * @throws MyGridPucException
	 */
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public void excluir(Integer id) throws MyGridPucException {
		getCursoDAO().excluir(id);
		
	}

	/**
	 * Consulta um curso
	 * @param curso
	 * @return
	 * @throws MyGridPucException
	 */
	@Transactional(readOnly=true, propagation = Propagation.SUPPORTS)
	public Curso consultar(Integer id) throws MyGridPucException {
		Curso curso = getCursoDAO().consultar(id);
		return curso;
	}

	/**
	 * Lista um curso
	 * @param curso
	 * @return
	 * @throws MyGridPucException
	 */
	@Transactional(readOnly=true, propagation = Propagation.SUPPORTS)
	public List<Curso> listar() throws MyGridPucException {
		return getCursoDAO().listar();
	}
	
}
