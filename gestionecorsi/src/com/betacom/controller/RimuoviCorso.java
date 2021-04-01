package com.betacom.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.betacom.architecture.dao.DAOException;
import com.betacom.businesscomponent.ClientFacade;


@WebServlet("/rimuoviCorso")
public class RimuoviCorso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		try {
			String cod=request.getParameter("cod");
			if(cod!=null) {
				//elimina il corso
				ClientFacade.getInstance().deleteCorso(Long.valueOf(cod));
			
			//elimina da corso_corsista le righe del corso cancellato
				ClientFacade.getInstance().deleteCorsoCorsistaByCorso(Long.valueOf(cod));
			
			}
				
			}catch(DAOException| ClassNotFoundException e) {
				e.printStackTrace();
				throw new ServletException();
			}
			response.sendRedirect("eliminaCorsi.jsp");
			}

	
	
	
	}


