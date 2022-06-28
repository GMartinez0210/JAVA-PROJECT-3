package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entidad.Mensaje;
import entidad.Usuario;
import mantenimiento.GestionUsuariosDAO;
import mantenimiento.GestiosMensajeDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.ScrollPane;
import java.awt.TextArea;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;

public class FrmComunica extends JInternalFrame {


	// usuario
	int usuarioActual = PrincipalFuncional.codUsuario;

	// usuario buscado en la bd
	GestionUsuariosDAO gUsuario = new GestionUsuariosDAO();
	Usuario usuario = gUsuario.leerUsuario(usuarioActual);
	int cargoUsuario = usuario.getIdCargo();
	
	GestiosMensajeDAO gMsj = new GestiosMensajeDAO();

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblTitulo;
	private JLabel lblAsunto;
	private JLabel lblNewLabel_2;
	private JTextField txtReceptor;
	private JTextField txtAsunto;
	private JButton btnEnviar;
	private JButton btnLimpiarMjs;
	private JButton btnLimpiarTodo;
	private JTextArea txtMensaje;
	private JButton btnListar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmComunica frame = new FrmComunica();
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
	public FrmComunica() {
		setClosable(true);
		setBorder(null);
		setBounds(100, 100, 711, 553);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("Receptor:");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblNewLabel.setBounds(106, 88, 80, 18);
		contentPane.add(lblNewLabel);

		lblTitulo = new JLabel("Enviar Mensaje");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 22));
		lblTitulo.setBounds(0, 30, 685, 29);
		contentPane.add(lblTitulo);

		lblAsunto = new JLabel("Mensaje:");
		lblAsunto.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblAsunto.setBounds(106, 168, 80, 18);
		contentPane.add(lblAsunto);

		lblNewLabel_2 = new JLabel("Asunto:");
		lblNewLabel_2.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblNewLabel_2.setBounds(106, 128, 80, 18);
		contentPane.add(lblNewLabel_2);

		txtReceptor = new JTextField();
		txtReceptor.setBounds(206, 88, 343, 20);
		contentPane.add(txtReceptor);
		txtReceptor.setColumns(10);

		txtAsunto = new JTextField();
		txtAsunto.setBounds(206, 128, 343, 20);
		contentPane.add(txtAsunto);
		txtAsunto.setColumns(10);

		btnEnviar = new JButton("Enviar");
		btnEnviar.setBackground(new Color(0, 255, 0));
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnEnviar(e);
			}
		});
		btnEnviar.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnEnviar.setBounds(281, 443, 108, 29);
		contentPane.add(btnEnviar);

		btnLimpiarMjs = new JButton("Limpiar Mensaje");
		btnLimpiarMjs.setBackground(new Color(0, 255, 127));
		btnLimpiarMjs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnLimpiarMjs(e);
			}
		});
		btnLimpiarMjs.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnLimpiarMjs.setBounds(432, 443, 131, 29);
		contentPane.add(btnLimpiarMjs);

		btnLimpiarTodo = new JButton("Limpiar Todo");
		btnLimpiarTodo.setBackground(new Color(0, 255, 127));
		btnLimpiarTodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnLimpiarTodo(e);
			}
		});
		btnLimpiarTodo.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnLimpiarTodo.setBounds(106, 443, 132, 29);
		contentPane.add(btnLimpiarTodo);
		
		txtMensaje = new JTextArea();
		txtMensaje.setWrapStyleWord(true);
		txtMensaje.setBounds(206, 166, 343, 229);
		contentPane.add(txtMensaje);
		
		btnListar = new JButton("");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnListar(e);
			}
		});
		btnListar.setIcon(new ImageIcon(FrmComunica.class.getResource("/images/to-do-list.png")));
		btnListar.setBounds(106, 356, 48, 39);
		contentPane.add(btnListar);
		btnListar.setVisible(false);

		if (cargoUsuario == 2) {
			lblTitulo.setText("Enviar Mensaje a Personal de Servicio");
			txtReceptor.setEditable(false);
			txtReceptor.setText("psJimmy@MesaServico.net");
		} else if (cargoUsuario == 4) {
			btnListar.setVisible(true);			
		} else {
			lblTitulo.setText("Enviar Mensaje");
			txtReceptor.setEditable(true);
			txtReceptor.setText("");
		}
	}
	protected void actionPerformedBtnLimpiarTodo(ActionEvent e) {
		if(cargoUsuario != 2) 
			txtReceptor.setText("");

		txtMensaje.setText("");
		txtAsunto.setText("");
	}
	
	protected void actionPerformedBtnLimpiarMjs(ActionEvent e) {
		txtMensaje.setText("");
	}
	
	protected void actionPerformedBtnEnviar(ActionEvent e) {
		enviarMensaje();
	}
	
	protected void actionPerformedBtnListar(ActionEvent e) {
		abrirDlgListarMensajes();
	}
	
	private void abrirDlgListarMensajes() {
		DlgListarMensajes lM = new DlgListarMensajes();
		lM.setVisible(true);
		lM.setLocationRelativeTo(this);
	}

	private void enviarMensaje() {
		if(validarReceptor()) {
			try {	
				Properties props = new Properties();
				props.setProperty("mail.smtp.host", "smtp.gmail.com");
				props.setProperty("mail.smtp.starttls.enable", "true");
				props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
				props.setProperty("mail.smtp.port", "587");
				props.setProperty("mail.smtp.auth", "true");

				Session session = Session.getDefaultInstance(props);

				String correoRemitente = "fualanodetal1@gmail.com";
				String contraRemitente = "jxuehwywxcxnpbhd";
				String correoReceptor = txtReceptor.getText();
				String asunto = txtAsunto.getText();
				String mensaje = txtMensaje.getText();

				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress(correoRemitente));

				message.addRecipient(Message.RecipientType.TO, new InternetAddress(correoReceptor));
				message.setSubject(asunto);
				message.setText(mensaje);

				Transport t = session.getTransport("smtp");
				t.connect(correoRemitente, contraRemitente);
				t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
				t.close();

				registrarMensaje(correoReceptor, asunto, mensaje, usuarioActual); // registra el mensaje en la base de datos
				JOptionPane.showMessageDialog(null, "enviado...");
			} catch(AddressException e1) {
				System.out.println("error "+ e1);
			} catch(MessagingException e2) {
				System.out.println("error "+ e2);
			}
		} else {
			txtReceptor.setText("");
			txtReceptor.requestFocus();
			mensajeError("Usuario no valido");
		}
	}

	private void registrarMensaje(String correoReceptor, String asunto, String mensaje, int usuActual) {
		Mensaje msj = new Mensaje();
		
		msj.setCorreo(correoReceptor);
		msj.setAsunto(asunto);
		msj.setMensaje(mensaje);
		msj.setCodUser(usuActual);
		
		int res = gMsj.registrar(msj);
		
		if(res == 0) {
			mensajeError("Error en el registro");
		}
	}

	private void mensajeError(String msj) {
		JOptionPane.showMessageDialog(this, msj, "ERROR!!!!!", 0);
	}

	private boolean validarReceptor() {
		String receptor = txtReceptor.getText().trim();
		String regx = "^[A-Za-z0-9+_.-]+@(.+)$";   
        Pattern pattern = Pattern.compile(regx);
        Matcher matcher = pattern.matcher(receptor); 

		return matcher.matches();
	}
}