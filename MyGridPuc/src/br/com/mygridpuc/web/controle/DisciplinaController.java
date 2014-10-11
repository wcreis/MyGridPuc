package br.com.mygridpuc.web.controle;

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

	public DisciplinaController(){
		disciplina = new DisciplinaBean();
	}
	
	@Autowired
	private DisciplinaBean disciplina;
	
	@Autowired
	private DisciplinaService disciplinaService;
	

	public String incluir(){
		try{
			System.out.print("Antes de incluir: " + disciplina);
			Disciplina disciplina = new Disciplina();
			
			disciplina.setCodigo(this.disciplina.getCodigo());
			disciplina.setNome(this.disciplina.getNome());
			disciplina.setCredito(this.disciplina.getCredito());
			
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
	
	public DisciplinaBean getDisciplina() {
		return disciplina;
	}


	public void setDisciplina(DisciplinaBean disciplina) {
		this.disciplina = disciplina;
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
}
 