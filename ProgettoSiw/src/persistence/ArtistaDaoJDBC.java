package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Artista;
import persistence.dao.ArtistaDao;

public class ArtistaDaoJDBC implements ArtistaDao
{
	private DataSource dataSource;

	public ArtistaDaoJDBC(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}

	@Override
	public void save(Artista artista)
	{
		Connection connection = this.dataSource.getConnection();
		try
		{
			Long id = IdBroker.getId(connection);
			artista.setId(id);
			String insert = "insert into artista(id, nome, paese, immagine) values (?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setLong(1, artista.getId());
			statement.setString(2, artista.getNome());
			statement.setString(3, artista.getPaese());
			statement.setString(4, artista.getImmagine());
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
	public Artista findByPrimaryKey(Long id)
	{
		Connection connection = this.dataSource.getConnection();
		Artista artista = null;
		try
		{
			String insert = "select * from artista where id=?";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setLong(1, id);
			ResultSet result = statement.executeQuery();
			if (result.next())
			{
				artista = new Artista(result.getString("nome"),result.getString("paese"),result.getString("immagine"));
				artista.setId(id);
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
		return artista;
	}

	@Override
	public List<Artista> findAll()
	{
		Connection connection = this.dataSource.getConnection();
		List<Artista> list_artista = new LinkedList<>();
		try
		{
			String insert = "select * from artista";
			PreparedStatement statement = connection.prepareStatement(insert);
			ResultSet result = statement.executeQuery();
			while (result.next())
			{
				Artista artista = new Artista(result.getString("nome"),result.getString("paese"),result.getString("immagine"));
				artista.setId(result.getLong("id"));

				list_artista.add(artista);
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
		return list_artista;
	}

	@Override
	public void update(Artista artista)
	{
		Connection connection = this.dataSource.getConnection();
		try
		{
			String update = "update artista SET nome = ?, paese = ?, immagine = ? WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(1, artista.getNome());
			statement.setString(2, artista.getPaese());
			statement.setString(3, artista.getImmagine());
			statement.setLong(4, artista.getId());
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
	public void delete(Artista artista)
	{
		Connection connection = this.dataSource.getConnection();
		try
		{
			String delete = "delete FROM artista WHERE id = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setLong(1, artista.getId());
			connection.setAutoCommit(false);
			connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			statement.executeUpdate();
			this.removeForeignKeyDaAlbum(artista,connection);
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
	
	private void removeForeignKeyDaAlbum(Artista artista, Connection connection) throws SQLException 
	{	
		String playlist = "update album SET artista = NULL WHERE artista = ? ";
		PreparedStatement statement = connection.prepareStatement(playlist);
		statement.setLong(1, artista.getId());
		statement.executeUpdate();
	}
}
