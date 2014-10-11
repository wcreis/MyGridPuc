package br.com.mygridpuc.web.controle;

public class TurmaBean {
	
	private String nome;
	private int codigo;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String toString(){
		return "nome: " + nome + ", codigo: " + codigo;
	}
}
