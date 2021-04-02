package com.betacom.utility.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		try {
			Connection conn = DBAccess.getConnection();
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(NUMERO_ISCRITTI_CORSI);
			rs.beforeFirst();
			while(rs.next()) {
				if(rs.getLong(1)==Long.parseLong(request.getParameter("codCorso"))) {
					if(rs.getInt(2)<=11) {
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

					} else {
						response.sendRedirect("error.jsp");
					}
				}
			}
		} catch (SQLException sql) {
			sql.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
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
