/**
 * 
 */
package br.com.mygridpuc.web.controle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Component;

/**
 * Classe que representa o formulario web de Curso
 * 
 * @author DavidRodrigues
 *
 */
@Component
@ManagedBean
@SessionScoped
public class MatrizDisciplinaBean extends AbstractBean implements Comparable<MatrizDisciplinaBean>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6778514013295028590L;
	private Integer periodo;
	private DisciplinaBean disciplinaBean;
	private MatrizBean matrizBean;
	
	public Integer getPeriodo() {
		return periodo;
	}
	public void setPeriodo(Integer periodo) {
		this.periodo = periodo;
	}
	public DisciplinaBean getDisciplinaBean() {
		return disciplinaBean;
	}
	public void setDisciplinaBean(DisciplinaBean disciplinaBean) {
		this.disciplinaBean = disciplinaBean;
	}
	public MatrizBean getMatrizBean() {
		return matrizBean;
	}
	public void setMatrizBean(MatrizBean matrizBean) {
		this.matrizBean = matrizBean;
	}

	@Override
	public int compareTo(MatrizDisciplinaBean arg0) {
		if(this.periodo < arg0.periodo){
			return -1;
		}
		if(this.periodo > arg0.periodo){
			return 1;
		}
		return 0;
	}

}
