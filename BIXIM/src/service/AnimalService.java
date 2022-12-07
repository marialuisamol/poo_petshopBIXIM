package service;

import dao.AnimalDAO;
import model.Animal;

public class AnimalService {
	
	private AnimalDAO animalDAO;
	
	public AnimalService() {
		animalDAO = new AnimalDAO();
	}
	
	public boolean inserir(Animal animal){
		if (this.getAnimal(animal.getCodigo()) != null) {
			throw new Error("Código existente!");
		}
		boolean sucesso = animalDAO.inserir(animal);
		if(sucesso == false) {
			throw new Error("Não há espaço suficiente!");
		}
		return sucesso;
	}
	public boolean alterar(int codigo, Animal animal) {
		boolean sucesso = animalDAO.alterar(codigo, animal);
		if(sucesso == false) {
			throw new Error("Código não encontrado!");
		}
		return sucesso;
	}
	public boolean remover(int codigo) {
		boolean sucesso = animalDAO.remover(codigo);
		if(sucesso == false) {
			throw new Error("Código não encontrado!");
		}
		return sucesso;
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
	
	
}
