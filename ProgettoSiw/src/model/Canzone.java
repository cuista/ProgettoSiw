package model;

public class Canzone
{
	private Long id;
	private String titolo;
	private float durata;

	public Canzone(String titolo, float durata)
	{
		this.titolo = titolo;
		this.durata = durata;
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
}
