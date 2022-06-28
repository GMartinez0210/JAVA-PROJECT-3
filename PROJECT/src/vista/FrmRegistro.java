package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
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
import mantenimiento.GestionRegistroDAO;

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

public class FrmRegistro extends JInternalFrame {

	private JPanel contentPane;
	private JLabel lblCodigo;
	public static JTextField txtCodigo;
	private JLabel lblAnexo;
	private JLabel lblFecha;
	private JLabel lblEstado;
	public static JTextField txtAnexo;
	private JDateChooser dcFecha;
	private JComboBox cboEstado;
	private JTable table;
	private JScrollPane scrollPane;
	private JRadioButton rdbtnEvaluar;
	private JRadioButton rdbtnEliminar;
	private JButton btnAceptar;
	ButtonGroup group = new ButtonGroup();
	
	GestionEstadoDAO gEs = new GestionEstadoDAO();
	GestionReporteDAO gRe = new GestionReporteDAO();
	GestionTipoUsuarioDAO gTip = new GestionTipoUsuarioDAO();
	GestionRegistroDAO gReg = new GestionRegistroDAO();
	private JLabel lblUsuario;
	private JComboBox cboUser;
	private JLabel lblReporte;
	public static JTextField txtReporte;
	private JButton btnAnexos;
	private JButton btnReportes;
	DefaultTableModel model = new DefaultTableModel();
	private JLabel lblNewLabel;
	public static JDateChooser dcFechaRepote;

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
		setClosable(true);
		setTitle("Formulario | Registro");
		setBounds(100, 100, 692, 453);
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
		txtCodigo.setBounds(142, 19, 202, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		lblAnexo = new JLabel("Anexo");
		lblAnexo.setBounds(10, 124, 46, 14);
		contentPane.add(lblAnexo);
		
		lblFecha = new JLabel("Fecha de Evaluaci\u00F3n");
		lblFecha.setBounds(10, 149, 122, 14);
		contentPane.add(lblFecha);
		
		lblEstado = new JLabel("Estado");
		lblEstado.setBounds(10, 174, 46, 14);
		contentPane.add(lblEstado);
		
		txtAnexo = new JTextField();
		txtAnexo.setBounds(142, 121, 77, 20);
		contentPane.add(txtAnexo);
		txtAnexo.setColumns(10);
		
		dcFecha = new JDateChooser();
		dcFecha.setBounds(142, 146, 162, 20);
		contentPane.add(dcFecha);
		
		cboEstado = new JComboBox();
		cboEstado.setBounds(142, 170, 162, 22);
		contentPane.add(cboEstado);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 199, 656, 204);
		contentPane.add(scrollPane);
		
		
		model.addColumn("Código");
		model.addColumn("Responsable");
		model.addColumn("Reporte");
		model.addColumn("Fecha R");
		model.addColumn("Estado");
		model.addColumn("Anexo");
		model.addColumn("Fecha E");
		table = new JTable();
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		rdbtnEvaluar = new JRadioButton("Evaluar");
		rdbtnEvaluar.setSelected(true);
		rdbtnEvaluar.setBackground(Color.LIGHT_GRAY);
		rdbtnEvaluar.setBounds(557, 22, 109, 23);
		contentPane.add(rdbtnEvaluar);
		
		rdbtnEliminar = new JRadioButton("Eliminar");
		rdbtnEliminar.setBackground(Color.LIGHT_GRAY);
		rdbtnEliminar.setBounds(557, 48, 109, 23);
		contentPane.add(rdbtnEliminar);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnAceptar(e);
			}
		});
		btnAceptar.setBounds(557, 116, 89, 23);
		contentPane.add(btnAceptar);
		group.add(rdbtnEliminar);
		group.add(rdbtnEvaluar);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(10, 99, 46, 14);
		contentPane.add(lblUsuario);
		
		cboUser = new JComboBox();
		cboUser.setBounds(142, 97, 202, 22);
		contentPane.add(cboUser);
		
		lblReporte = new JLabel("Reporte");
		lblReporte.setBounds(10, 47, 46, 14);
		contentPane.add(lblReporte);
		
		txtReporte = new JTextField();
		txtReporte.setEditable(false);
		txtReporte.setBounds(142, 44, 202, 20);
		contentPane.add(txtReporte);
		txtReporte.setColumns(10);
		
		btnAnexos = new JButton("...");
		btnAnexos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnAnexos(e);
			}
		});
		btnAnexos.setBounds(229, 120, 29, 23);
		contentPane.add(btnAnexos);
		
		btnReportes = new JButton("...");
		btnReportes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnReportes(e);
			}
		});
		btnReportes.setBounds(354, 46, 29, 23);
		contentPane.add(btnReportes);
		
		lblNewLabel = new JLabel("Fecha Reportado");
		lblNewLabel.setBounds(10, 72, 109, 14);
		contentPane.add(lblNewLabel);
		
		dcFechaRepote = new JDateChooser();
		dcFechaRepote.setEnabled(false);
		dcFechaRepote.setBounds(142, 69, 202, 20);
		contentPane.add(dcFechaRepote);
		
		ajustarAnchoColumnas();
		cargarComboEstado();
		cargarComboUsuarios();
		mostrarData();
	}
	
	private void cargarComboEstado() {
		ArrayList<Estado> listaEstado = gEs.listaEstado();
		
		if (listaEstado.size() == 0) {
			mensajeError("Lista Vacia");
		}else {
			cboEstado.addItem("Seleccione el estado");
			for(Estado estado : listaEstado) {
				cboEstado.addItem(estado.getDescripcion());
			}
		}
	}
	
	private void cargarComboUsuarios() {
		ArrayList<TipoUsuario> listaUsuario = gTip.listaTipoUsuarios();
		
		if (listaUsuario.size() == 0) {
			mensajeError("Lista Vacia");
		}else {
			cboUser.addItem("Seleciones un Usuario ");
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

	protected void mouseClickedRdbtnRegistrar(MouseEvent e) {
		txtCodigo.setEditable(false);
	}

	private void limpiarCampos() {
		txtCodigo.setText("");
		txtReporte.setText("");
		dcFechaRepote.setDate(null);
		cboUser.setSelectedIndex(0);
		txtAnexo.setText("");
		dcFecha.setDate(null);
		cboEstado.setSelectedIndex(0);
		cboUser.requestFocus();
	}

	protected void actionPerformedBtnAceptar(ActionEvent e) {
		//boton aceptar
		if(rdbtnEvaluar.isSelected()){
			evaluarDatos();
			limpiarCampos();
			mostrarData();
		} else {
			eliminarReporte();
			limpiarCampos();
			mostrarData();
		}
	}
	
	private void evaluarDatos() {
		String fechaEvaluacion, descripcion, fechaReportado;
		int cod, user, estado, anexo;
		
		cod = getCodigo();
		user = getUsuario();
		descripcion = getDescripcion();
		fechaReportado = getFechaRep();
		estado = getEstado();
		anexo = getAnexo();
		fechaEvaluacion = getFechaEv();
		
		if(cod == -1 || descripcion == null || fechaReportado == null || user == 0 || anexo == -1 || fechaEvaluacion == null || estado == 0 ){
			return;
		}else {
			Reporte r = new Reporte();
			
			r.setCodigo(cod);
			r.setUsuario(user);
			r.setDescripcion(descripcion);
			r.setFecha(fechaReportado);
			r.setEstado(estado);
			r.setCodAnexo(anexo);
			r.setFechaEvaluacion(fechaEvaluacion);
			
			int ok = gReg.actualizar(r);
			
			if (ok == 0){
				mensajeError("Error en la actualización");
			}else {
				mensajeExitoso("Usuario actualizado");
			}
		}
		
	}

	private void eliminarReporte() {
int cod, opcion;
		
		cod = getCodigo();
		
		//validar 
		if(cod == -1) {
			return;
		}else {
			//mensaje confirmacion
			opcion = JOptionPane.showConfirmDialog(this, "Seguro de eliminar ?", "Sistema", JOptionPane.YES_NO_OPTION);
			if(opcion == 0){ //click en Yes || si desa eliminar
				//ejecutar el proceso eliminar usuario
				int ok = gReg.eliminar(cod);
				//validar resultado del proceso
				if(ok == 0){
					mensajeError("Codigo no existe");
				}else {
					mensajeExitoso("Usuario eliminado");
				}
			}
		}
	}
	
	private String getFechaRep() {
		String fecha = null;
		if(dcFechaRepote.getDate() == null){
			mensajeError("Seleccione un Reporte");
			dcFechaRepote.requestFocus();
		}else {
			fecha = new SimpleDateFormat("yyyy/MM/dd").format(dcFechaRepote.getDate());
		}
		return fecha;
	}

	private void mensajeExitoso(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Exito!", 1);
		
	}

	private int getCodigo() {
		int cod = -1;
		if(txtCodigo.getText().trim().length() == 0){
			mensajeError("Seleccione un reporte");
			txtCodigo.requestFocus();
		}else {
			cod = Integer.parseInt(txtCodigo.getText());
		}
		return cod;
	}

	private int getAnexo() {
		int anexo = -1;
		if(txtAnexo.getText().trim().length() == 0){
			mensajeError("Seleccione un Anexo");
			txtAnexo.requestFocus();
		}else {
			anexo = Integer.parseInt(txtAnexo.getText());
		}
		return anexo;
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

	private String getFechaEv() {
		String fecha = null;
		if(dcFecha.getDate() == null){
			mensajeError("Ingrese una fecha");
			dcFecha.requestFocus();
		}else {
			fecha = new SimpleDateFormat("yyyy/MM/dd").format(dcFecha.getDate());
		}
		return fecha;
	}

	private String getDescripcion() {
		String reporte = null;
		if(txtReporte.getText().trim().length() == 0){
			mensajeError("Seleccione un reporte");
			txtReporte.requestFocus();
		}else {
			reporte = txtReporte.getText().trim();
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
	protected void actionPerformedBtnAnexos(ActionEvent e) {
		Anexo a = new Anexo();
		a.setVisible(true);
	}
	protected void actionPerformedBtnReportes(ActionEvent e) {
		dlgReportes re = new dlgReportes();
		re.setVisible(true);
	}
	
	private void mostrarData(){
		model.setRowCount(0);
		ArrayList<ReporteTabla> data = gReg.listarReportesenTabla();
		for(ReporteTabla rt : data) {
			Object fila[] = {rt.getCod(),
							 rt.getUsuario(),
							 rt.getDescripcion(),
							 rt.getFecha(),
							 rt.getEstado(),
							 rt.getCodAnexo(),
							 rt.getFechaEvaluacion()
			};
			model.addRow(fila);
		}
		
	}
	protected void mouseClickedRdbtnEliminar(MouseEvent e) {
		txtCodigo.setEditable(true);
	}
	
	private void ajustarAnchoColumnas() {
		TableColumnModel tcm = table.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(8));
		tcm.getColumn(1).setPreferredWidth(anchoColumna(27));
		tcm.getColumn(2).setPreferredWidth(anchoColumna(23));
		tcm.getColumn(3).setPreferredWidth(anchoColumna(12));
		tcm.getColumn(4).setPreferredWidth(anchoColumna(12));
		tcm.getColumn(5).setPreferredWidth(anchoColumna(6));
		tcm.getColumn(6).setPreferredWidth(anchoColumna(12));
	}
	
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}
}
