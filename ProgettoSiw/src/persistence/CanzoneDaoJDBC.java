package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Canzone;
import persistence.dao.CanzoneDao;

public class CanzoneDaoJDBC implements CanzoneDao
{
	private DataSource dataSource;

	public CanzoneDaoJDBC(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}

	@Override
	public void save(Canzone canzone)
	{
		Connection connection = this.dataSource.getConnection();
		try
		{
			Long id = IdBroker.getId(connection);
			canzone.setId(id);
			String insert = "insert into canzone(id, titolo, durata) values (?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setLong(1, canzone.getId());
			statement.setString(2, canzone.getTitolo());
			statement.setFloat(3, canzone.getDurata());

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
	public Canzone findByPrimaryKey(Long id)
	{
		Connection connection = this.dataSource.getConnection();
		Canzone canzone=null;
		try
		{
			String insert = "select * from canzone where id=?";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setLong(1, id);
			ResultSet result = statement.executeQuery();
			if (result.next())
			{
				canzone = new Canzone(result.getString("titolo"),result.getFloat("durata"));
				canzone.setId(id);
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
		return canzone;
	}

	@Override
	public List<Canzone> findAll()
	{
		Connection connection = this.dataSource.getConnection();
		List<Canzone> list_canzone=new LinkedList<>();
		try
		{
			String insert = "select * from canzone";
			PreparedStatement statement = connection.prepareStatement(insert);
			ResultSet result = statement.executeQuery();
			while (result.next())
			{
				Canzone canzone = new Canzone(result.getString("titolo"),result.getFloat("durata"));
				canzone.setId(result.getLong("id"));
				
				list_canzone.add(canzone);
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
		return list_canzone;
	}

	@Override
	public void update(Canzone canzone)
	{
		Connection connection = this.dataSource.getConnection();
		try
		{
			String update = "update canzone SET titolo = ?, durata = ? WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(1, canzone.getTitolo());
			statement.setFloat(2, canzone.getDurata());	
			statement.setLong(3, canzone.getId());
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
	public void delete(Canzone canzone)
	{
		Connection connection = this.dataSource.getConnection();
		try
		{
			String delete = "delete FROM canzone WHERE id = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setLong(1, canzone.getId());
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
