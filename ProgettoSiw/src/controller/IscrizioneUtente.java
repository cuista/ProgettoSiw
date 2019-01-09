package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Utente;
import persistence.DatabaseManager;
import persistence.dao.UtenteDao;


/**
 * Servlet implementation class RegistraUtente
 */
@WebServlet("/IscrizioneUtente")
public class IscrizioneUtente extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String email = req.getParameter("email");
		String confermaEmail = req.getParameter("confermaEmail");
		String password = req.getParameter("password");
		String username = req.getParameter("username");
		
		PrintWriter out = resp.getWriter();
		if(!email.equals(confermaEmail))
		{
			out.print("le email non corrispondono"); //stampa su "/iscriviUtente"
			return;
		}
		
		UtenteDao utenteDao= DatabaseManager.getInstance().getDaoFactory().getUtenteDAO();
		List<Utente> utenti=utenteDao.findAll();	
		boolean usernameUguali= false, emailUguali = false;
		for (Iterator<Utente> it = utenti.iterator();it.hasNext() && !usernameUguali && !emailUguali;) 
		{
			Utente utenteTmp = it.next();
			if (utenteTmp.getUsername().equals(username) )
			{
				usernameUguali = true;
			}
			else if(utenteTmp.getEmail().equals(email))
			{
				emailUguali = true;
			}
		}
	
		if(emailUguali)
		{
			out.print("email già esistente");
			return;
		}
		else if(usernameUguali)
		{
			out.print("username già esistente");
			return;
		}

		//registriamo l'utente al db
		Utente utente=new Utente(username, email, password);
		utenteDao.save(utente);
		
		//logga l'utente alla pagina
		req.getSession().setAttribute("user", utente);
		
		//reindirizza alla pagina di "iscrizioneSuccesso.html"
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/iscrizioneSuccesso.jsp");
		dispatcher.forward(req, resp);
	}
}
	
