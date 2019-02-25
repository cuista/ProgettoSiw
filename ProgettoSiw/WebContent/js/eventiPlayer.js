/**
 *  JQuery/ajax, gestione eventi player
 */

//CODA tracce musicali
var indiceCorrente = 0;
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
		audio.src = queueCanzoni[indiceCorrente%queueCanzoni.length].audio;
		
		$(".player").find(".name").text(queueCanzoni[indiceCorrente%queueCanzoni.length].titolo);
		$(".player").find(".singer").text(queueCanzoni[indiceCorrente%queueCanzoni.length].album.artista.nome);
		$(".player").find(".artwork").attr("src",queueCanzoni[indiceCorrente%queueCanzoni.length].album.immagine);
		
		audio.play();
		indiceCorrente++;
		
		$(".play-pause").removeClass("icon-play");
		$(".play-pause").addClass("icon-stop");
	});
	
	audio.ontimeupdate = function()
	{
		$('.progress').css('width', audio.currentTime / audio.duration * 100 + '%')
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
			
			//LA MANDO IN PLAY
			audio.src = queueCanzoni[indiceCorrente%queueCanzoni.length].audio;
			$(".player").find(".name").text(queueCanzoni[indiceCorrente%queueCanzoni.length].titolo);
			$(".player").find(".singer").text(queueCanzoni[indiceCorrente%queueCanzoni.length].album.artista.nome);
			$(".player").find(".artwork").attr("src",queueCanzoni[indiceCorrente%queueCanzoni.length].album.immagine);
			audio.play();
			indiceCorrente++;
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
			
			//LA MANDO IN PLAY
			audio.src = queueCanzoni[indiceCorrente%queueCanzoni.length].audio;
			$(".player").find(".name").text(queueCanzoni[indiceCorrente%queueCanzoni.length].titolo);
			$(".player").find(".singer").text(queueCanzoni[indiceCorrente%queueCanzoni.length].album.artista.nome);
			$(".player").find(".artwork").attr("src",queueCanzoni[indiceCorrente%queueCanzoni.length].album.immagine);
			audio.play();
			indiceCorrente++;
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
			
			//LA MANDO IN PLAY
			audio.src = queueCanzoni[indiceCorrente%queueCanzoni.length].audio;
			$(".player").find(".name").text(queueCanzoni[indiceCorrente%queueCanzoni.length].titolo);
			$(".player").find(".singer").text(queueCanzoni[indiceCorrente%queueCanzoni.length].album.artista.nome);
			$(".player").find(".artwork").attr("src",queueCanzoni[indiceCorrente%queueCanzoni.length].album.immagine);
			audio.play();
			indiceCorrente++;
			$(".play-pause").removeClass("icon-play");
			$(".play-pause").addClass("icon-stop");
		},
		error : function(canzoniJson) 
		{
			alert("ERROR");
		}
	});
}
