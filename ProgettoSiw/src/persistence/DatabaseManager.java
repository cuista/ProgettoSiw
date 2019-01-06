package persistence;

//Singleton
public class DatabaseManager {
	private static DatabaseManager instance = null;
	
	public static DatabaseManager getInstance(){
		if (instance == null){
			instance = new DatabaseManager();
		}
		return instance;
	}
	
	private DAOFactory daoFactory;
		
	private DatabaseManager() {
		daoFactory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
	}
	
	public DAOFactory getDaoFactory() {
		return daoFactory;
	}
	
	

}
