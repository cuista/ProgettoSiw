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
	private Set<Long> canzoni = new LinkedHashSet<>();
	private List<Long> canzoniDaEliminare = new LinkedList<>();
	private List<Long> canzoniDaAggiungere = new LinkedList<>();
	
	
	public Playlist(String nome, Utente utente)
	{
		this.setNome(nome);
		this.setUtente(utente);
		this.canzoni = new LinkedHashSet<>();
		this.canzoniDaEliminare = new LinkedList<>();
		this.canzoniDaAggiungere = new LinkedList<>();
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

	public Set<Long> getCanzoni()
	{
		return canzoni;
	}
	
	public void setCanzoni(Set<Long> canzoni)
	{
		canzoniDaAggiungere.clear();
		canzoniDaEliminare.clear();
		this.canzoni=canzoni;
	}
	
	public void removeCanzone(Long id_canzone)
	{
		this.canzoniDaEliminare.add(id_canzone);
		this.canzoni.remove(id_canzone);
	}
	
	public void addCanzone(Long id_canzone)
	{
		this.canzoniDaAggiungere.add(id_canzone);
		this.canzoni.add(id_canzone);
	}
	
	public List<Long> getCanzoniDaEliminare()
	{
		return canzoniDaEliminare;
	}
	
	public List<Long> getCanzoniDaAggiungere()
	{
		return canzoniDaAggiungere;
	}
}
