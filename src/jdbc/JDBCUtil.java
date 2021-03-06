package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
	
	public static void close(ResultSet rs) {
		if (rs != null) {
			try { rs.close(); } catch (SQLException ex) {}
		}
	}

	public static void close(Statement state) {
		if (state != null) {
			try { state.close(); } catch (SQLException ex) {}
		}
	}

	public static void close(Connection conn) {
		if (conn != null) {
			try { conn.close(); } catch (SQLException ex) {}
		}
	}

	public static void rollback(Connection conn) {
		if (conn != null) {
			try { conn.rollback(); } catch (SQLException ex) {}
		}
	}
	
}