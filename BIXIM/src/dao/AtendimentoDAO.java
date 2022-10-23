package dao;

import bd.BancoDeDados;
import model.Atendimento;

public class AtendimentoDAO {
	
	private Atendimento[] atendimentos;
	
	public AtendimentoDAO() {
		atendimentos = BancoDeDados.getAtendimentos();
	}
	
	public boolean inserir(Atendimento atendimento) {
		
		int i = 0;
		
		while (i < atendimentos.length) {
			
			if(atendimentos[i] == null) {
				atendimento.setCodigo(i + 100);
				atendimentos[i] = atendimento;
				return true;
			}
			i++;
		}
		return false;
	}
	
	public boolean alterar(int codigo, Atendimento atendimento) {
		
		for(int i = 0; i < atendimentos.length; i++) {
			if (atendimentos[i] != null && atendimentos[i].getCodigo() == codigo) {
				
				atendimentos[i] = atendimento;
				return true;
			}
		}
		return false;
	}
	
	public boolean remover(int codigo) {
		
		for(int i = 0; i < atendimentos.length; i++) {
			if (atendimentos[i] != null && atendimentos[i].getCodigo() == codigo) {
				
				atendimentos[i] = null;
				return true;
			}
		}
		return false;
	
	}
	
	public void limpaDados() {
		
		for (int i = 0; i < atendimentos.length; i++) {
			atendimentos[i] = null;
		}
	}
	
	public Atendimento getAtendimento(int codigo) {
		
		for (int i = 0; i < atendimentos.length; i++) {
			if(atendimentos[i] != null && atendimentos[i].getCodigo() == codigo) {
				return atendimentos[i];
			}
		}
		
		return null;
	}
	
	public Atendimento[] getAll() {
		return atendimentos;
	}

}
