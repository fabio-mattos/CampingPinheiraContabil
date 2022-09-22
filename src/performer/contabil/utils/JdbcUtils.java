package performer.contabil.utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.salmonllc.sql.DBConnection;

public class JdbcUtils {
	
	public static void closeQuietly(DBConnection con) {
		if(con != null) {
			try {
				con.freeConnection();
			} catch (Exception e) {
				// NOOP
			}
		}
	}

	public static void closeQuietly(PreparedStatement stmt) {
		if(stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// NOOP
			}
		}
	}
	
	public static void closeQuietly(ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				// NOOP
			}
		}
	}
	
}
