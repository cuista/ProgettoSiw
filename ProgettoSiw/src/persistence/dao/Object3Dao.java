package persistence.dao;

import java.util.List;

import model.Object3;

public interface Object3Dao
{
	public void save(Object3 object3);
	public Object3 findByPrimaryKey(Long id);
	public List<Object3> findAll();
	public void update(Object3 object3);
	public void delete(Object3 object3);
}
