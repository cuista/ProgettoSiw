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
import model.Playlist;
import model.Utente;
import persistence.dao.AlbumDao;
import persistence.dao.PlaylistDao;
import persistence.dao.UtenteDao;

public class PlaylistDaoJDBC implements PlaylistDao
{
	private DataSource dataSource;

	public PlaylistDaoJDBC(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}

	@Override
	public void save(Playlist playlist)
	{
		Connection connection = this.dataSource.getConnection();
		try
		{
			Long id = IdBroker.getId(connection);
			playlist.setId(id);
			String insert = "insert into playlist(id, nome, utente) values (?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setLong(1, playlist.getId());
			statement.setString(2, playlist.getNome());
			statement.setString(3, playlist.getUtente().getUsername());
			this.updateCanzoniDiPlaylist(playlist,connection);
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
	public Playlist findByPrimaryKey(Long id)
	{
		Connection connection = this.dataSource.getConnection();
		UtenteDao utenteDao=DatabaseManager.getInstance().getDaoFactory().getUtenteDAO();
		Playlist playlist = null;
		try
		{
			String insert = "select * from playlist where id=?";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setLong(1, id);
			ResultSet result = statement.executeQuery();
			if (result.next())
			{
				playlist = new Playlist(result.getString("nome"), utenteDao.findByPrimaryKey(result.getString("utente")));
				playlist.setId(id);
				this.addCanzoni(playlist,connection);
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
		return playlist;
	}

	@Override
	public List<Playlist> findAll()
	{
		Connection connection = this.dataSource.getConnection();
		UtenteDao utenteDao=DatabaseManager.getInstance().getDaoFactory().getUtenteDAO();
		List<Playlist> list_playlist = new LinkedList<>();
		try
		{
			String insert = "select * from playlist";
			PreparedStatement statement = connection.prepareStatement(insert);
			ResultSet result = statement.executeQuery();
			while (result.next())
			{
				Playlist playlist = new Playlist(result.getString("nome"), utenteDao.findByPrimaryKey(result.getString("utente")));
				playlist.setId(result.getLong("id"));
				this.addCanzoni(playlist,connection);
				list_playlist.add(playlist);
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
		return list_playlist;
	}
	
	@Override
	public Set<Canzone> getCanzoniDiPlaylist(Playlist playlist)
	{
		AlbumDao albumDao=DatabaseManager.getInstance().getDaoFactory().getAlbumDAO();
		Connection connection = this.dataSource.getConnection();
		Set<Canzone> canzoni = new HashSet<>();
		try
		{
			for (Long id_canzone : playlist.getCanzoni())
			{	
				String insert = "select * FROM canzone WHERE id = ?";
				PreparedStatement statement = connection.prepareStatement(insert);
				statement.setLong(1, id_canzone);
				ResultSet result = statement.executeQuery();
				if(result.next())
				{
					Canzone canzone = new Canzone(result.getString("titolo"), result.getFloat("durata"), albumDao.findByPrimaryKey(result.getLong("album")),result.getString("audio"));
					canzone.setId(result.getLong("id"));
					canzoni.add(canzone);
				}
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
	public List<Playlist> getPlaylistUtente(Utente utente)
	{
		Connection connection = this.dataSource.getConnection();
		List<Playlist> list_playlist = new LinkedList<>();
		try
		{
			String insert = "select * FROM playlist WHERE utente = ?";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setString(1, utente.getUsername());
			ResultSet result = statement.executeQuery();
			while (result.next())
			{
				Playlist playlist = new Playlist(result.getString("nome"), utente);
				playlist.setId(result.getLong("id"));
				this.addCanzoni(playlist,connection);
				list_playlist.add(playlist);
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
		return list_playlist;
	}

	@Override
	public void update(Playlist playlist)
	{
		Connection connection = this.dataSource.getConnection();
		try
		{
			String update = "update playlist SET nome = ? WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(1, playlist.getNome());
			statement.setLong(2, playlist.getId());
			this.updateCanzoniDiPlaylist(playlist,connection);
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
	public void delete(Playlist playlist)
	{
		Connection connection = this.dataSource.getConnection();
		try
		{
			String delete = "delete FROM playlist WHERE id = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setLong(1, playlist.getId());
			connection.setAutoCommit(false);
			connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			this.deletePlaylistDaUtente(playlist, connection);
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
	
	private void addCanzoni(Playlist playlist, Connection connection)  throws SQLException
	{
		Set<Long> canzoni = new HashSet<>();
		String query = "select canzone FROM raccolta WHERE playlist = ?";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setLong(1, playlist.getId());
		ResultSet result = statement.executeQuery();
		while(result.next())
		{
			canzoni.add(result.getLong("canzone"));
		}
		playlist.setCanzoni(canzoni);
	}

	private void updateCanzoniDiPlaylist(Playlist playlist, Connection connection) throws SQLException
	{
		for (Long id_canzoneDaEliminare : playlist.getCanzoniDaEliminare())
		{	
			String eliminazioneCanzone = "delete FROM raccolta WHERE playlist=? AND canzone=?";
			PreparedStatement statement = connection.prepareStatement(eliminazioneCanzone);
			statement.setLong(1, playlist.getId());
			statement.setLong(2, id_canzoneDaEliminare);
			statement.executeUpdate();
		}
		playlist.getCanzoniDaEliminare().clear();
		
		for (Long id_canzoneDaAggiungere : playlist.getCanzoniDaAggiungere())
		{
			String presenzaCanzone = "select id FROM raccolta WHERE canzone=? AND playlist=?";
			PreparedStatement statement = connection.prepareStatement(presenzaCanzone);
			statement.setLong(1, id_canzoneDaAggiungere);
			statement.setLong(2, playlist.getId());
			ResultSet result = statement.executeQuery();
			if(!result.next())
			{			
				Long id = IdBroker.getId(connection);
				String aggiungiCanzone = "insert into raccolta(id, canzone, playlist) values (?,?,?)";
				PreparedStatement statementAggiungiCanzone = connection.prepareStatement(aggiungiCanzone);
				statementAggiungiCanzone.setLong(1,id);
				statementAggiungiCanzone.setLong(2,id_canzoneDaAggiungere);
				statementAggiungiCanzone.setLong(3,playlist.getId());
				statementAggiungiCanzone.executeUpdate();
			}
		}
		playlist.getCanzoniDaAggiungere().clear();
	}
	
	private void deletePlaylistDaUtente(Playlist playlist, Connection connection) throws SQLException
	{
		String deleteCondivisione = "delete FROM condivisione WHERE playlist = ? ";
		PreparedStatement statement1 = connection.prepareStatement(deleteCondivisione);
		statement1.setLong(1, playlist.getId());
		statement1.executeUpdate();
		
		String deleteRaccolta = "delete FROM raccolta WHERE playlist = ? ";
		PreparedStatement statement2 = connection.prepareStatement(deleteRaccolta);
		statement2.setLong(1, playlist.getId());
		statement2.executeUpdate();
		
		playlist.getCanzoni().clear();
		playlist.getCanzoniDaAggiungere().clear();
		playlist.getCanzoniDaEliminare().clear();
	}
}
