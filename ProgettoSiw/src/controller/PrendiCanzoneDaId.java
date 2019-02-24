package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import model.Canzone;
import persistence.DatabaseManager;
import persistence.dao.CanzoneDao;

@WebServlet("/PrendiCanzoneDaId")
public class PrendiCanzoneDaId extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException ,ServletException
	{
		CanzoneDao canzoneDao = DatabaseManager.getInstance().getDaoFactory().getCanzoneDAO();
		//AlbumDao albumDao = DatabaseManager.getInstance().getDaoFactory().getAlbumDAO();
		//ArtistaDao artistaDao = DatabaseManager.getInstance().getDaoFactory().getArtistaDAO();
		Canzone canzone = canzoneDao.findByPrimaryKey(Long.parseLong(request.getParameter("idCanzone")));
		JSONObject canzoneJSON = new JSONObject(canzone,true);
		
		PrintWriter out = response.getWriter();
		out.println(canzoneJSON.toString());
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		CanzoneDao canzoneDao = DatabaseManager.getInstance().getDaoFactory().getCanzoneDAO();
		//AlbumDao albumDao = DatabaseManager.getInstance().getDaoFactory().getAlbumDAO();
		//ArtistaDao artistaDao = DatabaseManager.getInstance().getDaoFactory().getArtistaDAO();
		Canzone canzone = canzoneDao.findByPrimaryKey(Long.parseLong(request.getParameter("idCanzone")));
		JSONObject canzoneJSON = new JSONObject(canzone,true);
		
		PrintWriter out = response.getWriter();
		out.println(canzoneJSON.toString());
	}

}
