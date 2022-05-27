package Hilos;

import javax.swing.ImageIcon;

import vista.PrincipalFuncional;

public class MenuAnimacion extends Thread {
	public void run() {
		if (PrincipalFuncional.panelMenu.getBounds().width == 0) {
			PrincipalFuncional.lblMenu.setIcon(new ImageIcon(PrincipalFuncional.class.getResource("/images/nav-cancel.png")));

			for (int i = 0; i <= 170; i++) {
				PrincipalFuncional.panelMenu.setBounds(10, 52, i, 491);
				
				try {
					Thread.sleep(1);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
		else {
			PrincipalFuncional.lblMenu.setIcon(new ImageIcon(PrincipalFuncional.class.getResource("/images/nav-hamburger.png")));
			for (int i = 170; i >= 0; i--) {
				PrincipalFuncional.panelMenu.setBounds(10, 52, i, 491);
				
				try {
					Thread.sleep(1);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
	}
}
