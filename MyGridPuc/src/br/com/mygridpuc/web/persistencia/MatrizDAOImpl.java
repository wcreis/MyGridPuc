package br.com.mygridpuc.web.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.mygridpuc.web.entidade.Matriz;
import br.com.mygridpuc.web.util.MyGridPucException;

/**
 * Classe que define as operacoes da camada de persistencia de Matriz
 * @author David Rodrigues
 *
 */
@Repository
public class MatrizDAOImpl implements MatrizDAO<Matriz>{

	private EntityManager entityManager;
	private Class<Matriz> matrizClass;
	
	@Override
	public Class<Matriz> getObjectClass() {
		return this.matrizClass;
	}

	@Override
	public Matriz incluir(Matriz object) throws MyGridPucException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Matriz alterar(Matriz object) throws MyGridPucException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Matriz consultar(Integer id) throws MyGridPucException {
		Matriz object = null;
		try{
			object = getEntityManager().find(getObjectClass(), id);
		}
		catch (EntityNotFoundException e) {
			throw new MyGridPucException(e,"Registro não encontrado.");
		}
		catch (Exception e) {
			throw new MyGridPucException(e,"Não foi possível realizar a consulta.");
		}
		return object;
	}

	@Override
	public void excluir(Integer id) throws MyGridPucException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Matriz> listar() throws MyGridPucException {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Matriz> listar(Integer idCurso) throws MyGridPucException {
		List<Matriz> lista = null;  
        try {  
            Query query = getEntityManager().createQuery("select matriz from Matriz as matriz where matriz.curso.idCurso ="+idCurso+"");  
            lista = query.getResultList();  
        } catch (Exception e) {  
            throw new MyGridPucException(e, "Problemas na localização dos objetos");  
        }  
        return lista; 
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
