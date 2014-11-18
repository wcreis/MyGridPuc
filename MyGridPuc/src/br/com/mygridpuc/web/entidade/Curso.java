/**
 * 
 */
package br.com.mygridpuc.web.entidade;
	@Column(name="idCurso")
	private Integer idCurso;
	
	@Column(name="codigocurso", unique=true, length=4)
	private String codigoCurso;
	
	@Column(name="nomeCurso")
	private String nomeCurso;
	
	@OneToMany(mappedBy = "curso", targetEntity = Matriz.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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
	}
	public String getNomeCurso() {
		return nomeCurso;
	}
	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	public String getCodigoCurso() {
		return codigoCurso;
	}
	public void setCodigoCurso(String codigoCurso) {
		this.codigoCurso = codigoCurso;
	}
	@Override
	public String toString() {
		return "Curso [idCurso=" + idCurso + ", codigoCurso=" + codigoCurso
				+ ", nomeCurso=" + nomeCurso + "]";
	}
}
