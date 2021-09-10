package fr.libonline.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.libonline.model.Client;
import fr.libonline.service.CommandeService;

@WebServlet(urlPatterns = {
		"/mon-profil",
		"/mes-commandes"
})
public class MenuClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String PROFILE_VIEW = "/WEB-INF/views/client/profile.jsp";

	private static final String MY_ORDERS_VIEW = "/WEB-INF/views/client/commandes.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Client currentUser = (Client) request.getSession().getAttribute("currentUser");
		if (currentUser == null) {
			response.sendRedirect("login");
		} else {
			String path = "";
			if (request.getServletPath().equals("/mon-profil")) {
				path = PROFILE_VIEW;
			} else if (request.getServletPath().equals("/mes-commandes")) {
				CommandeService commandeService = new CommandeService();
				request.setAttribute("commandes", commandeService.findByClientId(currentUser.getId()));
				path = MY_ORDERS_VIEW;
			}
			this.getServletContext().getRequestDispatcher(path).forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
