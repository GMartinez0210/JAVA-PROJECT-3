package vista;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import entidad.Alerta;
import mantenimiento.GestionAlertaDAO;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseListener;
import java.util.Date;
import java.awt.event.MouseEvent;

public class FrmIngresarAlerta extends JDialog implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblTitle;
	private JTextField txtCodAle;
	private JComboBox<Boolean> cboRelAle;
	private JDateChooser jdcFecAle;
	private JLabel lblNewLabel;
	private JLabel lblRelAle;
	private JLabel lblDescriAle;
	private JScrollPane scrollPane;
	private JTextArea txtDescriAle;
	private JLabel lblCodAle;
	private JPanel panelIngresar;
	private JLabel lblIngresar;
	
	GestionAlertaDAO gAlerta = new GestionAlertaDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FrmIngresarAlerta dialog = new FrmIngresarAlerta();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FrmIngresarAlerta() {
		setBounds(100, 100, 758, 578);
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(255,255,255));
		
		lblTitle = new JLabel("Ingresar Alerta de Seguridad");
		lblTitle.setBounds(165, 11, 399, 41);
		getContentPane().add(lblTitle);
		lblTitle.setForeground(new Color(33, 85, 205));
		lblTitle.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 30));
		
		txtCodAle = new JTextField();
		txtCodAle.setToolTipText("Codigo de Alerta auto generado");
		txtCodAle.setEnabled(false);
		txtCodAle.setFont(new Font("Malgun Gothic", Font.PLAIN, 16));
		txtCodAle.setBounds(122, 128, 201, 28);
		getContentPane().add(txtCodAle);
		txtCodAle.setColumns(10);
		
		cboRelAle = new JComboBox<Boolean>();
		cboRelAle.setForeground(new Color(204, 0, 0));
		cboRelAle.setToolTipText("Seleccionar Relevancia; true, si es relevante; false, si no lo es.");
		cboRelAle.setModel(new DefaultComboBoxModel <Boolean> (new Boolean[] {true, false}));
		cboRelAle.setBackground(Color.WHITE);
		cboRelAle.setFont(new Font("Malgun Gothic", Font.PLAIN, 16));
		cboRelAle.setBounds(122, 298, 201, 28);
		getContentPane().add(cboRelAle);
		
		jdcFecAle = new JDateChooser();
		jdcFecAle.setDateFormatString("dd MMM y");
		jdcFecAle.getCalendarButton().setFont(new Font("Malgun Gothic", Font.PLAIN, 16));
		jdcFecAle.setBounds(122, 210, 201, 28);
		jdcFecAle.setFont(new Font("Malgun Gothic", Font.PLAIN, 16));
		jdcFecAle.setDate(new Date()); //Fecha actual
		getContentPane().add(jdcFecAle);
		
		lblNewLabel = new JLabel("Fecha");
		lblNewLabel.setFont(new Font("Malgun Gothic", Font.PLAIN, 16));
		lblNewLabel.setBounds(29, 210, 42, 22);
		getContentPane().add(lblNewLabel);
		
		lblRelAle = new JLabel("Relevancia");
		lblRelAle.setFont(new Font("Malgun Gothic", Font.PLAIN, 16));
		lblRelAle.setBounds(29, 298, 77, 22);
		getContentPane().add(lblRelAle);
		
		lblDescriAle = new JLabel("Descripcion");
		lblDescriAle.setFont(new Font("Malgun Gothic", Font.PLAIN, 18));
		lblDescriAle.setBounds(363, 102, 95, 25);
		getContentPane().add(lblDescriAle);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(363, 148, 353, 178);
		getContentPane().add(scrollPane);
		
		txtDescriAle = new JTextArea();
		txtDescriAle.setFont(new Font("Malgun Gothic", Font.PLAIN, 16));
		scrollPane.setViewportView(txtDescriAle);
		
		lblCodAle = new JLabel("Codigo");
		lblCodAle.setFont(new Font("Malgun Gothic", Font.PLAIN, 16));
		lblCodAle.setBounds(29, 128, 77, 22);
		getContentPane().add(lblCodAle);
		
		panelIngresar = new JPanel();
		panelIngresar.setBackground(Color.WHITE);
		panelIngresar.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(65, 105, 225), new Color(65, 105, 225), new Color(65, 105, 225), new Color(65, 105, 225)));
		panelIngresar.setBounds(73, 400, 595, 41);
		getContentPane().add(panelIngresar);
		panelIngresar.setLayout(null);
		
		lblIngresar = new JLabel("Ingresar");
		lblIngresar.addMouseListener(this);
		lblIngresar.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngresar.setFont(new Font("Malgun Gothic", Font.PLAIN, 22));
		lblIngresar.setForeground(new Color(33, 85, 205));
		lblIngresar.setBounds(0, 0, 595, 41);
		panelIngresar.add(lblIngresar);
	}
	
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == lblIngresar) {
			mouseClickedLblIngresar(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == lblIngresar) {
			mouseEnteredLblIngresar(e);
		}
	}
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == lblIngresar) {
			mouseExitedLblIngresar(e);
		}
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	//Ingresar Button Hover
	protected void mouseEnteredLblIngresar(MouseEvent e) {
		panelIngresar.setBackground(new Color(65, 105, 225));
		lblIngresar.setForeground(Color.WHITE);
		lblIngresar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	//Ingresar Button Not Hover
	protected void mouseExitedLblIngresar(MouseEvent e) {
		panelIngresar.setBackground(Color.WHITE);
		lblIngresar.setForeground(new Color(33, 85, 205));
	}
	// Click Ingresar-Button
	protected void mouseClickedLblIngresar(MouseEvent e) {
		ingresarAlerta();
	}
	//Get variables
	protected java.sql.Date getFec() {
		java.sql.Date sqlDate = null;
		try {
			Date date = jdcFecAle.getDate();
			long d = date.getTime();
			sqlDate = new java.sql.Date(d);
			if(d > new Date().getTime()) {
				sqlDate = null;
				mensajeError("Ingresa una fecha menor o igual a hoy");
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sqlDate;
	}
	
	protected  boolean getRelevancia() {
		boolean relevancia = false;
		try {
			relevancia = Boolean.parseBoolean(cboRelAle.getSelectedItem().toString());
		} catch (Exception e) {
			mensajeError("Error en el formato a la relevancia");
		}
		return relevancia;
	}
	
	protected String getDescri() {
		String des = null;
		if(txtDescriAle.getText().trim().isEmpty()) {
			mensajeError("Ingresa una descripcion");
		} else {
			try {
				if(txtDescriAle.getText().trim().matches("[A-Za-z0-9\\s\\d\\D]{1,30}")) {
					des = txtDescriAle.getText().trim();
				} else {
					mensajeError("Ingresa una descripcion entre 1 y 30 caracteres");
				}
			} catch (Exception e) {
				mensajeError("Error en el formato de la descripcion");
			}
		}
		return des;
	}
	
	//Clear
	protected void clearFrame() {
		jdcFecAle.setDate(new Date());
		cboRelAle.setSelectedIndex(0);
		txtDescriAle.setText("");
	}
	
	// void ingresar
	protected void ingresarAlerta() {
		java.sql.Date date = getFec();
		boolean rel = getRelevancia();
		String des = getDescri();
		if(date == null || des == null) {
			return;
		}
		else {
			try {
				Alerta a = new Alerta();
				a.setFec(date);
				a.setRelevancia(rel);
				a.setBreveDes(des);
				
				gAlerta.insertarAlerta(a);
				mensajeExitoso("Se realizo un registro exitoso");
				clearFrame();
			} catch (Exception e) {
				mensajeError("Problemas al ingresar");
				e.printStackTrace();
			}
		}
	}

	private void mensajeError(String message) {
		JOptionPane.showMessageDialog(this, message, "Error", 0);
		
	}
	
	private void mensajeExitoso(String message) {
		JOptionPane.showMessageDialog(this, message, "Excelente", 1);
		
	}
}
