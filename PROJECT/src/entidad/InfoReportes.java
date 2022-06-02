package entidad;

public class InfoReportes {
	private int cod;
	private String reporte;
	private String fecha;
	
	
	public InfoReportes() {

	}

	public InfoReportes(int cod, String reporte, String fecha) {
		this.cod = cod;
		this.reporte = reporte;
		this.fecha = fecha;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getReporte() {
		return reporte;
	}

	public void setReporte(String reporte) {
		this.reporte = reporte;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
}
