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
	public Usuario login(Ingresar ingresar) {
		Usuario usuario = null;
		
		Connection connection = null;
		PreparedStatement pstm = null;
		PreparedStatement pstm2 = null;
		int ingreso = 0;
		ResultSet result = null;
		
		try {
			// Step 1: Connecting the DB
			connection = MySQLConexion8.getConexion();
			connection.setAutoCommit(false);
			
			// Step 2: Query to search the user
			String sql = "SELECT * FROM usuario WHERE dniUsuario = ? AND claveUsuario = ?;";
		
			// Step 3: 
			pstm = connection.prepareStatement(sql);
			
			// Step 4: Passing the pamaeters
			pstm.setString(1, ingresar.getDniUsuario());
			pstm.setString(2, ingresar.getPasswordUsuario());
			
			// Step 5: Executing the action
			result = pstm.executeQuery();
			
			// Step 6: Loop through the info
			if(result.next()) {
				usuario = new Usuario();
				
				usuario.setCodigo(result.getInt(1));
				usuario.setUsuario(result.getString(2));
				usuario.setClave(result.getString(3));
				usuario.setNombre(result.getString(4));
				usuario.setApellido(result.getString(5));
				usuario.setIdCargo(result.getInt(6));
			}
			
			String sql2 = "{call USP_Ingresar(?,?,?)}";
			pstm2 = connection.prepareStatement(sql2);
			pstm2.setInt(1, usuario.getCodigo());
			pstm2.setString(2, ingresar.getFecha());
			pstm2.setString(3, ingresar.getHora());
			
			ingreso = pstm2.executeUpdate();
			
			connection.commit();
		}
		catch (Exception e) {
			System.out.println(">>> ERROR en el query SQL: " + e.getMessage());
			try {
				connection.rollback();
			} 
			catch (Exception e2) {
				System.out.println(">>> ERROR en el rollback(): " + e.getMessage());
			}
		}
		finally {
			try {
				if (pstm != null) pstm.close();
				if (pstm2 != null) pstm2.close();
				if (connection != null) connection.close();
			}
			catch (Exception e2) {
				System.out.println(">>> ERROR al cerrar la BD: " + e2.getMessage());
			}
		}
		return usuario;
	}
}
