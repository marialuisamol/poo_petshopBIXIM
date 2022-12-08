package model;

import java.util.Date;

import com.google.gson.Gson;

import util.Util;

public class Atendimento {
	
	private int codigo;
	private Date date;
	private Servico servico;
	private Animal animal;
	
	public Atendimento() {
		
	}

	public Atendimento(int codigo, Animal animal, Servico servico, Date date) {
		
		this.codigo = codigo;
		this.animal = animal;
		this.servico = servico;
		this.date = date;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	@Override
	public String toString() {
		return "\n#########################################################\n"
	 	 + "#                   DADOS ATENDIMENTO                   #\n"
		 + "# Código = " + codigo + 
		 "\n# Nome: "+getAnimal().getNome() +
		 "\n# Serviço: "+getServico().getNome()+
		 "\n# Valor: "+(getServico().getValor() + (getServico().getValor() * getAnimal().getTaxa()))+
		 "\n# Data = " + Util.dateParaString(date);
	}
	
	public String toJson() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}
	
}
