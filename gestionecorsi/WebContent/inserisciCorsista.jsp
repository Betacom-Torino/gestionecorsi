<%@page import="com.betacom.businesscomponent.ClientFacade"%>
<%@page import="com.betacom.businesscomponent.model.Corso"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../CDN.html"%>
<meta charset="ISO-8859-1">
<script>
	function selezionaCorso(idCorso){
		//sendRedirect("");
		
	}

</script>
<title>Inserisci corsista</title>
</head>
<body>

	<div class="container">
		<div class="page-header">
			<h3>Inserimento nuovo corsista</h3>
		</div>
		<form
			action="/<%=application.getServletContextName()%>/inserisciCorsista"
			method="post" class="form-horizontal" id="userForm">

			<div class="form-group">
				<label class="col-md-1 control-label">Nome</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"> <i
							class="glyphicon glyphicon-user"></I>
						</span> <input type="text" name="nome" id="nome" placeholder="Nome..."
							class="form-control">
					</div>
				</div>
				<div class="col-md-7 control-label" id="infoNome"></div>
			</div>

			<div class="form-group">
				<label class="col-md-1 control-label">Cognome</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"> <i
							class="glyphicon glyphicon-user"></I>
						</span> <input type="text" name="cognome" id="cognome"
							placeholder="Cognome..." class="form-control">
					</div>
				</div>
				<div class="col-md-7 control-label" id="infoCognome"></div>
			</div>

			<div class="form-group">
				<label class="col-md-1 control-label">Precedenti formativi</label>
				<div class="col-md-4 inputGroupContainer">
					
				</div>
				<div class="col-md-7 control-label" id="infoPrecForm"></div>
				
				<a class="custom-control custom-radio">
					<input type="radio" class="custom-control-input" id="precForm"
						name="precForm" value="1"> <label
						class="custom-control-label" for="precForm">Si</label>
				</a>
	
				<a class="custom-control custom-radio">
					<input type="radio" class="custom-control-input" id="precForm"
						name="precForm" value="0" checked> <label
						class="custom-control-label" for="precForm">No</label>
				</a>
			</div>
			
			<ul class="nav navbar-nav">
		   		<li class="dropdown">
		    		<a href="#" class="dropdown-toggle" 
		    			data-toggle="dropdown" role="button" >Corso
		    			<span class="caret"></span>
		    		</a>
		    		<ul class="dropdown-menu">
		    		<%
		    			Corso[] corsi = ClientFacade.getInstance().getCorsi();
								
						for(int i=0; i<corsi.length; i++){
		    		%>
		    		<li>
		    			<button type="button" class="btn btn-info btn-xs" 
		    			onclick = "selezionaCorso(<%= corsi[i].getCod()%>)"><%=corsi[i].getNome() %> &nbsp;&nbsp;
							<span class="glyphicon glyphicon-plus"></span>
						</button>
		    		</li>
		    		<%
						}
		    		%>
		     			<li>
		      				<button type="button" class="btn btn-info btn-xs" data-toggle="modal" 
							data-target="#addCorsoModal">Aggiungi Corso &nbsp;&nbsp;
								<span class="glyphicon glyphicon-plus"></span>
							</button>
		     			</li>
		    		</ul>
		    	</li>
		   	</ul>



		</form>
	</div>
</body>
</html>