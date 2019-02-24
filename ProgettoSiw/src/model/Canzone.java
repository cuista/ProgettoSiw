package model;

public class Canzone
{
	private Long id;
	private String titolo;
	private float durata;
	private Album album;
	private String audio;

	public Canzone(String titolo, float durata, Album album, String audio)
	{
		this.titolo = titolo;
		this.durata = durata;
		this.album = album;
		this.audio = audio;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getTitolo()
	{
		return titolo;
	}

	public void setTitolo(String titolo)
	{
		this.titolo = titolo;
	}

	public float getDurata()
	{
		return durata;
	}

	public void setDurata(float durata)
	{
		this.durata = durata;
	}

	public Album getAlbum()
	{
		return album;
	}

	public void setAlbum(Album album)
	{
		this.album = album;
	}

	public String getAudio()
	{
		return audio;
	}

	public void setAudio(String audio)
	{
		this.audio = audio;
	}
}
