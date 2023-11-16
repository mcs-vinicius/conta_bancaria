package conta_bancaria;

import java.util.Scanner;
import conta_bancaria.util.*;

public class Menu {
	static Scanner leia = new Scanner(System.in);

	public static void main(String[] args) {
		int opcao = 0;

		while (opcao != 9) {
			System.out.println(Cores.ANSI_CYAN_BACKGROUND_BRIGHT + Cores.TEXT_BLUE_BOLD + 
							   "*************************************************");
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
			System.out.println("Entre com a opção desejada:                      "+ Cores.TEXT_RESET);
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
				System.out.println("Opção invalida, Digite uma opção valida.");
				break;
			}
		}
	}

	static void sobre() {
		System.out.println("Sistema Finalizado!");
		System.out.println("\nProjeto - Conta Bancaria");
		System.out.println("By: Vinicius M C Silva");
	}
}
