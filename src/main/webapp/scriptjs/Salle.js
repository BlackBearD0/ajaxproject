$(document).ready(function() {




	$.ajax({
		url: "SalleController",
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
		var Code = $("#Code").val();
		var Capacite = $("#Capacite").val();
		var Type = $("#Type").val();

		console.log(Code + " " + Capacite + " " + Type);
		$.ajax({
			url: "SalleController",
			data: { Code1: Code, Capacite1: Capacite, Type1: Type },
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
			url: "SalleController",
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
		$("#form1").on("submit",function() {
		 var code= 	$("#code").val();
		 var cpacity = $("#capacity").val();
		 var type = $("#type").val();
	var op ="add";
	
				//alert(op);
				$.ajax({
					url: "SalleController",
					data: { Code: code, Capacite: capacity, Type: type },
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
	
	$("#content").on("click", ".update", function() {
		//alert($(this).attr('val'));
		var Code = $("#Code").val();
		var Capacite = $("#Capacite").val();
		var Type = $("#Type").val();
		var id = $(this).closest('tr').find('td').eq(0).text();
		$.ajax({
			url: "SalleController",
			data: { op: "update", id: id, Code1: Code, Capacite1: Capacite, Type1: Type },
			type: 'POST',
			success: function(data, textStatus, jqXHR) {
				remplir(data);
			},
			error: function(jqXHR, textStatus, errorThrown) {
				console.log(textStatus);
			}
		});
	});
	
	$("#content").on("click",".mode", function() {
		//alert("allo");
 		
 		 $("#code").val($(this).closest('tr').find('td').eq(1).text());
 		$("#capacity").val($(this).closest('tr').find('td').eq(2).text());
 		 $("#type").val($(this).closest('tr').find('td').eq(3).text());
 		// 	 $("#Nom").val("fedwa");
		
		$("#id_s").val($(this).closest('tr').find('td').eq(0).text());
		
	//	var content = "<form><div class='form-row'><div class='form-group col-md-6'><label>Nom</label><input type='text' class='form-control' value  = '"+$(this).closest('tr').find('td').eq(1).text()+"' id='Nom'><input type='hidden' class='form-control' placeholder='' id='id' value='"+$(this).closest('tr').find('td').eq(0).text()+"'></div><div class='form-group col-md-6'><label>Prenom</label><input type='text' class='form-control' id='Prenom' value = '"+$(this).closest('tr').find('td').eq(2).text()+"' ></div><div class='form-group col-md-6'><label>Numero telephone</label><input type='text' class='form-control' id='Phone'  value= '"+$(this).closest('tr').find('td').eq(3).text()+"'></div><div class='form-group col-md-6'><label>etat</label><input type='number' class='form-control' placeholder='' id='Etat' value='"+$(this).closest('tr').find('td').eq(4).text()+"'></div> </div></form>'";
		
		//$('#Bcontent').html(content);
		//$('#clientM').modal('show');
			
	});
	function remplir(data) {
		var ligne = "";
		for (var i = 0; i < data.length; i++) {
			ligne += "<tr><td>" + data[i].id + "</td><td>" + data[i].code + "</td><td>" + data[i].capacite + "</td><td>" + data[i].type + "</td><td><button type='button'  class='btn btn-danger delete' val='" + data[i].id + "'>Supprimer</button> <button type='button'   class='btn btn-warning mode'  data-toggle='modal' data-target='.bd-example-modal-lg'>Update</button></td></tr>";
		}
		$("#content").html(ligne);
	}
});