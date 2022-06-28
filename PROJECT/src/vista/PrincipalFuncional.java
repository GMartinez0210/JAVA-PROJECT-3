package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.Cursor;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import Hilos.MenuAnimacion;
import arrayList.IngresarList;
import entidad.Ingresar;
import entidad.Usuario;
import mantenimiento.GestionIngresarDAO;
import mantenimiento.GestionUsuariosDAO;
import java.awt.GridLayout;
import java.awt.CardLayout;

public class PrincipalFuncional extends JFrame {

	// Globales privadas
	private JPanel contentPane;
	private JDesktopPane desktopPane;
	private JButton NavForm1;
	private JButton NavForm2;
	private JButton NavForm3;
	private JButton NavForm4;
	private JLabel lblNombre;
	private JButton btnSalir;
	private JDesktopPane escritorio;

	// Globales publicas estaticas
	public static int codUsuario;
	
	public static JPanel panelMenu;
	public static JLabel lblMenu;

	// ArrayList 
	IngresarList ingresarList = new IngresarList();
	GestionUsuariosDAO gUsuario = new GestionUsuariosDAO();
	
	public Usuario usuario = gUsuario.leerUsuario(codUsuario);
	public String nombre = usuario.getNombre();
	private JButton btnCambiar;
	

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalFuncional frame = new PrincipalFuncional();
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
	public PrincipalFuncional() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				windowOpenedThis(e);
			}
		});
		setBackground(new Color(123,155,189));
		setTitle("Try Hacking me");
		setIconImage(Toolkit.getDefaultToolkit().getImage(PrincipalFuncional.class.getResource("/images/shield.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(123,155,189));
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		panelMenu = new JPanel();
		panelMenu.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		panelMenu.setBackground(new Color(126,173,189));
		panelMenu.setBounds(10, 52, 170, 491);
		desktopPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		NavForm1 = new JButton("New label");
		NavForm1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedNavForm1(e);
			}
		});
		NavForm1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		NavForm1.setForeground(new Color(0, 0, 0));
		NavForm1.setBackground(new Color(255, 255, 255));
		NavForm1.setHorizontalAlignment(SwingConstants.LEFT);
		NavForm1.setOpaque(true);
		NavForm1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		NavForm1.setBounds(10, 90, 150, 30);
		panelMenu.add(NavForm1);
		
		NavForm2 = new JButton("New label");
		NavForm2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedNavForm2(e);
			}
		});
		NavForm2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		NavForm2.setForeground(new Color(0, 0, 0));
		NavForm2.setBackground(new Color(255, 255, 255));
		NavForm2.setHorizontalAlignment(SwingConstants.LEFT);
		NavForm2.setOpaque(true);
		NavForm2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		NavForm2.setBounds(10, 140, 150, 30);
		panelMenu.add(NavForm2);
		
		NavForm3 = new JButton("New label");
		NavForm3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedNavForm3(e);
			}
		});
		NavForm3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		NavForm3.setForeground(new Color(0, 0, 0));
		NavForm3.setBackground(new Color(255, 255, 255));
		NavForm3.setHorizontalAlignment(SwingConstants.LEFT);
		NavForm3.setOpaque(true);
		NavForm3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		NavForm3.setBounds(10, 190, 150, 30);
		panelMenu.add(NavForm3);
		
		NavForm4 = new JButton("New label");
		NavForm4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedNavForm4(e);
			}
		});
		NavForm4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		NavForm4.setForeground(new Color(0, 0, 0));
		NavForm4.setBackground(new Color(255, 255, 255));
		NavForm4.setHorizontalAlignment(SwingConstants.LEFT);
		NavForm4.setOpaque(true);
		NavForm4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		NavForm4.setBounds(10, 240, 150, 30);
		panelMenu.add(NavForm4);
		
		btnSalir = new JButton("Salir");
		btnSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnSalir(e);
			}
		});
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setOpaque(true);
		btnSalir.setBackground(new Color(220, 20, 60));
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalir.setBounds(10, 435, 150, 30);
		
		panelMenu.add(btnSalir);
		
		lblNombre = new JLabel("Nombre Apellido");
		lblNombre.setBackground(new Color(255, 255, 255));
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setOpaque(true);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(10, 20, 150, 30);
		panelMenu.add(lblNombre);
		
		btnCambiar = new JButton("Cambiar Usuario");
		btnCambiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnCambiar(e);
			}
		});
		btnCambiar.setOpaque(true);
		btnCambiar.setForeground(Color.WHITE);
		btnCambiar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCambiar.setBackground(new Color(220, 20, 60));
		btnCambiar.setBounds(10, 395, 150, 30);
		panelMenu.add(btnCambiar);
		
		lblMenu = new JLabel("\r\n");
		lblMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mouseClickedLblMenu(e);
			}
		});
		lblMenu.setIcon(new ImageIcon(PrincipalFuncional.class.getResource("/images/nav-cancel.png")));
		lblMenu.setBounds(10, 10, 45, 32);
		desktopPane.add(lblMenu);
		
		escritorio = new JDesktopPane();
		escritorio.setBackground(new Color(123,155,189));
		escritorio.setBounds(65, 0, 711, 553);
		desktopPane.add(escritorio);
		escritorio.setLayout(new CardLayout(0, 0));
	
		ingresar();
	}
	
	private void habilitandoForms(boolean bool) {
		NavForm1.setVisible(bool);
		NavForm2.setVisible(bool);
		NavForm3.setVisible(bool);
		NavForm4.setVisible(bool);
	}
	
	private void ingresar() {
		try {
			
			lblNombre.setText(nombre);
					
			int idCategoria = usuario.getIdCargo();
			
			switch (idCategoria) {
				case 1: 
					habilitandoForms(false);
					
					NavForm1.setVisible(true);
					
					NavForm1.setText("Reporte");
						break;
				case 2: 
					habilitandoForms(true);
					
					NavForm1.setText("Comunica");
					NavForm2.setText("Deriva");
					NavForm3.setText("Seguimiento");
					NavForm4.setText("Alerta");
						break;
				case 3: 
					habilitandoForms(true);
					
					NavForm1.setText("Registro");
					NavForm2.setText("Estimacion");
					NavForm3.setText("Comunica");
					NavForm4.setText("Atencion");
						break;
			}
		} 
		catch (Exception e) {
			System.out.println(">>> ERROR: " + e.getMessage());
		}
	}
	
	// Windows Opened event handler to set the values making this functional
	protected void windowOpenedThis(WindowEvent e) {
		Usuario usuario = gUsuario.leerUsuario(codUsuario);
		String nombreCompleto = usuario.getNombre() + " " + usuario.getApellido();
		JOptionPane.showMessageDialog(this, "BIENVENIDO/A " + nombreCompleto, "Try hacking me", 1);

	}
	
	// Click Event Handler on Menu
	protected void mouseClickedLblMenu(MouseEvent e) {
		MenuAnimacion menuAnimacion = new MenuAnimacion();
		menuAnimacion.start();
	}
	
	// Button Salir
	protected void actionPerformedBtnSalir(ActionEvent e) {
		System.exit(0);
	}
	
	// Button Cambiar Uusario
	protected void actionPerformedBtnCambiar(ActionEvent e) {
		Login login = new Login();
		login.setVisible(true);
		dispose();
	}
	
	// NavForm1 Button
	protected void actionPerformedNavForm1(ActionEvent e) {
		Usuario usuario = gUsuario.leerUsuario(codUsuario);
		int idCategoria = usuario.getIdCargo();
		
		switch(idCategoria) {
			case 1: 
				FrmReporte reporte = new FrmReporte();
				escritorio.add(reporte);
				reporte.setVisible(true);
					break;
			case 2: 
				FrmComunica comunica = new FrmComunica();
				escritorio.add(comunica);
				comunica.setVisible(true);
					break;
			case 3: 
				FrmRegistro registro = new FrmRegistro();
				escritorio.add(registro);
				registro.setVisible(true);
					break;

		}
		
		MenuAnimacion menuAnimacion = new MenuAnimacion();
		menuAnimacion.start();
	}
	// NavForm2 Button	
	protected void actionPerformedNavForm2(ActionEvent e) {
		Usuario usuario = gUsuario.leerUsuario(codUsuario);
		int idCategoria = usuario.getIdCargo();
		
		switch(idCategoria) {
			case 2: 
				FrmDerivacion deriva = new FrmDerivacion();
				escritorio.add(deriva);
				deriva.setVisible(true);
					break;
			case 3: 
				FrmEstimacion estimacion = new FrmEstimacion();
				escritorio.add(estimacion);
				estimacion.setVisible(true);
					break;
		}
		
		MenuAnimacion menuAnimacion = new MenuAnimacion();
		menuAnimacion.start();
	}
	
	// NavForm3 Button
	protected void actionPerformedNavForm3(ActionEvent e) {
		Usuario usuario = gUsuario.leerUsuario(codUsuario);
		int idCategoria = usuario.getIdCargo();
		
		switch(idCategoria) {
			case 2: 
				FrmSeguimiento seguimiento = new FrmSeguimiento();
				escritorio.add(seguimiento);
				seguimiento.setVisible(true);
					break;
			case 3: 
				FrmComunica comunica = new FrmComunica();
				escritorio.add(comunica);
				comunica.setVisible(true);
					break;
		}
		
		MenuAnimacion menuAnimacion = new MenuAnimacion();
		menuAnimacion.start();
	}

	// NavForm4 Button
	protected void actionPerformedNavForm4(ActionEvent e) {
		Usuario usuario = gUsuario.leerUsuario(codUsuario);
		int idCategoria = usuario.getIdCargo();
		
		switch(idCategoria) {
			case 2: 
				FrmIngresarAlerta alerta = new FrmIngresarAlerta();
				escritorio.add(alerta);
				alerta.setVisible(true);
					break;
			case 3: 
				FrmAtencion atencion = new FrmAtencion();
				escritorio.add(atencion);
				atencion.setVisible(true);
					break;
		}
		
		MenuAnimacion menuAnimacion = new MenuAnimacion();
		menuAnimacion.start();
	}
}
