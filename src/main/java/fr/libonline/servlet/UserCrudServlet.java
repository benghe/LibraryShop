package fr.libonline.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.libonline.model.Client;
import fr.libonline.service.ClientService;
import fr.libonline.service.CommandeService;
import fr.libonline.service.LivreService;

@WebServlet(urlPatterns = {
		"/users-update",
		"/users-delete"
})
public class UserCrudServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Client currentUser = (Client) request.getSession().getAttribute("currentUser");
		if (currentUser == null) {
			response.sendRedirect("login");
		} else if (!currentUser.getLogin().equals("admin")){
			response.sendRedirect("livres");
		} else {
			String id = request.getParameter("modifiedObjectId");
			if (id != null) {
				ClientService clientService = new ClientService();
				if (request.getServletPath().equals("/users-update")) {
					String nom = request.getParameter("nom");
					String prenom = request.getParameter("prenom");
					String adresse = request.getParameter("adresse");
					String login = request.getParameter("login");
					clientService.save(clientService.findById(Integer.parseInt(id)).nom(nom)
																					.prenom(prenom)
																					.adresse(adresse)
																					.login(login));
					response.sendRedirect("users-administration");
					return;
				} else if (request.getServletPath().equals("/users-delete")) {
					clientService.deleteById(Integer.parseInt(id));
				}
			}
			response.sendRedirect(request.getHeader("referer"));
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
