
public class ContaPoupanca extends Conta {

	//Reescrever o metodo da classe PAI
	//Overriding
	
	@Override
	public void depositar(double valor) {
		super.depositar(valor);
		this.rentabilidade();		
	}
	
	protected void rentabilidade() {
		this.saldo += 1;
	}
}
