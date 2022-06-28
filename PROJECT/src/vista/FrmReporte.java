package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.table.DefaultTableModel;

import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.toedter.calendar.JDateChooser;

import Hilos.MenuAnimacion;
import entidad.Estado;
import entidad.Reporte;
import entidad.ReporteTabla;
import entidad.TipoUsuario;
import entidad.Usuario;
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
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class FrmReporte extends JInternalFrame{

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
	private JButton btnPDF;

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
		addInternalFrameListener(new InternalFrameAdapter() {});
		setResizable(true);
		setFrameIcon(new ImageIcon(FrmReporte.class.getResource("/images/shield-16.png")));
		setTitle("Formulario | Reporte");
		setBounds(100, 100, 711, 553);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setBounds(77, 78, 46, 14);
		contentPane.add(lblCodigo);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(77, 103, 81, 14);
		contentPane.add(lblUsuario);
		
		lblAnexo = new JLabel("Descripci\u00F3n");
		lblAnexo.setBounds(77, 128, 70, 14);
		contentPane.add(lblAnexo);
		
		lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(77, 153, 46, 14);
		contentPane.add(lblFecha);
		
		lblEstado = new JLabel("Estado");
		lblEstado.setBounds(77, 178, 46, 14);
		contentPane.add(lblEstado);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigo.setText("Autogenerado");
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(187, 73, 150, 20);
		contentPane.add(txtCodigo);
		
		dcFecha = new JDateChooser();
		dcFecha.setBounds(187, 148, 150, 20);
		contentPane.add(dcFecha);
		
		cboEstado = new JComboBox();
		cboEstado.setEnabled(false);
		cboEstado.setBounds(187, 172, 150, 20);
		contentPane.add(cboEstado);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(77, 208, 559, 258);
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
		btnReportar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnReportar(e);
			}
		});
		btnReportar.setBounds(547, 73, 89, 23);
		contentPane.add(btnReportar);
		
		txtReporte = new JTextField();
		txtReporte.setBounds(187, 123, 150, 20);
		contentPane.add(txtReporte);
		txtReporte.setColumns(10);
		
		cboUsuario = new JComboBox();
		cboUsuario.setEnabled(false);
		cboUsuario.setBounds(187, 98, 150, 22);
		contentPane.add(cboUsuario);
		
		btnPDF = new JButton("PDF");
		btnPDF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnPDF(e);
			}
		});
		btnPDF.setBounds(547, 100, 89, 23);
		contentPane.add(btnPDF);
		
		cargarCombo();
		cargarComboUsuarios();
		mostrarData();
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
		
		if(user == 0 
			|| report == null 
			|| fecha == null 
			|| estado == 0){
			return;
		}
		else {
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

	private void mostrarData(){
		model.setRowCount(0);
		
		ArrayList<ReporteTabla> data = gRe.listarReportes();
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
	
	protected void actionPerformedBtnReportar(ActionEvent e) {
		registrarDatos();
		limpiarCampos();
		mostrarData();
	}
	
	void imprimePDF() {
		String nombreArchivo = "reportes/Listado de Reporte.pdf";
		
		try {
			Document documento = new Document();
			
			FileOutputStream fos = new FileOutputStream(nombreArchivo);
			
			PdfWriter pdfWriter = PdfWriter.getInstance(documento, fos);;
			
			
			documento.open();
			
			/*
			Image image = Image.getInstance("src/img/logociberfarma.png");
			image.scaleToFit(100,100);
			image.setAlignment(Chunk.ALIGN_LEFT);
			documento.add(image);
			*/
			
			Paragraph paragraph = new Paragraph("Listado Reportes", FontFactory.getFont("arial", 22, Font.BOLD));
			paragraph.setAlignment(Chunk.ALIGN_CENTER);
			documento.add(paragraph);
			
			String fecha = LocalDate.now().toString();
			paragraph = new Paragraph(fecha);
			paragraph.setAlignment(Chunk.ALIGN_RIGHT);
			documento.add(paragraph);
			
			paragraph = new Paragraph("\n\n");
			documento.add(paragraph);
			
			ArrayList<ReporteTabla> reportes = gRe.listarReportes();
			
			if (reportes.size() == 0) {
				paragraph = new Paragraph("Lista Vacia", FontFactory.getFont("arial", 14, Font.BOLD));
				documento.add(paragraph);
				return;
			}
			
			PdfPTable tabla = new PdfPTable(5);
			tabla.addCell("Codigo");
			tabla.addCell("Usuario");
			tabla.addCell("Descripcion");
			tabla.addCell("Estado");
			tabla.addCell("Fecha");
			
			for(ReporteTabla reporte : reportes) {
				tabla.addCell(reporte.getCod() + "");
				tabla.addCell(reporte.getUsuario());
				tabla.addCell(reporte.getDescripcion());
				tabla.addCell(reporte.getEstado());
				tabla.addCell(reporte.getFecha());
			}
			documento.add(tabla);
			
			paragraph = new Paragraph("\n\n\n\n");
			documento.add(paragraph);
			
			
			Image image = Image.getInstance("src/images/firma-gerente.png");
			image.scaleToFit(120,100);
			image.setAlignment(Chunk.ALIGN_RIGHT);
			documento.add(image);
			
			paragraph = new Paragraph("_______________________");
			paragraph.setAlignment(Chunk.ALIGN_RIGHT);
			documento.add(paragraph);
			
			paragraph = new Paragraph("Firma del Representante\n de Mesa de Servicio");
			paragraph.setAlignment(Chunk.ALIGN_RIGHT);
			documento.add(paragraph);
			
			
			documento.close();
			
			Desktop.getDesktop().open(new File(nombreArchivo));
		} 
		catch (Exception e) {
			System.out.println(">>> Error: " + e.getMessage());
		}
	}
	
	// 
	protected void actionPerformedBtnPDF(ActionEvent e) {
		imprimePDF();	
	}
}
