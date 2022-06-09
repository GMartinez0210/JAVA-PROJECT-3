package interfaces;

import java.util.ArrayList;

import entidad.Mensaje;
import entidad.MensajeCUsuario;

public interface MensajeInterfacesDAO {
	public int registrar(Mensaje r);
	
	public ArrayList<Mensaje> listaMensajes();
	
	public ArrayList<MensajeCUsuario> listarMensajesCUsuario();
}
