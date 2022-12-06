package dao;

import java.util.Iterator;
import java.util.Set;

import bd.BancoDeDados;
import model.Atendimento;

public class AtendimentoDAO {
	
	private Set<Atendimento> atendimentos;
	
	public AtendimentoDAO() {
		BancoDeDados.getInstance();
		atendimentos = BancoDeDados.getAtendimentos();
	}
	
	public boolean inserir(Atendimento atendimento) {
		return atendimentos.add(atendimento);
	}
	
	public boolean alterar(int codigo, Atendimento atendimento) {
        for(Iterator<Atendimento> iter = atendimentos.iterator();iter.hasNext();) {
            Atendimento atendimentoAtual = iter.next();
            if(atendimentoAtual.getCodigo() == codigo) {
            	atendimentoAtual = atendimento;
            	return true;
            }
        }
		return false;
	}
	
	public boolean remover(int codigo) {
        for(Iterator<Atendimento> iter = atendimentos.iterator();iter.hasNext();) {
            Atendimento atendimentoAtual = iter.next();
            if(atendimentoAtual.getCodigo() == codigo) {
            	return atendimentos.remove(atendimentoAtual);
            }
        }
		return false;
	}
	
	public void limpaDados() {
		atendimentos.removeAll(atendimentos);
	}
	
	public Atendimento getAtendimento(int codigo) {
        for(Iterator<Atendimento> iter = atendimentos.iterator();iter.hasNext();) {
            Atendimento atendimentoAtual = iter.next();
            if(atendimentoAtual.getCodigo() == codigo) {
            	return atendimentoAtual;
            }
        }
		return null;
	}
	
	public Set<Atendimento> getAll() {
		return atendimentos;
	}

}
