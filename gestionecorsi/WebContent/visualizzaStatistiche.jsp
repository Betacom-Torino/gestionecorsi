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
<link rel="stylesheet" href="css/style.css">
<meta charset="ISO-8859-1">
<title>Visualizza statistiche</title>
</head>
<body >
<jsp:include page="nav.jsp"/>
<div class="container" style="margin-top: 20px;">

	<h1 align="center" style="margin-bottom: 20px; color: #133347;"><strong>Statistiche Generali</strong>&nbsp;<i class="fas fa-chart-pie"></i></h1>
	
	
	<div>
	<!-- NUMERO CORSI PIU FREQUENTATI-------------------------------------------------------------------------------------------- -->
	<p><button class="btn btn-primary btn-lg btn-block" type="button" data-toggle="collapse" data-target="#corsiPiuFrequentati" aria-expanded="false" aria-controls="collapseExample" style="background-color: #133347; border-radius: 0; border: black;">
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
						if(nomeCorsi != null){
						for(int j=0; j<nomeCorsi.length; j++){
				%>
				<tr>
				<td><%= nomeCorsi[j] %></td>
				</tr>
				</tbody>
				<%
						}
						}
				%>
			</table>
		</div>
	  </div>
  	</div>
				
  <!-- ELENCO CORSISTI---------------------------------------------------------------------------------------------------------- -->
  <p><button class="btn btn-primary btn-lg btn-block" type="button" data-toggle="collapse" data-target="#elencoCorsisti" aria-expanded="false" aria-controls="collapseExample" style="background-color: #133347; border-radius: 0; border: black;">
   		Elenco Corsisti </button><p>
   
   <div class="collapse" id="elencoCorsisti">
	  <div class="card card-body">
	    <div class="table-responsive">
			<table class="table table-hover" style="width:100%">
				<thead>
					<tr class="row">
					<th  class="col-12 col-sm-3">&nbsp;Codice Corsista</th>
					<th class="col-12 col-sm-3">Nome</th>
					<th class="col-12 col-sm-3">Cognome</th>
					<th class="col-12 col-sm-3">Precedenti formativi</th>
					</tr>
				</thead>
				<tbody>
					<%
						Corsista[] corsisti=ClientFacade.getInstance().getCorsisti();
						if(corsisti!=null){
						
							for(int i=0; i<corsisti.length; i++){
					%>

							<tr class="row" role="clickable-row" class="btn btn-light btn-lg" data-toggle="modal" data-target="#editModal_<%=corsisti[i].getCodiceCor()%>">
							
								
								<td  class="col-12 col-sm-3">&nbsp;<%= corsisti[i].getCodiceCor()%></td>
								<td  class="col-12 col-sm-3"><%= corsisti[i].getNomeCor()%></td>
								<td  class="col-12 col-sm-3"><%= corsisti[i].getCognomeCor()%></td>
								<%
									if(corsisti[i].getPreFormativi()==1){
								%>
								<td class="col-12 col-sm-3"><span><i class="fas fa-check-circle"></i> </span></td> 
								<%  
									}else{ 								
								%>
								<td class="col-12 col-sm-3"><span><i class="fas fa-times-circle"></i></span></td>
								<%
									}
								%>
								<jsp:include page="corsoModal.jsp">
 								<jsp:param value="<%=corsisti[i].getCodiceCor() %>" name="id"/>
								</jsp:include>
							</tr>
								
							  <%
							  	
									}
						}
						
   							  %>
   							  	
						</tbody>
					</table>
				</div>
			  </div>
			</div>

   
 <!--ELENCO DOCENTI CHE TENGONO PIU CORSI--------------------------------------------------------------------------------------  -->
   <p><button class="btn btn-primary btn-lg btn-block" type="button" data-toggle="collapse" data-target="#elencoDocenti" aria-expanded="false" aria-controls="collapseExample" style="background-color: #133347; border-radius: 0; border: black;">
   Elenco Docenti che tengono più corsi </button><p>
   
    <div class="collapse" id="elencoDocenti">
	  <div class="card card-body">
	    	<div class="table-responsive">
			<table class="table table-hover">
				<thead>
					<tr>
					<th style="width:200px">Codice Docente</th>
					<th style="width:200px">Nome</th>
					<th style="width:200px">Cognome</th>
					<th style="width:200px">Curriculum</th>
					</tr>
				</thead>
				<tbody>
					<%
						Docente[] docenti=ClientFacade.getInstance().getStatisticaDocenti();
						if(docenti!=null){
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
						}
					%>
				</tbody>
			</table>	
	  		</div>
		</div>
	</div>
   
   
   <!-- CORSI DISPONIBILI------------------------------------------------------------------------------------------------------- -->
   <p><button class="btn btn-primary btn-lg btn-block" type="button" data-toggle="collapse" data-target="#corsiDisponibili" aria-expanded="false" aria-controls="collapseExample" style="background-color: #133347; border-radius: 0; border: black;">
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
						if(corsi3!=null){
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
						}
					%>
				</tbody>
			</table>	
	  		</div>
	  </div>
	</div>
	
	<!-- 1 STATISTICA-------------------------------------------------------------------------------------------------------- -->
	<%
		int n=ClientFacade.getInstance().getNumCorsistiTotali();
	%>
	<h4 style="margin-top: 40px; margin-left: 10px;">Numero corsisti totali&nbsp;&nbsp;<span class="badge badge-pill badge-primary" style="padding-bottom :10px; background-color: #133347; float: right; margin-right: 10px;"><%= n %></span></h4>
	
	
	<!-- 3 STATISTICA-------------------------------------------------------------------------------------------------------- -->
	<%
		int durata=ClientFacade.getInstance().getDurataMediaCorsi();
	%>
	<h4 style="margin-top: 20px;margin-left: 10px;">Durata media dei corsi&nbsp;&nbsp;<span class="badge badge-pill badge-primary" style="padding-bottom :10px; background-color: #133347; float: right; margin-right: 10px;"><%= durata %></span></h4>
	
	
	<!-- 4 STATISTICA---------------------------------------------------------------------------------------------------------- -->
	<%
		Date inizio=ClientFacade.getInstance().getDataUltimoCorso();
		if(inizio != null){
	%>
	<h4 style="margin-top: 20px; margin-bottom: 20px; margin-left: 10px;">Data inizio ultimo corso&nbsp;&nbsp;<span class="badge badge-pill badge-primary" style="padding-bottom :10px; background-color: #133347;  float: right; margin-right: 10px;"><%=new java.sql.Date( inizio.getTime())%></span></h4> 
	<%
		}
	%>
	
	<!-- 5 STATISTICA----------------------------------------------------------------------------------------------------------- -->
	<%
		int commenti=ClientFacade.getInstance().getNumeroCommenti();
	%>
	<h4 style="margin-bottom: 40px;margin-left: 10px;">Numero totale di commenti&nbsp;&nbsp;<span class="badge badge-pill badge-primary" style="padding-bottom :10px; background-color: #133347; float: right;margin-right: 10px;"><%= commenti %></span></h4>
		

</div>
</div>

<footer class="footer"><%@include file="footer.html" %></footer>
</body>
</html>

<%
	}else{
		response.sendRedirect("accessonegato.jsp");
	}
%>