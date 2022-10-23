package dao;


import bd.BancoDeDados;
import model.Servico;

public class ServicoDAO {
	
	private Servico[] servicos;
	
	public ServicoDAO() {
		servicos = BancoDeDados.getServicos();
	}
	
	public boolean inserir(Servico servico) {
		
		for(int i = 0; i < servicos.length; i++) {
			if(servicos[i] == null) {
				servicos[i] = servico;
				return true;
			}
		}
		
		return false;
	}
	
	public boolean alterar(int codigo, Servico servico) {
		
		for(int i = 0; i < servicos.length; i++) {
			if (servicos[i] != null && servicos[i].getCodigo() == codigo) {
				
				servicos[i] = servico;
				return true;
			}
		}
		return false;
	}
	
	public boolean remover(int codigo) {
		
		for(int i = 0; i < servicos.length; i++) {
			if (servicos[i] != null && servicos[i].getCodigo() == codigo) {
				
				servicos[i] = null;
				return true;
			}
		}
		return false;
		
	}
	
	public void limpaDados() {
		for(int i = 0; i < servicos.length; i++) {
			
			servicos[i] = null;
		}
	}
	
	public Servico getServico(int codigo) {

		for(int i = 0; i < servicos.length; i++) {
			if(servicos[i] != null && servicos[i].getCodigo() == codigo) {
				
				return servicos[i];
			}
		}
		
		return null;
	}
	
	public Servico[] getAll() {
		return servicos;
	}
}
