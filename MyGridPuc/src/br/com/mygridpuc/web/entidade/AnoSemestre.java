package br.com.mygridpuc.web.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Classe que representa o formulario web de Curso/Ano Semestre
 * @author DavidRodrigues
 *
 */

@Entity
@Table(name="anosemestre")
public class AnoSemestre implements Serializable{

	private static final long serialVersionUID = 8069893849165474970L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idanosemestre")
	private Integer idAnoSemestre;
	
	@Column(name="ano")
	private Integer ano;
	
	@Column(name="semestre")
	private Integer semestre;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idcurso", referencedColumnName="idcurso", nullable=false)
	private Curso curso;

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

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idAnoSemestre == null) ? 0 : idAnoSemestre.hashCode());
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
		AnoSemestre other = (AnoSemestre) obj;
		if (idAnoSemestre == null) {
			if (other.idAnoSemestre != null)
				return false;
		} else if (!idAnoSemestre.equals(other.idAnoSemestre))
			return false;
		return true;
	}
	
}
