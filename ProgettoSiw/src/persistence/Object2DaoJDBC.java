package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Object2;
import persistence.dao.Object2Dao;

public class Object2DaoJDBC implements Object2Dao
{
	private DataSource dataSource;

	public Object2DaoJDBC(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}

	@Override
	public void save(Object2 object2)
	{
		Connection connection = this.dataSource.getConnection();
		try
		{
			Long id = IdBroker.getId(connection);
			object2.setId(id);
			String insert = "insert into object2(id, attribute) values (?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setLong(1, object2.getId());
			statement.setInt(2, object2.getAttribute());

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
	public Object2 findByPrimaryKey(Long id)
	{
		Connection connection = this.dataSource.getConnection();
		Object2 object2 = null;
		try
		{
			String insert = "select * from object2 where id=?";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setLong(1, id);
			ResultSet result = statement.executeQuery();
			if (result.next())
			{
				object2 = new Object2(result.getInt("attribute"));
				object2.setId(id);
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
		return object2;
	}

	@Override
	public List<Object2> findAll()
	{
		Connection connection = this.dataSource.getConnection();
		List<Object2> list_object2 = new LinkedList<>();
		try
		{
			String insert = "select * from object2";
			PreparedStatement statement = connection.prepareStatement(insert);
			ResultSet result = statement.executeQuery();
			while (result.next())
			{
				Object2 object2 = new Object2(result.getInt("attribute"));
				object2.setId(result.getLong("id"));

				list_object2.add(object2);
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
		return list_object2;
	}

	@Override
	public void update(Object2 object2)
	{
		Connection connection = this.dataSource.getConnection();
		try
		{
			String update = "update object2 SET attribute = ? WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setLong(1, object2.getAttribute());
			statement.setLong(2, object2.getId());
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
	public void delete(Object2 object2)
	{
		Connection connection = this.dataSource.getConnection();
		try
		{
			String delete = "delete FROM object2 WHERE id = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setLong(1, object2.getId());
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
