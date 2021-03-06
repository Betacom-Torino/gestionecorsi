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
	
	<script>
	/*
	setTimeout( function () {
		alert( "moo" ); }, 2000 ); //displays msg in 10 seconds
		
	$('.alert').alert()*/
	</script>
	<%
	String nome = (String) session.getAttribute("nome");
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
	
	<%
	} else {
		
		
		//controllo se ho inserito un nuovo corso
		boolean corsoInserito = (boolean)session.getAttribute("corsoAppenaInserito");
		if(corsoInserito != false){
			out.write("<div class=\"alert alert-success\" id=\"notificationId\">");
			out.write("<strong>Corso inserito con successo.</strong></div>");
			out.write("<script type='text/javascript'>\n");
			out.write("(function myFunction() {" +
					"setTimeout(function(){ " +
					"document.getElementById(\"notificationId\").style.display = \"none\"; }, 2500); })()");
			out.write("</script>\n");
		}
		session.setAttribute("corsoAppenaInserito", false);
		
		
		//controllo se ho inserito un nuovo corsista
		boolean corsistaInserito = (boolean)session.getAttribute("corsistaAppenaInserito");
		if(corsistaInserito != false){
			out.write("<div class=\"alert alert-success\" id=\"notificationId\">");
			out.write("<strong>Corsista inserito con successo.</strong></div>");
			out.write("<script type='text/javascript'>\n");
			out.write("(function myFunction() {" +
					"setTimeout(function(){ " +
					"document.getElementById(\"notificationId\").style.display = \"none\"; }, 2500); })()");
			out.write("</script>\n");
		}
		session.setAttribute("corsistaAppenaInserito", false);
		
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
					<input style="color: white;" type="submit" class="btn" value="Inserisci Corsista"
						id="center">
				</form>
			</div>
			<div class="col-sm">
				<form action="visualizzaStatistiche.jsp">
					<input style="color: white;" type="submit" class="btn" value="Visualizza Statistiche"
						id="center">
				</form>
			</div>
			<div class="col-sm">
				<form action="eliminaCorso.jsp">
					<input style="color: white;" type="submit" class="btn" value="Elimina Corso" id="center">
				</form>
			</div>
		</div>
	</div>
	
	<%
	}
	%>

	<%
	String eliminazione = (String) session.getAttribute("eliminazione");

	if (eliminazione != null && eliminazione.equals("1")) {
	%>

	<script type="text/javascript">
		$(window).on('load', function() {
			$('#myModal2').modal('show');
		});
	</script>



	<!-- The Modal -->
	<div class="modal fade" id="myModal2">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content"
				style="background-color: rgba(0, 0, 0, 0.85) !important; color: white;">

				<!-- Modal Header -->
				<div class="modal-header border-0">
					<h4 class="modal-title">
						<strong>Warning!</strong>
					</h4>
					<button type="button" class="close" data-dismiss="modal"
						style="color: white;">&times;</button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">
					<p>Hai superato il limite massimo di tentativi di login.</p>
					<span>Contatta l'amministratore per ripristinare il tuo
						account.</span>
				</div>

				<!-- Modal footer -->
				<div class="modal-footer border-0">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Chiudi</button>
				</div>

			</div>
		</div>
	</div>

	<%
	}

	else if (eliminazione != null && eliminazione.equals("2")) {
	%>

	<script type="text/javascript">
		$(window).on('load', function() {
			$('#myModal2').modal('show');
		});
	</script>



	<!-- The Modal -->
	<div class="modal fade" id="myModal2">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content"
				style="background-color: rgba(0, 0, 0, 0.85) !important; color: white;">

				<!-- Modal Header -->
				<div class="modal-header border-0">
					<h4 class="modal-title">
						<strong>Warning!</strong>
					</h4>
					<button type="button" class="close" data-dismiss="modal"
						style="color: white;">&times;</button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">
					<p>Uno dei campi inseriti non ? corretto!</p>
					<p>Contatta l'amministratore per ripristinare il tuo
						account.</p>
						
						<p>Altrimenti ritenta l'inserimento.</p>
				</div>

				<!-- Modal footer -->
				<div class="modal-footer border-0">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Chiudi</button>
				</div>

			</div>
		</div>
	</div>

	<%
	}

	session.setAttribute("eliminazione", null);
	%>


<%@ include file="footer.html"%>
</body>
</html>