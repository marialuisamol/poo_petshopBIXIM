package bd;

import model.Animal;
import model.Atendimento;
import model.Servico;

public class BancoDeDados {
	
	private Animal[] animais;
	private Servico[] servicos;
	private Atendimento[] atendimentos;
	private static BancoDeDados bancoDeDados;
	
	private BancoDeDados() {
		animais = new Animal[10];
		servicos = new Servico[10];
		atendimentos = new Atendimento[20];
	}
	
	public static BancoDeDados getInstance() {
		
		if(bancoDeDados == null) {
			bancoDeDados = new BancoDeDados();
		}
		return bancoDeDados;
	}
	
	public static Animal[] getAnimais() {
		
		return getInstance().animais;
	}
	
	public static Servico[] getServicos() {
		return getInstance().servicos;
	}
	
	public static Atendimento[] getAtendimentos() {
		return getInstance().atendimentos;
	}
}
