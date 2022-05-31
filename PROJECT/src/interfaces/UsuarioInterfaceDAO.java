package interfaces;

import java.util.ArrayList;

import entidad.Usuario;

public interface UsuarioInterfaceDAO {
	// agregar
	public Usuario agregar(String user, String password);
	
	// actualizar
	public int actualizar(Usuario usuario);

	// eliminar
	public int eliminar(Usuario usuario);
	
	// leer
	public ArrayList<Usuario> leerUsuarios(Usuario usuario);
	public Usuario leerUsuario(int codigoUsuario);
}
