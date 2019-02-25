/**
 * JQuery/ajax, richieste al server da search
 */

//EVENTO FORM
$(document).ready(function() 
{
	$("#inputSearch").keyup(function()
	{
		//FUNZIONI AJAX
		ricercaCanzoni($("#inputSearch").val());
	    ricercaAlbum($("#inputSearch").val());
	    ricercaArtisti($("#inputSearch").val());
	    ricercaPlaylist($("#inputSearch").val());
	});
});

//RICHIESTE AJAX
function ricercaCanzoni(stringa_daCercare)
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
			riempiCanzoni(list_canzoni);
		},
		error : function(canzoniJson) 
		{
			alert("ERROR");
		}
	});
}

function ricercaAlbum(stringa_daCercare)
{
	var list_album;
	$.ajax({
		type : "POST",
		url : "RicercaAlbum",
		datatype : "json",
		data : {"stringa_daCercare":stringa_daCercare},

		success : function(albumJson) 
		{
			list_album = JSON.parse(albumJson);
			riempiAlbum(list_album);
		},
		error : function(albumJson) 
		{
			alert("ERROR");
		}
	});
}

function ricercaArtisti(stringa_daCercare)
{
	var list_artisti;
	$.ajax({
		type : "POST",
		url : "RicercaArtisti",
		datatype : "json",
		data : {"stringa_daCercare":stringa_daCercare},

		success : function(artistiJson) 
		{
			list_artisti = JSON.parse(artistiJson);
			riempiArtisti(list_artisti);
		},
		error : function(artistiJson) 
		{
			alert("ERROR");
		}
	});
}

function ricercaPlaylist(stringa_daCercare)
{
	var list_playlist;
	$.ajax({
		type : "POST",
		url : "RicercaPlaylist",
		datatype : "json",
		data : {"stringa_daCercare":stringa_daCercare},

		success : function(playlistJson) 
		{
			list_playlist = JSON.parse(playlistJson);
			riempiPlaylist(list_playlist);
		},
		error : function(playlistJson) 
		{
			alert("ERROR");
		}
	});
}

//RIEMPIMENTO HTML CON RISULTATI
function riempiCanzoni(list_canzoni)
{
	var divPartenza = $(".canzoni");
	divPartenza.html("");
	
	if(list_canzoni.length==0)
	{
		var nessunRisultato = $("<p>").addClass("text-white").attr("style", "width:100%;font-size: 2rem;").text("Nessun Risultato");
		divPartenza.append(nessunRisultato);
	}
	
	for(var i=0; i<list_canzoni.length; i++)
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

function riempiAlbum(list_album)
{
	var divPartenza = $(".album");
	divPartenza.html("");
	
	if(list_album.length==0)
	{
		var nessunRisultato = $("<p>").addClass("text-white").attr("style", "width:100%;font-size: 2rem;").text("Nessun Risultato");
		divPartenza.append(nessunRisultato);
	}
	
	for(var i=0; i<list_album.length; i++)
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

function riempiArtisti(list_artisti)
{
	var divPartenza = $(".artisti");
	divPartenza.html("");
	
	if(list_artisti.length==0)
	{
		var nessunRisultato = $("<p>").addClass("text-white").attr("style", "width:100%;font-size: 2rem;").text("Nessun Risultato");
		divPartenza.append(nessunRisultato);
	}
	
	for(var i=0; i<list_artisti.length; i++)
	{
		var divColonna = $("<div>").addClass("col-xs-6 col-sm-4 col-md-3 col-lg-2 col-xl-2").appendTo(divPartenza);
		
		var divCard = $("<div>").addClass("card").appendTo(divColonna);
		
		var immagine = $("<img>")
		.attr("src", list_artisti[i].immagine)
		.attr("alt", "immagine artista")
		.addClass("card-img-top rounded-circle")
		.appendTo(divCard);
		
		var divCardBody = $("<div>").addClass("card-body").appendTo(divCard);
		
		var p = $("<p>").addClass("card-title text-white").text(list_artisti[i].nome).appendTo(divCardBody);
	}
}

function riempiPlaylist(list_playlist)
{
	var divPartenza = $(".playlist");
	divPartenza.html("");
	
	if(list_playlist.length==0)
	{
		var nessunRisultato = $("<p>").addClass("text-white").attr("style", "width:100%;font-size: 2rem;").text("Nessun Risultato");
		divPartenza.append(nessunRisultato);
	}
	
	for(var i=0; i<list_playlist.length; i++)
	{
		var divColonna = $("<div>").addClass("col-xs-6 col-sm-4 col-md-3 col-lg-2 col-xl-2").appendTo(divPartenza);
		
		var divCard = $("<div>").addClass("card").attr("onclick","prendiCanzoniDaIdPlaylist(" + list_playlist[i].id + ")").attr("onmouseover","").attr("style","cursor: pointer;").appendTo(divColonna);
		
		var immagine = $("<img>")
		.attr("src", "img/icons/playlist.svg")
		.attr("alt", "immagine playlist")
		.addClass("card-img-top")
		.appendTo(divCard);
		
		var divCardBody = $("<div>").addClass("card-body").appendTo(divCard);
		
		var p = $("<p>").addClass("card-title text-white").text(list_playlist[i].nome).appendTo(divCardBody);	
	}
}
