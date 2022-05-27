package Hilos;

import vista.PreLoader;
import vista.PrincipalFuncional;

public class Ingresar extends Thread {
	public void run() {
		for (int i = 0; i <= 100; i++) {
			if (i % 6 == 0) PreLoader.lblCargando.setText("Cargando.");
			else if (i % 4 == 0) PreLoader.lblCargando.setText("Cargando..");
			else if (i % 2 == 0) PreLoader.lblCargando.setText("Cargando...");
				
			PreLoader.lblPorcentaje.setText(i + " %");
			PreLoader.pbCargando.setValue(i);
			try {
				Thread.sleep(25);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(PreLoader.pbCargando.getValue() == 100) {
			PreLoader preLoader = new PreLoader();
			preLoader.setVisible(false);
			PrincipalFuncional principalFuncional = new PrincipalFuncional();
			principalFuncional.setVisible(true);
			principalFuncional.setLocationRelativeTo(preLoader.frame);
		}
	}
}
