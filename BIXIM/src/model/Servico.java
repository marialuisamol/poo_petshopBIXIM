package model;

import java.util.Objects;

public class Servico {
	private int codigo;
	private String nome;
	private float valor;
	
	public Servico() {
	
	}

	public Servico(int codigo, String nome, float valor) {
		this.codigo = codigo;
		this.nome = nome;
		this.valor = valor;
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, nome, valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Servico other = (Servico) obj;
		return codigo == other.codigo && Objects.equals(nome, other.nome)
				&& Float.floatToIntBits(valor) == Float.floatToIntBits(other.valor);
	}

	@Override
	public String toString() {
		return "#########################################################\n"
			 + "#                       SERVIÇO                         #\n"
			 + "# Código:" + codigo +"\n"
			 + "# Serviço: " + nome + "\n"
			 + "# Valor: " + valor + "\n"
			 + "#########################################################";
	}
	
	
	
}
