package interfaces;

import java.util.ArrayList;

import entidad.Alerta;

public interface AlertaInterfaceDAO {
	public int insertarAlerta(Alerta alerta);
	public int actualizarAlerta(Alerta alerta);
	public ArrayList<Alerta> listarAlerta();
}
