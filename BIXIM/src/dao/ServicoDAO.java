package dao;


import java.util.Iterator;
import java.util.Set;

import bd.BancoDeDados;
import model.Servico;

public class ServicoDAO {
	
	private Set<Servico> servicos;
	
	public ServicoDAO() {
		servicos = BancoDeDados.getServicos();
	}
	
	public boolean inserir(Servico servico) {
		return servicos.add(servico);
	}
	
	public boolean alterar(int codigo, Servico servico) {
        for(Iterator<Servico> iter = servicos.iterator();iter.hasNext();) {
            Servico servicoAtual = iter.next();
            if(servicoAtual.getCodigo() == codigo) {
            	servicoAtual = servico;
            	return true;
            }
        }
		return false;
	}
	
	public boolean remover(int codigo) {
        for(Iterator<Servico> iter = servicos.iterator();iter.hasNext();) {
            Servico servicoAtual = iter.next();
            if(servicoAtual.getCodigo() == codigo) {
            	return servicos.remove(servicoAtual);
            }
        }
		return false;
	}
	
	public void limpaDados() {
		servicos.removeAll(servicos);
	}
	
	public Servico getServico(int codigo) {
        for(Iterator<Servico> iter = servicos.iterator();iter.hasNext();) {
            Servico servicoAtual = iter.next();
            if(servicoAtual.getCodigo() == codigo) {
            	return servicoAtual;
            }
        }
		return null;
	}
	
	public Set<Servico> getAll() {
		return servicos;
	}
}
