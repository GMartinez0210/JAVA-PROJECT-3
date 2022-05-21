package entidad;

public class Reporte {
	private int codigo;
	private String usuario;
	private String descripcion;
	private String fecha;
	private int estado;
	
	public Reporte() {
	
	}

	public Reporte(int codigo, String usuario, String descripcion, String fecha, int estado) {
		this.codigo = codigo;
		this.usuario = usuario;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.estado = estado;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
	
}
