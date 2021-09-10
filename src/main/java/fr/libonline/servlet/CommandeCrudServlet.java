package fr.libonline.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.libonline.model.Client;
import fr.libonline.service.CommandeService;

@WebServlet(value = {
		"/commandes-delete"
})
public class CommandeCrudServlet extends HttpServlet {
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
				CommandeService commandeService = new CommandeService();
				commandeService.deleteById(Integer.parseInt(id));
			}
			response.sendRedirect(request.getHeader("referer"));
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
