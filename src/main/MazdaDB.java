package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MazdaDB {

	private static MazdaDB instance;

	public static MazdaDB getInstance() {
		if (instance == null) {
			instance = new MazdaDB();
		}
		return instance;
	}

	private MazdaDB() {

	}

	public String welcome(String str) throws SQLException {

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:db/Mazda.db");
			con.setAutoCommit(false);

			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM " + str);

			while (rs.next()) {
				String welcome = rs.getString("welcome");
				return welcome;
			}

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		} finally {
			rs.close();
			stmt.close();
			con.close();
		}
		return null;

	}

	public String fromDB(String nameDB, String nameField) throws SQLException {

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:db/Mazda.db");
			con.setAutoCommit(false);

			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM " + nameDB);

			while (rs.next()) {
				String res = rs.getString(nameField);
				return res;
			}

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		} finally {
			rs.close();
			stmt.close();
			con.close();
		}
		return null;
	}

	public String inDB(String nameDB, String nameField, String value) {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:db/Mazda.db");
			c.setAutoCommit(false);

			stmt = c.createStatement();
			String sql = "UPDATE " + nameDB + " set " + nameField + " = "
					+ value;
			stmt.executeUpdate(sql);
			c.commit();

			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return null;
	}

	public int inDB(String nameDB, String nameField, int value) {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:db/Mazda.db");
			c.setAutoCommit(false);

			stmt = c.createStatement();
			String sql = "UPDATE " + nameDB + " set " + nameField + " = "
					+ value;
			stmt.executeUpdate(sql);
			c.commit();

			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return value;
	}

}
