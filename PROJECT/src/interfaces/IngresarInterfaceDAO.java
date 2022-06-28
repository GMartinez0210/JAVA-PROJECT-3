package interfaces;

import entidad.Ingresar;
import entidad.Usuario;

public interface IngresarInterfaceDAO {
	// login
	public Usuario login(Ingresar ingresar);
}
