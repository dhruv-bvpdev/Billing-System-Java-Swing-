package Billing;

//import java.awt.BorderLayout;





import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
//import javax.swing.text.Document;

import java.awt.CardLayout;
import java.awt.SystemColor;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Billing.Helper.DB_Handler;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JTextArea;
//import java.awt.Color;

public class Screen_2 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static private JPanel contentPane;
	private static JTextField textField;
	private JPasswordField passwordField;
	static private DB_Handler DBhandler;
    static private Connection connection;
    static private PreparedStatement preparedstatement;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Screen_2 frame = new Screen_2();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}   
		});
	}

	/**
	 * Create the frame.
	 */
	public Screen_2() throws SQLException, ClassNotFoundException{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		CardLayout c = (CardLayout)(contentPane.getLayout());
		
		JPanel CPanel_1 = new JPanel();
		CPanel_1.setBackground(SystemColor.window);
		contentPane.add(CPanel_1, "LOGIN");
		CPanel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.textInactiveText);
		panel_2.setBounds(161, 0, 263, 251);
		CPanel_1.add(panel_2);
		panel_2.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(87, 57, 166, 20);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("USERNAME:");
		lblNewLabel.setForeground(SystemColor.window);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 60, 79, 14);
		panel_2.add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(87, 94, 166, 20);
		panel_2.add(passwordField);
		
		JLabel lblNewLabel_2 = new JLabel("PASSWORD:");
		lblNewLabel_2.setForeground(SystemColor.window);
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 97, 79, 14);
		panel_2.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					String s1 = textField.getText();
					String s2 = new String(passwordField.getPassword());
					DBhandler = new DB_Handler();
			        try {
						connection = DBhandler.getDbConnection();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			        String query = "SELECT * FROM users WHERE User_Name = ? and Password=?";
			        try {
						 PreparedStatement st= (PreparedStatement) connection.prepareStatement(query);
						 st.setString(1,s1);
						 st.setString(2,s2);
						 ResultSet rs = st.executeQuery();
						 if(rs.next())
						 {
							 c.show(contentPane, "Menu");
						 }
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}	
			}
		});
		btnNewButton.setForeground(SystemColor.desktop);
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 12));
		btnNewButton.setBackground(SystemColor.activeCaptionBorder);
		btnNewButton.setBounds(87, 161, 89, 20);
		panel_2.add(btnNewButton);
		
		BufferedImage myPicture=null;
		try {
			myPicture = ImageIO.read(new File("C:\\Users\\dhruv\\Desktop\\Practicals\\Projects\\BillingSystem\\src\\Billing\\Download_3.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JLabel lblNewLabel_1 = new JLabel(new ImageIcon(myPicture));
		lblNewLabel_1.setBounds(10, 39, 149, 174);
		CPanel_1.add(lblNewLabel_1);
		
		BufferedImage myPicture_2=null;
		try {
			myPicture_2 = ImageIO.read(new File("C:\\Users\\dhruv\\Desktop\\Practicals\\Projects\\BillingSystem\\src\\Billing\\Download_4.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JPanel CPanel_3 = new JPanel();
		CPanel_3.setBackground(SystemColor.window);
		contentPane.add(CPanel_3, "Menu");
		CPanel_3.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaptionBorder);
		panel_1.setBounds(0, 0, 424, 49);
		CPanel_3.add(panel_1);
		panel_1.setLayout(null);
		
		GregorianCalendar time = new GregorianCalendar();
		 Date s_22 = time.getTime();
		JLabel lblNewLabel_12 = new JLabel(s_22.toString());
		lblNewLabel_12.setForeground(SystemColor.window);
		lblNewLabel_12.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_12.setBounds(241, 34, 183, 15);
		panel_1.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Last Login:");
		lblNewLabel_13.setForeground(SystemColor.window);
		lblNewLabel_13.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_13.setBounds(165, 31, 76, 18);
		panel_1.add(lblNewLabel_13);
		
		JLabel lblNewLabel_3 = new JLabel("LogOut");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout c = (CardLayout)(contentPane.getLayout());
				c.show(contentPane,"LOGIN");
			}
		});
		lblNewLabel_3.setForeground(SystemColor.window);
		lblNewLabel_3.setFont(new Font("Calibri", Font.BOLD, 12));
		lblNewLabel_3.setBounds(10, 34, 46, 14);
		panel_1.add(lblNewLabel_3);
		
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.window);
		panel_3.setBounds(0, 48, 424, 49);
		CPanel_3.add(panel_3);
		panel_3.setLayout(null);
		
		JTextArea txtrAddNewUser = new JTextArea("ADD NEW USER \r\n ");
		txtrAddNewUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Screen_3 sc3;
				try {
					sc3 = new Screen_3();
					sc3.setVisible(true);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		txtrAddNewUser.setFont(new Font("Dialog", Font.BOLD, 18));
		txtrAddNewUser.setForeground(SystemColor.activeCaptionText);
		txtrAddNewUser.setEditable(false);
		txtrAddNewUser.setBounds(0, 0, 424, 49);
		panel_3.add(txtrAddNewUser);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(SystemColor.activeCaptionBorder);
		panel_4.setBounds(0, 98, 424, 49);
		CPanel_3.add(panel_4);
		panel_4.setLayout(null);
		
		JTextArea txtrCreateBillLeads = new JTextArea();
		txtrCreateBillLeads.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Screen_8 sc8 = new Screen_8();
				sc8.setVisible(true);
			}
		});
		txtrCreateBillLeads.setEditable(false);
		txtrCreateBillLeads.setFont(new Font("Dialog", Font.BOLD, 18));
		txtrCreateBillLeads.setText("CREATE BILL\r\n ");
		txtrCreateBillLeads.setBackground(SystemColor.activeCaptionBorder);
		txtrCreateBillLeads.setBounds(0, 0, 424, 49);
		panel_4.add(txtrCreateBillLeads);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(SystemColor.window);
		panel_5.setBounds(0, 147, 424, 50);
		CPanel_3.add(panel_5);
		panel_5.setLayout(null);
		
		JTextArea txtrCheckInventory = new JTextArea();
		txtrCheckInventory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Screen_4 sc4 = new Screen_4();
				sc4.setVisible(true);
			}
		});
		txtrCheckInventory.setFont(new Font("Dialog", Font.BOLD, 18));
		txtrCheckInventory.setText("CHECK INVENTORY");
		txtrCheckInventory.setEditable(false);
		txtrCheckInventory.setBounds(0, 0, 424, 50);
		panel_5.add(txtrCheckInventory);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(SystemColor.activeCaptionBorder);
		panel_6.setBounds(0, 197, 424, 54);
		CPanel_3.add(panel_6);
		panel_6.setLayout(null);
		
		JTextArea txtrFetchCustomerInformation = new JTextArea();
		txtrFetchCustomerInformation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Screen_6 sc6 = new Screen_6();
				sc6.setVisible(true);
			}
		});
		txtrFetchCustomerInformation.setFont(new Font("Dialog", Font.BOLD, 18));
		txtrFetchCustomerInformation.setText("FETCH CUSTOMER INFORMATION");
		txtrFetchCustomerInformation.setBackground(SystemColor.activeCaptionBorder);
		txtrFetchCustomerInformation.setEditable(false);
		txtrFetchCustomerInformation.setBounds(0, 0, 424, 54);
		panel_6.add(txtrFetchCustomerInformation);
		
		
	}
	public static void showcard()
	{
		CardLayout c = (CardLayout)(contentPane.getLayout());
		c.show(contentPane, "Menu");
	}
}
