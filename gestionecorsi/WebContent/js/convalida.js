$(document).ready(
	function() {
		$('#corsistaForm').bootstrapValidator({
			/*feedbackIcons: {
				valid: 'glyphicon glyphicon-ok',
				invalid: 'glyphicon glyphicon-remove',
				validating: 'glyphicon glyphicon-refresh'
			},
			*/
			fields: {
				nomecorsista: {
					container: '#infoNomeCorsista',
					validators: {
						notEmpty: {
							message: 'Campo obbligatorio'
						},
						regexp: {
							regexp: /^[a-zA-Z ,.']{2,30}$/,
							message: 'Da 2 a 30 caratteri (Solo lettere e virgola, punto e apostrofo)'
						}
					}
				},
				cognomecorsista: {
					container: '#infoCognomeCorsista',
					validators: {
						notEmpty: {
							message: 'Campo obbligatorio'
						},
						regexp: {
							regexp: /^[a-zA-Z ,.']{2,30}$/,
							message: 'Da 2 a 30 caratteri (Solo lettere e virgola, punto e apostrofo)'
						}
					}
				},
				/*nomecorso: {
					container: '#infoNomeCorso',
					validators: {
						notEmpty: {
							message: 'Campo obbligatorio'
						},
						regexp: {
							regexp: /^[a-zA-Z ,.']{2,30}$/,
							message: 'Da 2 a 30 caratteri (Solo lettere e virgola, punto e apostrofo)'
						}
					}
				},
				datainizio: {
					container: '#infoDataInizio',
					validators: {
						notEmpty: {
							message: 'Campo obbligatorio'
						},
						date: {
							format: 'DD/MM/YYYY',
							message: 'Data non valita. Formato DD/MM/YYYY'
						}
					}
				},
				datafine: {
					container: '#infoDataFine',
					validators: {
						notEmpty: {
							message: 'Campo obbligatorio'
						},
						date: {
							format: 'DD/MM/YYYY',
							message: 'Data non valita. Formato DD/MM/YYYY'
						}
					}
				},
				commenti: {
					container: '#infoCommenti',
					validators: {
						regexp: {
							regexp: /^[\w\-\.\+]{,200}$/,
							message: 'Max 200 caratteri'
						}
					}
				},
				aulacorso: {
					container: '#infoAulaCorso',
					validators: {
						regexp: {
							regexp: /^[a-zA-Z0-9]{2,30}$/,
							message: 'Da 2 a 30 caratteri alfanumerici'
						}
					}
				}*/
			}

		});
	}
);



