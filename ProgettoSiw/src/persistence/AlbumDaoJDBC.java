package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Album;
import persistence.dao.AlbumDao;

public class AlbumDaoJDBC implements AlbumDao
{
	private DataSource dataSource;

	public AlbumDaoJDBC(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}

	@Override
	public void save(Album album)
	{
		Connection connection = this.dataSource.getConnection();
		try
		{
			Long id = IdBroker.getId(connection);
			album.setId(id);
			String insert = "insert into album(id, titolo, anno, genere) values (?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setLong(1, album.getId());
			statement.setString(2, album.getTitolo());
			statement.setInt(3, album.getAnno());
			statement.setString(4, album.getGenere());

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
	public Album findByPrimaryKey(Long id)
	{
		Connection connection = this.dataSource.getConnection();
		Album album = null;
		try
		{
			String insert = "select * from album where id=?";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setLong(1, id);
			ResultSet result = statement.executeQuery();
			if (result.next())
			{
				album = new Album(result.getString("titolo"),result.getInt("anno"),result.getString("genere"));
				album.setId(id);
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
		return album;
	}

	@Override
	public List<Album> findAll()
	{
		Connection connection = this.dataSource.getConnection();
		List<Album> list_album = new LinkedList<>();
		try
		{
			String insert = "select * from album";
			PreparedStatement statement = connection.prepareStatement(insert);
			ResultSet result = statement.executeQuery();
			while (result.next())
			{
				Album album = new Album(result.getString("titolo"),result.getInt("anno"),result.getString("genere"));
				album.setId(result.getLong("id"));

				list_album.add(album);
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
		return list_album;
	}

	@Override
	public void update(Album album)
	{
		Connection connection = this.dataSource.getConnection();
		try
		{
			String update = "update album SET titolo = ?, anno = ?, genere = ? WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(1, album.getTitolo());
			statement.setInt(2, album.getAnno());
			statement.setString(3, album.getGenere());
			statement.setLong(4, album.getId());
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
	public void delete(Album album)
	{
		Connection connection = this.dataSource.getConnection();
		try
		{
			String delete = "delete FROM album WHERE id = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setLong(1, album.getId());
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
