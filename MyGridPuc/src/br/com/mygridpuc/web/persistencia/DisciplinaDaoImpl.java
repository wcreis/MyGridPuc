package br.com.mygridpuc.web.persistencia;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.mygridpuc.web.entidade.Disciplina;
import br.com.mygridpuc.web.util.MyGridPucException;

@Repository
public class DisciplinaDaoImpl extends GenericoDAOImpl<Disciplina, Integer> implements DisciplinaDao {

	
	@SuppressWarnings("unchecked")
	@Override
	public Disciplina consultarPorCodigo(String codDisc) throws MyGridPucException {
		List<Disciplina> disciplina=null;
		try { 
			Query query = getEntityManager().createQuery("select disciplina from Disciplina as disciplina where disciplina.codigo =:codDisciplina");
			query.setParameter("codDisciplina", codDisc);
			query.setMaxResults(1);
			disciplina = query.getResultList();

		} catch (Exception e) {
			throw new MyGridPucException(e, "Problemas na localização dos objetos");  
		}
		if(disciplina.size()>0){

			return disciplina.get(0);
		}return null;
	}

}
