package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataBaseCP {

	private String DB_PATH = "data\\";

	public Connection getConnection(String databaseName) {

		String engine = "jdbc:sqlite";

		String connectionString = engine + ":" + DB_PATH + databaseName;

		try {
			Connection dbConnection = DriverManager.getConnection(connectionString);
			return dbConnection;
		} catch (SQLException ex) {
			Logger.getLogger(DataBaseCP.class.getName()).log(Level.SEVERE, null, ex);
			return null;

		}

	}

}
