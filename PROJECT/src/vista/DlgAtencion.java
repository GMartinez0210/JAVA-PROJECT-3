package vista;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import com.toedter.calendar.JDateChooser;
import entidad.Alerta;
import mantenimiento.GestionAlertaDAO;
import java.text.SimpleDateFormat;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class DlgAtencion extends JDialog {
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	public static JTextArea txtDescripcion;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_5;
	private JDateChooser dtcFecha;
	private JLabel lblNewLabel_6;
	private JButton btnGuardar;
	GestionAlertaDAO gAlert = new GestionAlertaDAO();
	public static JTextField txtCodigo;
	public static JTextField txtFecha;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgAtencion dialog = new DlgAtencion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the dialog.
	 */
	public DlgAtencion() {
		setResizable(false);
		setTitle("Atenci\u00F3n");
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setBounds(100, 100, 394, 335);
		getContentPane().setLayout(null);
		{
			JLabel lblNewLabel_4 = new JLabel("ATENCI\u00D3N");
			lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 17));
			lblNewLabel_4.setBounds(140, 11, 100, 21);
			getContentPane().add(lblNewLabel_4);
		}
		{
			lblNewLabel = new JLabel("Cod. Formulario:");
			lblNewLabel.setForeground(new Color(153, 51, 0));
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel.setBounds(10, 44, 138, 14);
			getContentPane().add(lblNewLabel);
		}
		{
			lblNewLabel_1 = new JLabel("Fecha:");
			lblNewLabel_1.setForeground(new Color(153, 51, 0));
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_1.setBounds(10, 70, 138, 14);
			getContentPane().add(lblNewLabel_1);
		}
		{
			lblNewLabel_2 = new JLabel("Descripci\u00F3n corta:");
			lblNewLabel_2.setForeground(new Color(153, 51, 0));
			lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_2.setBounds(10, 99, 138, 14);
			getContentPane().add(lblNewLabel_2);
		}
		{
			txtDescripcion = new JTextArea();
			txtDescripcion.setFont(new Font("Courier New", Font.PLAIN, 12));
			txtDescripcion.setEditable(false);
			txtDescripcion.setBounds(176, 100, 191, 78);
			getContentPane().add(txtDescripcion);
		}
		{
			lblNewLabel_3 = new JLabel("_______________________________________________________________________________");
			lblNewLabel_3.setBounds(-42, 175, 521, 14);
			getContentPane().add(lblNewLabel_3);
		}
		{
			lblNewLabel_5 = new JLabel("ASIGNAR FECHA");
			lblNewLabel_5.setForeground(new Color(0, 0, 0));
			lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 17));
			lblNewLabel_5.setBounds(115, 194, 147, 21);
			getContentPane().add(lblNewLabel_5);
		}
		{
			dtcFecha = new JDateChooser();
			dtcFecha.setDateFormatString("yyyy-MM-dd");
			dtcFecha.setBounds(176, 226, 122, 20);
			getContentPane().add(dtcFecha);
		}
		{
			lblNewLabel_6 = new JLabel("Fecha:");
			lblNewLabel_6.setForeground(new Color(153, 51, 0));
			lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_6.setBounds(84, 227, 106, 14);
			getContentPane().add(lblNewLabel_6);
		}
		{
			btnGuardar = new JButton("Guardar");
			btnGuardar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnGuardar(e);
				}
			});
			btnGuardar.setBackground(Color.WHITE);
			btnGuardar.setForeground(Color.DARK_GRAY);
			btnGuardar.setBounds(140, 257, 100, 28);
			getContentPane().add(btnGuardar);
		}
		{
			txtCodigo = new JTextField();
			txtCodigo.setEditable(false);
			txtCodigo.setBounds(176, 43, 191, 20);
			getContentPane().add(txtCodigo);
			txtCodigo.setColumns(10);
		}
		{
			txtFecha = new JTextField();
			txtFecha.setEditable(false);
			txtFecha.setColumns(10);
			txtFecha.setBounds(176, 69, 191, 20);
			getContentPane().add(txtFecha);
		}
	}

	private void mensajeError(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Error", 0);
	}
	
	private void mensajeExitoso(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Sistema", 1);
	}
	protected void actionPerformedBtnGuardar(ActionEvent e) {
		String fecha;
		java.util.Date fec;
		String formato;
		formato = dtcFecha.getDateFormatString();
		SimpleDateFormat sdf = new SimpleDateFormat(formato);
		fec = dtcFecha.getDate();
		fecha = String.valueOf(sdf.format(fec));
		int confirm = JOptionPane.showConfirmDialog(btnGuardar, "¿La fecha: "+fecha+ " Es correcta?");
		if (confirm == 0) {
			actualizarFecha();
			dispose();
		}else {
			return;
		}
	}

	private void actualizarFecha() {
		int cod;
		String fecha;
		java.util.Date fec;
		String formato;
		cod = Integer.parseInt(txtCodigo.getText());
		formato = dtcFecha.getDateFormatString();
		SimpleDateFormat sdf = new SimpleDateFormat(formato);
		fec = dtcFecha.getDate();
		fecha = String.valueOf(sdf.format(fec));
		Alerta alerta = new Alerta();
		alerta.setPlazoatencion(fecha);;
		alerta.setCod(cod);
		int ok = gAlert.asignarFechaAlerta(alerta);
		if(ok == 0) {
			mensajeError("Error al asignar fecha.");
		}
		else {
			mensajeExitoso("Asignación de plazo exitosa.");
		}
	}
}
