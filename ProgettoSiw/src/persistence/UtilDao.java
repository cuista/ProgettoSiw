package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UtilDao
{

	private DataSource dataSource;

	public UtilDao(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}

	public void dropDatabase()
	{
		Connection connection = dataSource.getConnection();
		try
		{
			String delete = "drop SEQUENCE if EXISTS sequenza_id;"
							+ "drop table if exists raccolta;"
							+ "drop table if exists condivisione;"
							+ "drop table if exists playlist;"
							+ "drop table if exists utente;"
							+ "drop table if exists canzone;"
							+ "drop table if exists album;" 
							+ "drop table if exists artista;";
			PreparedStatement statement = connection.prepareStatement(delete);

			statement.executeUpdate();
			System.out.println("Executed drop database");

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

	public void createDatabase()
	{

		Connection connection = dataSource.getConnection();
		try
		{

			String create = "create SEQUENCE sequenza_id;"
					+ "create table artista (\"id\" bigint primary key, nome varchar(255), paese varchar(255));"
					+ "create table album (\"id\" bigint primary key, titolo varchar(255), anno int, genere varchar(255), artista bigint REFERENCES artista(\"id\"));"
					+ "create table canzone (\"id\" bigint primary key, titolo varchar(255), durata float, album bigint REFERENCES album(\"id\"));"
					+ "create table utente (\"username\" varchar(255) primary key, email varchar(255), password varchar(255), premium boolean);"
					+ "create table playlist (\"id\" bigint primary key, nome varchar(255), utente varchar(255) REFERENCES utente(\"username\"));"
					+ "create table raccolta (\"id\" bigint primary key, canzone bigint REFERENCES canzone(\"id\"), playlist bigint REFERENCES playlist(\"id\"));"
					+ "create table condivisione (\"id\" bigint primary key, utente varchar(255) REFERENCES utente(\"username\"), playlist bigint REFERENCES playlist(\"id\"));";

			PreparedStatement statement = connection.prepareStatement(create);

			statement.executeUpdate();
			System.out.println("Executed create database");

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

	public void resetDatabase()
	{

		/*
		 * Connection connection = dataSource.getConnection(); try { String delete =
		 * "delete FROM user"; PreparedStatement statement =
		 * connection.prepareStatement(delete);
		 * 
		 * statement.executeUpdate();
		 * 
		 * delete = "delete FROM object1"; statement =
		 * connection.prepareStatement(delete);
		 * 
		 * delete = "delete FROM object2"; statement =
		 * connection.prepareStatement(delete);
		 * 
		 * delete = "delete FROM object3"; statement =
		 * connection.prepareStatement(delete);
		 * 
		 * statement.executeUpdate(); } catch (SQLException e) {
		 * 
		 * throw new PersistenceException(e.getMessage()); } finally { try {
		 * connection.close(); } catch (SQLException e) {
		 * 
		 * throw new PersistenceException(e.getMessage()); } }
		 */
	}
}
