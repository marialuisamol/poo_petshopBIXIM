package model;

import java.util.Objects;

public abstract class Animal {
	
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
	
	public abstract float getTaxa();
	
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
		return "\n#########################################################\n"
		 	 + "#                      DADOS ANIMAL                     #\n"
			 + "# Código = " + codigo + "\n# Nome = " + nome + "\n# Endereco = " + endereco + "\n# Cidade = " + cidade ;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cidade, codigo, endereco, nome);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		return Objects.equals(cidade, other.cidade) && codigo == other.codigo
				&& Objects.equals(endereco, other.endereco) && Objects.equals(nome, other.nome);
	}
	
	
	
}
