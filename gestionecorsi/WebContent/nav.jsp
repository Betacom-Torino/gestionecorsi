<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<a class="navbar-brand" style="color: white;" href="home.jsp">TorinoUniversity</a>
	<%
	String nome = (String) session.getAttribute("nome");
	if (nome != null) {
	%>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
		</ul>
		<ul class="navbar-nav navbar-right">
			<li class="nav-item"><a class="nav-link"
				href="inserisciCorsista.jsp">Inserisci corsista</a></li>
			<li class="nav-item"><a class="nav-link"
				href="visualizzaStatistiche.jsp">Visualizza Statistiche</a></li>
			<li class="nav-item"><a class="nav-link" href="eliminaCorsi.jsp">Elimina
					corso</a></li>
			<li class="nav-item"><a class="nav-link disabled" href=""><i
					class="fas fa-user-tie"></i>&nbsp;<%=nome%></a></li>
			<li class="nav-item"><a class="nav-link" data-toggle="modal"
				data-target="#myModal">Logout</a></li>
		</ul>
		<%
		}
		%>
	</div>
</nav>
<jsp:include page="logout.jsp" />