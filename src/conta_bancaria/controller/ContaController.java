package conta_bancaria.controller;

import java.util.ArrayList;
import conta_bancaria.model.Conta;
import conta_bancaria.repository.ContaRepository;
import conta_bancaria.util.Cores;

public class ContaController implements ContaRepository {
	// Criar a Collection
	private ArrayList<Conta> listaContas = new ArrayList<Conta>();

	// Variavel para receber o numero da Conta
	int numero = 0;

	@Override
	public void procurarPorNumero(int numero) {
		var conta = buscarNaCollection(numero);
		if (conta != null) {
			conta.visualizar();
		} else {
			System.out.println("A Conta número: " + numero + "não foi encontrada!");
		}

	}

	@Override
	public void listarTodas() {
		if (listaContas.isEmpty()) {
			System.out.println("Nenhuma conta encontrada.");
		} else {
			for (var conta : listaContas) {
				conta.visualizar();
			}
		}
	}

	@Override
	public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.println(Cores.ANSI_GREEN_BACKGROUND + Cores.TEXT_BLACK_BOLD + "Conta: " + conta.getNumero()
				+ " Foi criada com sucesso!" + Cores.TEXT_RESET);

	}

	@Override
	public void atualizar(Conta conta) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletar(int numero) {
		var conta = buscarNaCollection(numero);
		if (conta != null) {
			if (listaContas.remove(conta) == true) {
				System.out.println("A Conta Numero: " + numero + " Foi excluida com sucesso!");
			}
		} else {
			System.out.println("A Conta número: " + numero + "não foi encontrada!");
		}

	}

	@Override
	public void sacar(int numero, float valor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void depositar(int numero, float valor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		// TODO Auto-generated method stub

	}

	// Metodos Auxiliares
	public int gerarNumero() {
		return ++numero;
	}

	public Conta buscarNaCollection(int numero) {
		for (var conta : listaContas) {
			if (conta.getNumero() == numero) {
				return conta;
			}
		}
		return null;
	}
}
