package servlets;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ModelLogin;

//O Chamado Controller são as Servlets ou ServletLoginController
//@WebServlet("/ServletLogin")  //Mapeamento de url que vem da tela
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletLogin() {

	}

	// Recebe os dados pela url em parametros
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	// Recebe os dados enviados por um formulário
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = request.getParameter("login");
		String senha = request.getParameter("senha");

		// Validar dados da tela
		if (login != null && !login.isEmpty() && senha != null && !senha.isEmpty()) {
			ModelLogin modelLogin = new ModelLogin();
			modelLogin.setLogin(login);
			modelLogin.setSenha(senha);

			// Simulação
			if (modelLogin.getLogin().equalsIgnoreCase("admin") && modelLogin.getSenha().equalsIgnoreCase("admin")) {
				
				request.getSession().setAttribute("usuario", modelLogin.getLogin());//Mater o usuário logado
				RequestDispatcher redirecionar = request.getRequestDispatcher("principal/principal.jsp");
				redirecionar.forward(request, response);
				
			}else {
				RequestDispatcher redirecionar = request.getRequestDispatcher("index.jsp");
				request.setAttribute("msg", "Informe um login e senha corretamente!");
				redirecionar.forward(request, response);
			}
		} else {
			RequestDispatcher redirecionar = request.getRequestDispatcher("index.jsp");
			request.setAttribute("msg", "Informe um login e senha corretamente!");
			redirecionar.forward(request, response);
		}

	}

}
