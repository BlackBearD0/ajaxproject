$(document).ready(function () {



$("#form1").submit(function() {
		 var Fname = $("#firstName").val();
		var lname =  $("#lastName").val();
		var mail = $("#mail").val();
		var phone = $("#phone").val();
		var password = $("#password").val();
	
				$.ajax({
					url: "ClientsController",
					data: { Fname: Fname, lname: lname, mail: mail , phone: phone, password: password},
					type: 'POST',
					success: function(data, textStatus, jqXHR) {

				  window.location.href = "login.jsp";
					},
					error: function(jqXHR, textStatus, errorthrown) {
					alert(textStatus);
					alert("error");
					}
					});
			});









$( "#ConfirmPassword" ).change(function() {
		  
	var password = 	$("#password").val();
	var Cpass = $("#ConfirmPassword").val();
	if(password != Cpass){
		alert("unmatced password please rewrite");
	}
});
});