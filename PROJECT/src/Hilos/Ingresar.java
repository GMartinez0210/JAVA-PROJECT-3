package Hilos;

import vista.PreLoader;

public class Ingresar extends Thread {
	public void run() {
		for (int i = 0; i <= 100; i++) {
			if (i % 3 == 0) PreLoader.lblCargando.setText("Cargando.");
			else if (i % 2 == 0) PreLoader.lblCargando.setText("Cargando..");
			else PreLoader.lblCargando.setText("Cargando...");
				
			PreLoader.lblPorcentaje.setText(i + " %");
			PreLoader.pbCargando.setValue(i);
			
			if(PreLoader.pbCargando.getValue() == 100) {
				PreLoader preloader = new PreLoader();
				preloader.setVisible(false);
				
			}
			try {
				Thread.sleep(50);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
