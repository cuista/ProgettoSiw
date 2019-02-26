/**
 *  Disdici premium
 */

function disdiciPremium()
{
	$.ajax({
		method: "POST",
		url: "TogliUtentePremium",
		success : function() 
		{
			window.location.href = "/ProgettoSiw/premium.jsp";
		},
		error : function() 
		{
			alert("ERROR");
		}
	});
}