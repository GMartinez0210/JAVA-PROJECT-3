package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import entidad.MensajeCUsuario;
import mantenimiento.GestiosMensajeDAO;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class DlgListarMensajes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JScrollPane scrollPane;
	private JTable tbMensajes;
	
	DefaultTableModel model = new DefaultTableModel();
	private JButton btnNewButton;
	
	GestiosMensajeDAO gMsj = new GestiosMensajeDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgListarMensajes dialog = new DlgListarMensajes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgListarMensajes() {
		setBounds(100, 100, 769, 334);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(135, 206, 235));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblNewLabel = new JLabel("Listado de los mensajes enviados:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(40, 24, 543, 14);
		contentPanel.add(lblNewLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(40, 60, 666, 211);
		contentPanel.add(scrollPane);
		
		tbMensajes = new JTable();
		tbMensajes.setFillsViewportHeight(true);
		scrollPane.setViewportView(tbMensajes);
		
		model.addColumn("Nombre usu");
		model.addColumn("ID men");
		model.addColumn("Correo");
		model.addColumn("Asunto");
		model.addColumn("Mensaje");
		
		tbMensajes.setModel(model);
		
		btnNewButton = new JButton("Cerrar");
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnNewButton(e);
			}
		});
		btnNewButton.setBounds(617, 20, 89, 23);
		contentPanel.add(btnNewButton);
		
		tbMensajes.getColumn("Mensaje").setPreferredWidth(270);
		tbMensajes.getColumn("ID men").setPreferredWidth(50);
		
		listarMensajes();
	}

	private void listarMensajes() {
		// TODO Auto-generated method stub
		ArrayList<MensajeCUsuario> listMU = gMsj.listarMensajesCUsuario();
		
		for (MensajeCUsuario m : listMU) {
			Object fila[] = {m.getNombre(),
					         m.getIdMensajes(),
					         m.getCorreo(),
					         m.getAsunto(),
					         m.getMensajes()
					         
					      };
			model.addRow(fila);
		}
	}
	
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		dispose();
	}
}
