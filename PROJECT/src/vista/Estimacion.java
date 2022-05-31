package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JPopupMenu;
import javax.swing.JMenuItem;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Estimacion extends JDialog implements MouseListener, KeyListener {

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Estimacion dialog = new Estimacion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Estimacion() {
		initComponents();
		//setBox(tablePrioridad, tablePrioridad.getColumnModel().getColumn(1));
		
		//Probando con datos
		for(int i=0, cod = 10001; i<40; i++, cod++) {
			addRow(String.valueOf(cod),"NO ASIGNADO");
		}
	}
	
	void initComponents() {
		setBounds(100, 100, 758, 578);
		getContentPane().setLayout(new BorderLayout());
		cpEstimacion.setLayout(null);
		cpEstimacion.setBorder(new EmptyBorder(5, 5, 5, 5));
		cpEstimacion.setBackground(new Color(255,255,255));
		getContentPane().add(cpEstimacion, BorderLayout.CENTER);
		
		filtrar = new PpMenuFiltrar();
		cpEstimacion.setComponentPopupMenu(filtrar);
		
		spPrioridad = new JScrollPane();
		spPrioridad.setBounds(0, 59, 493, 443);
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
		tablePrioridad.addKeyListener(this);
		tablePrioridad.addMouseListener(this);
		tablePrioridad.setFillsViewportHeight(true);
		tablePrioridad.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		spPrioridad.setViewportView(tablePrioridad);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("Cod Registro");
		modelo.addColumn("Nivel Prioridad");
		tablePrioridad.setModel(modelo);
		setColumnWidth();
		setBox(tablePrioridad, tablePrioridad.getColumnModel().getColumn(1));

		
		lblInfoPrioridad = new JLabel("See more about Prioridad ...");
		lblInfoPrioridad.addMouseListener(this);
		lblInfoPrioridad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInfoPrioridad.setForeground(Color.BLUE);
		lblInfoPrioridad.setBounds(322, 513, 168, 14);
		cpEstimacion.add(lblInfoPrioridad);
		
		spDescripcion = new JScrollPane();
		spDescripcion.setBounds(491, 59, 251, 443);
		cpEstimacion.add(spDescripcion);
		
		txtDescripcion = new JTextArea();
		txtDescripcion.setFont(new Font("Monospaced", Font.PLAIN, 16));
		spDescripcion.setViewportView(txtDescripcion);	
		
		dialog = new JDialog();
		dialog.getContentPane().setLayout(new BorderLayout());
		
		dialog.setBounds(100, 100, 518, 282);
		dialog.getContentPane().setBackground(Color.WHITE);
		dialog.setUndecorated(true);
		//dialog.setLocationRelativeTo(cpEstimacion);
		
		JLabel nivelImage = new JLabel();
		nivelImage.setIcon(new ImageIcon(Estimacion.class.getResource("/images/Prioridad.png")));
		dialog.getContentPane().add(nivelImage);
		
	}
	//Adding a JComboBox in the second column
	void setBox(JTable table, TableColumn column) {
		JComboBox<String> cboNivel = new JComboBox<String>();
		cboNivel.addItem("NO ASIGNADO");
		cboNivel.addItem("ALTO");
		cboNivel.addItem("MEDIANO");
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
	//Adding fake data
	void addRow(String cod, String nivel) {
		String[] fila = {cod, nivel};
		modelo.addRow(fila);
	}
	/*
	 * MouseListener
	 */
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tablePrioridad) {
			mouseClickedTablePrioridad(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == lblInfoPrioridad) {
			mouseEnteredLblInfoPrioridad(e);
		}
	}
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == lblInfoPrioridad) {
			mouseExitedLblInfoPrioridad(e);
		}
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
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
		if(tablePrioridad.getRowCount() >0) {
			int row = tablePrioridad.getSelectedRow();
			String cod = modelo.getValueAt(row, 0).toString();
			buscar(cod);
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
	//Show the data when using a sql script
	protected void keyReleasedTablePrioridad(KeyEvent e) {
		if(tablePrioridad.getRowCount() >0) {
			int row = tablePrioridad.getSelectedRow();
			String cod = modelo.getValueAt(row, 0).toString();
			buscar(cod);
		}
	}

	void buscar(String cod) {
		//Use a Select
		//Show the data
		txtDescripcion.setText("Codigo: " + cod + "\nDescripcion: " + "\n...");
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
		mntmFiltrarM = new JMenuItem("Filtrar por Mediano");
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

