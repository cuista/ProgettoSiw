/**
 * JQuery/ajax, richieste server per il player
 */

$(document).ready(function() 
{
	dammiTutteLeCanzoni();
	dammiTuttiGliAlbum();
	dammiPlaylistUtente();
	dammiPlaylistCondiviseAltriUtenti();
	dammiPlaylistCondiviseDaUtente();
});

//RICHIESTE AJAX
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
			riempiPlayerCanzoni(list_canzoni);
		},
		error : function(canzoniJson) 
		{
			alert("ERROR");
		}
	});
}

function dammiTuttiGliAlbum()
{
	var list_canzoni;
	$.ajax({
		type : "POST",
		url : "DammiAlbum",
		datatype : "json",

		success : function(albumJson) 
		{
			list_album = JSON.parse(albumJson);
			riempiPlayerAlbum(list_album);
		},
		error : function(albumJson) 
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

//RIEMPIMENTO HTML CON RISULTATI
function riempiPlayerCanzoni(list_canzoni)
{
	var divPartenza = $(".tutteCanzoni");
	divPartenza.html("");
	
	var min=0; 
    var max=22;  
    var random =Math.floor(Math.random() * (+max - +min)) + +min;
    
	if(list_canzoni.length==0)
	{
		var nessunRisultato = $("<p>").addClass("text-white").attr("style", "width:100%;font-size: 2rem;").text("Nessun Risultato");
		divPartenza.append(nessunRisultato);
	}
	
	for(var i=(0+random); i<(8+random); i++)
	{		
		var divColonna = $("<div>").addClass("col-xs-6 col-sm-4 col-md-3 col-lg-2 col-xl-2").appendTo(divPartenza);
		
		var divCard = $("<div>").addClass("card").attr("onclick","prendiCanzoneDaId(" + list_canzoni[i].id + ")").attr("onmouseover","").attr("style","cursor: pointer;").appendTo(divColonna);
		
		var immagine = $("<img>")
		.attr("src", list_canzoni[i].album.immagine)
		.attr("alt", "immagine canzone")
		.addClass("card-img-top shape-vinyl")
		.appendTo(divCard);
		
		var divCardBody = $("<div>").addClass("card-body").appendTo(divCard);
		
		var p = $("<p>").addClass("card-title text-white").text(list_canzoni[i].titolo).appendTo(divCardBody);	
	}
}

function riempiPlayerAlbum(list_album)
{
	var divPartenza = $(".tuttiAlbum");
	divPartenza.html("");
	
	var min=0; 
	var max=1;  
	var random =Math.floor(Math.random() * (+max - +min)) + +min; 
	
	if(list_album.length==0)
	{
		var nessunRisultato = $("<p>").addClass("text-white").attr("style", "width:100%;font-size: 2rem;").text("Nessun Risultato");
		divPartenza.append(nessunRisultato);
	}
	
	for(var i=(0+random); i<(1+random); i++)
	{		
		var divColonna = $("<div>").addClass("col-xs-6 col-sm-4 col-md-3 col-lg-2 col-xl-2").appendTo(divPartenza);
		
		var divCard = $("<div>").addClass("card").attr("onclick","prendiCanzoniDaIdAlbum(" + list_album[i].id + ")").attr("onmouseover","").attr("style","cursor: pointer;").appendTo(divColonna);
		
		var immagine = $("<img>")
		.attr("src", list_album[i].immagine)
		.attr("alt", "immagine album")
		.addClass("card-img-top rounded")
		.appendTo(divCard);
		
		var divCardBody = $("<div>").addClass("card-body").appendTo(divCard);
		
		var p = $("<p>").addClass("card-title text-white").text(list_album[i].titolo).appendTo(divCardBody);	
	}
}

function riempiPlaylistUtente(list_playlistUtente)
{
	var divPartenza = $(".playlistUtente");
	divPartenza.html("");
	
	if(list_playlistUtente.length==0)
	{
		var nessunRisultato = $("<p>").addClass("text-white").attr("style", "width:100%;font-size: 2rem;").text("Nessun Risultato");
		divPartenza.append(nessunRisultato);
	}
	
	for(var i=0; i<list_playlistUtente.length; i++)
	{		
		var divColonna = $("<div>").addClass("col-xs-6 col-sm-4 col-md-3 col-lg-2 col-xl-2").appendTo(divPartenza);
		
		var divCard = $("<div>").addClass("card").attr("onclick","prendiCanzoniDaIdPlaylist(" + list_playlistUtente[i].id + ")").attr("onmouseover","").attr("style","cursor: pointer;").appendTo(divColonna);
		
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
	
	if(list_playlistCondAltriUtente.length==0)
	{
		var nessunRisultato = $("<p>").addClass("text-white").attr("style", "width:100%;font-size: 2rem;").text("Nessun Risultato");
		divPartenza.append(nessunRisultato);
	}
	
	for(var i=0; i<list_playlistCondAltriUtente.length; i++)
	{		
		var divColonna = $("<div>").addClass("col-xs-6 col-sm-4 col-md-3 col-lg-2 col-xl-2").appendTo(divPartenza);
		
		var divCard = $("<div>").addClass("card").attr("onclick","prendiCanzoniDaIdPlaylist(" + list_playlistCondAltriUtente[i].id + ")").attr("onmouseover","").attr("style","cursor: pointer;").appendTo(divColonna);
		
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
	
	if(list_playlistCondDaUtente.length==0)
	{
		var nessunRisultato = $("<p>").addClass("text-white").attr("style", "width:100%;font-size: 2rem;").text("Nessun Risultato");
		divPartenza.append(nessunRisultato);
	}
	
	for(var i=0; i<list_playlistCondDaUtente.length; i++)
	{		
		var divColonna = $("<div>").addClass("col-xs-6 col-sm-4 col-md-3 col-lg-2 col-xl-2").appendTo(divPartenza);
		
		var divCard = $("<div>").addClass("card").attr("onclick","prendiCanzoniDaIdPlaylist(" + list_playlistCondDaUtente[i].id + ")").attr("onmouseover","").attr("style","cursor: pointer;").appendTo(divColonna);
		
		var immagine = $("<img>")
		.attr("src", "img/icons/playlist-file.svg")
		.attr("alt", "playlist condivisa")
		.addClass("card-img-top")
		.appendTo(divCard);
		
		var divCardBody = $("<div>").addClass("card-body").appendTo(divCard);
		
		var p = $("<p>").addClass("card-title text-white").text(list_playlistCondDaUtente[i].nome).appendTo(divCardBody);	
	}
}