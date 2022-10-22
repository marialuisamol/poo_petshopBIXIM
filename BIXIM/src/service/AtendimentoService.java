package service;

import dao.AtendimentoDAO;
import model.Atendimento;

public class AtendimentoService {
	
	private AtendimentoDAO atendimentoDAO;
	
	public AtendimentoService() {
		atendimentoDAO = new AtendimentoDAO();
	}
	
	public boolean inserir(Atendimento atendimento){
		return atendimentoDAO.inserir(atendimento);
	}
	public boolean alterar(int codigo, Atendimento atendimento) {
		return atendimentoDAO.alterar(codigo, atendimento);
	}
	public boolean remover(int codigo) {
		return atendimentoDAO.remover(codigo);
	}
	public void limpaDados(int codigo) {
		atendimentoDAO.limpaDados();
	}
	public Atendimento getAnimal(int codigo) {
		return atendimentoDAO.getAtendimento(codigo);
	}

	@Override
	public String toString() {
		return "AnimalService [atendimentoDAO=" + atendimentoDAO + "]";
	}
	
	

}
