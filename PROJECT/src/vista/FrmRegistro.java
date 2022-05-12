package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import java.awt.Toolkit;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class FrmRegistro extends JFrame {

	private JPanel contentPane;
	private JLabel lblCodigo;
	private JTextField txtCodigo;
	private JLabel lblReporte;
	private JLabel lblFecha;
	private JLabel lblEstado;
	private JTextField txtEstado;
	private JDateChooser dcFecha;
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
					FrmRegistro frame = new FrmRegistro();
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
	public FrmRegistro() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmRegistro.class.getResource("/images/shield-16.png")));
		setTitle("Formulario | Registro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 595, 374);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setBounds(10, 22, 46, 14);
		contentPane.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(66, 19, 150, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		lblReporte = new JLabel("Reporte");
		lblReporte.setBounds(10, 47, 46, 14);
		contentPane.add(lblReporte);
		
		lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(10, 72, 46, 14);
		contentPane.add(lblFecha);
		
		lblEstado = new JLabel("Estado");
		lblEstado.setBounds(10, 97, 46, 14);
		contentPane.add(lblEstado);
		
		txtEstado = new JTextField();
		txtEstado.setBounds(66, 44, 150, 20);
		contentPane.add(txtEstado);
		txtEstado.setColumns(10);
		
		dcFecha = new JDateChooser();
		dcFecha.setBounds(66, 69, 150, 20);
		contentPane.add(dcFecha);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Seleciones el estado", "Pendiente", "Revisado", "Enviado"}));
		comboBox.setBounds(66, 93, 150, 22);
		contentPane.add(comboBox);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 126, 559, 198);
		contentPane.add(scrollPane);
		
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("Codigo");
		modelo.addColumn("Reporte");
		modelo.addColumn("Fecha");
		modelo.addColumn("Estado");
		table = new JTable();
		table.setModel(modelo);
		scrollPane.setViewportView(table);
		
		rdbtnRegistrar = new JRadioButton("Registrar");
		rdbtnRegistrar.setBackground(Color.LIGHT_GRAY);
		rdbtnRegistrar.setBounds(460, 18, 109, 23);
		contentPane.add(rdbtnRegistrar);
		
		rdbtnActualizar = new JRadioButton("Actualizar");
		rdbtnActualizar.setBackground(Color.LIGHT_GRAY);
		rdbtnActualizar.setBounds(460, 43, 109, 23);
		contentPane.add(rdbtnActualizar);
		
		rdbtnEliminar = new JRadioButton("Eliminar");
		rdbtnEliminar.setBackground(Color.LIGHT_GRAY);
		rdbtnEliminar.setBounds(460, 68, 109, 23);
		contentPane.add(rdbtnEliminar);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(460, 93, 89, 23);
		contentPane.add(btnAceptar);
	}
	
	
}
