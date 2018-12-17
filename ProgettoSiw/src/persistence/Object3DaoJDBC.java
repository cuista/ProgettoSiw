package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Object3;
import persistence.dao.Object3Dao;

public class Object3DaoJDBC implements Object3Dao
{
	private DataSource dataSource;

	public Object3DaoJDBC(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}

	@Override
	public void save(Object3 object3)
	{
		Connection connection = this.dataSource.getConnection();
		try
		{
			Long id = IdBroker.getId(connection);
			object3.setId(id);
			String insert = "insert into object3(id, attribute) values (?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setLong(1, object3.getId());
			statement.setInt(2, object3.getAttribute());

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
	public Object3 findByPrimaryKey(Long id)
	{
		Connection connection = this.dataSource.getConnection();
		Object3 object3 = null;
		try
		{
			String insert = "select * from object3 where id=?";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setLong(1, id);
			ResultSet result = statement.executeQuery();
			if (result.next())
			{
				object3 = new Object3(result.getInt("attribute"));
				object3.setId(id);
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
		return object3;
	}

	@Override
	public List<Object3> findAll()
	{
		Connection connection = this.dataSource.getConnection();
		List<Object3> list_object3 = new LinkedList<>();
		try
		{
			String insert = "select * from object3";
			PreparedStatement statement = connection.prepareStatement(insert);
			ResultSet result = statement.executeQuery();
			while (result.next())
			{
				Object3 object3 = new Object3(result.getInt("attribute"));
				object3.setId(result.getLong("id"));

				list_object3.add(object3);
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
		return list_object3;
	}

	@Override
	public void update(Object3 object3)
	{
		Connection connection = this.dataSource.getConnection();
		try
		{
			String update = "update object3 SET attribute = ? WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setLong(1, object3.getAttribute());
			statement.setLong(2, object3.getId());
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
	public void delete(Object3 object3)
	{
		Connection connection = this.dataSource.getConnection();
		try
		{
			String delete = "delete FROM object3 WHERE id = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setLong(1, object3.getId());
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
