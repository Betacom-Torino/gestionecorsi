<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="CDN.html"%>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/style2.css">

<script src="https://kit.fontawesome.com/4b9ba14b0f.js"></script>

<style>

a:hover {
	color: #2F4F4F;
}

a:hover:before {
	top: 0;
}

a:before {
	content: "";
	background: white;
	height: 100%;
	width: 100%;
	position: absolute;
	top: -100%;
	left: 0;
	transition: 0.3s;
	z-index: -1;
}

.button {
	border: none;
	color: white;
	padding: 12px 15px;
	text-align: center;
	font-weight: bold;
	display: inline-block;
	font-size: 18px;
	transition-duration: 0.4s;
	cursor: pointer;
	background-color:  white;
	color:#2F4F4F;
	border: 0px solid #F0FFFF;
}

.button:hover {
	background-color: #2F4F4F;
	color: white;
}
</style>

</head>

<body>
	<%@ include file="nav.jsp"%>
	<div class="container">
		<div style="margin-top: 50px; font-size: 200px; text-align: center;">


			4<i class="far fa-question-circle fa-spin"></i>4

			<div style="text-align: center;">
				<h1 style="font-size: 40px;">
					<strong>Pagina non trovata!</strong>
				</h1>
			</div>
			<div style="text-align: center; margin-top: 50px;">

				<h3>Sembra che questa pagina non esista <i class="fas fa-frown"></i></h3>
			</div>
		</div>
	</div>
	<div style="text-align: center; margin-top: 50px;">
		<h3>
			Ricomincia dalla &nbsp; <a href="home.jsp"><i class="fas fa-home" style="color: #2F4F4F;"></i></a>
			oppure torna
			<button class="button" onclick="window.history.back()">INDIETRO</button>
			alla pagina precedente
		</h3>
	</div>
<%@ include file="footer.html"%>
</body>
</html>