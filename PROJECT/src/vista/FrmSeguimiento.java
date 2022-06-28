package vista;

import java.awt.EventQueue;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import entidad.Alerta;
import mantenimiento.GestionAlertaDAO;
import javax.swing.JTable;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class FrmSeguimiento extends JInternalFrame {
	private JLabel lblNewLabel;
	private JTable tblAlertas;
	private JButton btnModificarEstado;
	private JRadioButton rdbtnActivo;
	private JRadioButton rdbtnInactivo;
	private JScrollPane scrollPane;
	DefaultTableModel model = new DefaultTableModel();
	GestionAlertaDAO gAlert = new GestionAlertaDAO();
	private JLabel lblRecargar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmSeguimiento frame = new FrmSeguimiento();
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
	public FrmSeguimiento() {
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setBounds(100, 100, 595, 375);
		getContentPane().setLayout(null);
		{
			lblNewLabel = new JLabel("SEGUIMIENTO DE ALERTAS");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
			lblNewLabel.setBounds(10, 11, 559, 19);
			getContentPane().add(lblNewLabel);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 44, 559, 214);
			getContentPane().add(scrollPane);
			{
				tblAlertas = new JTable();
				tblAlertas.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						mouseClickedTblAlertas(e);
					}
				});
				scrollPane.setViewportView(tblAlertas);
			}
		}
		{
			btnModificarEstado = new JButton("Cambiar Estado");
			btnModificarEstado.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnModificarEstado(e);
				}
			});
			btnModificarEstado.setBackground(Color.WHITE);
			btnModificarEstado.setBounds(186, 283, 128, 29);
			getContentPane().add(btnModificarEstado);
		}
		{
			rdbtnActivo = new JRadioButton("Activo");
			rdbtnActivo.setBounds(334, 273, 109, 23);
			getContentPane().add(rdbtnActivo);
		}
		{
			rdbtnInactivo = new JRadioButton("Inactivo");
			rdbtnInactivo.setBounds(334, 299, 109, 23);
			getContentPane().add(rdbtnInactivo);
		}
		tblAlertas.setModel(model);
		{
			lblRecargar = new JLabel("");
			lblRecargar.setIcon(new ImageIcon(FrmSeguimiento.class.getResource("/images/icons8-actualizar-30.png")));
			lblRecargar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					mouseEnteredLblRecargar(e);
				}
				@Override
				public void mouseClicked(MouseEvent e) {
					mouseClickedLblRecargar(e);
				}
			});
			lblRecargar.setBounds(527, 11, 30, 29);
			getContentPane().add(lblRecargar);
		}

		//Grupo de radious buttons
		ButtonGroup rd = new ButtonGroup();
		rd.add(rdbtnInactivo);
		rd.add(rdbtnActivo);
		//Modelo de tabla
		model.addColumn("Código");
		model.addColumn("Cod. Usuario");
		model.addColumn("Descripción");
		model.addColumn("Plazo");
		model.addColumn("Estado");
		mostrarTabla();
	}
	
	private void mostrarTabla() {
		model.setRowCount(0);
		ArrayList<Alerta> alerta = gAlert.seguimientoAlertas();
		try {
			for(Alerta a : alerta) {
				Object fila[] = {a.getCod(),
						 		  a.getCodUsu(),
						 		  a.getBreveDes(),
						 		  a.getPlazoatencion(),
						 		  a.getEstado()};
			model.addRow(fila);
			}
		}
		catch (Exception e) {
			System.out.print(e.getMessage());
		}
		for(int i = 0; i < alerta.size(); i++) {
			Object valor = tblAlertas.getValueAt(i, 4);
			if(valor == null) {
				tblAlertas.setValueAt("Inactivo", i, 4);
			}
		}
	}
	
	protected void actionPerformedBtnModificarEstado(ActionEvent e) {
		int selected;
		selected = tblAlertas.getSelectedRow();
		if(selected == -1) {
			JOptionPane.showMessageDialog(this, "Debes seleccionar una alerta en la tabla.");
		}else {
			actualizarEstado();
		}
	}

	private void actualizarEstado() {
		int cod, fila;
		String estado = null;
		fila = tblAlertas.getSelectedRow();
		cod = (int) tblAlertas.getValueAt(fila, 0);
		if(rdbtnActivo.isSelected()) {
			estado = "Activo";
		}else if (rdbtnInactivo.isSelected()) {
			estado = "Inactivo";
		}
		Alerta alerta = new Alerta();
		alerta.setEstado(estado);
		alerta.setCod(cod);
		int ok = gAlert.seguimientoAlerta(alerta);
		try {
			if(ok == 0) {
				JOptionPane.showMessageDialog(this, "Error al actualizar estado");
			}
			else {
				JOptionPane.showMessageDialog(this, "Estado cambio con éxito.");
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		mostrarTabla();
	}
	
	protected void mouseClickedTblAlertas(MouseEvent e) {
		int fila;
		String estado;
		fila = tblAlertas.getSelectedRow();
		estado = tblAlertas.getValueAt(fila, 4).toString();
		switch(estado) {
				case "Inactivo": rdbtnInactivo.setSelected(true);
					break;
				case "Activo": rdbtnActivo.setSelected(true);
					break;
		}
	}
	
	protected void mouseEnteredLblRecargar(MouseEvent e) {
		lblNewLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	
	protected void mouseClickedLblRecargar(MouseEvent e) {
		mostrarTabla();
		JOptionPane.showMessageDialog(this, "La tabla ha sido actualizada.");
	}
}
