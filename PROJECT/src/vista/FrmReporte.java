package vista;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmReporte extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblCodigo;
	private JLabel lblIdResponsable;
	private JLabel lblFecha;
	private JLabel lblDescripcion;
	private JLabel lblEstado;
	private JTextField txtResponsable;
	private JTextField txtDescripcion;
	private JTextField txtCodigo;
	private JDateChooser dcFecha;
	private JComboBox cboEstado;
	private JButton btnRegistrar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JTable table;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmReporte frame = new FrmReporte();
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
	public FrmReporte() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmReporte.class.getResource("/images/shield.png")));
		setTitle("Formulario | Reporte");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 595, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblCodigo = new JLabel("C\u00F3digo");
			lblCodigo.setBounds(10, 11, 46, 14);
			contentPane.add(lblCodigo);
		}
		{
			lblIdResponsable = new JLabel("ID Responsable");
			lblIdResponsable.setBounds(10, 36, 98, 14);
			contentPane.add(lblIdResponsable);
		}
		{
			lblFecha = new JLabel("Fecha");
			lblFecha.setBounds(10, 89, 46, 14);
			contentPane.add(lblFecha);
		}
		{
			lblDescripcion = new JLabel("Descripci\u00F3n");
			lblDescripcion.setBounds(10, 61, 77, 14);
			contentPane.add(lblDescripcion);
		}
		{
			lblEstado = new JLabel("Estado");
			lblEstado.setBounds(10, 118, 46, 14);
			contentPane.add(lblEstado);
		}
		{
			txtResponsable = new JTextField();
			txtResponsable.setBounds(118, 33, 127, 20);
			contentPane.add(txtResponsable);
			txtResponsable.setColumns(10);
		}
		{
			txtDescripcion = new JTextField();
			txtDescripcion.setColumns(10);
			txtDescripcion.setBounds(118, 58, 127, 20);
			contentPane.add(txtDescripcion);
		}
		{
			txtCodigo = new JTextField();
			txtCodigo.setColumns(10);
			txtCodigo.setBounds(118, 8, 127, 20);
			contentPane.add(txtCodigo);
		}
		{
			dcFecha = new JDateChooser();
			dcFecha.setBounds(118, 86, 127, 20);
			contentPane.add(dcFecha);
		}
		{
			cboEstado = new JComboBox();
			cboEstado.setBounds(118, 114, 128, 22);
			contentPane.add(cboEstado);
		}
		{
			btnRegistrar = new JButton("Registrar");
			btnRegistrar.addActionListener(this);
			btnRegistrar.setBounds(433, 11, 112, 23);
			contentPane.add(btnRegistrar);
		}
		{
			btnModificar = new JButton("Modificar");
			btnModificar.addActionListener(this);
			btnModificar.setBounds(433, 40, 112, 23);
			contentPane.add(btnModificar);
		}
		{
			btnEliminar = new JButton("Eliminar");
			btnEliminar.addActionListener(this);
			btnEliminar.setBounds(433, 69, 112, 23);
			contentPane.add(btnEliminar);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 143, 559, 181);
			contentPane.add(scrollPane);
			{
				DefaultTableModel modelo = new DefaultTableModel();
				modelo.addColumn("Código");
				modelo.addColumn("Id Responsable");
				modelo.addColumn("Descripción");
				modelo.addColumn("Fecha");
				modelo.addColumn("Estado");
				table = new JTable();
				table.setModel(modelo);
				scrollPane.setViewportView(table);
			}
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrar(e);
		}
	}
	protected void actionPerformedBtnRegistrar(ActionEvent e) {
	
	}
	
	protected void actionPerformedBtnModificar(ActionEvent e) {
		
	}
	
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		
	}
	
	
	
}
