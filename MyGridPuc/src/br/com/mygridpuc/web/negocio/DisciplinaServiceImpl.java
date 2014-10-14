package br.com.mygridpuc.web.negocio;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.mygridpuc.web.entidade.Disciplina;
import br.com.mygridpuc.web.persistencia.DisciplinaDao;
import br.com.mygridpuc.web.util.MyGridPucException;

@Service
@Transactional
public class DisciplinaServiceImpl implements DisciplinaService {

	private DisciplinaDao disciplinaDao;
	
	/**
	 * Inclui uma disciplina no BD.
	 * @param Objeto com os dados da disciplina.
	 * @return
	 * @throws MyGridPucException
	 */
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public Disciplina incluir(Disciplina disciplina) throws MyGridPucException {
		return disciplinaDao.incluir(disciplina);
	}

	@Override
	public Disciplina alterar(Disciplina disciplina) throws MyGridPucException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void excluir(Integer id) throws MyGridPucException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Disciplina consultar(Integer id) throws MyGridPucException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Disciplina> listar() throws MyGridPucException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
