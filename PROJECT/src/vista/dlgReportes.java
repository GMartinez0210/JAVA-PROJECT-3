package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import entidad.Anexos;
import entidad.InfoReportes;
import mantenimiento.GestionRegistroDAO;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class dlgReportes extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JButton btnSeleccionar;
	private JTable tblDatos;
	private JScrollPane scrollPane;
	DefaultTableModel model = new DefaultTableModel();
	
	GestionRegistroDAO gRe = new GestionRegistroDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			dlgReportes dialog = new dlgReportes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public dlgReportes() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(dlgReportes.class.getResource("/images/shield-16.png")));
		setTitle("Reportes");
		setBounds(100, 100, 575, 367);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		btnSeleccionar = new JButton("Selecionar");
		btnSeleccionar.addActionListener(this);
		btnSeleccionar.setBounds(228, 294, 107, 23);
		contentPanel.add(btnSeleccionar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 539, 272);
		contentPanel.add(scrollPane);
		
		tblDatos = new JTable();
		scrollPane.setViewportView(tblDatos);
		model.addColumn("N°");
		model.addColumn("Descripción");
		model.addColumn("Fecha");
		tblDatos.setModel(model);
		
		ajustarAnchoColumnas();
		listar();
	}
	
	private void ajustarAnchoColumnas() {
		TableColumnModel tcm = tblDatos.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(10));
		tcm.getColumn(1).setPreferredWidth(anchoColumna(70));
		tcm.getColumn(2).setPreferredWidth(anchoColumna(20));
	}
	
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}
	
	void listar(){
		model.setRowCount(0);
		
		for(InfoReportes re : gRe.listaReportes()){
			Object[] row = {
					re.getCod(),
					re.getReporte(),
					re.getFecha()
			};
			model.addRow(row);
		}
	}
	
	private void enviarDatos(){
		String cod, reporte, fecha;
		int fila;
		
		fila = tblDatos.getSelectedRow();
		cod = tblDatos.getValueAt(fila, 0).toString();
		reporte = tblDatos.getValueAt(fila, 1).toString();
		fecha = tblDatos.getValueAt(fila, 2).toString();
		
		FrmRegistro.txtCodigo.setText(cod);
		FrmRegistro.txtReporte.setText(reporte);
		try {
			FrmRegistro.dcFechaRepote.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(fecha));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.dispose();
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSeleccionar) {
			actionPerformedBtnSeleccionar(e);
		}
	}
	protected void actionPerformedBtnSeleccionar(ActionEvent e) {
		enviarDatos();
	}
}
