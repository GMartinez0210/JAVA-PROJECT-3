package entidad;

public class Ingresar {
	// Variables
	private int idUser;
	private String codUser;
	private String passwordUser;
	private String nameUser;
	private String lastnameUser;
	private int idCargo;
	
		// Constructor
	// First Constructor
	public Ingresar(int idUser, String codUser, String passwordUser, String nameUser, String lastnameUser,
			int idCargo) {
		this.idUser = idUser;
		this.codUser = codUser;
		this.passwordUser = passwordUser;
		this.nameUser = nameUser;
		this.lastnameUser = lastnameUser;
		this.idCargo = idCargo;
	}

	// Second Constructor
	public Ingresar() {
	}
	
	// Getters and Setters
	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getCodUser() {
		return codUser;
	}

	public void setCodUser(String codUser) {
		this.codUser = codUser;
	}

	public String getPasswordUser() {
		return passwordUser;
	}

	public void setPasswordUser(String passwordUser) {
		this.passwordUser = passwordUser;
	}

	public String getNameUser() {
		return nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	public String getLastnameUser() {
		return lastnameUser;
	}

	public void setLastnameUser(String lastnameUser) {
		this.lastnameUser = lastnameUser;
	}

	public int getIdCargo() {
		return idCargo;
	}

	public void setIdCargo(int idCargo) {
		this.idCargo = idCargo;
	}
}
