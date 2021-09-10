package fr.libonline.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.libonline.model.Client;
import fr.libonline.service.ClientService;

@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Client currentUser = (Client) request.getSession().getAttribute("currentUser");
		if (currentUser != null) {
			/**
			 * Si un user est connecté on empêche l'accès à la page de login  
			 * Dans ce cas, il sera redirigé vers l'affichage des livres
			 */
			response.sendRedirect("livres");
			return;
		}
		this.getServletContext()
		.getRequestDispatcher("/WEB-INF/views/user/login.jsp")
		.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Récupération des credentials
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		// Vérification de l'existence du user
		ClientService cService = new ClientService();
		Client fetchedUser = cService.findByCredentiants(login, password);
		
		// Traitement en fonction des cas
		if (fetchedUser == null) {
			request.setAttribute("loginError", "Bad Credentials!");
		} else {
			Client currentUser = (Client) request.getSession().getAttribute("currentUser");
			if (currentUser != null) {
				currentUser = fetchedUser;
			} else {
				request.getSession().setAttribute("currentUser", fetchedUser);	
			}
			response.sendRedirect("livres");
			return;
		}
		doGet(request, response);
	}

}
