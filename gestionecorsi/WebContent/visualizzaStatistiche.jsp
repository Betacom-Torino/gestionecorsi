<%@page import="java.util.Date"%>
<%@page import="com.betacom.businesscomponent.model.Docente"%>
<%@page import="com.betacom.businesscomponent.model.Corso"%>
<%@page import="com.betacom.businesscomponent.model.Corsista"%>
<%@page import="com.betacom.businesscomponent.ClientFacade"%>

<%
	//devo verificare che l utente sia in sessione per richiamare la pass
	String nome = (String)session.getAttribute("nome");
	if(nome!=null){
		

%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="CDN.html" %>
<link rel="stylesheet" href="css/style2.css">
<meta charset="ISO-8859-1">
<title>Visualizza statistiche</title>
</head>
<body >
<jsp:include page="nav.jsp"/>
<div class="container" >

	<h1 align="center"><strong>Statistiche</strong></h1>
	
	<!-- 1 STATISTICA-------------------------------------------------------------------------------------------------------- -->
	<%
		int n=ClientFacade.getInstance().getNumCorsistiTotali();
	%>
	<h3>Numero corsisti totali&nbsp;&nbsp;<span class="badge badge-pill badge-primary" style="padding-bottom :10px;"><%= n %></span></h3>
	
	
	<!-- 3 STATISTICA-------------------------------------------------------------------------------------------------------- -->
	<%
		int durata=ClientFacade.getInstance().getDurataMediaCorsi();
	%>
	<h3>Durata media dei corsi&nbsp;&nbsp;<span class="badge badge-pill badge-primary" style="padding-bottom :10px;"><%= durata %></span></h3>
	
	
	<!-- 4 STATISTICA---------------------------------------------------------------------------------------------------------- -->
	<%
		Date inizio=ClientFacade.getInstance().getDataUltimoCorso();
	%>
	<h3>Data inizio ultimo corso&nbsp;&nbsp;<span class="badge badge-pill badge-primary" style="padding-bottom :10px;"><%=new java.sql.Date( inizio.getTime())%></span></h3> 
	
	<!-- 5 STATISTICA----------------------------------------------------------------------------------------------------------- -->
	<%
		int commenti=ClientFacade.getInstance().getNumeroCommenti();
	%>
	<h3>Numero totale di commenti&nbsp;&nbsp;<span class="badge badge-pill badge-primary" style="padding-bottom :10px;"><%= commenti %></span></h3>
		
		
	<div>
	<!-- NUMERO CORSI PIU FREQUENTATI-------------------------------------------------------------------------------------------- -->
	<p><button class="btn btn-primary btn-lg btn-block" type="button" data-toggle="collapse" data-target="#corsiPiuFrequentati" aria-expanded="false" aria-controls="collapseExample">
   		Nome corsi più frequentati </button></p>
   
   	<div class="collapse" id="corsiPiuFrequentati">
	  <div class="card card-body">
	    <div class="table-responsive">
			<table class="table table-hover" style="width:100%">
				<thead>
					<tr>
					<th>Nome Corso</th>
					</tr>
				</thead>
				<tbody>
				<%
						String[] nomeCorsi=ClientFacade.getInstance().getCorsoPiuFreq();
						for(int j=0; j<nomeCorsi.length; j++){
				%>
				<tr>
				<td><%= nomeCorsi[j] %></td>
				</tr>
				</tbody>
				<%
						}
				%>
			</table>
		</div>
	  </div>
  	</div>
				
  <!-- ELENCO CORSISTI---------------------------------------------------------------------------------------------------------- -->
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
							<td ><span><i class="fas fa-check-circle"></i> </span></td> 
							<%}else{ %>
							<td><span><i class="fas fa-times-circle"></i></span></td>
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
						Corso[] corsi2=ClientFacade.getInstance().corsiByCorsista(corsisti[i].getCodiceCor());
						for(int j=0; j<corsi2.length; j++){
							%>
					<tr>
					<td><%= corsi2[j].getCod()%></td>
					<td><%= corsi2[j].getCodDocente()%></td>
					<td><%= corsi2[j].getNome()%></td>
					<td><%= new java.sql.Date(corsi2[j].getDataInizio().getTime())%></td> 
					<td><%= new java.sql.Date(corsi2[j].getDataFine().getTime())%></td>
					<td><%= corsi2[j].getCosto()%></td>
					<td><%= corsi2[j].getCommenti()%></td>
					<td><%= corsi2[j].getAula()%></td>
					</tr>
			    </tbody>
					<%
						}
					%>
		</table>
	</div>
  </div>
</div> 
   <%
   	} 
   %>
   
   
 <!--ELENCO DOCENTI CHE TENGONO PIU CORSI--------------------------------------------------------------------------------------  -->
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
   
   <!-- CORSI DISPONIBILI------------------------------------------------------------------------------------------------------- -->
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
						Corso[] corsi3=ClientFacade.getInstance().getCorsiDisponibili();
						for(int j=0; j<corsi3.length; j++){
					%>
					<tr>
						<td><%= corsi3[j].getCod()%></td>
						<td><%= corsi3[j].getCodDocente()%></td>
						<td><%= corsi3[j].getNome()%></td>
						<td><%= new java.sql.Date(corsi3[j].getDataInizio().getTime())%></td> 
						<td><%= new java.sql.Date(corsi3[j].getDataFine().getTime())%></td>
						<td><%= corsi3[j].getCosto()%></td>
						<td><%= corsi3[j].getCommenti()%></td>
						<td><%= corsi3[j].getAula()%></td>
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
<footer class="footer"><%@include file="footer.html" %></footer>
</body>
</html>

<%
	}else{
		response.sendRedirect("error.jsp");
	}
%>