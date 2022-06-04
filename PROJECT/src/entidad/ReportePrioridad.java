package entidad;

public class ReportePrioridad {
	private int codigo;
	private int cod_prio;
	private String descripcion;
	public ReportePrioridad() {
		super();
	}
	public ReportePrioridad(int codigo, int cod_prio, String descripcion) {
		super();
		this.codigo = codigo;
		this.cod_prio = cod_prio;
		this.descripcion = descripcion;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getCod_prio() {
		return cod_prio;
	}
	public void setCod_prio(int cod_prio) {
		this.cod_prio = cod_prio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
