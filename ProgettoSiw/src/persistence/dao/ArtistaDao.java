package persistence.dao;

import java.util.List;

import model.Artista;

public interface ArtistaDao
{
	public void save(Artista artista);
	public Artista findByPrimaryKey(Long id);
	public List<Artista> findAll();
	public void update(Artista artista);
	public void delete(Artista artista);
}
