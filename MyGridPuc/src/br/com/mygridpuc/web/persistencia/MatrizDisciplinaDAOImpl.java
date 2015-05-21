package br.com.mygridpuc.web.persistencia;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.mygridpuc.web.entidade.MatrizDisciplina;
import br.com.mygridpuc.web.util.MyGridPucException;

/**
 * Classe que define as operacoes da camada de persistencia de MatrizDisciplina
 * 
 * @author Wesley Reis
 *
 */
@Repository
public class MatrizDisciplinaDAOImpl implements MatrizDisciplinaDAO<MatrizDisciplina>{
	
	private EntityManager entityManager;
	private Class<MatrizDisciplina> matrizDisciplina;

	@Override
	public Class<MatrizDisciplina> getObjectClass() {
		return this.matrizDisciplina;
	}

	@Override
	public MatrizDisciplina incluir(MatrizDisciplina matrizDisciplina) throws MyGridPucException {
		return getEntityManager().merge(matrizDisciplina);
	}

	@Override
	public MatrizDisciplina alterar(MatrizDisciplina matrizDisciplina) throws MyGridPucException {
		return null;
	}

	@Override
	public MatrizDisciplina consultar(Integer id) throws MyGridPucException {
		MatrizDisciplina matrizDisciplina = null;
		try{
			matrizDisciplina = getEntityManager().find(getObjectClass(), id);
		}
		catch (EntityNotFoundException e) {
			throw new MyGridPucException(e,"Registro n�o encontrado.");
		}
		catch (Exception e) {
			throw new MyGridPucException(e,"N�o foi poss�vel realizar a consulta.");
		}
		return matrizDisciplina;
	}

	@Override
	public void excluir(Integer id) throws MyGridPucException {

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MatrizDisciplina> listar() throws MyGridPucException {
		List<MatrizDisciplina> lista = new ArrayList<MatrizDisciplina>();
		
		try {  
			Query query = getEntityManager().createQuery("select matrizDisciplina from MatrizDisciplina as matrizDisciplina ");  
			lista = query.getResultList();  
		} catch (Exception e) {  
			throw new MyGridPucException(e, "Problemas na localiza��o dos objetos");  
		}  
		
		return lista;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MatrizDisciplina> listarPorMatriz(Integer idMatriz) throws MyGridPucException {
		List<MatrizDisciplina> lista = new ArrayList<MatrizDisciplina>();
		try {  
			Query query = getEntityManager().createQuery("select matrizDisciplina from MatrizDisciplina as matrizDisciplina where matrizDisciplina.matriz.idMatriz =:idMatriz ");  
			query.setParameter("idMatriz", idMatriz);
			
			lista = query.getResultList();  
		} catch (Exception e) {  
			throw new MyGridPucException(e, "Problemas na localiza��o dos objetos");  
		}  
		return lista; 
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MatrizDisciplina> listarPorDisciplina(Integer idDisciplina) throws MyGridPucException{
		List<MatrizDisciplina> lista = new ArrayList<MatrizDisciplina>();
		try {  
			Query query = getEntityManager().createQuery("select matrizDisciplina from MatrizDisciplina as matrizDisciplina where matrizDisciplina.disciplina.idDisciplina =:idDisciplina ");  
			query.setParameter("idDisciplina", idDisciplina);
			
			lista = query.getResultList();  
		} catch (Exception e) {  
			throw new MyGridPucException(e, "Problemas na localiza��o dos objetos");  
		}  
		return lista; 
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MatrizDisciplina> listarPorMatrizPeriodo(Integer idMatriz, Integer periodo) throws MyGridPucException {
		List<MatrizDisciplina> lista = new ArrayList<MatrizDisciplina>();
		try {  
			Query query = getEntityManager().createQuery("select matrizDisciplina from MatrizDisciplina as matrizDisciplina where matrizDisciplina.matriz.idMatriz  =:idMatriz and matrizDisciplina.periodo =:periodo ");  
			query.setParameter("idMatriz", idMatriz);
			query.setParameter("periodo", periodo);
			
			lista = query.getResultList();  
		} catch (Exception e) {  
			throw new MyGridPucException(e, "Problemas na localiza��o dos objetos");  
		}  
		if(lista.size()>0){
			return lista;	
		}return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MatrizDisciplina> listarPorIdMatrizIdDisciplina(Integer idMatriz, Integer idDisciplina) throws MyGridPucException {
		List<MatrizDisciplina> lista = new ArrayList<MatrizDisciplina>();
		try {  
			Query query = getEntityManager().createQuery("select matrizDisciplina from MatrizDisciplina as matrizDisciplina where matrizDisciplina.matriz.idMatriz =:idMatriz and matrizDisciplina.disciplina.idDisciplina =:idDisciplina ");  
			query.setParameter("idMatriz", idMatriz);
			query.setParameter("idDisciplina", idDisciplina);
			
			lista = query.getResultList();  
		} catch (Exception e) {  
			throw new MyGridPucException(e, "Problemas na localiza��o dos objetos");  
		}  
		if(lista.size()>0){
			return lista;	
		}return null;
	}
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}
