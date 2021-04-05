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
<script>
	$(function() {
		$('#data1').datepicker({
			format : 'dd/mm/yyyy',
			autoclose : true,
			startDate : '01/01/1900',
			endDate : '31/12/2900'
		}).on('changeDate', function(e) {
			// Rivalidazione del data field
			$('#corsistaForm').bootstrapValidator('revalidateField', 'data1');
		});
	});
	$(function() {
		$('#data2').datepicker({
			format : 'dd/mm/yyyy',
			autoclose : true,
			startDate : '01/01/1900',
			endDate : '31/12/2900'
		}).on('changeDate', function(e) {
			// Rivalidazione del data field
			$('#corsistaForm').bootstrapValidator('revalidateField', 'data2');
		});
	});
</script>



<style>
.has-error label, .has-error input, .has-error textarea {
	color: red;
	border-color: red;
}

.list-unstyled li {
	font-size: 13px;
	padding: 4px 0 0;
	color: red;
}
</style>





</head>
<%
String nome = (String) session.getAttribute("nome");
if (nome != null) {
%>
<body>
	<%@ include file="nav.jsp"%>
	<div class="container" style="margin-top: 20px;" id="inserisciCorso">

		<div class="page-header">
			<h3 style="margin-top: 25px; margin-bottom: 35px; color: #133347;">
				<strong>Inserimento nuovo corso</strong>
			</h3>
		</div>
		<div class="page-body">
			<form action="/gestionecorsi/inserisciCorso" method="post"
				class="form-horizontal" id="corsoForm" style="margin-bottom: 50px;"
				data-toggle="validator">

				<div class="form-group">






					<label class="col-md-3 control-label"><strong>Nome</strong></label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon" style="padding-right: 10px;">
								<i class="fas fa-graduation-cap"></i>
							</span>&nbsp; <input type="text" name="nome" id="nome"
								placeholder="Nome corso..." class="form-control" data-error="Il corso deve avere un nome" required>
						</div>
					</div>
					<div class="col-md-6 help-block with-errors" id="infoNome"></div>
				</div>

				<div class="form-group">
					<label class="col-md-3 control-label"><strong>Data
							Inizio</strong></label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group date" id="data1">
							<span class="input-group-addon" style="padding-right: 16px;">
								<i class="fas fa-calendar-alt"></i>
							</span>&nbsp; <input type="text" name="inizio" id="inizio"
								placeholder="DD/MM/YYYY..." class="form-control" required data-error="Inserisci data di inizio corso">
						</div>
					</div>
					<div class="col-md-6 help-block with-errors" id="infoDataInizio"></div>
				</div>
				<div class="form-group">
					<label class="col-md-3 control-label"><strong>Data
							Fine</strong></label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group date" id="data2">
							<span class="input-group-addon" style="padding-right: 16px;">
								<i class="fas fa-calendar-alt"></i>
							</span> <input type="text" name="fine" id="fine"
								placeholder="DD/MM/YYYY..." class="form-control" required data-error="Inserisci data di fine corso" >
						</div>
					</div>
					<div class="col-md-6 help-block with-errors" id="infoDataFine"></div>
				</div>

				<div class="form-group">
					<label class="col-md-3 control-label"><strong>Costo</strong></label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon" style="padding-right: 10px;"><i
								class="fas fa-graduation-cap"></i></span> <input type="number"
								name="costo" id="costo" class="form-control" required data-error="Inserisci il prezzo del corso (valore tra 1 e 5000)" step=".01"  min="1" max="5000" pattern="^[a0-9]*$">
						</div>
					</div>
					<div class="col-md-6 help-block with-errors" id="infoCosto"></div>
				</div>
				<div class="form-group">
					<label class="col-md-3 control-label"><strong>Commento</strong></label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon" style="padding-right: 10px;"><i
								class="fas fa-graduation-cap"></i></span>
							<textarea cols="60" rows="3" name="commento" id="commento"
								placeholder="Commento..." class="form-control"
								style="resize: none"></textarea>
						</div>
					</div>
					<div class="col-md-6 help-block with-errors" id="infoCommento"></div>
				</div>
				<div class="form-group">
					<label class="col-md-3 control-label"><strong>Aula</strong></label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon" style="padding-right: 10px;"><i
								class="fas fa-graduation-cap"></i></span> <input type="text"
								name="aula" id="aula" placeholder="Aula..." class="form-control"  required data-error="Inserisci l'aula del corso">
						</div>
					</div>
					<div class="col-md-6 help-block with-errors" id="infoAula"></div>
				</div>
				<div class="form-group">
					<label class="col-md-3 control-label"><strong>Docente</strong></label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon" style="padding-right: 10px;"><i
								class="fas fa-graduation-cap"></i></span> <input list="sceltaDocente"
								name="sceltaDocenteName" class="form-control"
								id="sceltaDocenteId" />
							<datalist id="sceltaDocente">
								<%
								Docente[] docenti = ClientFacade.getInstance().getDocenti();
								for (int i = 0; i < docenti.length; i++) {
								%>
								<option
									value="<%=docenti[i].getNomeDocente()%>-<%=docenti[i].getCognomeDocente()%>">
									<%
									}
									%>
								
							</datalist>
						</div>
					</div>
					<div class="col-md-6 help-block with-errors" id="infoAula"></div>
				</div>
				<div class="form-group">
					<span class="col-md-3"></span>
					<div class="col-md-4 inputGroupContainer">
						<input type="submit" class="btn btn-primary" id="submitButtonId"
							value="Crea corso" 
							style="width: 100%; border-radius: 0;"></input>
					</div>

				</div>





				<script>
					/*	(function() {
							$('input')
									.keyup(
											function() {

												var empty = false;

												if ($("#nome").val() == ''
														|| $("#inizio").val() == ''
														|| $("#fine").val() == ''
														|| $("#costo").val() == ''
														|| $("#aula").val() == ''
														|| $("#sceltaDocenteId")
																.val() == '') {
													empty = true;
												}

												if (empty) {
													$('#submitButtonId').attr(
															'disabled', 'disabled');
												} else {
													$('#submitButtonId')
															.removeAttr('disabled');
												}
											});
						})
								()
								(
										function() {
											$('input')
													.change(
															function() {

																var empty = false;

																if ($("#nome")
																		.val() == ''
																		|| $(
																				"#inizio")
																				.val() == ''
																		|| $(
																				"#fine")
																				.val() == ''
																		|| $(
																				"#costo")
																				.val() == ''
																		|| $(
																				"#aula")
																				.val() == ''
																		|| $(
																				"#sceltaDocenteId")
																				.val() == '') {
																	empty = true;
																}

																if (empty) {
																	$(
																			'#submitButtonId')
																			.attr(
																					'disabled',
																					'disabled');
																} else {
																	$(
																			'#submitButtonId')
																			.removeAttr(
																					'disabled');
																}
															});
										})()
					 */
				</script>
			</form>
		</div>
	</div>
	<%@ include file="footer.html"%>
</body>
<%
} else {
response.sendRedirect("accessonegato.jsp");
}
%>
</html>



