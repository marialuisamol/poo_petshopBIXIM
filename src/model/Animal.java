package model;

public class Animal {
	
	private int codigo;
	private String nome;
	private String endereco;
	private String cidade;
	
	
	
	public Animal() {
		
	}
	public Animal(int codigo, String nome, String endereco, String cidade) {
		
		this.codigo = codigo;
		this.nome = nome;
		this.endereco = endereco;
		this.cidade = cidade;
	}
	
	
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
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
	@Override
	public String toString() {
		return "Animal [codigo=" + codigo + ", nome=" + nome + ", endereco=" + endereco + ", cidade=" + cidade + "]";
	}
	
	
	
}
