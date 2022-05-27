package interfaces;

import entidad.Ingresar;

public interface IngresarInterfaceDAO {
	// login
	public boolean login(String user, String password);
	
	public void singout();
}
