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
 * @author DavidRodrigues / Wesley Reis
 *
 */
@Component
@ManagedBean
@SessionScoped
public class MatrizBean {
	private Integer idMatriz;
	private String anoSemestreMatriz;
	private List<PeriodoBean> listPeriodos;
	
	public Integer getIdMatriz() {
		return idMatriz;
	}
	public void setIdMatriz(Integer idMatriz) {
		this.idMatriz = idMatriz;
	}
	public String getAnoSemestreMatriz() {
		return anoSemestreMatriz;
	}
	public void setAnoSemestreMatriz(String anoSemestreMatriz) {
		this.anoSemestreMatriz = anoSemestreMatriz;
	}
	public List<PeriodoBean> getListPeriodos() {
		return listPeriodos;
	}
	public void setListPeriodos(List<PeriodoBean> listPeriodos) {
		this.listPeriodos = listPeriodos;
	}
		
}
