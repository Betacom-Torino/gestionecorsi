
<%@page import="com.betacom.businesscomponent.model.Docente"%>
<%@page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="CDN.html"%>
<%@page import="com.betacom.businesscomponent.ClientFacade"%>
<%@page import="com.betacom.businesscomponent.model.Corso"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<link rel="stylesheet" href="css/style2.css">
<script src="js/convalida.js"></script>



<title>Inserisci Corsista</title>
</head>
<body>
<%
	
	String nome = (String)session.getAttribute("nome");
	if(nome!=null){
		

%>
	<%@ include file="nav.jsp"%>
	<div class="container" style="margin-top: 20px;" id="inserisciCorsista">

		<div class="page-header">
			<h3 style="margin-top: 35px; color: #133347;">
				<strong>Inserimento nuovo corsista</strong>
			</h3>
		</div>
		<form action="/gestionecorsi/inserisciCorsista" method="post"
			class="form-horizontal" id="corsistaForm"
			style="margin-bottom: 50px;">
			<div class="btn-group" style="width: 184px;">
				<button type="button" class="btn btn-primary dropdown-toggle"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"
					style="background-color: #133347; width: 100%; border-radius: 0px; margin-top: 10px; margin-bottom: 25px; margin-left: 20px;">
					Corso</button>
				<div class="dropdown-menu">
					<%
					String valoreNome = request.getParameter("nome");
					String valoreCognome = request.getParameter("cognome");

					
					Corso[] corsi = ClientFacade.getInstance().getCorsiDisponibili();
					for (int i = 0; i < corsi.length; i++) {
					%>
					<a class="dropdown-item"
						href="inserisciCorsista.jsp?codCorso=<%=corsi[i].getCod()%>">
						<%=corsi[i].getNome()%>&nbsp;&nbsp;
						<i class="fas fa-graduation-cap"></i></a>
					<%
					}
					%>

				</div>

			</div>
			
			<div class="form-group">
				<label class="col-md-2 control-label"><strong><span
							class="	far fa-user"></span>&nbsp;Nome</strong></label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"> 
						</span> <input type="text" name="nome" id="nome" placeholder="nome..."
							value="<%=request.getParameter("nome") != null ? request.getParameter("nome") : "" %>"
							class="form-control" required>
					</div>
				</div>
				<div class="col-md-7 control-label" id="infoNome"></div>
			</div>

			<div class="form-group">
				<label class="col-md-2 control-label"><strong><i
							class="	far fa-user"></i>&nbsp;Cognome</strong></label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon">
						</span> <input type="text" name="cognome" id="cognome"
							placeholder="cognome..."
							value="<%=request.getParameter("cognome") != null ? request.getParameter("cognome") : "" %>"
							class="form-control" required>
					</div>
				</div>
				<div class="col-md-7 control-label" id="infoCognome"></div>
			</div>

			<div class="form-group" style="padding-left: 15px;">
				<label class="control-label"><strong>Precedenti
						formativi</strong></label> <a class="custom-control custom-radio"> <input
					type="radio" class="custom-control-input" id="precFormSi"
					name="precForm" value="1"> <label
					class="custom-control-label" for="precFormSi">Si</label>
				</a> <a class="custom-control custom-radio"> <input type="radio"
					class="custom-control-input" id="precFormNo" name="precForm"
					value="0" required> <label class="custom-control-label"
					for="precFormNo">No</label>
				</a>

			</div>
			<%
			String s = (request.getParameter("codCorso"));
			
			if(s!=null){
							
				Corso corsetto = ClientFacade.getInstance().getCorsoByCod(Long.parseLong(s));
	
				Docente docente = ClientFacade.getInstance().getDocenteByCod(corsetto.getCodDocente());
	
				SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
			%>
			<div class="table-responsive" style="padding-left: 15px;">
				<table class="table table-hover" style="width: 100%;">
					<tr>
						<td><strong>Nome Corso</strong></td>
						<td><%=corsetto.getNome()%></td>
					</tr>
					<tr>
						<td><strong>Data Inizio</strong></td>
						<td><%=f.format(corsetto.getDataInizio())%></td>
					</tr>
					<tr>
						<td><strong>Data Fine</strong></td>
						<td><%=f.format(corsetto.getDataFine())%></td>
					</tr>
					<tr>
						<td><strong>Docente Corso</strong></td>
						<td><%=docente.getNomeDocente()%>&nbsp;<%=docente.getCognomeDocente()%></td>
					</tr>
					<tr>
						<td><strong>Costo Corso</strong></td>
						<td><%=String.format("%.2f", corsetto.getCosto())%>&euro;</td>
					</tr>
					<tr>
						<td><strong>Commento</strong></td>
						<td><%=corsetto.getCommenti()%></td>
					</tr>
					<tr>
						<td><strong>Aula corso</strong></td>
						<td><%=corsetto.getAula()%></td>
					</tr>
				</table>
			</div>
			
			
			<div class="row">
				<div class="col-md-4 col-md-offset-1">
					<input type="hidden" name="codCorso" value="<%=corsetto.getCod()%>">
					<button type="submit" class="btn btn-primary"
						style="border-radius: 0px; margin-left: 30px; background-color: #133347;">
						Inserisci&nbsp;</button>
				</div>
			</div>
			<%
			} 
			%>
			<hr>
			<a href="inserisciCorsista.jsp"
				style="margin-top: 30px; color: #133347; margin-left: 30px;">Torna
				alla selezione del Corso</a>	
		</form>

	</div>
	<%@ include file="footer.html"%>
</body>
<%
	}else{
		response.sendRedirect("accessonegato.jsp");
	}
%>
</html>