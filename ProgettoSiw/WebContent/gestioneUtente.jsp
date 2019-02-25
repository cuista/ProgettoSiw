<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Gestione Utente</title>
	<link rel="stylesheet" href="css/bootstrap.min.css"></link>
	<link rel="stylesheet" href="css/style.css"></link>
	<link rel="stylesheet" href="css/sidebar.css"></link>
	<!-- ADATTAMENTO MOBILE -->
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
<body>

<!---------------------------------------------------------------
 NAVBAR
 !--------------------------------------------------------------->
<nav class="navbar navbar-expand-lg navbar-dark">
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
			<a class="nav-link" href="premium.jsp">Premium</a>
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
				<a class="nav-link" href="login.jsp">Accedi</a>
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
			  		<a class="dropdown-item active" href="gestioneUtente.jsp">Account</a>
			  		<a class="dropdown-item" href="Logout">Disconnetti</a>
				</div>
			</li>
		  </c:if>
		  <!-- ENDIF -->
		</ul>
		
	  </div>
	</div>
</nav>

<!---------------------------------------------------------------
 BANNER
 !--------------------------------------------------------------->
<section class="container banner" style="background-image: url(img/gestioneUtente.jpg);">
		<div class="row">
			<div class="col-sm-5 offset-sm-7">
				<h3>Passa alla versione Premium,<br> il primo mese è gratis!</h3>
				<p>Puoi annullare l'abbonamento in qualsiasi momento.<br>Al termine dell'offerta, solo 4,99€ al mese.</p>
				<a href="#" class="btn btn-primary rounded-pill" role="button">PROVA GRATUITAMENTE</a>
			</div>
		</div>
</section>

<!---------------------------------------------------------------
 CONTENUTO
 !--------------------------------------------------------------->
<section class="container">
	<div class="row">
		<!-- Menu -->
		<div class="sidebar col-md-12 col-lg-3">
			<div class="row hide-brand-collapse" style="padding-top:10px">
				<div class="col-10 offset-1">
					<img src="img/brand/brand_white.svg" height="60" class="d-inline-block align-top" alt="vinyl-brand">
				</div>
			</div>
			<div class="row" style="padding:10px 0;">
				<div class="col-10 offset-1" style="padding: 0;">
					<div class="sidebar-button hide-sidebar-button" role="tablist" data-toggle="collapse" data-target="#side-menu-collapse" aria-expanded="false">
						<img src="img/icons/menu.svg" class="d-inline-block align-top" alt="menu-icon" style="margin-right: 5px;" height="24">
					</div>
					<div class="collapse sidebar-collapse list-group" id="side-menu-collapse">
						<a class="nav-link dark-link list-group-item active" id="tab-elem0" data-toggle="tab" role="tab" aria-controls="elem0" aria-selected="true" href="#elem0">Riepilogo</a>
						<a class="nav-link dark-link list-group-item" id="tab-elem1" data-toggle="tab" role="tab" aria-controls="elem1" aria-selected="false" href="#elem1">Profilo</a>
						<a class="nav-link dark-link list-group-item" id="tab-elem2" data-toggle="tab" role="tab" aria-controls="elem2" aria-selected="false" href="#elem2">Modifica password</a>
						<a class="nav-link dark-link list-group-item" id="tab-elem3" data-toggle="tab" role="tab" aria-controls="elem3" aria-selected="false" href="#elem3">Modifica email</a>
						<a class="nav-link dark-link list-group-item" id="tab-elem4" data-toggle="tab" role="tab" aria-controls="elem4" aria-selected="false" href="#elem4">Premium</a>
					</div>
				</div>
			</div>
		</div>
		<!-- Pannelli Tab -->
		<div class="contentbar col-md-12 col-lg-9">
			<div class="tab-content" id="v-pills-tabContent">
				<div class="tab-pane fade show active" id="elem0" role="tabpanel" aria-labelledby="tab-0">
					<div class="tab-padding">
						<h2 class="text-subtitle"> Riepilogo </h2>
						<hr>
						<div class="jumbotron border">
							<img src="img/brand/brand_black_vinyl.svg" width="225" height="60" class="d-inline-block align-top" alt="vinyl-brand">
							<hr class="my-4">
							<p class="lead">Vinyl è un servizio musicale che offre lo streaming on demand di una vasta gamma di brani da tutto il mondo, La musica può essere visualizzata per artista, album, etichetta, genere o playlist. Entra nella nostra community!</p>
							<hr class="my-4">
							<p>Gli utenti che hanno sottoscritto il servizio Premium o Unlimited o hanno già ricevuto un periodo di prova gratuito non possono accedere alla prova gratuita di 30 giorni.</p>
							<p style="color: #919496;margin:10px;">*Offerta per la prova gratuita di 30 giorni di Vinyl® Si applicano<br><a href="#">Termini e condizioni</a>.</p>
							<a class="btn btn-secondary btn-lg rounded-pill" href="#" role="button">SCOPRI DI PIÙ</a>
						</div>
					</div>
				</div>
				<div class="tab-pane fade" id="elem1" role="tabpanel" aria-labelledby="tab-1">
					<div class="tab-padding">
						<h2 class="text-subtitle"> Profilo </h2>
						<hr>
						<div class="jumbotron border text-left">
							<h3 class="text-medium"> Profilo </h3>
							<hr class="my-4">
							<p class="lead text-gray">Nome Utente</p>
							<p>${user.username}</p>
							<p class="lead text-gray">Indirizzo Email</p>
							<p>${user.email}</p>
							<hr class="my-4">
							<a class="btn btn-secondary rounded-pill" href="#" role="button">MODIFICA EMAIL</a>
						</div>
					</div>
				</div>
				<div class="tab-pane fade" id="elem2" role="tabpanel" aria-labelledby="tab-2">
					<div class="tab-padding">
						<h2 class="text-subtitle"> Modifica password </h2>
						<hr>
						<form method="post" action="ModificaPassword" class="container jumbotron border text-left">
							<p class="lead text-gray">Verifica password attuale</p>
							<!-- FORM-GROUP -->
							<div class="form-group"><input name="passwordPrecedente" type="password" class="form-control" placeholder="Password Precedente"></div>
							<div class="form-group"><input name="confermaPasswordPrecedente" type="password" class="form-control" placeholder="Conferma Password Precedente"></div>
							<hr>
							<p class="lead text-gray">Inserisci la tua nuova password</p>
							<div class="form-group"><input name="nuovaPassword" type="password" class="form-control" placeholder="Nuova Password"></div>
							<!-- -->
							<button name="inviaIscrizione" type="submit" class="btn btn-success rounded-pill">AGGIORNA</button>
							<hr>
							<p class="text-small"><span style="color: #919496">Se desideri ulteriori informazioni su come Vinyl raccoglie, elabora, condivide e protegge i tuoi dati personali, leggi l'Informativa sulla privacy di Vinyl.<br><a href="#">Maggiori informazioni</a>.</span></p>
						</form>
					</div>
				</div>
				<div class="tab-pane fade" id="elem3" role="tabpanel" aria-labelledby="tab-3">
					<div class="tab-padding">
						<h2 class="text-subtitle"> Modifica email </h2>
						<hr>
						<form method="post" action="ModificaEmail" class="container jumbotron border text-left">
							<!-- FORM-GROUP -->
							<p class="lead text-gray">Indirizzo Email</p>
							<p>${user.email}</p>
							<hr>
							<p class="lead text-gray">Inserisci la tua nuova email</p>
							<div class="form-group"><input name="nuovaEmail" type="text" class="form-control" placeholder="Nuova Email"></div>
							<!-- -->
							<button name="inviaIscrizione" type="submit" class="btn btn-success rounded-pill">AGGIORNA</button>
							<hr>
							<p class="text-small"><span style="color: #919496">Se desideri ulteriori informazioni su come Vinyl raccoglie, elabora, condivide e protegge i tuoi dati personali, leggi l'Informativa sulla privacy di Vinyl.<br><a href="#">Maggiori informazioni</a>.</span></p>
						</form>
					</div>
				</div>
				<div class="tab-pane fade" id="elem4" role="tabpanel" aria-labelledby="tab-4">
					<div class="tab-padding">
						<h2 class="text-subtitle"> Premium </h2>
						<hr>
						<div class="jumbotron border">
							<h3 class="text-subtitle">Vinyl PREMIUM<br><span style="font-family: Helvetica;">€ 4,99</span><span class="text-small">/MESE</span></h3>
							<p class="text-note">*Inizia la tua prova gratis di 30 giorni</p>
							<hr class="my-4">
							<ul class="lead" style="text-align: left;">
								<li class="check-item">Ascolta qualsiasi brano</li>
								<li class="check-item">Ascolta offline</li>
								<li class="check-item">Niente pubblicità </li>
								<li class="check-item">Skip illimitati</li>
								<li class="check-item">Audio di qualità  elevata</li>
							</ul>
							<hr class="my-4">
							<a href="#" class="btn btn-primary btn-lg btn-block rounded-pill" role="button">PROVA GRATUITAMENTE</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
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
					Visita la mia <a href="https://github.com/cuista" target="_blank"> Pagina GitHub</a> <br> per visionare altri miei progetti
				</p>
			</div>
		</div>
</section>















<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<c:if test="${empty user.username}"><script>$("html").load("ritornaHome.html");</script></c:if>
<c:if test="${not empty user.username}">
<script type="text/javascript" src="js/jumbotronAnimation.js"></script>
</c:if>


</body>
</html>