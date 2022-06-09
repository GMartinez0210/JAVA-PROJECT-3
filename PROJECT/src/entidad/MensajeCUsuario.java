package entidad;

public class MensajeCUsuario {
	
	
	String nombre;
	int idMensajes;
	String correo;
	String asunto;
	String Mensajes;
	
	
	
	public MensajeCUsuario() {

	}

	public MensajeCUsuario(String nombre, int idMensajes, String correo, String asunto, String mensajes) {
		super();
		this.nombre = nombre;
		this.idMensajes = idMensajes;
		this.correo = correo;
		this.asunto = asunto;
		Mensajes = mensajes;
	}
	
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getIdMensajes() {
		return idMensajes;
	}

	public void setIdMensajes(int idMensajes) {
		this.idMensajes = idMensajes;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getMensajes() {
		return Mensajes;
	}

	public void setMensajes(String mensajes) {
		Mensajes = mensajes;
	}
}
