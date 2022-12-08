package dao;

import java.util.HashSet;
import java.util.Set;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

import bd.BancoDeDados;
import model.Animal;

public class AnimalDAO {
	
	private MongoCollection<Animal> animais;
	
	public AnimalDAO() {
		BancoDeDados.getInstance();
		animais = BancoDeDados.getAnimais();
	}
	
	public void inserir(Animal animal) {

		animais.insertOne(animal);
	}
	
	public void alterar(int codigo, Animal animal) {

		animais.updateOne(Filters.eq("codigo", codigo), Document.parse(animal.toJson()));
	}
	
	public void remover(int codigo) {

		animais.deleteOne(Filters.eq("codigo", codigo));
        
	}
	
	public void limpaDados() {
		animais.drop();	
	}
	
	
	public Animal getAnimal(int codigo) {	
		
		Animal animal = animais.find(Filters.eq("codigo", codigo)).first();
		
		return animal;
	}
	
	public Set<Animal> getAll() {
		
		FindIterable<Animal> cursor = animais.find();
		Set<Animal> listaAll = cursor.into(new HashSet<>());
		
		return listaAll;
	}
	
}
