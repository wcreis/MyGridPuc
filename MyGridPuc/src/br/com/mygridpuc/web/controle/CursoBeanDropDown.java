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
@ManagedBean
@Component
@SessionScoped
public class CursoBeanDropDown extends AbstractBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2278192633089432470L;
	private Integer codigoCurso;
	private String nomeCurso;
	private List<MatrizBean> listMatriz;
	
	public List<MatrizBean> getListMatriz() {
		return listMatriz;
	}
	public void setListMatriz(List<MatrizBean> listMatriz) {
		this.listMatriz = listMatriz;
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
