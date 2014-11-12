package br.com.mygridpuc.web.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * Classe que representa os dados persistentes do Relacinamento entre matriz e Disciplina
 * @author Wesley Reis
 *
 */

@Entity
@Table(name="matriz_displina")

public class MatrizDisciplina implements Serializable{
	
	@EmbeddedId
	private MatrizDisciplinaId idMatrizDisciplina;
	/**
	 * 
	 */
	private static final long serialVersionUID = -5230920933167758902L;

	@Column(name="periodo") 
	private int periodo;
	
    @ManyToOne
    @JoinColumn(name="idMatriz", nullable=false,  insertable = false, updatable = false)
	private Matriz matriz;
	
    @ManyToOne
    @JoinColumn(name="idDisciplina", nullable=false,  insertable = false, updatable = false)
	private Disciplina disciplina;

	
	public MatrizDisciplinaId getIdMatrizDisciplina() {
		return idMatrizDisciplina;
	}

	public void setIdMatrizDisciplina(MatrizDisciplinaId idMatrizDisciplina) {
		this.idMatrizDisciplina = idMatrizDisciplina;
	}

	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	public Matriz getMatriz() {
		return matriz;
	}

	public void setMatriz(Matriz matriz) {
		this.matriz = matriz;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((disciplina == null) ? 0 : disciplina.hashCode());
		result = prime
				* result
				+ ((idMatrizDisciplina == null) ? 0 : idMatrizDisciplina
						.hashCode());
		result = prime * result + ((matriz == null) ? 0 : matriz.hashCode());
		result = prime * result + periodo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof MatrizDisciplina))
			return false;
		MatrizDisciplina other = (MatrizDisciplina) obj;
		if (disciplina == null) {
			if (other.disciplina != null)
				return false;
		} else if (!disciplina.equals(other.disciplina))
			return false;
		if (idMatrizDisciplina == null) {
			if (other.idMatrizDisciplina != null)
				return false;
		} else if (!idMatrizDisciplina.equals(other.idMatrizDisciplina))
			return false;
		if (matriz == null) {
			if (other.matriz != null)
				return false;
		} else if (!matriz.equals(other.matriz))
			return false;
		if (periodo != other.periodo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MatrizDisciplina [idMatrizDisciplina=" + idMatrizDisciplina
				+ ", periodo=" + periodo + ", matriz=" + matriz
				+ ", disciplina=" + disciplina + "]";
	}

}
