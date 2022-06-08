package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.MySQLConexion8;

import arrayList.IngresarList;
import entidad.Ingresar;
import entidad.Usuario;
import interfaces.IngresarInterfaceDAO;

public class GestionIngresarDAO implements  IngresarInterfaceDAO{
	@Override
	public Usuario login(String user, String password) {
		Usuario usuario = null;
		
		Connection connection = null;
		PreparedStatement pstm = null;
		ResultSet result = null;
		
		try {
			// Step 1: Connecting the DB
			connection = MySQLConexion8.getConexion();
			
			// Step 2: Query to search the user
			String sql = "SELECT * FROM usuario WHERE dniUsuario = ? AND claveUsuario = ?;";
		
			// Step 3: 
			pstm = connection.prepareStatement(sql);
			
			// Step 4: Passing the pamaeters
			pstm.setString(1, user);
			pstm.setString(2, password);
			
			// Step 5: Executing the action
			result = pstm.executeQuery();
			
			// Step 6: Loop through the info
			while(result.next()) {
				usuario = new Usuario();
				
				usuario.setCodigo(result.getInt(1));
				usuario.setUsuario(result.getString(2));
				usuario.setClave(result.getString(3));
				usuario.setNombre(result.getString(4));
				usuario.setApellido(result.getString(5));
				usuario.setIdCargo(result.getInt(6));
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
		return usuario;
	}

	@Override
	public void singout() {
		
	}
}
