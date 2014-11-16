package br.com.mygridpuc.web.persistencia;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.mygridpuc.web.entidade.Curso;
import br.com.mygridpuc.web.util.MyGridPucException;

/**
 * Classe que define as operacoes da camada de persistencia de Curso
 * @author David Rodrigues
 *
 */
@Repository
public class CursoDAOImpl extends GenericoDAOImpl<Curso, Integer> implements CursoDAO{

	@SuppressWarnings("unchecked")
	@Override
	public Curso consultarPorCodCurso(String codCurso)	throws MyGridPucException {

		List<Curso> cursos=null;
		try { 
			Query query = getEntityManager().createQuery("select curso from Curso as curso where curso.codigoCurso =:codCurso");
			query.setParameter("codCurso", codCurso);
			query.setMaxResults(1);
			cursos = query.getResultList();

		} catch (Exception e) {
			throw new MyGridPucException(e, "Problemas na localização dos objetos");  
		}
		if(cursos.size()>0){
			return cursos.get(0);
		}return null;
	}

}
