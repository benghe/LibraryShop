package fr.libonline.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.libonline.dao.CommandeDao;
import fr.libonline.dao.sql.CommandeDaoSqlImpl;

@WebServlet("/commande-supprimer")
public class CommandeSupprimerServlet extends HttpServlet{
	
private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String idCommandeString = req.getParameter("idCommande");
		int idCommande = Integer.parseInt(idCommandeString);
		

		CommandeDao daoCommande = new CommandeDaoSqlImpl();
		
		daoCommande.deleteById(idCommande);
		

		resp.sendRedirect("commandes");
	}

}
