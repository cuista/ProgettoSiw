package persistence;

import java.util.List;

import model.Object1;
import model.Object2;
import model.Object3;
import model.Utente;
import persistence.dao.Object1Dao;
import persistence.dao.Object2Dao;
import persistence.dao.Object3Dao;
import persistence.dao.UtenteDao;

public class MainJDBC
{

	public static void main(String args[])
	{
		DAOFactory factory = DatabaseManager.getInstance().getDaoFactory();
		UtilDao util = factory.getUtilDAO();
		util.dropDatabase();

		util.createDatabase();
		
		//DAO
		UtenteDao utenteDao = factory.getUtenteDAO();
		Object1Dao object1Dao = factory.getObject1DAO();
		Object2Dao object2Dao = factory.getObject2DAO();
		Object3Dao object3Dao = factory.getObject3DAO();

		//INSTANCES UTENTE,OB1,OB2,OB3
		Utente destiny= new Utente("destiny", "destiny@gmail.com", "berlusconiErMeglio");
		Utente chimera= new Utente("chimera", "chimera@gmail.com", "salvenee");
		Utente fragola86= new Utente("fragola86", "fragola86@gmail.com", "pompei");
		Utente banana33= new Utente("banana33", "banana33@gmail.com", "cetriolo");
		
		Object1 o1A=new Object1(2);
		Object1 o1B=new Object1(1);
		Object1 o1C=new Object1(3);
		Object1 o1D=new Object1(17);
		Object1 o1E=new Object1(4);
		
		Object2 o2A=new Object2(23);
		Object2 o2B=new Object2(1);
		
		Object3 o3A=new Object3(5);
		Object3 o3B=new Object3(6);
		Object3 o3C=new Object3(4);

		//SAVE UTENTE,OB1,OB2,OB3
		utenteDao.save(destiny);
		utenteDao.save(chimera);
		utenteDao.save(fragola86);
		utenteDao.save(banana33);
		
		object1Dao.save(o1A);
		object1Dao.save(o1B);
		object1Dao.save(o1C);
		object1Dao.save(o1D);
		object1Dao.save(o1E);
		
		object2Dao.save(o2A);
		object2Dao.save(o2B);
		
		object3Dao.save(o3A);
		object3Dao.save(o3B);
		object3Dao.save(o3C);
		
		//DELETE
		utenteDao.delete(chimera);
		object1Dao.delete(o1B);
		object2Dao.delete(o2A);
		object3Dao.delete(o3B);
		
		//UPDATE
		destiny.setEmail("real_destiny@gmail.com");
		utenteDao.update(destiny);
		
		o1A.setAttribute(99);
		object1Dao.update(o1A);
		
		o2B.setAttribute(99);
		object2Dao.update(o2B);
		
		o3C.setAttribute(99);
		object3Dao.update(o3C);
		
		//NON SETTARE LE CHIAVI PRIMARIE, IL SUO UPDATE NEL DATABASE NON POTRA' ANDARE
		//L'INTERROGAZIONE DELLA QUERY DELL'UPDATE SI BASA SULLA CHIAVE PRIMARIA!

		
		//-----------------------------TEST-----------------------------------------
		System.out.println("\n<TEST: DELETE, UPDATE, FINDALL - LISTA USERS>");
		List<Utente> utenti= utenteDao.findAll();
		for(Utente utente: utenti)
		{
			System.out.println(utente.getUsername() + " - email: " + utente.getEmail() + " - email: " + utente.getPassword());
		}
		System.out.println("<ENDTEST: DELETE, UPDATE, FINDALL>\n");	
		
		System.out.println("\n<TEST: DELETE, UPDATE, FINDALL - LISTA OBJECTS1>");
		List<Object1> objects1= object1Dao.findAll();
		for (Object1 object1 : objects1)
		{
			System.out.println("id: " + object1.getId() + " - attributo: "+object1.getAttribute());
		}
		System.out.println("<ENDTEST: DELETE, UPDATE, FINDALL>\n");	
		
		System.out.println("\n<TEST: DELETE, UPDATE, FINDALL - LISTA OBJECTS1>");
		List<Object2> objects2= object2Dao.findAll();
		for (Object2 object2 : objects2)
		{
			System.out.println("id: " + object2.getId() + " - attributo: "+object2.getAttribute());
		}
		System.out.println("<ENDTEST: DELETE, UPDATE, FINDALL>\n");	
		
		System.out.println("\n<TEST: DELETE, UPDATE, FINDALL - LISTA OBJECTS1>");
		List<Object3> objects3= object3Dao.findAll();
		for (Object3 object3 : objects3)
		{
			System.out.println("id: " + object3.getId() + " - attributo: "+object3.getAttribute());
		}
		System.out.println("<ENDTEST: DELETE, UPDATE, FINDALL>\n");	

		//----------------------FINE-TEST-------------------------------------------
	}

}
