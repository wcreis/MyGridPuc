package br.com.mygridpuc.web.controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.component.html.HtmlInputHidden;
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
@RequestScoped
@Controller
public class DisciplinaController {

	public DisciplinaController(){
		disciplinaBean = new DisciplinaBean();
		listaDisciplinaBean = new ArrayList<DisciplinaBean>();
	}
	
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
			System.out.print("Antes de incluir: " + disciplinaBean);
			Disciplina disciplina = new Disciplina();
			
			disciplina.setCodigo(this.disciplinaBean.getCodigo());
			disciplina.setNome(this.disciplinaBean.getNome());
			disciplina.setCredito(this.disciplinaBean.getCredito());
			
			getDisciplinaService().incluir(disciplina);
			
			System.out.print("Depois de incluir: " + disciplina);
			return "sucesso";
		}catch(Exception ex){
			String msg = "Inclusão não realizada. Movito: " + ((ex instanceof MyGridPucException ? ((MyGridPucException)ex).getEx().getMessage():""));
			FacesMessage message = new FacesMessage(msg);
			getFacesContext().addMessage("formulario", message);
			return "falha";
		}
	}
	
	/**
	 * Lista as diciplinas cadastradas
	 * @return
	 */
	public String listar(){
		try{
			List<Disciplina> listDisciplina = getDisciplinaService().listar();
			if(listDisciplina == null || listDisciplina.size() == 0){
				FacesMessage facesMessage = new FacesMessage("Nenhum registro encontrado");
				getFacesContext().addMessage("formulario", facesMessage);
				return "listar disciplinas";
			}
			
			//preenche a lista de cursos na tela
			listaDisciplinaBean = new ArrayList<DisciplinaBean>();
			
			for(Disciplina disciplina: listDisciplina){
				DisciplinaBean disciplinaBean = new DisciplinaBean();
				disciplinaBean.setId(disciplina.getId());
				disciplinaBean.setCodigo(disciplina.getCredito());
				disciplinaBean.setNome(disciplina.getNome());
				disciplinaBean.setCredito(disciplina.getCredito());
				
				listaDisciplinaBean.add(disciplinaBean);
			}
			return "listar disciplina";
		}catch(Exception e){
			String msg = "Inclusão não realizada. Movito: " + ((e instanceof MyGridPucException ? ((MyGridPucException)e).getEx().getMessage():""));
			FacesMessage message = new FacesMessage(msg);
			getFacesContext().addMessage("formulario", message);
			return "falha";
		}
	}
	
	
	/**
	 * Consulta uma disciplina de acordo com o ID da disciplina que está sendo alterado.
	 * @return
	 */
	public String consultar(){
		try{
			String idDisciplina = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idDisciplina");
			Disciplina disciplina = getDisciplinaService().consultar(Integer.parseInt(idDisciplina));
			
			if(disciplina == null || disciplina.getId() == 0){
				FacesMessage facesMessage = new FacesMessage("Nenhum registro encontrado");
				getFacesContext().addMessage("formulario", facesMessage);
				return "listar disciplinas";
			}
			
			disciplinaBean.setId(disciplina.getId());
			disciplinaBean.setCodigo(disciplina.getCodigo());
			disciplinaBean.setNome(disciplina.getNome());
			
			return "editar disciplina";
		}catch(Exception e){
			String msg = "Consulta não realizada. Movito: " + ((e instanceof MyGridPucException ? ((MyGridPucException)e).getEx().getMessage():""));
			FacesMessage message = new FacesMessage(msg);
			getFacesContext().addMessage("formulario", message);
			return "falha";
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
			String msg = "Criação não realizada. Movito: " + ((e instanceof MyGridPucException ? ((MyGridPucException)e).getEx().getMessage():""));
			FacesMessage message = new FacesMessage(msg);
			getFacesContext().addMessage("formulario", message);
			return "falha";
		}
	}
	
	public String excluir(){
		try{
			HtmlInputHidden idDisciplina = (HtmlInputHidden) getFacesContext().getViewRoot().findComponent("formularioDisciplina:idDisciplina");
			String id = (String) (idDisciplina == null ? FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idDisciplina") : idDisciplina);
			Disciplina disciplina = getDisciplinaService().consultar(Integer.parseInt(id));
			
			if(disciplina == null || disciplina.getId() == 0){
				FacesMessage facesMessage = new FacesMessage("Nenhum registro encontrado");
				getFacesContext().addMessage("formulario", facesMessage);
				return "listar disciplina";
			}
			
			getDisciplinaService().excluir(disciplina.getId());
			return "sucesso";
			
		}catch(Exception e){
			String msg = "Exclusão não realizada. Movito: " + ((e instanceof MyGridPucException ? ((MyGridPucException)e).getEx().getMessage():""));
			FacesMessage message = new FacesMessage(msg);
			getFacesContext().addMessage("formulario", message);
			return "falha";
		}
	}
	
	public String alterar(){
		try{
			Disciplina disciplina = getDisciplinaService().consultar(this.disciplinaBean.getId());
			
			if(disciplina == null || disciplina.getId() == 0){
				FacesMessage facesMessage = new FacesMessage("Nenhum registro encontrado");
				getFacesContext().addMessage("formulario", facesMessage);
				return "listar curso";
			}
			
			disciplina.setNome(this.disciplinaBean.getNome());
			disciplina.setCodigo(this.disciplinaBean.getCodigo());
			
			getDisciplinaService().alterar(disciplina);
			return "sucesso";
		}catch(Exception e){
			String msg = "Alteração não realizada. Movito: " + ((e instanceof MyGridPucException ? ((MyGridPucException)e).getEx().getMessage():""));
			FacesMessage message = new FacesMessage(msg);
			getFacesContext().addMessage("formulario", message);
			return "falha";
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
}
 