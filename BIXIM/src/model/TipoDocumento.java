package model;

public enum TipoDocumento {
	CPF, CNPJ;
	
	private String tipo;
	
	private TipoDocumento() {
		// TODO Auto-generated constructor stub
	}

	public String getTipo() {
		return tipo;
	}
	
}
