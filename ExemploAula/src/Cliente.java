import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Cliente {
	private String nome;
	private String email;
	private int idade;
	
	String arquivoCad = "C:\\Users\\Silvio\\eclipse-workspace\\ExemploAula\\Arquivos\\clientes.txt";
	
	public String salvar() {
		File fl = new File(arquivoCad);
		
		if(!fl.exists()) {
			try {
				fl.createNewFile();				
			} catch(Exception ex) {
				return "Erro ao Criar o Arquivo. Msg: " + ex.getMessage();
			}	
		}
		
		FileWriter writer;
		try {
			writer = new FileWriter(fl);
			writer.write(this.nome + " - " + this.email + " - " + this.idade);
			
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return "Sucesso ao Cadastrar!";
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
}
