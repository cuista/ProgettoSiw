package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Utente;
import persistence.DatabaseManager;
import persistence.dao.UtenteDao;

@WebServlet("/MettiUtentePremium")
public class MettiUtentePremium extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException ,ServletException
	{
		UtenteDao utenteDao = DatabaseManager.getInstance().getDaoFactory().getUtenteDAO();
		HttpSession sessione=request.getSession();
		Utente utente = (Utente) sessione.getAttribute("user");
		utente.setPremium(true);
		utenteDao.update(utente);
//		
//		PrintWriter out = response.getWriter();
//		out.println(?.toString());
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		UtenteDao utenteDao = DatabaseManager.getInstance().getDaoFactory().getUtenteDAO();
		HttpSession sessione=request.getSession();
		Utente utente = (Utente) sessione.getAttribute("user");
		utente.setPremium(true);
		utenteDao.update(utente);
//		
//		PrintWriter out = response.getWriter();
//		out.println(?.toString());
	}

}
