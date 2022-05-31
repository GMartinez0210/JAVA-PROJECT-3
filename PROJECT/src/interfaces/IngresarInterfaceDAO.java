package interfaces;

import entidad.Ingresar;
import entidad.Usuario;

public interface IngresarInterfaceDAO {
	// login
	public Usuario login(String user, String password);
		
	// sign out
	public void singout();
}
