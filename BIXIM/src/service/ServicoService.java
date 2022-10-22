package service;

import dao.ServicoDAO;
import model.Servico;

public class ServicoService {
	
	private ServicoDAO servicoDAO;
	
	public ServicoService() {
		
	}
	
	public boolean inserir(Servico servico) {
		return servicoDAO.inserir(servico);
	}
	
	public boolean alterar(int codigo, Servico servico) {
		return servicoDAO.alterar(codigo, servico);
	}
	
	public boolean remover(int codigo) {
		return servicoDAO.remover(codigo);
	}
	
	public void limpaDados() {
		
	}
	
	public Servico getServico(int codigo) {
		return servicoDAO.getServico(codigo);
	}

	@Override
	public String toString() {
		return "ServicoService [servicoDAO=" + servicoDAO + "]";
	}
	
	
}
