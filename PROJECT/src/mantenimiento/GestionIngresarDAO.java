package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.MySQLConexion8;

import arrayList.IngresarList;
import entidad.Ingresar;
import interfaces.IngresarInterfaceDAO;

public class GestionIngresarDAO implements  IngresarInterfaceDAO{
	IngresarList ingresarList = new IngresarList();
	Ingresar ingresar;
	
	public boolean login(String user, String password) {
		boolean login = false;
	
		Connection connection = null;
		PreparedStatement pstm = null;
		ResultSet result = null;
		
		try {
			// Step 1: Connecting the DB
			connection = MySQLConexion8.getConexion();
			
			// Step 2: Query to search the user
			String sql = "SELECT * FROM user WHERE codUser = ? AND passwordUser = ?;";
		
			// Step 3: 
			pstm = connection.prepareStatement(sql);
			
			// Step 4: Passing the pamaeters
			pstm.setString(1, user);
			pstm.setString(2, password);
			
			// Step 5: Executing the action
			result = pstm.executeQuery();
			
			// Step 6: Loop through the info
			while(result.next()) {
				ingresar = new Ingresar();
				
				ingresar.setIdUser(result.getInt(1));
				ingresar.setCodUser(result.getString(2));
				ingresar.setPasswordUser(result.getString(3));
				ingresar.setNameUser(result.getString(4));
				ingresar.setLastnameUser(result.getString(5));
				ingresar.setIdCargo(result.getInt(6));
				
				ingresarList.add(ingresar);
			}
			
		}
		catch (Exception e) {
			System.out.println(">>> ERROR en el query SQL: " + e.getMessage());
		}
		finally {
			try {
				if (pstm != null) pstm.close();
				if (connection != null) connection.close();
			}
			catch (Exception e2) {
				System.out.println(">>> ERROR al cerrar la BD: " + e2.getMessage());
			}
		}
		if(ingresarList.size() == 1) {
			login = true;
		}
		
		return login;
	}
	
	public IngresarList getIngresarList() {
		return ingresarList;
	}
	
	public void singout() {
		Connection connection = null;
		PreparedStatement pstm = null;
		
		try {
			// Step 1: Making the connection
			connection = MySQLConexion8.getConexion();
		}
		catch (Exception e) {
			
		}
		finally {
			
		}
	}
}
