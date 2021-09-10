package fr.libonline.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.libonline.model.Client;
import fr.libonline.service.LivreService;

@WebServlet(urlPatterns = {
		"/livres-update",
		"/livres-delete"
})
public class LivreCrudServlet extends HttpServlet {
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
				LivreService livreService = new LivreService();
				if (request.getServletPath().equals("/livres-update")) {
					String titre = request.getParameter("titre");
					String auteur = request.getParameter("auteur");
					String prix = request.getParameter("prix");
					String photo = request.getParameter("photo");
					String resume = request.getParameter("resume");
					livreService.save(livreService.findById(Integer.parseInt(id)).titre(titre)
																					.auteur(auteur)
																					.prix(Double.valueOf(prix))
																					.photo(photo)
																					.resume(resume));
					response.sendRedirect("livres-administration");
					return;
				} else if (request.getServletPath().equals("/livres-delete")) {
					livreService.deleteById(Integer.parseInt(id));
				}
			}
			response.sendRedirect(request.getHeader("referer"));
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
