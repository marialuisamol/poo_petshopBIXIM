package service;

import dao.AnimalDAO;
import model.Animal;

public class AnimalService {
	
	private AnimalDAO animalDAO;
	
	public AnimalService() {
		animalDAO = new AnimalDAO();
	}
	
	public boolean inserir(Animal animal){
		return animalDAO.inserir(animal);
	}
	public boolean alterar(int codigo, Animal animal) {
		return animalDAO.alterar(codigo, animal);
	}
	public boolean remover(int codigo) {
		return animalDAO.remover(codigo);
	}
	public void limpaDados(int codigo) {
		animalDAO.limpaDados();
	}
	public Animal getAnimal(int codigo) {
		return animalDAO.getAnimal(codigo);
	}

	@Override
	public String toString() {
		return "AnimalService [animalDAO=" + animalDAO + "]";
	}
	
	
}
