	<div class="container">

		<!-- Button to Open the Modal -->
		

<form action="<%=request.getContextPath() %>/logout" method="post">
		<div class="modal fade" id="myModal">
			<div class="modal-dialog modal-dialog-centered">
				<div class="modal-content">


					<div class="modal-header">
						<h4 class="modal-title">Logout</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>

					<!-- Modal body -->
					<div class="modal-body">Sei sicuro di voler effettuare il logout?</div>

					<!-- Modal footer -->
					<div class="modal-footer">
						<button type="submit" class="btn btn-primary" >Procedi</button>
						<button type="button" class="btn btn-secondary" data-dismiss="modal">Chiudi</button>
					</div>

				</div>
			</div>
		</div>
			</form>
	</div>


