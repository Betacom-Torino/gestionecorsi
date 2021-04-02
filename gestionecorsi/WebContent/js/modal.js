$(function() {
	$('').datepicker({
		format : 'dd/mm/yyyy',
		autoclose : true,
		startDate : '01/01/1900',
		endDate : '31/12/2900'
	}).on(
			'changeDate',
			function(e) {
				// Rivalidazione del data field
				$('#corsistaForm').bootstrapValidator(
						'revalidateField', 'data2');
			});
});

function myFunction() {
	//document.getElementById("sceltaDocente").style.visibility = "false";
	
	if(allFieldsFilled){
  		document.getElementById("sceltaDocente").style.visibility = "true";
    }
}


function main(){
	myFunction();
}

function allFieldsFilled(){
	var c1 = document.getElementById("nome").value;
	var c2 = document.getElementById("inizio").value;
	var c3 = document.getElementById("fine").value;
	var c4 = document.getElementById("costo").value;
	var c5 = document.getElementById("aula").value;
	
	if(c1 == "" || c1 == null){
		alert("Inserire il nome");
		return false;	
	}
	if(c2 == "" || c2 == null){
		alert("Inserire la data d'inizio");
		return false;	
	}
	if(c3 == "" || c3 == null){
		alert("Inserire la data di fine");
		return false;	
	}
	if(c4 == "" || c4 == null){
		alert("Inserire il costo");
		return false;	
	}
	if(c5 == "" || c5 == null){
		alert("Inserire l'aula'");
		return false;	
	}
	 return true;
}

//main();
window.onload = function() {
  myFunction();
};
onload();