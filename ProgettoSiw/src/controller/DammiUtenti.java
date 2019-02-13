package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import model.Utente;
import persistence.DatabaseManager;
import persistence.dao.UtenteDao;

public class DammiUtenti extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException ,ServletException
	{
		UtenteDao utenteDao = DatabaseManager.getInstance().getDaoFactory().getUtenteDAO();
	
		List<Utente> utenti = utenteDao.findAll();
		
		JSONArray utentiJSON = new JSONArray();
		
		for(Utente e : utenti)
		{
			utentiJSON.put(new JSONObject(e,true));
		}
		
		PrintWriter out = response.getWriter();
		out.println(utentiJSON.toString());
	}

}
