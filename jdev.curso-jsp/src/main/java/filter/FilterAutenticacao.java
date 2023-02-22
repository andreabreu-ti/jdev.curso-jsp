package filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

//Intercepta todas as requisições que vierem do projeto ou mapeamento
@WebFilter(urlPatterns = { "/principal/*" })
public class FilterAutenticacao extends HttpFilter implements Filter {

	public FilterAutenticacao() {
	}

	// Encerra os processos quando o servidor é parado
	// Mataria os processos de conexão com o banco
	public void destroy() {
	}

	// Intercepta as requisições e as respostas no sistema
	// Tudo que fizer no sistema passará aqui
	// Exemplo: Validação de autenticação, Commit e Rolback de Transação no banco,
	// Fazer direcionamentos específicos/paginas
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		
		String usuarioLogado = (String) session.getAttribute("usuario");
		
		String urlParaAutenticar = req.getServletPath();// Url que está sendo acessada

		// Validar se está logado senao redireciona para a tela de login
		if (usuarioLogado == null && !urlParaAutenticar.equalsIgnoreCase("/principal/ServletLogin")) { // Não stá logado

			RequestDispatcher redireciona = request.getRequestDispatcher("/index.jsp?url=" + urlParaAutenticar);
			request.setAttribute("msg", "Por favor realize o login!");
			redireciona.forward(request, response);
			return;// Para a execução e redireciona para o login

		}

		chain.doFilter(request, response);
	}

	// Executado quando inicia o sistema, inicia os processos e recursos quando o
	// server sob o projeto
	// Inicia a conexão com o banco
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
