package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConexion8 {
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Error >> Driver no Instalado: " + e.getMessage());
			e.printStackTrace();
		}
	}
	public static Connection getConexion() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3310/projectdb?serverTimezone=UTC";
			String user = "root";
			String password = "admin";
			connection = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("Error >> Driver no Instalado!!" + e.getMessage());
		} catch (SQLException e) {
			System.out.println("Error >> de conexión con la BD" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error >> general : " + e.getMessage());
		} 
		return connection;
	}

}
