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
public class CursoBean {
	private Integer idCurso;
	private Integer codigoCurso;
	private String nomeCurso;
	private List<AnoSemestreBean> listAnoSemestre;
	
	public List<AnoSemestreBean> getListAnoSemestre() {
		return listAnoSemestre;
	}
	public void setListAnoSemestre(List<AnoSemestreBean> listAnoSemestre) {
		this.listAnoSemestre = listAnoSemestre;
	}
	public Integer getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}
	public Integer getCodigoCurso() {
		return codigoCurso;
	}
	public void setCodigoCurso(Integer codigoCurso) {
		this.codigoCurso = codigoCurso;
	}
	public String getNomeCurso() {
		return nomeCurso;
	}
	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	
}
