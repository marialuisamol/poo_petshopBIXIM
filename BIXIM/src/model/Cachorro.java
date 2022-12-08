package model;

public class Cachorro extends Animal {
	public boolean pedigree;
	
	public Cachorro() {
		
	}
	public Cachorro(int codigo,String nome, String endereco, String cidade, boolean pedigree) {
		super(codigo,nome,endereco,cidade);
		this.pedigree = pedigree;
	}
	public boolean isPedigree() {
		return pedigree;
	}
	public void setPedigree(boolean pedigree) {
		this.pedigree = pedigree;
	}

	
	@Override
	public String toString() {
		return "Código: "+getCodigo()+" Nome: "+getNome()+" Endereço: "+getEndereco()+
				" Cidade: "+getCidade()+" Pedigree: "+pedigree+" ";
	}
	@Override
	public float getTaxa() {
		
		return 0.10f;
	}

	
}
