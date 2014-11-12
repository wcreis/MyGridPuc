/**
 * 
 */
package br.com.mygridpuc.web.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Wesley
 *
 */
@Embeddable
public class MatrizDisciplinaId implements Serializable {
	
	public MatrizDisciplinaId(){}

	/**
	 * 
	 */
	private static final long serialVersionUID = 5024854461522428877L;
	
	@Column(name = "idMatriz")  
	private int idMatriz;
	@Column(name = "idDisciplina") 
	private int idDisciplina;
	
	public int getIdMatriz() {
		return idMatriz;
	}
	public void setIdMatriz(int idMatriz) {
		this.idMatriz = idMatriz;
	}
	public int getIdDisciplina() {
		return idDisciplina;
	}
	public void setIdDisciplina(int idDisciplina) {
		this.idDisciplina = idDisciplina;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idDisciplina;
		result = prime * result + idMatriz;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof MatrizDisciplinaId))
			return false;
		MatrizDisciplinaId other = (MatrizDisciplinaId) obj;
		if (idDisciplina != other.idDisciplina)
			return false;
		if (idMatriz != other.idMatriz)
			return false;
		return true;
	}
	
	
}
