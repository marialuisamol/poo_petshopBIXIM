package service;

import dao.AtendimentoDAO;
import model.Atendimento;

public class AtendimentoService {
	
	private AtendimentoDAO atendimentoDAO;
	private AnimalService animalService;
	private ServicoService servicoService;
	
	public AtendimentoService() {
		atendimentoDAO = new AtendimentoDAO();
		animalService = new AnimalService();
		servicoService = new ServicoService();
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
		return "AnimalService [atendimentoDAO=" + atendimentoDAO + "]";
	}
	
	public String getNotaFiscal(int codigo) {
		
	}
	

}
