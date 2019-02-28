package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import model.Album;
import model.Canzone;
import persistence.DatabaseManager;
import persistence.dao.AlbumDao;
import persistence.dao.CanzoneDao;

@WebServlet("/PrendiCanzoniDaIdArtista")
public class PrendiCanzoniDaIdArtista extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException ,ServletException
	{
		AlbumDao albumDao = DatabaseManager.getInstance().getDaoFactory().getAlbumDAO();
		CanzoneDao canzoneDao = DatabaseManager.getInstance().getDaoFactory().getCanzoneDAO();
		List<Album> list_album = albumDao.getAlbumDiArtista(Long.parseLong(request.getParameter("idArtista")));
		Set<Canzone> list_canzoni = new LinkedHashSet<>();
		for (Album album : list_album)
		{
			list_canzoni.addAll(canzoneDao.getCanzoniDaAlbum(album.getId()));
		}
		
		JSONArray list_canzoniJSON = new JSONArray();	
		for(Canzone canzone : list_canzoni)
		{
			list_canzoniJSON.put(new JSONObject(canzone,true));
		}
		
		PrintWriter out = response.getWriter();
		out.println(list_canzoniJSON.toString());
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		AlbumDao albumDao = DatabaseManager.getInstance().getDaoFactory().getAlbumDAO();
		CanzoneDao canzoneDao = DatabaseManager.getInstance().getDaoFactory().getCanzoneDAO();
		List<Album> list_album = albumDao.getAlbumDiArtista(Long.parseLong(request.getParameter("idArtista")));
		Set<Canzone> list_canzoni = new LinkedHashSet<>();
		for (Album album : list_album)
		{
			list_canzoni.addAll(canzoneDao.getCanzoniDaAlbum(album.getId()));
		}
		
		JSONArray list_canzoniJSON = new JSONArray();	
		for(Canzone canzone : list_canzoni)
		{
			list_canzoniJSON.put(new JSONObject(canzone,true));
		}
		
		PrintWriter out = response.getWriter();
		out.println(list_canzoniJSON.toString());
	}

}
