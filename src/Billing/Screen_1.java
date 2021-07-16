package Billing;

import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.Font;

public class Screen_1 implements ActionListener {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Screen_1 window = new Screen_1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Screen_1() {
		initialize();
		Timer pause = new Timer(10000,this);
		pause.start();
		frame.addMouseListener(new MouseAdapter() {
		        public void mouseClicked(MouseEvent e) {
		                   try {
							shownextScreen();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		        	     }
		        });
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 450, 300);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.textInactiveText);
		panel_1.setBounds(167, 0, 283, 300);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CONSUMER BILLING SYSTEM");
		lblNewLabel.setForeground(SystemColor.window);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 21));
		lblNewLabel.setBounds(10, 109, 251, 26);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("A PRODUCT OF GTS");
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD, 16));
		lblNewLabel_2.setForeground(SystemColor.window);
		lblNewLabel_2.setBounds(73, 269, 144, 20);
		panel_1.add(lblNewLabel_2);
		
		BufferedImage myPicture=null;
		try {
			myPicture = ImageIO.read(new File("C:\\Users\\dhruv\\Desktop\\Practicals\\Projects\\BillingSystem\\src\\Billing\\Download_2.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JLabel lblNewLabel_1 = new JLabel(new ImageIcon(myPicture));
		lblNewLabel_1.setBounds(10, 63, 149, 174);
		panel.add(lblNewLabel_1);
		
	}
	public void shownextScreen() throws ClassNotFoundException, SQLException
	{
		frame.dispose();
		Screen_2 sc2 = new Screen_2();
		sc2.setVisible(true);

	}
	public void actionPerformed(ActionEvent e)
	{
		//shownextScreen();
	}
}
