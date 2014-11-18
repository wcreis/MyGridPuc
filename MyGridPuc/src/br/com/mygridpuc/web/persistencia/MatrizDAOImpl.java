package br.com.mygridpuc.web.persistencia;

import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import br.com.mygridpuc.web.entidade.Matriz;
import br.com.mygridpuc.web.util.MyGridPucException;

/**
 * Classe que define as operacoes da camada de persistencia de Matriz
 * 
 * @author David Rodrigues
 *
 */
@Repository
public class MatrizDAOImpl extends GenericoDAOImpl<Matriz, Integer>implements MatrizDAO{

	@SuppressWarnings("unchecked")
	@Override
	public List<Matriz> listar(Integer idCurso) throws MyGridPucException {
		List<Matriz> lista = null;  
		try {  
			Query query = getEntityManager().createQuery("select matriz from Matriz as matriz where matriz.curso.idCurso =:idCurso"); 
			query.setParameter("idCurso", idCurso);

			lista = query.getResultList();  
		} catch (Exception e) {  
			throw new MyGridPucException(e, "Problemas na localização dos objetos");  
		}  
		return lista; 
	}

	@SuppressWarnings("unchecked")
	@Override
	public Matriz listar(Integer idCurso, String anoSemestre) throws MyGridPucException{
		List<Matriz> lista = null;  
		try {  
			Query query = getEntityManager().createQuery("select matriz from Matriz as matriz where matriz.curso.idCurso =:idCurso and matriz.anoSemestreMatriz =:anoSemestre "); 
			query.setParameter("idCurso", idCurso);
			query.setParameter("anoSemestre", anoSemestre);

			lista = query.getResultList(); 
		} catch (Exception e) {  
			throw new MyGridPucException(e, "Problemas na localização dos objetos");  
		}
		if(lista.size()>0){
			return lista.get(0);	
		}return null;
		 
	}
}
