<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Accedi</title>
	<link rel="stylesheet" href="css/bootstrap.min.css"></link>
	<link rel="stylesheet" href="css/style.css"></link>
	<!-- ADATTAMENTO MOBILE -->
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
<body>

<!---------------------------------------------------------------
 NAVBAR
 !--------------------------------------------------------------->
<nav class="navbar fixed-top navbar-expand-lg navbar-dark">
	<div class="container">
	  <a class="navbar-brand" href="index.jsp">
		<img src="img/brand/brand_white_vinyl.svg" width="150" height="40" class="d-inline-block align-top" alt="vinyl-brand">
		
	  </a>
	  
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	  </button>

	  <div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav ml-auto"> <!-- ml ==> Margin Left: auto; !-->
		  <li class="nav-item">
			<a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
		  </li>
		  <li class="nav-item">
			<a class="nav-link" href="#">Premium</a>
		  </li>
		  <li class="nav-item dropdown" style="margin-right: 30px;">
			<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			  Dropdown
			</a>
			<div class="dropdown-menu" aria-labelledby="navbarDropdown">
			  <a class="dropdown-item" href="#">Action</a>
			  <a class="dropdown-item" href="#">Another action</a>
			  <div class="dropdown-divider"></div>
			  <a class="dropdown-item" href="#">Something else here</a>
			</div>
		  </li>
		  <!-- IF USER LOGGATO -->
		  <c:if test="${empty user.username}">
		  	<li class="nav-item">
				<a class="nav-link" href="iscrizione.jsp">Iscriviti</a>
		  	</li>
		  	<li class="nav-item">
				<a class="nav-link active" href="login.jsp">Accedi</a>
		  	</li>
		  </c:if>
		  <!-- ENDIF -->
		  <!-- IF USER NON LOGGATO -->
		  <c:if test="${not empty user.username}">
		  	<li class="nav-item dropdown" style="margin-right: 30px;">
				<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			  	<img src="img/icons/user.svg" class="d-inline-block align-top rounded-circle border border-light" alt="user-icon" style="margin-right: 5px;" height="24">Profilo
				</a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
			  		<a class="dropdown-item" href="gestioneUtente.jsp">Account</a>
			  		<a class="dropdown-item disabled" href="Logout">Disconnetti</a>
				</div>
			</li>
		  </c:if>
		  <!-- ENDIF -->
		</ul>
		
	  </div>
	</div>
</nav>

<!---------------------------------------------------------------
 LOGIN
 !--------------------------------------------------------------->
<section class="login-iscrizione">
	<form method="post" action="Login" class="container jumbotron border">
		<img src="img/brand/brand_black_vinyl.svg" width="225" height="60" class="d-inline-block align-top" alt="vinyl-brand">
		<hr>
		  <div class="row">
    		<div class="col-sm-12 col-md-6 offset-md-3">
				<button type="submit" class="btn btn-primary btn-lg btn-block rounded-pill">ACCEDI CON FACEBOOK</button>
				<p class="text-small"><span style="color: #919496">Se clicchi su "Accedi con Facebook" e non sei un utente Vinyl, sarai registrato su Vinyl e accetterai i relativi <a href="#">Termini e condizioni</a>.</span></p>
				<hr>
				<h1 class="text-small"><span style="font-weight: 600;">Accedi con il tuo indirizzo email.</span></h1>
				<div class="form-group">
					<input name="email" type="text" class="form-control" placeholder="Indirizzo Email">
				</div>
				<div class="form-group">
					<input name="password" type="password" class="form-control" aria-describedby="passwordHelp" placeholder="Password">
				</div>
				<div class="form-group form-check">
					<div class="row justify-content-between">
    					<div class="col-sm-12 col-md-5">
							<input type="checkbox" class="form-check-input" id="exampleCheck1">
							<label class="form-check-label" for="exampleCheck1">Ricordami</label>
						</div>
						<div class="col-sm-12 col-md-5">
							<button type="submit" class="btn btn-success rounded-pill">ACCEDI</button>
						</div>
					</div>
					<a href="#" id="passwordHelp" class="form-text text-muted"><span style="line-height: 2.5;">Hai dimenticato la password?</span></a>
				</div>
				<hr>
				<h1 class="text-small"><span style="font-weight: 600;">Non hai un account?</span></h1>
				<a href="iscrizione.jsp" class="btn btn-secondary btn-lg btn-block rounded-pill" role="button">ISCRIVITI A VINYL</a>
				<hr>
				<p class="text-small"><span style="color: #919496">Se desideri ulteriori informazioni su come Vinyl raccoglie, elabora, condivide e protegge i tuoi dati personali, leggi l'Informativa sulla privacy di Vinyl. <a href="#">Maggiori informazioni</a>.</span></p>
			</div>
		</div>
	</form>
</section>

<!---------------------------------------------------------------
 FOOTER
 !--------------------------------------------------------------->
<section class="footer">
		<div class="container">
			<div class="text-center py-3 lead">
				<aside>
					<img src="img/brand/brand_white_vinyl.svg" width="150" height="40" class="d-inline-block align-top" alt="">
				</aside>
				Copyright © 2019 - Cuista
				<p class="lead"> 
					Visita la mia <a href="https://github.com/cuista" target="_blank"> Pagina GitHub </a> <br> per visionare altri miei progetti
				</p>
			</div>
		</div>
</section>














<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jumbotronAnimation.js"></script>


</body>
</html>