package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import model.Playlist;
import model.Utente;
import persistence.dao.UtenteDao;

public class UtenteDaoJDBC implements UtenteDao
{
	private DataSource dataSource;

	public UtenteDaoJDBC(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}

	@Override
	public void save(Utente utente)
	{
		Connection connection = this.dataSource.getConnection();
		try
		{
			String insert = "insert into utente(username, email, password, premium) values (?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setString(1, utente.getUsername());
			statement.setString(2, utente.getEmail());
			statement.setString(3, utente.getPassword());
			statement.setBoolean(4, utente.isPremium());
			this.updatePlaylistCondiviseDaUtente(utente, connection);
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
	public Utente findByPrimaryKey(String username)
	{
		Connection connection = this.dataSource.getConnection();
		Utente utente = null;
		try
		{
			PreparedStatement statement;
			String query = "select * from utente where username = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, username);
			ResultSet result = statement.executeQuery();
			if (result.next())
			{
				utente = new Utente(result.getString("username"), result.getString("email"), result.getString("password"), result.getBoolean("premium"));
				this.addPlaylistCondivise(utente,connection);
			}
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
		return utente;
	}

	@Override
	public List<Utente> findAll()
	{
		Connection connection = this.dataSource.getConnection();
		if(connection==null)System.out.println("è NULL findAll()");
		List<Utente> list_utente = new LinkedList<>();
		try
		{
			PreparedStatement statement;
			String query = "select * from utente";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next())
			{
				Utente utente = new Utente(result.getString("username"), result.getString("email"), result.getString("password"), result.getBoolean("premium"));
				this.addPlaylistCondivise(utente,connection);
				list_utente.add(utente);
			}
		} 
		catch (SQLException e)
		{
			throw new PersistenceException(e.getMessage());
		} 
		finally
		{
			try
			{
				connection.close();
			} catch (SQLException e)
			{
				throw new PersistenceException(e.getMessage());
			}
		}
		return list_utente;
	}
	
	@Override
	public Set<Playlist> getPlaylistCondiviseDaUtente(Utente utente)
	{
		Connection connection = this.dataSource.getConnection();
		Set<Playlist> list_playlistCondivise = new HashSet<>();
		try
		{
			for (Long id_playlistCondivisa : utente.getPlaylistCondivise())
			{	
				String insert = "select * FROM playlist WHERE id = ?";
				PreparedStatement statement = connection.prepareStatement(insert);
				statement.setLong(1, id_playlistCondivisa);
				ResultSet result = statement.executeQuery();
				if(result.next())
				{
					Playlist playlist = new Playlist(result.getString("nome"), utente);
					playlist.setId(result.getLong("id"));
					list_playlistCondivise.add(playlist);
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
		
		return list_playlistCondivise;
	}
	
	@Override
	public List<Playlist> getPlaylistCondiviseAltriUtenti(Utente utente)
	{		
		Connection connection = this.dataSource.getConnection();
		UtenteDao utenteDao= DatabaseManager.getInstance().getDaoFactory().getUtenteDAO();
		List<Playlist> list_playlistCondAltriUtenti = new LinkedList<>();
		try
		{
			String insertCondivisione = "select * FROM condivisione WHERE utente != ?";
			PreparedStatement statementCondivisione = connection.prepareStatement(insertCondivisione);
			statementCondivisione.setString(1, utente.getUsername());
			ResultSet resultCondivisione = statementCondivisione.executeQuery();
			while (resultCondivisione.next())
			{
				String insertPlaylist = "select * FROM playlist WHERE id = ?";
				PreparedStatement statementPlaylist = connection.prepareStatement(insertPlaylist);
				statementPlaylist.setLong(1, resultCondivisione.getLong("playlist"));
				ResultSet resultPlaylist = statementPlaylist.executeQuery();
				
				while (resultPlaylist.next())
				{
				Playlist playlist = new Playlist(resultPlaylist.getString("nome"), utenteDao.findByPrimaryKey(resultPlaylist.getString("utente")));
				playlist.setId(resultPlaylist.getLong("id"));

				list_playlistCondAltriUtenti.add(playlist);
				}
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
		return list_playlistCondAltriUtenti;
	}

	@Override
	public void update(Utente utente)
	{
		Connection connection = this.dataSource.getConnection();
		try
		{
			String update = "update utente SET email = ?, password = ?, premium = ? WHERE username = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(1, utente.getEmail());
			statement.setString(2, utente.getPassword());
			statement.setBoolean(3, utente.isPremium());
			statement.setString(4, utente.getUsername());
			this.updatePlaylistCondiviseDaUtente(utente, connection);
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
	public void delete(Utente utente)
	{
		Connection connection = this.dataSource.getConnection();
		try
		{
			String delete = "delete FROM utente WHERE username = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setString(1, utente.getUsername());
			connection.setAutoCommit(false);
			connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			this.removeForeignKeyDaPlaylist(utente, connection);
			this.removeForeignKeyDaCondivisione(utente, connection);
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
	
	private void addPlaylistCondivise(Utente utente, Connection connection)  throws SQLException
	{
		Set<Long> playlistCondivise = new HashSet<>();
		String query = "select playlist FROM condivisione WHERE utente = ?";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, utente.getUsername());
		ResultSet result = statement.executeQuery();
		while(result.next())
		{
			playlistCondivise.add(result.getLong("playlist"));
		}
		utente.setPlaylistCondivise(playlistCondivise);
	}
	
	private void removeForeignKeyDaPlaylist(Utente utente, Connection connection) throws SQLException 
	{	
		for (Long id_playlistCondivisa : utente.getPlaylistCondivise())
		{
			String condivisione = "update condivisione SET utente = NULL WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(condivisione);
			statement.setLong(1, id_playlistCondivisa);
			statement.executeUpdate();
		}
	}
	
	private void removeForeignKeyDaCondivisione(Utente utente, Connection connection) throws SQLException 
	{	
		String playlist = "update playlist SET utente = NULL WHERE utente = ? ";
		PreparedStatement statement = connection.prepareStatement(playlist);
		statement.setString(1, utente.getUsername());
		statement.executeUpdate();
	}
	
	private void updatePlaylistCondiviseDaUtente(Utente utente, Connection connection) throws SQLException
	{	
		for (Long id_playlistCondivisa : utente.getPlaylistCondivise())
		{	
			String presenzaPlaylistCondivisa = "select playlist FROM condivisione WHERE utente = ? AND playlist = ?";
			PreparedStatement statement = connection.prepareStatement(presenzaPlaylistCondivisa);
			statement.setString(1,utente.getUsername());
			statement.setLong(2,id_playlistCondivisa);
			ResultSet result = statement.executeQuery();
			if(!result.next())
			{
				Long id = IdBroker.getId(connection);
				String aggiungiCanzone = "insert into condivisione(id, utente, playlist) values (?,?,?)";
				PreparedStatement statementAggiungiCanzone = connection.prepareStatement(aggiungiCanzone);
				statementAggiungiCanzone.setLong(1,id);
				statementAggiungiCanzone.setString(2,utente.getUsername());
				statementAggiungiCanzone.setLong(3,id_playlistCondivisa);
				statementAggiungiCanzone.executeUpdate();
			}
		}
	}
}
