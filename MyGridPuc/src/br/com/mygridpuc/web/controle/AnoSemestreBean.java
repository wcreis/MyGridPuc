package br.com.mygridpuc.web.controle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Component;

/**
 * Classe que representa o formulario web de Curso/Ano Semestre
 * @author DavidRodrigues
 *
 */

@Component
@ManagedBean
@SessionScoped
public class AnoSemestreBean {
	
	private Integer idAnoSemestre;
	private Integer ano;
	private Integer semestre;
	
	public Integer getIdAnoSemestre() {
		return idAnoSemestre;
	}
	public void setIdAnoSemestre(Integer idAnoSemestre) {
		this.idAnoSemestre = idAnoSemestre;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	public Integer getSemestre() {
		return semestre;
	}
	public void setSemestre(Integer semestre) {
		this.semestre = semestre;
	}
	
}
