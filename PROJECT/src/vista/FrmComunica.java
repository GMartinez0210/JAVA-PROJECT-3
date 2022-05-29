package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.TextArea;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.util.Properties;
import java.awt.event.ActionEvent;

public class FrmComunica extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField txtReceptor;
	private JTextField txtAsunto;
	private TextArea textArea;
	private JButton btnLimpiar;
	private JButton btnEnviar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FrmComunica dialog = new FrmComunica();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FrmComunica() {
		setBounds(100, 100, 626, 367);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblNewLabel = new JLabel("Receptor:");
		lblNewLabel.setBounds(45, 26, 91, 14);
		contentPanel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Asunto:");
		lblNewLabel_1.setBounds(45, 61, 117, 14);
		contentPanel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Mensaje:");
		lblNewLabel_2.setBounds(45, 102, 62, 14);
		contentPanel.add(lblNewLabel_2);
		
		txtReceptor = new JTextField();
		txtReceptor.setBounds(135, 23, 384, 20);
		contentPanel.add(txtReceptor);
		txtReceptor.setColumns(10);
		
		txtAsunto = new JTextField();
		txtAsunto.setBounds(135, 58, 384, 20);
		contentPanel.add(txtAsunto);
		txtAsunto.setColumns(10);
		
		textArea = new TextArea();
		textArea.setBounds(135, 102, 384, 160);
		contentPanel.add(textArea);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(this);
		btnLimpiar.setBounds(135, 282, 134, 23);
		contentPanel.add(btnLimpiar);
		
		btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(this);
		btnEnviar.setBounds(385, 282, 134, 23);
		contentPanel.add(btnEnviar);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEnviar) {
			actionPerformedBtnEnviar(e);
		}
		if (e.getSource() == btnLimpiar) {
			actionPerformedBtnLimpiar(e);
		}
	}
	protected void actionPerformedBtnLimpiar(ActionEvent e) {
		txtReceptor.setText("");
		txtAsunto.setText("");
		textArea.setText("");
	}
	protected void actionPerformedBtnEnviar(ActionEvent e) {
		try {	
			Properties props = new Properties();
			props.setProperty("mail.smtp.host", "smtp.gmail.com");
			props.setProperty("mail.smtp.starttls.enable", "true");
			props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
			props.setProperty("mail.smtp.port", "587");
			props.setProperty("mail.smtp.auth", "true");
			
			Session session = Session.getDefaultInstance(props);
			
			String correoRemitente = "fualanodetal1@gmail.com";
			String contraRemitente = "gjK^xmJ9WMqQG;-:S-*L";
			String correoReceptor = txtReceptor.getText();
			String asunto = txtAsunto.getText();
			String mensaje = textArea.getText();
			
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(correoRemitente));
			
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(correoReceptor));
			message.setSubject(asunto);
			message.setText(mensaje);
			
			Transport t = session.getTransport("smtp");
			t.connect(correoRemitente, contraRemitente);
			t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
			t.close();
			
			JOptionPane.showMessageDialog(null, "enviado...");
		} catch(AddressException e1) {
			System.out.println("error "+ e1);
		} catch(MessagingException e2) {
			System.out.println("error "+ e2);
		}
	}
}
