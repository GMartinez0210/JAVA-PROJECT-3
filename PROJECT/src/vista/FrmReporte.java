package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import Hilos.MenuAnimacion;
import entidad.Estado;
import mantenimiento.GestionEstadoDAO;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class FrmReporte extends JInternalFrame implements ActionListener, MouseListener {

	private JPanel contentPane;
	private JLabel lblCodigo;
	private JLabel lblUsuario;
	private JLabel lblAnexo;
	private JLabel lblFecha;
	private JLabel lblEstado;
	private JTextField txtCodigo;
	private JTextField txtIdResponsable;
	private JDateChooser dcFecha;
	private JComboBox cboEstado;
	private JTable table;
	private JScrollPane scrollPane;
	private JRadioButton rdbtnRegistrar;
	private JRadioButton rdbtnActualizar;
	private JRadioButton rdbtnEliminar;
	private JButton btnAceptar;
	private JTextField txtAnexo;
	private JButton btnMostrar;
	ButtonGroup group = new ButtonGroup();
	
	GestionEstadoDAO gEs = new GestionEstadoDAO();
	private JButton btnCerrar;

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
		setBorder(null);
		setClosable(true);
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameOpened(InternalFrameEvent e) {
				internalFrameOpenedThis(e);
			}
		});
		setResizable(true);
		setFrameIcon(new ImageIcon(FrmReporte.class.getResource("/images/shield-16.png")));
		setTitle("Formulario | Reporte");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 711, 553);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setBounds(10, 26, 46, 14);
		contentPane.add(lblCodigo);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(10, 51, 81, 14);
		contentPane.add(lblUsuario);
		
		lblAnexo = new JLabel("Anexo");
		lblAnexo.setBounds(10, 76, 70, 14);
		contentPane.add(lblAnexo);
		
		lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(10, 101, 46, 14);
		contentPane.add(lblFecha);
		
		lblEstado = new JLabel("Estado");
		lblEstado.setBounds(10, 126, 46, 14);
		contentPane.add(lblEstado);
		
		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(66, 22, 150, 20);
		contentPane.add(txtCodigo);
		
		txtIdResponsable = new JTextField();
		txtIdResponsable.setColumns(10);
		txtIdResponsable.setBounds(66, 47, 150, 20);
		contentPane.add(txtIdResponsable);
		
		dcFecha = new JDateChooser();
		dcFecha.setBounds(66, 97, 150, 20);
		contentPane.add(dcFecha);
		
		cboEstado = new JComboBox();
		cboEstado.setBounds(66, 121, 150, 20);
		contentPane.add(cboEstado);
		
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
		rdbtnRegistrar.setSelected(true);
		rdbtnRegistrar.addMouseListener(this);
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
		
		txtAnexo = new JTextField();
		txtAnexo.setBounds(66, 72, 150, 20);
		contentPane.add(txtAnexo);
		txtAnexo.setColumns(10);
		
		btnMostrar = new JButton("...");
		btnMostrar.addActionListener(this);
		btnMostrar.setBounds(226, 71, 29, 23);
		contentPane.add(btnMostrar);
		
		group.add(rdbtnActualizar);
		group.add(rdbtnEliminar);
		group.add(rdbtnRegistrar);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnCerrar(e);
			}
		});
		btnCerrar.setBounds(365, 98, 85, 21);
		contentPane.add(btnCerrar);
		
		cargarCombo();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnMostrar) {
			actionPerformedBtnMostrar(e);
		}
	}
	protected void actionPerformedBtnMostrar(ActionEvent e) {
		Anexo ax = new Anexo();
		ax.setLocationRelativeTo(this);
		ax.setVisible(true);
		
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == rdbtnRegistrar) {
			mouseClickedRdbtnRegistrar(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mouseClickedRdbtnRegistrar(MouseEvent e) {
		limpiarcampos();
	}

	private void limpiarcampos() {
		txtCodigo.setText("");
		txtIdResponsable.setText("");
		txtAnexo.setText("");
		dcFecha.setDate(null);
		cboEstado.setSelectedIndex(0);
		
	}
	
	private void cargarCombo() {
		ArrayList<Estado> listaDistrito = gEs.listaEstado();
		
		if (listaDistrito.size() == 0) {
			mensajeError("Lista Vacia");
		}else {
			cboEstado.addItem("Seleccione ...");
			for(Estado distrito : listaDistrito) {
				cboEstado.addItem(distrito.getCodigo() + " - " + distrito.getDescripcion());
			}
		}
	}

	private void mensajeError(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Error !!!", 0);
	}
	
	// InternalFrame - Opened 
	protected void internalFrameOpenedThis(InternalFrameEvent e) {
		MenuAnimacion menuAnimacion = new MenuAnimacion();
		menuAnimacion.start();
	}
	
	// Button Cerrar
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
}
