package persistence.dao;

import java.util.List;

import model.Object2;

public interface Object2Dao
{
	public void save(Object2 object2);
	public Object2 findByPrimaryKey(Long id);
	public List<Object2> findAll();
	public void update(Object2 object2);
	public void delete(Object2 object2);
}
