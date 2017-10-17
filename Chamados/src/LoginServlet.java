

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out = response.getWriter();
			
			//Sair
			if(request.getParameter("msg") != null) {
				if(request.getParameter("msg").equals("logoff")) {
					HttpSession sessao = request.getSession();
					sessao.invalidate();
					out.println("<span style='color: red' >Deslogado com Sucesso! </span>");
				}
			}
			
			if(request.getParameter("msg") != null) {
				if(request.getParameter("msg").equals("error")) {
					out.println("<span style='color: red' >Login e/ou senha incorretos! </span>");
				}
			}
			
			String login_name = "";
			
			Cookie[] ck = request.getCookies();
			
			if(ck != null) {
				for(Cookie cookie : ck) {
					if(cookie.getName().equals("login_name")) {
						login_name = cookie.getValue();
					}
				}				
			}
			
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Login</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Preencha seu login e senha</h1>");
			out.println("<hr/>");
			out.println("<form method='POST'>");
			out.println("Login:<br> <input type='text' name='txtLogin' value='"+ login_name +"'>");
			out.println("<br>");
			out.println("Senha:<br> <input type='password' name='txtSenha'>");
			out.println("<br>");
			out.println("<input type='submit' value='Logar'>");
			out.println("</form>");
			out.println("<br>");
			/*out.println("<a href='/ListarChamados'>Logar</a>");
			out.println("<br>");
			out.println("<a href='/Logoff'>Sair</a>");*/
			out.println("</body>");
			out.println("</html>");
		}catch(IOException e) {
			
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			PrintWriter out = response.getWriter();

			String login = request.getParameter("txtLogin");
			String senha = request.getParameter("txtSenha");
			
			Cookie ck = new Cookie("login_name", login);
			ck.setMaxAge(60*60*24*30);
			response.addCookie(ck);

			try {
				Class.forName("com.mysql.jdbc.Driver");
				
				try {
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/chamados_rlsystem", "root", "123456");
				
					String SQL = "SELECT* FROM usuarios WHERE login = ? and senha = ?";
							
					PreparedStatement pstm = conn.prepareStatement(SQL);
					
					pstm.setString(1, login);
					pstm.setString(2, senha);
					
					ResultSet rs = pstm.executeQuery();
					
					if(rs.next()) {
						HttpSession sessao = request.getSession();
						sessao.setAttribute("login", login);
						
						response.sendRedirect("http://localhost:8080/Chamados/ListarChamados");							
					}else {
						response.sendRedirect("http://localhost:8080/Chamados/Login?msg=error");
					}
					
					pstm.close();
					conn.close();
					
					
				} catch (SQLException e) {
					out.println("Problema no banco de dados! Msg: " + e.getMessage());
				}
				
				
			}catch(ClassNotFoundException ex){
				out.println("Problema ao carregar o driver de conex�o!");
			}
			
	}
}

