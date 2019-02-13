package persistence;

import persistence.dao.CanzoneDao;
import persistence.dao.PlaylistDao;
import persistence.dao.AlbumDao;
import persistence.dao.ArtistaDao;
import persistence.dao.UtenteDao;

class PostgresDAOFactory extends DAOFactory {

	//INFO: fabbrica concreta oggetti DAO
	
	private static DataSource dataSource;
	

	// --------------------------------------------

	static {
		try {
			Class.forName("org.postgresql.Driver").newInstance();
			//questi vanno messi in file di configurazione!!!	
//			dataSource=new DataSource("jdbc:postgresql://52.39.164.176:5432/xx","xx","p@xx");
			dataSource=new DataSource("jdbc:postgresql://localhost:5432/ProgettoSiw","postgres","root");
		} 
		catch (Exception e) {
			System.err.println("PostgresDAOFactory.class: failed to load MySQL JDBC driver\n"+e);
			e.printStackTrace();
		}
	}

	
	// --------------------------------------------
	
	@Override
	public UtenteDao getUtenteDAO()
	{
		return new UtenteDaoJDBC(dataSource);
	}
	
	@Override
	public CanzoneDao getCanzoneDAO()
	{
		return new CanzoneDaoJDBC(dataSource);
	}

	@Override
	public AlbumDao getAlbumDAO()
	{
		return new AlbumDaoJDBC(dataSource);
	}

	@Override
	public ArtistaDao getArtistaDAO()
	{
		return new ArtistaDaoJDBC(dataSource);
	}
	
	@Override
	public PlaylistDao getPlaylistDAO()
	{
		return new PlaylistDaoJDBC(dataSource);
	}
	
	@Override
	public UtilDao getUtilDAO(){
		return new UtilDao(dataSource);
	}


}
