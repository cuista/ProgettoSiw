$(document).ready(function() {

	$("#FormLogin").submit(function(e) {

		$.ajax({
			type: "POST",
			url: "Login",
			data: $("#FormLogin").serialize(), 
			async:false,
			success: function(data)
			{
				if(data.valueOf() == "fallito")
				{
					//alert("DATI ERRATI");
					$("#login-result")
					.html("<div class=\"alert alert-danger\" role=\"alert\">Login fallito.</div>");
			setTimeout(
					function() {
						window.location.href = "login.jsp";
					}, 2000);
				}
				else
				{
					$(location).attr('href', "loginSuccesso.jsp");
				}

			},
			error: function(data)
			{
				alert("ERROR");
			}
		});

		e.preventDefault();

	});

});


