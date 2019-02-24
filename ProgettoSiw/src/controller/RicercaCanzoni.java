package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import model.Canzone;
import persistence.DatabaseManager;
import persistence.dao.CanzoneDao;

@WebServlet("/RicercaCanzoni")
public class RicercaCanzoni extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException ,ServletException
	{
		String stringa_cercata = request.getParameter("stringa_daCercare");
		CanzoneDao canzoneDao = DatabaseManager.getInstance().getDaoFactory().getCanzoneDAO();	
		List<Canzone> list_canzoni = canzoneDao.findAll();		
		JSONArray list_canzoniJSON = new JSONArray();	
		for(Canzone canzone : list_canzoni)
		{
			if(canzone.getTitolo().toLowerCase().contains(stringa_cercata.toLowerCase()))
				list_canzoniJSON.put(new JSONObject(canzone,true));
		}
		
		PrintWriter out = response.getWriter();
		out.println(list_canzoniJSON.toString());
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String stringa_cercata = request.getParameter("stringa_daCercare");
		CanzoneDao canzoneDao = DatabaseManager.getInstance().getDaoFactory().getCanzoneDAO();	
		List<Canzone> list_canzoni = canzoneDao.findAll();		
		JSONArray list_canzoniJSON = new JSONArray();	
		for(Canzone canzone : list_canzoni)
		{
			if(canzone.getTitolo().toLowerCase().contains(stringa_cercata.toLowerCase()))
				list_canzoniJSON.put(new JSONObject(canzone,true));
		}
		
		PrintWriter out = response.getWriter();
		out.println(list_canzoniJSON.toString());
	}

}
