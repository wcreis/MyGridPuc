package br.com.mygridpuc.web.persistencia;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.mygridpuc.web.entidade.Local;
import br.com.mygridpuc.web.util.MyGridPucException;

/**
 * Classe que define as operacoes da camada de persistencia de local
 * 
 * @author David Rodrigues / Wesley Reis
 *
 */
@Repository
public class LocalDAOImpl extends GenericoDAOImpl<Local, Integer> implements LocalDAO{

	@SuppressWarnings("unchecked")
	@Override
	public List<Local> consultarPorIdTurma(Integer idTurma)	throws MyGridPucException {
		List<Local> locais=null;
		try { 
			Query query = getEntityManager().createQuery("select local from Local as local where local.turma.idTurma =:idTurma");
			query.setParameter("idTurma", idTurma);
			
			locais = query.getResultList();

		} catch (Exception e) {
			throw new MyGridPucException(e, "Problemas na localização dos objetos");  
		}
		if(locais.size()>0){
			return locais;
		}return null;
	}

}
