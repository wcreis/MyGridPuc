package br.com.mygridpuc.web.persistencia;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.mygridpuc.web.entidade.Usuario;
import br.com.mygridpuc.web.util.MyGridPucException;

/**
 * Classe que define as operacoes da camada de persistencia
 * 
 * @author David Rodrigues
 *
 */
@Repository
public class UsuarioDAOImpl extends GenericoDAOImpl<Usuario, Integer> implements UsuarioDAO {
	
	@SuppressWarnings("unchecked")
	public Usuario consultarPorLogin(String login) throws MyGridPucException {
		List<Usuario> usuario=null;
		try { 
			Query query = getEntityManager().createQuery("select usuario from Usuario as usuario where usuario.emailUsuario =:login");
			query.setParameter("login", login);
			query.setMaxResults(1);
			usuario = query.getResultList();

		} catch (Exception e) {
			throw new MyGridPucException(e, "Problemas na localização dos objetos");  
		}
		if(usuario.size()>0){
			return usuario.get(0);
		}return null;

	}
																					   
}
