package fr.libonline.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.libonline.dao.LivreDao;
import fr.libonline.dao.sql.LivreDaoSqlImpl;

@WebServlet("/livre-supprimer")
public class LivreSupprimerServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String livreIdString = req.getParameter("id");
		int livreId = Integer.parseInt(livreIdString);
		
		//On supprime le livre
		LivreDao daolivre = new LivreDaoSqlImpl();
		daolivre.deleteById(livreId);
		
		//On redirige vers la liste
		resp.sendRedirect("livres");
	}

}
