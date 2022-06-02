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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import entidad.Estado;
import entidad.Reporte;
import entidad.ReporteTabla;
import entidad.TipoUsuario;
import mantenimiento.GestionEstadoDAO;
import mantenimiento.GestionReporteDAO;
import mantenimiento.GestionTipoUsuarioDAO;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;

public class FrmReporte extends JFrame implements ActionListener, MouseListener {

	private JPanel contentPane;
	private JLabel lblCodigo;
	private JLabel lblUsuario;
	private JLabel lblAnexo;
	private JLabel lblFecha;
	private JLabel lblEstado;
	private JTextField txtCodigo;
	private JDateChooser dcFecha;
	private JComboBox cboEstado;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnReportar;
	private JTextField txtReporte;
	ButtonGroup group = new ButtonGroup();
	DefaultTableModel model = new DefaultTableModel();
	
	GestionEstadoDAO gEs = new GestionEstadoDAO();
	GestionReporteDAO gRe = new GestionReporteDAO();
	GestionTipoUsuarioDAO gTip = new GestionTipoUsuarioDAO();
	private JComboBox cboUsuario;

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
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(10, 51, 81, 14);
		contentPane.add(lblUsuario);
		
		lblAnexo = new JLabel("Descripci\u00F3n");
		lblAnexo.setBounds(10, 76, 70, 14);
		contentPane.add(lblAnexo);
		
		lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(10, 101, 46, 14);
		contentPane.add(lblFecha);
		
		lblEstado = new JLabel("Estado");
		lblEstado.setBounds(10, 126, 46, 14);
		contentPane.add(lblEstado);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigo.setText("Autogenerado");
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(96, 22, 150, 20);
		contentPane.add(txtCodigo);
		
		dcFecha = new JDateChooser();
		dcFecha.setBounds(96, 97, 150, 20);
		contentPane.add(dcFecha);
		
		cboEstado = new JComboBox();
		cboEstado.setEnabled(false);
		cboEstado.setBounds(96, 121, 150, 20);
		contentPane.add(cboEstado);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 151, 559, 173);
		contentPane.add(scrollPane);
		
		
		model.addColumn("Código");
		model.addColumn("Responsable");
		model.addColumn("Reporte");
		model.addColumn("Fecha");
		model.addColumn("Estado");
		table = new JTable();
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		btnReportar = new JButton("Reportar");
		btnReportar.addActionListener(this);
		btnReportar.setBounds(456, 22, 89, 23);
		contentPane.add(btnReportar);
		
		txtReporte = new JTextField();
		txtReporte.setBounds(96, 72, 150, 20);
		contentPane.add(txtReporte);
		txtReporte.setColumns(10);
		
		cboUsuario = new JComboBox();
		cboUsuario.setEnabled(false);
		cboUsuario.setBounds(96, 47, 150, 22);
		contentPane.add(cboUsuario);
		
		
		cargarCombo();
		cargarComboUsuarios();
		mostrarData();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnReportar) {
			actionPerformedBtnAceptar(e);
		}
	}
	public void mouseClicked(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}

	private void limpiarCampos() {

		txtReporte.setText("");
		dcFecha.setDate(null);
		
	}
	
	private void cargarCombo() {
		ArrayList<Estado> listaEstado = gEs.listaEstado();
		
		if (listaEstado.size() == 0) {
			mensajeError("Lista Vacia");
		}else {
			cboEstado.addItem(" ");
			for(Estado estado : listaEstado) {
				cboEstado.addItem(estado.getCodigo() + " - " + estado.getDescripcion());
			}
		}
		
		cboEstado.setSelectedIndex(1);
		
	}
	
	private void cargarComboUsuarios() {
		ArrayList<TipoUsuario> listaUsuario = gTip.listaTipoUsuarios();
		
		if (listaUsuario.size() == 0) {
			mensajeError("Lista Vacia");
		}else {
			cboUsuario.addItem(" ");
			for(TipoUsuario tipousuario : listaUsuario) {
				cboUsuario.addItem(tipousuario.getCodigo() + " - " + tipousuario.getDescripcion());
			}
		}
		
		cboUsuario.setSelectedIndex(1);
	}

	private void mensajeError(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Error !!!", 0);
	}
	
	private void mensajeExito(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Exito !!!", 1);
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
	
	private int getUsuario() {
		int user = 0;
		if(cboUsuario.getSelectedIndex() == 0){
			mensajeError("Seleccione un usuario");
			cboUsuario.requestFocus();
		}else {
			user = cboUsuario.getSelectedIndex();
		}
		return user;
	}
	
	private String getReporte() {
		String reporte = null;
		if(txtReporte.getText().trim().length() == 0){
			mensajeError("Ingrese un reporte");
			txtReporte.requestFocus();
		}else {
			reporte = txtReporte.getText().trim();
		}
		return reporte;
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
	
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		
		registrarDatos();
		limpiarCampos();
		mostrarData();
		
	}
	
	private void mostrarData(){
		model.setRowCount(0);
		
		ArrayList<ReporteTabla> data = gRe.listarReportes();
//		System.out.println(data.size());
		for(ReporteTabla rt : data) {
			Object fila[] = {rt.getCod(),
							 rt.getUsuario(),
							 rt.getDescripcion(),
							 rt.getFecha(),
							 rt.getEstado()
			};
			
			model.addRow(fila);
		}
		
	}
}
