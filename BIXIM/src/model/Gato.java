package model;

public class Gato extends Animal{
	private String numeroDocumento;
	
	public Gato() {
		// TODO Auto-generated constructor stub
	}

	public Gato(int codigo, String nome, String endereco, String cidade, String numeroDocumento) {
		super(codigo,nome,endereco,cidade);
		this.numeroDocumento = numeroDocumento;
	}
	
	public TipoDocumento getTipo() {
		return null;
		
	}
	public void setTipo(TipoDocumento documento) {
		
	}
	

	@Override
	public String toString() {
		return "Código: "+getCodigo()+" Nome: "+getNome()+" Endereço: "+getEndereco()+
				" Cidade: "+getCidade()+" Documento: "+numeroDocumento+" "; //pessoa fisica.
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	@Override
	public float getTaxa() {
		return 0.15f;
	}
	
}
