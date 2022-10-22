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
		
		while (i < animais.length) {
			if(animais[i] == null) {
				animais[i] = animal;
				return true;
			}	
			
			i++;			
		}
		
		return false;
	}
	
	public boolean alterar(int codigo, Animal animal) {
		
		for(int i = 0; i < animais.length; i++) {
			if (animais[i].getCodigo() == codigo) {
				
				animais[i] = animal;
				return true;
			}
		}
		return false;
	
	}
	
	public boolean remover(int codigo) {
		
		for(int i = 0; i < animais.length; i++) {
			if (animais[i].getCodigo() == codigo) {
				
				animais[i] = null;
				return true;
			}
		}
		return false;
	}
	
	public void limpaDados() {
		
		animais = new Animal[animais.length];
		
	}
	
	public Animal getAnimal(int codigo) {
		
		int i = 0;
		
		while(i < animais.length) {
			if(codigo == animais[i].getCodigo()) {
				return animais[i];
			}
			i++;
		}
		return null;		
	}
	
	public Animal[] getAll() {
		return animais;
	}

}
