package vista;

import java.awt.Cursor;
import java.awt.EventQueue;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import entidad.Alerta;
import mantenimiento.GestionAlertaDAO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class FrmAtencion extends JInternalFrame{
	public static JTable tblAlertas;
	private JButton btnAsignarFecha;
	private JLabel lblDerivarAlertas;
	private JScrollPane scrollPane;
	DefaultTableModel model = new DefaultTableModel();
	GestionAlertaDAO gAlert = new GestionAlertaDAO();
	private JLabel lblNewLabel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAtencion frame = new FrmAtencion();
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
	public FrmAtencion() {
		setClosable(true);
		setBounds(100, 100, 595, 374);
		getContentPane().setLayout(null);
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 47, 559, 246);
			getContentPane().add(scrollPane);
			{
				tblAlertas = new JTable();
				tblAlertas.setFillsViewportHeight(true);
				scrollPane.setViewportView(tblAlertas);
				tblAlertas.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
					}
				));
			}
		}
		{
			btnAsignarFecha = new JButton("Asignar Fecha");
			btnAsignarFecha.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnAsignarFecha(e);
				}
			});
			btnAsignarFecha.setBounds(230, 304, 118, 29);
			getContentPane().add(btnAsignarFecha);
		}
		{
			lblDerivarAlertas = new JLabel("ATENDER ALERTAS");
			lblDerivarAlertas.setFont(new Font("Tahoma", Font.PLAIN, 24));
			lblDerivarAlertas.setBounds(176, 11, 217, 29);
			getContentPane().add(lblDerivarAlertas);
		}
		model.addColumn("Codigo");
		model.addColumn("Cod. Usuario");
		model.addColumn("Fecha");
		model.addColumn("Descripcion");
		model.addColumn("Relevancia");
		tblAlertas.setModel(model);
		{
			lblNewLabel = new JLabel("");
			lblNewLabel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					mouseClickedLblNewLabel(e);
				}
				@Override
				public void mouseEntered(MouseEvent e) {
					mouseEnteredLblNewLabel(e);
				}
			});
			lblNewLabel.setIcon(new ImageIcon(FrmAtencion.class.getResource("/images/icons8-actualizar-30.png")));
			lblNewLabel.setBounds(526, 11, 30, 29);
			getContentPane().add(lblNewLabel);
		}
		mostrarTabla();
	}
	//Metodo Mostar Tabla
	private void mostrarTabla() {
		model.setRowCount(0);
		ArrayList<Alerta> alerta = gAlert.listarAlertasDerivadas();
		try {
			for(Alerta a : alerta) {
				Object fila[] = {a.getCod(),
						 		  a.getCodUsu(),
						 		  a.getFec(),
						 		  a.getBreveDes(),
						 		  a.getRelevancia()};
				model.addRow(fila);
			}
		}catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
	//Botón Asignar Fecha
	protected void actionPerformedBtnAsignarFecha(ActionEvent e) {
		try{
			DlgAtencion dialog = new DlgAtencion();
			enviarDatos();
			dialog.setVisible(true);
		}catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Debe seleccionar una alerta de la tabla");
		}
	}
	//Método enviar datos a JDialog
	public void enviarDatos() {
		int fila;
		String cod, fecha, descrip;
		fila = tblAlertas.getSelectedRow();
		cod = tblAlertas.getValueAt(fila, 0).toString();
		fecha = tblAlertas.getValueAt(fila, 2).toString();
		descrip = tblAlertas.getValueAt(fila, 3).toString();
		DlgAtencion.txtCodigo.setText(cod);
		DlgAtencion.txtFecha.setText(fecha);
		DlgAtencion.txtDescripcion.setText(descrip);
	}
	//Evento Clicked del label actualizar tabla
	protected void mouseClickedLblNewLabel(MouseEvent e) {
		mostrarTabla();
		JOptionPane.showMessageDialog(this, "La tabla ha sido actualizada.");
	}
	//Evento Entered del label actualizar tabla
	protected void mouseEnteredLblNewLabel(MouseEvent e) {
		lblNewLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
}
