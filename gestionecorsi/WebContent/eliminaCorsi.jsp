
<%@page import="java.sql.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.betacom.businesscomponent.ClientFacade"%>
<%@page import="com.betacom.businesscomponent.model.Corso"%>
<%
String username = (String) session.getAttribute("nome");
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
	<%
	
	//controllo se ho eliminato un corso esistente
	boolean corsoEliminato = (boolean)session.getAttribute("corsoAppenaEliminato");
	if(corsoEliminato != false){
		out.write("<div class=\"alert alert-success\" id=\"notificationId\">");
		out.write("<strong>Corso eliminato con successo.</strong></div>");
		out.write("<script type='text/javascript'>\n");
		out.write("(function myFunction() {" +
				"setTimeout(function(){ " +
				"document.getElementById(\"notificationId\").style.display = \"none\"; }, 2500); })()");
		out.write("</script>\n");
	}
	session.setAttribute("corsoAppenaEliminato", false);
	
	%>
	
	<div class="container" style="margin-top:40px;">
		<div class="page-header">
			<h3>Corsi non ancora avviati</h3>
		</div>
		<p>

			<%
			//inserisco in un array tutti i corsi non ancora iniziati
			Corso[] corsi = ClientFacade.getInstance().getCorsiNonIniziati(); //facciata: select su corsi non acora iniziati
			%>


			Totale corsi non ancora avviati:&nbsp;
			<%=corsi.length%>
		</p>



		<div class="table-responsive">
			<table class="table table-hover" style="width: 100%;">
				<thead>
					<tr style="background-color: #133347; color: white; text-align: center;">
						<th style="width: 200px;">Codice</th>
						<th style="width: 200px;">Nome</th>
						<th style="width: 200px;">Inizio</th>
						<th style="width: 200px;">Fine</th>
						<th style="width: 200px;">Costo</th>
						<th style="width: 200px;">Aula</th>
						<th style="width: 200px;">Rimuovi</th>
					</tr>
				</thead>
				<tbody>
					<%
					
					for (Corso c : corsi) {
					%>
					<tr style="text-align: center;">
						<td><%=c.getCod()%></td>
						<td><%=c.getNome()%></td>
						<td><%Date p=new Date(c.getDataInizio().getTime()); %> <%=p %></td>
						<td><%Date p1=new Date(c.getDataFine().getTime()); %> <%=p1%></td>
						<td><%=c.getCosto()%> &euro;</td>
						<td><%=c.getAula()%></td>

						<td>
							<%System.out.println(" contesto "+ request.getContextPath()+" codice corso "+c.getCod()); %>
							<form
								action="<%=request.getContextPath()%>/rimuoviCorso?cod=<%=c.getCod()%>"
								method="post">
								<button type="submit" class="btn btn-outline-secondary">
									<i class="fas fa-trash"></i> elimina
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
	
	
		<div style=" margin-bottom: 100px;">
			
				<form action="home.jsp"
					method="post">
					<button type="submit" class="btn btn-outline-primary">
						<i class="fas fa-home"></i>&nbsp;Torna alla Home</button>
						
				</form>
				<br>
			</div>
			</div>
		
	<footer class="footer"><%@include file="footer.html"%></footer>
</body>
</html>
<%
} else {
response.sendRedirect("accessonegato.jsp"); //accesso ala pagina senza login
}
%>

