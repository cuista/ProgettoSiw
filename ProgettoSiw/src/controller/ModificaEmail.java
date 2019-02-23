package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Utente;
import persistence.DatabaseManager;
import persistence.dao.UtenteDao;

@WebServlet("/ModificaEmail")
public class ModificaEmail extends HttpServlet
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		doPost(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String nuovaEmail=req.getParameter("nuovaEmail");
		
		HttpSession session=req.getSession();
		UtenteDao utenteDao=DatabaseManager.getInstance().getDaoFactory().getUtenteDAO();
		Utente utente=(Utente) session.getAttribute("user");
		
		//aggiorno utente
		utente.setEmail(nuovaEmail);
		utenteDao.update(utente);
		
		//aggiorno sessione
		session.removeAttribute("user");
		session.setAttribute("user",utente);
		
		//reindirizzo la pagina
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/gestioneUtente.jsp");
		dispatcher.forward(req, resp);
	}

}
