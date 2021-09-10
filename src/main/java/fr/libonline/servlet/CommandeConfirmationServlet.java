package fr.libonline.servlet;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.libonline.model.Client;
import fr.libonline.model.Commande;
import fr.libonline.service.ClientService;
import fr.libonline.service.CommandeService;

@WebServlet(value = "/confirm-order")
public class CommandeConfirmationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String SAVE_FAILURE = "Un problème est survenu lors de la finalisation de votre commande. Veuillez rééssayer ultérieurement.";
	
	private static final String SAVE_SUCCESS = "Nous vous confirmons la prise en compte de votre commande. Elle sera livrée dans de brefs délais.";

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Client currentUser = (Client) request.getSession().getAttribute("currentUser");
		Map<Integer, Integer> cart = (Map<Integer, Integer>) request.getSession().getAttribute("cart");

		if (currentUser == null) {
			/**
			 * On empèche l'accès à la page de confirmation si le user n'est pas connecté
			 * Dans ce cas, on redirige vers la page de connexion
			 */
			response.sendRedirect("login");
			return;
		} else if (cart.isEmpty()) {
			response.sendRedirect("panier");
			return;
		}
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/commande/confirmation.jsp").forward(request,
				response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Client currentUser = (Client) request.getSession().getAttribute("currentUser");
		// Récupération de la saisie du formulaire de confirmation
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String adresse = request.getParameter("adresse");

		// Enregistrement de la commande
		if (isValid(nom) && isValid(prenom) && isValid(adresse)) {
			// On met à jour le user dans la base avec les nouvelles infos
			ClientService clientService = new ClientService();
			Client client = clientService
					.save(clientService.findById(currentUser.getId()).nom(nom).prenom(prenom).adresse(adresse));
			
			// Mise à jour du user dans la session
			request.getSession().setAttribute("currentUser", client);
			
			// Sauvegarde de la commande
			CommandeService commandeService = new CommandeService();
			Double totalPanier = (Double) request.getSession().getAttribute("totalPanier");
			Commande commande = new Commande().date(Date.from(ZonedDateTime.now().toInstant()))
												.clientId(currentUser.getId())
												.montant(computeOrderTotal(totalPanier));
			String successMessage = SAVE_SUCCESS;
			String failureMessage = SAVE_FAILURE;
			if (commandeService.add(commande) == null) {
				request.setAttribute("failureMessage", failureMessage);
			} else {
				request.getSession().removeAttribute("cart");
				request.getSession().removeAttribute("detailedCart");
				request.getSession().removeAttribute("totalPanier");
				request.setAttribute("successMessage", successMessage);
			}
			this.getServletContext().getRequestDispatcher("/WEB-INF/views/commande/save_status_notification.jsp")
					.forward(request, response);
		}
	}

	private Double computeOrderTotal(Double totalPanier) {
		return totalPanier + (totalPanier * 0.20);
	}

	private boolean isValid(String string) {
		return string != null && !string.isEmpty();
	}

}
