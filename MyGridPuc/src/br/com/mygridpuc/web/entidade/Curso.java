/**
 * 
 */
package br.com.mygridpuc.web.entidade;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Classe que representa os dados persistentes do curso
 * @author David Rodrigues
 *
 */

@Entity
@Table(name="curso")
public class Curso implements Serializable{
	
	private static final long serialVersionUID = 2757727363377720051L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idcurso")
	private Integer idCurso;
	
	@Column(name="codigocurso", columnDefinition="INT(4) ZEROFILL", nullable=false, unique=true, length=4)
	private int codigoCurso;
	
	@Column(name="nomecurso")
	private String nomeCurso;
	
	@OneToMany(mappedBy="curso", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Matriz> listMatriz;
	
	public List<Matriz> getListMatriz() {
		return listMatriz;
	}
	public void setListMatriz(List<Matriz> listMatriz) {
		this.listMatriz = listMatriz;
	}

	public Integer getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}
	public int getCodigoCurso() {
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
	public void setCodigoCurso(int codigoCurso) {
		this.codigoCurso = codigoCurso;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigoCurso;
		result = prime * result + ((idCurso == null) ? 0 : idCurso.hashCode());
		result = prime * result
				+ ((listMatriz == null) ? 0 : listMatriz.hashCode());
		result = prime * result
				+ ((nomeCurso == null) ? 0 : nomeCurso.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		if (codigoCurso != other.codigoCurso)
			return false;
		if (idCurso == null) {
			if (other.idCurso != null)
				return false;
		} else if (!idCurso.equals(other.idCurso))
			return false;
		if (listMatriz == null) {
			if (other.listMatriz != null)
				return false;
		} else if (!listMatriz.equals(other.listMatriz))
			return false;
		if (nomeCurso == null) {
			if (other.nomeCurso != null)
				return false;
		} else if (!nomeCurso.equals(other.nomeCurso))
			return false;
		return true;
	}
	
	

	
}
