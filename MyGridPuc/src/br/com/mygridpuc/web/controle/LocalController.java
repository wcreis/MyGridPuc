/**
 * 
 */
package br.com.mygridpuc.web.controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.mygridpuc.web.entidade.Local;
import br.com.mygridpuc.web.negocio.LocalService;
import br.com.mygridpuc.web.util.MyGridPucException;

/**
 * Classe que controla as requisicoes do cliente web
 * @author DavidRodrigues
 *
 */
@ManagedBean(name="localController")
@RequestScoped
@Controller
public class LocalController {

	@Autowired
	private LocalBean localBean;
	@Autowired
	private List<LocalBean> listLocalBeans;
	@Autowired
	private LocalService localService ;
	
	
	/**
	 * Incluir um curso na base de dados
	 * @return
	 */
	public String incluir(){
		try{
			Local local = new Local();

			getLocalService().incluir(local);
			
			return "sucesso";
		}catch(Exception e){
			String msg = "Inclusão não realizada. Movito: " + ((e instanceof MyGridPucException ? ((MyGridPucException)e).getEx().getMessage():""));
			FacesMessage message = new FacesMessage(msg);
			getFacesContext().addMessage("formulario", message);
			e.printStackTrace();
			return "falha";
		}
	}
	
	/**
	 * Lista cursos cadastrados
	 * @return
	 */
	@SuppressWarnings("unused")
	public String listar(){
		try{
			List<Local> listLocal = getLocalService().listar();
			
			if(listLocal == null || listLocal.size() == 0){
				FacesMessage facesMessage = new FacesMessage("Nenhum registro encontrado");
				getFacesContext().addMessage("formulario", facesMessage);
				return "listar local";
			}
			
			//preenche a lista de cursos na tela
			listLocalBeans = new ArrayList<LocalBean>();
			
			for(Local local: listLocal){
				LocalBean localBean = new LocalBean();
	
				
				listLocalBeans.add(localBean);
			}
			
			return "listar local";
		}catch(Exception e){
			String msg = "Inclusão não realizada. Movito: " + ((e instanceof MyGridPucException ? ((MyGridPucException)e).getEx().getMessage():""));
			FacesMessage message = new FacesMessage(msg);
			getFacesContext().addMessage("formulario", message);
			e.printStackTrace();
			return "falha";
		}
	}
	
	public String consultar(){
		try{
			String idLocal = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idLocal");
			Local local = getLocalService().consultar(Integer.parseInt(idLocal));

			if(local == null || local.getIdLocal() == 0){
				FacesMessage facesMessage = new FacesMessage("Nenhum registro encontrado");
				getFacesContext().addMessage("formulario", facesMessage);
				return "listar local";
			}
			

			
			return "editar local";
		}catch(Exception e){
			String msg = "Consulta não realizada. Movito: " + ((e instanceof MyGridPucException ? ((MyGridPucException)e).getEx().getMessage():""));
			FacesMessage message = new FacesMessage(msg);
			getFacesContext().addMessage("formulario", message);
			e.printStackTrace();
			return "falha";
		}
	}
	
	public String criar(){
		try{
			localBean = new LocalBean();
			return "criar local";
		}catch(Exception e){
			String msg = "Criação não realizada. Movito: " + ((e instanceof MyGridPucException ? ((MyGridPucException)e).getEx().getMessage():""));
			FacesMessage message = new FacesMessage(msg);
			getFacesContext().addMessage("formulario", message);
			e.printStackTrace();
			return "falha";
		}
	}
	
	public String excluir(){
		try{
			String idLocal = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idLocal");
			Local local = getLocalService().consultar(Integer.parseInt(idLocal));
			
			if(local == null || local.getIdLocal() == 0){
				FacesMessage facesMessage = new FacesMessage("Nenhum registro encontrado");
				getFacesContext().addMessage("formulario", facesMessage);
				return "listar local";
			}
			
			getLocalService().excluir(local.getIdLocal());
			return "sucesso";
			
		}catch(Exception e){
			String msg = "Exclusão não realizada. Movito: " + ((e instanceof MyGridPucException ? ((MyGridPucException)e).getEx().getMessage():""));
			FacesMessage message = new FacesMessage(msg);
			getFacesContext().addMessage("formulario", message);
			e.printStackTrace();
			return "falha";
		}
	}
	
	public String alterar(){
		try{
			Local local = getLocalService().consultar(localBean.getIdLocal());
			
			if(local == null || local.getIdLocal() == 0){
				FacesMessage facesMessage = new FacesMessage("Nenhum registro encontrado");
				getFacesContext().addMessage("formulario", facesMessage);
				return "listar local";
			}
			

			
			getLocalService().alterar(local);
			return "sucesso";
			
		}catch(Exception e){
			String msg = "Alteração não realizada. Movito: " + ((e instanceof MyGridPucException ? ((MyGridPucException)e).getEx().getMessage():""));
			FacesMessage message = new FacesMessage(msg);
			getFacesContext().addMessage("formulario", message);
			e.printStackTrace();
			return "falha";
		}
	}
	
	public LocalBean getLocalBean() {
		return localBean;
	}

	public void setLocalBean(LocalBean localBean) {
		this.localBean = localBean;
	}

	public List<LocalBean> getListLocalBeans() {
		return listLocalBeans;
	}

	public void setListLocalBeans(List<LocalBean> listLocalBeans) {
		this.listLocalBeans = listLocalBeans;
	}

	public LocalService getLocalService() {
		return localService;
	}

	public void setLocalService(LocalService localService) {
		this.localService = localService;
	}
	
	public void removeBean(String bean){
		getFacesContext().getExternalContext().getSessionMap().remove(bean);
    }

	private FacesContext getFacesContext(){
		return FacesContext.getCurrentInstance();
	}
}
