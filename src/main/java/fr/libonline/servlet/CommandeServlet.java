package fr.libonline.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.libonline.dao.CommandeDao;
import fr.libonline.dao.sql.CommandeDaoSqlImpl;

@WebServlet("/commandes")
public class CommandeServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CommandeDao daoCommande = new CommandeDaoSqlImpl();
		
		req.setAttribute("commandes", daoCommande.findAll());
		
		this.getServletContext()
			.getRequestDispatcher("/WEB-INF/views/commande/listeCommande.jsp")
			.forward(req, resp);
	}
	
}
