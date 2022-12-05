package model;

public class Cachorro extends Animal {
	public boolean pedigree;
	
	public Cachorro() {
		// TODO Auto-generated constructor stub
	}
	public Cachorro(int codigo,String nome, String endereco, String Cidade, boolean pedigree) {
		
	}
	public boolean isPedigree() {
		return true;
	}
	public void setPedigree(boolean pedigree) {
		this.pedigree = pedigree;
	}

	@Override
	public String toString() {
		return "Cachorro [pedigree=" + pedigree + "]";
	}
	@Override
	public float getTaxa() {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
