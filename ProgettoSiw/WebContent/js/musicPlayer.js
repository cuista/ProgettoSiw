/**
 * JQuery, funzioni per MusicPlayer
 */

$(function()
{
	var audio= $("audio")[0];
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
	audio.src = "audio/mrbluesky.mp3";
	audio.play();
	$(".play-pause").removeClass("icon-play");
	$(".play-pause").addClass("icon-stop");
	});
	
	audio.ontimeupdate = function(){
    $('.progress').css('width', audio.currentTime / audio.duration * 100 + '%')
	};
});