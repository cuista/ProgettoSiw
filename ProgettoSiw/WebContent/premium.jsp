<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Premium</title>
	<link rel="stylesheet" href="css/bootstrap.min.css"></link>
	<link rel="stylesheet" href="css/style.css"></link>
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
			<a class="nav-link active" href="premium.jsp">Premium</a>
		  </li>
		  <li class="nav-item" style="margin-right: 30px;">
			<a class="nav-link" href="terminiECondizioni.jsp">Termini e condizioni</a>
		  </li>
			<!-- PLAYER SE USER LOGGATO -->
			<c:if test="${not empty user.username}">
				<!-- SE UTENTE PREMIUM -->
				<c:if test="${user.premium}">
					<li class="nav-item">
					<a class="nav-link active" href="player.jsp">Player Web<span class="sr-only">(current)</span></a>
				  	</li>
				</c:if>
				<!-- SE UTENTE NON PREMIUM -->
				<c:if test="${!user.premium}">
					<li class="nav-item">
					<a class="nav-link active" href="playerNonPremium.jsp">Player Web<span class="sr-only">(current)</span></a>
				  	</li>
				</c:if>
			</c:if>
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
			  		<a class="dropdown-item" href="gestioneUtente.jsp">Account</a>
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
			<!-- SE UTENTE NON PREMIUM -->
			<c:if test="${!user.premium}">
			<div class="col-sm-5 offset-sm-7">
				<h3>Passa alla versione Premium,<br> il primo mese è gratis!</h3>
				<p>Puoi annullare l'abbonamento in qualsiasi momento.<br>Al termine dell'offerta, solo 4,99€ al mese.</p>
				<button type="button" class="btn btn-primary btn-lg btn-block rounded-pill" data-toggle="modal" data-target="#modalPagamento">PASSA A PREMIUM</button>
			</div>
			</c:if>
		</div>
</section>

<!---------------------------------------------------------------
 CONTENUTO
 !--------------------------------------------------------------->
<section class="container content">

	<!-- SE UTENTE NON PREMIUM -->
	<c:if test="${!user.premium}">
	<h2 class="text-title">Perchè passare a Vinyl Premium?</h2>

	<div class="row">
		<div class="col-sm-10 offset-sm-1">
			<div class="jumbotron border">
	  			<h3 class="text-subtitle">Vinyl PREMIUM<br><span style="font-family: Helvetica;">€ 4,99</span><span class="text-small">/MESE</span></h3>
	  			<p class="text-note">*Inizia la tua prova gratis di 30 giorni</p>
	  			<hr class="my-4">
	  			<ul class="lead" style="text-align: left;">
	  				<li class="check-item">Ascolta qualsiasi brano</li>
	  				<li class="check-item">Ascolta offline</li>
	  				<li class="check-item">Niente pubblicità</li>
	  				<li class="check-item">Skip illimitati</li>
	  				<li class="check-item">Audio di qualità elevata</li>
	  			</ul>
	  			<hr class="my-4">
	  			<button type="button" class="btn btn-primary btn-lg btn-block rounded-pill" data-toggle="modal" data-target="#modalPagamento">PASSA A PREMIUM</button>
	  		</div>
  		</div>
	</div>
	</c:if>
	
	<!-- SE UTENTE PREMIUM -->
	<c:if test="${user.premium}">
	<h2 class="text-title">Complimenti! Sei già utente Premium.</h2>

	<div class="row">
		<div class="col-sm-10 offset-sm-1">
			<div class="jumbotron border">
	  			<h3 class="text-subtitle">Vinyl PREMIUM<br>Ecco i vantaggi a tua disposizione!</h3>
	  			<hr class="my-4">
	  			<ul class="lead" style="text-align: left;">
	  				<li class="check-item">Ascolta qualsiasi brano</li>
	  				<li class="check-item">Ascolta offline</li>
	  				<li class="check-item">Niente pubblicità</li>
	  				<li class="check-item">Skip illimitati</li>
	  				<li class="check-item">Audio di qualità elevata</li>
	  			</ul>
	  		</div>
  		</div>
	</div>
	</c:if>
	
	
	<div class="row">
		<div class="col-sm-10 offset-sm-1">
			<div class="jumbotron border">
	  			<img src="img/brand/brand_black_vinyl.svg" width="225" height="60" class="d-inline-block align-top" alt="vinyl-brand">
	  			<hr class="my-4">
	  			<p class="lead">Vinyl è un servizio musicale che offre lo streaming on demand di una vasta gamma di brani da tutto il mondo, La musica può essere visualizzata per artista, album, etichetta, genere o playlist. Entra nella nostra community!</p>
	  			<hr class="my-4">
	  			<p>Gli utenti che hanno sottoscritto il servizio Premium o Unlimited o hanno già ricevuto un periodo di prova gratuito non possono accedere alla prova gratuita di 30 giorni.</p>
	  			<p style="color: #919496;margin:10px;">*Offerta per la prova gratuita di 30 giorni di Vinyl® Si applicano <a href="TerminiECondizioni.jsp">Termini e condizioni</a>.</p>
	  			<a class="btn btn-secondary btn-lg rounded-pill" href="TerminiECondizioni.jsp" role="button">SCOPRI DI PIÙ</a>
	  		</div>
		</div>
	</div>
	
</section>

<!---------------------------------------------------------------
 MODAL DATI CARTA DI CREDITO
 !--------------------------------------------------------------->
<!-- SE UTENTE NON PREMIUM -->
<c:if test="${!user.premium}">
<div class="modal fade" id="modalPagamento" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="modalLabel">Dettagli Pagamento</h5>
				<img class="img-responsive pull-right" src="http://i76.imgup.net/accepted_c22e0.png">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<div class="container">
					<form role="form" id="payment-form" method="POST" action="javascript:void(0);">
						<div class="form-row">
							<div class="col-12">
								<div class="form-group">
									<label for="cardNumber">Numero Carta di Credito</label>
									<div class="input-group">
										<input type="tel" class="form-control" name="cardNumber" placeholder="Numero di Carta Valido" autocomplete="cc-number" required autofocus />
										<img style="content: url(img/icons/credit-card.svg); height: 38px;">
									</div>
								</div>
							</div>
						</div>
						<div class="form-row">
							<div class="col-xs-7 col-md-7">
								<div class="form-group">
									<label for="cardExpiry">Data di Scadenza</label> 
									<input type="tel" class="form-control" name="cardExpiry" placeholder="MM / AA" autocomplete="cc-exp" required />
								</div>
							</div>
							<div class="col-xs-5 col-md-5 pull-right">
								<div class="form-group">
									<label for="cardCVC">Codice CVC/CVV</label> 
									<input type="tel" class="form-control" name="cardCVC" placeholder="CVC/CVV" autocomplete="cc-csc" required />
								</div>
							</div>
						</div>
						<div class="form-row">
							<div class="col-xs-12">
								<div class="form-group">
									<label for="couponCode">Nome Titolare Carta</label> 
									<input type="text" class="form-control" name="couponCode" placeholder="Nome" />
								</div>
								<div class="form-group">
									<label for="couponCode">Cognome Titolare Carta</label> 
									<input type="text" class="form-control" name="couponCode" placeholder="Cognome" />
								</div>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="subscribe btn btn-success">Iscriviti a Premium</button>
						</div>
						<div class="form-row" style="display: none;">
							<div class="col-xs-12">
								<p class="payment-errors">ERRORE: </p>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
</c:if>

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
<script type="text/javascript" src="js/jumbotronAnimation.js"></script>

<!-- CARTA DI CREDITO -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.13.1/jquery.validate.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.payment/1.2.3/jquery.payment.min.js"></script>
<script type="text/javascript" src="https://js.stripe.com/v2/"></script>
<script type="text/javascript" src="js/cartaDiCredito.js"></script>

</body>
</html>