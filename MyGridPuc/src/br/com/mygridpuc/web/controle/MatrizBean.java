/**
 * 
 */
package br.com.mygridpuc.web.controle;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Component;

/**
 * Classe que representa o formulario web de Matriz
 * @author DavidRodrigues
 *
 */
@Component
@ManagedBean
@SessionScoped
public class MatrizBean {
	private Integer idMatriz;
	private String descricao;
	private List<CursoBean> listCurso;
	private List<DisciplinaBean> listDisciplina;
	
	public Integer getIdMatriz() {
		return idMatriz;
	}
	public void setIdMatriz(Integer idMatriz) {
		this.idMatriz = idMatriz;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public List<CursoBean> getListCurso() {
		return listCurso;
	}
	public void setListCurso(List<CursoBean> listCurso) {
		this.listCurso = listCurso;
	}
	public List<DisciplinaBean> getListDisciplina() {
		return listDisciplina;
	}
	public void setListDisciplina(List<DisciplinaBean> listDisciplina) {
		this.listDisciplina = listDisciplina;
	}
		
}
