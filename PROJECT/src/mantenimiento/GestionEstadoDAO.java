package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.Estado;
import interfaces.EstadoInterfacesDAO;
import util.MySQLConexion8;

public class GestionEstadoDAO implements EstadoInterfacesDAO{

	@Override
	public ArrayList<Estado> listaEstado() {
		ArrayList<Estado> lista = new ArrayList<Estado>();
		Estado es;
		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet res = null;
		try {
			//paso 1
			con = MySQLConexion8.getConexion();
			//paso 2
			String sql = "select * from estado";
			//paso 3
			pstm = con.prepareStatement(sql);
			//paso 4 --> no hay
			
			//paso 5
			res = pstm.executeQuery();
			//paso6 
			while(res.next()){
				es = new Estado();
			
				es.setCodigo(res.getInt(1));
				es.setDescripcion(res.getString(2));
				
				lista.add(es);
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
