<html>
<head>
<title>Modal Logout</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">



		<!-- Button to Open the Modal -->
		<button type="button" class="btn btn-primary" data-toggle="modal"
			data-target="#myModal">Logout</button>


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
						<button type="button" class="btn btn-primary">Procedi</button>
						<button type="button" class="btn btn-danger" data-dismiss="modal">Chiudi</button>
					</div>

				</div>
			</div>
		</div>

	</div>

</body>
</html>
