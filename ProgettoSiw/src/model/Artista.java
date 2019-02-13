package model;

public class Artista
{
	private Long id;
	private String nome;
	private String paese;

	public Artista(String nome, String paese)
	{
		this.nome = nome;
		this.paese = paese;
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
}
