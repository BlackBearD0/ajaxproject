$(document).ready(function() {


 

	$.ajax({
		url: "CrenomController",
		data: { op: "load" },
		type: 'post',

		success: function(data, textStatus, jqXHR) {
			console.log(JSON.stringify(data))
			remplir(data);
		},
		error: function(jqXHR, textStatus, errorthrown) {
			alert(textStatus);
			alert(textStatus);

		}

	});
	$("#add").click(function() {
		var HeureDebut = $("#HeureDebut").val();
		var HeureFin = $("#HeureFin").val();


		console.log(HeureFin + " " + HeureDebut + " ");
		$.ajax({
			url: "CrenomController",
			data: { HeureDebut: HeureDebut, HeureFin: HeureFin },
			type: 'post',

			success: function(data, textStatus, jqXHR) {
				console.log(JSON.stringify(data))
				remplir(data);
			},
			error: function(jqXHR, textStatus, errorthrown) {
				alert(textStatus);
				alert(textStatus);

			}

		});

	});

	$("#content").on("click", ".delete", function() {
		//alert($(this).attr('val'));
		var id = $(this).closest('tr').find('td').eq(0).text();
		$.ajax({
			url: "CrenomController",
			data: { op: "delete", id: id },
			type: 'POST',
			success: function(data, textStatus, jqXHR) {
				remplir(data);
			},
			error: function(jqXHR, textStatus, errorThrown) {
				console.log(textStatus);
			}
		});
	});
	$("#content").on("click", ".update", function() {
		//alert($(this).attr('val'));
		var HeureDebut = $("#HeureDebut").val();
		var HeureFin = $("#HeureFin").val();

		var id = $(this).closest('tr').find('td').eq(0).text();
		$.ajax({
			url: "CrenomController",
			data: { op: "update", id: id, HeureDebut: HeureDebut, HeureFin: HeureFin },
			type: 'POST',
			success: function(data, textStatus, jqXHR) {
				remplir(data);
			},
			error: function(jqXHR, textStatus, errorThrown) {
				console.log(textStatus);
			}
		});
	});
	
	$("#form1").submit(function() {
		 var date = $("#date").val();
		var heureD =  $("#heureD").val();
		var heureF = $("#heureF").val();
		var id = $("#id_r").val();
				$.ajax({
					url: "CrenomController",
					data: { op: "update",date: date, heureD: heureD, heureF: heureF, id: id },
					type: 'POST',
					success: function(data, textStatus, jqXHR) {
					remplir(data);
					},
					error: function(jqXHR, textStatus, errorthrown) {
					alert(textStatus);
					alert("error");
					}
					});
			});
	$("#content").on("click",".mode", function() {
		//alert("allo");
 		
 		 $("#salle").val($(this).closest('tr').find('td').eq(1).text());
 		$("#client").val($(this).closest('tr').find('td').eq(2).text());
 		 $("#date").val($(this).closest('tr').find('td').eq(3).text());
 		// 	 $("#Nom").val("fedwa");
		 $("#heureD").val($(this).closest('tr').find('td').eq(4).text());
		$("#heureF").val($(this).closest('tr').find('td').eq(5).text());	
		$("#id_r").val($(this).closest('tr').find('td').eq(0).text());
		
		var content = "<form><div class='form-row'><div class='form-group col-md-6'><label>Nom</label><input type='text' class='form-control' value  = '"+$(this).closest('tr').find('td').eq(1).text()+"' id='Nom'><input type='hidden' class='form-control' placeholder='' id='id' value='"+$(this).closest('tr').find('td').eq(0).text()+"'></div><div class='form-group col-md-6'><label>Prenom</label><input type='text' class='form-control' id='Prenom' value = '"+$(this).closest('tr').find('td').eq(2).text()+"' ></div><div class='form-group col-md-6'><label>Numero telephone</label><input type='text' class='form-control' id='Phone'  value= '"+$(this).closest('tr').find('td').eq(3).text()+"'></div><div class='form-group col-md-6'><label>etat</label><input type='number' class='form-control' placeholder='' id='Etat' value='"+$(this).closest('tr').find('td').eq(4).text()+"'></div> </div></form>'";
		
		//$('#Bcontent').html(content);
		//$('#clientM').modal('show');
			
	});
	function remplir(data) {
		var ligne = "";
		for (var i = 0; i < data.length; i++) {
			ligne += "<tr><td>" + data[i].id + "</td><td>" + data[i].salle['code'] + "</td><td>" + data[i].client['nom'] + "</td><td>" + data[i].date + "</td><td>" + data[i].heureDebut+ "</td><td>" + data[i].heureFin + "</td><td><button type='button'  class='btn btn-danger delete' val='" + data[i].id + "'>Supprimer</button> <button type='button'   class='btn btn-warning mode'  data-toggle='modal' data-target='.bd-example-modal-lg' >Update</button></td></tr>";
		}
		$("#content").html(ligne);
	}
});