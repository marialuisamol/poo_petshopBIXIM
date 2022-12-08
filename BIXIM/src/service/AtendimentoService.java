package service;

import java.util.Date;
import java.util.Iterator;
import java.util.Set;
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
	
	public void inserir(Atendimento atendimento){

		atendimentoDAO.inserir(atendimento);
	}

	public void alterar(int codigo, Atendimento atendimento) {


		atendimentoDAO.alterar(codigo, atendimento);
	}

	public void remover(int codigo) {
		
		atendimentoDAO.remover(codigo);
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
		
		notaFiscal += this.listaAtendimentos(codigo);

		Set<Atendimento> listaAtendimentos = atendimentoDAO.getAll();

		for(Iterator<Atendimento> iter = listaAtendimentos.iterator();iter.hasNext();) {
			Atendimento atendimentoAtual = iter.next();
			if(atendimentoAtual.getAnimal().getCodigo() == codigo) {
				total += (atendimentoAtual.getServico().getValor() +
						(atendimentoAtual.getServico().getValor() * atendimentoAtual.getAnimal().getTaxa()));
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
		Set<Animal> animais = animalService.getAll();
        for(Iterator<Animal> iter = animais.iterator();iter.hasNext();) {
        	Animal animalAtual = iter.next();
            if(animalAtual.getCodigo() == codigo) {
            	encontrou = true;
            }
        }	
		    
		if(encontrou) { 
			Set<Atendimento> atendimentos = atendimentoDAO.getAll();		
	        for(Iterator<Atendimento> iter = atendimentos.iterator();iter.hasNext();) {
	        	Atendimento atendimentoAtual = iter.next();
	            if(atendimentoAtual.getAnimal().getCodigo() == codigo) {
	            	if(temp == null) {
	            		temp = atendimentoAtual;
	            	}
	            	if(atendimentoAtual.getServico().getValor() >= temp.getServico().getValor()) {
	            		temp = atendimentoAtual;
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
		Set<Animal> animais = animalService.getAll(); 
		
        for(Iterator<Animal> iter = animais.iterator();iter.hasNext();) {
        	Animal animalAtual = iter.next();
            if(animalAtual.getCodigo() == codigo) {
            	encontrou = true;
            }
        }
		if(encontrou) { 
			Set<Atendimento> atendimentos = atendimentoDAO.getAll();		
	        for(Iterator<Atendimento> iter = atendimentos.iterator();iter.hasNext();) {
	        	Atendimento atendimentoAtual = iter.next();
	            if(atendimentoAtual.getAnimal().getCodigo() == codigo) {
	            	if(temp == null) {
	            		temp = atendimentoAtual;
	            	}
	            	if(atendimentoAtual.getServico().getValor() <= temp.getServico().getValor()) {
	            		temp = atendimentoAtual;
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
		Set<Animal> animais = animalService.getAll(); 
        for(Iterator<Animal> iter = animais.iterator();iter.hasNext();) {
        	Animal animalAtual = iter.next();
            if(animalAtual.getCodigo() == codigo) {
            	encontrou = true;
            }
        }     
		if(encontrou) { 			
			Set<Atendimento> atendimentos = atendimentoDAO.getAll();		
	        for(Iterator<Atendimento> iter = atendimentos.iterator();iter.hasNext();) {
	        	Atendimento atendimentoAtual = iter.next();
	            if(atendimentoAtual.getAnimal().getCodigo() == codigo) {
	            	if(atendimentoAtual.getServico().getValor() > 0) {
	            		temp += (atendimentoAtual.getServico().getValor() +
	                			(atendimentoAtual.getServico().getValor() * atendimentoAtual.getAnimal().getTaxa()));
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
		Set<Atendimento> atendimentos = atendimentoDAO.getAll();
		String resultado = "";

		Date data1, data2;

		data1 = Util.stringParaDate(inicio);
		data2 = Util.stringParaDate(fim);

		for(Iterator<Atendimento> iter = atendimentos.iterator();iter.hasNext();) {
        	Atendimento atendimentoAtual = iter.next();
            if((atendimentoAtual.getDate().after(data1) || atendimentoAtual.getDate().equals(data1))
   				 && (atendimentoAtual.getDate().before(data2) || atendimentoAtual.getDate().equals(data2))) {
            	resultado += ("Atendimento: "+atendimentoAtual.getCodigo()
						+" "+atendimentoAtual.getAnimal().getNome()
						+" - "+atendimentoAtual.getServico().getNome()
						+" R$"+atendimentoAtual.getServico().getValor()+"\n");
				exist = true;
            }
        }	
		if(exist == false){
			throw new Error ("Não há atendimentos no período informado!");
		}

		return resultado;
	}

	private String listaAtendimentos(int codigo){	
		String resultado = "";

		Set<Atendimento> listaAtendimentos = atendimentoDAO.getAll();

		for(Iterator<Atendimento> iter = listaAtendimentos.iterator();iter.hasNext();) {
        	Atendimento atendimentoAtual = iter.next();
            if(atendimentoAtual.getAnimal().getCodigo() == codigo) {
            	resultado +=  String.format("# Serviço: %s\tValor:%.2f\n", atendimentoAtual.getServico().getNome(),
            			(atendimentoAtual.getServico().getValor() + 
            					(atendimentoAtual.getServico().getValor() * atendimentoAtual.getAnimal().getTaxa())));
            	
            }
        }
		return resultado;
	}

	public Set<Atendimento> getAll(){
		return atendimentoDAO.getAll();
	}

}
