package vista;

import javax.swing.JButton;
import javax.swing.JDialog;
import entidad.Alerta;
import mantenimiento.GestionAlertaDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class DlgDerivacion extends JDialog {
	private JLabel lblNewLabel;
	public static JTextField txtCodigo;
	public static JTextField txtCodUsu;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	public static JTextField txtFecha;
	private JLabel lblNewLabel_3;
	public static JTextArea txtDescripcion;
	private JLabel lblNewLabel_4;
	private JButton btnDerivar;
	private JScrollPane scrollPane;
	public static JLabel lblRelevante;
	GestionAlertaDAO gAlert = new GestionAlertaDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgDerivacion dialog = new DlgDerivacion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgDerivacion() {
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setBounds(100, 100, 391, 318);
		getContentPane().setLayout(null);
		{
			lblNewLabel = new JLabel("DERIVACION");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
			lblNewLabel.setBounds(131, 11, 125, 14);
			getContentPane().add(lblNewLabel);
		}
		{
			txtCodigo = new JTextField();
			txtCodigo.setEditable(false);
			txtCodigo.setColumns(10);
			txtCodigo.setBounds(176, 46, 191, 20);
			getContentPane().add(txtCodigo);
		}
		{
			txtCodUsu = new JTextField();
			txtCodUsu.setEditable(false);
			txtCodUsu.setColumns(10);
			txtCodUsu.setBounds(176, 71, 191, 20);
			getContentPane().add(txtCodUsu);
		}
		{
			lblNewLabel_1 = new JLabel("Cod. Formulario:");
			lblNewLabel_1.setForeground(new Color(153, 51, 0));
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_1.setBounds(10, 47, 138, 14);
			getContentPane().add(lblNewLabel_1);
		}
		{
			lblNewLabel_2 = new JLabel("Cod. Usuario");
			lblNewLabel_2.setForeground(new Color(153, 51, 0));
			lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_2.setBounds(10, 72, 138, 14);
			getContentPane().add(lblNewLabel_2);
		}
		{
			txtFecha = new JTextField();
			txtFecha.setEditable(false);
			txtFecha.setColumns(10);
			txtFecha.setBounds(176, 96, 191, 20);
			getContentPane().add(txtFecha);
		}
		{
			lblNewLabel_3 = new JLabel("Fecha:");
			lblNewLabel_3.setForeground(new Color(153, 51, 0));
			lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_3.setBounds(10, 97, 138, 14);
			getContentPane().add(lblNewLabel_3);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 147, 357, 63);
			getContentPane().add(scrollPane);
			{
				txtDescripcion = new JTextArea();
				scrollPane.setViewportView(txtDescripcion);
				txtDescripcion.setFont(new Font("Courier New", Font.PLAIN, 12));
				txtDescripcion.setEditable(false);
			}
		}
		{
			lblNewLabel_4 = new JLabel("Descripci\u00F3n:");
			lblNewLabel_4.setForeground(new Color(153, 51, 0));
			lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_4.setBounds(10, 122, 138, 14);
			getContentPane().add(lblNewLabel_4);
		}
		{
			btnDerivar = new JButton("Derivar");
			btnDerivar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnDerivar(e);
				}
			});
			btnDerivar.setForeground(Color.DARK_GRAY);
			btnDerivar.setBackground(Color.WHITE);
			btnDerivar.setBounds(140, 246, 100, 28);
			getContentPane().add(btnDerivar);
		}
		{
			lblRelevante = new JLabel("");
			lblRelevante.setHorizontalAlignment(SwingConstants.CENTER);
			lblRelevante.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblRelevante.setBounds(10, 221, 357, 14);
			getContentPane().add(lblRelevante);
		}
	}
	protected void actionPerformedBtnDerivar(ActionEvent e) {
		int confirm = JOptionPane.showConfirmDialog(btnDerivar, "¿Desea derivar esta alerta?");
		if (confirm == 0) {
			actualizarDato();
			dispose();
		}else {

		}
	}

	private void actualizarDato() {
		int cod;
		String deriv;
		cod = Integer.parseInt(txtCodigo.getText());
		deriv  = "SI";
		Alerta alerta = new Alerta();
		alerta.setDeriv(deriv);
		alerta.setCod(cod);
		
		int ok = gAlert.derivarAlerta(alerta);
		try {
			if(ok == 0) {
				JOptionPane.showMessageDialog(this, "Error al derivar.");
			}
			else {
				JOptionPane.showMessageDialog(this, "Derivado con éxito.");
			}			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
