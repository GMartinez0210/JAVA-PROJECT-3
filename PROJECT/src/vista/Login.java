package vista;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.swing.JPasswordField;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import entidad.Ingresar;
import entidad.Usuario;
import mantenimiento.GestionIngresarDAO;
import java.awt.Color;

public class Login extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblContrasea;
	private JButton btnIngresar;
	private JLabel lblNewLabel_1;
	private JTextField txtDNI;
	private JPasswordField txtContrasenia;
	
	GestionIngresarDAO gIngresar = new GestionIngresarDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setResizable(false);
		setTitle("Try Hacking me");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/images/shield.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 250);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(123,155,189,74));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("DNI");
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNewLabel.setBounds(32, 112, 88, 13);
		contentPane.add(lblNewLabel);
		
		lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblContrasea.setBounds(32, 141, 88, 13);
		contentPane.add(lblContrasea);
		
		txtDNI = new JTextField();
		txtDNI.setBackground(new Color(255, 255, 255));
		txtDNI.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtDNI.setColumns(10);
		txtDNI.setBounds(130, 112, 131, 19);
		contentPane.add(txtDNI);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.setBackground(new Color(255, 255, 255));
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnIngresar(e);
			}
		});
		btnIngresar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnIngresar.setBounds(319, 109, 85, 21);
		contentPane.add(btnIngresar);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/images/shield-16.png")));
		lblNewLabel_1.setBounds(32, 25, 38, 52);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Try Hacking me");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(80, 36, 146, 28);
		contentPane.add(lblNewLabel_2);
		
		txtContrasenia = new JPasswordField();
		txtContrasenia.setBackground(new Color(255, 255, 255));
		txtContrasenia.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				keyTypedTxtContrasenia(e);
			}
		});
		txtContrasenia.setBounds(130, 140, 131, 19);
		contentPane.add(txtContrasenia);
	}
	
	void Ingresar() {
		String dni = txtDNI.getText();
		String password = new String(txtContrasenia.getPassword());
		String fecha = String.valueOf(LocalDate.now());
		String hora =  String.valueOf(LocalTime.now().getHour());
		String minutos = String.valueOf(LocalTime.now().getMinute());
		String segundos = String.valueOf(LocalTime.now().getSecond());
		String fullHora = String.valueOf(hora + ":" + minutos + ":" + segundos);
		
		if (dni.length() == 0) {
			JOptionPane.showMessageDialog(null, "Ingrese DNI", "ERROR", 0);
			return;
		}
		
		if (password.length() == 0) {
			JOptionPane.showMessageDialog(null, "Ingrese clave", "ERROR", 0);
			return;
		}
		
		Ingresar ingresar = new Ingresar();
		ingresar.setDniUsuario(dni);
		ingresar.setPasswordUsuario(password);
		ingresar.setFecha(fecha);
		ingresar.setHora(fullHora);
		
		Usuario usuario = gIngresar.login(ingresar);
		
		if (usuario == null) {
			JOptionPane.showMessageDialog(null, "Usuario nulo", "ERROR", 0);
			return;
		}
		
		PrincipalFuncional.codUsuario = usuario.getCodigo();
		
		JOptionPane.showMessageDialog(null, "Ingresaste satisfactoriamente", "Sistema", 1);
		dispose();
		PreLoader preloader = new PreLoader();
		preloader.setVisible(true);
	}
	
	// Button Ingrsar
	protected void actionPerformedBtnIngresar(ActionEvent e) {	
		Ingresar();
	}
	
	// Enter para campo contraseña
	protected void keyTypedTxtContrasenia(KeyEvent e) {
		if(e.getKeyChar() == e.VK_ENTER) {
			Ingresar();
		}
	}
}
