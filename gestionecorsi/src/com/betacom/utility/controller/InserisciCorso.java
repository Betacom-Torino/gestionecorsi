package com.betacom.utility.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.betacom.architecture.dao.DAOException;
import com.betacom.businesscomponent.ClientFacade;
import com.betacom.businesscomponent.model.Corso;
import com.betacom.businesscomponent.model.Docente;


@WebServlet("/inserisciCorso")
public class InserisciCorso extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Corso corso = getCorso(request);
		
		if(corso != null) {
			try {
				ClientFacade.getInstance().createOrUpdateCorso(corso);
				
			HttpSession session = request.getSession();
			session.setAttribute("corso", corso);
			session.setAttribute("valore", 1);

			Corso[] corsi = ClientFacade.getInstance().getCorsi();
			
			for(Corso c : corsi) {
				if(c.getNome().equals(corso.getNome())) {
					session.setAttribute("c", c);
				}
			}
			
			
			}catch(DAOException | ClassNotFoundException exc) {
				exc.printStackTrace();
				throw new ServletException(exc.getMessage());
			}
		}
		response.sendRedirect("inserisciCorsista.jsp");
		
	}
	
	private Corso getCorso(HttpServletRequest request) {
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		Corso corso = null;
		try {
			corso = new Corso();
			corso.setNome(request.getParameter("nome"));
			corso.setDataInizio(f.parse(request.getParameter("inizio")));
			corso.setDataFine(f.parse(request.getParameter("fine")));
			corso.setCosto(Double.parseDouble(request.getParameter("costo")));
			
			
			corso.setCommenti(request.getParameter("commento"));
			
			corso.setAula(request.getParameter("aula"));
			
			
			long coddocente = getDocente(request);
			
			corso.setCodDocente(coddocente);
		}catch(Exception exc) {
			exc.printStackTrace();
		}
		return corso;
	}

	private long getDocente(HttpServletRequest request) {
		
		long coddocente = 0;
		String nomeEcognome = request.getParameter("sceltaDocenteName");
		String[] dati = nomeEcognome.split(" ");
		
		Docente[] docenti= null;
		try {
			docenti = ClientFacade.getInstance().getDocenti();
		} catch (DAOException | ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		
		for (Docente doc : docenti) {
			if (doc.getNomeDocente().equals(dati[0]) && doc.getCognomeDocente().equals(dati[1])){
				coddocente = doc.getCodDocente();
			}
		}
		return coddocente;
	}
}
