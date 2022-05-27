package arrayList;

import java.util.ArrayList;
import entidad.Ingresar;

public class IngresarList {
	private ArrayList<Ingresar> ingresarList;
	
	public IngresarList() {
		ingresarList = new ArrayList<Ingresar>();
	}
	
	public int size() {
		return ingresarList.size();
	}
	
	public void add(Ingresar ingresar) {
		ingresarList.add(ingresar);
	}
	
	public Ingresar getFirstValue() {
		return ingresarList.get(0);
	}
}
