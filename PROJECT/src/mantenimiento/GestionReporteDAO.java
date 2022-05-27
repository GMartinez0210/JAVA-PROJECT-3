package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;

import entidad.Reporte;
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
			
			String sql = "INSERT INTO tb_reportes values (null, ?, ?, ?, ?)";
			
			pstm = con.prepareStatement(sql);
			
			pstm.setString(1, r.getUsuario());
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

}
