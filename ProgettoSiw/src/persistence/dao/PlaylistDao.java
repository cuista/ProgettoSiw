package persistence.dao;

import java.util.List;

import model.Playlist;

public interface PlaylistDao
{
	public void save(Playlist playlist);
	public Playlist findByPrimaryKey(Long id);
	public List<Playlist> findAll();
	public void update(Playlist playlist);
	public void delete(Playlist playlist);
}
