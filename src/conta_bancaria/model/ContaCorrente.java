package conta_bancaria.model;

import conta_bancaria.util.Cores;

public class ContaCorrente  extends Conta{ // Extends permite eu Herdar os atributos da classe Conta, para utiliza-la aplico o construtor. 
	private float limite;
	
	public ContaCorrente(int numero, int agencia, int tipo, String titular, float saldo, float limite) {
		super(numero, agencia, tipo, titular, saldo);
		this.limite = limite;
	}

	public float getLimite() {
		return limite;
	}
	public void setLimite(float limite) {
		this.limite = limite;
	}
	
@Override
	public boolean sacar (float valor) {
		if(this.getSaldo()  + this.getLimite() < valor) {
			System.out.println("\nSaldo Insuficiente!\n");
			return false;
		}
		this.setSaldo(this.getSaldo() - valor);
		if(this.getSaldo()<0) {
		this.setLimite(this.getLimite() - Math.abs(this.getSaldo()));
		}
		return true;
	}
	
	@Override //avisa o para o codigo que esse metodo ja existe e esta sendo reescrito.
	public void visualizar(){
		super.visualizar();
		System.out.println("*	Limite da conta: " + this.limite + "			*");
		System.out.println("*************************************************\n\n" + Cores.TEXT_RESET);
	}
}
