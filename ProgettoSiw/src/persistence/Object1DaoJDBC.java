package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Object1;
import persistence.dao.Object1Dao;

public class Object1DaoJDBC implements Object1Dao
{
	private DataSource dataSource;

	public Object1DaoJDBC(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}

	@Override
	public void save(Object1 object1)
	{
		Connection connection = this.dataSource.getConnection();
		try
		{
			Long id = IdBroker.getId(connection);
			object1.setId(id);
			String insert = "insert into object1(id, attribute) values (?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setLong(1, object1.getId());
			statement.setInt(2, object1.getAttribute());

			statement.executeUpdate();
		} catch (SQLException e)
		{
			if (connection != null)
			{
				try
				{
					connection.rollback();
				} catch (SQLException excep)
				{
					throw new PersistenceException(e.getMessage());
				}
			}
		} finally
		{
			try
			{
				connection.close();
			} catch (SQLException e)
			{
				throw new PersistenceException(e.getMessage());
			}
		}	
	}

	@Override
	public Object1 findByPrimaryKey(Long id)
	{
		Connection connection = this.dataSource.getConnection();
		Object1 object1=null;
		try
		{
			String insert = "select * from object1 where id=?";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setLong(1, id);
			ResultSet result = statement.executeQuery();
			if (result.next())
			{
				object1 = new Object1(result.getInt("attribute"));
				object1.setId(id);
			}
		} catch (SQLException e)
		{
			if (connection != null)
			{
				try
				{
					connection.rollback();
				} catch (SQLException excep)
				{
					throw new PersistenceException(e.getMessage());
				}
			}
		} finally
		{
			try
			{
				connection.close();
			} catch (SQLException e)
			{
				throw new PersistenceException(e.getMessage());
			}
		}
		return object1;
	}

	@Override
	public List<Object1> findAll()
	{
		Connection connection = this.dataSource.getConnection();
		List<Object1> list_object1=new LinkedList<>();
		try
		{
			String insert = "select * from object1";
			PreparedStatement statement = connection.prepareStatement(insert);
			ResultSet result = statement.executeQuery();
			while (result.next())
			{
				Object1 object1 = new Object1(result.getInt("attribute"));
				object1.setId(result.getLong("id"));
				
				list_object1.add(object1);
			}
		} catch (SQLException e)
		{
			if (connection != null)
			{
				try
				{
					connection.rollback();
				} catch (SQLException excep)
				{
					throw new PersistenceException(e.getMessage());
				}
			}
		} finally
		{
			try
			{
				connection.close();
			} catch (SQLException e)
			{
				throw new PersistenceException(e.getMessage());
			}
		}
		return list_object1;
	}

	@Override
	public void update(Object1 object1)
	{
		Connection connection = this.dataSource.getConnection();
		try
		{
			String update = "update object1 SET attribute = ? WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setLong(1, object1.getAttribute());		
			statement.setLong(2, object1.getId());
			statement.executeUpdate();
		} catch (SQLException e)
		{
			if (connection != null)
			{
				try
				{
					connection.rollback();
				} catch (SQLException excep)
				{
					throw new PersistenceException(e.getMessage());
				}
			}
		} finally
		{
			try
			{
				connection.close();
			} catch (SQLException e)
			{
				throw new PersistenceException(e.getMessage());
			}
		}
	}

	@Override
	public void delete(Object1 object1)
	{
		Connection connection = this.dataSource.getConnection();
		try
		{
			String delete = "delete FROM object1 WHERE id = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setLong(1, object1.getId());
			connection.setAutoCommit(false);
			connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			statement.executeUpdate();
			connection.commit();
		} catch (SQLException e)
		{
			throw new PersistenceException(e.getMessage());
		} finally
		{
			try
			{
				connection.close();
			} catch (SQLException e)
			{
				throw new PersistenceException(e.getMessage());
			}
		}
	}
}
