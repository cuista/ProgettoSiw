package persistence.dao;

import java.util.List;

import model.Object1;

public interface Object1Dao
{
	public void save(Object1 object1);
	public Object1 findByPrimaryKey(Long id);
	public List<Object1> findAll();
	public void update(Object1 object1);
	public void delete(Object1 object1);
}
