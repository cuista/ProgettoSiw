<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Vinyl</title>
	<link rel="stylesheet" href="css/bootstrap.min.css"></link>
	<link rel="stylesheet" href="css/style.css"></link>
	<link rel="stylesheet" href="css/player.css"></link>
	<!-- ADATTAMENTO MOBILE -->
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
<body>

<!---------------------------------------------------------------
 CONTENUTO
 !--------------------------------------------------------------->
<section class="container-fluid container-full">
	<div class="row no-padding">
		<!-- Menu -->
		<div class="sidebar no-padding col-md-12 col-lg-2">
			<div class="row hide-brand-collapse padding-top">
				<div class="col-10 offset-1">
					<img src="img/brand/brand_white_vinyl.svg" height="40" class="d-inline-block align-top" alt="vinyl-brand">
				</div>
			</div>
			<div class="row padding-top">
				<div class="col-10 offset-1 no-padding">
					<div class="sidebar-button hide-sidebar-button" role="tablist" data-toggle="collapse" data-target="#side-menu-collapse" aria-expanded="false">
						<img src="img/icons/menu.svg" class="d-inline-block align-top" alt="menu-icon" style="margin-right: 5px;" height="24">
					</div>
					<div class="collapse sidebar-collapse list-group" id="side-menu-collapse">
						<a class="nav-link dark-link list-group-item active" id="tab-elem0" data-toggle="tab" role="tab" aria-controls="elem0" aria-selected="true" href="#elem0">
							<img src="img/icons/home.svg" class="d-inline-block align-top" alt="home-icon" style="margin-right: 5px;" height="24">Home
						</a>
						<a class="nav-link dark-link list-group-item" id="tab-elem1" data-toggle="tab" role="tab" aria-controls="elem1" aria-selected="false" href="#elem1">
							<img src="img/icons/playlist.svg" class="d-inline-block align-top" alt="playlist-icon" style="margin-right: 5px;" height="24">Playlist
						</a>
						<a class="nav-link dark-link list-group-item" id="tab-elem2" data-toggle="tab" role="tab" aria-controls="elem2" aria-selected="false" href="#elem2">
							<img src="img/icons/search.svg" class="d-inline-block align-top" alt="search-icon" style="margin-right: 5px;" height="24">Cerca
						</a>
						<a class="nav-link dark-link list-group-item" id="tab-elem3" data-toggle="tab" role="tab" aria-controls="elem3" aria-selected="false" href="#elem3">
							<img src="img/icons/playlist-file.svg" class="d-inline-block align-top" alt="playlist-icon" style="margin-right: 5px;" height="24">Crea Playlist
						</a>
						<a class="nav-link dark-link list-group-item" id="tab-elem4" data-toggle="tab" role="tab" aria-controls="elem4" aria-selected="false" href="#elem4">Privacy Policy</a>
					</div>
					<hr style="background-color:gray;">
					<a class="nav-link dark-link list-group-item" href="index.jsp">
						<img src="img/icons/back-arrow.svg" class="d-inline-block align-top" alt="search-icon" style="margin-right: 5px;" height="24">Torna al sito
					</a>
				</div>
			</div>
		</div>
		<!-- Pannelli Tab -->
		<div class="contentbar col-md-12 offset-lg-2 col-lg-10">
			<div class="tab-content" id="v-pills-tabContent">
				<div class="tab-pane fade show active" id="elem0" role="tabpanel" aria-labelledby="tab-0">
					<div class="tab-padding">
					
						<h2 class="text-subtitle text-white" style="text-align: center;"> FUNZIONALITÀ BLOCCATE! </h2>
						<hr style="background-color: #fff;">
						<div class="row">
							<div class="col-lg-6 offset-lg-3">
								<div class="jumbotron border">
									<h3 class="text-message text">Per gli utenti NON Premium non è possibilè utilizzare tutte le funzioni del player.</h3>
									<p> Ascolta brani casuali dal player, attenzione gli skip sono limitati.</p>
									<hr class="my-4">
									<a href="premium.jsp" class="btn btn-success btn-lg btn-block rounded-pill" role="button">PASSA A PREMIUM</a>
								</div>
							</div>
						</div>
						
					</div>
				</div>
				<div class="tab-pane fade" id="elem1" role="tabpanel" aria-labelledby="tab-1">
					<div class="tab-padding">
					
						<h2 class="text-subtitle text-white" style="text-align: center;"> FUNZIONALITÀ BLOCCATE! </h2>
						<hr style="background-color: #fff;">
						<div class="row">
							<div class="col-lg-6 offset-lg-3">
								<div class="jumbotron border">
									<h3 class="text-message text">Per gli utenti NON Premium non è possibilè utilizzare tutte le funzioni del player.</h3>
									<p> Ascolta brani casuali dal player, attenzione gli skip sono limitati.</p>
									<hr class="my-4">
									<a href="premium.jsp" class="btn btn-success btn-lg btn-block rounded-pill" role="button">PASSA A PREMIUM</a>
								</div>
							</div>
						</div>
						
					</div>
				</div>
				<div class="tab-pane fade" id="elem2" role="tabpanel" aria-labelledby="tab-2">
					<div class="tab-padding">
					
						<h2 class="text-subtitle text-white" style="text-align: center;"> FUNZIONALITÀ BLOCCATE! </h2>
						<hr style="background-color: #fff;">
						<div class="row">
							<div class="col-lg-6 offset-lg-3">
								<div class="jumbotron border">
									<h3 class="text-message text">Per gli utenti NON Premium non è possibilè utilizzare tutte le funzioni del player.</h3>
									<p> Ascolta brani casuali dal player, attenzione gli skip sono limitati.</p>
									<hr class="my-4">
									<a href="premium.jsp" class="btn btn-success btn-lg btn-block rounded-pill" role="button">PASSA A PREMIUM</a>
								</div>
							</div>
						</div>
						
					</div>
				</div>
				<div class="tab-pane fade" id="elem3" role="tabpanel" aria-labelledby="tab-3">
					<div class="tab-padding">
					
						<h2 class="text-subtitle text-white" style="text-align: center;"> FUNZIONALITÀ BLOCCATE! </h2>
						<hr style="background-color: #fff;">
						<div class="row">
							<div class="col-lg-6 offset-lg-3">
								<div class="jumbotron border">
									<h3 class="text-message text">Per gli utenti NON Premium non è possibilè utilizzare tutte le funzioni del player.</h3>
									<p> Ascolta brani casuali dal player, attenzione gli skip sono limitati.</p>
									<hr class="my-4">
									<a href="premium.jsp" class="btn btn-success btn-lg btn-block rounded-pill" role="button">PASSA A PREMIUM</a>
								</div>
							</div>
						</div>
						
					</div>
				</div>
				<div class="tab-pane fade" id="elem4" role="tabpanel" aria-labelledby="tab-4">
					<div class="tab-padding">
						<h2 class="text-subtitle text-white"> Privacy Policy </h2>
						<hr style="background-color: #fff;">
						<div class="row">
							<div class="col-lg-6 offset-lg-3">
								<div class="jumbotron border">
										<div class="iub_content simple_pp"><div class="iub_header"><h1>Privacy Policy di <strong>Vinyl</strong></h1><p>
        								Questa Applicazione raccoglie alcuni Dati Personali dei propri Utenti.
      									</p></div><h2 id="purposes_data">Dati personali raccolti per le seguenti finalità ed utilizzando i seguenti servizi:</h2>
      									<ul class="for_boxes cf"><li class="one_line_col">
        								<div class="iconed policyicon_purpose_9"><h3>Registrazione ed autenticazione</h3>
                      					<h3>Facebook Authentication</h3>
                        				<p>Dati Personali: varie tipologie di Dati secondo quanto specificato dalla privacy policy del servizio</p>
                    					</div>
      									</li></ul><h2 id="contact_information">Informazioni di contatto</h2>
	   					 				<ul class="for_boxes">
        								<li>
          								<div class="iconed icon_owner">
            							<h3>Titolare del Trattamento dei Dati</h3>
                						<p>Vinyl Corp</p>
                						<p><b>Indirizzo email del Titolare:</b> vinyl-1251512-support@vinyl-staff.it</p>
          								</div></li></ul>
 										</div>
									<hr class="my-4">
									<a class="btn btn-secondary btn-lg rounded-pill" href="terminiECondizioni.jsp" role="button">SCOPRI DI PIÙ</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
</section>

<!---------------------------------------------------------------
 MUSIC PLAYER
 !--------------------------------------------------------------->
<section class="player-container">
	<audio autoplay src=""></audio>
	<div class="player">
		<img class="artwork" src="img/brand/brand_white.svg" alt="...">
		<div class="info">
			<div class="name"> Sto caricando.. </div>
			<div class="singer"> </div>
		</div>
		<div class="buttons">
			<div class="previous icon-previous" onmouseover="" style="cursor: pointer;"></div>
			<div class="play-pause icon-stop" onmouseover="" style="cursor: pointer;"></div>
			<div class="next icon-next" onmouseover="" style="cursor: pointer;"></div>
			<p style="padding-left: 15px;padding-top: 15px"> Skip: <p><p class="skip" style="padding-top: 15px"> 10</p>
		</div>
		<div class="progress">
		
		</div>
	</div>
</section> 















<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<c:if test="${empty user.username}"><script>$("html").load("ritornaHome.html");</script></c:if>
<c:if test="${not empty user.username}">
<script type="text/javascript" src="js/eventiPlayerNonPremium.js"></script>
</c:if>

</body>
</html>