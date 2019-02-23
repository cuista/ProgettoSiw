package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;

import model.Playlist;
import model.Utente;
import persistence.DatabaseManager;
import persistence.dao.PlaylistDao;

@WebServlet("/DammiPlaylistUtente")
public class DammiPlaylistUtente extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException ,ServletException
	{
		PlaylistDao playlistDao = DatabaseManager.getInstance().getDaoFactory().getPlaylistDAO();
		HttpSession sessione=request.getSession();
		List<Playlist> list_playlist = playlistDao.getPlaylistUtente((Utente) sessione.getAttribute("user"));
		JSONArray list_playlistJSON = new JSONArray();
		
		for(Playlist playlist : list_playlist)
		{
			list_playlistJSON.put(new JSONObject(playlist,true));
		}
		
		PrintWriter out = response.getWriter();
		out.println(list_playlistJSON.toString());
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PlaylistDao playlistDao = DatabaseManager.getInstance().getDaoFactory().getPlaylistDAO();
		HttpSession sessione=request.getSession();
		List<Playlist> list_playlist = playlistDao.getPlaylistUtente((Utente) sessione.getAttribute("user"));
		JSONArray list_playlistJSON = new JSONArray();
		
		for(Playlist playlist : list_playlist)
		{
			list_playlistJSON.put(new JSONObject(playlist,true));
		}
		
		PrintWriter out = response.getWriter();
		out.println(list_playlistJSON.toString());
	}

}
