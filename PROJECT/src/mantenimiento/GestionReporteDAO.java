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
			
			String sql = "INSERT INTO reportes(descripcionReporte, codTipoUsuario, codEstado, fechaReporte) values (?, ?, ?, ?)";
			
			pstm = con.prepareStatement(sql);
			
			pstm.setString(1, r.getDescripcion());
			pstm.setInt(2, r.getUsuario());
			pstm.setInt(3, r.getEstado());
			pstm.setString(4, r.getFecha());
			
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
