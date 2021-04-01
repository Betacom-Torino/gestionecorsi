
<%
long codCorso = 0;
//String s  = (request.getParameter("codCorso"));
%>

<%@page import="com.betacom.businesscomponent.ClientFacade"%>
<%@page import="com.betacom.businesscomponent.model.Corso"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="CDN.html"%>
<meta charset="ISO-8859-1">
<script>
	function selezionaCorso(idCorso) {
		//sendRedirect("");

	}
</script>
<title>Inserisci corsista</title>
</head>
<body>

	<div class="container">
		<div class="page-header">
			<h3>Inserimento nuovo corsista</h3>
		</div>
		<%
		String s = (request.getParameter("codCorso"));
		if (s != null) {
		%>
		<form
			action="/<%=application.getServletContextName()%>/inserisciCorsista"
			method="post" class="form-horizontal" id="userForm">

			<div class="form-group">
				<label class="col-md-1 control-label">Nome</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"> <i
							class="glyphicon glyphicon-user"></I>
						</span> <input type="text" name="nome" id="nome" placeholder="nome..."
							value="<%=request.getParameter("nomeCorsista") != null ? request.getParameter("nomeCorsista") : ""%>"
							class="form-control">
					</div>
				</div>
				<div class="col-md-7 control-label" id="infoNome"></div>
			</div>

			<div class="form-group">
				<label class="col-md-1 control-label">Cognome</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"> <i
							class="glyphicon glyphicon-user"></I>
						</span> <input type="text" name="cognome" id="cognome"
							placeholder="cognome..."
							value="<%=request.getParameter("cognomeCorsista") != null ? request.getParameter("cognomeCorsista") : ""%>"
							class="form-control">
					</div>
				</div>
				<div class="col-md-7 control-label" id="infoCognome"></div>
			</div>

			<div class="form-group">
				<label class="col-md-1 control-label">Precedenti formativi</label>
				<div class="col-md-4 inputGroupContainer"></div>
				<div class="col-md-7 control-label" id="infoPrecForm"></div>

				<a class="custom-control custom-radio"> <input type="radio"
					class="custom-control-input" id="precForm" name="precForm"
					value="1"> <label class="custom-control-label"
					for="precForm">Si</label>
				</a> <a class="custom-control custom-radio"> <input type="radio"
					class="custom-control-input" id="precForm" name="precForm"
					value="0" checked> <label class="custom-control-label"
					for="precForm">No</label>
				</a>
			</div>
			<%
			codCorso = Long.parseLong(s);
			%>
			<h1>
				CI SIAMOOOOOOOOO: codcorso =
				<%=s%></h1>
			<div class="btn-group">
			<button type="button" class="btn btn-primary dropdown-toggle"
				data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				Corso</button>
			<div class="dropdown-menu">
				<%
				Corso[] corsi = ClientFacade.getInstance().getCorsi();
				for (int i = 0; i < corsi.length; i++) {
				%>
				<a class="dropdown-item"
					href="inserisciCorsista.jsp?codCorso=<%=corsi[i].getCod()%>&nomeCorsista=#nome&cognomeCorsista=#cognome"><%=corsi[i].getNome()%></a>
				<%
				}
				%>
				<div class="dropdown-divider"></div>
				<a class="dropdown-item" href="#">
					<button type="button" class="btn btn-primary btn-sm"
						data-toggle="modal" data-target="#addCorsoModal">Aggiungi
						Corso</button>
				</a>

			</div>
		</div>
		</form>
		<%
		} else {
		%>
		<div class="btn-group">
			<button type="button" class="btn btn-primary dropdown-toggle"
				data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				Corso</button>
			<div class="dropdown-menu">
				<%
				Corso[] corsi = ClientFacade.getInstance().getCorsi();
				for (int i = 0; i < corsi.length; i++) {
				%>
				<a class="dropdown-item"
					href="inserisciCorsista.jsp?codCorso=<%=corsi[i].getCod()%>&nomeCorsista=nome&cognomeCorsista=cognome"><%=corsi[i].getNome()%></a>

				<%
				}
				%>
				<div class="dropdown-divider"></div>
				<a class="dropdown-item" href="#">
					<button type="button" class="btn btn-primary btn-sm"
						data-toggle="modal" data-target="#addCorsoModal">Aggiungi
						Corso</button>
				</a>

			</div>
		</div>
		<%
		}
		%>
		
	</div>
</body>
</html>