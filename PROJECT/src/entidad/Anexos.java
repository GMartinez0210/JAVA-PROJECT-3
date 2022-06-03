package entidad;

public class Anexos {
	private int cod;
	private String descripcion;
	
	//contructor
	public Anexos() {
		
	}

	public Anexos(int cod, String descripcion) {
		this.cod = cod;
		this.descripcion = descripcion;
	}

	//metodos set / get
	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
