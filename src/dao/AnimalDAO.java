package dao;

import bd.BancoDeDados;
import model.Animal;

public class AnimalDAO {
	
	private Animal[] animais;
	
	public AnimalDAO() {
		animais = BancoDeDados.getAnimais();
	}
	
	public boolean inserir(Animal animal) {
		int i = 0;
		
		while (i < 10) {
			if(animais[i] == null) {
				animais[i] = animal;
				
				return true;
				break;
			}
			i = i + 1;
		}
		if(i == 10) {
			
			return false;
		}
	}
	
	public boolean alterar(int codigo, Animal animal) {
		
	}
	
	public boolean remover(int codigo) {
		
	}
	
	public void limpaDados() {
		
	}
	
	public Animal getAnimal(int codigo) {
		return animais[codigo];
	}
	
	public Animal[] getAll() {
		return animais;
	}

}
