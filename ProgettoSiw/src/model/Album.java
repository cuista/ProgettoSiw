package model;

public class Album
{
	private Long id;
	private String titolo;
	private int anno;
	private String genere;
	private Artista artista;
	private String immagine;

	public Album(String titolo, int anno, String genere, Artista artista, String immagine)
	{
		this.titolo = titolo;
		this.anno = anno;
		this.genere = genere;
		this.artista = artista;
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

	public String getTitolo()
	{
		return titolo;
	}

	public void setTitolo(String titolo)
	{
		this.titolo = titolo;
	}

	public int getAnno()
	{
		return anno;
	}

	public void setAnno(int anno)
	{
		this.anno = anno;
	}

	public String getGenere()
	{
		return genere;
	}

	public void setGenere(String genere)
	{
		this.genere = genere;
	}

	public Artista getArtista()
	{
		return artista;
	}

	public void setArtista(Artista artista)
	{
		this.artista = artista;
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
