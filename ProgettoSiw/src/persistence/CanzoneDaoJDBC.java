package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import model.Canzone;
import persistence.dao.AlbumDao;
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
			String insert = "insert into canzone(id, titolo, durata, album, audio) values (?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setLong(1, canzone.getId());
			statement.setString(2, canzone.getTitolo());
			statement.setFloat(3, canzone.getDurata());
			statement.setLong(4, canzone.getAlbum().getId());
			statement.setString(5, canzone.getAudio());
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
		AlbumDao albumDao = DatabaseManager.getInstance().getDaoFactory().getAlbumDAO();
		Canzone canzone=null;
		try
		{
			String insert = "select * from canzone where id=?";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setLong(1, id);
			ResultSet result = statement.executeQuery();
			if (result.next())
			{
				canzone = new Canzone(result.getString("titolo"),result.getFloat("durata"),albumDao.findByPrimaryKey(result.getLong("album")),result.getString("audio"));
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
		AlbumDao albumDao = DatabaseManager.getInstance().getDaoFactory().getAlbumDAO();
		List<Canzone> list_canzone=new LinkedList<>();
		try
		{
			String insert = "select * from canzone";
			PreparedStatement statement = connection.prepareStatement(insert);
			ResultSet result = statement.executeQuery();
			while (result.next())
			{
				Canzone canzone = new Canzone(result.getString("titolo"),result.getFloat("durata"),albumDao.findByPrimaryKey(result.getLong("album")),result.getString("audio"));
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
	public Set<Canzone> getCanzoniDaAlbum(Long id_album)
	{
		AlbumDao albumDao = DatabaseManager.getInstance().getDaoFactory().getAlbumDAO();
		Connection connection = this.dataSource.getConnection();
		Set<Canzone> canzoni = new HashSet<>();
		try
		{
			String insert = "select * FROM canzone WHERE album = ?";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setLong(1, id_album);
			ResultSet result = statement.executeQuery();
			while(result.next())
			{
				Canzone canzone = new Canzone(result.getString("titolo"), result.getFloat("durata"), albumDao.findByPrimaryKey(id_album),result.getString("audio"));
				canzone.setId(result.getLong("id"));
				canzoni.add(canzone);
			}
		}
		catch (SQLException e)
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
		
		return canzoni;
	}
	
	@Override
	public Set<Canzone> getCanzoniDaPlaylist(Long id_playlist)
	{
		CanzoneDao canzoneDao = DatabaseManager.getInstance().getDaoFactory().getCanzoneDAO();
		Connection connection = this.dataSource.getConnection();
		Set<Canzone> canzoni = new HashSet<>();
		try
		{
			String insert = "select canzone FROM raccolta WHERE playlist = ?";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setLong(1, id_playlist);
			ResultSet result = statement.executeQuery();
			while(result.next())
			{
				canzoni.add(canzoneDao.findByPrimaryKey(result.getLong("canzone")));
			}
		}
		catch (SQLException e)
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
		
		return canzoni;
	}

	@Override
	public void update(Canzone canzone)
	{
		Connection connection = this.dataSource.getConnection();
		try
		{
			String update = "update canzone SET titolo = ?, durata = ?, album = ? audio = ? WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(1, canzone.getTitolo());
			statement.setFloat(2, canzone.getDurata());	
			statement.setLong(3, canzone.getAlbum().getId());
			statement.setString(4, canzone.getAudio());
			statement.setLong(5, canzone.getId());
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
			this.deleteDallePlaylistCanzone(canzone, connection);
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
	
	private void deleteDallePlaylistCanzone(Canzone canzone, Connection connection) throws SQLException 
	{	
		String delete = "delete FROM raccolta WHERE canzone = ? ";
		PreparedStatement statement = connection.prepareStatement(delete);
		statement.setLong(1, canzone.getId());
		statement.executeUpdate();
	}
}
