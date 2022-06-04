package entidad;

import java.util.ArrayList;

public class ReporteArray {
	private ArrayList<ReportePrioridad> ar = new ArrayList<ReportePrioridad>();
	
	public ReporteArray() {
		super();
	}
	public ReporteArray(ArrayList<ReportePrioridad> array) {
		ar.clear();
		for(int i = 0; i<array.size();i++) {
			add(array.get(i));
		}
	}
	public void add(ReportePrioridad reporte) {
		ar.add(reporte);
	}
	public int size() {
		return ar.size();
	}
	public ReportePrioridad get(int i) {
		return ar.get(i); //index of the array
	}
	public ReportePrioridad searchForCod(int cod) {
		ReportePrioridad reporte = null;
		for(int i=0; i < size(); i++) {
			if(get(i).getCodigo() == cod) {
				reporte = get(i);
			}
		}
		return reporte;
	}
	public void setPrioForCod(int cod, int prioridad) {
		searchForCod(cod).setCod_prio(prioridad);
	}
	public String getDesForCod(int cod) {
		return searchForCod(cod).getDescripcion();
	}
}
