package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Playlist;
import model.Utente;
import persistence.DatabaseManager;
import persistence.dao.PlaylistDao;
import persistence.dao.UtenteDao;

@WebServlet("/CondividiPlaylist")
public class CondividiPlaylist extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException ,ServletException
	{
		UtenteDao utenteDao = DatabaseManager.getInstance().getDaoFactory().getUtenteDAO();
		PlaylistDao playlistDao = DatabaseManager.getInstance().getDaoFactory().getPlaylistDAO();
		HttpSession sessione = request.getSession();
		
		Utente utente = (Utente) sessione.getAttribute("user");
		Playlist playlist = playlistDao.findByPrimaryKey(Long.parseLong(request.getParameter("idPlaylist")));
		
		utente.addPlaylistCondivisa(playlist.getId());
		utente.addPlaylistCondivisa(playlist.getId());
		utenteDao.update(utente);	
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		UtenteDao utenteDao = DatabaseManager.getInstance().getDaoFactory().getUtenteDAO();
		PlaylistDao playlistDao = DatabaseManager.getInstance().getDaoFactory().getPlaylistDAO();
		HttpSession sessione = request.getSession();
		
		Utente utente = (Utente) sessione.getAttribute("user");
		Playlist playlist = playlistDao.findByPrimaryKey(Long.parseLong(request.getParameter("idPlaylist")));
		
		utente.addPlaylistCondivisa(playlist.getId());
		utente.addPlaylistCondivisa(playlist.getId());
		utenteDao.update(utente);	
	}

}
