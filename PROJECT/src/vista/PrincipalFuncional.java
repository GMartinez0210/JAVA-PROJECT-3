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
	private JButton NavForm6;
	private JLabel lblNombre;
	private JButton NavForm5;
	private JButton btnSalir;

	// Globales publicas estaticas
	public static int codUsuario;
	
	public static JPanel panelMenu;
	public static JLabel lblMenu;

	// ArrayList 
	IngresarList ingresarList = new IngresarList();
	GestionUsuariosDAO gUsuario = new GestionUsuariosDAO();
	private JDesktopPane escritorio;
	
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
		setBackground(Color.WHITE);
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
		desktopPane.setBackground(new Color(0, 128, 128));
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		panelMenu = new JPanel();
		panelMenu.setBackground(new Color(255, 250, 240));
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
		NavForm1.setForeground(new Color(0, 128, 128));
		NavForm1.setBackground(new Color(255, 250, 240));
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
		NavForm2.setForeground(new Color(0, 128, 128));
		NavForm2.setBackground(new Color(255, 250, 240));
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
		NavForm3.setForeground(new Color(0, 128, 128));
		NavForm3.setBackground(new Color(255, 250, 240));
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
		NavForm4.setForeground(new Color(0, 128, 128));
		NavForm4.setBackground(new Color(255, 250, 240));
		NavForm4.setHorizontalAlignment(SwingConstants.LEFT);
		NavForm4.setOpaque(true);
		NavForm4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		NavForm4.setBounds(10, 240, 150, 30);
		panelMenu.add(NavForm4);
		
		NavForm5 = new JButton("New label");
		NavForm5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedNavForm5(e);
			}
		});
		NavForm5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		NavForm5.setForeground(new Color(0, 128, 128));
		NavForm5.setBackground(new Color(255, 250, 240));
		NavForm5.setHorizontalAlignment(SwingConstants.LEFT);
		NavForm5.setOpaque(true);
		NavForm5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		NavForm5.setBounds(10, 290, 150, 30);
		panelMenu.add(NavForm5);
		
		NavForm6 = new JButton("New label");
		NavForm6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedNavForm6(e);
			}
		});
		NavForm6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		NavForm6.setForeground(new Color(0, 128, 128));
		NavForm6.setBackground(new Color(255, 250, 240));
		NavForm6.setHorizontalAlignment(SwingConstants.LEFT);
		NavForm6.setOpaque(true);
		NavForm6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		NavForm6.setBounds(10, 340, 150, 30);
		panelMenu.add(NavForm6);
		
		lblNombre = new JLabel("Nombre Apellido");
		lblNombre.setBackground(new Color(255, 250, 240));
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setOpaque(true);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(10, 20, 150, 30);
		panelMenu.add(lblNombre);
		
		btnSalir = new JButton("Salir");
		btnSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnSalir(e);
			}
		});
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setOpaque(true);
		btnSalir.setBackground(Color.RED);
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalir.setBounds(10, 435, 150, 30);
		
		panelMenu.add(btnSalir);
		
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
		escritorio.setBackground(new Color(0, 128, 128));
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
		NavForm5.setVisible(bool);
		NavForm6.setVisible(bool);
	}
	
	private void ingresar() {
		try {
			Usuario usuario = gUsuario.leerUsuario(codUsuario);
			
			String nombre = usuario.getNombre();
			
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
					
					NavForm4.setVisible(false);
					NavForm5.setVisible(false);
					NavForm6.setVisible(false);
					
					NavForm1.setText("Reporte");
					NavForm2.setText("Comunica");
					NavForm3.setText("Deriva");
						break;
				case 3: 
					habilitandoForms(false);
					
					NavForm1.setVisible(true);
					
					NavForm1.setText("Reporte");
						break;
				case 4: 
					habilitandoForms(true);
					
					NavForm5.setVisible(false);
					NavForm6.setVisible(false);
					
					NavForm1.setText("Registro");
					NavForm2.setText("Evalua");
					NavForm3.setText("Comunica");
					NavForm4.setText("Atencion");
						break;
				case 5: 
					habilitandoForms(false);
					NavForm1.setVisible(true);
					NavForm1.setText("Reporte");
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
	
	// NavForm1 Button
	protected void actionPerformedNavForm1(ActionEvent e) {
		Usuario usuario = gUsuario.leerUsuario(codUsuario);
		int idCategoria = usuario.getIdCargo();
		
		switch(idCategoria) {
			case 3: 
				FrmRegistro registro = new FrmRegistro();
				escritorio.add(registro);
				registro.setVisible(true);
					break;
			default: 
				FrmReporte reporte = new FrmReporte();
				escritorio.add(reporte);
				reporte.setVisible(true);
					break;
		}
	}
	// NavForm2 Button	
	protected void actionPerformedNavForm2(ActionEvent e) {
		Usuario usuario = gUsuario.leerUsuario(codUsuario);
		int idCategoria = usuario.getIdCargo();
		
		switch(idCategoria) {
			case 2: 
				FrmComunica comunica = new FrmComunica();
				escritorio.add(comunica);
				comunica.setVisible(true);
					break;
			case 4: 
				FrmIngresarAlerta ingresarAlerta = new FrmIngresarAlerta();
				escritorio.add(ingresarAlerta);
				ingresarAlerta.setVisible(true);
					break;
		}
	}
	
	// NavForm3 Button
	protected void actionPerformedNavForm3(ActionEvent e) {
		Usuario usuario = gUsuario.leerUsuario(codUsuario);
		int idCategoria = usuario.getIdCargo();
		
		switch(idCategoria) {
			case 2: 
				FrmDerivacion deriva = new FrmDerivacion();
				escritorio.add(deriva);
				deriva.setVisible(true);
					break;
			case 4: 
				FrmComunica comunica = new FrmComunica();
				escritorio.add(comunica);
				comunica.setVisible(true);
					break;
		}
	}

	// NavForm4 Button
	protected void actionPerformedNavForm4(ActionEvent e) {
		FrmAtencion atencion = new FrmAtencion();
		escritorio.add(atencion);
		atencion.setVisible(true);
	}
	
	// NavForm5 Button
	protected void actionPerformedNavForm5(ActionEvent e) {
	}
	
	// NavForm6 Button
	protected void actionPerformedNavForm6(ActionEvent e) {
	}
	
	/*
	
	 switch (idCategoria) {
				case 1: 
					habilitandoForms(false);
					
					NavForm1.setVisible(true);
					
					NavForm1.setText("Reporte");
						break;
				case 2: 
					habilitandoForms(true);
					
					NavForm4.setVisible(false);
					NavForm5.setVisible(false);
					NavForm6.setVisible(false);
					
					NavForm1.setText("Reporte");
					NavForm2.setText("Comunica");
					NavForm3.setText("Deriva");
						break;
				case 3: 
					habilitandoForms(false);
					
					NavForm1.setVisible(true);
					
					NavForm1.setText("Reporte");
						break;
				case 4: 
					habilitandoForms(true);
					
					NavForm5.setVisible(false);
					NavForm6.setVisible(false);
					
					NavForm1.setText("Registro");
					NavForm2.setText("Evalua");
					NavForm3.setText("Comunica");
					NavForm4.setText("Atencion");
						break;
				case 5: 
					habilitandoForms(false);
					NavForm1.setVisible(true);
					NavForm1.setText("Reporte");
						break;
						
			}
	 
	*/
}
