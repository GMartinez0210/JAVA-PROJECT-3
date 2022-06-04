package entidad;

import java.sql.*;

public class Alerta {
	private int cod;
	private int codUsu;
	private java.sql.Date fec;
	private String breveDes;
	private String des;
	private boolean relevancia;
	private String deriv;
	private String plazoatencion;
	private String estado;
	public Alerta() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Alerta(int cod, int codUsu, Date fec, String breveDes, String des, boolean relevancia, String deriv,
			String plazoatencion, String estado) {
		super();
		this.cod = cod;
		this.codUsu = codUsu;
		this.fec = fec;
		this.breveDes = breveDes;
		this.des = des;
		this.relevancia = relevancia;
		this.deriv = deriv;
		this.plazoatencion = plazoatencion;
		this.estado = estado;
	}
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public int getCodUsu() {
		return codUsu;
	}
	public void setCodUsu(int codUsu) {
		this.codUsu = codUsu;
	}
	public java.sql.Date getFec() {
		return fec;
	}
	public void setFec(java.sql.Date fec) {
		this.fec = fec;
	}
	public String getBreveDes() {
		return breveDes;
	}
	public void setBreveDes(String breveDes) {
		this.breveDes = breveDes;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public boolean getRelevancia() {
		return relevancia;
	}
	public void setRelevancia(boolean relevancia) {
		this.relevancia = relevancia;
	}
	public String getDeriv() {
		return deriv;
	}
	public void setDeriv(String deriv) {
		this.deriv = deriv;
	}
	public String getPlazoatencion() {
		return plazoatencion;
	}
	public void setPlazoatencion(String plazoatencion) {
		this.plazoatencion = plazoatencion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}