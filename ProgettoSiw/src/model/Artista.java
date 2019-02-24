package model;

public class Artista
{
	private Long id;
	private String nome;
	private String paese;
	private String immagine;

	public Artista(String nome, String paese, String immagine)
	{
		this.nome = nome;
		this.paese = paese;
		this.immagine = immagine;
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

	public String getPaese()
	{
		return paese;
	}

	public void setPaese(String paese)
	{
		this.paese = paese;
	}

	public String getImmagine()
	{
		return immagine;
	}

	public void setImmagine(String immagine)
	{
		this.immagine = immagine;
	}
}
