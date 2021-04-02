<!-- Modal -->
<%@page import="com.betacom.businesscomponent.ClientFacade"%>
<%@page import="com.betacom.businesscomponent.model.Docente"%>
<div class="modal fade bd-example-modal-lg" id="corsistaModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg" role="document">
	<form action="/gestionecorsi/inserisciCorso" method="post" id="formCorsoId">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<div class="form-group">
					<label class="col-md-1 control-label">Nome</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="fas fa-graduation-cap"></i></span> 
								<input type="text"
								name="nome" id="nome" placeholder="Nome corso..."
								class="form-control">
						</div>
					</div>
					<div class="col-md-7 control-label" id="infoNome"></div>
				</div>
				<div class="form-group">
					<label class="col-md-1 control-label">Data Inizio</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group date" id="data1">
							<span class="input-group-addon"><i class="fas fa-calendar-alt"></i></span> 
							<input type="text"
								name="inizio" id="inizio" placeholder="DD/MM/YYYY..."
								class="form-control">
						</div>
					</div>
					<div class="col-md-7 control-label" id="infoDataInizio"></div>
				</div>
				<div class="form-group">
					<label class="col-md-1 control-label">Data Fine</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group date" id="data2">
							<span class="input-group-addon"><i class="fas fa-calendar-alt"></i></span> 
							<input type="text"
								name="fine" id="fine" placeholder="DD/MM/YYYY..."
								class="form-control">
						</div>
					</div>
					<div class="col-md-7 control-label" id="infoDataFine"></div>
				</div>
				
				<div class="form-group">
					<label class="col-md-1 control-label">Costo</label>
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
					<label class="col-md-1 control-label">Commento</label>
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
					<label class="col-md-1 control-label">Aula</label>
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

				<label>Docente:
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
			</div>

			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Chiudi</button>
				<input type="submit" class="btn btn-primary" id="submitButtonId" value="Crea corso" disabled></input>
			</div>
		</div>
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
</div>