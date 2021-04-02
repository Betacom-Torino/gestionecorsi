package com.betacom.utility.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.betacom.architecture.dao.DAOException;
import com.betacom.businesscomponent.ClientFacade;
import com.betacom.businesscomponent.model.Corsista;
import com.betacom.businesscomponent.model.CorsoCorsista;

@WebServlet("/inserisciCorsista")
public class InserisciCorsista extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Corsista corsista = getCorsista(request);

		if (corsista != null) {
			try {
				ClientFacade.getInstance().createOrUpdateCorsista(corsista);
				long codCorso = Long.parseLong(request.getParameter("codCorso"));
				Corsista[] corsisti = ClientFacade.getInstance().getCorsisti();
				long codCorsista = 0;
				for (Corsista c : corsisti) {
					if (c.getNomeCor().equals(corsista.getNomeCor())
							&& c.getCognomeCor().equals(corsista.getCognomeCor())
							&& c.getPreFormativi() == corsista.getPreFormativi()) {
						codCorsista = c.getCodiceCor();
					}
				}
				CorsoCorsista cc = new CorsoCorsista();
				cc.setCodCorso(codCorso);
				cc.setCodCorsista(codCorsista);
				ClientFacade.getInstance().createCorsoCorsista(cc);
			} catch (DAOException | ClassNotFoundException exc) {
				exc.printStackTrace();
				throw new ServletException(exc.getMessage());
			}
		}
		response.sendRedirect("inserisciCorsista.jsp");

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
