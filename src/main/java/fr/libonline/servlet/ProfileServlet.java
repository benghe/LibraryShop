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

@WebServlet(urlPatterns = {
		"/profile-update"
})
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Client currentUser = (Client) request.getSession().getAttribute("currentUser");
		if (currentUser == null) {
			response.sendRedirect("login");
		} else {
			String id = request.getParameter("modifiedObjectId");
			if (id != null) {
				ClientService clientService = new ClientService();
				String nom = request.getParameter("nom");
				String prenom = request.getParameter("prenom");
				String adresse = request.getParameter("adresse");
				Client client = clientService.save(clientService.findById(Integer.parseInt(id)).nom(nom)
																				.prenom(prenom)
																				.adresse(adresse));
				request.getSession().setAttribute("currentUser", client);
				response.sendRedirect(request.getHeader("referer"));
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
