/**
 *  JQuery/ajax, gestione eventi player
 */

//CODA tracce musicali

$(document).ready(function() 
{
	var canzoneBenvenuto={titolo:"Benvenuto su Vinyl!",album:{titolo:"vinyl",anno:0,artista:{paese:"Italia",nome:"Ascolta subito i tuoi brani preferiti",id:-1,immagine:""},id:-2,immagine:"img/brand/brand_white.svg",genere:"introVinyl"},durata:0.20,id:-3,audio:"audio/benvenuti.mp3"};
	queueCanzoni = [canzoneBenvenuto];
	indiceCorrente = 0;
});
	
var indiceCorrente;
var queueCanzoni;

//Variabile AUDIO del player
var audio= $("audio")[0];

//AUDIO PLAYER
$(function()
{
	$(".play-pause").on("click", function()
	{
		if(audio.paused)
		{
			audio.play();
			$(".play-pause").removeClass("icon-play");
			$(".play-pause").addClass("icon-stop");
		}
		else
		{
			audio.pause();
			$(".play-pause").removeClass("icon-stop");
			$(".play-pause").addClass("icon-play");
		}
	});
	
	$('.next').on('click', function()
	{
		indiceCorrente=(indiceCorrente+1)%queueCanzoni.length;
		audio.src = queueCanzoni[indiceCorrente%queueCanzoni.length].audio;
		
		$(".player").find(".name").text(queueCanzoni[indiceCorrente%queueCanzoni.length].titolo);
		$(".player").find(".singer").text(queueCanzoni[indiceCorrente%queueCanzoni.length].album.artista.nome);
		$(".player").find(".artwork").attr("src",queueCanzoni[indiceCorrente%queueCanzoni.length].album.immagine);
		
		audio.play();
		
		$(".play-pause").removeClass("icon-play");
		$(".play-pause").addClass("icon-stop");
	});
	
	$('.previous').on('click', function()
	{
		indiceCorrente=((indiceCorrente-1)>=0)?(indiceCorrente-1)%queueCanzoni.length:(queueCanzoni.length+(indiceCorrente-1));
		audio.src = queueCanzoni[indiceCorrente%queueCanzoni.length].audio;
		
		$(".player").find(".name").text(queueCanzoni[indiceCorrente%queueCanzoni.length].titolo);
		$(".player").find(".singer").text(queueCanzoni[indiceCorrente%queueCanzoni.length].album.artista.nome);
		$(".player").find(".artwork").attr("src",queueCanzoni[indiceCorrente%queueCanzoni.length].album.immagine);
		
		audio.play();
		
		$(".play-pause").removeClass("icon-play");
		$(".play-pause").addClass("icon-stop");
	});
	
	audio.ontimeupdate = function()
	{
		$('.progress').css('width', audio.currentTime / audio.duration * 100 + '%')
		
		if(audio.currentTime == audio.duration)
			{
				indiceCorrente=(indiceCorrente+1)%queueCanzoni.length;
				audio.src = queueCanzoni[indiceCorrente%queueCanzoni.length].audio;
				
				$(".player").find(".name").text(queueCanzoni[indiceCorrente%queueCanzoni.length].titolo);
				$(".player").find(".singer").text(queueCanzoni[indiceCorrente%queueCanzoni.length].album.artista.nome);
				$(".player").find(".artwork").attr("src",queueCanzoni[indiceCorrente%queueCanzoni.length].album.immagine);
				
				audio.play();
				
				$(".play-pause").removeClass("icon-play");
				$(".play-pause").addClass("icon-stop");
			}
	};
});

//RICHIESTE AJAX
function prendiCanzoneDaId(idCanzone)
{	
	$.ajax({
		type : "POST",
		url : "PrendiCanzoneDaId",
		datatype : "json",
		data : {idCanzone : idCanzone},
		
		success : function(canzoneJson) 
		{
			queueCanzoni = [JSON.parse(canzoneJson)];
			indiceCorrente = 0;
			
			//LA MANDO IN PLAY
			audio.src = queueCanzoni[indiceCorrente%queueCanzoni.length].audio;
			$(".player").find(".name").text(queueCanzoni[indiceCorrente%queueCanzoni.length].titolo);
			$(".player").find(".singer").text(queueCanzoni[indiceCorrente%queueCanzoni.length].album.artista.nome);
			$(".player").find(".artwork").attr("src",queueCanzoni[indiceCorrente%queueCanzoni.length].album.immagine);
			audio.play();
			$(".play-pause").removeClass("icon-play");
			$(".play-pause").addClass("icon-stop");
		},
		error : function(canzoneJson) 
		{
			alert("ERROR");
		}
	});
}

function prendiCanzoniDaIdAlbum(idAlbum)
{	
	$.ajax({
		type : "POST",
		url : "PrendiCanzoniDaIdAlbum",
		datatype : "json",
		data : {idAlbum : idAlbum},
		
		success : function(canzoniJson) 
		{
			queueCanzoni = JSON.parse(canzoniJson);
			indiceCorrente = 0;
			
			//LA MANDO IN PLAY
			audio.src = queueCanzoni[indiceCorrente%queueCanzoni.length].audio;
			$(".player").find(".name").text(queueCanzoni[indiceCorrente%queueCanzoni.length].titolo);
			$(".player").find(".singer").text(queueCanzoni[indiceCorrente%queueCanzoni.length].album.artista.nome);
			$(".player").find(".artwork").attr("src",queueCanzoni[indiceCorrente%queueCanzoni.length].album.immagine);
			audio.play();
			$(".play-pause").removeClass("icon-play");
			$(".play-pause").addClass("icon-stop");
		},
		error : function(canzoniJson) 
		{
			alert("ERROR");
		}
	});
}

function prendiCanzoniDaIdPlaylist(idPlaylist)
{	
	$.ajax({
		type : "POST",
		url : "PrendiCanzoniDaIdPlaylist",
		datatype : "json",
		data : {idPlaylist : idPlaylist},
		
		success : function(canzoniJson) 
		{
			queueCanzoni = JSON.parse(canzoniJson);
			indiceCorrente = 0;
			
			//LA MANDO IN PLAY
			audio.src = queueCanzoni[indiceCorrente%queueCanzoni.length].audio;
			$(".player").find(".name").text(queueCanzoni[indiceCorrente%queueCanzoni.length].titolo);
			$(".player").find(".singer").text(queueCanzoni[indiceCorrente%queueCanzoni.length].album.artista.nome);
			$(".player").find(".artwork").attr("src",queueCanzoni[indiceCorrente%queueCanzoni.length].album.immagine);
			audio.play();
			$(".play-pause").removeClass("icon-play");
			$(".play-pause").addClass("icon-stop");
		},
		error : function(canzoniJson) 
		{
			alert("ERROR");
		}
	});
}

function prendiCanzoniDaIdArtista(idArtista)
{	
	$.ajax({
		type : "POST",
		url : "PrendiCanzoniDaIdArtista",
		datatype : "json",
		data : {idArtista : idArtista},
		
		success : function(canzoniJson) 
		{
			queueCanzoni = JSON.parse(canzoniJson);
			indiceCorrente = 0;
			
			//LA MANDO IN PLAY
			audio.src = queueCanzoni[indiceCorrente%queueCanzoni.length].audio;
			$(".player").find(".name").text(queueCanzoni[indiceCorrente%queueCanzoni.length].titolo);
			$(".player").find(".singer").text(queueCanzoni[indiceCorrente%queueCanzoni.length].album.artista.nome);
			$(".player").find(".artwork").attr("src",queueCanzoni[indiceCorrente%queueCanzoni.length].album.immagine);
			audio.play();
			$(".play-pause").removeClass("icon-play");
			$(".play-pause").addClass("icon-stop");
		},
		error : function(canzoniJson) 
		{
			alert("ERROR");
		}
	});
}

function condividiPlaylistId(idPlaylist)
{
	$.ajax({
		type : "POST",
		url : "CondividiPlaylist",
		datatype : "json",
		data : {idPlaylist : idPlaylist},
		
		success : function() 
		{
			dammiPlaylistCondiviseDaUtente();
			$(("#iconaPlaylistCondivisa" + idPlaylist)).attr("src", "img/icons/done-tick.svg");
			setTimeout(function() 
			{
				$(("#iconaPlaylistCondivisa" + idPlaylist)).attr("src", "img/icons/share-playlist.svg");
			}, 1000);
		},
		error : function() 
		{
			alert("ERROR");
		}
	});
}

