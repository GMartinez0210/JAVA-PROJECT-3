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
		
		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
			con = MySQLConexion8.getConexion();
			String sql = "insert into alerta(codUsuario, descripBreveAlerta, relevanciaAlerta, fechaAlerta) values(?,?,?,?)";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, alerta.getCodUsu());
			pstm.setString(2, alerta.getBreveDes());
			pstm.setBoolean(3, alerta.getRelevancia());
			pstm.setDate(4, alerta.getFec());
			
			insert = pstm.executeUpdate();
		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		} finally {
			try {
				if(pstm != null) pstm.close();

				if(con != null) pstm.close();
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
			conn = MySQLConexion8.getConexion();
			String sql = "update alerta set descripBreveAlerta = ?, descripcionAlerta = ?, relevanciaAlerta = ? where codAlerta = ?";
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
	public ArrayList<Alerta> registrarAlerta() {
		ArrayList<Alerta> data = new ArrayList<Alerta>();
		
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "select * from alerta";
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			Alerta a = null;
			while(rs.next()){
				a = new Alerta();
				a.setCod(rs.getInt(1));
				a.setCodUsu(rs.getInt(2));
				a.setBreveDes(rs.getString(3));
				a.setDes(rs.getString(4));
				a.setRelevancia(rs.getBoolean(5));
				a.setFec(rs.getDate(7));

				data.add(a);
			}
		}  catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstm != null) pstm.close();

				if(con != null) pstm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return data;
	}


	/**
	 * 
	 * AQUÍ EMPIEZA EL CODIGO DE ALESSANDRO
	 * 
	 * */

	@Override
	public ArrayList<Alerta> listarAlertas() {
		ArrayList<Alerta> lista = new ArrayList<Alerta>();
		Alerta a;
		PreparedStatement pstm = null;
		Connection cn = null;
		ResultSet rs= null;
		try {
			cn = MySQLConexion8.getConexion();
			String sql = "select * from alerta where derivadaAlerta is null";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()){
				a = new Alerta();
				a.setCod(rs.getInt(1));
				a.setCodUsu(rs.getInt(2));
				a.setBreveDes(rs.getString(3));				
				a.setDes(rs.getString(4));
				a.setRelevancia(rs.getBoolean(5));
				a.setDeriv(rs.getString(6));
				a.setFec(rs.getDate(7));
				a.setPlazoatencion(rs.getString(8));
				lista.add(a);
			}
		} catch (Exception e) {
			System.out.println(">>>>>>>>> Error en la Instruccion SQL - Consultar " + e.getMessage());
		}
		finally {
			try {
				if(pstm != null) pstm.close();
				if(rs !=null) rs.close();
				if(cn != null) cn.close();
			} catch (SQLException e2) {
				System.out.println("<<<<<< Error al cerrar la base de datos " +e2.getMessage());
			}
		}
		return lista;
	}

	@Override
	public ArrayList<Alerta> codAlerta() {
		ArrayList<Alerta> lista = new ArrayList<Alerta>();
		Alerta a;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = MySQLConexion8.getConexion();
			String sql = "SELECT codAlerta FROM alerta";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()){
				a = new Alerta();
				a.setCod(rs.getInt(1));
				lista.add(a);
			}
		} catch (Exception e) {
			System.out.println(">>>>>>>>> Error en la Instruccion SQL - Consultar " + e.getMessage());
		}
		finally {
			try {
				if(pstm != null) pstm.close();
				if(rs !=null) rs.close();
				if(cn != null) cn.close();
			} catch (SQLException e2) {
				System.out.println("<<<<<< Error al cerrar la base de datos " +e2.getMessage());
			}
		}
		return lista;
	}

	@Override
	public int derivarAlerta(Alerta alerta) {
		int alert = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MySQLConexion8.getConexion();
			String sql = "update alerta set derivadaAlerta = ? where codAlerta = ?";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, alerta.getDeriv());
			pstm.setInt(2, alerta.getCod());
			alert = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstm != null) pstm.close();
				if(cn != null) pstm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return alert;
	}

	@Override
	public ArrayList<Alerta> listarAlertasDerivadas() {
		ArrayList<Alerta> lista = new ArrayList<Alerta>();
		Alerta a;
		PreparedStatement pstm = null;
		Connection cn = null;
		ResultSet rs= null;
		try {
			cn = MySQLConexion8.getConexion();
			String sql = "select * from alerta where derivadaAlerta is not null and plazoAlerta is null";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()){
				a = new Alerta();
				a.setCod(rs.getInt(1));
				a.setCodUsu(rs.getInt(2));
				a.setFec(rs.getDate(3));
				a.setBreveDes(rs.getString(4));
				a.setDes(rs.getString(5));
				a.setRelevancia(rs.getBoolean(6));
				a.setDeriv(rs.getString(7));
				a.setPlazoatencion(rs.getString(8));
				lista.add(a);
			}
		} catch (Exception e) {
			System.out.println(">>>>>>>>> Error en la Instruccion SQL - Consultar " + e.getMessage());
		}
		finally {
			try {
				if(pstm != null) pstm.close();
				if(rs !=null) rs.close();
				if(cn != null) cn.close();
			} catch (SQLException e2) {
				System.out.println("<<<<<< Error al cerrar la base de datos " +e2.getMessage());
			}
		}
		return lista;
	}

	@Override
	public int asignarFechaAlerta(Alerta alerta) {
		int alert = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MySQLConexion8.getConexion();
			String sql = "update alerta set plazoAlerta = ? where codAlerta = ?";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, alerta.getPlazoatencion());
			pstm.setInt(2, alerta.getCod());
			alert = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstm != null) pstm.close();
				if(cn != null) pstm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return alert;
	}

	@Override
	public ArrayList<Alerta> seguimientoAlertas() {
		ArrayList<Alerta> lista = new ArrayList<Alerta>();
		Alerta a;
		PreparedStatement pstm = null;
		Connection cn = null;
		ResultSet rs= null;
		try {
			cn = MySQLConexion8.getConexion();
			String sql = "select * from alerta where derivadaAlerta is not null and plazoAlerta is not null";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()){
				a = new Alerta();
				a.setCod(rs.getInt(1));
				a.setCodUsu(rs.getInt(2));
				a.setFec(rs.getDate(3));
				a.setBreveDes(rs.getString(4));
				a.setDes(rs.getString(5));
				a.setRelevancia(rs.getBoolean(6));
				a.setDeriv(rs.getString(7));
				a.setPlazoatencion(rs.getString(8));
				a.setEstado(rs.getString(9));
				lista.add(a);
			}
		} catch (Exception e) {
			System.out.println("Error en la Instruccion SQL - Consultar " + e.getMessage());
		}
		finally {
			try {
				if(pstm != null) pstm.close();
				if(rs !=null) rs.close();
				if(cn != null) cn.close();
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la base de datos " + e2.getMessage());
			}
		}
		return lista;
	}

	@Override
	public int seguimientoAlerta(Alerta alerta) {
		int alert = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MySQLConexion8.getConexion();
			String sql = "update alerta set estadoAlerta = ? where codAlerta = ?";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, alerta.getEstado());
			pstm.setInt(2, alerta.getCod());
			alert = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstm != null) pstm.close();
				if(cn != null) pstm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return alert;
	}
}
