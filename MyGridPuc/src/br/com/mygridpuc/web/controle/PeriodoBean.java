/**
 * 
 */
package br.com.mygridpuc.web.controle;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Component;

/**
 * Classe que representa o formulario web de Curso
 * @author DavidRodrigues
 *
 */
@Component
@ManagedBean
@SessionScoped
public class PeriodoBean extends AbstractBean{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4698859573076589608L;
	private Integer idPeriodo;
	private Integer periodo;
	private List<DisciplinaBean> listDisciplinaBean;
	
	public Integer getIdPeriodo() {
		return idPeriodo;
	}
	public void setIdPeriodo(Integer idPeriodo) {
		this.idPeriodo = idPeriodo;
	}
	public Integer getPeriodo() {
		return periodo;
	}
	public void setPeriodo(Integer periodo) {
		this.periodo = periodo;
	}
	public List<DisciplinaBean> getListDisciplinaBean() {
		return listDisciplinaBean;
	}
	public void setListDisciplinaBean(List<DisciplinaBean> listDisciplinaBean) {
		this.listDisciplinaBean = listDisciplinaBean;
	}
	
}
