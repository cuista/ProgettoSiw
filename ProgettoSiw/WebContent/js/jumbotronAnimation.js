/**
 * JQuery, animazione per alzare il jumbotron quando è nello stato di mouseover
 */

$(document).ready(function()
{
	$(".jumbotron").addClass("animated faster");
	$(".jumbotron").on("mouseover",function()
	{
			$(this).addClass("pulseIn");
			$(this).removeClass("pulseOut");
	});
	$(".jumbotron").on("mouseleave",function()
	{
			$(this).addClass("pulseOut");
			$(this).removeClass("pulseIn");
	});
});