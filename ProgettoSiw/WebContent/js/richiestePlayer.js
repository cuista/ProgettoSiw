/**
 * JQuery/ajax, richieste server per il player
 */

$(document).ready(function() 
{
	dammiTutteLeCanzoni();
	dammiPlaylistUtente();
	dammiPlaylistCondiviseAltriUtenti();
	dammiPlaylistCondiviseDaUtente();
});

function dammiTutteLeCanzoni()
{
	var list_canzoni;
	$.ajax({
		type : "POST",
		url : "DammiCanzoni",
		datatype : "json",

		success : function(canzoniJson) 
		{
			list_canzoni = JSON.parse(canzoniJson);
			riempiPlayer(list_canzoni);
		},
		error : function(canzoniJson) 
		{
			alert("ERROR");
		}
	});
}

function dammiPlaylistUtente()
{
	var list_playlistUtente;
	$.ajax({
		type : "POST",
		url : "DammiPlaylistUtente",
		datatype : "json",

		success : function(playlistUtenteJson) 
		{
			list_playlistUtente = JSON.parse(playlistUtenteJson);
			riempiPlaylistUtente(list_playlistUtente);
		},
		error : function(playlistUtenteJson)
		{
			alert("ERROR");
		}
	});
}

function dammiPlaylistCondiviseAltriUtenti()
{
	var list_playlistCondAltriUtenti;
	$.ajax({
		type : "POST",
		url : "DammiPlaylistCondiviseAltriUtenti",
		datatype : "json",

		success : function(plCondAltriUtentiJson) 
		{
			list_playlistCondAltriUtenti = JSON.parse(plCondAltriUtentiJson);
			riempiPlaylistCondiviseAltriUtenti(list_playlistCondAltriUtenti);
		},
		error : function(plCondAltriUtentiJson) 
		{
			alert("ERROR");
		}
	});
}

function dammiPlaylistCondiviseDaUtente()
{
	var list_playlistCondDaUtente;
	$.ajax({
		type : "POST",
		url : "DammiPlaylistCondiviseDaUtente",
		datatype : "json",

		success : function(plCondDaUtenteJson)
		{
			list_playlistCondDaUtente = JSON.parse(plCondDaUtenteJson);
			riempiPlaylistCondiviseDaUtente(list_playlistCondDaUtente);
		},
		error : function(plCondDaUtenteJson) 
		{
			alert("ERROR");
		}
	});
}

function riempiPlayer(list_canzoni)
{
	var divPartenza = $(".tutteCanzoni");
	divPartenza.html("");
	
	for(var i=0; i<list_canzoni.length; i++)
	{		
		var divColonna = $("<div>").addClass("col-xs-6 col-sm-4 col-md-3 col-lg-2 col-xl-2").appendTo(divPartenza);
		
		var divCard = $("<div>").addClass("card").appendTo(divColonna);
		
		var immagine = $("<img>")
		.attr("src", "img/album/album4.jpg")
		.attr("alt", "immagine canzone")
		.addClass("card-img-top")
		.appendTo(divCard);
		
		var divCardBody = $("<div>").addClass("card-body").appendTo(divCard);
		
		var p = $("<p>").addClass("card-title text-white").text(list_canzoni[i].titolo).appendTo(divCardBody);	
	}
}

function riempiPlaylistUtente(list_playlistUtente)
{
	var divPartenza = $(".playlistUtente");
	divPartenza.html("");
	
	for(var i=0; i<list_playlistUtente.length; i++)
	{		
		var divColonna = $("<div>").addClass("col-xs-6 col-sm-4 col-md-3 col-lg-2 col-xl-2").appendTo(divPartenza);
		
		var divCard = $("<div>").addClass("card").appendTo(divColonna);
		
		var immagine = $("<img>")
		.attr("src", "img/icons/playlist-file.svg")
		.attr("alt", "playlist condivisa")
		.addClass("card-img-top")
		.appendTo(divCard);
		
		var divCardBody = $("<div>").addClass("card-body").appendTo(divCard);
		
		var p = $("<p>").addClass("card-title text-white").text(list_playlistUtente[i].nome).appendTo(divCardBody);	
	}
}

function riempiPlaylistCondiviseAltriUtenti(list_playlistCondAltriUtente)
{
	var divPartenza = $(".playlistCondiviseAltriUtenti");
	divPartenza.html("");
	
	for(var i=0; i<list_playlistCondAltriUtente.length; i++)
	{		
		var divColonna = $("<div>").addClass("col-xs-6 col-sm-4 col-md-3 col-lg-2 col-xl-2").appendTo(divPartenza);
		
		var divCard = $("<div>").addClass("card").appendTo(divColonna);
		
		var immagine = $("<img>")
		.attr("src", "img/icons/playlist-file.svg")
		.attr("alt", "playlist condivisa")
		.addClass("card-img-top")
		.appendTo(divCard);
		
		var divCardBody = $("<div>").addClass("card-body").appendTo(divCard);
		
		var p = $("<p>").addClass("card-title text-white").text(list_playlistCondAltriUtente[i].nome).appendTo(divCardBody);	
	}
}

function riempiPlaylistCondiviseDaUtente(list_playlistCondDaUtente)
{
	var divPartenza = $(".playlistCondiviseDaUtente");
	divPartenza.html("");
	
	for(var i=0; i<list_playlistCondDaUtente.length; i++)
	{		
		var divColonna = $("<div>").addClass("col-xs-6 col-sm-4 col-md-3 col-lg-2 col-xl-2").appendTo(divPartenza);
		
		var divCard = $("<div>").addClass("card").appendTo(divColonna);
		
		var immagine = $("<img>")
		.attr("src", "img/icons/playlist-file.svg")
		.attr("alt", "playlist condivisa")
		.addClass("card-img-top")
		.appendTo(divCard);
		
		var divCardBody = $("<div>").addClass("card-body").appendTo(divCard);
		
		var p = $("<p>").addClass("card-title text-white").text(list_playlistCondDaUtente[i].nome).appendTo(divCardBody);	
	}
}