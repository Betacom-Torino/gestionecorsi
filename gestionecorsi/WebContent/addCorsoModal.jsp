<!-- Modal -->
<div class="modal fade" id="corsistaModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
	<form action="/gestionecorsi/inserisciCorso" method="post">
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
					<label class="col-md-1 control-label">Nome </label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="fas fa-graduation-cap"></i></span> <input type="text"
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
							<span class="input-group-addon"><i class="fas fa-calendar-alt"></i></span> <input type="text"
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
							<span class="input-group-addon"><i class="fas fa-calendar-alt"></i></span> <input type="text"
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
								class="fas fa-graduation-cap"></i></span> <input type="number"
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
								class="fas fa-graduation-cap"></i></span> <input type="text"
								name="commento" id="commento" placeholder="Commento..."
								class="form-control">
						</div>
					</div>
					<div class="col-md-7 control-label" id="infoCommento"></div>
				</div>
				<div class="form-group">
					<label class="col-md-1 control-label">Aula</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="fas fa-graduation-cap"></i></span> <input type="text"
								name="aula" id="aula" placeholder="Aula..."
								class="form-control">
						</div>
					</div>
					<div class="col-md-7 control-label" id="infoAula"></div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Chiudi</button>
				<button type="submit" class="btn btn-primary">Crea corso</button>
			</div>
		</div>
		</form>
	</div>
</div>