$(document).ready(function() {

	var idSelect = document.getElementById("id_libro").value;

	var $form = $('#formulario');
	var $submitActors = $form.find('input[type=submit]');
	var submitActor = null;

	var $tabla = $('#registros');
	var $selectores = $tabla.find('input[type=radio]');
	var selector = null;

	var $mutadores = $tabla.find('input[type=checkbox]');
	var mutador = null;
	var $disp = document.getElementById("disponible");


	if (idSelect > 0) {
		if ($disp.value == 1) {
			$("#disponibleCheck").attr("checked", true);
			$("#textStock").html("Disponible");
			$("#disponible").attr("value", 1);

		} else {
			$("#disponibleCheck").attr("checked", false);
			$("#textStock").html("Sin disponibilidad");
			$("#disponible").attr("value", 0);

		}
		radiobtn = document.getElementById("optSelectRow" + idSelect);
		radiobtn.checked = true;
	} else {
		$("#disponible").attr("value", 1);
	}

	$("#disponibleCheck").click(function(event) {
		if (this.checked) {
			$("#textStock").html("Disponible");
			$("#disponible").attr("value", 1);
		}
		else {
			$("#textStock").html("Sin disponibilidad");
			$("#disponible").attr("value", 0);
		}
	});

	$submitActors.click(function(event) {
		submitActor = this;
	});

	$form.submit(function(event) {
		event.preventDefault();
		if (null === submitActor) {
			submitActor = $submitActors[0];
		}
		if (submitActor.name == "eliminar") {
			if (idSelect != 0) {
				document.getElementById("formulario").action = "/booklet/deleteLibro";
			}

		} else {
			if (idSelect == 0) {
				document.getElementById("formulario").action = "/booklet/addLibro";
			} else {
				document.getElementById("formulario").action = "/booklet/editLibro";
			}
		}

		document.getElementById("formulario").method = "POST";
		document.getElementById("formulario").submit();
	});


	$selectores.click(function(event) {
		selector = this;
		idSelect = selector.name;
		editLibro();
	});

	$mutadores.click(function(event) {
		mutador = this;
		var id = mutador.name;
		var texto = $("#textStock" + id);
		if (mutador.checked) {
			texto.html("Disponible");
			window.location.href = "/booklet/editStock?idLibro=" + id + "&set=1";
		}
		else {
			texto.html("Sin disponibilidad");
			window.location.href = "/booklet/editStock?idLibro=" + id + "&set=0";
		}
	});

	function editLibro() {
		window.location.href = "/booklet/editLibro?idLibro=" + idSelect;
	}






});