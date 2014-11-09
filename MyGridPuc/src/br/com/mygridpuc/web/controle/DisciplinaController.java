package br.com.mygridpuc.web.controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.mygridpuc.web.entidade.Disciplina;
import br.com.mygridpuc.web.negocio.DisciplinaService;
import br.com.mygridpuc.web.util.MyGridPucException;

/**
 * Representa o controlador da view de cadastro de disciplina.
 * 
 * @author davi
 *
 */
@ManagedBean(name="disciplinaController")
@RequestScoped
@Controller
public class DisciplinaController {
	
	@Autowired
	private DisciplinaBean disciplinaBean;
	
	@Autowired
	private DisciplinaService disciplinaService;
	
	@Autowired
	private List<DisciplinaBean> listaDisciplinaBean;

	
	/**
	 * Inclui a disciplina no banco de dados.
	 * @return
	 */
	public String incluir(){
		try{
			Disciplina disciplina = new Disciplina();
			
			disciplina.setCodigo(this.disciplinaBean.getCodigo().toUpperCase());
			disciplina.setNome(this.disciplinaBean.getNome().toUpperCase());
			disciplina.setCredito(this.disciplinaBean.getCredito());
			
			getDisciplinaService().incluir(disciplina);
			String msg = "Cadastro Realizado com Sucesso!!!";
			FacesMessage message = new FacesMessage(msg);
			getFacesContext().addMessage("formulario", message);
			
			return null;
		}catch(Exception ex){
			String msg = "Inclus„o n„o realizada. Motivo: " + ((ex instanceof MyGridPucException ? ((MyGridPucException)ex).getEx().getMessage():""));
			FacesMessage message = new FacesMessage(msg);
			getFacesContext().addMessage("formulario", message);
			return null;
		}
	}
	
	/**
	 * Lista as diciplinas cadastradas
	 * @return
	 */
	public String listar(){
		disciplinaBean = new DisciplinaBean();
		try{
			List<Disciplina> listDisciplina = new ArrayList<>();
			listDisciplina = getDisciplinaService().listar();
			if(listDisciplina == null || listDisciplina.size() == 0){
				FacesMessage facesMessage = new FacesMessage("Nenhum registro encontrado");
				System.out.println(getFacesContext());
				getFacesContext().addMessage("formulario", facesMessage);
				return "listar disciplinas";
			}
			
			//preenche a lista de Disciplinas na tela
			listaDisciplinaBean = new ArrayList<DisciplinaBean>();
			
			for(Disciplina disciplina: listDisciplina){
				DisciplinaBean disciplinaBean = new DisciplinaBean();
				
				disciplinaBean.setId(disciplina.getIdDisciplina());
				disciplinaBean.setCodigo(disciplina.getCodigo().toUpperCase());
				disciplinaBean.setNome(disciplina.getNome().toUpperCase());
				disciplinaBean.setCredito(disciplina.getCredito());
				
				listaDisciplinaBean.add(disciplinaBean);
			}
			return "listar disciplina";
		}catch(Exception e){
			String msg = "Inclus√£o n√£o realizada. Motivo: " + ((e instanceof MyGridPucException ? ((MyGridPucException)e).getEx().getMessage():""));
			FacesMessage message = new FacesMessage(msg);
			getFacesContext().addMessage("formulario", message);
			return null;
		}
	}
	
	
	/**
	 * Consulta uma disciplina de acordo com o ID da disciplina que est√° sendo alterado.
	 * @return
	 */
	public String consultar(){
		try{
			
			String idDisciplina = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("formulario:idDisciplina");
			
			Disciplina disciplina = getDisciplinaService().consultar(Integer.parseInt(idDisciplina));
			
			if(disciplina == null || disciplina.getIdDisciplina() == 0){
				FacesMessage facesMessage = new FacesMessage("Nenhum registro encontrado");
				getFacesContext().addMessage("formulario", facesMessage);
				return "listar disciplinas";
			}
			
			disciplinaBean.setId(disciplina.getIdDisciplina());
			disciplinaBean.setCodigo(disciplina.getCodigo().toUpperCase());
			disciplinaBean.setNome(disciplina.getNome().toUpperCase());
			disciplinaBean.setCredito(disciplina.getCredito());
			
			return "editar disciplina";
		}catch(Exception e){
			String msg = "Consulta n√£o realizada. Motivo: " + ((e instanceof MyGridPucException ? ((MyGridPucException)e).getEx().getMessage():""));
			FacesMessage message = new FacesMessage(msg);
			getFacesContext().addMessage("formulario", message);
			return null;
		}
	}
	
	/**
	 * Cria um novo objeto Disciplina e redireciona para a tela de criar disciplina.
	 * @return
	 */
	public String criar(){
		try{
			disciplinaBean = new DisciplinaBean();
			return "criar disciplina";
		}catch(Exception e){
			String msg = "Cria√ß√£o n√£o realizada. Motivo: " + ((e instanceof MyGridPucException ? ((MyGridPucException)e).getEx().getMessage():""));
			FacesMessage message = new FacesMessage(msg);
			getFacesContext().addMessage("formulario", message);
			return null;
		}
	}
	
	public String excluir(){
		try{
			
			String idDisciplina = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("formulario:idDisciplina");
			//HtmlInputHidden idDisciplina = (HtmlInputHidden) getFacesContext().getViewRoot().findComponent("formulario:idDisciplina");
			
			String id = (String) (idDisciplina == null ? FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("formulario:idDisciplina") : idDisciplina);
			Disciplina disciplina = getDisciplinaService().consultar(Integer.parseInt(id));
			
			if(disciplina == null || disciplina.getIdDisciplina() == 0){
				FacesMessage facesMessage = new FacesMessage("Nenhum registro encontrado");
				getFacesContext().addMessage("formulario", facesMessage);
				return "listar disciplina";
			}
			
			getDisciplinaService().excluir(disciplina.getIdDisciplina());
			
			String msg = "Cadastro Excluido com Sucesso!!!";
			FacesMessage message = new FacesMessage(msg);
			getFacesContext().addMessage("formulario", message);
			
			return "sucesso";
			
		}catch(Exception e){
			String msg = "Exclus√£o n√£o realizada. Motivo: " + ((e instanceof MyGridPucException ? ((MyGridPucException)e).getEx().getMessage():""));
			FacesMessage message = new FacesMessage(msg);
			getFacesContext().addMessage("formulario", message);
			return null;
		}
	}
	
	public String alterar(){
		try{
			Disciplina disciplina = getDisciplinaService().consultar(this.disciplinaBean.getId());
			System.out.println(disciplina.getIdDisciplina());
			
			if(disciplina == null || disciplina.getIdDisciplina() == 0){
				FacesMessage facesMessage = new FacesMessage("Nenhum registro encontrado");
				getFacesContext().addMessage("formulario", facesMessage);
				return "listar disciplina";
			}
			
			disciplina.setNome(this.disciplinaBean.getNome().toUpperCase());
			disciplina.setCodigo(this.disciplinaBean.getCodigo().toUpperCase());
			disciplina.setCredito(this.disciplinaBean.getCredito());
			
			getDisciplinaService().alterar(disciplina);
			
			String msg = "Cadastro Alterado com Sucesso!!!";
			FacesMessage message = new FacesMessage(msg);
			getFacesContext().addMessage("formulario", message);
			
			return "sucesso";
		}catch(Exception e){
			String msg = "AlteraÁ„o n„o realizada. Motivo: " + ((e instanceof MyGridPucException ? ((MyGridPucException)e).getEx().getMessage():""));
			FacesMessage message = new FacesMessage(msg);
			getFacesContext().addMessage("formulario", message);
			return null;
		}
	}

	
	public DisciplinaBean getDisciplina() {
		return disciplinaBean;
	}


	public void setDisciplina(DisciplinaBean disciplina) {
		this.disciplinaBean = disciplina;
	}
	
	private FacesContext getFacesContext(){
		return FacesContext.getCurrentInstance();
	}
	
	public DisciplinaService getDisciplinaService() {
		return disciplinaService;
	}

	public void setDisciplinaService(DisciplinaService disciplinaService) {
		this.disciplinaService = disciplinaService;
	}
	
	public DisciplinaBean getDisciplinaBean() {
		return disciplinaBean;
	}

	public void setDisciplinaBean(DisciplinaBean disciplinaBean) {
		this.disciplinaBean = disciplinaBean;
	}

	public List<DisciplinaBean> getListaDisciplinaBean() {
		return listaDisciplinaBean;
	}

	public void setListaDisciplinaBean(List<DisciplinaBean> listaDisciplinaBean) {
		this.listaDisciplinaBean = listaDisciplinaBean;
	}
	
	public String limparFormulario(){
		this.disciplinaBean = new DisciplinaBean();
		return null;
	}
	
}
 
