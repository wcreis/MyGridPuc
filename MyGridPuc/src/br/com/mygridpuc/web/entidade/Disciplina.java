package br.com.mygridpuc.web.entidade;

<<<<<<< HEAD
import java.util.List;
=======
import java.io.Serializable;
>>>>>>> origin/master

import javax.persistence.*;

/**
 * Representa o Objeto de negocio 'Disciplina'.
 * @author davi
 *
 */
@Entity
@Table(name="disciplina")
public class Disciplina implements Serializable{

	
	private static final long serialVersionUID = -8422772729429194168L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idDisciplina")
	private Integer idDisciplina;
	
	@Column(name="codigo", unique=true)
	private String codigo;
	
	@Column(name="creditoDisciplina")
	private Integer credito;
	
	@Column(name="nomeDiciplina")
	private String nome;
	
<<<<<<< HEAD
	@OneToMany(mappedBy="disciplina", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Matriz> listMatriz;

	public List<Matriz> getListMatriz() {
		return listMatriz;
	}

	public void setListMatriz(List<Matriz> listMatriz) {
		this.listMatriz = listMatriz;
	}

	public Integer getId() {
		return id;
=======
	public Integer getIdDisciplina() {
		return idDisciplina;
>>>>>>> origin/master
	}

	public void setIdDisciplina(Integer idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
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
