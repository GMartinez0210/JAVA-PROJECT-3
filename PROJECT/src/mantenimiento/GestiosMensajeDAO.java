package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.Mensaje;
import entidad.MensajeCUsuario;
import interfaces.MensajeInterfacesDAO;
import util.MySQLConexion8;

public class GestiosMensajeDAO implements MensajeInterfacesDAO{


	@Override
	public int registrar(Mensaje r) {
		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = MySQLConexion8.getConexion();
		
			String sql = "insert into mensajes values (null,?,?,?,?);";
			
			pstm = con.prepareStatement(sql);
			
			pstm.setString(1, r.getCorreo());
			pstm.setString(2, r.getAsunto());
			pstm.setString(3, r.getMensaje());
			pstm.setInt(4, r.getCodUser());
			
			res = pstm.executeUpdate();
						
		} catch (Exception e) {
			System.out.println(">>>>>>>>>>>>> Error en la Instrucción SQL - Registrar" + e.getMessage());
		}finally {
			try {
				if(pstm != null) pstm.close();
				if(con != null) con.close();
			} catch (SQLException e2) {
				System.out.println("<<<< Error al cerrar la base de datos " + e2.getMessage());
			}
		}
		return res;
	}

	@Override
	public ArrayList<Mensaje> listaMensajes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<MensajeCUsuario> listarMensajesCUsuario() {
		ArrayList<MensajeCUsuario> lista = new ArrayList<MensajeCUsuario>();//null
		MensajeCUsuario mu;
		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet res = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "{call usp_listarMensajeUsuario}";
			pstm = con.prepareStatement(sql);
			res = pstm.executeQuery();
			
			while(res.next()) {
				mu = new MensajeCUsuario();
				mu.setNombre(res.getString(1));
				mu.setIdMensajes(res.getInt(2));
				mu.setCorreo(res.getString(3));
				mu.setAsunto(res.getString(4));
				mu.setMensajes(res.getString(5));
				 
				lista.add(mu);	 
			}
							
		} catch (Exception e) {
			System.out.println(">>>>>>>>>>>> Error en la Instrucci�n SQL - Consultar" + e.getMessage());
		}finally {
			try {
				if(pstm != null ) pstm.close();
				if(res != null) res.close();
				if(con != null) con.close();
				
			} catch (SQLException e2) {
				System.out.println("<<<< Error al cerrar la base de datos "+ e2.getMessage());
			}
		}
		return lista;
	}

}
