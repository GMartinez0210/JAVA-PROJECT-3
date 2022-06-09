package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.InfoReportes;
import entidad.Reporte;
import entidad.ReportePrioridad;
import entidad.ReporteTabla;
import interfaces.RegistroInterfacesDAO;
import util.MySQLConexion8;

public class GestionRegistroDAO implements RegistroInterfacesDAO{

	@Override
	public ArrayList<InfoReportes> listaReportes() {
		ArrayList<InfoReportes> lista = new ArrayList<InfoReportes>();
		InfoReportes InRe;
		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet res = null;
		try {
			//paso 1
			con = MySQLConexion8.getConexion();
			//paso 2
			String sql = "select codReporte, descripcionReporte, fechaReporte from reportes where codEstado = 1";
			//paso 3
			pstm = con.prepareStatement(sql);
			//paso 4 --> no hay
			
			//paso 5
			res = pstm.executeQuery();
			//paso6 
			while(res.next()){
				InRe = new InfoReportes();
			
				InRe.setCod(res.getInt(1));
				InRe.setReporte(res.getString(2));
				InRe.setFecha(res.getString(3));
				
				lista.add(InRe);
			}
			
		} catch (Exception e) {
			System.out.println(">>>>>>>>> Error en la Instruccion SQL - Listar Reportes " + e.getMessage());
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

	@Override
	public ArrayList<ReporteTabla> listarReportesenTabla() {
		ArrayList<ReporteTabla> lista = new ArrayList<ReporteTabla>();
		ReporteTabla rTa;
		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet res = null;
		try {
			con = MySQLConexion8.getConexion();
			
			String sql = "{call proc_mostrarRegistros}";
			
			pstm = con.prepareStatement(sql);
			
			res = pstm.executeQuery();
			
			while(res.next()) {
				rTa = new ReporteTabla();
				
				rTa.setCod(res.getInt(1));
				rTa.setUsuario(res.getString(2));
				rTa.setDescripcion(res.getString(3));
				rTa.setFecha(res.getString(4));
				rTa.setEstado(res.getString(5));
				rTa.setCodAnexo(res.getInt(6));
				rTa.setFechaEvaluacion(res.getString(7));
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

	@Override
	public int actualizar(Reporte r) {
		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
			
			con = MySQLConexion8.getConexion();
			
			String sql = "call proc_evaluarReportes(?, ?, ?, ?, ?, ?, ?)";
			
			pstm = con.prepareStatement(sql);
			//paso 4: parametros
			pstm.setInt(1, r.getCodigo());
			pstm.setInt(2, r.getUsuario());
			pstm.setString(3, r.getDescripcion());
			pstm.setString(4, r.getFecha());
			pstm.setInt(5, r.getEstado());
			pstm.setInt(6, r.getCodAnexo());
			pstm.setString(7, r.getFechaEvaluacion());
			
			//paso 5: Ejecutar la instrucci�n
			res = pstm.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(">>>>>>>>> Error en la Instruccion SQL - Actualizar " + e.getMessage());
		}
		finally {
			try {
				if(pstm != null) pstm.close();
				if(con != null) con.close();
			} catch (SQLException e2) {
				System.out.println("<<<<<< Error al cerrar la base de datos " +e2.getMessage());
			}
		}
		return res;
	}

	@Override
	public int eliminar(int codigo) {
		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
			//paso 1: Establecer la coneccion a la base de datos
			con = MySQLConexion8.getConexion();
			//paso 2: Poder determinar la intruccion SQL --> Eliminar
			//
			String sql = "delete from reportes where codReporte = ?";
			// paso 3
			pstm = con.prepareStatement(sql);
			//paso 4
			pstm.setInt(1, codigo);
			//paso 5
			res = pstm.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(">>>>>>>>> Error en la Instruccion SQL - Eliminar " + e.getMessage());
		}
		finally {
			try {
				if(pstm != null) pstm.close();
				if(con != null) con.close();
			} catch (SQLException e2) {
				System.out.println("<<<<<< Error al cerrar la base de datos " +e2.getMessage());
			}
		}
		return res;
	}

	@Override
	public ArrayList<ReportePrioridad> listarReporteXPrioridad(int cod_prio) {
		ArrayList<ReportePrioridad> lista = new ArrayList<ReportePrioridad>();
		ReportePrioridad rPrio;
		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet res = null;
		try {
			con = MySQLConexion8.getConexion();
			
			String sql = "{call Proc_listarReporteXPrioridad(?)}";
			
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, cod_prio);
			res = pstm.executeQuery();
			
			while(res.next()) {
				rPrio = new ReportePrioridad();
				rPrio.setCodigo(res.getInt(1));
				rPrio.setCod_prio(res.getInt(2));
				rPrio.setDescripcion(res.getString(3));
				lista.add(rPrio);
			}
		} catch (Exception e) {
			System.out.println(">>>>>>>>> Error en la Instruccion SQL - Consultar " + e.getMessage());
		}
		finally {
			try {
				if(pstm != null) pstm.close();
				if(res !=null) res.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				System.out.println("<<<<<< Error al cerrar la base de datos " +e.getMessage());
			}
		}
		return lista;
	}

	@Override
	public int updatePrioridadXCod(int cod, int cod_prio) {
		int res = -1;
		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
			
			con = MySQLConexion8.getConexion();
			
			String sql = "{call Proc_updatePrioridadXCod(?,?)}";
			
			pstm = con.prepareStatement(sql);
			//paso 4: parametros
			pstm.setInt(1, cod);
			pstm.setInt(2, cod_prio);
			//paso 5: Ejecutar la instrucci�n
			res = pstm.executeUpdate();
		} catch (Exception e) {
			System.out.println(">>>>>>>>> Error en la Instruccion SQL - Actualizar " + e.getMessage());
		}
		finally {
			try {
				if(pstm != null) pstm.close();
				if(con != null) con.close();
			} catch (SQLException e2) {
				System.out.println("<<<<<< Error al cerrar la base de datos " +e2.getMessage());
			}
		}
		return res;
		
	}

}
