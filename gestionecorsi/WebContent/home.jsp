<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="CDN.html"%>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/style2.css">
<title>Home</title>
</head>
<body>
	<%@ include file="nav.jsp"%>
	<%
	nome = (String) session.getAttribute("nome");
	if (nome == null) {
	%>
	<div class="container-fluid px-0" id="section">
		<div class="row mx-0">
			<div class="col-12 px-0">
				<img src="img/img.jpg" class="img-fluid w-100">
				<form action="#section1">
					<input type="submit" class="btn" id="bottone" value="Vai al login" />
				</form>
			</div>
		</div>
		<%@ include file="login.jsp"%>
	</div>
	<%@ include file="footer.html"%>
	<%
	} else {
	%>
	<div class="container-fluid px-0" id="section">
		<div class="row mx-0">
			<div class="col-12 px-0">
				<img src="img/img.jpg" class="img-fluid w-100">
				<form action="#menu">
					<input type="submit" class="btn" id="bottone" value="Menu" />
				</form>
			</div>
		</div>
		<div class="row" id="menu">
			<div class="col-sm">
				<form action="inserisciCorsista.jsp">
					<input type="submit" class="btn" value="Inserisci Corsista"
						id="center">
				</form>
			</div>
			<div class="col-sm">
				<form action="visualizzaStatistiche.jsp">
					<input type="submit" class="btn" value="Visualizza Statistiche"
						id="center">
				</form>
			</div>
			<div class="col-sm">
				<form action="eliminaCorso.jsp">
					<input type="submit" class="btn" value="Elimina Corso" id="center">
				</form>
			</div>
		</div>
	</div>
	<%@ include file="footer.html"%>
	<%
	}
	%>
</body>
</html>