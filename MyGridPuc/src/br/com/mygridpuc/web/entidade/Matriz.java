/**
 * 
 */
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
 * Classe que representa os dados persistentes da matriz
 * @author David Rodrigues
 *
 */

@Entity
@Table(name="matriz")
public class Matriz implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idmatriz")
	private Integer idMatriz;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idcurso", referencedColumnName="idcurso", nullable=false)
	private Curso curso;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="iddisciplina", referencedColumnName="iddisciplina", nullable=false)
	private Disciplina disciplina;
	
	@Column(name="descricao")
	private String descricao;
	
	public Integer getIdMatriz() {
		return idMatriz;
	}

	public void setIdMatriz(Integer idMatriz) {
		this.idMatriz = idMatriz;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	private static final long serialVersionUID = -8385150311284945963L;
	
}
