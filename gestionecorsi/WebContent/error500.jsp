<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>

<script src="https://kit.fontawesome.com/4b9ba14b0f.js"></script>

<style>
body {
	position: absolute;
	width: 800px;
	height: 200px;
	z-index: 15;
	top: 20%;
	left: 25%;
	margin: -50px 0 0 -50px;
	background: #2F4F4F;
	color: #F0FFFF;
	font-family: Roboto;
}

p {
	width: 100%;
	font-size: 20px;
}

a {
	display: inline-block;
	padding: 0.6em 1em;
	margin-right: 1em;
	margin-bottom: -1em;
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

</style>

</head>
<body>
	<div class="container">

		<div class="row justify-content-md-center"
			style="font-size: 150px; text-align: center;">
			<i class="fas fa-power-off"> 500</i>
		</div>

		<div class="row justify-content-md-center" style="text-align: center;">
			<br> <br>
			<h1>
				<strong>SPEGNI TUTTO</strong>
			</h1>

			<br>
			<h2>
				Se proprio ci tieni, torna alla &nbsp; <a href="home.jsp">HOME</a> e
				riprova.
			</h2>
		</div>
	</div>

</body>
</html>