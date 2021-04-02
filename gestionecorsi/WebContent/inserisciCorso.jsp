<%@page import="com.betacom.businesscomponent.ClientFacade"%>
<%@page import="com.betacom.businesscomponent.model.Docente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserimento nuovo corso</title>
<%@include file="CDN.html"%>
<link rel="stylesheet" href="css/style2.css">
<script src="js/convalida.js"></script>
</head>
<body>
	<%@ include file="nav.jsp"%>
	<div class="container" style="height: 100vh; margin-top: 20px; " id="inserisciCorso" >
	
		<div class="page-header">
			<h3 style="margin-top: 25px; margin-bottom: 35px; color: #133347;">
				<strong>Inserimento nuovo corso</strong>
			</h3>
		</div>
		<form action="/gestionecorsi/inserisciCorso" method="post"
			class="form-horizontal" id="corsoForm"
			style="margin-bottom: 50px;" >

			<div class="form-group">
				<label class="col-md-1 control-label"><strong>Nome</strong></label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon">
							<i class="fas fa-graduation-cap"></i>
						</span> 
						<input type="text" name="nome" id="nome" placeholder="Nome corso..." class="form-control">
					</div>
				</div>
				<div class="col-md-7 control-label" id="infoNome"></div>
			</div>

			<div class="form-group">
				<label class="col-md-1 control-label"><strong>Data Inizio</strong></label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group date" id="data1">
						<span class="input-group-addon">
							<i class="fas fa-calendar-alt"></i>
						</span> 
						<input type="text" name="inizio" id="inizio" placeholder="DD/MM/YYYY..."
							class="form-control">
					</div>
				</div>
				<div class="col-md-7 control-label" id="infoDataInizio"></div>
			</div>
			<div class="form-group">
				<label class="col-md-1 control-label"><strong>Data Fine</strong></label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group date" id="data2">
						<span class="input-group-addon">
							<i class="fas fa-calendar-alt"></i>
						</span> 
						<input type="text" name="fine" id="fine" placeholder="DD/MM/YYYY..."
							class="form-control">
					</div>
				</div>
				<div class="col-md-7 control-label" id="infoDataFine"></div>
			</div>
			
			<div class="form-group">
				<label class="col-md-1 control-label"><strong>Costo</strong></label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="fas fa-graduation-cap"></i></span> 
							<input type="number"
							name="costo" id="costo"
							class="form-control">
					</div>
				</div>
				<div class="col-md-7 control-label" id="infoCosto"></div>
			</div>
			<div class="form-group">
				<label class="col-md-1 control-label"><strong>Commento</strong></label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="fas fa-graduation-cap"></i></span> 
							<textarea cols="60" rows="3" name="commento" id="commento"
	 					placeholder="Commento..." class="form-control" style="resize: none"></textarea>
					</div>
				</div>
				<div class="col-md-7 control-label" id="infoCommento"></div>
			</div>
			<div class="form-group">
				<label class="col-md-1 control-label"><strong>aula</strong></label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="fas fa-graduation-cap"></i></span> 
							<input type="text"
							name="aula" id="aula" placeholder="Aula..."
							class="form-control">
					</div>
				</div>
				<div class="col-md-7 control-label" id="infoAula"></div>
			</div>

			<label><strong>Docente:</strong>
				<input list="sceltaDocente" name="sceltaDocenteName" id="sceltaDocenteId"/>
			</label>
			<datalist id="sceltaDocente">
			<%
				Docente[] docenti = ClientFacade.getInstance().getDocenti();
				for(int i = 0; i < docenti.length; i++) {
			%>
			  <option value="<%=docenti[i].getNomeDocente()%>-<%=docenti[i].getCognomeDocente()%>">  
			<%
				}
						
			%>
			</datalist>
			<input type="submit" class="btn btn-primary" id="submitButtonId" value="Crea corso" disabled></input>
			
			
			
			<script>
			(function() {
			    $('input').keyup(function() {
	
			        var empty = false;
			        
		        	if($("#nome").val() == '' || $("#inizio").val() == '' || $("#fine").val() == '' 
				    	|| $("#costo").val() == '' || $("#aula").val() == '' || $("#sceltaDocenteId").val() == ''){
		        		empty = true;
			        }
	
			        if (empty) {
			            $('#submitButtonId').attr('disabled', 'disabled');
			        } else {
			            $('#submitButtonId').removeAttr('disabled');
			        }
			    });
			})()
			(function() {
			    $('input').change(function() {
	
			        var empty = false;
			        
		        	if($("#nome").val() == '' || $("#inizio").val() == '' || $("#fine").val() == '' 
				    	|| $("#costo").val() == '' || $("#aula").val() == '' || $("#sceltaDocenteId").val() == ''){
		        		empty = true;
			        }
	
			        if (empty) {
			            $('#submitButtonId').attr('disabled', 'disabled');
			        } else {
			            $('#submitButtonId').removeAttr('disabled');
			        }
			    });
			})()
			</script>
		</form>
	</div>
	<!-- TODO: INCLUDERE IL FOOTER -->
</body>
</html>