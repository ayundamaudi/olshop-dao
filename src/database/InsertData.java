package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class InsertData {
	public static void main(String[] args) throws SQLException {
		String URL = "jdbc:mysql://localhost:3306/db_onlinestore";
		String USER = "root";
		String PWD = "";
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(URL, USER, PWD);
			System.out.println(conn);
			
			String sql = "insert into tb_brand(brand) values(?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			
			pst.setString(1, "Nokiaa");
			int affectedRow = pst.executeUpdate();
			
			System.out.println(affectedRow +" records inserted");
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			conn.close();
		}
	}
}
