package fr.libonline.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.libonline.model.Client;
import fr.libonline.service.ClientService;

@WebServlet(value = "/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ClientService clientService= new ClientService();
	
	private static final String SAVE_FAILURE = "Un problème est survenu lors de l'enregistrement.";
	
	private static final String SAVE_SUCCESS = "Vous avez été enregistré avec succès. Merci de vous connecter.";
	
	private static final String INCORRECT_INFO = "Les informations saisies sont incorrectes.";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		if (clientService == null) {
//			clientService = new ClientService();
//		}
		Client currentUser = (Client) request.getSession().getAttribute("currentUser");
		if (currentUser != null) {
			/* Si un user est connect� on emp�che l'acc�s � la page d'inscription
			 * Dans ce cas, il sera redirig� vers l'affichage des livres
			 */
			response.sendRedirect("livres");
			return;
		}
		this.getServletContext()
		.getRequestDispatcher("/WEB-INF/views/user/register.jsp")
		.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String adresse = request.getParameter("adresse");
		String failureMessage = "";
		String successMessage = "";
		
		if (isValidUserInfo(login, password, nom, prenom, adresse)) {
			Client client = clientService.add(new Client(nom, prenom, adresse, login, password));
			if (client != null) {
				successMessage = SAVE_SUCCESS;
			} else {
				failureMessage = SAVE_FAILURE;
			}
		} else {
			failureMessage = INCORRECT_INFO;
		}
		request.setAttribute("failureMessage", failureMessage);
		request.setAttribute("successMessage", successMessage);
		doGet(request, response);
	}

	private boolean isValidUserInfo(String login, String password, String nom, String prenom, String adresse) {			
		return clientService.validateUserInfo(login, password, nom, prenom, adresse);
	}
	
	

}
