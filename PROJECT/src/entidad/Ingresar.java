package entidad;

public class Ingresar {
	// Variables
	private int codUsuario;
	private String dniUsuario;
	private String passwordUsuario;
	private String hora;
	private String fecha;
	
		// Constructor
	// First Constructor
	public Ingresar(int codUsuario, String dniUsuario, String passwordUsuario) {
		this.codUsuario = codUsuario;
		this.dniUsuario = dniUsuario;
		this.passwordUsuario = passwordUsuario;
	}

	// Second Constructor
	public Ingresar() {
	}
	
	// Getters and Setters
	public int getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(int codUsuario) {
		this.codUsuario = codUsuario;
	}

	public String getDniUsuario() {
		return dniUsuario;
	}

	public void setDniUsuario(String dniUsuario) {
		this.dniUsuario = dniUsuario;
	}

	public String getPasswordUsuario() {
		return passwordUsuario;
	}

	public void setPasswordUsuario(String passwordUsuario) {
		this.passwordUsuario = passwordUsuario;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
}
