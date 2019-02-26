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

	static 
	{
		try 
		{
			Class.forName("org.postgresql.Driver").newInstance();

			//DATABASE IN REMOTO
//			dataSource=new DataSource("jdbc:postgresql://manny.db.elephantsql.com:5432/wzpvguxd","wzpvguxd","9_CTTez605MRrJeUWM3oijHAYZOMREMF");
			
			//DATABASE LOCALE
			dataSource=new DataSource("jdbc:postgresql://localhost:5432/ProgettoSiw","postgres","root");
			
		} 
		catch (Exception e) 
		{
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
