<form action="<%=request.getContextPath()%>/logout" method="post">
	<div class="modal fade" id="myModal">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content"  style="background-color: rgba(0,0,0,0.85) !important; color: white;">
				<div class="modal-header border-0" >
					<h4 class="modal-title">Logout</h4>
					<button type="button" class="close" data-dismiss="modal" style="color: white;">&times;</button>
				</div>

				<!-- Modal body -->
				<div class="modal-body ">Sei sicuro di voler effettuare il
					logout?</div>

				<!-- Modal footer -->
				<div class="modal-footer border-0">
					<button type="submit" class="btn btn-primary" style="background-color: #113e85; border: white;">Procedi</button>
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Chiudi</button>
				</div>

			</div>
		</div>
	</div>
</form>