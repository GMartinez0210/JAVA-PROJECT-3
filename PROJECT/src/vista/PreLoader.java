package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Hilos.Ingresar;

import javax.swing.JSeparator;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

import Hilos.Ingresar;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PreLoader extends JFrame {

	// Variables globales privadas
	private JPanel contentPane;
	private JLabel lblNewLabel_1;

	// Variables globales publicas
	public static JProgressBar pbCargando;
	public static JLabel lblCargando;
	public static JLabel lblPorcentaje;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PreLoader frame = new PreLoader();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PreLoader() {
		setTitle("Ty Hacking me");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				windowOpenedThis(e);
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(PreLoader.class.getResource("/images/shield.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		pbCargando = new JProgressBar();
		pbCargando.setBounds(10, 74, 416, 17);
		contentPane.add(pbCargando);
		
		lblCargando = new JLabel("Cargando aplicaci\u00F3n...");
		lblCargando.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCargando.setBounds(10, 47, 138, 17);
		contentPane.add(lblCargando);
		
		lblNewLabel_1 = new JLabel("ESPERE POR FAVOR");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 20, 416, 17);
		contentPane.add(lblNewLabel_1);
		
		lblPorcentaje = new JLabel("New label");
		lblPorcentaje.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPorcentaje.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPorcentaje.setBounds(365, 47, 61, 17);
		contentPane.add(lblPorcentaje);
	}
	
	// Method for Timing the login
	void timingIngresar() {
		Ingresar ingresar = new Ingresar();
		ingresar.start();
	}
	
	// Setting the Timing Method as soon as it's run
	protected void windowOpenedThis(WindowEvent e) {
		timingIngresar();
	}
}
