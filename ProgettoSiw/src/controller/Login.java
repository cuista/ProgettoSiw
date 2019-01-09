package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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

@WebServlet("/Login")
public class Login extends  HttpServlet
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
		HttpSession sessione=req.getSession();

		UtenteDao utenteDao=DatabaseManager.getInstance().getDaoFactory().getUtenteDAO();

		sessione.removeAttribute("user");

		String email= req.getParameter("email");
		String password= req.getParameter("password");

		List<Utente> utenti=utenteDao.findAll();

		for (Utente utente:utenti)
		{
			if (email.equals(utente.getEmail()) && password.equals(utente.getPassword()))
			{
				sessione.setAttribute("user", utente);
				break;
			}
		}

		PrintWriter out = resp.getWriter();
		if(sessione.getAttribute("user") == null)
		{
			out.print("fallito");
		}
		else
		{
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/loginSuccesso.jsp");
			dispatcher.forward(req, resp);
		}
	}

}
