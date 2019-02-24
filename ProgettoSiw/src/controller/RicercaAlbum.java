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

import model.Album;
import persistence.DatabaseManager;
import persistence.dao.AlbumDao;

@WebServlet("/RicercaAlbum")
public class RicercaAlbum extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException ,ServletException
	{
		String stringa_cercata = request.getParameter("stringa_daCercare");
		AlbumDao albumDao = DatabaseManager.getInstance().getDaoFactory().getAlbumDAO();	
		List<Album> list_album = albumDao.findAll();		
		JSONArray list_albumJSON = new JSONArray();	
		for(Album album : list_album)
		{
			if(album.getTitolo().toLowerCase().contains(stringa_cercata.toLowerCase()))
				list_albumJSON.put(new JSONObject(album,true));
		}
		
		PrintWriter out = response.getWriter();
		out.println(list_albumJSON.toString());
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String stringa_cercata = request.getParameter("stringa_daCercare");
		AlbumDao albumDao = DatabaseManager.getInstance().getDaoFactory().getAlbumDAO();	
		List<Album> list_album = albumDao.findAll();		
		JSONArray list_albumJSON = new JSONArray();	
		for(Album album : list_album)
		{
			if(album.getTitolo().toLowerCase().contains(stringa_cercata.toLowerCase()))
				list_albumJSON.put(new JSONObject(album,true));
		}
		
		PrintWriter out = response.getWriter();
		out.println(list_albumJSON.toString());
	}

}
