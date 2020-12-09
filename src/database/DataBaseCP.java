package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseCP {

	private final String DB_PATH = "data\\";

	public Connection getConnection(String databaseName) throws SQLException {

		String engine = "jdbc:sqlite";

		String connectionString = engine + ":" + DB_PATH + databaseName;


		Connection dbConnection = DriverManager.getConnection(connectionString);
		return dbConnection;

	}

	public Connection getConnectionFromCustomPath(String customPath) throws SQLException {

		String engine = "jdbc:sqlite";

		String connectionString = engine + ":" + customPath;

		Connection dbConnection = DriverManager.getConnection(connectionString);
		return dbConnection;

	}

}
