
public class MySQL implements IDb {

	@Override
	public void conectar() {
		System.out.println("Conectado ao MySQL.");
		
		
	}

	@Override
	public void desconectar() {
		System.out.println("desconectado do MySQL.");
		
	}

}
