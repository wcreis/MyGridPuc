package br.com.mygridpuc.web.controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.mygridpuc.web.entidade.Usuario;
import br.com.mygridpuc.web.negocio.UsuarioService;
import br.com.mygridpuc.web.util.MyGridPucException;

/**
 * Representa o controlador da view de cadastro de Usuarios.
 * 
 * @author Wesley Reis
 *
 */
@ManagedBean(name="usuarioController")
@RequestScoped
@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioBean usuarioBean;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private List<UsuarioBean> listaUsuarioBean;

	/**
	 * Inclui a usuario no banco de dados.
	 * @return
	 */
	public String incluir(){
		try{
			
			Usuario usuario = new Usuario();
			
			usuario.setEmailUsuario(this.usuarioBean.getEmailUsuario().toLowerCase());
			usuario.setTipoUsuario("ROLE_ADMINISTRADOR");
			usuario.setSenhaUsuario(this.usuarioBean.getSenhaUsuario());
			
			getUsuarioService().incluir(usuario);
			
			String msg = "Usuario Incluso com Sucesso!!!";
			FacesMessage message = new FacesMessage(msg);
			getFacesContext().addMessage("formularioUsuario", message);
			
			return limparFormulario();
		}catch(Exception ex){
			String msg = "Inclusao nao realizada. Motivo: " + ((ex instanceof MyGridPucException ? ((MyGridPucException)ex).getEx().getMessage():""));
			FacesMessage message = new FacesMessage(msg);
			getFacesContext().addMessage("formularioUsuario", message);
			return null;
		}
	}
	
	/**
	 * Lista as diciplinas cadastradas
	 * @return
	 */
	public String listar(){
		this.usuarioBean = new UsuarioBean();
		try{
			List<Usuario> listUsuario = new ArrayList<>();
			listUsuario = getUsuarioService().listar();
			if(listUsuario == null || listUsuario.size() == 0){
				FacesMessage facesMessage = new FacesMessage("Nenhum registro encontrado");
				System.out.println(getFacesContext());
				getFacesContext().addMessage("formularioUsuario", facesMessage);
				return "listar usuarios";
			}
			
			//preenche a lista de Usuarios na tela
			listaUsuarioBean = new ArrayList<UsuarioBean>();
			
			for(Usuario usuario: listUsuario){
				UsuarioBean usuarioBean = new UsuarioBean();
				
				usuarioBean.setIdUsuario(usuario.getIdUsuario());
				usuarioBean.setEmailUsuario(usuario.getEmailUsuario().toLowerCase());
				usuarioBean.setSenhaUsuario(usuario.getSenhaUsuario());
				usuarioBean.setTipoUsuario("177.235.16.243");
				
				listaUsuarioBean.add(usuarioBean);
			}
			return "listar usuario";
		}catch(Exception e){
			String msg = "Não Foi possivel listar os Usuarios. Motivo: " + ((e instanceof MyGridPucException ? ((MyGridPucException)e).getEx().getMessage():""));
			FacesMessage message = new FacesMessage(msg);
			getFacesContext().addMessage("formularioUsuario", message);
			return null;
		}
	}
	
	
	/**
	 * Consulta uma usuario de acordo com o ID da usuario que estÃ¡ sendo alterado.
	 * @return
	 */
	public String consultar(){
		
		try{
			
			String idUsuario = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("formularioUsuario:idUsuario");
			System.out.println(idUsuario);
			Usuario usuario = getUsuarioService().consultar(Integer.parseInt(idUsuario));
			
			if(usuario == null || usuario.getIdUsuario() == 0){
				FacesMessage facesMessage = new FacesMessage("Nenhum registro encontrado");
				getFacesContext().addMessage("formularioUsuario", facesMessage);
				return null;
			}
			
			usuarioBean.setIdUsuario(usuario.getIdUsuario());
			usuarioBean.setEmailUsuario(usuario.getEmailUsuario().toLowerCase());
			usuarioBean.setSenhaUsuario(usuario.getSenhaUsuario());
			usuarioBean.setTipoUsuario("ROLE_ADMINISTRADOR");
			
			return "editar usuario";
		}catch(Exception e){
			String msg = "Consulta não realizada. Motivo: " + ((e instanceof MyGridPucException ? ((MyGridPucException)e).getEx().getMessage():""));
			FacesMessage message = new FacesMessage(msg);
			getFacesContext().addMessage("formularioUsuario", message);
			return null;
		}
	}
	
	
	
	/**
	 * Cria um novo objeto Usuario e redireciona para a tela de criar usuario.
	 * @return
	 */
	public String criar(){
		try{
			usuarioBean = new UsuarioBean();
			return "criar usuario";
		}catch(Exception e){
			String msg = "Criação não realizada. Motivo: " + ((e instanceof MyGridPucException ? ((MyGridPucException)e).getEx().getMessage():""));
			FacesMessage message = new FacesMessage(msg);
			getFacesContext().addMessage("formularioUsuario", message);
			return limparFormulario();
		}
	}
	
	public String excluir(){
		try{
			
			String idUsuario = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("formularioUsuario:idUsuario");
			//HtmlInputHidden idUsuario = (HtmlInputHidden) getFacesContext().getViewRoot().findComponent("formularioUsuario:idUsuario");
			
			String id = (String) (idUsuario == null ? FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("formularioUsuario:idUsuario") : idUsuario);
			Usuario usuario = getUsuarioService().consultar(Integer.parseInt(id));
			
			if(usuario == null || usuario.getIdUsuario() == 0){
				FacesMessage facesMessage = new FacesMessage("Nenhum registro encontrado");
				getFacesContext().addMessage("formularioUsuario", facesMessage);
				return "listar usuario";
			}
			
			getUsuarioService().excluir(usuario.getIdUsuario());
			
			String msg = "Usuário Excluido com Sucesso!!!";
			FacesMessage message = new FacesMessage(msg);
			getFacesContext().addMessage("formularioUsuario", message);
			return null;
			
		}catch(Exception e){
			String msg = "Exclusão não realizada. Motivo: " + ((e instanceof MyGridPucException ? ((MyGridPucException)e).getEx().getMessage():""));
			FacesMessage message = new FacesMessage(msg);
			getFacesContext().addMessage("formularioUsuario", message);
			return null;
		}
	}
	
	public String alterar(){
		try{
			Usuario usuario = getUsuarioService().consultar(this.usuarioBean.getIdUsuario());
			System.out.println(usuario.getIdUsuario());
			
			if(usuario == null || usuario.getIdUsuario() == 0){
				FacesMessage facesMessage = new FacesMessage("Nenhum registro encontrado");
				getFacesContext().addMessage("formularioUsuario", facesMessage);
				return "listar usuario";
			}
			
			usuario.setEmailUsuario(this.usuarioBean.getEmailUsuario().toLowerCase());
			usuario.setTipoUsuario("ROLE_ADMINISTRADOR");
			usuario.setSenhaUsuario(this.usuarioBean.getSenhaUsuario());
			
			getUsuarioService().alterar(usuario);
			
			String msg = "Usuario Alterado com Sucesso!!!";
			FacesMessage message = new FacesMessage(msg);
			getFacesContext().addMessage("formularioUsuario", message);
			
			return limparFormulario();
		}catch(Exception e){
			e.printStackTrace();
			String msg = "Alteração não realizada. Motivo: " + ((e instanceof MyGridPucException ? ((MyGridPucException)e).getEx().getMessage():""));
			FacesMessage message = new FacesMessage(msg);
			getFacesContext().addMessage("formularioUsuario", message);
			return null;
		}
	}

	
	public UsuarioBean getUsuario() {
		return usuarioBean;
	}


	public void setUsuario(UsuarioBean usuario) {
		this.usuarioBean = usuario;
	}
	
	private FacesContext getFacesContext(){
		return FacesContext.getCurrentInstance();
	}
	
	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	public UsuarioBean getUsuarioBean() {
		return usuarioBean;
	}

	public void setUsuarioBean(UsuarioBean usuarioBean) {
		this.usuarioBean = usuarioBean;
	}

	public List<UsuarioBean> getListaUsuarioBean() {
		return listaUsuarioBean;
	}

	public void setListaUsuarioBean(List<UsuarioBean> listaUsuarioBean) {
		this.listaUsuarioBean = listaUsuarioBean;
	}
	
	public String limparFormulario(){
		this.usuarioBean = new UsuarioBean();
		return null;
	}
	
}
 
