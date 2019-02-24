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

import model.Playlist;
import persistence.DatabaseManager;
import persistence.dao.PlaylistDao;

@WebServlet("/RicercaPlaylist")
public class RicercaPlaylist extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException ,ServletException
	{
		String stringa_cercata = request.getParameter("stringa_daCercare");
		PlaylistDao playlistDao = DatabaseManager.getInstance().getDaoFactory().getPlaylistDAO();	
		List<Playlist> list_playlist = playlistDao.findAll();		
		JSONArray list_playlistJSON = new JSONArray();	
		for(Playlist playlist : list_playlist)
		{
			if(playlist.getNome().toLowerCase().contains(stringa_cercata.toLowerCase()))
				list_playlistJSON.put(new JSONObject(playlist,true));
		}
		
		PrintWriter out = response.getWriter();
		out.println(list_playlistJSON.toString());
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String stringa_cercata = request.getParameter("stringa_daCercare");
		PlaylistDao playlistDao = DatabaseManager.getInstance().getDaoFactory().getPlaylistDAO();	
		List<Playlist> list_playlist = playlistDao.findAll();		
		JSONArray list_playlistJSON = new JSONArray();	
		for(Playlist playlist : list_playlist)
		{
			if(playlist.getNome().toLowerCase().contains(stringa_cercata.toLowerCase()))
				list_playlistJSON.put(new JSONObject(playlist,true));
		}
		
		PrintWriter out = response.getWriter();
		out.println(list_playlistJSON.toString());
	}

}
