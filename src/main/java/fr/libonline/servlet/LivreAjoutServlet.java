package fr.libonline.servlet;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.libonline.dao.LivreDao;
import fr.libonline.dao.sql.LivreDaoSqlImpl;
import fr.libonline.model.Livre;

@WebServlet("/livre-ajouter")
public class LivreAjoutServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//R�cuparation des param�tres du Livre (via le formulaire)
		String titreLivre = req.getParameter("titre");
		String auteurLivre = req.getParameter("auteur");
		String prixLivreString = req.getParameter("prix");
		String photoLivre = req.getParameter("photo");
		String resumeLivre = req.getParameter("resume");
		
		Double prixLivre = new Double(prixLivreString);
		

		//Cr�ation du Livre avec le nom du Livre
		Livre monLivre = new Livre (titreLivre, auteurLivre, prixLivre, photoLivre, resumeLivre);
		
		
		monLivre.titre(titreLivre);
		monLivre.auteur(auteurLivre);
		monLivre.prix(prixLivre);
		monLivre.photo(photoLivre);
		monLivre.resume(resumeLivre);
		
		//Ajoute le Livre
		LivreDao daoLivre = new LivreDaoSqlImpl();
		
		daoLivre.add(monLivre);
		
		//Redirection vers la page des Livres
		resp.sendRedirect("livres-administration");
	}
	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		//R�cuparation des param�tres du Livre (via le formulaire)
//		String titreLivre = req.getParameter("titre");
//		String auteurLivre = req.getParameter("auteur");
//		String prixLivreString = req.getParameter("prix");
//		String photoLivre = req.getParameter("photo");
//		String resumeLivre = req.getParameter("resume");
//		
//		Double prixLivre = new Double(prixLivreString);
//		
//
//		//Cr�ation du Livre avec le nom du Livre
//		Livre monLivre = new Livre (titreLivre, auteurLivre, prixLivre, photoLivre, resumeLivre);
//		
//		
//		monLivre.titre(titreLivre);
//		monLivre.auteur(auteurLivre);
//		monLivre.prix(prixLivre);
//		monLivre.photo(photoLivre);
//		monLivre.resume(resumeLivre);
//		
//		//Ajoute le Livre
//		LivreDao daoLivre = new LivreDaoSqlImpl();
//		
//		daoLivre.add(monLivre);
//		
//		//Redirection vers la page des Livres
//		resp.sendRedirect("livres-administration");
//	}
}
