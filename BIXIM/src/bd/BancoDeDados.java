package bd;

import com.mongodb.client.MongoCollection;

import model.Animal;
import model.Atendimento;
import model.Servico;


public class BancoDeDados {

	private static MongoCollection<Animal> animais;
	private static MongoCollection<Servico> servicos;
	private static MongoCollection<Atendimento> atendimentos;
	private static BancoDeDados bancoDeDados;


	private BancoDeDados() {
		animais = MongoConnection.getInstance().getDB().getCollection("animais", Animal.class); 
		servicos = MongoConnection.getInstance().getDB().getCollection("servicos", Servico.class);
		atendimentos = MongoConnection.getInstance().getDB().getCollection("atendimentos", Atendimento.class);
	}
	
	public static BancoDeDados getInstance() {
		
		if(bancoDeDados == null) {
			bancoDeDados = new BancoDeDados();
		}
		return bancoDeDados;
	}

	public static MongoCollection<Animal> getAnimais() {
		return animais;
	}

	public static MongoCollection<Servico> getServicos() {
		return servicos;
	}

	public static MongoCollection<Atendimento> getAtendimentos() {
		return atendimentos;
	}
   
}
