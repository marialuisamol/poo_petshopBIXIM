package util;

import java.text.DateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Util {
	public static int leInteiro() {
		Scanner entrada;
		int valor = 0;
		boolean erro = true;
		while (erro) {
			try {
				entrada = new Scanner(System.in);
				valor = entrada.nextInt();
				erro = false;
			} catch (Exception e) {
				System.out.println("# Erro ao digitar. Tente novamente.");
				entrada = null;
			}
		}
		return valor;
	}

	public static float leFloat() {
		Scanner entrada;
		float valor = 0;
		boolean erro = true;
		while (erro) {
			try {
				entrada = new Scanner(System.in);
				valor = entrada.nextFloat();
				erro = false;
			} catch (Exception e) {
				System.out.println("# Erro ao digitar. Tente novamente.");
				entrada = null;
			}

		}
		return valor;
	}

	public static String leString() {
		Scanner entrada;
		String valor = "";
		boolean erro = true;
		while (erro) {
			try {
				entrada = new Scanner(System.in);
				valor = entrada.nextLine();
				erro = false;
			} catch (Exception e) {
				System.out.println("# Erro ao digitar. Tente novamente.");
				entrada = null;
			}
		}
		return valor;
	}

	public static char leChar() {
		Scanner entrada;
		char valor = 0;
		boolean erro = true;
		while (erro) {
			try {
				entrada = new Scanner(System.in);
				valor = entrada.next().charAt(0);
				erro = false;
			} catch (Exception e) {
				System.out.println("# Erro ao digitar. Tente novamente.");
				entrada = null;
			}
		}
		return valor;
	}
	
	public static boolean leBoolean() {
		Scanner entrada;
		boolean in = false, erro = true;
		while(erro) {
			try {
				entrada = new Scanner(System.in);
				in = entrada.nextBoolean();
				erro = false;
			} catch (Exception e) {
				System.out.println("# Erro ao digitar. Tente novamente.");
				entrada = null;
			}
		}
		return in;
	}

	public static boolean cpfValido(String CPF) {
        if (CPF.equals("00000000000") ||
                CPF.equals("11111111111") ||
                CPF.equals("22222222222") || CPF.equals("33333333333") ||
                CPF.equals("44444444444") || CPF.equals("55555555555") ||
                CPF.equals("66666666666") || CPF.equals("77777777777") ||
                CPF.equals("88888888888") || CPF.equals("99999999999") ||
                (CPF.length() != 11))
                return(false);

            char dig10, dig11;
            int sm, i, r, num, peso;
		try {
	        // Calculo do 1o. Digito Verificador
	            sm = 0;
	            peso = 10;
	            for (i=0; i<9; i++) {
	        // converte o i-esimo caractere do CPF em um numero:
	        // por exemplo, transforma o caractere '0' no inteiro 0
	        // (48 eh a posicao de '0' na tabela ASCII)
		            num = (int)(CPF.charAt(i) - 48);
		            sm = sm + (num * peso);
		            peso = peso - 1;
	            }

	            r = 11 - (sm % 11);
	            if ((r == 10) || (r == 11))
	                dig10 = '0';
	            else dig10 = (char)(r + 48); // converte no respectivo caractere numerico

	        // Calculo do 2o. Digito Verificador
	            sm = 0;
	            peso = 11;
		            for(i=0; i<10; i++) {
		            num = (int)(CPF.charAt(i) - 48);
		            sm = sm + (num * peso);
		            peso = peso - 1;
	            }

	            r = 11 - (sm % 11);
	            if ((r == 10) || (r == 11))
	                 dig11 = '0';
	            else dig11 = (char)(r + 48);

	        // Verifica se os digitos calculados conferem com os digitos informados.
	            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
	                 return(true);
	            else return(false);
        } catch (InputMismatchException erro) {
        	return(false);
        }
	}
	
	public static boolean cnpjValido(String CNPJ) {
		// considera-se erro CNPJ's formados por uma sequencia de numeros iguais
	    if (CNPJ.equals("00000000000000") || CNPJ.equals("11111111111111") ||
	        CNPJ.equals("22222222222222") || CNPJ.equals("33333333333333") ||
	        CNPJ.equals("44444444444444") || CNPJ.equals("55555555555555") ||
	        CNPJ.equals("66666666666666") || CNPJ.equals("77777777777777") ||
	        CNPJ.equals("88888888888888") || CNPJ.equals("99999999999999") ||
	       (CNPJ.length() != 14))
	       return(false);

	    char dig13, dig14;
	    int sm, i, r, num, peso;

	// "try" - protege o código para eventuais erros de conversao de tipo (int)
	    try {
	// Calculo do 1o. Digito Verificador
	      sm = 0;
	      peso = 2;
	      for (i=11; i>=0; i--) {
	// converte o i-ésimo caractere do CNPJ em um número:
	// por exemplo, transforma o caractere '0' no inteiro 0
	// (48 eh a posição de '0' na tabela ASCII)
	        num = (int)(CNPJ.charAt(i) - 48);
	        sm = sm + (num * peso);
	        peso = peso + 1;
	        if (peso == 10)
	           peso = 2;
	      }

	      r = sm % 11;
	      if ((r == 0) || (r == 1))
	         dig13 = '0';
	      else dig13 = (char)((11-r) + 48);

	// Calculo do 2o. Digito Verificador
	      sm = 0;
	      peso = 2;
	      for (i=12; i>=0; i--) {
	        num = (int)(CNPJ.charAt(i)- 48);
	        sm = sm + (num * peso);
	        peso = peso + 1;
	        if (peso == 10)
	           peso = 2;
	      }

	      r = sm % 11;
	      if ((r == 0) || (r == 1))
	         dig14 = '0';
	      else dig14 = (char)((11-r) + 48);

	// Verifica se os dígitos calculados conferem com os dígitos informados.
	      if ((dig13 == CNPJ.charAt(12)) && (dig14 == CNPJ.charAt(13)))
	         return(true);
	      else return(false);
	    } catch (InputMismatchException erro) {
	        return(false);
	    }
	}
	
	public static Date leData() {
		Scanner entrada;
		Date valor = null;
		boolean erro = true;
		
		DateFormat df = DateFormat.getDateInstance();
		while (erro) {
			try {
				entrada = new Scanner(System.in);
				String dtString = entrada.next();
				valor = df.parse(dtString);
				erro = false;
			} catch (Exception e) {
				System.out.println("# Erro ao digitar. Tente novamente.");
				entrada = null;
			}
		}
		return valor;
	}
	

	public static Date stringParaDate(String dt) {

		DateFormat df = DateFormat.getDateInstance();
		Date retorno = null;
		try {
			retorno = df.parse(dt);
		} catch (Exception e) {
			System.out.println("# Erro ao digitar a data. Tente novamente.");
			retorno = null;
		}
		return retorno;
	}

	public static String dateParaString(Date dt) {
		DateFormat df = DateFormat.getDateInstance();
		String retorno = null;
		try {
			retorno = df.format(dt);
		} catch (Exception e) {
			System.out.println("# Erro ao converter a data. Tente novamente.");
			retorno = null;
		}
		return retorno;
	}

}