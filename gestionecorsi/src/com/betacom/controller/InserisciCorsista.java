package com.betacom.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.betacom.architecture.dao.DAOConstants;
import com.betacom.architecture.dao.DAOException;
import com.betacom.architecture.dbaccess.DBAccess;
import com.betacom.businesscomponent.ClientFacade;
import com.betacom.businesscomponent.model.Corsista;
import com.betacom.businesscomponent.model.CorsoCorsista;

@WebServlet("/inserisciCorsista")
public class InserisciCorsista extends HttpServlet implements DAOConstants {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Corsista corsista = getCorsista(request);

		if (corsista != null) {
			try {
				ClientFacade.getInstance().createOrUpdateCorsista(corsista);
				long codCorso = Long.parseLong(request.getParameter("codCorso"));
				CorsoCorsista cc = new CorsoCorsista();
				cc.setCodCorso(codCorso);
				cc.setCodCorsista(corsista.getCodiceCor());
				ClientFacade.getInstance().createCorsoCorsista(cc);

			} catch (DAOException | ClassNotFoundException exc) {
				exc.printStackTrace();
				throw new ServletException(exc.getMessage());
			}
			HttpSession session = request.getSession();
			session.setAttribute("corsistaAppenaInserito", true);
			response.sendRedirect("home.jsp");

		} else {
			response.sendRedirect("error.jsp");
		}
	}

	private Corsista getCorsista(HttpServletRequest request) {
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		Corsista corsista = null;
		try {
			corsista = new Corsista();
			corsista.setNomeCor(request.getParameter("nome"));
			corsista.setCognomeCor(request.getParameter("cognome"));
			corsista.setPreFormativi(Integer.parseInt(request.getParameter("precForm")));

		} catch (Exception exc) {
			exc.printStackTrace();
		}
		return corsista;
	}

}
