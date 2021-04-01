<%@page import="com.betacom.businesscomponent.model.Docente"%>
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
   Elenco Corsisti </button><p>
   
   <div class="collapse" id="elencoCorsisti">
	  <div class="card card-body">
	    <div class="table-responsive">
			<table class="table table-hover" style="width:100%">
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
					<%if(corsisti[i].getPreFormativi()==1) {%>
					<td ><i class="glyphicon glyphicon-ok-circle" aria-hidden="true"></i></td> 
					<%}else{ %>
					<td><span><i class= "glyphicon glyphicon-ban-circle"></i></span></td>
					<%} %>
					</tr>
				</tbody>
			</table>
		</div>
	  </div>
	</div>

	
						
<div class="collapse" id="elencoCorsi">
	<div class="card card-body">
	 	<div class="table-responsive">
			<table class="table table-hover" >
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
					<td><%= new java.sql.Date(corsi[j].getDataInizio().getTime())%></td> 
					<td><%= new java.sql.Date(corsi[j].getDataFine().getTime())%></td>
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
   
   

   <p><button class="btn btn-primary btn-lg btn-block" type="button" data-toggle="collapse" data-target="#elencoDocenti" aria-expanded="false" aria-controls="collapseExample">
   Elenco Docenti che tengono più corsi </button><p>
   
    <div class="collapse" id="elencoDocenti">
	  <div class="card card-body">
	    	<div class="table-responsive">
			<table class="table table-hover">
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
						Docente[] docenti=ClientFacade.getInstance().getStatisticaDocenti();
						for(int i=0; i<docenti.length; i++){
					%>
					<tr>
					<td><%= docenti[i].getCodDocente()%></td>
					<td><%= docenti[i].getNomeDocente()%></td>
					<td><%= docenti[i].getCognomeDocente()%></td>
					<td><a href="cv/cv<%=docenti[i].getCodDocente() %>.pdf"><%= docenti[i].getCvDocente()%></a></td>
					</tr>
					<%
						} 
					%>
				</tbody>
			</table>	
	  		</div>
		</div>
	</div>
   
   
   <p><button class="btn btn-primary btn-lg btn-block" type="button" data-toggle="collapse" data-target="#corsiDisponibili" aria-expanded="false" aria-controls="collapseExample">
   Corsi disponibili </button></p>
   
   
  	<div class="collapse" id="corsiDisponibili">
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
						Corso[] corsi=ClientFacade.getInstance().getCorsiDisponibili();
						for(int j=0; j<corsi.length; j++){
					%>
					<tr>
						<td><%= corsi[j].getCod()%></td>
						<td><%= corsi[j].getCodDocente()%></td>
						<td><%= corsi[j].getNome()%></td>
						<td><%= new java.sql.Date(corsi[j].getDataInizio().getTime())%></td> 
						<td><%= new java.sql.Date(corsi[j].getDataFine().getTime())%></td>
						<td><%= corsi[j].getCosto()%></td>
						<td><%= corsi[j].getCommenti()%></td>
						<td><%= corsi[j].getAula()%></td>
					</tr>
					<%
						} 
					%>
				</tbody>
			</table>	
	  		</div>
	  </div>
	</div>

	
</div>



</div>
</body>
</html>