package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import model.Playlist;
import model.Utente;
import persistence.DatabaseManager;
import persistence.dao.PlaylistDao;

@WebServlet("/CreaPlaylist")
public class CreaPlaylist extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException ,ServletException
	{
		PlaylistDao playlistDao = DatabaseManager.getInstance().getDaoFactory().getPlaylistDAO();
		HttpSession sessione=request.getSession();
		
		StringBuffer jsonReceived = new StringBuffer();
		BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));		
		String line = reader.readLine();
		while (line != null)
		{
			jsonReceived.append(line);
			line = reader.readLine();
		}

		try
		{
			JSONArray jsonArray = new JSONArray(jsonReceived.toString());
			
			JSONObject jsonNomePlaylist = jsonArray.getJSONObject(0);
			JSONObject jsonCanzoni = jsonArray.getJSONObject(1);
			
			String nomePlaylist = jsonNomePlaylist.getString("nomePlaylist");		
			Playlist nuovaPlaylist=new Playlist(nomePlaylist,(Utente) sessione.getAttribute("user"));
			playlistDao.save(nuovaPlaylist);
			
			JSONArray jsonArrayCanzoni = jsonCanzoni.getJSONArray("canzoni");
			
			for (int i = 0; i < jsonArrayCanzoni.length(); i++)
			{
				nuovaPlaylist.addCanzone(jsonArray.getJSONObject(i).getLong("id"));
			}
			playlistDao.update(nuovaPlaylist);
		} 
		catch (JSONException e)
		{
			e.printStackTrace();
		}	
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PlaylistDao playlistDao = DatabaseManager.getInstance().getDaoFactory().getPlaylistDAO();
		HttpSession sessione=request.getSession();
		
		StringBuffer jsonReceived = new StringBuffer();
		BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));		
		String line = reader.readLine();
		while (line != null)
		{
			jsonReceived.append(line);
			line = reader.readLine();
		}

		try
		{
			JSONArray jsonArray = new JSONArray(jsonReceived.toString());
			
			JSONObject jsonNomePlaylist = jsonArray.getJSONObject(0);
			JSONArray jsonCanzoni = jsonArray.getJSONArray(1);
			
			String nomePlaylist = jsonNomePlaylist.getString("nomePlaylist");		
			Playlist nuovaPlaylist=new Playlist(nomePlaylist,(Utente) sessione.getAttribute("user"));
			playlistDao.save(nuovaPlaylist);
			
			for (int i = 0; i < jsonCanzoni.length(); i++)
			{
				nuovaPlaylist.addCanzone(jsonCanzoni.getJSONObject(i).getLong("id"));
			}
			playlistDao.update(nuovaPlaylist);
		} 
		catch (JSONException e)
		{
			e.printStackTrace();
		}	
	}

}
