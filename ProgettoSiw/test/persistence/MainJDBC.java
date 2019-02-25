package persistence;

import java.util.List;
import java.util.Set;

import model.Canzone;
import model.Playlist;
import model.Album;
import model.Artista;
import model.Utente;
import persistence.dao.CanzoneDao;
import persistence.dao.PlaylistDao;
import persistence.dao.AlbumDao;
import persistence.dao.ArtistaDao;
import persistence.dao.UtenteDao;

public class MainJDBC
{

	public static void main(String args[])
	{
		DAOFactory factory = DatabaseManager.getInstance().getDaoFactory();
		UtilDao util = factory.getUtilDAO();
		util.dropDatabase();

		util.createDatabase();
		
		//DAO UTENTE,ETC..
		UtenteDao utenteDao = factory.getUtenteDAO();
		CanzoneDao canzoneDao = factory.getCanzoneDAO();
		AlbumDao albumDao = factory.getAlbumDAO();
		ArtistaDao artistaDao = factory.getArtistaDAO();
		PlaylistDao playlistDao = factory.getPlaylistDAO();

		//INSTANCES UTENTE,ETC..
		Utente destiny= new Utente("destiny", "destiny@gmail.com", "lattuga", false);
		Utente chimera= new Utente("chimera", "chimera@gmail.com", "salvenee", false);
		Utente fragola86= new Utente("fragola86", "fragola86@gmail.com", "pompei", true);
		Utente banana33= new Utente("banana33", "banana33@gmail.com", "cetriolo", false);
		
		//Artista artistaDaEliminare=new Artista("Pino Scotto","Italia",null);
		//Artista artistaDaAggiornare=new Artista("Luci351 Battisti","Itttalia","img/artista/luciobattisti.jpg");
		
		Artista redhotchilipeppers=new Artista("Red Hot Chili Peppers","USA","img/artista/redhotchilipeppers.jpg");
		Artista muse=new Artista("Muse","United Kingdom","img/artista/muse.jpg");
		Artista luciobattisti=new Artista("Lucio Battisti","Italia","img/artista/luciobattisti.jpg");
		
		//Album albumDaEliminare=new Album("album3",2002,"metal",muse,null);
		//Album albumDaAggiornare=new Album("album1",1978,"pop",luciobattisti,null);
		
		Album album_californication=new Album("californication",1999,"rock",redhotchilipeppers,"img/album/californication.jpg");
		Album album_bytheway=new Album("bytheway",2002,"rock",redhotchilipeppers,"img/album/bytheway.jpg");
		Album album_showbiz=new Album("showbiz",1999,"rock",muse,"img/album/showbiz.jpg");
		
		//Canzone cannzoneDaAggiornare=new Canzone("titolo1",(float) 5.32,null);
		//Canzone canzoneDaEliminare=new Canzone("titolo3",(float) 3.25,null);
		Canzone aroundtheworld=new Canzone("Around The World",(float) 3.58,album_californication,"audio/californication/aroundtheworld.mp3");
		Canzone paralleluniverse=new Canzone("Parallel Universe",(float) 4.30,album_californication,"audio/californication/paralleluniverse.mp3");
		Canzone scartissue=new Canzone("Scar Tissue",(float) 3.37,album_californication,"audio/californication/scartissue.mp3");
		Canzone otherside=new Canzone("Otherside",(float) 4.15,album_californication,"audio/californication/otherside.mp3");
		Canzone getontop=new Canzone("Get On Top",(float) 3.18,album_californication,"audio/californication/getontop.mp3");
		Canzone californication=new Canzone("Californication",(float) 5.21,album_californication,"audio/californication/californication.mp3");
		Canzone easily=new Canzone("Easily",(float) 3.51,album_californication,"audio/californication/easily.mp3");
		Canzone porcelain=new Canzone("Porcelain",(float) 2.43,album_californication,"audio/californication/porcelain.mp3");
		Canzone emitremmus=new Canzone("Emit Remmus",(float) 4.00,album_californication,"audio/californication/emitremmus.mp3");
		Canzone ilikedirt=new Canzone("I Like Dirt",(float) 2.37,album_californication,"audio/californication/ilikedirt.mp3");
		Canzone thisvelvetglove=new Canzone("This Velvet Glove",(float) 3.45,album_californication,"audio/californication/thisvelvetglove.mp3");
		Canzone savior=new Canzone("Savior",(float) 4.52,album_californication,"audio/californication/savior.mp3");
		Canzone purplestain=new Canzone("Purple Stain",(float) 4.12,album_californication,"audio/californication/purplestain.mp3");
		Canzone rightontime=new Canzone("Right On Time",(float) 1.52,album_californication,"audio/californication/rightontime.mp3");
		Canzone roadtrippin=new Canzone("Road Trippin",(float) 3.25,album_californication,"audio/californication/roadtrippin.mp3");
		
		Canzone bytheway=new Canzone("By The Way",(float) 3.37,album_bytheway,"audio/bytheway/bytheway.mp3");
		Canzone universallyspeaking=new Canzone("Universally Speaking",(float) 4.19,album_bytheway,"audio/bytheway/universallyspeaking.mp3");
		Canzone thisistheplace=new Canzone("This Is The Place",(float) 4.17,album_bytheway,"audio/bytheway/thisistheplace.mp3");
		Canzone dosed=new Canzone("Dosed",(float) 5.12,album_bytheway,"audio/bytheway/dosed.mp3");
		Canzone dontforgetme=new Canzone("Dont Forget Me",(float) 4.37,album_bytheway,"audio/bytheway/dontforgetme.mp3");
		Canzone thezephyrsong=new Canzone("The Zephyr Song",(float) 3.52,album_bytheway,"audio/bytheway/thezephyrsong.mp3");
		Canzone cantstop=new Canzone("Cant Stop",(float) 4.29,album_bytheway,"audio/bytheway/cantstop.mp3");
		Canzone icoulddieforyou=new Canzone("I Could Die For You",(float) 3.13,album_bytheway,"audio/bytheway/icoulddieforyou.mp3");
		Canzone midnight=new Canzone("Midnight",(float) 4.55,album_bytheway,"audio/bytheway/midnight.mp3");
		Canzone throwawayyourtelevision=new Canzone("Throw Away Your Television",(float) 3.44,album_bytheway,"audio/bytheway/throwawayyourtelevision.mp3");
		Canzone cabron=new Canzone("Cabron",(float) 3.38,album_bytheway,"audio/bytheway/cabron.mp3");
		Canzone tear=new Canzone("Tear",(float) 5.17,album_bytheway,"audio/bytheway/tear.mp3");
		Canzone onmercury=new Canzone("On Mercury",(float) 3.28,album_bytheway,"audio/bytheway/onmercury.mp3");
		Canzone minorthing=new Canzone("Minor Thing",(float) 3.37,album_bytheway,"audio/bytheway/minorthing.mp3");
		Canzone warmtape=new Canzone("Warm Tape",(float) 4.16,album_bytheway,"audio/bytheway/warmtape.mp3");
		Canzone venicequeen=new Canzone("Venice Queen",(float) 6.08,album_bytheway,"audio/bytheway/venicequeen.mp3");
		
		Canzone sunburn=new Canzone("Sunburn",(float) 3.53,album_showbiz,"audio/showbiz/sunburn.mp3");
		Canzone musclemuseum=new Canzone("Muscle Museum",(float) 4.22,album_showbiz,"audio/showbiz/musclemuseum.mp3");
		Canzone fillip=new Canzone("Fillip",(float) 4.01,album_showbiz,"audio/showbiz/fillip.mp3");
		Canzone fallingdown=new Canzone("Falling Down",(float) 4.33,album_showbiz,"audio/showbiz/fallingdown.mp3");
		Canzone cave=new Canzone("Cave",(float) 4.46,album_showbiz,"audio/showbiz/cave.mp3");
		Canzone showbiz=new Canzone("Showbiz",(float) 5.17,album_showbiz,"audio/showbiz/showbiz.mp3");
		Canzone unintended=new Canzone("Unintended",(float) 3.57,album_showbiz,"audio/showbiz/unintended.mp3");
		Canzone uno=new Canzone("Uno",(float) 3.38,album_showbiz,"audio/showbiz/uno.mp3");
		Canzone sober=new Canzone("Sober",(float) 4.04,album_showbiz,"audio/showbiz/sober.mp3");
		Canzone escape=new Canzone("Escape",(float) 3.31,album_showbiz,"audio/showbiz/escape.mp3");
		Canzone overdue=new Canzone("Overdue",(float) 2.26,album_showbiz,"audio/showbiz/overdue.mp3");
		Canzone hatethisandillloveyou=new Canzone("Hate This And Ill Love You",(float) 5.09,album_showbiz,"audio/showbiz/hatethisandillloveyou.mp3");
		Canzone spiralstatic=new Canzone("Spiral Static",(float) 4.43,album_showbiz,"audio/showbiz/spiralstatic.mp3");
		
		Playlist playlist1=new Playlist("playlist1",destiny);
		Playlist playlist2=new Playlist("playlist2",destiny);
		Playlist playlist3=new Playlist("playlist3",banana33);

		//SAVE UTENTE,ETC.. (RISPETTARE ORDINE DIPENDENZE)
		utenteDao.save(destiny);
		utenteDao.save(chimera);
		utenteDao.save(fragola86);
		utenteDao.save(banana33);
		
		
		//artistaDao.save(artistaDaEliminare);
		//artistaDao.save(artistaDaAggiornare);	
		artistaDao.save(redhotchilipeppers);
		artistaDao.save(muse);
		artistaDao.save(luciobattisti);
		
		
		//albumDao.save(albumDaEliminare);
		//albumDao.save(albumDaAggiornare);
		albumDao.save(album_californication);
		albumDao.save(album_bytheway);
		albumDao.save(album_showbiz);
		
		//canzoneDao.save(cannzoneDaAggiornare);
		//canzoneDao.save(canzoneDaEliminare);
		canzoneDao.save(aroundtheworld);
		canzoneDao.save(paralleluniverse);
		canzoneDao.save(scartissue);
		canzoneDao.save(otherside);
		canzoneDao.save(getontop);
		canzoneDao.save(californication);
		canzoneDao.save(easily);
		canzoneDao.save(porcelain);
		canzoneDao.save(emitremmus);
		canzoneDao.save(ilikedirt);
		canzoneDao.save(thisvelvetglove);
		canzoneDao.save(savior);
		canzoneDao.save(purplestain);
		canzoneDao.save(rightontime);
		canzoneDao.save(roadtrippin);
		
		canzoneDao.save(bytheway);
		canzoneDao.save(universallyspeaking);
		canzoneDao.save(thisistheplace);
		canzoneDao.save(dosed);
		canzoneDao.save(dontforgetme);
		canzoneDao.save(thezephyrsong);
		canzoneDao.save(cantstop);
		canzoneDao.save(icoulddieforyou);
		canzoneDao.save(midnight);
		canzoneDao.save(throwawayyourtelevision);
		canzoneDao.save(cabron);
		canzoneDao.save(tear);
		canzoneDao.save(onmercury);
		canzoneDao.save(minorthing);
		canzoneDao.save(warmtape);
		canzoneDao.save(venicequeen);
		
		canzoneDao.save(sunburn);
		canzoneDao.save(musclemuseum);
		canzoneDao.save(fillip);
		canzoneDao.save(fallingdown);
		canzoneDao.save(cave);
		canzoneDao.save(showbiz);
		canzoneDao.save(unintended);
		canzoneDao.save(uno);
		canzoneDao.save(sober);
		canzoneDao.save(escape);
		canzoneDao.save(overdue);
		canzoneDao.save(hatethisandillloveyou);
		canzoneDao.save(spiralstatic);
		
		playlistDao.save(playlist1);
		playlistDao.save(playlist2);
		playlistDao.save(playlist3);
		
		//DELETE
		utenteDao.delete(chimera);
		//canzoneDao.delete(canzoneDaEliminare);
		//albumDao.delete(albumDaEliminare);
		//artistaDao.delete(artistaDaEliminare);
		playlistDao.delete(playlist3);
		
		//UPDATE
		destiny.setPassword("wengweng");
		destiny.setEmail("real_destiny@gmail.com");
		destiny.setPremium(true);
		destiny.addPlaylistCondivisa(playlist1.getId());
		destiny.addPlaylistCondivisa(playlist2.getId());
		utenteDao.update(destiny);
		
		//fragola86.addPlaylistCondivisa(playlist3.getId()); -->AVEVO FATTO DELETE PLAYLIST3
		utenteDao.update(fragola86);
		
		banana33.addPlaylistCondivisa(playlist1.getId());
		utenteDao.update(banana33);
		
//		cannzoneDaAggiornare.setTitolo("nuovoTitolo");
//		cannzoneDaAggiornare.setDurata((float) 1.50);
//		canzoneDao.update(cannzoneDaAggiornare);
		
//		albumDaAggiornare.setTitolo("NuovoTitoloAlbum1");
//		albumDaAggiornare.setAnno(2019);
//		albumDaAggiornare.setGenere("electro");
//		albumDao.update(albumDaAggiornare);
		
//		artistaDaAggiornare.setNome("Lucio Battisti");
//		artistaDaAggiornare.setPaese("Italia");
//		artistaDao.update(artistaDaAggiornare);
		
		playlist1.setNome("nuovaPlaylist1");
		playlist1.addCanzone(scartissue.getId());
		playlist1.addCanzone(sunburn.getId());
		playlist1.addCanzone(universallyspeaking.getId());
		playlist1.addCanzone(uno.getId());
		playlist1.addCanzone(roadtrippin.getId());
		playlist1.addCanzone(hatethisandillloveyou.getId());
		playlistDao.update(playlist1);
		
		playlist2.setNome("nuovaPlaylist2");
		playlist2.addCanzone(aroundtheworld.getId());
		playlist2.addCanzone(showbiz.getId());
		playlist2.addCanzone(venicequeen.getId());
		playlist2.addCanzone(unintended.getId());
		playlist2.addCanzone(fillip.getId());
		playlist2.addCanzone(paralleluniverse.getId());
		playlistDao.update(playlist2);
		
		//NON SETTARE LE CHIAVI PRIMARIE, IL SUO UPDATE NEL DATABASE NON POTRA' ANDARE
		//L'INTERROGAZIONE DELLA QUERY DELL'UPDATE SI BASA SULLA CHIAVE PRIMARIA!

		
		//-----------------------------TEST-----------------------------------------
		System.out.println("\n<TEST: DELETE, UPDATE, FINDALL - LISTA USERS>");
		List<Utente> utenti= utenteDao.findAll();
		for(Utente utente: utenti)
		{
			System.out.println(utente.getUsername() + " - email: " + utente.getEmail() + " - password: " + utente.getPassword() + " - premium: " + utente.isPremium());
		}
		System.out.println("<ENDTEST: DELETE, UPDATE, FINDALL>\n");	
		
		System.out.println("\n<TEST: DELETE, UPDATE, FINDALL - LISTA CANZONE>");
		List<Canzone> list_canzone= canzoneDao.findAll();
		for (Canzone canzone : list_canzone)
		{
			System.out.println("id: " + canzone.getId() + " - titolo: " + canzone.getTitolo() + " - durata: " + canzone.getDurata() + " - album: " + canzone.getAlbum().getTitolo());
		}
		System.out.println("<ENDTEST: DELETE, UPDATE, FINDALL>\n");	
		
		System.out.println("\n<TEST: DELETE, UPDATE, FINDALL - LISTA ALBUM>");
		List<Album> list_album= albumDao.findAll();
		for (Album album : list_album)
		{
			System.out.println("id: " + album.getId() + " - titolo: " + album.getTitolo() + " - anno: " + album.getAnno() + " - genere: " + album.getGenere() + " - artista: " + album.getArtista().getNome() + " - immagine: " + album.getImmagine());
		}
		System.out.println("<ENDTEST: DELETE, UPDATE, FINDALL>\n");	
		
		System.out.println("\n<TEST: DELETE, UPDATE, FINDALL - LISTA ARTISTA>");
		List<Artista> list_artista= artistaDao.findAll();
		for (Artista artista : list_artista)
		{
			System.out.println("id: " + artista.getId() + " - nome: " + artista.getNome() + " - paese: " + artista.getPaese() + " - immagine: " + artista.getImmagine());
		}
		System.out.println("<ENDTEST: DELETE, UPDATE, FINDALL>\n");
		
		System.out.println("\n<TEST: DELETE, UPDATE, FINDALL - LISTA PLAYLIST>");
		List<Playlist> list_playlist= playlistDao.findAll();
		for (Playlist playlist : list_playlist)
		{
			System.out.println("id: " + playlist.getId() + " - nome: " + playlist.getNome());
		}
		System.out.println("<ENDTEST: DELETE, UPDATE, FINDALL>\n");	

		System.out.println("\n<TEST: DELETE, UPDATE, FINDALL - LISTA RACCOLTA>");
		for(Playlist playlist : list_playlist)
		{
			Set<Canzone> set_canzoni= playlistDao.getCanzoniDiPlaylist(playlist);
			System.out.println("PLAYLIST: id: " + playlist.getId() + " - nome: " + playlist.getNome());
			System.out.print("	{");
			for (Canzone canzone : set_canzoni)
			{
				System.out.print(canzone.getTitolo() + "; ");
			}
			System.out.println("}");
		}
		System.out.println("<ENDTEST: DELETE, UPDATE, FINDALL>\n");
		
		System.out.println("\n<TEST: DELETE, UPDATE, FINDALL - LISTA CONDIVISIONE>");
		for(Utente utente: utenti)
		{
			Set<Playlist> set_playlistCondivise= utenteDao.getPlaylistCondiviseDaUtente(utente);
			System.out.println("PLAYLIST-CONDIVISE: nome: " + utente.getUsername());
			System.out.print("	{");
			for (Playlist playlist : set_playlistCondivise)
			{
				System.out.print(playlist.getNome() + "; ");
			}
			System.out.println("}");
		}
		System.out.println("<ENDTEST: DELETE, UPDATE, FINDALL>\n");	

		//----------------------FINE-TEST-------------------------------------------
	}

}
