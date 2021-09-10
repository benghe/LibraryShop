package fr.libonline.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import fr.libonline.dao.LivreDao;
import fr.libonline.dao.sql.LivreDaoSqlImpl;
import fr.libonline.model.Livre;

@WebServlet("/livre-modifier")
public class LivreModifierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//On récupère l'identifiant de le livre à modifier
		String livreIdString = req.getParameter("id");
		int livreId = Integer.parseInt(livreIdString);
		
		//On cherche le livre à modifier
		LivreDao daolivre = new LivreDaoSqlImpl();
		Livre livre = daolivre.findById(livreId);
		
		//On donne le livre au scope request, pour pouvoir l'afficher sur la vue
		req.setAttribute("livre", livre);
		
		//On délègue à la vue
		this.getServletContext()
			.getRequestDispatcher("/WEB-INF/views/livre/form.jsp")
			.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//On récupère les paramètres
		String livreIdString = req.getParameter("id");
		String titreLivre = req.getParameter("titre");
		String auteurLivre = req.getParameter("auteur");
		String prixLivreString = req.getParameter("prix");
		String photoLivre = req.getParameter("photo");
		String resumeLivre = req.getParameter("resume");
		
		int livreId = Integer.parseInt(livreIdString);
		
		Double prixLivre = new Double(prixLivreString);
		
		//On cherche le livre à modifier
		LivreDao daolivre = new LivreDaoSqlImpl();
		Livre livre = daolivre.findById(livreId);
		
		//On modifie les données
		livre.titre(titreLivre);
		livre.auteur(auteurLivre);
		livre.prix(prixLivre);
		livre.photo(photoLivre);
		livre.resume(resumeLivre);
		
		//On sauvegarde le livre
		daolivre.save(livre);
		
		//On redirige vers la liste
		resp.sendRedirect("livres");
	}

}
