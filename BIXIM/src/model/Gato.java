package model;

public class Gato extends Animal{
	private String numeroDocumento;
	
	public Gato() {
		// TODO Auto-generated constructor stub
	}

	public Gato(int codigo, String nome, String endereco, String cidade, String numeroDocumento) {
		// TODO Auto-generated constructor stub
	}
	
	public TipoDocumento getTipo() {
		return null;
		
	}
	public void setTipo(TipoDocumento documento) {
		
	}
	
	@Override
	public String toString() {
		return "Gato [numeroDocumento=" + numeroDocumento + "]";
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	@Override
	public float getTaxa() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
