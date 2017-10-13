
public class ContaCorrente extends Conta{
	
	//Reescrever o metodo da classe PAI
	//Overriding
	
	@Override
	public void sacar(double valor) {
		super.sacar(valor);
		this.juros();
	}
	
	private void juros() {
		this.saldo -= 1;
	}
}
