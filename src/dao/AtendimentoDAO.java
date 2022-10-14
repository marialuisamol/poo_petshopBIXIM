package dao;

import model.Animal;
import model.Atendimento;

public class AtendimentoDAO {
	
	private Atendimento[] atendimentos;
	
	public AtendimentoDAO() {
		
	}
	
	public boolean inserir(Atendimento atendimento) {
		
	}
	
	public boolean alterar(int codigo, Atendimento atendimento) {
		
	}
	
	public boolean remover(int codigo) {
		
	}
	
	public void limpaDados() {
		
	}
	
	public Atendimento getAtendimento(int codigo) {
		return atendimentos[codigo];
	}
	
	public Atendimento[] getAll() {
		return atendimentos;
	}

}
