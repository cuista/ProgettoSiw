package model;

import java.util.Set;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

public class Playlist
{
	private Long id;
	private String nome;
	private Utente utente;
	private Set<Canzone> canzoni;
	private List<Canzone> canzoniDaEliminare;
	private List<Canzone> canzoniDaAggiungere;
	
	
	public Playlist(String nome, Utente utente)
	{
		this.setNome(nome);
		this.setUtente(utente);
		this.canzoni = new LinkedHashSet<>();
		this.canzoniDaEliminare=new LinkedList<>();
		this.canzoniDaAggiungere=new LinkedList<>();
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public Utente getUtente()
	{
		return utente;
	}

	public void setUtente(Utente utente)
	{
		this.utente = utente;
	}

	public Set<Canzone> getCanzoni()
	{
		return canzoni;
	}
	
	public void removeCanzone(Canzone canzone)
	{
		this.canzoniDaEliminare.add(canzone);
		this.canzoni.add(canzone);
	}
	
	public void addCanzone(Canzone canzone)
	{
		this.canzoniDaAggiungere.add(canzone);
		this.canzoni.add(canzone);
	}
	
	public List<Canzone> getCanzoniDaEliminare()
	{
		return canzoniDaEliminare;
	}
	
	public List<Canzone> getCanzoniDaAggiungere()
	{
		return canzoniDaAggiungere;
	}
}
