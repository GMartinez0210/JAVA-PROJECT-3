package mantenimiento;

import java.util.ArrayList;

import entidad.Alerta;
import interfaces.AlertaInterfaceDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Connection;
import util.MySQLConexion8;

public class GestionAlertaDAO implements AlertaInterfaceDAO{

	@Override
	public int insertarAlerta(Alerta alerta) {
		int insert = -1;
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = new MySQLConexion8().getConexion();   //here
			String sql = "insert into tb_alerta values(null,1,?,?,null,?,null,null)"; //Cambiar el 1 a ?
			pstm = conn.prepareStatement(sql);
			pstm.setDate(1, alerta.getFec());
			pstm.setString(2, alerta.getBreveDes());
			pstm.setBoolean(3, alerta.getRelevancia());
			
			insert = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstm != null) pstm.close();
				if(conn != null) pstm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return insert;
	}

	@Override
	public int actualizarAlerta(Alerta alerta) {
		int update = -1;
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = new MySQLConexion8().getConexion();
			String sql = "update tb_alerta set descripbreve = ?, descrip=?, relevancia=? where codigo=?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, alerta.getBreveDes());
			pstm.setString(2, alerta.getDes());
			pstm.setBoolean(3, alerta.getRelevancia());
			pstm.setInt(4, alerta.getCod());
			
			update = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstm != null) pstm.close();
				if(conn != null) pstm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return update;
	}

	@Override
	public ArrayList<Alerta> listarAlerta() {
		ArrayList<Alerta> data = new ArrayList<Alerta>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			conn = new MySQLConexion8().getConexion();
			String sql = "select * from tb_alerta";
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			Alerta a = null;
			while(rs.next()){
				a = new Alerta();
				a.setCod(rs.getInt(1));
				a.setCodUsu(rs.getInt(2));
				a.setFec(rs.getDate(3));
				a.setBreveDes(rs.getString(4));
				a.setDes(rs.getString(5));
				a.setRelevancia(rs.getBoolean(6));
				a.setDerivada(rs.getString(7));
				a.setPlazoAtencion(rs.getDate(8));
				data.add(a);
			}
		}  catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstm != null) pstm.close();
				if(conn != null) pstm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return data;
	}
	
}
