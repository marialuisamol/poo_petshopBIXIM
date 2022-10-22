package visao;

import bd.BancoDeDados;
import model.Animal;
import model.Atendimento;
import model.Servico;
import service.AnimalService;
import service.AtendimentoService;
import service.ServicoService;
import util.Login;
import util.Util;


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
							 + "# 1- Cadastro de animal                                 #\n"
							 + "# 2- Cadastro de serviços                               #\n"
							 + "# 3- Lançamento de atendimentos                         #\n"
							 + "# 4- Listar dados dos animais                           #\n"
							 + "# 5- Listar dados dos serviços                          #\n"
							 + "# 6- Listar atendimentos cadastrados                    #\n"
							 + "# 7- Emitir nota fiscal                                 #\n"
							 + "# 8- Limpar banco de dados                              #\n"
							 + "# 9- Relatório - Maior valor do atendimento do animal   #\n"
							 + "# 10- Relatório - Menor valor do atendimento do animal  #\n"
							 + "# 11- Relatório - Totalizar os atendimentos do animal   #\n"
							 + "# Digite zero para terminar                             #\n"
							 + "#########################################################\n");
			
			op = Util.leInteiro();
			
			switch (op) {
			case 1: {
				
				do {
					System.out.println("#########################################################\n"
									 + "#                   CADASTRO DE ANIMAL                  #\n"
									 + "#                MENU DE OPÇÕES DO ANIMAL               #\n"
							 		 + "# 1- Inserir animal                                     #\n"
							 		 + "# 2- Deletar animal                                     #\n"
							 		 + "# 3- Alterar animal                                     #\n"
							 		 + "# Digite zero para voltar ao menu anterior              #\n"
							 		 + "#########################################################\n");
					op1 = Util.leInteiro();
					
					switch(op1) {
					
					case 1: {
						Animal animal = new Animal();
						System.out.println("#########################################################\n"
										 + "#                   CADASTRO DE ANIMAL                  #\n"
										 + "# Código do animal: ");
						animal.setCodigo(Util.leInteiro());
						
						System.out.println("# Nome do animal");
						animal.setNome(Util.leString());
						
						System.out.println("# Endereço do animal: ");
						animal.setEndereco(Util.leString());
						
						System.out.println("# Cidade do animal: ");
						animal.setCidade(Util.leString());
						
						boolean sucesso = animalService.inserir(animal);
						
						if (sucesso == false) {
							System.out.println("# Não existe espaço suficiente.                         #");
						}
						else {
							System.out.println("# Dados inseridos com sucesso!                          #");
						}
						
						break;
						
					}//case 1
					
					case 2: {
						Animal animal = new Animal();
						System.out.println("#########################################################\n"
										 + "#                     DELETAR ANIMAL                    #\n"
										 + "# Código do animal: ");
						animal.setCodigo(Util.leInteiro());
						
						boolean sucesso = animalService.remover(animal.getCodigo());
						
						if (sucesso == false) {
							System.out.println("# Código não encontrado.                                #");
						}
						else {
							System.out.println("# Dados excluído com sucesso!                           #");
						}
						
						break;
					}//case 2
					
					case 3: {
						Animal animal = new Animal();
						System.out.println("#########################################################\n"
										 + "#                     ALTERAR ANIMAL                    #\n"
										 + "# Código do animal: ");
						animal.setCodigo(Util.leInteiro());
						
						System.out.println("#########################################################\n"
										 + "#                       NOVOS DADOS                     #\n");
						
						System.out.println("# Nome do animal");
						animal.setNome(Util.leString());
						
						System.out.println("# Endereço do animal: ");
						animal.setEndereco(Util.leString());
						
						System.out.println("# Cidade do animal: ");
						animal.setCidade(Util.leString());
								
						boolean sucesso = animalService.alterar(animal.getCodigo(), animal);
						
						if (sucesso == false) {
							System.out.println("# Código não encontrado.                                #");
						}
						else {
							System.out.println("# Dados alterados com sucesso!                          #");
						}
						
						break;
					}
					
					case 0: {
						break;
					}//case 0
					
					default:
						throw new IllegalArgumentException("# Opção Inválida!                                       #\n"
														 + "#########################################################");
					}//default
					//FIM MENU ANIMAL
					
				}while(op1 != 0);
				break;
			}//case 1
			
				
			case 2: {
				
				do {
					System.out.println("#########################################################\n"
									 + "#                   CADASTRO DE SERVIÇO                 #\n"
									 + "#                MENU DE OPÇÕES DE SERVIÇO              #\n"
							 		 + "# 1- Inserir serviço                                    #\n"
							 		 + "# 2- Deletar serviço                                    #\n"
							 		 + "# 3- Alterar serviço                                    #\n"
							 		 + "# Digite zero para voltar ao menu anterior              #\n"
							 		 + "#########################################################\n");
					op2 = Util.leInteiro();
					
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
						
						boolean sucesso = servicoService.inserir(servico);
						
						if(sucesso == false) {
							System.out.println("# Não existe espaço suficiente.                         #");
						}
						else {
							System.out.println("# Dados inseridos com sucesso!                          #");
						}
						
						break;
					}//case 1
					
					case 2:{
						
						Servico servico = new Servico();
						System.out.println("#########################################################\n"
										 + "#                    DELETAR SERVIÇO                    #\n"
										 + "# Código do serviço: ");
						servico.setCodigo(Util.leInteiro());
						
						boolean sucesso = servicoService.remover(servico.getCodigo());
						
						if (sucesso == false) {
							System.out.println("# Código não encontrado.                                #");
						}
						else {
							System.out.println("# Dados excluído com sucesso!                           #");
						}
						
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
						
						boolean sucesso = servicoService.remover(servico.getCodigo());
						
						if (sucesso == false) {
							System.out.println("# Código não encontrado.                                #");
						}
						else {
							System.out.println("# Dados excluído com sucesso!                           #");
						}
						
						break;
					}
					
					case 0: {
						break;
					}//case 0
					
					default:
						throw new IllegalArgumentException("# Opção Inválida!                                       #\n"
														 + "#########################################################");
					}//default
					//FIM MENU SERVIÇO
					
				}while(op2 != 0);
				break;
			}//case 2
			
			case 3: {
				
				Atendimento atendimento = new Atendimento();
				
				System.out.println("#########################################################\n"
								 + "#               LANÇAMENTO DE ATENDIMENTOS              #\n");
				while(true) {
					System.out.println("# Código do animal: ");
					int codigo = Util.leInteiro();
					
					Animal animal = animalService.getAnimal(codigo);
					
					if(animal != null) {
						atendimento.setAnimal(animal);
						break;
					}
					else {
						System.out.println("# Animal não encontrado. Tente novamente!               #");
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
						System.out.println("# Serviço não encontrado. Tente novamente!              #");
					}
				}
				
				System.out.println("# Data do atendimento: ");
				atendimento.setDate(Util.leData());
				
				boolean sucesso = atendimentoService.inserir(atendimento);
				
				if(sucesso == false) {
					System.out.println("# Não existe espaço suficiente!                         #");
				}
				else {
					System.out.println("# Dados inseridos com sucesso!                          #");
				}
				
				break;
			}//case 3
			
			case 4: {
				System.out.println("#########################################################\n"
								 + "#                LISTAR DADOS DOS ANIMAIS               #\n");
				
				Animal[] lista = BancoDeDados.getAnimais();
				for(int i = 0; i < lista.length; i++) {
					if (lista[i] == null) {
						continue;
				  }
					System.out.println(lista[i]);
				}
				
				break;
			}//case 4
			
			case 5: {
				System.out.println("#########################################################\n"
								 + "#                LISTAR DADOS DOS SERVIÇOS              #\n");
				
				Servico[] lista = BancoDeDados.getServicos();
				for(int i = 0; i < lista.length; i++) {
				  if (lista[i] == null) {
				    continue;
				  }

				  System.out.println(lista[i]);
				}
				break;
			}//case 5
			
			case 6: {
				System.out.println("#########################################################\n"
								 + "#           LISTAR ATENDIMENTOS CADASTRADOS             #\n");
				
				Atendimento[] lista = BancoDeDados.getAtendimentos();
				for(int i = 0; i < lista.length; i++) {
				  if (lista[i] == null) {
				    continue;
				  }

				  System.out.println(lista[i]);
				}
				
				break;
			}//case 6
			
			case 7:{
				System.out.println("#########################################################\n"
								 + "#                   EMITIR NOTA FISCAL                  #\n");
				
				break;
			}//case 7
			
			case 8: {
				System.out.println("#########################################################\n"
								 + "#                 LIMPAR BANCO DE DADOS                 #\n");
				
				break;
			}//case 8
			
			case 9: {
				System.out.println("#########################################################\n"
								 + "#    RELATÓRIO - MAIOR VALOR DO ATENDIMENTO DO ANIMAL   #\n");
				
				break;
			}//case 9
			
			case 10: {
				System.out.println("#########################################################\n"
								 + "#    RELATÓRIO - MENOR VALOR DO ATENDIMENTO DO ANIMAL   #\n");
				
				break;
			}//case 10
			
			case 11: {
				System.out.println("#########################################################\n"
								 + "#    RELATÓRIO - TOTALIZAR OS ATENDIMENTOS DO ANIMAL    #\n");
				
				break;
			}//case 11
			
			case 0: {
				System.exit(0);
				break;
			}//case 0
				
			default:
				throw new IllegalArgumentException("# Opção Inválida!                                       #\n"
												 + "#########################################################");
			}//default
			
		} while (op != 0);
	}//switch

}
