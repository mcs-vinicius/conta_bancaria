package conta_bancaria;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;
import conta_bancaria.controller.ContaController;
import conta_bancaria.model.Conta;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;
public class Menu {
	static Scanner leia = new Scanner(System.in);
	public static void main(String[] args) {
		ContaController contas = new ContaController();
		int opcao = 0, numero = 0, agencia, tipo = 0, aniverssario = 0, numeroDestino;
		String titular;
		float saldo, limite, valor;

		//Contas criadas para testes.
		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "Rasputcha", 10000.00f, 100.0f);
		contas.cadastrar(cc1);
		ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 321, 1, "Geriscleuso", 20000.00f, 100.0f);
		contas.cadastrar(cc2);
		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 213, 2, "Clariosvaldo", 5000.00f, 10);
		contas.cadastrar(cp1);

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
			try {
				opcao = leia.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Digite valores inteiros!");
				leia.nextLine();
				opcao = 0;
			}
			if (opcao == 9) {
				sobre();
				System.exit(9);
			}

			switch (opcao) {
			case 1:
				System.out.println(Cores.ANSI_GREEN_BACKGROUND + Cores.TEXT_BLACK_BOLD
						+ "*************************************************");
				System.out.println("*         	  Criar Conta			*");
				System.out.println("*************************************************"+ Cores.TEXT_RESET);
				System.out.println("Digite o numero da Agência: 			 ");
				agencia = leia.nextInt();

				System.out.println("Digite o Nome do titular: 			 ");
				leia.skip("\\R");
				titular = leia.nextLine();

				System.out.println("Digite o tipo da conta(1-CC ou 2-CP): 		 ");
				tipo = leia.nextInt();

				System.out.println("Digite o Saldo da conta: 			 ");
				saldo = leia.nextFloat();

				switch (tipo) {
					case 1 -> {
						System.out.println("Digite o limite da conta: 			 ");
						limite = leia.nextFloat();
						contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
					}
					case 2 -> {
						System.out.println("Digite o Aniverssário da conta: 		 " + Cores.TEXT_RESET);
						aniverssario = leia.nextInt();
						contas.cadastrar(
								new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniverssario));
					}
				}
				keyPress();
				break;
			case 2:
				System.out.println(Cores.ANSI_GREEN_BACKGROUND + Cores.TEXT_BLACK_BOLD
						+ "*************************************************");
				System.out.println("*         	    Contas			*");
				System.out.println("*************************************************"+ Cores.TEXT_RESET);
				contas.listarTodas();
				keyPress();
				break;
			case 3:
				System.out.println(Cores.ANSI_GREEN_BACKGROUND + Cores.TEXT_BLACK_BOLD
						+ "*************************************************");
				System.out.println("*         	   Buscar conta			*");
				System.out.println("*************************************************"+ Cores.TEXT_RESET);
				System.out.println("Digite o numero da conta:");
				numero = leia.nextInt();

				contas.procurarPorNumero(numero);
				keyPress();
				break;
			case 4:
				System.out.println(Cores.ANSI_GREEN_BACKGROUND + Cores.TEXT_BLACK_BOLD
						+ "*************************************************");
				System.out.println("*         Atualizar dados da Conta		*");
				System.out.println("*************************************************"+ Cores.TEXT_RESET);
				System.out.println("\nDigite o numero da conta:" );
				numero = leia.nextInt();

				Optional<Conta> conta = contas.buscarNaCollection(numero);
				if (conta.isPresent()) {
					System.out.println(Cores.ANSI_GREEN_BACKGROUND + Cores.TEXT_BLACK_BOLD
							+ "Digite o numero da Agência: 			 ");
					agencia = leia.nextInt();

					System.out.println("Digite o Nome do titular: 			 ");
					leia.skip("\\R");
					titular = leia.nextLine();

					System.out.println("Digite o Saldo da conta: 			 ");
					saldo = leia.nextFloat();
					
					tipo = conta.get().getTipo();

					switch (tipo) {
					case 1 -> {
						System.out.println("Digite o limite da conta: 			 " + Cores.TEXT_RESET);
						limite = leia.nextFloat();
						contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
					}
					case 2 -> {
						System.out.println("Digite o Aniverssário da conta: 		 " + Cores.TEXT_RESET);
						aniverssario = leia.nextInt();
						contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniverssario));
					}
					}
				} else {
					System.out.println("A Conta: " + numero + " não foi encontrada!");
				}

				keyPress();
				break;
			case 5:
				System.out.println(Cores.ANSI_GREEN_BACKGROUND + Cores.TEXT_BLACK_BOLD
						+ "*************************************************");
				System.out.println("*         	   Apagar Conta			*");
				System.out.println("*************************************************" + Cores.TEXT_RESET);
				System.out.println("\nDigite o numero da conta:");
				numero = leia.nextInt();

				contas.procurarPorNumero(numero);
				contas.deletar(numero);
				keyPress();
				break;
			case 6:
				System.out.println(Cores.ANSI_GREEN_BACKGROUND + Cores.TEXT_BLACK_BOLD
						+ "*************************************************");
				System.out.println("*         	   Sacar			*");
				System.out.println("*************************************************"+ Cores.TEXT_RESET);

				System.out.println("\nDigite o numero da conta:");
				numero = leia.nextInt();

				System.out.println("\nDigite o valor do saque:");
				valor = leia.nextFloat();

				contas.sacar(numero, valor);

				keyPress();
				break;
			case 7:
				System.out.println(Cores.ANSI_GREEN_BACKGROUND + Cores.TEXT_BLACK_BOLD
						+ "*************************************************");
				System.out.println("*         	   Depositar			*");
				System.out.println("*************************************************"+ Cores.TEXT_RESET);

				System.out.println("\nDigite o numero da conta:");
				numero = leia.nextInt();

				System.out.println("\nDigite o valor a ser depositado:");
				valor = leia.nextFloat();

				contas.depositar(numero, valor);

				keyPress();
				break;
			case 8:
				System.out.println(Cores.ANSI_GREEN_BACKGROUND + Cores.TEXT_BLACK_BOLD
						+ "*************************************************");
				System.out.println("*         	  Transferência			*");
				System.out.println("*************************************************"+ Cores.TEXT_RESET);
				
				System.out.println("\nDigite o numero da conta de Origem:");
				numero = leia.nextInt();

				System.out.println("\nDigite o numero da conta de Destino:");
				numeroDestino = leia.nextInt();

				System.out.println("\nDigite o valor a ser transferido:");
				valor = leia.nextFloat();

				if (numero != numeroDestino) {
					contas.transferir(numero, numeroDestino, valor);
				} else {
					System.out.println("Os números das contas são iguais: ");
				}

				keyPress();
				break;
			default:
				System.out.println(Cores.ANSI_RED_BACKGROUND + "*************************************************");
				System.out.println("*   Opção invalida, Digite uma opção valida.    *");
				System.out.println("*************************************************\n" + Cores.TEXT_RESET);
				keyPress();
				break;
			}
		}
	}

	static void sobre() {
		System.out.println(Cores.ANSI_GREEN_BACKGROUND_BRIGHT + Cores.TEXT_BLUE_BOLD
				+ "*************************************************");
		System.out.println("*		Sistema Finalizado!		*");
		System.out.println("*************************************************");
		System.out.println("*						*");
		System.out.println("*	     Projeto - Conta Bancaria		*");
		System.out.println("*	     By: Vinicius M C Silva		*");
		System.out.println("*						*");
		System.out.println("*************************************************");
	}

	public static void keyPress() {
		try {
			System.out.println("Pressione a tecla Enter para continuar...");
			System.in.read();
		} catch (IOException e) {
			System.out.println("Você precionou uma tecla invalida.");
		}
	}
}
