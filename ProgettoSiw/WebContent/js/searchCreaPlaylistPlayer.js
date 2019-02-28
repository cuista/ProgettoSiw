/**
 * JQuery/ajax, richieste al server da search
 */

//EVENTO FORM
$(document).ready(function() 
{
	$('form').keypress(function(e) { 
	    return e.keyCode != 13;	//per evitare il refresh premendo invio
	});
	
	$("#nomePlaylist").keypress(function(e) 
	{
        // Enter premuto?
        if(e.which == 10 || e.which == 13) 
        {            
            creaPlaylist(playlistDaCreare);
            
            nuovaPlaylist = [];
        }
	});
	
	$("#inputSearchForPlaylist").keyup(function()
	{
		ricercaCanzoniPerPlaylist($("#inputSearchForPlaylist").val());
	});
	
});

var nuovaPlaylist = [];

//RICHIESTE AJAX
function ricercaCanzoniPerPlaylist(stringa_daCercare)
{
	var list_canzoni;
	$.ajax({
		type : "POST",
		url : "RicercaCanzoni",
		datatype : "json",
		data : {"stringa_daCercare":stringa_daCercare},

		success : function(canzoniJson) 
		{
			list_canzoni = JSON.parse(canzoniJson);
			riempiCanzoniPerPlaylist(list_canzoni);
		},
		error : function(canzoniJson) 
		{
			alert("ERROR");
		}
	});
}

function aggiungiCanzoneAPlaylist(idCanzone)
{
	$.ajax({
		type : "POST",
		url : "PrendiCanzoneDaId",
		datatype : "json",
		data : {idCanzone : idCanzone},
		
		success : function(canzoneJson) 
		{
			var canzoneDaAggiungere = JSON.parse(canzoneJson);
			nuovaPlaylist.push(canzoneDaAggiungere);
		},
		error : function(canzoneJson) 
		{
			alert("ERROR");
		}
	});
}

function creaPlaylist(playlistDaCreare)
{
	$.ajax({
		type : "POST",
		url : "CreaPlaylist",
		datatype : "json",
		data : {playlistDaCreare : playlistDaCreare},

		success : function(data) 
		{
			alert(data);
			$("#playlistCreata-result")
			.html("<div class=\"alert alert-success\" role=\"alert\">Playlist creata con successo.</div>");
			setTimeout(function() 
			{
				$("#playlistCreata-result")
				.html("");
			}, 2000);
		},
		error : function(data) 
		{
			alert("ERROR");
		}
	});
}

//RIEMPIMENTO HTML CON RISULTATI
function riempiCanzoniPerPlaylist(list_canzoni)
{
	var divPartenza = $(".canzoniPerPlaylist");
	divPartenza.html("");
	
	if(list_canzoni.length==0)
	{
		var nessunRisultato = $("<p>").addClass("text-white").attr("style", "width:100%;font-size: 2rem;").text("Nessun Risultato");
		divPartenza.append(nessunRisultato);
	}
	
	for(var i=0; i<list_canzoni.length; i++)
	{
		var divColonna = $("<div>").addClass("col-xs-6 col-sm-4 col-md-3 col-lg-2 col-xl-2").appendTo(divPartenza);
		
		var divCard = $("<div>").addClass("card").attr("onclick","aggiungiCanzoneAPlaylist(" + list_canzoni[i].id + ")").attr("onmouseover","").attr("style","cursor: pointer;").appendTo(divColonna);
		
		var immagine = $("<img>")
		.attr("src", list_canzoni[i].album.immagine)
		.attr("alt", "immagine canzone")
		.addClass("card-img-top shape-vinyl")
		.appendTo(divCard);
		
		var divCardBody = $("<div>").addClass("card-body").appendTo(divCard);
		
		var p = $("<p>").addClass("card-title text-white").text(list_canzoni[i].titolo).appendTo(divCardBody);	
	}
}


