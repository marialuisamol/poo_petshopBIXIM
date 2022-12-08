package model;

public enum TipoDocumento {
	CPF, CNPJ;
	
	private String tipo;
	
	private TipoDocumento() {
		
	}

	public String getTipo() {
		return tipo;
	}
	
}
