package model;

public class Playlist
{
	private Long id;
	private String nome;
	
	public Playlist(String nome)
	{
		this.setNome(nome);
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
}
