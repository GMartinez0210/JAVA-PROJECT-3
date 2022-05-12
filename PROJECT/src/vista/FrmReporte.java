package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class FrmReporte extends JFrame {

	private JPanel contentPane;
	private JLabel lblCodigo;
	private JLabel lblIdResponsable;
	private JLabel lblDescripcion;
	private JLabel lblFecha;
	private JLabel lblEstado;
	private JTextField txtCodigo;
	private JTextField txtIdResponsable;
	private JDateChooser dateChooser;
	private JComboBox comboBox;
	private JTable table;
	private JScrollPane scrollPane;
	private JRadioButton rdbtnRegistrar;
	private JRadioButton rdbtnActualizar;
	private JRadioButton rdbtnEliminar;
	private JButton btnAceptar;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmReporte.class.getResource("/images/shield-16.png")));
		setTitle("Formulario | Reporte");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 595, 374);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setBounds(10, 26, 46, 14);
		contentPane.add(lblCodigo);
		
		lblIdResponsable = new JLabel("Id Reponsable");
		lblIdResponsable.setBounds(10, 51, 81, 14);
		contentPane.add(lblIdResponsable);
		
		lblDescripcion = new JLabel("Descripci\u00F3n");
		lblDescripcion.setBounds(10, 76, 70, 14);
		contentPane.add(lblDescripcion);
		
		lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(10, 101, 46, 14);
		contentPane.add(lblFecha);
		
		lblEstado = new JLabel("Estado");
		lblEstado.setBounds(10, 126, 46, 14);
		contentPane.add(lblEstado);
		
		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(100, 23, 150, 20);
		contentPane.add(txtCodigo);
		
		txtIdResponsable = new JTextField();
		txtIdResponsable.setColumns(10);
		txtIdResponsable.setBounds(100, 48, 150, 20);
		contentPane.add(txtIdResponsable);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(100, 98, 150, 20);
		contentPane.add(dateChooser);
		
		comboBox = new JComboBox();
		comboBox.setBounds(100, 122, 150, 22);
		contentPane.add(comboBox);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 151, 559, 173);
		contentPane.add(scrollPane);
		
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("Código");
		modelo.addColumn("Responsable");
		modelo.addColumn("Descripción");
		modelo.addColumn("Fecha");
		modelo.addColumn("Estado");
		table = new JTable();
		table.setModel(modelo);
		scrollPane.setViewportView(table);
		
		rdbtnRegistrar = new JRadioButton("Registrar");
		rdbtnRegistrar.setBackground(Color.LIGHT_GRAY);
		rdbtnRegistrar.setBounds(460, 22, 109, 23);
		contentPane.add(rdbtnRegistrar);
		
		rdbtnActualizar = new JRadioButton("Actualizar");
		rdbtnActualizar.setBackground(Color.LIGHT_GRAY);
		rdbtnActualizar.setBounds(460, 47, 109, 23);
		contentPane.add(rdbtnActualizar);
		
		rdbtnEliminar = new JRadioButton("Eliminar");
		rdbtnEliminar.setBackground(Color.LIGHT_GRAY);
		rdbtnEliminar.setBounds(460, 72, 109, 23);
		contentPane.add(rdbtnEliminar);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(460, 97, 89, 23);
		contentPane.add(btnAceptar);
	}
}
