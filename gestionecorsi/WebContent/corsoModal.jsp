<%@page import="com.betacom.businesscomponent.ClientFacade"%>
<%@page import="com.betacom.businesscomponent.model.Corso"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%


	Long id=Long.parseLong(request.getParameter("id"));
	Corso[] corsi=null;
	
	if(id != null){
		
	
%>

   <div class="modal fade bd-example-modal-lg" id="editModal_<%= id %>">
	<div class="modal-dialog modal-lg modal-dialog-centered">
	  <div class="modal-content" style="background-color: rgba(255,255,255,0.9) !important;">
	    <div class="modal-header">
	    	<h4 class="modal-title" style="color: #133347;"><strong>Lista corsi</strong></h4>
	      <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	    </div>
	    <div class="modal-body" >
	    	<div class="container" >
 				<%
						corsi=ClientFacade.getInstance().corsiByCorsista(id);
						if(corsi!=null){
						for(int j=0; j<corsi.length; j++){
				%>
    			<div class="col align-items-center">
    				
    				<div class="row-sm">
      						<strong>Corso:</strong>&nbsp;<%= corsi[j].getCod()%>
    				</div>
    				<div class="row-sm">
      						<strong>Docente:</strong>&nbsp;<%= corsi[j].getCodDocente()%>
    				</div>
    				<div class="row-sm">
      						<strong>Nome:</strong>&nbsp;<%= corsi[j].getNome()%>
    				</div>
    				<div class="row-sm">
      						<strong>Data inizio:</strong>&nbsp;<%= new java.sql.Date(corsi[j].getDataInizio().getTime())%>
    				</div>
    				<div class="row-sm">
      						<strong>Data fine:</strong>&nbsp;<%= new java.sql.Date(corsi[j].getDataFine().getTime())%>
    				</div>
    				<div class="row-sm">
      						<strong>Costo:</strong>&nbsp;<%= corsi[j].getCosto()%>
    				</div>
    				<div class="row-sm">
      						<strong>Commenti:</strong>&nbsp;<%= corsi[j].getCommenti()%>
    				</div>
    				<div class="row-sm">
      						<strong>Aula:</strong>&nbsp;<%= corsi[j].getAula()%>
    				</div>    			
  			</div>
  			<hr>
  			<%
						} 
						}
			%>
		</div>

	    </div>
	    <div class="modal-footer" style="margin-bottom: 15px; margin-right: 20px;">
	      <button type="button" class="btn btn-default" data-dismiss="modal" style="background-color: #133347; color: white;">Close</button>
	    </div>
	  </div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div>


<%
 }
%>