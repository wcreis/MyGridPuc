/**
 * 
 */
package br.com.mygridpuc.web.controle;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Component;

/**
 * Classe que representa o formulario web de Usuario
 * @author Wesley Reis
 *
 */

@Component
@ManagedBean
@SessionScoped
public class UsuarioBean {
	private Integer idUsuario;
	private Integer tipoUsuario;
	private String emailUsuario;
	private String senhaUsuario;
	
	/**
	 * 
	 * @return idUsuario
	 */
	public Integer getIdCurso() {
		return idUsuario;
	}
	/**
	 * 
	 * @param idCurso
	 */
	public void setIdCurso(Integer idCurso) {
		this.idUsuario = idCurso;
	}
	/**
	 * 
	 * @return tipoUsuario
	 */
	public Integer getCodigoCurso() {
		return tipoUsuario;
	}
	
	/**
	 * 
	 * @param codigoCurso
	 */
	public void setCodigoCurso(Integer codigoCurso) {
		this.tipoUsuario = codigoCurso;
	}
	
	/**
	 * 
	 * @return emailUsuario
	 */
	public String getNomeCurso() {
		return emailUsuario;
	}
	
	/**
	 * 
	 * @param nomeCurso
	 */
	public void setNomeCurso(String nomeCurso) {
		this.emailUsuario = nomeCurso;
	}
	
	/**
	 * 
	 * @return senhaUsuario
	 */
	public String getSenhaUsuario() {
		return senhaUsuario;
	}
	
	/**
	 * 
	 * @param senhaUsuario
	 */
	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}
	
}
