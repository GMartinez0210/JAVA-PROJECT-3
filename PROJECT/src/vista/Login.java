package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import vista.PreLoader;

public class Login extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblContrasea;
	private JButton btnIngresar;
	private JLabel lblNewLabel_1;
	private JTextField txtContrasenia;
	private JTextField txtUsuario;
	private JLabel lblNewLabel_3;
	
	public static JProgressBar pbIngresar;

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
		setTitle("Try Hacking me");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/images/shield.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(32, 112, 88, 13);
		contentPane.add(lblNewLabel);
		
		lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContrasea.setBounds(32, 141, 88, 13);
		contentPane.add(lblContrasea);
		
		txtContrasenia = new JTextField();
		txtContrasenia.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				keyTypedTxtContrasenia(e);
			}
		});
		txtContrasenia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtContrasenia.setBounds(130, 141, 131, 19);
		contentPane.add(txtContrasenia);
		txtContrasenia.setColumns(10);
		
		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(130, 112, 131, 19);
		contentPane.add(txtUsuario);
		
		btnIngresar = new JButton("Ingresar");
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
		
		pbIngresar = new JProgressBar();
		pbIngresar.setBounds(32, 224, 372, 11);
		contentPane.add(pbIngresar);
		
		lblNewLabel_3 = new JLabel("LA VENTANA SE CERRAR\u00C1 AL CARGAR LA BARRA");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(32, 196, 372, 17);
		contentPane.add(lblNewLabel_3);
	}
	
	void Ingresar(String user, String password) {
		String usuario = user;
		String contrasenia = password;
		
		if (contrasenia.equals("Panchito")) {
			JOptionPane.showMessageDialog(null, "Entraste, mano", "Sistema", 0);
		}
	}
	
	// Button Ingrsar
	protected void actionPerformedBtnIngresar(ActionEvent e) {
		String user = txtUsuario.getText();
		String password = txtContrasenia.getText();
		
		Ingresar(user, password);
		this.setVisible(false);
		PreLoader preloader = new PreLoader();
		preloader.setVisible(true);
	}
	
	// Event handler KeyTyped for Contrasenia
	protected void keyTypedTxtContrasenia(KeyEvent e) {
		if(e.getKeyChar() == e.VK_ENTER) {
			String user = txtUsuario.getText();
			String password = txtContrasenia.getText();
			
			Ingresar(user, password);
		}
	}
}
