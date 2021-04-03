package com.betacom.utility.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.betacom.architecture.dao.DAOException;
import com.betacom.businesscomponent.utilities.AccessUtility;

@WebServlet("/controllo")
public class Controllo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String codice = request.getParameter("codice");
		String adminpass;
		int loginAttempts = 0;

		try {
			loginAttempts = Integer.parseInt(session.getAttribute("LOGIN_ATTEMPTS").toString());
		} catch (Exception exc) {
			// setta LOGIN_ATTEMPTS ad 1 la prima volta
			session.setAttribute("LOGIN_ATTEMPTS", 1);
		}

		if (nome != null && cognome != null && codice != null && loginAttempts < 4) {
			try {
				AccessUtility au = new AccessUtility();
				adminpass = au.getAdminPass(nome, cognome);

				if (adminpass != null) {
					if (adminpass.equals(codice)) {
						session.setAttribute("nome", nome);
						session.setAttribute("cognome", cognome);
						
						session.setAttribute("corsoAppenaInserito", false);
						session.setAttribute("corsoAppenaEliminato", false);

						response.sendRedirect("home.jsp");
					} else {
						loginAttempts++;
						session.setAttribute("LOGIN_ATTEMPTS", loginAttempts);
						session.setAttribute("eliminazione", "2");
						response.sendRedirect("home.jsp?#section1");
					}
				} else {
					loginAttempts++;
					session.setAttribute("LOGIN_ATTEMPTS", loginAttempts);
					session.setAttribute("eliminazione", "2");
					response.sendRedirect("home.jsp?#section1");
				}
			} catch (DAOException | ClassNotFoundException exc) {
				exc.printStackTrace();
				throw new ServletException(exc.getMessage());
			}
		} else {

			response.sendRedirect("home.jsp?#section1");
			session.setAttribute("eliminazione", "1");
		}
	}
}
