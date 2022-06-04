package entidad;

public class Registro {
	private int cod;
	private int usuario;
	private int reporte;
	private int anexo;
	private String fecha;
	private int estado;
	
	
	public Registro() {

	}

	public Registro(int cod, int usuario, int reporte, int anexo, String fecha, int estado) {
		this.cod = cod;
		this.usuario = usuario;
		this.reporte = reporte;
		this.anexo = anexo;
		this.fecha = fecha;
		this.estado = estado;
	}

	
	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public int getUsuario() {
		return usuario;
	}

	public void setUsuario(int usuario) {
		this.usuario = usuario;
	}

	public int getReporte() {
		return reporte;
	}

	public void setReporte(int reporte) {
		this.reporte = reporte;
	}

	public int getAnexo() {
		return anexo;
	}

	public void setAnexo(int anexo) {
		this.anexo = anexo;
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
