

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NovoChamadoServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Novo Chamado</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Preencha as informa��es do chamado</h1>");
			out.println("<hr/>");
			out.println("<form method='POST'>");
			out.println("Titulo:<br> <input type='text' name='txtTitulo'>");
			out.println("<br>");
			out.println("Conteudo:<br> <textarea name='txtConteudo' rows='10' cols='40'></textarea>");
			out.println("<br>");
			out.println("<input type='submit' value='Abrir Chamado'>");
			out.println("</form>");
			out.println("<br>");
			out.println("<a href='/ListarChamados'>Listar Chamados</a>");
			out.println("<br>");
			out.println("<a href='/Logoff'>Sair</a>");
			out.println("</body>");
			out.println("</html>");
		}catch(IOException e) {
			
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			PrintWriter out = response.getWriter();

			String titulo = request.getParameter("txtTitulo");
			String conteudo = request.getParameter("txtConteudo");

			if(titulo.trim().length() < 4) {
				out.println("Preencha o campo titulo");
			} else if (conteudo.trim().length() < 4) {
				out.println("Preencha o campo Conteudo");
			}else {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					
					//String SQL = "INSERT INTO chamados (titulo, conteudo) VALUES (";
					//SQL +=  " '" + titulo + "', '" + conteudo + "')";
					String SQL = "INSERT INTO chamados (titulo, conteudo) VALUES (?,?)";
					
					
					try {
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/chamados_rlsystem", "root", "123456");
						//DriverManager.getConnection("jdbc:mysql://localhost/chamados_rlsystem", "root", "123456");
						//Statement stm = conn.createStatement();
						PreparedStatement pstm = conn.prepareStatement(SQL);
						
						pstm.setString(1, titulo);
						pstm.setString(2, conteudo);
						
						pstm.execute();
						pstm.close();
						conn.close();
						
						response.sendRedirect("http://localhost:8080/Chamados/ListarChamados");
					} catch (SQLException e) {
						out.println("Problema no banco de dados! Msg: " + e.getMessage());
						/*out.println("<br>");
						out.println(SQL);
						out.println("<br>");
						out.println(e.getErrorCode());*/
					}
					
					
				}catch(ClassNotFoundException ex){
					out.println("Problema ao carregar o driver de conex�o!");
				}
				
		}
	}

}
