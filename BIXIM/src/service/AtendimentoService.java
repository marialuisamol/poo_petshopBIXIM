package service;

import dao.AtendimentoDAO;
import model.Animal;
import model.Atendimento;

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

}
