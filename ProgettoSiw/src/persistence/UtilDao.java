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
							+ "drop table if exists utente;"
							+ "drop table if exists object1;" 
							+ "drop table if exists object2;"
							+ "drop table if exists object3;";
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

			String delete = "create SEQUENCE sequenza_id;"
					+ "create table utente (\"username\" varchar(255) primary key, email varchar(255), password varchar(255));"
					+ "create table object1 (\"id\" bigint primary key, attribute int);"
					+ "create table object2 (\"id\" bigint primary key, attribute int);"
					+ "create table object3 (\"id\" bigint primary key, attribute int);";

			PreparedStatement statement = connection.prepareStatement(delete);

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
