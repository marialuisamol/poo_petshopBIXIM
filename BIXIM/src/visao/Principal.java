package visao;

import bd.BancoDeDados;
import model.Animal;
import model.Atendimento;
import model.Cachorro;
import model.Gato;
import model.Servico;
import service.AnimalService;
import service.AtendimentoService;
import service.ServicoService;
import util.Login;
import util.Util;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;


public class Principal {
	
	public static AnimalService animalService = new AnimalService();
	public static ServicoService servicoService = new ServicoService();
	public static AtendimentoService atendimentoService = new AtendimentoService();
	
	public static void main(String[] args) {
		
		
		
		System.out.println("#########################################################\n"
						 + "#         Bem vindo ao sistema de petshop BIXIM         #\n"
						 + "# Usuário: ");
		String user = Util.leString();
		
		System.out.println("# Senha: ");
		String senha = Util.leString();
		
		boolean log = Login.logar(user, senha);
		
		if(log == false) {
			
			System.out.println("# ERRO! - Usuário ou senha inválidos!                   #\n"
							 + "#########################################################");
			System.exit(0);
		}
		
		
		int op = 0, op1 = 0, op2 = 0;
		
		do {
			
			System.out.println("#########################################################\n"
							 + "#                      MENU DE OPÇÕES                   #\n"
							 + "# 1- Cadastro de animal.                                #\n"
							 + "# 2- Cadastro de serviços.                              #\n"
							 + "# 3- Lançamento de atendimentos.                        #\n"
							 + "# 4- Listar dados dos animais.                          #\n"
							 + "# 5- Listar dados dos serviços.                         #\n"
							 + "# 6- Listar atendimentos cadastrados.                   #\n"
							 + "# 7- Emitir nota fiscal.                                #\n"
							 + "# 8- Limpar banco de dados.                             #\n"
							 + "# 9- Relatório - Maior valor do atendimento do animal.  #\n"
							 + "# 10- Relatório - Menor valor do atendimento do animal. #\n"
							 + "# 11- Relatório - Totalizar os atendimentos do animal.  #\n"
							 + "# 12- Relatório - Atendimento entre um período.         #\n"
							 + "# Digite zero para terminar.                            #\n"
							 + "#########################################################\n");
			
			op = Util.leInteiro();
			
			switch (op) {
			case 1: {
				
				do {
					System.out.println("#########################################################\n"
									 + "#                   CADASTRO DE ANIMAL                  #\n"
									 + "#                MENU DE OPÇÕES DO ANIMAL               #\n"
							 		 + "# 1- Inserir animal.                                    #\n"
							 		 + "# 2- Deletar animal.                                    #\n"
							 		 + "# 3- Alterar animal.                                    #\n"
							 		 + "# Digite zero para voltar ao menu anterior.             #\n"
							 		 + "#########################################################\n");
					op1 = Util.leInteiro();
					try {
						switch(op1) {
						
						case 1: {
							Cachorro dog = new Cachorro();
							System.out.println("#########################################################\n"
											 + "#                   CADASTRO DE ANIMAL                  #\n"
											 + "# Código do animal: ");
							dog.setCodigo(Util.leInteiro());
							
							System.out.println("# Nome do animal");
							dog.setNome(Util.leString());
							
							System.out.println("# Endereço do animal: ");
							dog.setEndereco(Util.leString());
							
							System.out.println("# Cidade do animal: ");
							dog.setCidade(Util.leString());
							
							System.out.println("# Tipo: 1) Cachorro. 2) Gato. ");
							int tipo = Util.leInteiro();
							if(tipo == 1) {
								 System.out.println("# Tem pedigree? (true ou false). ");
								 boolean ped = Util.leBoolean();
								 Cachorro cachorro = new Cachorro(dog.getCodigo(),
									 							  dog.getNome(),
									 							  dog.getEndereco(),
									 							  dog.getCidade(),
									 							  ped);
								 animalService.inserir(cachorro);
							}else if(tipo == 2) {
								System.out.println("# Tipo documento do dono: 1) CPF.  2) CNPJ. ");
								tipo = Util.leInteiro();
								Gato gato = null;
								System.out.println("# Número do documento do dono: ");
								if(tipo == 1) {
									String cpf = Util.leString();
									while(!Util.cpfValido(cpf)) {
										System.out.println("# Erro ao digitar. Tente novamente.");
										cpf = Util.leString();
									}
									gato = new Gato(dog.getCodigo(),
													dog.getNome(),
													dog.getEndereco(),
													dog.getCidade(),
													cpf);
								}else if(tipo == 2) {
									String cnpj = Util.leString();
									while(!Util.cnpjValido(cnpj)) {
										System.out.println("# Erro ao digitar. Tente novamente.");
										cnpj = Util.leString();
									}
									gato = new Gato(dog.getCodigo(),
													dog.getNome(),
													dog.getEndereco(),
													dog.getCidade(),
													cnpj);
								}
								animalService.inserir(gato);
							}
							
							System.out.println("# Dados inseridos com sucesso!                          #");
							
							break;
							
						}//case 1
						
						case 2: {
							Cachorro dog = new Cachorro();
							System.out.println("#########################################################\n"
											 + "#                     DELETAR ANIMAL                    #\n"
											 + "# Código do animal: ");
							dog.setCodigo(Util.leInteiro());
							
							animalService.remover(dog.getCodigo());
							
							System.out.println("# Dados deletados com sucesso!                          #");
							
							break;
						}//case 2
						
						case 3: {
							Cachorro dog = new Cachorro();
							System.out.println("#########################################################\n"
											 + "#                     ALTERAR ANIMAL                    #\n"
											 + "# Código do animal: ");
							dog.setCodigo(Util.leInteiro());
							
							System.out.println("#########################################################\n"
											 + "#                       NOVOS DADOS                     #\n");
							
							System.out.println("# Nome do animal");
							dog.setNome(Util.leString());
							
							System.out.println("# Endereço do animal: ");
							dog.setEndereco(Util.leString());
							
							System.out.println("# Cidade do animal: ");
							dog.setCidade(Util.leString());
									
							animalService.alterar(dog.getCodigo(), dog);
							
							
							System.out.println("# Dados alterados com sucesso!                          #");
							
							
							break;
						}
						
						case 0: {
							break;
						}//case 0
						
						default:
							System.err.println("\n# Opção Inválida!                                       #\n"
											 + "#########################################################");
						}//default
						//FIM MENU ANIMAL
					} catch (Error e) {
						System.err.println("# " +e.getMessage());
					}
				}while(op1 != 0);
				break;
			}//case 1
			
				
			case 2: {
				
				do {
					System.out.println("#########################################################\n"
									 + "#                   CADASTRO DE SERVIÇO                 #\n"
									 + "#                MENU DE OPÇÕES DE SERVIÇO              #\n"
							 		 + "# 1- Inserir serviço.                                   #\n"
							 		 + "# 2- Deletar serviço.                                   #\n"
							 		 + "# 3- Alterar serviço.                                   #\n"
							 		 + "# Digite zero para voltar ao menu anterior.             #\n"
							 		 + "#########################################################\n");
					op2 = Util.leInteiro();
					
					try {
						switch(op2) {
						
						case 1: {
							Servico servico = new Servico();
							
							System.out.println("#########################################################\n"
									 + "#                   CADASTRO DE SERVIÇO                 #\n"
									 + "# Código do serviço: ");
							
							servico.setCodigo(Util.leInteiro());
							
							System.out.println("# Descrição do serviço: ");
							servico.setNome(Util.leString());
							
							System.out.println("# Valor do serviço: ");
							servico.setValor(Util.leFloat());
							
							
							servicoService.inserir(servico);
							
							System.out.println("# Dados inseridos com sucesso!                          #");
							
							
							break;
						}//case 1
						
						case 2:{
							
							Servico servico = new Servico();
							System.out.println("#########################################################\n"
											 + "#                    DELETAR SERVIÇO                    #\n"
											 + "# Código do serviço: ");
							servico.setCodigo(Util.leInteiro());
							
							servicoService.remover(servico.getCodigo());
							
							System.out.println("# Dados excluído com sucesso!                           #");
							
							
							break;
						}//case 2
						
						case 3:{
							
							Servico servico = new Servico();
							System.out.println("#########################################################\n"
											 + "#                    ALTERAR SERVIÇO                    #\n"
											 + "# Código do serviço: ");
							servico.setCodigo(Util.leInteiro());
							
							System.out.println("#########################################################\n"
									 		 + "#                       NOVOS DADOS                     #\n");
							
							System.out.println("# Descrição do serviço: ");
							servico.setNome(Util.leString());
							
							System.out.println("# Valor do serviço: ");
							servico.setValor(Util.leFloat());
							
							servicoService.alterar(servico.getCodigo(),servico);
							
							System.out.println("# Dados alterados com sucesso!                          #");
							
							
							break;
						}
						
						case 0: {
							break;
						}//case 0
						
						default:
							System.err.println("\n# Opção Inválida!                                       #\n"
											   + "#########################################################");
						}//default
						//FIM MENU SERVIÇO
					}
					catch (Error e){
						System.err.println("# " + e.getMessage());
					}
					
				}while(op2 != 0);
				break;
			}//case 2
			
			case 3: {
				try {
					Atendimento atendimento = new Atendimento();
					
					System.out.println("#########################################################\n"
									 + "#               LANÇAMENTO DE ATENDIMENTOS              #\n");
					
					System.out.println("# Código do atendimento: ");
					atendimento.setCodigo(Util.leInteiro());
					while(true) {
						System.out.println("# Código do animal: ");
						int codigo = Util.leInteiro();
						
						Animal animal = animalService.getAnimal(codigo);
						
						if(animal != null) {
							atendimento.setAnimal(animal);
							break;
						}
						else {
							System.err.println("# Animal não encontrado. Tente novamente!               #");
						}
					}
					
					while(true) {
						System.out.println("# Código do serviço: ");
						int codigo = Util.leInteiro();
						
						Servico servico = servicoService.getServico(codigo);
						
						if(servico != null) {
							atendimento.setServico(servico);
							break;
						}
						else {
							System.err.println("# Serviço não encontrado. Tente novamente!              #");
						}
					}
					
					System.out.println("# Data do atendimento: ");
					atendimento.setDate(Util.leData());
		
					
					atendimentoService.inserir(atendimento);
					
					System.out.println("# Dados inseridos com sucesso!                          #");
				}
				catch (Error e){
					System.err.println("# " + e.getMessage());
				}
				break;
			}//case 3
			
			case 4: {
				System.out.println("#########################################################\n"
								 + "#                LISTAR DADOS DOS ANIMAIS               #\n");
				
				System.out.println("# Deseja realmente imprimir o relatório? (s/n)          #\n");
				char carac = Util.leChar();
				
				if(carac == 'n' || carac == 'N') {
					break;
				}
				else if(carac == 's' || carac == 'S') {
					Set<Animal> lista = BancoDeDados.getAnimais();
			        for(Iterator<Animal> iter = lista.iterator();iter.hasNext();) {
			            Animal animalAtual = iter.next();
			            System.out.println(animalAtual);
			        }
				}
				else {
					System.err.println("# Caractere inválido!                                   #\n");
				}
				
				break;
			}//case 4
			
			case 5: {
				System.out.println("#########################################################\n"
								 + "#                LISTAR DADOS DOS SERVIÇOS              #\n");
				
				System.out.println("# Deseja realmente imprimir o relatório? (s/n)          #\n");
				char carac = Util.leChar();
				
				if(carac == 'n' || carac == 'N') {
					break;
				}
				else if(carac == 's' || carac == 'S') {
					Set<Servico> lista = BancoDeDados.getServicos();
			        for(Iterator<Servico> iter = lista.iterator();iter.hasNext();) {
			            Servico servicoAtual = iter.next();
			            System.out.println(servicoAtual);
			        }
				}
				else {
					System.err.println("# Caractere inválido!                                   #\n");
				}
				break;
			}//case 5
			
			case 6: {
				System.out.println("#########################################################\n"
								 + "#           LISTAR ATENDIMENTOS CADASTRADOS             #\n");
				
				System.out.println("# Deseja realmente imprimir o relatório? (s/n)          #\n");
				char carac = Util.leChar();
				
				if(carac == 'n' || carac == 'N') {
					break;
				}
				else if(carac == 's' || carac == 'S') {
					Set<Atendimento> lista = BancoDeDados.getAtendimentos();
			        for(Iterator<Atendimento> iter = lista.iterator();iter.hasNext();) {
			            Atendimento atendimentoAtual = iter.next();
			            System.out.println(atendimentoAtual);
			        }
				}
				else {
					System.err.println("# Caractere inválido!                                   #\n");
				}
				
				break;
			}//case 6
			
			case 7:{
				System.out.println("#########################################################\n"
								 + "#                   EMITIR NOTA FISCAL                  #\n");
				System.out.println("# Deseja realmente emitir nota fiscal? (s/n)            #\n");
				char carac = Util.leChar();
				
				if(carac == 'n' || carac == 'N') {
					break;
				}
				else if(carac == 's' || carac == 'S') {
					System.out.println("# Digite o código do animal: ");
					int codigo = Util.leInteiro();
					try {
						String notaFiscal = atendimentoService.getNotaFiscal(codigo);
						System.out.println(notaFiscal);
					}
					catch (Error e){
						System.err.println(("# ") + e.getMessage());
					}
				}
				else {
					System.err.println("# Caractere inválido!                                   #\n");
				}
				
				break;
			}//case 7
			
			case 8: {
				System.out.println("#########################################################\n"
								 + "#                 LIMPAR BANCO DE DADOS                 #\n");
				System.out.println("# Deseja realmente limpar o banco de dados? (s/n)       #\n");
				char carac = Util.leChar();
				
				if(carac == 'n' || carac == 'N') {
					break;
				}
				else if(carac == 's' || carac == 'S') {
					
					animalService.limpaDados();
					servicoService.limpaDados();
					atendimentoService.limpaDados();
				}
				else {
					System.err.println("# Caractere inválido!                                   #\n");
				}
				
				break;
			}//case 8
			
			case 9: {
				System.out.println("#########################################################\n"
								 + "#    RELATÓRIO - MAIOR VALOR DO ATENDIMENTO DO ANIMAL   #\n");
				System.out.println("Insira o código do animal: "); 
				int codigo = Util.leInteiro(); 
				
				try{
					Atendimento atendimento = atendimentoService.getMaiorAtendimento(codigo);
					System.out.print(String.format("# Maior valor de atendimento:                           #\n"
									 + "# Código: %d\n"
									 + "# Animal: %s\n"
									 + "# Serviço: %s\n"
									 + "# Valor: R$%.2f\n"
									 + "# Data: %s\n",
									 atendimento.getCodigo(),
									 atendimento.getAnimal().getNome(),
									 atendimento.getServico().getNome(),
									 (atendimento.getServico().getValor() + (atendimento.getServico().getValor() * atendimento.getAnimal().getTaxa())),
									 atendimento.getDate()));
				}
				catch(Error e){
					System.err.println("# " + e.getMessage());
				}
				

				break;
			}//case 9
			
			case 10: {
				System.out.println("#########################################################\n"
								 + "#    RELATÓRIO - MENOR VALOR DO ATENDIMENTO DO ANIMAL   #\n");
				System.out.println("# Insira o código do animal: "); 
				int codigo = Util.leInteiro(); 
				
				try{
					Atendimento atendimento = atendimentoService.getMaiorAtendimento(codigo);
					System.out.print(String.format("# Menor valor de atendimento:                           #\n"
									 + "# Código: %d\n"
									 + "# Animal: %s\n"
									 + "# Serviço: %s\n"
									 + "# Valor: R$%.2f\n"
									 + "# Data: %s\n",
									 atendimento.getCodigo(),
									 atendimento.getAnimal().getNome(),
									 atendimento.getServico().getNome(),
									 (atendimento.getServico().getValor() + (atendimento.getServico().getValor() * atendimento.getAnimal().getTaxa())),
									 atendimento.getDate()));
				}
				catch(Error e){
					System.err.println("# " + e.getMessage());
				}

				break;
			}//case 10
			
			case 11: {
				System.out.println("#########################################################\n"
								 + "#    RELATÓRIO - TOTALIZAR OS ATENDIMENTOS DO ANIMAL    #\n");
				System.out.println("# Insira o código do animal: "); 
				int codigo = Util.leInteiro(); 
				
				try{
					float total = atendimentoService.getTotalDosAtendimentos(codigo);
					System.out.println(String.format("# Total dos atendimentos ao animal: R$%.2f", total));
				}
				catch(Error e){
					System.err.println("# " + e.getMessage());
				}

				break;
			}//case 11
			case 12:
				System.out.println("#########################################################\n"
						 		 + "#    RELATÓRIO - ATENDIMENTO ENTRE UM PERÍODO           #\n");
				System.out.println("# Insira a data incial: ");
				Date data1 = Util.leData();
				System.out.println("# Insira a data final: ");
				Date data2 = Util.leData();
				System.out.println("# RELATÓRIO - ATENDIMENTOS NO PERÍODO: ");

				String inicio = Util.dateParaString(data1);
				String fim = Util.dateParaString(data2);
				
				try{
					System.out.println(atendimentoService.getAtendimentoPorPeriodo(inicio, fim));
				}
				
				catch (Error e) {
					System.err.println("# " + e.getMessage());
				}

				break;
			case 0: {
				System.exit(0);
				break;
			}//case 0
				
			default:
				System.err.println("\n# Opção Inválida!                                       #\n"
								   + "#########################################################");
			}//default
			
		} while (op != 0);
	}//switch

}
