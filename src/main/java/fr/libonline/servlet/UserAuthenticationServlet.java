package fr.libonline.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.libonline.model.Client;

@WebServlet(urlPatterns = {
		"/login-page",
		"/register-page",
		"/disconnect"
})
public class UserAuthenticationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getServletPath().equals("/login-page")) {
			response.sendRedirect("login");
		} else if (request.getServletPath().equals("/register-page")) {
			response.sendRedirect("register");
		} else if (request.getServletPath().equals("/disconnect")) {
			request.getSession().removeAttribute("currentUser");
			response.sendRedirect("livres");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
