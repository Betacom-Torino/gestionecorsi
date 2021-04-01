<%@page import="com.betacom.businesscomponent.model.Docente"%>
<%@page import="java.text.SimpleDateFormat"%>
<%
long codCorso = 0;
%>
<%@include file="CDN.html"%>
<%@page import="com.betacom.businesscomponent.ClientFacade"%>
<%@page import="com.betacom.businesscomponent.model.Corso"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<script src="js/convalida.js"></script>
<div class="container" style="width: 1000px;" id="inserisciCorsista">
	<%
	String s = (request.getParameter("codCorso"));
	if (s != null) {
	%>
	<div class="page-header">
		<h3>Inserimento nuovo corsista</h3>
	</div>
	<form
		action="/<%=application.getServletContextName()%>/inserisciCorsista"
		method="post" class="form-horizontal" id="userForm">

		<div class="form-group">
			<label class="col-md-1 control-label"><strong>Nome</strong></label>
			<div class="col-md-4 inputGroupContainer">
				<div class="input-group">
					<span class="input-group-addon"> <i
						class="glyphicon glyphicon-user"></I>
					</span> <input type="text" name="nome" id="nome" placeholder="nome..."
						value="<%=request.getParameter("nomeCorsista") != null ? request.getParameter("nomeCorsista") : ""%>"
						class="form-control">
				</div>
			</div>
			<div class="col-md-7 control-label" id="infoNome"></div>
		</div>

		<div class="form-group">
			<label class="col-md-1 control-label"><strong>Cognome</strong></label>
			<div class="col-md-4 inputGroupContainer">
				<div class="input-group">
					<span class="input-group-addon"> <i
						class="glyphicon glyphicon-user"></I>
					</span> <input type="text" name="cognome" id="cognome"
						placeholder="cognome..."
						value="<%=request.getParameter("cognomeCorsista") != null ? request.getParameter("cognomeCorsista") : ""%>"
						class="form-control">
				</div>
			</div>
			<div class="col-md-7 control-label" id="infoCognome"></div>
		</div>

		<div class="form-group">
			<label class="control-label"><strong>Precedenti
					formativi</strong></label> <a class="custom-control custom-radio"> <input
				type="radio" class="custom-control-input" id="precForm"
				name="precForm" value="1"> <label
				class="custom-control-label" for="precForm">Si</label>
			</a> <a class="custom-control custom-radio"> <input type="radio"
				class="custom-control-input" id="precForm" name="precForm" value="0"
				checked> <label class="custom-control-label" for="precForm">No</label>
			</a>
		</div>
		<%
		codCorso = Long.parseLong(s);
		Corso corsetto = ClientFacade.getInstance().getCorsoByCod(codCorso);
		Docente docente = ClientFacade.getInstance().getDocenteByCod(corsetto.getCodDocente());
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		%>
		<div class="table-responsive">
			<table class="table table-hover" style="width: 100%;">
				<tr>
					<td><strong>Nome Corso</strong></td>
					<td><%=corsetto.getNome()%></td>
				</tr>
				<tr>
					<td><strong>Data Inizio</strong></td>
					<td><%=f.format(corsetto.getDataInizio())%></td>
				</tr>
				<tr>
					<td><strong>Data Fine</strong></td>
					<td><%=f.format(corsetto.getDataFine())%></td>
				</tr>
				<tr>
					<td><strong>Docente Corso</strong></td>
					<td><%=docente.getNomeDocente()%>&nbsp;<%=docente.getCognomeDocente()%></td>
				</tr>
				<tr>
					<td><strong>Costo Corso</strong></td>
					<td><%=String.format("%.2f", corsetto.getCosto())%>&euro;</td>
				</tr>
				<tr>
					<td><strong>Commento</strong></td>
					<td><%=corsetto.getCommenti()%></td>
				</tr>
				<tr>
					<td><strong>Aula corso</strong></td>
					<td><%=corsetto.getAula()%></td>
				</tr>
			</table>
		</div>
		<div class="row">
			<div class="col-md-4 col-md-offset-1">
				<input type="hidden" name="codCorso" value="<%=codCorso%>">
				<button type="submit" class="btn btn-primary">
					Inserisci&nbsp;</button>
			</div>
		</div>
		<hr>
		<a href="inserisciCorsista.jsp">Torna alla selezione del Corso</a>
	</form>
	<%
	} else {
	%>
	<div class="page-header">
		<h3>Scegli un corso:</h3>
	</div>
	<div class="btn-group">
		<button type="button" class="btn btn-primary dropdown-toggle"
			data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			Corso</button>
		<div class="dropdown-menu">
			<%
			Corso[] corsi = ClientFacade.getInstance().getCorsi();
			for (int i = 0; i < corsi.length; i++) {
			%>
			<a class="dropdown-item"
				href="inserisciCorsista.jsp?codCorso=<%=corsi[i].getCod()%>"><%=corsi[i].getNome()%>&nbsp;&nbsp;<i
				class="fas fa-graduation-cap"></i></a>

			<%
			}
			%>

		</div>
		<div>
			<h3>O inserisci un nuovo corso:</h3>
			<button type="button" class="btn btn-primary btn-sm"
				data-toggle="modal" data-target="#corsistaModal">
				Aggiungi Corso&nbsp;&nbsp;<i class="fas fa-plus"></i>
			</button>
			<jsp:include page="addCorsoModal.jsp">
				<jsp:param value="1" name="id" />
			</jsp:include></div>
	</div>
	<%
	}
	%>
</div>
