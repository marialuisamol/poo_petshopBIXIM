package dao;

import java.util.Iterator;
import java.util.Set;

import bd.BancoDeDados;
import model.Animal;

public class AnimalDAO {
	
	private Set<Animal> animais;
	
	public AnimalDAO() {
		animais = BancoDeDados.getAnimais();
	}
	
	public boolean inserir(Animal animal) {
		return animais.add(animal);
	}
	
	public boolean alterar(int codigo, Animal animal) {
        for(Iterator<Animal> iter = animais.iterator();iter.hasNext();) {
            Animal animalAtual = iter.next();
            if(animalAtual.getCodigo() == codigo) {
            	animalAtual = animal;
            	return true;
            }
        }
		return false;
	}
	
	public boolean remover(int codigo) {
        for(Iterator<Animal> iter = animais.iterator();iter.hasNext();) {
            Animal animalAtual = iter.next();
            if(animalAtual.getCodigo() == codigo) {
            	return animais.remove(animalAtual);
            }
        }
		return false;
	}
	
	public void limpaDados() {
		animais.removeAll(animais);	
	}
	
	public Animal getAnimal(int codigo) {	
        for(Iterator<Animal> iter = animais.iterator();iter.hasNext();) {
            Animal animalAtual = iter.next();
            if(animalAtual.getCodigo() == codigo) {
            	return animalAtual;
            }
        }
		return null;		
	}
	
	public Set<Animal> getAll() {
		return animais;
	}

}
