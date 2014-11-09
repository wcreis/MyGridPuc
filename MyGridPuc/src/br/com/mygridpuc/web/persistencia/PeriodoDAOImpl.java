package br.com.mygridpuc.web.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.mygridpuc.web.entidade.Periodo;
import br.com.mygridpuc.web.util.MyGridPucException;

/**
 * Classe que define as operacoes da camada de persistencia de Periodo
 * @author Wesley Reis
 *
 */
@Repository
public class PeriodoDAOImpl implements PeriodoDAO<Periodo>{
	private EntityManager entityManager;
	private Class<Periodo> periodo;
	
	@Override
	public Class<Periodo> getObjectClass() {
		return this.periodo;
	}

	@Override
	public Periodo incluir(Periodo periodo) throws MyGridPucException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Periodo alterar(Periodo periodo) throws MyGridPucException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Periodo consultar(Integer id) throws MyGridPucException {
		Periodo periodo = null;
		try{
			periodo = getEntityManager().find(getObjectClass(), id);
		}
		catch (EntityNotFoundException e) {
			throw new MyGridPucException(e,"Registro não encontrado.");
		}
		catch (Exception e) {
			throw new MyGridPucException(e,"Não foi possível realizar a consulta.");
		}
		return periodo;
	}

	@Override
	public void excluir(Integer id) throws MyGridPucException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Periodo> listar() throws MyGridPucException {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Periodo> listar(Integer idMatriz) throws MyGridPucException {
		List<Periodo> lista = null;  
        try {  
            Query query = getEntityManager().createQuery("select periodo from Periodo as periodo where periodo.matriz.idMatriz ="+idMatriz+"");  
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
