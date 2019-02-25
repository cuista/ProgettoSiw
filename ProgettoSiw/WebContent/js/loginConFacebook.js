/**
 * Login con FB
 */

 window.fbAsyncInit = function() {
	    FB.init({
	      appId            : '2058502200866258',
	      autoLogAppEvents : true,
	      xfbml            : true,
	      version          : 'v2.12'
	    });
	  };

	  (function(d, s, id){
	     var js, fjs = d.getElementsByTagName(s)[0];
	     if (d.getElementById(id)) {return;}
	     js = d.createElement(s); js.id = id;
	     js.src = "https://connect.facebook.net/en_US/sdk.js";
	     fjs.parentNode.insertBefore(js, fjs);
	   }(document, 'script', 'facebook-jssdk'));
	  
	  
function fbLogin() 
{
	FB.login(function(response)
	{
		if (response.authResponse) 
		{
			// Get and display the user profile data
			salvaDatiInDB(response);
			// getFbUserData();
		} 
		else 
		{
			document.getElementById('status').innerHTML = 'Email/Password errati o hai annullato il login.';
		}
					
	}, 
	{
		scope : 'email'
	});	
}
		
function salvaDatiInDB(response) 
{
	FB.api('/me',
	{
		locale : 'en_US',
		fields : 'id,first_name,last_name,email,link,gender,locale,picture'
	},
	function(response) {
		
		var username=(response.first_name+response.last_name);
		
		var stringa_vuota="";
		
		var jsonUtente = {
			username: username,
			mail: response.email,
			password: "utenteFacebook1",												
			premium: "0"
		}
		$.ajax({
			type : "POST",
			url : "LoginDaFacebookServlet",
			datatype : "json",
			data : {jsonUtenteFacebook : JSON.stringify(jsonUtente)},
			success : function(data) 
			{
				$("#facebook-result").html("<div class=\"alert alert-success\" role=\"alert\">  Stai per entrare nel sito.</div>");
				setTimeout(function()
						{
							window.location.href = "index.jsp";
						}, 2000);
			},
			error : function() 
			{
				$("#facebook-result").html("<div class=\"alert alert-danger\" role=\"alert\">Login fallito.</div>");
				setTimeout(function() {}, 2000);
			}
		});

	});
}
		
