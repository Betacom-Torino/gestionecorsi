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
	<div class="modal-dialog modal-lg">
	  <div class="modal-content">
	    <div class="modal-header">
	    	<h4 class="modal-title">Lista corsi</h4>
	      <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	    </div>
	    <div class="modal-body">
	    	<div class="container">
 				<%
						corsi=ClientFacade.getInstance().corsiByCorsista(id);
						if(corsi!=null){
						for(int j=0; j<corsi.length; j++){
				%>
    			<div class="col align-items-center">
    				
    				<div class="row-sm">
      						<strong>Corso :</strong><%= corsi[j].getCod()%>
    				</div>
    				<div class="row-sm">
      						<strong>Docente :</strong> <%= corsi[j].getCodDocente()%>
    				</div>
    				<div class="row-sm">
      						<strong>Nome :</strong><%= corsi[j].getNome()%>
    				</div>
    				<div class="row-sm">
      						<strong>Data inizio :</strong><%= new java.sql.Date(corsi[j].getDataInizio().getTime())%>
    				</div>
    				<div class="row-sm">
      						<strong>Data fine : </strong><%= new java.sql.Date(corsi[j].getDataFine().getTime())%>
    				</div>
    				<div class="row-sm">
      						<strong>Costo :</strong> <%= corsi[j].getCosto()%>
    				</div>
    				<div class="row-sm">
      						<strong>Commenti :</strong><%= corsi[j].getCommenti()%>
    				</div>
    				<div class="row-sm">
      						<strong>Aula :</strong><%= corsi[j].getAula()%>
    				</div>    			
  			</div>
  			<hr>
  			<%
						} 
						}
			%>
		</div>
<%-- 	      <table>
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
	          	<tbody class="table">
					<%
						corsi=ClientFacade.getInstance().corsiByCorsista(id);
						if(corsi!=null){
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
						}
					%>
	          	</tbody>
	      </table> --%>
	    </div>
	    <div class="modal-footer">
	      <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	    </div>
	  </div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div>


<%
 }
%>