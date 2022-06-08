package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.ScrollPane;

import javax.management.modelmbean.ModelMBeanOperationInfo;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import entidad.Anexos;
import mantenimiento.GestionAnexoDAO;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Anexo extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	
	//instancia
	GestionAnexoDAO gAn = new GestionAnexoDAO();
	private JTable txtS;
	private JScrollPane scrollPane;
	DefaultTableModel modelo = new DefaultTableModel();
	private JButton btnSeleccionar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Anexo dialog = new Anexo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Anexo() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Anexo.class.getResource("/images/shield-16.png")));
		setTitle("Formulario | Anexos");
		setBounds(100, 100, 575, 367);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 540, 271);
		contentPanel.add(scrollPane);
		
		
		txtS = new JTable();
		scrollPane.setViewportView(txtS);
		modelo.addColumn("N°");
		modelo.addColumn("Descripción");
		txtS.setModel(modelo);
		
		btnSeleccionar = new JButton("Selecionar");
		btnSeleccionar.addActionListener(this);
		btnSeleccionar.setBounds(228, 294, 107, 23);
		contentPanel.add(btnSeleccionar);
		
		ajustarAnchoColumnas();
		listar();
	}
	
	private void ajustarAnchoColumnas() {
		TableColumnModel tcm = txtS.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(8));
		tcm.getColumn(1).setPreferredWidth(anchoColumna(92));
	}
	
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}
	
	void listar(){
		modelo.setRowCount(0);
		
		for(Anexos anexos : gAn.listaAnexos()){
			Object[] row = {
				anexos.getCod(),
				anexos.getDescripcion()
			};
			modelo.addRow(row);
		}
	}
	
	private void enviarDatos(){
		String cod;
		int fila;
		
		fila = txtS.getSelectedRow();
		cod = txtS.getValueAt(fila, 0).toString();
		
		FrmRegistro.txtAnexo.setText(cod);
		
		this.dispose();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSeleccionar) {
			actionPerformedBtnSeleccionar(e);
		}
	}
	protected void actionPerformedBtnSeleccionar(ActionEvent e) {
		try {
			enviarDatos();
		} catch (Exception e2) {
			System.out.println("ERROR: " + e2.getMessage());
		}
	}
}
