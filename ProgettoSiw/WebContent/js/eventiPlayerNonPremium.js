/**
 *  JQuery/ajax, gestione eventi player
 */

//CODA tracce musicali

$(document).ready(function() 
{
	avviaTutteLeCanzoni();
});
	
var indiceCorrente;
var queueCanzoni;
var skipRimasti = 10;

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
		if(skipRimasti > 0)
		{
			indiceCorrente=(indiceCorrente+1)%queueCanzoni.length;
			audio.src = queueCanzoni[indiceCorrente%queueCanzoni.length].audio;
			
			$(".player").find(".name").text(queueCanzoni[indiceCorrente%queueCanzoni.length].titolo);
			$(".player").find(".singer").text(queueCanzoni[indiceCorrente%queueCanzoni.length].album.artista.nome);
			$(".player").find(".artwork").attr("src",queueCanzoni[indiceCorrente%queueCanzoni.length].album.immagine);
			
			audio.play();
			
			$(".play-pause").removeClass("icon-play");
			$(".play-pause").addClass("icon-stop");
			
			skipRimasti--;
			$(".skip").text(skipRimasti);
		}
	});
	
	$('.previous').on('click', function()
	{
		if(skipRimasti > 0)
		{
			indiceCorrente=((indiceCorrente-1)>=0)?(indiceCorrente-1)%queueCanzoni.length:(queueCanzoni.length+(indiceCorrente-1));
			audio.src = queueCanzoni[indiceCorrente%queueCanzoni.length].audio;
			
			$(".player").find(".name").text(queueCanzoni[indiceCorrente%queueCanzoni.length].titolo);
			$(".player").find(".singer").text(queueCanzoni[indiceCorrente%queueCanzoni.length].album.artista.nome);
			$(".player").find(".artwork").attr("src",queueCanzoni[indiceCorrente%queueCanzoni.length].album.immagine);
			
			audio.play();
			
			$(".play-pause").removeClass("icon-play");
			$(".play-pause").addClass("icon-stop");
			
			skipRimasti--;
			$(".skip").text(skipRimasti);
		}
	});
	
	audio.ontimeupdate = function()
	{
		$('.progress').css('width', audio.currentTime / audio.duration * 100 + '%')
		
		if(audio.currentTime == audio.duration)
			{
				indiceCorrente=(indiceCorrente+1)%queueCanzoni.length;
				audio.src = queueCanzoni[indiceCorrente%queueCanzoni.length].audio;
				
				if(queueCanzoni[indiceCorrente%queueCanzoni.length]!="audio/benvenuti.mp3")
				{
					$(".player").find(".name").text(queueCanzoni[indiceCorrente%queueCanzoni.length].titolo);
					$(".player").find(".singer").text(queueCanzoni[indiceCorrente%queueCanzoni.length].album.artista.nome);
					$(".player").find(".artwork").attr("src",queueCanzoni[indiceCorrente%queueCanzoni.length].album.immagine);
				}
				
				audio.play();
				
				$(".play-pause").removeClass("icon-play");
				$(".play-pause").addClass("icon-stop");
			}
	};
});

function avviaTutteLeCanzoni()
{	
	var list_canzoni;
	$.ajax({
		type : "POST",
		url : "DammiCanzoni",
		datatype : "json",
		
		success : function(canzoniJson) 
		{
			queueCanzoni = JSON.parse(canzoniJson);
			indiceCorrente=0;
			
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

