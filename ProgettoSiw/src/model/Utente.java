package model;

import java.util.HashSet;
import java.util.Set;

public class Utente
{
	private String username;
	private String email;
	private String password;
	private boolean premium;
	private Set<Playlist> playlistCondivise;

	public Utente(String username, String email, String password, boolean premium)
	{
		this.username = username;
		this.email = email;
		this.password = password;
		this.setPremium(premium);
		this.playlistCondivise = new HashSet<>();
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

	public boolean isPremium()
	{
		return premium;
	}

	public void setPremium(boolean premium)
	{
		this.premium = premium;
	}

	public Set<Playlist> getPlaylistCondivise()
	{
		return playlistCondivise;
	}

	public void addPlaylistCondivisa(Playlist playlist)
	{
		this.playlistCondivise.add(playlist);
	}

}
