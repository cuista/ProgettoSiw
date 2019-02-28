package persistence.dao;

import java.util.List;

import model.Album;

public interface AlbumDao
{
	public void save(Album album);
	public Album findByPrimaryKey(Long id);
	public List<Album> findAll();
	public void update(Album album);
	public void delete(Album album);
	public List<Album> getAlbumDiArtista(Long id_artista);
}
