package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import entidad.Estado;
import entidad.Reporte;
import entidad.TipoUsuario;
import mantenimiento.GestionEstadoDAO;
import mantenimiento.GestionReporteDAO;
import mantenimiento.GestionTipoUsuarioDAO;

import javax.swing.JComboBox;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class FrmRegistro extends JFrame implements MouseListener, ActionListener {

	private JPanel contentPane;
	private JLabel lblCodigo;
	private JTextField txtCodigo;
	private JLabel lblAnexo;
	private JLabel lblFecha;
	private JLabel lblEstado;
	private JTextField txtAnexo;
	private JDateChooser dcFecha;
	private JComboBox cboEstado;
	private JTable table;
	private JScrollPane scrollPane;
	private JRadioButton rdbtnRegistrar;
	private JRadioButton rdbtnActualizar;
	private JRadioButton rdbtnEliminar;
	private JButton btnAceptar;
	ButtonGroup group = new ButtonGroup();
	
	GestionEstadoDAO gEs = new GestionEstadoDAO();
	GestionReporteDAO gRe = new GestionReporteDAO();
	GestionTipoUsuarioDAO gTip = new GestionTipoUsuarioDAO();
	private JLabel lblUsuario;
	private JComboBox cboUser;
	private JLabel lblReporte;
	private JTextField txtReporte;
	private JButton btnAnexos;

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
		setBounds(100, 100, 595, 397);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setBounds(10, 22, 46, 14);
		contentPane.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigo.setText("Autogenerado");
		txtCodigo.setBounds(66, 19, 150, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		lblAnexo = new JLabel("Anexo");
		lblAnexo.setBounds(10, 96, 46, 14);
		contentPane.add(lblAnexo);
		
		lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(10, 121, 46, 14);
		contentPane.add(lblFecha);
		
		lblEstado = new JLabel("Estado");
		lblEstado.setBounds(10, 146, 46, 14);
		contentPane.add(lblEstado);
		
		txtAnexo = new JTextField();
		txtAnexo.setBounds(66, 93, 150, 20);
		contentPane.add(txtAnexo);
		txtAnexo.setColumns(10);
		
		dcFecha = new JDateChooser();
		dcFecha.setBounds(66, 118, 150, 20);
		contentPane.add(dcFecha);
		
		cboEstado = new JComboBox();
		cboEstado.setBounds(66, 142, 150, 22);
		contentPane.add(cboEstado);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 171, 559, 175);
		contentPane.add(scrollPane);
		
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("Codigo");
		modelo.addColumn("Usuario");
		modelo.addColumn("Reporte");
		modelo.addColumn("Fecha");
		modelo.addColumn("Estado");
		table = new JTable();
		table.setModel(modelo);
		scrollPane.setViewportView(table);
		
		rdbtnRegistrar = new JRadioButton("Registrar");
		rdbtnRegistrar.setSelected(true);
		rdbtnRegistrar.addMouseListener(this);
		rdbtnRegistrar.setBackground(Color.LIGHT_GRAY);
		rdbtnRegistrar.setBounds(460, 18, 109, 23);
		contentPane.add(rdbtnRegistrar);
		
		rdbtnActualizar = new JRadioButton("Actualizar");
		rdbtnActualizar.setBackground(Color.LIGHT_GRAY);
		rdbtnActualizar.setBounds(460, 43, 109, 23);
		contentPane.add(rdbtnActualizar);
		
		rdbtnEliminar = new JRadioButton("Eliminar");
		rdbtnEliminar.setBackground(Color.LIGHT_GRAY);
		rdbtnEliminar.setBounds(460, 69, 109, 23);
		contentPane.add(rdbtnEliminar);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(460, 112, 89, 23);
		contentPane.add(btnAceptar);
		
		group.add(rdbtnActualizar);
		group.add(rdbtnEliminar);
		group.add(rdbtnRegistrar);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(10, 47, 46, 14);
		contentPane.add(lblUsuario);
		
		cboUser = new JComboBox();
		cboUser.setBounds(66, 43, 150, 22);
		contentPane.add(cboUser);
		
		lblReporte = new JLabel("Reporte");
		lblReporte.setBounds(10, 72, 46, 14);
		contentPane.add(lblReporte);
		
		txtReporte = new JTextField();
		txtReporte.setBounds(66, 69, 150, 20);
		contentPane.add(txtReporte);
		txtReporte.setColumns(10);
		
		btnAnexos = new JButton("...");
		btnAnexos.setBounds(229, 92, 29, 23);
		contentPane.add(btnAnexos);
		
		cargarComboEstado();
		cargarComboUsuarios();
	}
	
	private void cargarComboEstado() {
		ArrayList<Estado> listaEstado = gEs.listaEstado();
		
		if (listaEstado.size() == 0) {
			mensajeError("Lista Vacia");
		}else {
			cboEstado.addItem("Seleccione el estado");
			for(Estado estado : listaEstado) {
				cboEstado.addItem(estado.getCodigo() + " - " + estado.getDescripcion());
			}
		}
	}
	
	private void cargarComboUsuarios() {
		ArrayList<TipoUsuario> listaUsuario = gTip.listaTipoUsuarios();
		
		if (listaUsuario.size() == 0) {
			mensajeError("Lista Vacia");
		}else {
			cboUser.addItem(" ");
			for(TipoUsuario tipousuario : listaUsuario) {
				cboUser.addItem(tipousuario.getCodigo() + " - " + tipousuario.getDescripcion());
			}
		}
	}

	private void mensajeError(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Error !!!", 0);
	}
	
	private void mensajeExito(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Exito !!!", 1);
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
//		limpiarCampos();
	}

	private void limpiarCampos() {
		txtCodigo.setText("");
		cboUser.setSelectedIndex(0);
		txtAnexo.setText("");
		dcFecha.setDate(null);
		cboEstado.setSelectedIndex(0);
		cboUser.requestFocus();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
	}
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		//boton aceptar
		if(rdbtnRegistrar.isSelected()){
			registrarDatos();
			limpiarCampos();
		}
	}
	
	private void registrarDatos() {
		String report, fecha;
		int user, estado;
		
		user = getUsuario();
		report = getReporte();
		fecha = getFecha();
		estado = getEstado();
		
		if(user == 0 || report == null || fecha == null || estado == 0){
			return;
		}else {
			Reporte r = new Reporte();
			
			r.setUsuario(user);
			r.setDescripcion(report);
			r.setFecha(fecha);
			r.setEstado(estado);
			
			int res = gRe.registrar(r);
			
			if(res == 0){
				mensajeError("Error en el registro");
			}else {
				mensajeExito("Registro exitoso");
			}
		}
		
	}

	
	private int getEstado() {
		int estado = 0;
		if(cboEstado.getSelectedIndex() == 0){
			mensajeError("Seleccione un estado");
			cboEstado.requestFocus();
		}else {
			estado = cboEstado.getSelectedIndex();
		}
		return estado;
	}

	private String getFecha() {
		String fecha = null;
		if(dcFecha.getDate() == null){
			mensajeError("Ingrese una fecha");
			dcFecha.requestFocus();
		}else {
			fecha = new SimpleDateFormat("yyyy/MM/dd").format(dcFecha.getDate());
		}
		return fecha;
	}

	private String getReporte() {
		String reporte = null;
		if(txtAnexo.getText().trim().length() == 0){
			mensajeError("Ingrese un reporte");
			txtAnexo.requestFocus();
		}else {
			reporte = txtAnexo.getText().trim();
		}
		return reporte;
	}

	private int getUsuario() {
		int user = 0;
		if(cboUser.getSelectedIndex() == 0){
			mensajeError("Seleccione un usuario");
			cboUser.requestFocus();
		}else {
			user = cboUser.getSelectedIndex();
		}
		return user;
	}
}
