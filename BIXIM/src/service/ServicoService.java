package service;

import java.util.Set;
import dao.ServicoDAO;
import model.Servico;

public class ServicoService {
	
	private ServicoDAO servicoDAO;
	
	public ServicoService() {
		servicoDAO = new ServicoDAO();
	}
	
	public void inserir(Servico servico) {
		
		servicoDAO.inserir(servico);	
	}
	
	public void alterar(int codigo, Servico servico) {
		
		servicoDAO.alterar(codigo, servico);	
	}
	
	public void remover(int codigo) {
		servicoDAO.remover(codigo);
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
	
	public Set<Servico> getAll(){
		return servicoDAO.getAll();
	}
}
