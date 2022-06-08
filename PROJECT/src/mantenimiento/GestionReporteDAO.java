package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.Reporte;
import entidad.ReporteTabla;
import interfaces.ReporteInterfacesDAO;
import util.MySQLConexion8;

public class GestionReporteDAO implements ReporteInterfacesDAO {

	@Override
	public int registrar(Reporte r) {
		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
			con = MySQLConexion8.getConexion();
			
			String sql = "INSERT INTO reportes values (null, ?, ?, ?, ?, null, null)";
			
			pstm = con.prepareStatement(sql);
			
			pstm.setInt(1, r.getUsuario());
			pstm.setString(2, r.getDescripcion());
			pstm.setString(3, r.getFecha());
			pstm.setInt(4, r.getEstado());
			
			res = pstm.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(">>>>>>>>> Error en la Instruccion SQL - Registrar " + e.getMessage());
		}finally {
			try {
				if(pstm != null) pstm.close();
				if(con != null) con.close();
			} catch (Exception e2) {
				System.out.println("<<<<<< Error al cerrar la base de datos " +e2.getMessage());
			}
		}
		
		return res;
	}

	@Override
	public ArrayList<ReporteTabla> listarReportes() {
		ArrayList<ReporteTabla> lista = new ArrayList<ReporteTabla>();
		ReporteTabla rTa;
		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet res = null;
		try {
			con = MySQLConexion8.getConexion();
			
			String sql = "call proc_listarreportes";
			
			pstm = con.prepareStatement(sql);
			
			res = pstm.executeQuery();
			
			while(res.next()) {
				rTa = new ReporteTabla();
				
				rTa.setCod(res.getInt(1));
				rTa.setUsuario(res.getString(2));
				rTa.setDescripcion(res.getString(3));
				rTa.setFecha(res.getString(4));
				rTa.setEstado(res.getString(5));
				
				lista.add(rTa);
				
			}
//			System.out.println(lista.size());
		} catch (Exception e) {
			System.out.println(">>>>>>>>> Error en la Instruccion SQL - Consultar " + e.getMessage());
		}
		finally {
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
