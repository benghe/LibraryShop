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
		"/users-administration", 
		"/livres-administration", 
		"/orders-administration" 
		})
public class AdministrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String BASE_PATH = "/WEB-INF/views/administration/";
	
	private static final String USERS_VIEW = "users.jsp";

	private static final String BOOKS_VIEW = "books.jsp";

	private static final String ORDERS_VIEW = "orders.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Client currentUser = (Client) request.getSession().getAttribute("currentUser");
		if (currentUser == null) {
			response.sendRedirect("login");
		} else {
			if (!currentUser.getLogin().equals("admin")) {
				String referer = request.getHeader("referer");
				response.sendRedirect(referer != null ? referer : "livres");
			} else {
				// V�rifier si la modification des champs est autoris�e
				String modification = request.getParameter("modification");
				String ajout = request.getParameter("ajout");
				
				String id = request.getParameter("modifiedObjectId");
				if (modificationAllowed(modification, id)) {
					request.setAttribute("modification", modification);
					request.setAttribute("modifiedObjectId", id);
				}
				if (ajout != null && ajoutActif(ajout)) {
					request.setAttribute("ajout", ajout);
				}
				// On retourne la bonne page
				String path = BASE_PATH;
				if (request.getServletPath().equals("/users-administration")) {
					ClientService clientService = new ClientService();
					request.setAttribute("users", clientService.findAll());
					path += USERS_VIEW;
				} else if (request.getServletPath().equals("/livres-administration")) {
					LivreService livreService = new LivreService();
					request.setAttribute("livres", livreService.findAll());
					path += BOOKS_VIEW;
				} else if (request.getServletPath().equals("/orders-administration")) {
					CommandeService commandeService = new CommandeService();
					request.setAttribute("commandes", commandeService.findAll());
					path += ORDERS_VIEW;
				}
				this.getServletContext().getRequestDispatcher(path).forward(request, response);
			}
		}
	}

	private boolean modificationAllowed(String modification, String id) {
		if (
			id != null &&
			modification != null &&
			modification.equals("allowed")
			
		) {
			return true;
		}
		return false;
	}
	
	private boolean ajoutActif(String ajout) {
		if (
			ajout.equals("actif")
		) {
			return true;
		}
		return false;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
