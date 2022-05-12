package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Shape;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JDesktopPane;
import java.awt.GridLayout;
import javax.swing.SwingConstants;

public class MainMenu extends JFrame implements ActionListener, MouseListener, MouseMotionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	int xMouse, yMouse;
	private JPanel panel;
	private JLabel lblLogo;
	private JPanel panelReporte;
	private JPanel panel_2;
	private JPanel panelBarItem_2;
	private JPanel panelBarItem_3;
	private JPanel panel_5;
	private JScrollPane spSideBar;
	private JPanel panelSideBar;
	private JPanel panel_7;
	private JPanel panel_8;
	private JPanel panel_9;
	private JPanel panel_10;
	private JPanel panel_11;
	private JPanel panel_12;
	private JPanel panel_13;
	private JPanel panel_14;
	private JLabel lblReporte;
	private JLabel lblReportes_1;
	private JLabel lblReportes_2;
	private JLabel lblReportes_3;
	private JLabel lblReportes_4;
	private JLabel lblReportes_5;
	private JLabel lblReportes_6;
	private JLabel lblReportes_7;
	private JLabel lblReportes_8;
	private JLabel lblReportes_9;
	private JLabel lblReportes_10;
	private JLabel lblReportes_11;
	private JPanel panelExit;
	private JLabel lblExit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
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
	public MainMenu() {
		this.setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 980, 620);
		this.setLocationRelativeTo(null);
		Shape shape = new RoundRectangle2D.Double(0,0,this.getBounds().width, this.getBounds().height, 26, 26);
		this.setShape(shape);
		contentPane = new JPanel();
		contentPane.addMouseMotionListener(this);
		contentPane.addMouseListener(this);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setBackground(new Color(255, 255, 255, 210));
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 42, 224, 578);
		panel.setBackground(new Color(255, 255, 255));
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		panel_2 = new JPanel();
		panel_2.setBounds(0, 12, 64, 45);
		panel_2.setBackground(new Color(255,255,255));
		panel.add(panel_2);
		
		spSideBar = new JScrollPane();
		spSideBar.addMouseListener(this);
		spSideBar.setViewportBorder(null);
		spSideBar.setBounds(0, 57, 224, 428);
		spSideBar.setBorder(null);
		spSideBar.getVerticalScrollBar().setBackground(Color.WHITE);
		spSideBar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		panel.add(spSideBar);
		
		panelSideBar = new JPanel();
		panelSideBar.setBorder(null);
		panelSideBar.addMouseListener(this);
		panelSideBar.setBackground(new Color(255,255,255));
		spSideBar.setViewportView(panelSideBar);
		panelSideBar.setLayout(null);
		panelSideBar.setPreferredSize(new Dimension(200,560));
		
		panelReporte = new JPanel();
		panelReporte.setBackground(Color.WHITE);
		panelReporte.setBounds(0, 11, 205, 45);
		panelSideBar.add(panelReporte);
		panelReporte.setLayout(null);
		
		lblReporte = new JLabel("Reportes");
		lblReporte.addMouseListener(this);
		lblReporte.setHorizontalAlignment(SwingConstants.CENTER);
		lblReporte.setBounds(0, 0, 205, 45);
		panelReporte.add(lblReporte);
		lblReporte.setFont(new Font("Segoe UI Symbol", Font.BOLD, 18));
		
		panelBarItem_2 = new JPanel();
		panelBarItem_2.setBackground(Color.WHITE);
		panelBarItem_2.setBounds(0, 56, 205, 45);
		panelSideBar.add(panelBarItem_2);
		panelBarItem_2.setLayout(null);
		
		lblReportes_1 = new JLabel("Reportes");
		lblReportes_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblReportes_1.setFont(new Font("Segoe UI Symbol", Font.BOLD, 18));
		lblReportes_1.setBounds(0, 0, 205, 45);
		panelBarItem_2.add(lblReportes_1);
		
		panelBarItem_3 = new JPanel();
		panelBarItem_3.setBackground(Color.WHITE);
		panelBarItem_3.setBounds(0, 100, 205, 45);
		panelSideBar.add(panelBarItem_3);
		panelBarItem_3.setLayout(null);
		
		lblReportes_2 = new JLabel("Reportes");
		lblReportes_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblReportes_2.setFont(new Font("Segoe UI Symbol", Font.BOLD, 18));
		lblReportes_2.setBounds(0, 0, 205, 45);
		panelBarItem_3.add(lblReportes_2);
		
		panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(0, 145, 205, 45);
		panelSideBar.add(panel_5);
		panel_5.setLayout(null);
		
		lblReportes_3 = new JLabel("Reportes");
		lblReportes_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblReportes_3.setFont(new Font("Segoe UI Symbol", Font.BOLD, 18));
		lblReportes_3.setBounds(0, 0, 205, 45);
		panel_5.add(lblReportes_3);
		
		panel_7 = new JPanel();
		panel_7.setBackground(Color.WHITE);
		panel_7.setBounds(0, 189, 205, 45);
		panelSideBar.add(panel_7);
		panel_7.setLayout(null);
		
		lblReportes_4 = new JLabel("Reportes");
		lblReportes_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblReportes_4.setFont(new Font("Segoe UI Symbol", Font.BOLD, 18));
		lblReportes_4.setBounds(0, 0, 205, 45);
		panel_7.add(lblReportes_4);
		
		panel_8 = new JPanel();
		panel_8.setBackground(Color.WHITE);
		panel_8.setBounds(0, 234, 205, 45);
		panelSideBar.add(panel_8);
		panel_8.setLayout(null);
		
		lblReportes_5 = new JLabel("Reportes");
		lblReportes_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblReportes_5.setFont(new Font("Segoe UI Symbol", Font.BOLD, 18));
		lblReportes_5.setBounds(0, 0, 205, 45);
		panel_8.add(lblReportes_5);
		
		panel_9 = new JPanel();
		panel_9.setBackground(Color.WHITE);
		panel_9.setBounds(0, 278, 205, 45);
		panelSideBar.add(panel_9);
		panel_9.setLayout(null);
		
		lblReportes_6 = new JLabel("Reportes");
		lblReportes_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblReportes_6.setFont(new Font("Segoe UI Symbol", Font.BOLD, 18));
		lblReportes_6.setBounds(0, 0, 205, 45);
		panel_9.add(lblReportes_6);
		
		panel_10 = new JPanel();
		panel_10.setBackground(Color.WHITE);
		panel_10.setBounds(0, 323, 205, 45);
		panelSideBar.add(panel_10);
		panel_10.setLayout(null);
		
		lblReportes_7 = new JLabel("Reportes");
		lblReportes_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblReportes_7.setFont(new Font("Segoe UI Symbol", Font.BOLD, 18));
		lblReportes_7.setBounds(0, 0, 205, 45);
		panel_10.add(lblReportes_7);
		
		panel_11 = new JPanel();
		panel_11.setBackground(Color.WHITE);
		panel_11.setBounds(0, 368, 205, 45);
		panelSideBar.add(panel_11);
		panel_11.setLayout(null);
		
		lblReportes_8 = new JLabel("Reportes");
		lblReportes_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblReportes_8.setFont(new Font("Segoe UI Symbol", Font.BOLD, 18));
		lblReportes_8.setBounds(0, 0, 205, 45);
		panel_11.add(lblReportes_8);
		
		panel_12 = new JPanel();
		panel_12.setBackground(Color.WHITE);
		panel_12.setBounds(0, 412, 205, 45);
		panelSideBar.add(panel_12);
		panel_12.setLayout(null);
		
		lblReportes_9 = new JLabel("Reportes");
		lblReportes_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblReportes_9.setFont(new Font("Segoe UI Symbol", Font.BOLD, 18));
		lblReportes_9.setBounds(0, 0, 205, 45);
		panel_12.add(lblReportes_9);
		
		panel_13 = new JPanel();
		panel_13.setBackground(Color.WHITE);
		panel_13.setBounds(0, 457, 205, 45);
		panelSideBar.add(panel_13);
		panel_13.setLayout(null);
		
		lblReportes_10 = new JLabel("Reportes");
		lblReportes_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblReportes_10.setFont(new Font("Segoe UI Symbol", Font.BOLD, 18));
		lblReportes_10.setBounds(0, 0, 205, 45);
		panel_13.add(lblReportes_10);
		
		panel_14 = new JPanel();
		panel_14.setBackground(Color.WHITE);
		panel_14.setBounds(0, 501, 205, 45);
		panelSideBar.add(panel_14);
		panel_14.setLayout(null);
		
		lblReportes_11 = new JLabel("Reportes");
		lblReportes_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblReportes_11.setFont(new Font("Segoe UI Symbol", Font.BOLD, 18));
		lblReportes_11.setBounds(0, 0, 205, 45);
		panel_14.add(lblReportes_11);
		
		panelExit = new JPanel();
		panelExit.setBorder(null);
		panelExit.setBackground(new Color(255,255,255));
		panelExit.setBounds(10, 531, 116, 36);
		panel.add(panelExit);
		panelExit.setLayout(null);
		
		lblExit = new JLabel("Sign Out");
		lblExit.addMouseListener(this);
		lblExit.setForeground(new Color(204, 0, 0));
		lblExit.setHorizontalAlignment(SwingConstants.CENTER);
		lblExit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblExit.setBounds(0, 0, 116, 36);
		panelExit.add(lblExit);
		
		lblLogo = new JLabel("Logo Here");
		lblLogo.setBounds(21, 17, 72, 20);
		lblLogo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		contentPane.add(lblLogo);
	}
	public void actionPerformed(ActionEvent e) {
	}
	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getSource() == contentPane) {
			mousePressedContentPane(e);
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == lblExit) {
			mouseClickedLblExit(e);
		}		
	}

	@Override
	public void mouseReleased(MouseEvent e) {	
		if(e.getSource() == contentPane) {
			mouseReleasedContentPane(e);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == lblReporte) {
			mouseEnteredLblReportes(e);
		}
		if (e.getSource() == panelSideBar) {
			mouseEnteredPanelSideBar(e);
		}
		if (e.getSource() == lblExit) {
			mouseEnteredLblExit(e);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == panelSideBar) {
			mouseExitedPanelSideBar(e);
		}
		if (e.getSource() == lblExit) {
			mouseExitedLblExit(e);
		}
		if (e.getSource() == lblReporte) {
			mouseExitedLblReportes(e);
		}
	}
	public void mouseDragged(MouseEvent e) {
		if (e.getSource() == contentPane) {
			mouseDraggedContentPane(e);
		}
	}
	public void mouseMoved(MouseEvent e) {
	}
	
	protected void mousePressedContentPane(MouseEvent e) {
		xMouse = e.getX();
		yMouse = e.getY();
	}

	
	//Drag and drop
	protected void mouseDraggedContentPane(MouseEvent e) {
		contentPane.setCursor(new Cursor(Cursor.MOVE_CURSOR));
		int x = e.getXOnScreen();
		int y = e.getYOnScreen();
		this.setLocation(x - xMouse, y - yMouse);
	}
	
	protected void mouseReleasedContentPane(MouseEvent e) {
		contentPane.setCursor(Cursor.getDefaultCursor());
	}
	
	//Show the scroll bar when is hover	
	protected void mouseEnteredPanelSideBar(MouseEvent e) {
		spSideBar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	}
	//Don't show the scroll bar when is not hover	
	protected void mouseExitedPanelSideBar(MouseEvent e) {
		spSideBar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
	}
	//Exit Button
	protected void mouseClickedLblExit(MouseEvent e) {
		System.exit(0);
	}
	//Exit hover
	protected void mouseEnteredLblExit(MouseEvent e) {
		panelExit.setBackground(new Color(236,236, 236));
		lblExit.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	//Exit not hover
	protected void mouseExitedLblExit(MouseEvent e) {
		panelExit.setBackground(new Color(255,255, 255));
	}
	//Report hover
	protected void mouseEnteredLblReportes(MouseEvent e) {
		panelReporte.setBackground(new Color(244,244, 244));
		lblReporte.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	//Report not hover
	protected void mouseExitedLblReportes(MouseEvent e) {
		panelReporte.setBackground(new Color(255,255, 255));
	}
}
