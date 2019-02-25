package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Utente;
import persistence.DatabaseManager;
import persistence.dao.UtenteDao;

@WebServlet("/LoginDaFacebookServlet")
public class LoginDaFacebookServlet extends HttpServlet
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		UtenteDao utenteDao= DatabaseManager.getInstance().getDaoFactory().getUtenteDAO();
		
		String nome=new String();
	
		if (request.getParameterNames().hasMoreElements()) 
		{
			String jsonString=request.getParameter("jsonUtenteFacebook").toString();

			if (jsonString != null) 
			{
				//parserizzo le informazioni di Utente
				String infoDaStringa[]=jsonString.split(":\"");
				String username=infoDaStringa[1].split("\"")[0];
				String email=infoDaStringa[2].split("\"")[0];
				String password=infoDaStringa[3].split("\"")[0];
				boolean premium=Boolean.parseBoolean(infoDaStringa[4].split("\"")[0]);
				
				//creo utente parserizzato
				Utente utente1 = new Utente(username, email, password, premium);
				HttpSession httpSession = request.getSession();
				
				List<Utente> utenti=utenteDao.findAll();
				
				boolean trovato=false,uguale=false;
				
				for (Utente utente2:utenti)
				{
					if (utente2.getUsername().equals(utente1.getUsername()))
					{
						trovato=true;
						break;
					}
					
					else if ((!utente2.getUsername().equals(utente1.getUsername()) && utente2.getEmail().equals(utente1.getEmail())))
					{
						uguale=true;
						nome=utente2.getUsername();
						break;
					}
				}
				
				if (trovato && !uguale)
				{
					httpSession.setAttribute("user", utente1);
					response.setStatus(HttpServletResponse.SC_OK);
				}
				
				else if (!trovato && uguale)
				{
					Utente ut1=utenteDao.findByPrimaryKey(nome);
					httpSession.setAttribute("user",ut1);
					response.setStatus(HttpServletResponse.SC_OK);
				}
				
				else if (!trovato || !uguale)
				{
					Utente ute=new Utente(utente1.getUsername(),utente1.getEmail(),utente1.getPassword(),utente1.isPremium());
					DatabaseManager.getInstance().getDaoFactory().getUtenteDAO().save(ute);
					
					//REGISTRAZIONE EFFETTUATA
					
					httpSession.setAttribute("user", utente1);
					response.setStatus(HttpServletResponse.SC_OK);
				}					
			}
		}
	}

}
