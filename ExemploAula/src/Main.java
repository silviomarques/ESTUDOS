import javax.swing.JOptionPane;

public class Main {
	
	public static void main(String args[]) {
		//System.out.println("Hello Guy's");
		
		//Instanciar uma classe = Objeto
		/*
		double valor = 100.50;
		int valor2 = 200;
		Integer valor3 = 200;
		
		char txt = 'A';
		String nome = "Silvio";
		
		int[] numeros = {1, 2, 3, 4};
		String[] paises = {"Brasil", "EUA", "Portugal", "Argentina", "Angola"};
		
		for(int i = 0; i < paises.length; i++) {
			//System.out.println(paises[i]);
		}
		
		for(String pais : paises) {
			//System.out.println(pais);
		}
		
		int e = 0;
		while(e < 5) {
			System.out.println(paises[e]);
			e++;
		}
		
		Carro c4 = new Carro();
		/*c4.ligar();
		c4.freio = false ;
		c4.acelerar(80);
		c4.desligar();
		
		//c4.trocarMarcha();*/
		/*
		Carro ix35 = new Carro();
		
		/*ContaCorrente c = new ContaCorrente();
		c.depositar(100);
		c.sacar(50);
		c.verSaldo();*/
		/*
		ContaPoupanca p = new ContaPoupanca();
		p.depositar(100);
		p.verSaldo();
		p.sacar(50);
		p.verSaldo();
		*/
		
		IDb db;
		
		String acao = JOptionPane.showInputDialog("Digite o tipo do Banco de Dados");
		
		if(acao.equals("m")) {
			db = new MySQL();
		}else {
			db = new Oracle();
		}
		
		db.conectar();
		db.desconectar();
		
	}
	
}