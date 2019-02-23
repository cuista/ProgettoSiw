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
		
		Artista artista1=new Artista("Red Hot Chili Peppers","USA");
		Artista artista2=new Artista("Muse","United Kingdom");
		Artista artista3=new Artista("Luci351 Battisti","Itttalia");
		
		Album album1=new Album("album1",2002,"pop",artista3);
		Album album2=new Album("album2",1998,"rock",artista1);
		Album album3=new Album("album3",2002,"metal",artista2);
		
		Canzone canzone1=new Canzone("titolo1",(float) 5.32,album1);
		Canzone canzone2=new Canzone("titolo2",(float) 3.44,album1);
		Canzone canzone3=new Canzone("titolo3",(float) 3.25,album2);
		Canzone canzone4=new Canzone("titolo4",(float) 4.21,album2);
		Canzone canzone5=new Canzone("titolo5",(float) 4.16,album2);
		
		Playlist playlist1=new Playlist("playlist1",destiny);
		Playlist playlist2=new Playlist("playlist2",destiny);
		Playlist playlist3=new Playlist("playlist3",banana33);

		//SAVE UTENTE,ETC.. (RISPETTARE ORDINE DIPENDENZE)
		utenteDao.save(destiny);
		utenteDao.save(chimera);
		utenteDao.save(fragola86);
		utenteDao.save(banana33);
		
		artistaDao.save(artista1);
		artistaDao.save(artista2);
		artistaDao.save(artista3);
		
		albumDao.save(album1);
		albumDao.save(album2);
		albumDao.save(album3);
		
		canzoneDao.save(canzone1);
		canzoneDao.save(canzone2);
		canzoneDao.save(canzone3);
		canzoneDao.save(canzone4);
		canzoneDao.save(canzone5);
		
		playlistDao.save(playlist1);
		playlistDao.save(playlist2);
		playlistDao.save(playlist3);
		
		//DELETE
		utenteDao.delete(chimera);
		canzoneDao.delete(canzone3);
		albumDao.delete(album3);
		artistaDao.delete(artista2);
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
		
		canzone1.setTitolo("nuovoTitolo");
		canzone1.setDurata((float) 1.50);
		canzoneDao.update(canzone1);
		
		album1.setTitolo("NuovoTitoloAlbum1");
		album1.setAnno(2019);
		album1.setGenere("electro");
		albumDao.update(album1);
		
		artista3.setNome("Lucio Battisti");
		artista3.setPaese("Italia");
		artistaDao.update(artista3);
		
		playlist1.setNome("nuovaPlaylist1");
		playlist1.addCanzone(canzone1.getId());
		//playlist1.addCanzone(canzone3.getId()); -->AVEVO FATTO DELETE CANZONE3
		playlist1.addCanzone(canzone4.getId());
		playlistDao.update(playlist1);
		
		playlist2.setNome("nuovaPlaylist2");
		playlist2.addCanzone(canzone2.getId());
		playlist2.addCanzone(canzone4.getId());
		playlist2.addCanzone(canzone1.getId());
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
			System.out.println("id: " + album.getId() + " - titolo: " + album.getTitolo() + " - anno: " + album.getAnno() + " - genere: " + album.getGenere() + " - artista: " + album.getArtista().getNome());
		}
		System.out.println("<ENDTEST: DELETE, UPDATE, FINDALL>\n");	
		
		System.out.println("\n<TEST: DELETE, UPDATE, FINDALL - LISTA ARTISTA>");
		List<Artista> list_artista= artistaDao.findAll();
		for (Artista artista : list_artista)
		{
			System.out.println("id: " + artista.getId() + " - nome: " + artista.getNome() + " - paese: " + artista.getPaese());
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
