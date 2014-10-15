package br.com.mygridpuc.web.entidade;

import javax.persistence.*;

/**
 * Representa o Objeto de negocio 'Disciplina'.
 * @author davi
 *
 */
@Entity
@Table(name="disciplina")
public class Disciplina {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idDisciplina")
	private Integer id;
	
	@Column(name="codigoCurso")
	private Integer codigo;
	
	@Column(name="creditoDisciplina")
	private Integer credito;
	
	@Column(name="nomeDiciplina")
	private String nome;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getCredito() {
		return credito;
	}

	public void setCredito(Integer credito) {
		this.credito = credito;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
