package controller;

import java.io.IOException;
import java.io.PrintWriter;

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

@WebServlet("/ModificaPassword")
public class ModificaPassword extends HttpServlet
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
		String passwordPrecedente=req.getParameter("passwordPrecedente");
		String confermaPasswordPrecedente=req.getParameter("confermaPasswordPrecedente");
		String nuovaPassword=req.getParameter("nuovaPassword");
		
		PrintWriter out = resp.getWriter();
		if(!passwordPrecedente.equals(confermaPasswordPrecedente))
		{
			out.print("le password precedenti non corrispondono");
			return;
		}
		
		HttpSession session=req.getSession();
		UtenteDao utenteDao=DatabaseManager.getInstance().getDaoFactory().getUtenteDAO();
		Utente utente=(Utente) session.getAttribute("user");
		
		if(!(utente.getPassword().equals(passwordPrecedente)))
		{
			out.print("la password precedente inserita non è corretta");
			return;
		}
		
		//aggiorno utente
		utente.setPassword(nuovaPassword);
		utenteDao.update(utente);
		
		//aggiorno sessione
		session.removeAttribute("user");
		session.setAttribute("user",utente);
		
		//reindirizzo la pagina
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/gestioneUtente.jsp");
		dispatcher.forward(req, resp);
		
	}

}
