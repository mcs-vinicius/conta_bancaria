package conta_bancaria.model;

import conta_bancaria.util.Cores;

public class ContaPoupanca extends Conta{
	private int aniverssario;;
	public ContaPoupanca(int numero, int agencia, int tipo, String titular, float saldo, int aniverssario) {
		super(numero, agencia, tipo, titular, saldo);
		this.aniverssario = aniverssario;
	}
	public int getAniverssario() {
		return aniverssario;
	}
	public void setAniverssario(int aniverssario) {
		this.aniverssario = aniverssario;
	}

@Override 
	public void visualizar(){
		super.visualizar();
		System.out.println("*	Aniverssário: " + this.aniverssario + "			*");
		System.out.println("*************************************************\n\n" + Cores.TEXT_RESET);
	}
}
