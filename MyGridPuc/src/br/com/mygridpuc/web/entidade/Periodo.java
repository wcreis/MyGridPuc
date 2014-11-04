/**
 * 
 */
package br.com.mygridpuc.web.entidade;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Classe que representa os dados persistentes do Periodo por curso
 * @author Wesley
 *
 */
@Entity
@Table(name="periodo")
public class Periodo implements Serializable {



	/**
	 * 
	 */
	private static final long serialVersionUID = -604457152311770855L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idPeriodo")
	private Integer idPeriodo;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idMatriz", unique=true, referencedColumnName="idMatriz", nullable=false)
	private Matriz matriz;
	
	
    @ManyToMany
    @JoinTable(name="periodo_disciplina", joinColumns= {@JoinColumn(name="idPeriodo")}, inverseJoinColumns= {@JoinColumn(name="idDisciplina")})
	private List<Disciplina> listaDiscilinas;

	public Integer getIdPeriodo() {
		return idPeriodo;
	}

	public void setIdPeriodo(Integer idPeriodo) {
		this.idPeriodo = idPeriodo;
	}

	public Matriz getMatriz() {
		return matriz;
	}

	public void setMatriz(Matriz matriz) {
		this.matriz = matriz;
	}

	public List<Disciplina> getListaDiscilinas() {
		return listaDiscilinas;
	}

	public void setListaDiscilinas(List<Disciplina> listaDiscilinas) {
		this.listaDiscilinas = listaDiscilinas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idPeriodo == null) ? 0 : idPeriodo.hashCode());
		result = prime * result
				+ ((listaDiscilinas == null) ? 0 : listaDiscilinas.hashCode());
		result = prime * result + ((matriz == null) ? 0 : matriz.hashCode());
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
		Periodo other = (Periodo) obj;
		if (idPeriodo == null) {
			if (other.idPeriodo != null)
				return false;
		} else if (!idPeriodo.equals(other.idPeriodo))
			return false;
		if (listaDiscilinas == null) {
			if (other.listaDiscilinas != null)
				return false;
		} else if (!listaDiscilinas.equals(other.listaDiscilinas))
			return false;
		if (matriz == null) {
			if (other.matriz != null)
				return false;
		} else if (!matriz.equals(other.matriz))
			return false;
		return true;
	}

}
