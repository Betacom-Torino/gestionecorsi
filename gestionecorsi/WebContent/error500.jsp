<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<script src="https://kit.fontawesome.com/4b9ba14b0f.js"></script>

<style>
body {
	
	background: #2F4F4F;
	color: #F0FFFF;
	font-family: Roboto;
}

a {
	display: inline-block;
	padding: 0.4em 0.9em;
	margin-right: 0.5em;
	margin-bottom: -0.75em;
	border: 2px solid #b9ddfb;
	color: #F0FFFF;
	font-weight: 700;
	text-decoration: none;
	letter-spacing: 0.2em;
	position: relative;
	overflow: hidden;
	transition: 0.3s;
}

a:hover {
	color: #2F4F4F;
}

a:hover:before {
	top: 0;
}

a:before {
	content: "";
	background: #F0FFFF;
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
	background-color: #2F4F4F;
	color: #F0FFFF;
	border: 0px solid #F0FFFF;
}

.button:hover {
	background-color: #F0FFFF;
	color: #2F4F4F;
}
</style>

</head>
<body>
	<div class="row justify-content-center"  style="margin-top: 50px;">

		<div class="col-4 align-self-center" style="font-size: 300px; text-align: center;">
		<i class="fas fa-spinner fa-pulse"> </i>
		</div>
		<div class="col-6 align-self-center" style="text-align: center;">
			<h1 style="font-size: 150px;" >
				<strong>Err 500</strong>
			</h1>
			<br>
			<h2>Sembra che qualcosa sia andato storto</h2>
			<br>
			<h3>
				Torna alla &nbsp; <a href="home.jsp"><i class="fas fa-home"></i></a>
				e riprova.
			</h3>
		</div>
	</div>
	
	<div class="row justify-content-md-center"  style="margin-top:0px;" >
	<h3>
				Oppure torna
				<button class="button" onclick="window.history.back()">INDIETRO</button>
				alla pagina precedente
			</h3>
	</div> 

</body>
</html>