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
	public Connection getConexion() {
		
		Connection con = null;
		try {
			String url = "jdbc:mysql://localhost:3306/javaprojectdb?useSSL=false&useTimezone=true&serverTimezone=UTC";
			String usr = "root";
			String psw = "Hacker$ensual";
			con = DriverManager.getConnection(url, usr, psw);
		} catch (SQLException e) {
			System.out.println("Error >> de conexión con la BD" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error >> general : " + e.getMessage());
		} 
		return con;
	}

}
