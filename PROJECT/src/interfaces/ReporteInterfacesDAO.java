package interfaces;

import java.util.ArrayList;

import entidad.Reporte;
import entidad.ReporteTabla;

public interface ReporteInterfacesDAO {
	//registrar
	public int registrar(Reporte r);
	
	//consultar
	public ArrayList<ReporteTabla> listarReportes();
}
