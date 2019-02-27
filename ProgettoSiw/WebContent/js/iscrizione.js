$("#FormIscrizione").submit(function(e) {

	$.ajax({
		type: "POST",
		url: "IscrizioneUtente",
		data: $("#FormIscrizione").serialize(), 
		async:false,
		success: function(data)
		{
			if(data.valueOf() == "puoiLoggare")
			{
				$("#iscrizione-result")
				.html(
						"<div class=\"alert alert-danger\" role=\"alert\">Email già registrata.</div>");
		setTimeout(function() {
		}, 2000);
			}
			else if(data.valueOf() == "usernameUguale")
			{
				$("#iscrizione-result")
				.html(
						"<div class=\"alert alert-danger\" role=\"alert\">Username non disponibile.</div>");
		setTimeout(function() {
		}, 2000);
			}
			else if(data.valueOf() == "usernameCorto")
			{
				$("#iscrizione-result")
				.html(
						"<div class=\"alert alert-danger\" role=\"alert\">L'username è troppo corto.</div>");
		setTimeout(function() {
		}, 2000);
			}
			else if(data.valueOf() == "passwordCorta")
			{
				$("#iscrizione-result")
				.html(
						"<div class=\"alert alert-danger\" role=\"alert\">La password è troppo corta.</div>");
		setTimeout(function() {
		}, 2000);
			}
			else if(data.valueOf() == "emailDifferenti")
			{
				$("#iscrizione-result")
				.html(
						"<div class=\"alert alert-danger\" role=\"alert\">Le due email non corrispondono.</div>");
		setTimeout(function() {
		}, 2000);
			}
			else
			{
				$("#iscrizione-result")
				.html(
						"<div class=\"alert alert-success\" role=\"alert\">Stai per entrare nel sito.</div>");
		setTimeout(
				function() {
					window.location.href = "iscrizioneSuccesso.jsp";
				}, 2000);
			}

		},
		error: function(data)
		{
			alert("ERROR");
		}
	});

	e.preventDefault();

});