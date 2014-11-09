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
@ManagedBean
@Component
@SessionScoped
public class MatrizBean extends AbstractBean{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7141962009716766510L;
	
	private String anoSemestreMatriz;
	private List<PeriodoBean> listPeriodos;

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
