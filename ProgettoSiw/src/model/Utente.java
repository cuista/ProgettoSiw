package model;

public class Utente
{
	private String username;
	private String email;
	private String password;

	public Utente(String username, String email, String password)
	{
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public String getUsername()
	{
		return username;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

}
