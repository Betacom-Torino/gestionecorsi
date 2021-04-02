<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<%@ include file="CDN.html"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/style2.css">
</head>
<body>

	<div class="container">
		<h2>Warning Login</h2>
		
		
		<%
	String eliminazione = (String) session.getAttribute("eliminazione");

	if (eliminazione != null) {
	%>

	<script type="text/javascript">
		$(window).on('load', function() {
			$('#myModal').modal('show');
		});
	</script>
	
	

		<!-- The Modal -->
		<div class="modal fade" id="myModal">
			<div class="modal-dialog modal-dialog-centered">
				<div class="modal-content" style="background-color: rgba(0,0,0,0.85) !important; color: white;">

					<!-- Modal Header -->
					<div class="modal-header border-0">
						<h4 class="modal-title"><strong>Warning!</strong></h4>
						<button type="button" class="close" data-dismiss="modal" style="color: white;">&times;</button>
					</div>

					<!-- Modal body -->
					<div class="modal-body">
					<p>Hai superato il limite massimo di tentativi di login.</p>
					<span>Contatta l'amministratore per ripristinare il tuo account.</span>
					</div>

					<!-- Modal footer -->
					<div class="modal-footer border-0">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Chiudi</button>
					</div>

				</div>
			</div>
		</div>
		
		<%
	}

	session.setAttribute("eliminazione", null);
	%>
		

	</div>

</body>
</html>
