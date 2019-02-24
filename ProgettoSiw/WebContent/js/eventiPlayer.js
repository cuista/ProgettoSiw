/**
 *  JQuery/ajax, gestione eventi player
 */

//CODA tracce musicali
var indiceCorrente = 0;
var queueUrl = ["audio/mrbluesky.mp3","audio/bytheway/cabron.mp3","audio/showbiz/showbiz.mp3"];
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
	audio.src = queueUrl[indiceCorrente%queueUrl.length];
	$(".player").find(".name").text(queueCanzoni[indiceCorrente%queueUrl.length].titolo);
	//$(".player").find(".singer").text(queueAlbum[indiceCorrente%queueUrl.length].titolo);
	//$(".player").find(".artwork").attr("src",queueAlbum[indiceCorrente%queueUrl.length].immagine);	
	audio.play();
	indiceCorrente++;
	
	$(".play-pause").removeClass("icon-play");
	$(".play-pause").addClass("icon-stop");
	});
	
	audio.ontimeupdate = function(){
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
			var canzone = JSON.parse(canzoneJson);
			queueUrl=[canzone.audio];
			queueCanzoni=[canzone];
			
			//LA MANDO IN PLAY
			audio.src = queueUrl[indiceCorrente%queueUrl.length];
			$(".player").find(".name").text(queueCanzoni[indiceCorrente%queueUrl.length].titolo);
			//$(".player").find(".singer").text(queueAlbum[indiceCorrente%queueUrl.length].titolo);
			//$(".player").find(".artwork").attr("src",queueAlbum[indiceCorrente%queueUrl.length].immagine);
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
