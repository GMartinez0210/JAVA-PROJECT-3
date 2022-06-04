package entidad;

import java.sql.Date;

public class Alerta {
	private int cod;
	private java.sql.Date fec;
	private boolean relevancia;
	private String breveDes;
	private String des;
	private int codUsu;
	private String derivada;
	private java.sql.Date plazoAtencion;
	public Alerta() {
		super();
	}
	public Alerta(int cod, int codUsu, Date fec, String breveDes, String des ,boolean relevancia, String derivada, Date plazoAtencion) {
		super();
		this.cod = cod;
		this.fec = fec;
		this.relevancia = relevancia;
		this.des = des;
		this.breveDes = breveDes;
		this.codUsu = codUsu;
		this.derivada = derivada;
		this.plazoAtencion = plazoAtencion;
	}
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public java.sql.Date getFec() {
		return fec;
	}
	public void setFec(java.sql.Date fec) {
		this.fec = fec;
	}
	public boolean getRelevancia() {
		return relevancia;
	}
	public void setRelevancia(boolean relevancia) {
		this.relevancia = relevancia;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public int getCodUsu() {
		return codUsu;
	}
	public void setCodUsu(int codUsu) {
		this.codUsu = codUsu;
	}
	public String getBreveDes() {
		return breveDes;
	}
	public void setBreveDes(String breveDes) {
		this.breveDes = breveDes;
	}
	public String getDerivada() {
		return derivada;
	}
	public void setDerivada(String derivada) {
		this.derivada = derivada;
	}
	public java.sql.Date getPlazoAtencion() {
		return plazoAtencion;
	}
	public void setPlazoAtencion(java.sql.Date plazoAtencion) {
		this.plazoAtencion = plazoAtencion;
	}
	
}
