package visao;

import util.Login;
import util.Util;

public class Principal {

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
						
					}
					
					case 0: {
						break;
					}
					
					default:
						throw new IllegalArgumentException("# Opção Inválida!                                       #\n"
														 + "#########################################################");
					}
					//FIM MENU ANIMAL
					
				}while(op1 != 0);
				break;
			}
			
				
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
						
					}
					
					case 0: {
						break;
					}
					
					default:
						throw new IllegalArgumentException("# Opção Inválida!                                       #\n"
														 + "#########################################################");
					}
					//FIM MENU SERVIÇO
					
				}while(op2 != 0);
				break;
			}
			
			case 3: {
				System.out.println("#########################################################\n"
								 + "#               LANÇAMENTO DE ATENDIMENTOS              #\n");
			}
			
			case 4: {
				System.out.println("#########################################################\n"
								 + "#                LISTAR DADOS DOS ANIMAIS               #\n");
			}
			
			case 5: {
				System.out.println("#########################################################\n"
								 + "#                LISTAR DADOS DOS SERVIÇOS              #\n");
			}
			
			case 6: {
				System.out.println("#########################################################\n"
								 + "#           LISTAR ATENDIMENTOS CADASTRADOS             #\n");
			}
			
			case 7:{
				System.out.println("#########################################################\n"
								 + "#                   EMITIR NOTA FISCAL                  #\n");
			}
			
			case 8: {
				System.out.println("#########################################################\n"
								 + "#                 LIMPAR BANCO DE DADOS                 #\n");
			}
			
			case 9: {
				System.out.println("#########################################################\n"
								 + "#    RELATÓRIO - MAIOR VALOR DO ATENDIMENTO DO ANIMAL   #\n");
			}
			
			case 10: {
				System.out.println("#########################################################\n"
								 + "#    RELATÓRIO - MENOR VALOR DO ATENDIMENTO DO ANIMAL   #\n");
			}
			
			case 11: {
				System.out.println("#########################################################\n"
								 + "#    RELATÓRIO - TOTALIZAR OS ATENDIMENTOS DO ANIMAL    #\n");
			}
			
			case 0: {
				System.exit(0);
				break;
			}
				
			default:
				throw new IllegalArgumentException("# Opção Inválida!                                       #\n"
												 + "#########################################################");
			}
			
		} while (op != 0);
	}

}
