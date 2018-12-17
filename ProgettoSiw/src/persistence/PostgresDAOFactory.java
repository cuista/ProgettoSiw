package persistence;

import persistence.dao.Object1Dao;
import persistence.dao.Object2Dao;
import persistence.dao.Object3Dao;
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
	public Object1Dao getObject1DAO() {
		return new Object1DaoJDBC(dataSource);
	}

	@Override
	public Object2Dao getObject2DAO()
	{
		return new Object2DaoJDBC(dataSource);
	}

	@Override
	public Object3Dao getObject3DAO()
	{
		return new Object3DaoJDBC(dataSource);
	}

	@Override
	public UtilDao getUtilDAO(){
		return new UtilDao(dataSource);
	}

}
