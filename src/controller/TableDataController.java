package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.DataBaseCP;
import model.DataModel;

public class TableDataController {

	private static String databaseName = "opticsTable.db";

	private static String tableName = "ops";

	private static String customDatabasePath;

	private static boolean useCustomPath = false;

	private static ArrayList<DataModel> dataList = new ArrayList<>();

	public static ArrayList<DataModel> getTableData() throws SQLException {

		dataList.clear();

		DataBaseCP dbp = new DataBaseCP();

		Connection dbConnection = useCustomPath ? dbp.getConnectionFromCustomPath(customDatabasePath) : dbp.getConnection(databaseName);

		String query = "select * from " + tableName;

		Statement stmt = dbConnection.createStatement();

		ResultSet resultSet = stmt.executeQuery(query);

		while (resultSet.next()) {

			DataModel dm = new DataModel(
					resultSet.getDouble("object_Distance"),
					resultSet.getDouble("object_Height"),
					resultSet.getDouble("focal_Point"),
					resultSet.getString("lens_TYPE"),
					resultSet.getInt("id"));

			dataList.add(dm);

		}

		return dataList;

	}

	public static void saveTableData(ArrayList<DataModel> data) throws SQLException {

		DataBaseCP dbp = new DataBaseCP();

		Connection dbConnection = useCustomPath ? dbp.getConnectionFromCustomPath(customDatabasePath) : dbp.getConnection(databaseName);

		String query = "INSERT INTO " + tableName
				+ " (object_Distance, object_Height, focal_Point, lens_TYPE, id) VALUES (?,?,?,?,?)";


		PreparedStatement prep = dbConnection.prepareStatement(query);
		for (DataModel d : data) {

			prep.setDouble(1, d.getObjectDistance());
			prep.setDouble(2, d.getObjectHeight());
			prep.setDouble(3, d.getFocalPoint());
			prep.setString(4, d.getLensType());
			prep.setInt(5, d.getId());

		}
		prep.executeUpdate();

	}

	public static void deleteEntry(double id) throws SQLException {

		DataBaseCP dbp = new DataBaseCP();

		Connection dbConnection = useCustomPath ? dbp.getConnectionFromCustomPath(customDatabasePath) : dbp.getConnection(databaseName);

		String query = "DELETE FROM " + tableName + " WHERE id=" + id;


		PreparedStatement prep = dbConnection.prepareStatement(query);

		prep.executeUpdate();

	}

	public static void setCustomDatabasePath(String path) {
		customDatabasePath = path;
	}

	public static void setUseCustomPath(boolean b) {
		useCustomPath = b;
	}

}
