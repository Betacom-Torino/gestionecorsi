<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="CDN.html"%>
<link rel="stylesheet" href="css/style.css">
<meta charset="ISO-8859-1">
<title>Login Utente</title>
</head>
<body>
	<div class="container">
		<div class="page-header">
			<h3>Inserire i dati per il login</h3>
		</div>
		<form action="<%=request.getContextPath()%>/controllo"
			method="post" class="form-horizontal" id="userForm">

			<!-- -------------------------NOMEADMIN -->
			<div class="form-group">
				<label class="col-md-1 control-label">Nome</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-user"></i></span> <input type="text"
							name="nome" id="nome" placeholder="Nome..."
							class="form-control" autocomplete="nome" required>
					</div>
				</div>
				<div class="col-md-7 control-label" id="infoNome"></div>
			</div>
			
			<!-- -------------------------COGNOMEADMIN -->
			
			<div class="form-group">
				<label class="col-md-1 control-label">Cognome</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-user"></i></span> <input type="text"
							name="cognome" id="cognome" placeholder="Cognome..."
							class="form-control" autocomplete="cognome" required>
					</div>
				</div>
				<div class="col-md-7 control-label" id="infoCognome"></div>
			</div>

			<!-- -------------------------CODADMIN -->
			<div class="form-group">
				<label class="col-md-1 control-label">Codice</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-lock"></i></span> <input type="password"
							name="codice" id="codice" placeholder="Codice..."
							class="form-control" autocomplete="codice" required>
					</div>
				</div>
				<div class="col-md-7 control-label" id="infoCodice"></div>
			</div>

			<div class="row">
				<div class="col-md-4 col-md-offset-1">
					<button type="submit" class="btn btn-warning">
						Login&nbsp; <span class="glyphicon glyphicon-log-in"></span>
					</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>