package model;

public class Object3
{
	private Long id;
	private int attribute;

	public Object3(int attribute)
	{
		this.attribute = attribute;
	}
	
	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public int getAttribute()
	{
		return attribute;
	}

	public void setAttribute(int attribute)
	{
		this.attribute = attribute;
	}
}
