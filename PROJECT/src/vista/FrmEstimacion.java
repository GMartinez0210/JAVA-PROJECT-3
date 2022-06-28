package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.DefaultCellEditor;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import entidad.ReporteArray;
import entidad.ReportePrioridad;
import mantenimiento.GestionRegistroDAO;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.MouseEvent;
import javax.swing.JPopupMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import java.beans.PropertyVetoException;
import java.awt.event.MouseAdapter;
import java.awt.event.KeyAdapter;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class FrmEstimacion extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel cpEstimacion = new JPanel();
	private JScrollPane spPrioridad;
	private JLabel lblInfoPrioridad;
	private JTable tablePrioridad;
	private DefaultTableModel modelo;
	private JScrollPane spDescripcion;
	private JTextArea txtDescripcion;
	private PpMenuFiltrar filtrar;
	private JDialog dialog;
	private JPanel panelSave;
	private JLabel lblSave;
	JComboBox<String> cboNivel;
	GestionRegistroDAO gRegistro = new GestionRegistroDAO();
	ReporteArray RN = new ReporteArray(gRegistro.listarReporteXPrioridad(0));

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FrmEstimacion dialog = new FrmEstimacion();
			dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the InternalFrame.
	 */
	public FrmEstimacion() {
		try {
			setMaximum(true);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
 	 }
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				internalFrameClosingThis(e);
			}
		});
		setClosable(true);
		initComponents();
		//setBox(tablePrioridad, tablePrioridad.getColumnModel().getColumn(1));
		
		
		listarReportes(0);
	}
	
	void initComponents() {
		setBounds(100, 100, 758, 515);
		getContentPane().setLayout(new BorderLayout());
		cpEstimacion.setLayout(null);
		cpEstimacion.setBorder(new EmptyBorder(5, 5, 5, 5));
		cpEstimacion.setBackground(new Color(255,255,255));
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		getContentPane().add(cpEstimacion, BorderLayout.CENTER);
		
		filtrar = new PpMenuFiltrar();
		filtrar.mntmFiltrarA.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				actionPreformedMntmFiltrarA(e);
			}
		});
		filtrar.mntmFiltrarM.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				actionPreformedMntmFiltrarM(e);
			}
		});
		filtrar.mntmFiltrarB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				actionPreformedMntmFiltrarB(e);
			}
		});
		filtrar.mntmFiltrarN.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				actionPreformedMntmFiltrarN(e);
			}
		});
		cpEstimacion.setComponentPopupMenu(filtrar);
		
		spPrioridad = new JScrollPane();
		spPrioridad.setBounds(0, 59, 493, 379);
		cpEstimacion.add(spPrioridad);
		
		
		
		tablePrioridad = new JTable() {
			//Override this method, because, we don't want the first column be editable
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int row, int column) {
				for(int i=0; i < tablePrioridad.getRowCount(); i++) {
					if(row == i && column == 0) return false;
				}
				return true;
			}
		};
		tablePrioridad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				keyReleasedTablePrioridad(e);
			}
		});
		tablePrioridad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mouseClickedTablePrioridad(e);
			}
		});
		tablePrioridad.setFillsViewportHeight(true);
		tablePrioridad.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablePrioridad.setGridColor(new Color(123, 155, 189));
		
		spPrioridad.setViewportView(tablePrioridad);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("Cod Registro");
		modelo.addColumn("Nivel Prioridad");
		tablePrioridad.setModel(modelo);
		setColumnWidth();
		setBox(tablePrioridad, tablePrioridad.getColumnModel().getColumn(1));

		
		lblInfoPrioridad = new JLabel("See more about Prioridad ...");
		lblInfoPrioridad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mouseEnteredLblInfoPrioridad(e);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				mouseExitedLblInfoPrioridad(e);
			}
		});
		lblInfoPrioridad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInfoPrioridad.setForeground(Color.blue);
		lblInfoPrioridad.setBounds(325, 448, 168, 14);
		cpEstimacion.add(lblInfoPrioridad);
		
		spDescripcion = new JScrollPane();
		spDescripcion.setBounds(491, 59, 251, 379);
		cpEstimacion.add(spDescripcion);
		
		txtDescripcion = new JTextArea();
		txtDescripcion.setLineWrap(true);
		txtDescripcion.setFont(new Font("Monospaced", Font.PLAIN, 16));
		txtDescripcion.setForeground(new Color(220, 20, 60));
		spDescripcion.setViewportView(txtDescripcion);	
		
		panelSave = new JPanel();
		panelSave.setBackground(Color.WHITE);
		panelSave.setBounds(652, 11, 50, 45);
		cpEstimacion.add(panelSave);
		panelSave.setLayout(null);
		
		lblSave = new JLabel("");
		lblSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mouseEnteredLblSave(e);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				mouseExitedLblSave(e);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				mouseClickedLblSave(e);
			}
		});
		lblSave.setHorizontalAlignment(SwingConstants.CENTER);
		lblSave.setIcon(new ImageIcon(FrmEstimacion.class.getResource("/images/save.png")));
		lblSave.setBounds(0, 0, 50, 45);
		panelSave.add(lblSave);
		
		dialog = new JDialog();
		dialog.getContentPane().setLayout(new BorderLayout());
		
		dialog.setBounds(100, 100, 518, 282);
		dialog.getContentPane().setBackground(Color.WHITE);
		dialog.setUndecorated(true);
		//dialog.setLocationRelativeTo(cpEstimacion);
		
		JLabel nivelImage = new JLabel();
		nivelImage.setIcon(new ImageIcon(FrmEstimacion.class.getResource("/images/Prioridad.png")));
		dialog.getContentPane().add(nivelImage);
		
	}
	//Adding a JComboBox in the second column
	void setBox(JTable table, TableColumn column) {
		cboNivel = new JComboBox<String>();
		cboNivel.addItem("NO ASIGNADO");
		cboNivel.addItem("ALTO");
		cboNivel.addItem("MEDIO");
		cboNivel.addItem("BAJO");
		
		cboNivel.setBackground(new Color(255,255,255));
		
		column.setCellEditor(new DefaultCellEditor(cboNivel));
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		column.setCellRenderer(renderer);
		
	}
	/*
	 * Column Width
	 */
	void setColumnWidth() {
		TableColumnModel tcm = tablePrioridad.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(getPixelsWidth(34));
		tcm.getColumn(1).setPreferredWidth(getPixelsWidth(66));
	}
	int getPixelsWidth(int porcentaje) {
		return porcentaje * spPrioridad.getWidth() / 100;
	}
	/*
	 * MouseListener
	 */
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == lblSave) {
			mouseClickedLblSave(e);
		}
		if (e.getSource() == tablePrioridad) {
			mouseClickedTablePrioridad(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == lblInfoPrioridad) {
			mouseEnteredLblInfoPrioridad(e);
		}
		if (e.getSource() == lblSave) {
			mouseEnteredLblSave(e);
		}
	}
	protected void mouseEnteredLblSave(MouseEvent e) {
		lblSave.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblSave.setIcon(new ImageIcon(FrmEstimacion.class.getResource("/images/saveHover.png")));
	}

	public void mouseExited(MouseEvent e) {
		if (e.getSource() == lblInfoPrioridad) {
			mouseExitedLblInfoPrioridad(e);
		}
		if (e.getSource() == lblSave) {
			mouseExitedLblSave(e);
		}
	}
	private void mouseExitedLblSave(MouseEvent e) {
		lblSave.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		lblSave.setIcon(new ImageIcon(FrmEstimacion.class.getResource("/images/save.png")));
		panelSave.setBackground(Color.WHITE);
	}

	protected void mouseEnteredLblInfoPrioridad(MouseEvent e) {
		lblInfoPrioridad.setCursor(new Cursor(Cursor.HAND_CURSOR));
		dialog.setVisible(true);
		int x = e.getXOnScreen();
		int y = e.getYOnScreen();
		dialog.setBounds(x - dialog.getWidth() + 50, y - dialog.getHeight(), 518, 282);
	}
	protected void mouseExitedLblInfoPrioridad(MouseEvent e) {
		dialog.setVisible(false);
	}
	//Show the data when its row is clicked and using a sql script
	protected void mouseClickedTablePrioridad(MouseEvent e) {
		try {
			if(tablePrioridad.getRowCount() >0) {
				int row = tablePrioridad.getSelectedRow();
				int cod = Integer.parseInt(modelo.getValueAt(row, 0).toString());
				search(cod);
			}
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
		}
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == tablePrioridad) {
			keyReleasedTablePrioridad(e);
		}
	}
	public void keyTyped(KeyEvent e) {
	}
	//Show the data using a key event
	protected void keyReleasedTablePrioridad(KeyEvent e) {
		if(tablePrioridad.getRowCount() >0) {
			try {
				int row = tablePrioridad.getSelectedRow();
				int cod = Integer.parseInt(modelo.getValueAt(row, 0).toString());
				search(cod);
			} catch (NumberFormatException e1) {
				e1.printStackTrace();
			}
		}
	}
	//Save button
	protected void mouseClickedLblSave(MouseEvent e) {
		lblSave.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblSave.setIcon(new ImageIcon(FrmEstimacion.class.getResource("/images/saveHover.png")));
		panelSave.setBackground(new Color(248, 248, 248));
		saveData();
		actualizarDataTotal();
	}
	/*
	 * ActionListener
	 */

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == filtrar.mntmFiltrarA) {
			actionPreformedMntmFiltrarA(e);
		}
		if (e.getSource() == filtrar.mntmFiltrarM) {
			actionPreformedMntmFiltrarM(e);
		}
		if (e.getSource() == filtrar.mntmFiltrarB) {
			actionPreformedMntmFiltrarB(e);
		}
		if (e.getSource() == filtrar.mntmFiltrarN) {
			actionPreformedMntmFiltrarN(e);
		}
	}
	private void actionPreformedMntmFiltrarA(ActionEvent e) {
		changeFilter(1);
	}
	private void actionPreformedMntmFiltrarM(ActionEvent e) {
		changeFilter(2);
	}
	private void actionPreformedMntmFiltrarB(ActionEvent e) {
		changeFilter(3);
	}
	private void actionPreformedMntmFiltrarN(ActionEvent e) {
		changeFilter(0);
	}
	
	/*
	 * InternalFrame Listener
	 */
	protected void internalFrameClosingThis(InternalFrameEvent e) {
		int question = mensajeConfirm("¿Desea guardar los cambios?");
		if(question == JOptionPane.YES_OPTION) {
			// save the data
			saveData();
			// close Frame
			dispose();
		} else if(question == JOptionPane.NO_OPTION) {
			dispose();
		} else if(question == JOptionPane.CLOSED_OPTION) {
		}
	}
	
	/*
	 * class voids
	 */
	
	//search the description and show it
	void search(int cod) {
		try {
			if(RN.searchForCod(cod) == null) {
				mensajeError("Pruebe seleccionando un codigo de la tabla o guarde y vuelva a entrar ");
			} else {
				//get the description using a void from ReporteArray
				String des = RN.getDesForCod(cod);
				//Show the data
				txtDescripcion.setText("Codigo: " + cod + "\nDescripcion: " + "\n" + des);
			}
		} 
		catch (Exception e) {
			System.out.println(">>> ERROR: " + e.getMessage());
		}
	}
	
	//Send the data from the table to javaprojectdb.tb_reportes
	private void saveData() {
		actualizarArrayTotal();
		if(RN.size() > 0) {
			int cont = 0;
			for(int i = 0; i < RN.size();i++) {
				int update = gRegistro.updatePrioridadXCod(RN.get(i).getCodigo(), RN.get(i).getCod_prio());
				if(update == -1) {
					mensajeError("No sé pudo actualizar el registro: " + RN.get(i).getCodigo());
				} else {
					cont++;
				}
			}
			mensajeExitoso("Se realizaron " + cont + " registros exitosos");
		} else {
			mensajeError("Por ahora no hay registros con prioridad no asignada, sigue pendiente ya llegaran");
		}
	}
	//Change the filter
	void changeFilter(int cod_prio) {
		// save the data
		saveData();
		ArrayList<ReportePrioridad> arrayValidacion = gRegistro.listarReporteXPrioridad(cod_prio);
		if(arrayValidacion.size() > 0) {
			//fill the RN array
			RN = new ReporteArray(arrayValidacion);
			//fill the tablePrioridad
			listarReportes(cod_prio);
		} else {
			String prio = "NO ASIGNADO";
			switch(cod_prio) {
				case 1: prio = "ALTO"; break;
				case 2: prio = "MEDIO"; break;
				case 3: prio = "BAJO"; break;
				default: prio = "NO ASIGNADO"; break;
			}
			mensajeError("No hay rerigstros con la propiedad: " + prio);
		}
	}
	void actualizarArrayTotal() {
		if(tablePrioridad.getRowCount() > 0) {
			for(int i=0; i<tablePrioridad.getRowCount(); i++) {
				int cod = Integer.parseInt(modelo.getValueAt(i, 0).toString());
				String prio = modelo.getValueAt(i, 1).toString();
				int cod_prio = 0;
				if(prio.equals("ALTO")) {
					cod_prio = 1;
				} else if(prio.equals("MEDIO")){
					cod_prio = 2;
				} else if(prio.equals("BAJO")) {
					cod_prio = 3;
				} else {
					cod_prio = 0;
				}
				RN.setPrioForCod(cod, cod_prio);
			}			
		}
	}
	void actualizarDataTotal() {
		ArrayList<ReportePrioridad> arrayValidacion = gRegistro.listarReporteXPrioridad(0);
		if(arrayValidacion.size() > 0) {
			//fill the RN array
			RN = new ReporteArray(arrayValidacion);
			//fill the tablePrioridad
			listarReportes(0);
		}
	}
	
	/*
	 * SQL voids
	 */
	void listarReportes(int prioridad) {
		ArrayList<ReportePrioridad> data = gRegistro.listarReporteXPrioridad(prioridad);
		modelo.setRowCount(0);
		if(data.size() > 0) {
			for(ReportePrioridad rp : data) {
				String prio = "NO ASIGNADO";
				switch(rp.getCod_prio()) {
					case 1: prio = "ALTO"; break;
					case 2: prio = "MEDIO"; break;
					case 3: prio = "BAJO"; break;
					default: prio = "NO ASIGNADO"; break;
				}
				Object[] fila = {rp.getCodigo(), prio};
				modelo.addRow(fila);
			}
		}
	}
	protected Icon getIcon(String path) {
		Icon img = new ImageIcon(new ImageIcon(this.getClass().getResource(path)).getImage());
		return img;
	}
	
	/*
	 * JOptionPanes as Messages
	 */
	private void mensajeError(String message) {
		JOptionPane.showMessageDialog(this, message, "Error", 0);
	}
	
	private void mensajeExitoso(String message) {
		JOptionPane.showMessageDialog(this, message, "Excelente", 1);
	}
	private int mensajeConfirm(String message) {
		return JOptionPane.showConfirmDialog(this, message, "Confirmar", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
	}
	
}


//Class PopupMenuPrioridad
class PpMenuFiltrar extends JPopupMenu implements MouseListener{
	
	private static final long serialVersionUID = 1L;
	JMenuItem mntmFiltrarA;
	JMenuItem mntmFiltrarM;
	JMenuItem mntmFiltrarB;
	JMenuItem mntmFiltrarN;
	public PpMenuFiltrar() {
		initPpMenuPrioridad();
	}
	
	void initPpMenuPrioridad() {
		mntmFiltrarA = new JMenuItem("Filtrar por Alto");
		mntmFiltrarM = new JMenuItem("Filtrar por Medio");
		mntmFiltrarB = new JMenuItem("Filtrar por Bajo");
		mntmFiltrarN = new JMenuItem("Filtrar por No Asignado");
		
		//Changing their properties
		changeProperties(mntmFiltrarA,new Color(229, 1, 28), new Color(255,255,255));
		changeProperties(mntmFiltrarM,new Color(255, 204, 0), new Color(255,255,255));
		changeProperties(mntmFiltrarB,new Color(0, 153, 0), new Color(255,255,255));
		changeProperties(mntmFiltrarN,new Color(0, 1, 153), new Color(255,255,255));
		changeProperties(mntmFiltrarA,new Font("Tahoma", Font.PLAIN, 14));
		changeProperties(mntmFiltrarM,new Font("Tahoma", Font.PLAIN, 14));
		changeProperties(mntmFiltrarB,new Font("Tahoma", Font.PLAIN, 14));
		changeProperties(mntmFiltrarN,new Font("Tahoma", Font.PLAIN, 14));
		
		//Adding Listening
		mntmFiltrarA.addMouseListener(this);
		mntmFiltrarM.addMouseListener(this);
		mntmFiltrarB.addMouseListener(this);
		mntmFiltrarN.addMouseListener(this);
		
		add(mntmFiltrarA);
		add(mntmFiltrarM);
		add(mntmFiltrarB);
		add(mntmFiltrarN);
		
	}
	/*
	 * Change Properties void
	 */
	void changeProperties(JMenuItem item, Color fg, Color bg) {
		item.setForeground(fg);
		item.setBackground(bg);
	}
	void changeProperties(JMenuItem item, Font font) {
		item.setFont(font);
	}
	void changeProperties(JMenuItem item, Cursor cursor) {
		item.setCursor(cursor);
	}
	//Implements methods
	@Override
	public void mouseClicked(MouseEvent e) {
	}
	@Override
	public void mousePressed(MouseEvent e) {
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == mntmFiltrarA) {
			mouseEnteredMntmFiltrarA(e);
		}
		if (e.getSource() == mntmFiltrarM) {
			mouseEnteredMntmFiltrarM(e);
		}
		if (e.getSource() == mntmFiltrarB) {
			mouseEnteredMntmFiltrarB(e);
		}
		if (e.getSource() == mntmFiltrarN) {
			mouseEnteredMntmFiltrarN(e);
		}
	}
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == mntmFiltrarA) {
			mouseExitedMntmFiltrarA(e);
		}
		if (e.getSource() == mntmFiltrarM) {
			mouseExitedMntmFiltrarM(e);
		}
		if (e.getSource() == mntmFiltrarB) {
			mouseExitedMntmFiltrarB(e);
		}
		if (e.getSource() == mntmFiltrarN) {
			mouseExitedMntmFiltrarN(e);
		}
	}

	/*
	 * mntmFiltrarA hover
	 */
	protected void mouseEnteredMntmFiltrarA(MouseEvent e) {
		changeProperties(mntmFiltrarA, new Cursor(Cursor.HAND_CURSOR));				
	}
	protected void mouseExitedMntmFiltrarA(MouseEvent e) {
		changeProperties(mntmFiltrarA, new Cursor(Cursor.HAND_CURSOR));				
	}
	/*
	 * mntmFiltrarM hover
	 */
	protected void mouseEnteredMntmFiltrarM(MouseEvent e) {
		changeProperties(mntmFiltrarM, new Cursor(Cursor.HAND_CURSOR));				
	}
	protected void mouseExitedMntmFiltrarM(MouseEvent e) {
		changeProperties(mntmFiltrarM, new Cursor(Cursor.HAND_CURSOR));				
	}
	/*
	 * mntmFiltrarB hover
	 */
	protected void mouseEnteredMntmFiltrarB(MouseEvent e) {
		changeProperties(mntmFiltrarB, new Cursor(Cursor.HAND_CURSOR));				
	}
	protected void mouseExitedMntmFiltrarB(MouseEvent e) {
		changeProperties(mntmFiltrarB, new Cursor(Cursor.HAND_CURSOR));				
	}
	/*
	 * mntmFiltrarN hover
	 */
	protected void mouseEnteredMntmFiltrarN(MouseEvent e) {
		changeProperties(mntmFiltrarN, new Cursor(Cursor.HAND_CURSOR));				
	}
	protected void mouseExitedMntmFiltrarN(MouseEvent e) {
		changeProperties(mntmFiltrarN, new Cursor(Cursor.HAND_CURSOR));				
	}

	
}

