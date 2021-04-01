<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<a class="navbar-brand">TorinoUniversity</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item"><a class="nav-link" href="home.jsp">Home</a></li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> Opzioni </a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" href="inserisciCorsista.jsp">Inserisci
						corsista</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="#">Lista corsi</a>
				</div></li>
		</ul>
		<%
		String nome = (String) session.getAttribute("nome");
		if (nome == null) {
		%>

		<ul class="navbar-nav  navbar-right">
			<li><a class="nav-link" href="login.jsp"><i
					class="fas fa-power-off"></i> Login</a></li>
		</ul>


		<%
		} else {
		%>

		<ul class="navbar-nav navbar-right">
			<li class="nav-item"><a class="nav-link disabled" href="#"><i class="fas fa-user-tie"></i>&nbsp;<%= nome %></a>
			</li>
			<li class="nav-item"><a class="nav-link" data-toggle="modal" data-target="#myModal">Logout</a>
			</li>
		</ul>
		<%
		}
		%>
	</div>
</nav>
<jsp:include page="logout.jsp"/>