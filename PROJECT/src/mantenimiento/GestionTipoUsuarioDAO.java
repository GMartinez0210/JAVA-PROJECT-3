package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.Anexos;
import entidad.TipoUsuario;
import interfaces.TipoUsuarioInterfacesDAO;
import util.MySQLConexion8;

public class GestionTipoUsuarioDAO implements TipoUsuarioInterfacesDAO{

	@Override
	public ArrayList<TipoUsuario> listaTipoUsuarios() {
		ArrayList<TipoUsuario> lista = new ArrayList<TipoUsuario>();
		TipoUsuario tip;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		
		try {
			//paso 1
			con = MySQLConexion8.getConexion();
			//paso 2
			String sql = "SELECT * FROM tipo_usuario";
			//paso 3
			pstm = con.prepareStatement(sql);
			//paso 4 --> no hay
			
			//paso 5
			res = pstm.executeQuery();
			//paso6 
			while(res.next()){
				tip = new TipoUsuario();
			
				tip.setCodigo(res.getInt(1));
				tip.setDescripcion(res.getString(2));
				
				lista.add(tip);
			}
			
		} catch (Exception e) {
			System.out.println(">>>>>>>>> Error en la Instruccion SQL - Listar " + e.getMessage());
		} finally {
			try {
				if(pstm != null) pstm.close();
				if(res !=null) res.close();
				if(con != null) con.close();
			} catch (SQLException e2) {
				System.out.println("<<<<<< Error al cerrar la base de datos " +e2.getMessage());
			}
		}
		
		return lista;
	}

}
