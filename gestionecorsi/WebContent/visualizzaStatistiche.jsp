<%@page import="com.betacom.businesscomponent.model.Corso"%>
<%@page import="com.betacom.businesscomponent.model.Corsista"%>
<%@page import="com.betacom.businesscomponent.ClientFacade"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="CDN.html" %>
<link rel="stylesheet" href="css/style.css">
<meta charset="ISO-8859-1">
<title>Visualizza statistiche</title>
</head>
<body >
<div class="container" >

	<h1 align="center"><strong>Statistiche</strong></h1>
	
	<div>
  
  <p><button class="btn btn-primary btn-lg btn-block" type="button" data-toggle="collapse" data-target="#elencoCorsisti" aria-expanded="false" aria-controls="collapseExample">
   Elenco Corsi </button><p>
   
   <div class="collapse" id="elencoCorsisti">
	  <div class="card card-body">
	    <div class="table-responsive">
			<table class="table table-hover" style="width:100%;">
				<thead>
					<tr>
					<th style="width:200px">Codice Corsista</th>
					<th style="width:200px">Nome</th>
					<th style="width:200px">Cognome</th>
					<th style="width:200px">Precedenti formativi</th>
					</tr>
				</thead>
				<tbody>
					<%
						Corsista[] corsisti=ClientFacade.getInstance().getCorsisti();
						
						for(int i=0; i<corsisti.length; i++){
							
					%>
					<tr  data-toggle="collapse" data-target="#elencoCorsi" aria-expanded="false" aria-controls="collapseExample">
					<td><%= corsisti[i].getCodiceCor()%></td>
					<td><%= corsisti[i].getNomeCor()%></td>
					<td><%= corsisti[i].getCognomeCor()%></td>
					<td><%= corsisti[i].getPreFormativi()%></td> <!-- magari con un if metti simbolo check o x -->
					</tr>
				</tbody>
			</table>
		</div>
	  </div>
	</div>

	
						
<div class="collapse" id="elencoCorsi">
	<div class="card card-body">
	 	<div class="table-responsive">
			<table class="table table-hover" style="width:100%;">
				<thead>
					<tr>
					<th style="width:150px">Codice Corso</th>
					<th style="width:200px">Codice Docente</th>
					<th style="width:120px">Nome</th>
					<th style="width:150px">Data inizio</th>
					<th style="width:150px">Data fine</th>
					<th style="width:150px">Costo</th>
					<th style="width:150px">Commento</th>
					<th style="width:150px">Aula</th>
					</tr>
				</thead>
				<tbody>
					<%
						Corso[] corsi=ClientFacade.getInstance().corsiByCorsista(corsisti[i].getCodiceCor());
						for(int j=0; j<corsi.length; j++){
					%>
					<tr>
					<td><%= corsi[j].getCod()%></td>
					<td><%= corsi[j].getCodDocente()%></td>
					<td><%= corsi[j].getNome()%></td>
					<td><%= corsi[j].getDataInizio()%></td> <!-- magari con un if metti simbolo check o x -->
					<td><%= corsi[j].getDataFine()%></td>
					<td><%= corsi[j].getCosto()%></td>
					<td><%= corsi[j].getCommenti()%></td>
					<td><%= corsi[j].getAula()%></td>
					</tr>
			    </tbody>
					<%
						}
					%>
		</table>
	</div>
  </div>
</div>
		
   
   
   
   
   <%} %>
   
   
   
   
   
   
   
   
   
   <p><button class="btn btn-primary btn-lg btn-block" type="button" data-toggle="collapse" data-target="#collapseExample2" aria-expanded="false" aria-controls="collapseExample">
   Elenco Docenti che tengono più corsi </button><p>
   
    <div class="collapse" id="collapseExample2">
	  <div class="card card-body">
	    Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident.
	  </div>
	</div>
   
   
   <p><button class="btn btn-primary btn-lg btn-block" type="button" data-toggle="collapse" data-target="#collapseExample3" aria-expanded="false" aria-controls="collapseExample">
   Corsi disponibili </button></p>
   
   
  	<div class="collapse" id="collapseExample3">
	  <div class="card card-body">
	    Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident.
	  </div>
	</div>

	
	</div>



</div>
</body>
</html>