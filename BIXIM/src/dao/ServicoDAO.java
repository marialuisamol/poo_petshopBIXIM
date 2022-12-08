package dao;

import java.util.HashSet;
import java.util.Set;
import org.bson.Document;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

import bd.BancoDeDados;
import model.Servico;

public class ServicoDAO {
	
	private MongoCollection<Servico> servicos;
	
	public ServicoDAO() {
		BancoDeDados.getInstance();
		servicos = BancoDeDados.getServicos();
	}
	
	public void inserir(Servico servico) {
		
		servicos.insertOne(servico);
	}
	
	public void alterar(int codigo, Servico servico) {
    
		servicos.updateOne(Filters.eq("codigo", codigo), Document.parse(servico.toJson()));
	}
	
	public void remover(int codigo) {

        servicos.deleteOne(Filters.eq("codigo", codigo));
	}
	
	public void limpaDados() {
		servicos.drop();
	}
	

	public Servico getServico(int codigo) {

		Servico servico = servicos.find(Filters.eq("codigo", codigo)).first();
		
		return servico;
	}
	
	public Set<Servico> getAll() {
		
		FindIterable<Servico> cursor = servicos.find();
		Set<Servico> listaAll = cursor.into(new HashSet<>());

		return listaAll;
	}

}
