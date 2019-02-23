package persistence.dao;

import java.util.List;
import java.util.Set;

import model.Playlist;
import model.Utente;

public interface UtenteDao
{
	public void save(Utente utente);
	public Utente findByPrimaryKey(String username);
	public List<Utente> findAll();
	public void update(Utente utente);
	public void delete(Utente utente);
	public Set<Playlist> getPlaylistCondiviseDaUtente(Utente utente);
	public List<Playlist> getPlaylistCondiviseAltriUtenti(Utente utente);
}
