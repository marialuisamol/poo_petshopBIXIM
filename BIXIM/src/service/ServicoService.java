package service;

import dao.ServicoDAO;
import model.Servico;

public class ServicoService {
	
	private ServicoDAO servicoDAO;
	
	public ServicoService() {
		servicoDAO = new ServicoDAO();
	}
	
	public boolean inserir(Servico servico) {
		if(this.getServico(servico.getCodigo()) != null) {
			throw new Error("Código existente!");
		}
		boolean sucesso = servicoDAO.inserir(servico);
		
		if(sucesso == false) {
			throw new Error("Não há espaço suficiente!");
		}
		return sucesso;
	}
	
	public boolean alterar(int codigo, Servico servico) {
		if(this.getServico(servico.getCodigo()) != null) {
			throw new Error("Código existente!");
		}
		boolean sucesso = servicoDAO.alterar(codigo, servico);
		
		if(sucesso == false) {
			throw new Error("Código não encontrado!");
		}
		return sucesso;
	}
	
	public boolean remover(int codigo) {
		boolean sucesso = servicoDAO.remover(codigo);
		
		if(sucesso == false) {
			throw new Error("Código não encontrado!");
		}
		return sucesso;
	}
	
	public void limpaDados() {
		servicoDAO.limpaDados();
	}
	
	public Servico getServico(int codigo) {
		return servicoDAO.getServico(codigo);
	}

	@Override
	public String toString() {
		return "ServicoService [servicoDAO=" + servicoDAO + "]";
	}
	
	
}
