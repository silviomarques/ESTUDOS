
public class Oracle implements IDb {

	@Override
	public void conectar() {
		System.out.println("Conectado ao Oracle.");
	}

	@Override
	public void desconectar() {
		System.out.println("desconectado do Oracle.");
	}

}
