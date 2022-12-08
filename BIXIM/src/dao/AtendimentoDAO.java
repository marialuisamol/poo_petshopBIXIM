package dao;

import java.util.HashSet;
import java.util.Set;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

import bd.BancoDeDados;
import model.Atendimento;

public class AtendimentoDAO {
	
	private MongoCollection<Atendimento> atendimentos;
	
	public AtendimentoDAO() {
		BancoDeDados.getInstance();
		atendimentos = BancoDeDados.getAtendimentos();
	}
	
	public void inserir(Atendimento atendimento) {


		atendimentos.insertOne(atendimento);
	}
	
	public void alterar(int codigo, Atendimento atendimento) {
        
		atendimentos.updateOne(Filters.eq("codigo", codigo), Document.parse(atendimento.toJson()));
	
	}
	
	public void remover(int codigo) {
        atendimentos.deleteOne(Filters.eq("codigo", codigo));
        
	}
	
	
	public void limpaDados() {
		atendimentos.drop();
	}
	
	
	public Atendimento getAtendimento(int codigo) {

		Atendimento atendimento = atendimentos.find(Filters.eq("codigo", codigo)).first();
		
		return atendimento;
	}
	
	public Set<Atendimento> getAll() {
		
		FindIterable<Atendimento> cursor = atendimentos.find();
		Set<Atendimento> listaAll = cursor.into(new HashSet<>());
		
		return listaAll;
	}

}
