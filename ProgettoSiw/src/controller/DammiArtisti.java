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

import model.Artista;
import persistence.DatabaseManager;
import persistence.dao.ArtistaDao;

@WebServlet("/DammiArtisti")
public class DammiArtisti extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException ,ServletException
	{
		ArtistaDao artistaDao = DatabaseManager.getInstance().getDaoFactory().getArtistaDAO();	
		List<Artista> list_artisti = artistaDao.findAll();		
		JSONArray list_artistiJSON = new JSONArray();	
		for(Artista artista : list_artisti)
		{
			list_artistiJSON.put(new JSONObject(artista,true));
		}
		
		PrintWriter out = response.getWriter();
		out.println(list_artistiJSON.toString());
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		ArtistaDao artistaDao = DatabaseManager.getInstance().getDaoFactory().getArtistaDAO();	
		List<Artista> list_artisti = artistaDao.findAll();		
		JSONArray list_artistiJSON = new JSONArray();	
		for(Artista artista : list_artisti)
		{
			list_artistiJSON.put(new JSONObject(artista,true));
		}
		
		PrintWriter out = response.getWriter();
		out.println(list_artistiJSON.toString());
	}

}
