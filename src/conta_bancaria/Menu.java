package conta_bancaria;

import java.util.Scanner;

import conta_bancaria.model.Conta;
import conta_bancaria.util.Cores;

public class Menu {
	static Scanner leia = new Scanner(System.in);

	public static void main(String[] args) {
		int opcao = 0;
		/*Criando Objetos da Classe Conta para teste*/
		
		Conta c1 = new Conta(1, 123, 1, "Geruncio Marcondes", 10000.0f );
		c1.visualizar();
		System.out.println("Exibir o Saldo: " + c1.getSaldo());
		c1.setSaldo(20000.00f);
		c1.visualizar();
		c1.sacar(21000.00f);
		c1.visualizar();
		c1.depositar(5000.00f);
		c1.visualizar();

		while (opcao != 9) {
			System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_CYAN_BOLD
					+ "*************************************************");
			System.out.println("*              Churupitas Bank			*");
			System.out.println("*************************************************");
			System.out.println("*						*");
			System.out.println("*	1 - Criar Conta				*");
			System.out.println("*	2 - Listar todas as Contas		*");
			System.out.println("*	3 - Buscar Conta por Numero	 	*");
			System.out.println("*	4 - Atualizar Dados da Conta		*");
			System.out.println("*	5 - Apagar Conta			*");
			System.out.println("*	6 - Sacar				*");
			System.out.println("*	7 - Depositar				*");
			System.out.println("*	8 - Transferir Valores entre Conta	*");
			System.out.println("*	9 - Sair				*");
			System.out.println("*						*");
			System.out.println("*************************************************");
			System.out.println("Entre com a opção desejada:                      " + Cores.TEXT_RESET);
			opcao = leia.nextInt();

			if (opcao == 9) {
				sobre();
				System.exit(9);
			}

			switch (opcao) {
			case 1:
				System.out.println("Criar Conta");
				break;
			case 2:
				System.out.println("Lista todas as Contas");
				break;
			case 3:
				System.out.println("Buscar Conta por Numero");
				break;
			case 4:
				System.out.println("Atualizar Dados da Conta");
				break;
			case 5:
				System.out.println("Apagar Conta");
				break;
			case 6:
				System.out.println("Sacar");
				break;
			case 7:
				System.out.println("Depositar");
				break;
			case 8:
				System.out.println("Transferir Valores entre Conta");
				break;
			default:
				System.out.println(Cores.ANSI_RED_BACKGROUND +
						"*************************************************");
				System.out.println("*   Opção invalida, Digite uma opção valida.    *");
				System.out.println("*************************************************\n" + Cores.TEXT_RESET);
				break;
			}
		}
	}

	static void sobre() {
		System.out.println(Cores.ANSI_GREEN_BACKGROUND_BRIGHT + Cores.TEXT_BLUE_BOLD +
							"*************************************************");
		System.out.println("*		Sistema Finalizado!		*");
		System.out.println("*************************************************");
		System.out.println("*						*");
		System.out.println("*	     Projeto - Conta Bancaria		*");	
		System.out.println("*	     By: Vinicius M C Silva		*");
		System.out.println("*						*");
		System.out.println("*************************************************");
	}
}
