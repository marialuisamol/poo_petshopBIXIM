package service;

import java.util.Set;


import dao.AnimalDAO;
import model.Animal;

public class AnimalService {
	
	private AnimalDAO animalDAO;
	
	public AnimalService() {
		animalDAO = new AnimalDAO();
	}
	
	public void inserir(Animal animal){
		if (this.getAnimal(animal.getCodigo()) != null) {
			
		}
		animalDAO.inserir(animal);
	}

	public void alterar(int codigo, Animal animal) {
		animalDAO.alterar(codigo, animal);
		
	}
	public void remover(int codigo) {
		animalDAO.remover(codigo);
		
	}
	
	public void limpaDados() {
		animalDAO.limpaDados();
	}
	
	
	public Animal getAnimal(int codigo) {
		return animalDAO.getAnimal(codigo);
	}


	@Override
	public String toString() {
		return "AnimalService [animalDAO=" + animalDAO + "]";
	}
	
	public Set<Animal> getAll(){
		return animalDAO.getAll();
	}
}
