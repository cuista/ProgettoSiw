package persistence.dao;

import java.util.List;
import java.util.Set;

import model.Canzone;

public interface CanzoneDao
{
	public void save(Canzone object1);
	public Canzone findByPrimaryKey(Long id);
	public List<Canzone> findAll();
	public void update(Canzone object1);
	public void delete(Canzone object1);
	public Set<Canzone> getCanzoniDaAlbum(Long id_album);
	public Set<Canzone> getCanzoniDaPlaylist(Long id_playlist);
}
