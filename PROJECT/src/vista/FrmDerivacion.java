package vista;

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
import java.util.ArrayList;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Cursor;

@SuppressWarnings("serial")
public class FrmDerivacion extends JInternalFrame {
	private JLabel lblAtenderAlertas;
	public JTable tblAlertas;
	private JScrollPane scrollpane;
	DefaultTableModel model = new DefaultTableModel();
	GestionAlertaDAO gAlert = new GestionAlertaDAO();
	private JButton btnAtender;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmDerivacion frame = new FrmDerivacion();
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
	public FrmDerivacion() {
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 595, 374);
		getContentPane().setLayout(null);
		{
			lblAtenderAlertas = new JLabel("DERIVAR ALERTAS");
			lblAtenderAlertas.setFont(new Font("Tahoma", Font.PLAIN, 24));
			lblAtenderAlertas.setBounds(185, 11, 204, 29);
			getContentPane().add(lblAtenderAlertas);
		}
		{
			scrollpane = new JScrollPane();
			scrollpane.setBounds(10, 45, 559, 247);
			getContentPane().add(scrollpane);
			{
				tblAlertas = new JTable();
				tblAlertas.setFillsViewportHeight(true);
				scrollpane.setViewportView(tblAlertas);
			}
		}
		model.addColumn("Codigo");
		model.addColumn("Cod. Usuario");
		model.addColumn("Fecha");
		model.addColumn("Descripcion");
		model.addColumn("Relevancia");
		tblAlertas.setModel(model);
		{
			btnAtender = new JButton("Derivar");
			btnAtender.setBackground(Color.WHITE);
			btnAtender.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnAtender(e);
				}
			});
			btnAtender.setBounds(230, 303, 118, 29);
			getContentPane().add(btnAtender);
		}
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
			lblNewLabel.setIcon(new ImageIcon(FrmDerivacion.class.getResource("/images/icons8-actualizar-30.png")));
			lblNewLabel.setBounds(527, 11, 30, 29);
			getContentPane().add(lblNewLabel);
		}
		mostrarTabla();
	}

	private void mostrarTabla() {
		model.setRowCount(0);
		
		ArrayList<Alerta> alerta = gAlert.listarAlertas();
		try {
			for(Alerta a : alerta) {
				Object fila[] = {a.getCod(),
						 		  a.getCodUsu(),
						 		  a.getFec(),
						 		  a.getDes(),
						 		  a.getRelevancia()};
				model.addRow(fila);
			}
		}catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
	
	protected void mouseEnteredLblNewLabel(MouseEvent e) {
		lblNewLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	
	protected void mouseClickedLblNewLabel(MouseEvent e) {
		mostrarTabla();
		JOptionPane.showMessageDialog(this, "La tabla ha sido actualizada.");
	}
	
	protected void actionPerformedBtnAtender(ActionEvent e) {
		try{
			DlgDerivacion derivacion = new DlgDerivacion();
			enviarDatos();
			derivacion.setVisible(true);
		}catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Debe seleccionar una alerta de la tabla");
		}
	}

	private void enviarDatos() {
		int fila;
		String cod, codUsu, fecha, descrip, relevancia;
		fila = tblAlertas.getSelectedRow();
		cod = tblAlertas.getValueAt(fila, 0).toString();
		codUsu = tblAlertas.getValueAt(fila, 1).toString();
		fecha = tblAlertas.getValueAt(fila, 2).toString();
		descrip = tblAlertas.getValueAt(fila, 3).toString();
		relevancia = tblAlertas.getValueAt(fila, 4).toString();
		
		DlgDerivacion.txtCodigo.setText(cod);
		DlgDerivacion.txtCodUsu.setText(codUsu);
		DlgDerivacion.txtFecha.setText(fecha);
		DlgDerivacion.txtDescripcion.setText(descrip);
		if(relevancia == "true") {
			DlgDerivacion.lblRelevante.setText("RELEVANTE");
			DlgDerivacion.lblRelevante.setForeground(Color.RED);
		} else {
			DlgDerivacion.lblRelevante.setText("NO RELEVANTE");
			DlgDerivacion.lblRelevante.setForeground(Color.BLACK);
		}	
	}
}
