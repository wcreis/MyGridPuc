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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Classe que representa os dados persistentes da matriz
 * @author David Rodrigues
 *
 */

@Entity
@Table(name="matriz")
public class Matriz implements Serializable{

	private static final long serialVersionUID = 4314447931031362446L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idmatriz")
	private Integer idMatriz;
	
	@Column(name="anoSemestreMatriz", unique=true, nullable=false)
	private String anoSemestreMatriz;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idcurso", referencedColumnName="idcurso", nullable=false)
	private Curso curso;
		
	@OneToMany(mappedBy="matriz", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Periodo> listaPeriodos;
	
	public Integer getIdMatriz() {
		return idMatriz;
	}

	public void setIdMatriz(Integer idMatriz) {
		this.idMatriz = idMatriz;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<Periodo> getListaPeriodos() {
		return listaPeriodos;
	}

	public void setListaPeriodos(List<Periodo> listaPeriodos) {
		this.listaPeriodos = listaPeriodos;
	}	
	
	public String getAnoSemestreMatriz() {
		return anoSemestreMatriz;
	}

	public void setAnoSemestreMatriz(String anoSemestreMatriz) {
		this.anoSemestreMatriz = anoSemestreMatriz;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((anoSemestreMatriz == null) ? 0 : anoSemestreMatriz
						.hashCode());
		result = prime * result + ((curso == null) ? 0 : curso.hashCode());
		result = prime * result
				+ ((idMatriz == null) ? 0 : idMatriz.hashCode());
		result = prime * result
				+ ((listaPeriodos == null) ? 0 : listaPeriodos.hashCode());
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
		Matriz other = (Matriz) obj;
		if (anoSemestreMatriz == null) {
			if (other.anoSemestreMatriz != null)
				return false;
		} else if (!anoSemestreMatriz.equals(other.anoSemestreMatriz))
			return false;
		if (curso == null) {
			if (other.curso != null)
				return false;
		} else if (!curso.equals(other.curso))
			return false;
		if (idMatriz == null) {
			if (other.idMatriz != null)
				return false;
		} else if (!idMatriz.equals(other.idMatriz))
			return false;
		if (listaPeriodos == null) {
			if (other.listaPeriodos != null)
				return false;
		} else if (!listaPeriodos.equals(other.listaPeriodos))
			return false;
		return true;
	}
	
	
	
}
