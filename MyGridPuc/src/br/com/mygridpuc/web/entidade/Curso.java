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
	
	private static final long serialVersionUID = -8385150311284945963L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idcurso")
	private Integer idCurso;
	
	@Column(name="codigocurso")
	private Integer codigoCurso;
	
	@Column(name="nomecurso")
	private String nomeCurso;
	
	@OneToMany(mappedBy="curso", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<AnoSemestre> listAnoSemestre;
	
	public List<AnoSemestre> getListAnoSemestre() {
		return listAnoSemestre;
	}
	public void setListAnoSemestre(List<AnoSemestre> listAnoSemestre) {
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCurso == null) ? 0 : idCurso.hashCode());
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
		if (idCurso == null) {
			if (other.idCurso != null)
				return false;
		} else if (!idCurso.equals(other.idCurso))
			return false;
		return true;
	}
	
}
