package persistence.dao;

import java.util.List;
import java.util.Set;

import model.Canzone;
import model.Playlist;
import model.Utente;

public interface PlaylistDao
{
	public void save(Playlist playlist);
	public Playlist findByPrimaryKey(Long id);
	public List<Playlist> findAll();
	public void update(Playlist playlist);
	public void delete(Playlist playlist);
	public List<Playlist> getPlaylistUtente(Utente utente);
	public Set<Canzone> getCanzoniDiPlaylist(Playlist playlist);
}
