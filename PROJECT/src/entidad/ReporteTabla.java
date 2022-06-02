package entidad;

public class ReporteTabla {
	private int cod;
	private String Usuario;
	private String descripcion;
	private String fecha;
	private String estado;
	private int codAnexo;
	private String fechaEvaluacion;
	
	
	public ReporteTabla() {

	}

	public ReporteTabla(int cod, String usuario, String descripcion, String fecha, String estado, int codAnexo, String fechaEvaluacion) {
		this.cod = cod;
		this.Usuario = usuario;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.estado = estado;
		this.codAnexo = codAnexo;
		this.fechaEvaluacion = fechaEvaluacion;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getUsuario() {
		return Usuario;
	}

	public void setUsuario(String usuario) {
		Usuario = usuario;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public int getCodAnexo(){
		return codAnexo;
	}
	
	public void setCodAnexo(int codAnexo){
		this.codAnexo = codAnexo;
	}

	public String getFechaEvaluacion() {
		return fechaEvaluacion;
	}

	public void setFechaEvaluacion(String fechaEvaluacion) {
		this.fechaEvaluacion = fechaEvaluacion;
	}
	
	
}
