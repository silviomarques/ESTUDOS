import javax.swing.JOptionPane;

public class Carro {
	
	//Atributos
	public String marca;
	public int ano;
	public int marcha;
	public boolean ligado;
	public int velocidade;
	public boolean freio = true;
	
	//Métodos
	public void ligar() {
		
		if(this.ligado == false) {
			this.ligado = true;
			JOptionPane.showMessageDialog(null, "Carro Ligado");
			System.out.println("Carro Ligado");
		}else {
			System.out.println("Carro já esta Ligado");
		}		
	}
	
	public void acelerar(int velocidade) {
		if (this.ligado == true) {
			if (this.freio == false) {
				this.velocidade = velocidade;
				System.out.println(this.velocidade);
			}
			
		}
		
		
	}
	
	public void desligar() {
		
		if(this.ligado == true) {
			this.ligado = false;
			JOptionPane.showMessageDialog(null, "Carro desligado");
			System.out.println("Carro desligado");
		}else {
			System.out.println("Carro não esta ligado");
		}
		
	}
	
	public void trocarMarcha() {
		System.out.println("Marcha Desligada");
	}
	
}
