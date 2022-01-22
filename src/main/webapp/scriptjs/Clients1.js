$(document).ready(function() {
	
	
	$("#form1").submit(function() {
		

		var login = $("#login").val();
		var password= $("#password").val();

	$.ajax({
		url: "ClientsController",
		data: { op: "login" , login: login , pass: password},
		type: 'POST',

		success: function(data, textStatus, jqXHR) {


			
		},
		error: function(jqXHR, textStatus, errorthrown) {
			alert(textStatus);
		
		}

	});
	
	});
	
	
	
});