package interfaces;

import java.util.ArrayList;

import entidad.Alerta;

public interface AlertaInterfaceDAO {
	public int insertarAlerta(Alerta alerta);
	public int actualizarAlerta(Alerta alerta);
	public ArrayList<Alerta> registrarAlerta();
	
	/*
	 * 
	 * AQUÍ EMPIEZA EL CÓDIGO DE ALESSANDRO
	 * 
	 * */
	public ArrayList<Alerta> listarAlertas();
	public ArrayList<Alerta> codAlerta();
	public ArrayList<Alerta> listarAlertasDerivadas();
	public ArrayList<Alerta> seguimientoAlertas();
	public int derivarAlerta(Alerta alerta);
	public int asignarFechaAlerta(Alerta alerta);
	public int seguimientoAlerta(Alerta alerta);
}
