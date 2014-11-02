package br.com.mygridpuc.web.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.mygridpuc.web.entidade.Usuario;
import br.com.mygridpuc.web.persistencia.UsuarioDAO;
import br.com.mygridpuc.web.util.MyGridPucException;

/**
 * Classe que define as operacoes da camada de negocio de Usuario
 * @author Wesley Reis
 *
 */
@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {
	
	private UsuarioDAO usuarioDAO;
	
	/**
	 * @return the usuarioDAO
	 */
	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	/**
	 * @param usuarioDAO the usuarioDAO to set
	 */
	@Autowired
	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
	
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public Usuario incluir(Usuario usuario) throws MyGridPucException {
		return usuarioDAO.incluir(usuario);
	}
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public Usuario alterar(Usuario usuario) throws MyGridPucException {
		return  getUsuarioDAO().alterar(usuario);
	}
	
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public void excluir(Integer id) throws MyGridPucException {
		getUsuarioDAO().excluir(id);
	}
	
	@Transactional(readOnly=true, propagation = Propagation.SUPPORTS)
	@Override
	public Usuario consultar(Integer id) throws MyGridPucException {
		Usuario usuario = getUsuarioDAO().consultar(id);
		return usuario;
	}
	
	@Transactional(readOnly=true, propagation = Propagation.SUPPORTS)
	@Override
	public List<Usuario> listar() throws MyGridPucException {
		return getUsuarioDAO().listar();
	}

}
