package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

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
import persistence.dao.UtenteDao;

@WebServlet("/DammiPlaylistCondiviseDaUtente")
public class DammiPlaylistCondiviseDaUtente extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException ,ServletException
	{
		UtenteDao utenteDao = DatabaseManager.getInstance().getDaoFactory().getUtenteDAO();
		HttpSession sessione=request.getSession();
		Set<Playlist> list_playlist = utenteDao.getPlaylistCondiviseDaUtente((Utente) sessione.getAttribute("user"));
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
		UtenteDao utenteDao = DatabaseManager.getInstance().getDaoFactory().getUtenteDAO();
		HttpSession sessione=request.getSession();
		Set<Playlist> list_playlist = utenteDao.getPlaylistCondiviseDaUtente((Utente) sessione.getAttribute("user"));
		JSONArray list_playlistJSON = new JSONArray();
		
		for(Playlist playlist : list_playlist)
		{
			list_playlistJSON.put(new JSONObject(playlist,true));
		}
		
		PrintWriter out = response.getWriter();
		out.println(list_playlistJSON.toString());
	}

}
