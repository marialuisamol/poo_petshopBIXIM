package service;

import java.util.Date;

import bd.BancoDeDados;
import dao.AtendimentoDAO;
import model.Animal;
import model.Atendimento;
import util.Util;

public class AtendimentoService {
	
	private AtendimentoDAO atendimentoDAO;
	private AnimalService animalService;

	
	public AtendimentoService() {
		atendimentoDAO = new AtendimentoDAO();
		animalService = new AnimalService();
		
	}
	
	public boolean inserir(Atendimento atendimento){
		
		boolean sucesso = atendimentoDAO.inserir(atendimento);
		if(sucesso == false) {
			throw new Error("Não há espaço suficiente!");
		}
		return sucesso;
		
	}
	public boolean alterar(int codigo, Atendimento atendimento) {
		
		boolean sucesso = atendimentoDAO.alterar(codigo, atendimento);
		if(sucesso == false) {
			throw new Error("Código não encontrado!");
		}
		return sucesso;
	}
	public boolean remover(int codigo) {
		
		boolean sucesso = atendimentoDAO.remover(codigo);
		if(sucesso == false) {
			throw new Error("Código não encontrado!");
		}
		return sucesso;
	}
	public void limpaDados() {
		atendimentoDAO.limpaDados();
	}
	public Atendimento getAtendimento(int codigo) {
		return atendimentoDAO.getAtendimento(codigo);
	}

	@Override
	public String toString() {
		return "AtendimentoService [atendimentoDAO=" + atendimentoDAO + "]";
	}
	
	public String getNotaFiscal(int codigo) {
		
		Animal animal = animalService.getAnimal(codigo);
		
		if (animal == null) {
			throw new Error("Animal não encontrado!");
		}
		
		Atendimento[] listaAtendimentos = atendimentoDAO.getAll();
		
		float total = 0f;
		
		String notaFiscal = String.format("#########################################################\n"
										 + "#                      Nota Fiscal                      #\n"
										 + "#########################################################\n"
										 + "# Nome: %s\n"
										 + "# Endereço: %s\n"
										 + "# Cidade: %s\n"
										 + "#########################################################\n"
										 + "#                      Atendimentos                     #\n"
										 + "#########################################################\n", 
										 animal.getNome(), animal.getEndereco(), animal.getCidade());
		
		for(int i = 0; i < listaAtendimentos.length; i++) {
			if(listaAtendimentos[i] == null) {
				continue;
			}
			if(listaAtendimentos[i].getAnimal().getCodigo() == codigo) {
				notaFiscal +=  String.format("# Serviço: %s\tValor:%.2f\n", listaAtendimentos[i].getServico().getNome(), listaAtendimentos[i].getServico().getValor());
				total += listaAtendimentos[i].getServico().getValor();
			}
		}
		
		notaFiscal += String.format("#########################################################\n"
								   + "# Total:\tR$%.2f\n"
								   + "#########################################################\n", total);
		
		return notaFiscal;
	}

	public Atendimento getMaiorAtendimento(int codigo) {
		
		Atendimento temp = null;
		boolean encontrou = false;    
		Animal[] animais = BancoDeDados.getAnimais(); 
		for (int i=0;i<animais.length;i++) { 
			if(animais[i]!=null) {       
				if(animais[i].getCodigo() == codigo) encontrou = true;       	
			}	
		}     
		if(encontrou) { 
			Atendimento[] atendimentos = BancoDeDados.getAtendimentos();
			
			for (int i=0;i<atendimentos.length;i++) {
				if (atendimentos[i]!=null) {
					if (atendimentos[i].getAnimal().getCodigo() == codigo) {
						if (temp == null){
							temp = atendimentos[i];
						}
						if(atendimentos[i].getServico().getValor() >= temp.getServico().getValor()) {
							temp = atendimentos[i];
						}
					}
				}
			}
		}
		else{
			throw new Error("Animal não encontrado!");
		}
		if(temp == null){
			throw new Error("Atendimento não encontrado!");
		}
			
		return temp;
	}

	public Atendimento getMenorAtendimento(int codigo) {
		boolean encontrou = false; 
		Atendimento temp = null;   
		Animal[] animais = BancoDeDados.getAnimais(); 
		for (int i=0;i<animais.length;i++) { 
			if(animais[i]!=null) {       
				if(animais[i].getCodigo() == codigo) encontrou = true;       	
			}	
		}     
		if(encontrou) { 
			Atendimento[] atendimentos = BancoDeDados.getAtendimentos();

			for(int i=0;i<atendimentos.length;i++) {
				if(atendimentos[i] != null) {
					if(atendimentos[i].getAnimal().getCodigo() == codigo) {		
						if(temp == null){
							//seta temp na com a primeira posição do vetor
							temp = atendimentos[i];
						}				
						if(atendimentos[i].getServico().getValor() <= temp.getServico().getValor()) {
							temp = atendimentos[i];
							
						}
					}
				}
			}
		}
		else{
			throw new Error("Animal não encontrado!");
		}
		if(temp == null){
			throw new Error("Atendimento não encontrado!");
		}

		return temp;
	}

	public float getTotalDosAtendimentos(int codigo){
		
		float temp = 0;
		
		boolean encontrou = false;    
		Animal[] animais = BancoDeDados.getAnimais(); 
		for (int i = 0; i < animais.length; i++) { 
			if(animais[i]!=null) {       
				if(animais[i].getCodigo() == codigo) encontrou = true;       	
			}	
		}     
		if(encontrou) { 
			Atendimento[] atendimentos = BancoDeDados.getAtendimentos();
			for(int i = 0; i < atendimentos.length; i++) {
				if(atendimentos[i] != null) {
					if(atendimentos[i].getAnimal().getCodigo() == codigo) {
						if(atendimentos[i].getServico().getValor() > 0) {
							temp += atendimentos[i].getServico().getValor();
						}
					}
				}
			}
		}
		else{
			throw new Error("Código não encontrado!");
		}


		return temp;

	}

	public String getAtendimentoPorPeriodo(String inicio, String fim){
		boolean exist = false;
		Atendimento[] atendimentos = BancoDeDados.getAtendimentos();
		String resultado = "";

		Date data1, data2;

		data1 = Util.stringParaDate(inicio);
		data2 = Util.stringParaDate(fim);

		for(int i = 0;i<atendimentos.length;i++) {
			if(atendimentos[i]!=null) {
				if((atendimentos[i].getDate().after(data1) || atendimentos[i].getDate().equals(data1))
				 && (atendimentos[i].getDate().before(data2) || atendimentos[i].getDate().equals(data2))){			
					resultado += ("Atendimento: "+atendimentos[i].getCodigo()
							+" "+atendimentos[i].getAnimal().getNome()
							+" - "+atendimentos[i].getServico().getNome()
							+" R$"+atendimentos[i].getServico().getValor()+"\n");
					exist = true;
				}
			}
		}
		if(exist == false){
			throw new Error ("Não há atendimentos no período informado!");
		}

		return resultado;
	}

}
