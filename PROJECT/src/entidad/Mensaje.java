package entidad;

public class Mensaje {
	int codigo, codUser;
	String correo, mensaje, asunto;
	
	
	public Mensaje() {
		
	}
	
	public Mensaje(int codigo, int codUser, String correo, String mensaje, String asunto) {
		super();
		this.codigo = codigo;
		this.codUser = codUser;
		this.correo = correo;
		this.mensaje = mensaje;
		this.asunto = asunto;
	}
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getCodUser() {
		return codUser;
	}
	public void setCodUser(int codUser) {
		this.codUser = codUser;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
}
