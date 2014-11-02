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
	public Integer getIdUsuario() {
		return idUsuario;
	}
	/**
	 * 
	 * @param idUsuario
	 */
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	/**
	 * 
	 * @return tipoUsuario
	 */
	public Integer getTipoUsuario() {
		return tipoUsuario;
	}
	
	/**
	 * 
	 * @param tipoUsuario
	 */
	public void setTipoUsuario(Integer tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
	/**
	 * 
	 * @return emailUsuario
	 */
	public String getEmailUsuario() {
		return emailUsuario;
	}
	
	/**
	 * 
	 * @param emailUsuario
	 */
	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
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
