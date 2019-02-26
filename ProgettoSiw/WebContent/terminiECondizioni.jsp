<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Termini e Condizioni</title>
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
			<a class="nav-link" href="premium.jsp">Premium</a>
		  </li>
		  <li class="nav-item active" style="margin-right: 30px;">
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
		  <!-- IF USER NON LOGGATO -->
		  <c:if test="${empty user.username}">
		  	<li class="nav-item">
				<a class="nav-link" href="iscrizione.jsp">Iscriviti</a>
		  	</li>
		  	<li class="nav-item">
				<a class="nav-link" href="login.jsp">Accedi</a>
		  	</li>
		  </c:if>
		  <!-- ENDIF -->
		  <!-- IF USER LOGGATO -->
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
 ACCESSO NON CONSENTITO
 !--------------------------------------------------------------->
<section class="login-iscrizione">
	<div class="container jumbotron border">
		<img src="img/brand/brand_black_vinyl.svg" width="225" height="60" class="d-inline-block align-top" alt="vinyl-brand">
		<h3> Termini e Condizioni </h3>
		<hr>
		<div id="wbars">
	      <div class="iub_content legal_pp">


          
<div class="iub_header">

    <h1>Privacy Policy di <strong>Vinyl</strong></h1>

      <p>Questa Applicazione raccoglie alcuni Dati Personali dei propri Utenti.</p>
</div> <!-- /header -->

          
<div class="one_line_col">

  <h2 id="owner_of_the_data">Titolare del Trattamento dei Dati</h2>

      <img src="img/brand/brand_black_vinyl.svg" width="120" height="40" class="d-inline-block align-top" alt="vinyl-brand">
      <p><b>Indirizzo email del Titolare:</b> vinyl-1251512-support@vinyl-staff.it</p>

</div> <!-- /one_line_col -->


<div class="one_line_col">

  <h2 id="types_of_data">Tipologie di Dati raccolti</h2>

     <p>Il Titolare non fornisce una lista di tipologie di Dati Personali raccolti.</p>
   

  <p>Dettagli completi su ciascuna tipologia di dati raccolti sono forniti nelle sezioni dedicate di questa privacy policy o mediante specifici testi informativi visualizzati prima della raccolta dei dati stessi.<br>
I Dati Personali possono essere liberamente forniti dall'Utente o, nel caso di Dati di Utilizzo, raccolti automaticamente durante l'uso di questa Applicazione.<br>
Se non diversamente specificato, tutti i Dati richiesti da questa Applicazione sono obbligatori. Se l’Utente rifiuta di comunicarli, potrebbe essere impossibile per questa Applicazione fornire il Servizio. Nei casi in cui questa Applicazione indichi alcuni Dati come facoltativi, gli Utenti sono liberi di astenersi dal comunicare tali Dati, senza che ciò abbia alcuna conseguenza sulla disponibilità del Servizio o sulla sua operatività.<br> 
Gli Utenti che dovessero avere dubbi su quali Dati siano obbligatori, sono incoraggiati a contattare il Titolare.<br>
L’eventuale utilizzo di Cookie - o di altri strumenti di tracciamento - da parte di questa Applicazione o dei titolari dei servizi terzi utilizzati da questa Applicazione, ove non diversamente precisato, ha la finalità di fornire il Servizio richiesto dall'Utente, oltre alle ulteriori finalità descritte nel presente documento e nella Cookie Policy, se disponibile.</p>
  <p>L'Utente si assume la responsabilità dei Dati Personali di terzi ottenuti, pubblicati o condivisi mediante questa Applicazione e garantisce di avere il diritto di comunicarli o diffonderli, liberando il Titolare da qualsiasi responsabilità verso terzi.</p>

</div> <!-- /one_line_col -->


<div class="one_line_col">

  <h2 id="place_of_processing">Modalità e luogo del trattamento dei Dati raccolti</h2>

  <h3>Modalità di trattamento</h3>

  <p>Il Titolare adotta le opportune misure di sicurezza volte ad impedire l’accesso, la divulgazione, la modifica o la distruzione non autorizzate dei Dati Personali. <br>
Il trattamento viene effettuato mediante strumenti informatici e/o telematici, con modalità organizzative e con logiche strettamente correlate alle finalità indicate. Oltre al Titolare, in alcuni casi, potrebbero avere accesso ai Dati altri soggetti coinvolti nell’organizzazione di questa Applicazione (personale amministrativo, commerciale, marketing, legali, amministratori di sistema) ovvero soggetti esterni (come fornitori di servizi tecnici terzi, corrieri postali, hosting provider, società informatiche, agenzie di comunicazione) nominati anche, se necessario, Responsabili del Trattamento da parte del Titolare. L’elenco aggiornato dei Responsabili potrà sempre essere richiesto al Titolare del Trattamento.</p>

  <h3>Base giuridica del trattamento</h3>

  <p>Il Titolare tratta Dati Personali relativi all’Utente in caso sussista una delle seguenti condizioni:</p>
  <ul>
    <li>l’Utente ha prestato il consenso per una o più finalità specifiche; Nota: in alcuni ordinamenti il Titolare può essere autorizzato a trattare Dati Personali senza che debba sussistere il consenso dell’Utente o un’altra delle basi giuridiche specificate di seguito, fino a quando l’Utente non si opponga (“opt-out”) a tale trattamento. Ciò non è tuttavia applicabile qualora il trattamento di Dati Personali sia regolato dalla legislazione europea in materia di protezione dei Dati Personali;</li>
    <li>il trattamento è necessario all'esecuzione di un contratto con l’Utente e/o all'esecuzione di misure precontrattuali;</li>
    <li>il trattamento è necessario per adempiere un obbligo legale al quale è soggetto il Titolare;</li>
    <li>il trattamento è necessario per l'esecuzione di un compito di interesse pubblico o per l'esercizio di pubblici poteri di cui è investito il Titolare;</li>
    <li>il trattamento è necessario per il perseguimento del legittimo interesse del Titolare o di terzi.</li>
  </ul>
  <p>È comunque sempre possibile richiedere al Titolare di chiarire la concreta base giuridica di ciascun trattamento ed in particolare di specificare se il trattamento sia basato sulla legge, previsto da un contratto o necessario per concludere un contratto.</p>

  <h3>Luogo</h3>

  <p>I Dati sono trattati presso le sedi operative del Titolare ed in ogni altro luogo in cui le parti coinvolte nel trattamento siano localizzate. Per ulteriori informazioni, contatta il Titolare.<br>
I Dati Personali dell’Utente potrebbero essere trasferiti in un paese diverso da quello in cui l’Utente si trova. Per ottenere ulteriori informazioni sul luogo del trattamento l’Utente può fare riferimento alla sezione relativa ai dettagli sul trattamento dei Dati Personali.</p>
  <p>L’Utente ha diritto a ottenere informazioni in merito alla base giuridica del trasferimento di Dati al di fuori dell’Unione Europea o ad un’organizzazione internazionale di diritto internazionale pubblico o costituita da due o più paesi, come ad esempio l’ONU, nonché in merito alle misure di sicurezza adottate dal Titolare per proteggere i Dati.<br><br>
L’Utente può verificare se abbia luogo uno dei trasferimenti appena descritti esaminando la sezione di questo documento relativa ai dettagli sul trattamento di Dati Personali o chiedere informazioni al Titolare contattandolo agli estremi riportati in apertura.</p>

  <h3>Periodo di conservazione</h3>

  <p>I Dati sono trattati e conservati per il tempo richiesto dalle finalità per le quali sono stati raccolti.</p>
  <p>Pertanto:</p>
  <ul>
    <li>I Dati Personali raccolti per scopi collegati all’esecuzione di un contratto tra il Titolare e l’Utente saranno trattenuti sino a quando sia completata l’esecuzione di tale contratto.</li>
    <li>I Dati Personali raccolti per finalità riconducibili all’interesse legittimo del Titolare saranno trattenuti sino al soddisfacimento di tale interesse. L’Utente può ottenere ulteriori informazioni in merito all’interesse legittimo perseguito dal Titolare nelle relative sezioni di questo documento o contattando il Titolare.</li>
  </ul>
  <p>Quando il trattamento è basato sul consenso dell’Utente, il Titolare può conservare i Dati Personali più a lungo sino a quando detto consenso non venga revocato. Inoltre, il Titolare potrebbe essere obbligato a conservare i Dati Personali per un periodo più lungo in ottemperanza ad un obbligo di legge o per ordine di un’autorità.<br><br>
Al termine del periodo di conservazione i Dati Personali saranno cancellati. Pertanto, allo spirare di tale termine il diritto di accesso, cancellazione, rettificazione ed il diritto alla portabilità dei Dati non potranno più essere esercitati.</p>

</div> <!-- /one_line_col -->



  <div class="one_line_col">

    <h2 id="use_collected_data">Finalità del Trattamento dei Dati raccolti</h2>

      <p>
      I Dati dell’Utente sono raccolti per consentire al Titolare di fornire i propri Servizi, così come per le seguenti finalità:
         Registrazione ed autenticazione.
      </p>
     

    <p>Per ottenere ulteriori informazioni dettagliate sulle finalità del trattamento e sui Dati Personali concretamente rilevanti per ciascuna finalità, l’Utente può fare riferimento alle relative sezioni di questo documento.</p>


  </div> <!-- /one_line_col -->
 







    <div class="one_line_col">

      <h2 id="data_processing_detailed_info">Dettagli sul trattamento dei Dati Personali</h2>
      <p>I Dati Personali sono raccolti per le seguenti finalità ed utilizzando i seguenti servizi:</p>

      <ul class="for_boxes">


           <li>
            <div class="box_primary box_10 expand collapsed">
               <h3 class="expand-click w_icon_24 policyicon_purpose_5965090">Registrazione ed autenticazione</h3>
               <div class="expand-content" style="display: none;">

                   <p>Con la registrazione o l’autenticazione l’Utente consente all’Applicazione di identificarlo e di dargli accesso a servizi dedicati.<br>
A seconda di quanto indicato di seguito, i servizi di registrazione e di autenticazione potrebbero essere forniti con l’ausilio di terze parti. Qualora questo avvenga, questa applicazione potrà accedere ad alcuni Dati conservati dal servizio terzo usato per la registrazione o l’identificazione.</p>


                   <h4>Facebook Authentication (Facebook, Inc.)</h4>

                   <div class="wrap">
                     <p>Facebook Authentication è un servizio di registrazione ed autenticazione fornito da Facebook, Inc. e collegato al social network Facebook.</p>
                   </div>


                       <p>
                         Dati Personali raccolti:
                         varie tipologie di Dati secondo quanto specificato dalla privacy policy del servizio.
                       </p>

                   
<p>
Luogo del trattamento:
Stati Uniti
–
<a href="https://www.facebook.com/help/405977429438260" target="_blank" rel="noopener noreferrer">Privacy Policy</a>.
Soggetto aderente al Privacy Shield.
</p>


                  

               </div> <!-- /expand-content -->
             </div> <!-- /expand -->
           </li>

         

      </ul>

    </div> <!-- /one_line_col -->

   

 



 

<div class="one_line_col">

  <h2>Diritti dell’Utente</h2>

  <p>Gli Utenti possono esercitare determinati diritti con riferimento ai Dati trattati dal Titolare.</p>
  <p>In particolare, l’Utente ha il diritto di:</p>

  <ul>
    <li><b>revocare il consenso in ogni momento.</b> L’Utente può revocare il consenso al trattamento dei propri Dati Personali precedentemente espresso. </li>
    <li><b>opporsi al trattamento dei propri Dati.</b> L’Utente può opporsi al trattamento dei propri Dati quando esso avviene su una base giuridica diversa dal consenso. Ulteriori dettagli sul diritto di opposizione sono indicati nella sezione sottostante.</li>
    <li><b>accedere ai propri Dati.</b> L’Utente ha diritto ad ottenere informazioni sui Dati trattati dal Titolare, su determinati aspetti del trattamento ed a ricevere una copia dei Dati trattati.</li>
    <li><b>verificare e chiedere la rettificazione.</b> L’Utente può verificare la correttezza dei propri Dati e richiederne l’aggiornamento o la correzione. </li>
    <li><b>ottenere la limitazione del trattamento.</b> Quando ricorrono determinate condizioni, l’Utente può richiedere la limitazione del trattamento dei propri Dati. In tal caso il Titolare non tratterà i Dati per alcun altro scopo se non la loro conservazione.</li>
    <li><b>ottenere la cancellazione o rimozione dei propri Dati Personali.</b> Quando ricorrono determinate condizioni, l’Utente può richiedere la cancellazione dei propri Dati da parte del Titolare.</li>
    <li><b>ricevere i propri Dati o farli trasferire ad altro titolare.</b> L’Utente ha diritto di ricevere i propri Dati in formato strutturato, di uso comune e leggibile da dispositivo automatico e, ove tecnicamente fattibile, di ottenerne il trasferimento senza ostacoli ad un altro titolare. Questa disposizione è applicabile quando i Dati sono trattati con strumenti automatizzati ed il trattamento è basato sul consenso dell’Utente, su un contratto di cui l’Utente è parte o su misure contrattuali ad esso connesse.</li>
    <li><b>proporre reclamo.</b> L’Utente può proporre un reclamo all’autorità di controllo della protezione dei dati personali competente o agire in sede giudiziale.</li>
  </ul>

  <h3>Dettagli sul diritto di opposizione</h3>
  <p>Quando i Dati Personali sono trattati nell’interesse pubblico, nell’esercizio di pubblici poteri di cui è investito il Titolare oppure per perseguire un interesse legittimo del Titolare, gli Utenti hanno diritto ad opporsi al trattamento per motivi connessi alla loro situazione particolare.</p>
  <p>Si fa presente agli Utenti che, ove i loro Dati fossero trattati con finalità di marketing diretto, possono opporsi al trattamento senza fornire alcuna motivazione. Per scoprire se il Titolare tratti dati con finalità di marketing diretto gli Utenti possono fare riferimento alle rispettive sezioni di questo documento.</p>

  <h3>Come esercitare i diritti</h3>
  <p>Per esercitare i diritti dell’Utente, gli Utenti possono indirizzare una richiesta agli estremi di contatto del Titolare indicati in questo documento. Le richieste sono depositate a titolo gratuito e evase dal Titolare nel più breve tempo possibile, in ogni caso entro un mese.</p>

</div> <!-- /one_line_col -->


    

<div class="one_line_col">

  <h2 id="further_data_processing_info">Ulteriori informazioni sul trattamento</h2>

  <h3>Difesa in giudizio</h3>
  <p>
    I Dati Personali dell’Utente possono essere utilizzati da parte del Titolare in giudizio o nelle fasi preparatorie alla sua eventuale instaurazione per la difesa da abusi nell'utilizzo di questa Applicazione o dei Servizi connessi da parte dell’Utente.<br>
L’Utente dichiara di essere consapevole che il Titolare potrebbe essere obbligato a rivelare i Dati per ordine delle autorità pubbliche.
  </p>

  <h3>Informative specifiche</h3>
  <p>
    Su richiesta dell’Utente, in aggiunta alle informazioni contenute in questa privacy policy, questa Applicazione potrebbe fornire all'Utente delle informative aggiuntive e contestuali riguardanti Servizi specifici, o la raccolta ed il trattamento di Dati Personali.
  </p>

  <h3>Log di sistema e manutenzione</h3>
  <p>
    Per necessità legate al funzionamento ed alla manutenzione, questa Applicazione e gli eventuali servizi terzi da essa utilizzati potrebbero raccogliere log di sistema, ossia file che registrano le interazioni e che possono contenere anche Dati Personali, quali l’indirizzo IP Utente.
  </p>

  <h3>Informazioni non contenute in questa policy</h3>
  <p>
    Ulteriori informazioni in relazione al trattamento dei Dati Personali potranno essere richieste in qualsiasi momento al Titolare del Trattamento utilizzando gli estremi di contatto.
  </p>

    <h3>Risposta alle richieste “Do Not Track”</h3>
    <p>
      Questa Applicazione non supporta le richieste “Do Not Track”.<br>
Per scoprire se gli eventuali servizi di terze parti utilizzati le supportino, l'Utente è invitato a consultare le rispettive privacy policy.
    </p>

  <h3>Modifiche a questa privacy policy</h3>
  <p>
    Il Titolare del Trattamento si riserva il diritto di apportare modifiche alla presente privacy policy in qualunque momento dandone informazione agli Utenti su questa pagina e, se possibile, su questa Applicazione nonché, qualora tecnicamente e legalmente fattibile, inviando una notifica agli Utenti attraverso uno degli estremi di contatto di cui è in possesso il Titolare . Si prega dunque di consultare regolarmente questa pagina, facendo riferimento alla data di ultima modifica indicata in fondo.<br><br>
Qualora le modifiche interessino trattamenti la cui base giuridica è il consenso, il Titolare provvederà a raccogliere nuovamente il consenso dell’Utente, se necessario.
  </p>


</div> <!-- /one_line_col -->

<div class="one_line_col">

  <div class="box_primary box_10 definitions expand collapsed">

    <h3 class="expand-click w_icon_24 icon_ribbon">
      Definizioni e riferimenti legali
    </h3>

    <div class="expand-content" style="display: none;">

      <h4>Dati Personali (o Dati)</h4>
      <p>Costituisce dato personale qualunque informazione che, direttamente o indirettamente, anche in collegamento con qualsiasi altra informazione, ivi compreso un numero di identificazione personale, renda identificata o identificabile una persona fisica.</p>

      <h4>Dati di Utilizzo</h4>
      <p>Sono le informazioni raccolte automaticamente attraverso questa Applicazione (anche da applicazioni di parti terze integrate in questa Applicazione), tra cui: gli indirizzi IP o i nomi a dominio dei computer utilizzati dall’Utente che si connette con questa Applicazione, gli indirizzi in notazione URI (Uniform Resource Identifier), l’orario della richiesta, il metodo utilizzato nell’inoltrare la richiesta al server, la dimensione del file ottenuto in risposta, il codice numerico indicante lo stato della risposta dal server (buon fine, errore, ecc.) il paese di provenienza, le caratteristiche del browser e del sistema operativo utilizzati dal visitatore, le varie connotazioni temporali della visita (ad esempio il tempo di permanenza su ciascuna pagina) e i dettagli relativi all’itinerario seguito all’interno dell’Applicazione, con particolare riferimento alla sequenza delle pagine consultate, ai parametri relativi al sistema operativo e all’ambiente informatico dell’Utente.</p>

      <h4>Utente</h4>
      <p>L'individuo che utilizza questa Applicazione che, salvo ove diversamente specificato, coincide con l'Interessato.</p>

      <h4>Interessato</h4>
      <p>La persona fisica cui si riferiscono i Dati Personali.</p>

      <h4>Responsabile del Trattamento (o Responsabile)</h4>
      <p>La persona fisica, giuridica, la pubblica amministrazione e qualsiasi altro ente che tratta dati personali per conto del Titolare, secondo quanto esposto nella presente privacy policy.</p>

      <h4>Titolare del Trattamento (o Titolare)</h4>
      <p>La persona fisica o giuridica, l'autorità pubblica, il servizio o altro organismo che, singolarmente o insieme ad altri, determina le finalità e i mezzi del trattamento di dati personali e gli strumenti adottati, ivi comprese le misure di sicurezza relative al funzionamento ed alla fruizione di questa Applicazione. Il Titolare del Trattamento, salvo quanto diversamente specificato, è il titolare di questa Applicazione.</p>

      <h4>
        Questa Applicazione
        
      </h4>
      <p>Lo strumento hardware o software mediante il quale sono raccolti e trattati i Dati Personali degli Utenti.</p>

      <h4>Servizio</h4>
      <p>Il Servizio fornito da questa Applicazione così come definito nei relativi termini (se presenti) su questo sito/applicazione.</p>

      <h4>Unione Europea (o UE)</h4>
      <p>Salvo ove diversamente specificato, ogni riferimento all’Unione Europea contenuto in questo documento si intende esteso a tutti gli attuali stati membri dell’Unione Europea e dello Spazio Economico Europeo.</p>


      <hr>

      <h4>Riferimenti legali</h4>
      <p>La presente informativa privacy è redatta sulla base di molteplici ordinamenti legislativi, inclusi gli artt. 13 e 14 del Regolamento (UE) 2016/679.</p>
      <p>Ove non diversamente specificato, questa informativa privacy riguarda esclusivamente questa Applicazione.</p>

    </div> <!-- /expand-content -->

  </div> <!-- /box_primary -->

</div> <!-- /one_line_col -->

	
	         

          
<div class="iub_footer">

  <p>
    Ultima modifica: 26 febbraio 2019
  </p>

	 
		<p>
			<a href="//www.iubenda.com" title="iubenda - generatore di Privacy Policy" target="_blank" rel="noopener">iubenda</a> ospita questo contenuto e raccoglie solo  <a href="//www.iubenda.com/privacy-policy/19418041" target="_blank" rel="noopener">i Dati Personali strettamente necessari</a> alla sua fornitura.
		</p>

                <a href="//www.iubenda.com/privacy-policy/69871044?ifr=true&amp;height=788&amp;an=no" title="Visualizza la Privacy Policy semplificata" class="show_comp_link iframe-preserve an-preserve">Visualizza la Privacy Policy semplificata</a>

</div> <!-- /footer -->

<script type="text/javascript">
  function tryFunc(fName,args){
    if(typeof window[fName]==='function'){
      window[fName](args);
    }else{
      if(args){
        /* default behaviour is link */
        if(args.href){
          /* default link is target='_blank' */
          window.open(args.href)
        }
      }
    }
    return false; /* inhibit default behaviour */
  }
</script>


	
	      </div> <!-- /content -->
	    </div>
		<hr>
		  <div class="row">
    		<div class="col-sm-12 col-md-6 offset-md-3">
				<a class="btn btn-secondary btn-lg rounded-pill" href="index.jsp" role="button">VAI ALLA HOMEPAGE</a>
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


</body>
</html>