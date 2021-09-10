package fr.libonline.servlet;

import static java.util.stream.Collectors.toMap;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.libonline.model.Livre;
import fr.libonline.service.LivreService;

@WebServlet(urlPatterns = {
		"/panier",
		"/panier-retirer"
})
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private LivreService lService;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (lService == null) {
			lService = new LivreService();
		}
		// R�cup�ration du panier depuis la session
		Map<Integer, Integer> cart = (Map<Integer, Integer>) request.getSession().getAttribute("cart");
		// S'il n'existe pas, on le cr�e
		if (cart == null) {
			request.getSession().setAttribute("cart", new HashMap<Integer, Integer>());
			cart = (Map<Integer, Integer>) request.getSession().getAttribute("cart");
		}
		// Gestion du retrait et de l'ajout du livre dans le panier
		String livreId = request.getParameter("livreId");
		if (livreId != null) {
			int parsedId = Integer.parseInt(livreId);
			if (request.getServletPath().equals("/panier-retirer")) {
				// Retrait
				cart.remove(parsedId);
			} else {
				// Ajout
				Livre fetchedBook = lService.findById(parsedId);
				if (fetchedBook != null) {
					int id = fetchedBook.getId();
					if (cart.containsKey(id)) {
						// Si le livre est d�j� dans le panier, on augmente sa quantit�
						cart.replace(id, cart.get(id) + 1);
					} else {
						// Si c'est pas le cas, on l'ajoute en initialisant sa quantit�
						cart.put(id, 1);
					}
				}
			}
			// On r�cup�re le panier d�taill� et on calcule le montant total
			request.getSession().setAttribute("detailedCart", getDetailedCart(cart));
			request.getSession().setAttribute("totalPanier", computeTotalCartAmount(cart));
			response.sendRedirect(request.getHeader("referer"));
			return;
		}
		this.getServletContext()
			.getRequestDispatcher("/WEB-INF/views/panier/cart_detail.jsp")
			.forward(request, response);
	}

	private Map<Livre, Integer> getDetailedCart(Map<Integer, Integer> cart) {
		return cart.entrySet()
					.stream()
					.collect(toMap(
								set -> lService.findById(set.getKey()), 
								Map.Entry::getValue));
	}

	private Double computeTotalCartAmount(Map<Integer, Integer> cart) {
		return lService.findAll()
						.stream()
						.filter(livre -> cart.containsKey(livre.getId()))
						.mapToDouble(livre -> getTotalPerQuantity(livre, cart))
						.sum();
	}

	private Double getTotalPerQuantity(Livre livre, Map<Integer, Integer> cart) {
		return livre.getPrix() * cart.get(livre.getId());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
