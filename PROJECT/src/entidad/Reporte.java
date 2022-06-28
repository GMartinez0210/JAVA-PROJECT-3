package entidad;

public class Reporte {
	private int codigo;
	private int usuario;
	private String descripcion;
	private String fecha;
	private int estado;
	private int codAnexo;
	private String fechaEvaluacion;
	private int cod_prio; //anexo_2 en la db
	
	public Reporte() {
	
	}

	public Reporte(int codigo, int usuario, String descripcion, String fecha, int estado, int codAnexo, String fechaEvaluacion, int cod_prio) {
		this.codigo = codigo;
		this.usuario = usuario;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.estado = estado;
		this.codAnexo = codAnexo;
		this.fechaEvaluacion = fechaEvaluacion;
		this.cod_prio = cod_prio;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	
	public int getUsuario() {
		return usuario;
	}

	public void setUsuario(int usuario) {
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


	public int getCod_prio() {
		return cod_prio;
	}

	public void setCod_prio(int cod_prio) {
		this.cod_prio = cod_prio;
	}
}
