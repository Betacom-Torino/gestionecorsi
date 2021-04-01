
<%@page import="com.betacom.businesscomponent.ClientFacade"%>
<%@page import="com.betacom.businesscomponent.model.Corso"%>
<%
String username = (String) session.getAttribute("username");
if (username != null) {
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="CDN.html"%>
<link rel="stylesheet" href="css/style.css">
<meta charset="ISO-8859-1">
<title>Corsi futuri</title>
</head>
<body>
	<jsp:include page="nav.jsp" />
	<div class="container">
		<div class="page-header">
			<h3>Corsi non ancora avviati</h3>
		</div>
		<p>

			<% 
//inserisco in un array tutti i corsi non ancora iniziati
	Corso[] corsi = ClientFacade.getInstance().getCorsiNonIniziati(); //facciata: select su corsi non acora iniziati
				
%>


			Totale corsi non ancora avviati:&nbsp;
			<%= corsi.length  %>;
		</p>
		<div class="table-responsive">
			<table class="table table-hover" style="width: 100%;">
				<thead>
					<tr>
						<th style="width: 200px;">Codice</th>
						<th style="width: 200px;">Nome</th>
						<th style="width: 200px;">Inizio</th>
						<th style="width: 200px;">Fine</th>
						<th style="width: 200px;">Costo</th>
						<th style="width: 200px;">Commenti</th>
						<th style="width: 200px;">Aula</th>
						<th style="width: 200px;">Rimuovi</th>
					</tr>
				</thead>
				<tbody>
					<%
					
for(Corso c:corsi){
	
					%>
					<tr>
						<td><%=c.getCod()%></td>
						<td><%=c.getNome()%></td>
						<td><%=c.getDataInizio()%></td>
						<td><%=c.getDataFine()%></td>
						<td><%=c.getCosto()%></td>
						<td><%=c.getCommenti()%></td>
						<td><%=c.getAula()%></td>

						<td>
							
							<% System.out.println("VALORE CODICE "+c.getCod() ); %>
							<% System.out.println(application.getServletContextName() ); %>
							<form
								action="/<%=application.getServletContextName()%>/rimuoviCorso?cod=<%=c.getCod()%>"
								method="post">
								<button type="button" class="btn btn-outline-danger">
									<i class="glyphicon glyphicon-trash"></i> elimina
								</button>
							</form>
						</td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
		</div>
		<hr>
	</div>
	<footer class="footer"><%@include file="footer.html"%></footer>
</body>
</html>
<%
} else {
response.sendRedirect("error.jsp");   //accesso ala pagina senza login
}
%>
