package model;

public class Gato extends Animal{
	private String numeroDocumento;
	private TipoDocumento tipo;
	
	public Gato() {
		
	}

	public Gato(int codigo, String nome, String endereco, String cidade, String numeroDocumento) {
		super(codigo,nome,endereco,cidade);
		this.numeroDocumento = numeroDocumento;
	}
	
	public TipoDocumento getTipo() {
		return tipo;
		
	}
	public void setTipo(TipoDocumento documento) {
		this.tipo = documento;
	}
	
	@Override
	public String toString() {
		return "Código: "+getCodigo()+" Nome: "+getNome()+" Endereço: "+getEndereco()+
				" Cidade: "+getCidade()+" Documento: "+numeroDocumento+" ";
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
