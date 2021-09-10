package fr.libonline.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.libonline.dao.CommandeDao;
import fr.libonline.dao.sql.CommandeDaoSqlImpl;
import fr.libonline.model.Commande;

@WebServlet("/commande-modifier")
public class CommandeModifierServlet extends HttpServlet {
	
private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String commandeIdString = req.getParameter("idCommande");
		int commandeId = Integer.parseInt(commandeIdString);
		
		
		CommandeDao daoCommande = new CommandeDaoSqlImpl();
		Commande commande = daoCommande.findById(commandeId);
		
		
		req.setAttribute("commande", commande);
		
		
		this.getServletContext()
			.getRequestDispatcher("/WEB-INF/views/commande/modifier.jsp")
			.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String idCommandeString = req.getParameter("idCommande");
		String dateCommandeString = req.getParameter("dateCommande");
		String clientIdString = req.getParameter("clientId");
		String montantCommandeString = req.getParameter("montantCommande");
		
		Date dateCommande = convertDate(dateCommandeString);
		int clientId = Integer.parseInt(clientIdString);
		Double montantCommande = Double.parseDouble(montantCommandeString);
		int idCommande = Integer.parseInt(idCommandeString);
		
		
		CommandeDao daoCommande = new CommandeDaoSqlImpl();
		Commande commande = daoCommande.findById(idCommande);
		
		
		commande.id(idCommande);
		commande.clientId(clientId);
		commande.montant(montantCommande);
		commande.date(dateCommande);
		
		
		daoCommande.save(commande);
		
		
		resp.sendRedirect("commandes");
	}
	
	private Date convertDate(String dateCommandeString) {
		
		String format = "yyyy-MM-dd";
		Date date = new Date();
		try {
		 date = new SimpleDateFormat(format).parse(dateCommandeString);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		return date;
	}

}