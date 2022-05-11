package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicTabbedPaneUI.TabbedPaneLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import java.awt.Toolkit;
import javax.swing.DefaultComboBoxModel;

public class FrmRegistro extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblReporte;
	private JLabel lblFecha;
	private JLabel lblEstado;
	private JTextField textField;
	private JTextField textField_1;
	private JDateChooser dcfecha;
	private JComboBox cboEstado;
	private JButton btnAceptar;
	private JTable table;
	private JScrollPane scrollPane;
	private JRadioButton rdbtnRegistrar;
	private JRadioButton rdbtnActualizar;
	private JRadioButton rdbtnEliminar;
	private JButton btnLimpiar;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmRegistro.class.getResource("/images/shield.png")));
		setTitle("Formulario | Registro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 595, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("C\u00F3digo ");
		lblNewLabel.setBounds(10, 27, 46, 14);
		contentPane.add(lblNewLabel);
		
		lblReporte = new JLabel("Reporte");
		lblReporte.setBounds(10, 52, 46, 14);
		contentPane.add(lblReporte);
		
		lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(10, 80, 46, 14);
		contentPane.add(lblFecha);
		
		lblEstado = new JLabel("Estado");
		lblEstado.setBounds(10, 109, 46, 14);
		contentPane.add(lblEstado);
		
		textField = new JTextField();
		textField.setBounds(66, 24, 176, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(66, 49, 176, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		dcfecha = new JDateChooser();
		dcfecha.setBounds(66, 77, 176, 20);
		contentPane.add(dcfecha);
		
		cboEstado = new JComboBox();
		cboEstado.setModel(new DefaultComboBoxModel(new String[] {"Selecciona el estado", "Pendiente", "Registrado", "Revisado"}));
		cboEstado.setBounds(66, 105, 176, 22);
		contentPane.add(cboEstado);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(356, 23, 89, 23);
		contentPane.add(btnAceptar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 138, 559, 186);
		contentPane.add(scrollPane);
		
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("Código");
		modelo.addColumn("Reporte");
		modelo.addColumn("Fecha");
		modelo.addColumn("Estado");
		table = new JTable();
		table.setModel(modelo);
		scrollPane.setViewportView(table);
		
		rdbtnRegistrar = new JRadioButton("Registrar");
		rdbtnRegistrar.setBounds(464, 24, 109, 23);
		contentPane.add(rdbtnRegistrar);
		
		rdbtnActualizar = new JRadioButton("Actualizar");
		rdbtnActualizar.setBounds(464, 52, 109, 23);
		contentPane.add(rdbtnActualizar);
		
		rdbtnEliminar = new JRadioButton("Eliminar");
		rdbtnEliminar.setBounds(464, 81, 109, 23);
		contentPane.add(rdbtnEliminar);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(356, 57, 89, 23);
		contentPane.add(btnLimpiar);
	}
}
