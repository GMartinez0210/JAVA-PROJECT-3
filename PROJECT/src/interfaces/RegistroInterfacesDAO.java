package interfaces;

import java.util.ArrayList;

import entidad.InfoReportes;
import entidad.Reporte;
import entidad.ReportePrioridad;
import entidad.ReporteTabla;

public interface RegistroInterfacesDAO {
	//actualizar
	public int actualizar(Reporte r);
	
	//eliminar
	public int eliminar(int codigo);
	
	//mostrar reportes
	public ArrayList<InfoReportes> listaReportes();
	
	//mostrar datos en la tabla
	public ArrayList<ReporteTabla> listarReportesenTabla();
	
	//listar reportes por prioridad
	public ArrayList<ReportePrioridad> listarReporteXPrioridad(int cod_prio);
	
	//actualizar prioridad por codigo
	public int updatePrioridadXCod(int cod, int cod_prio);
}
