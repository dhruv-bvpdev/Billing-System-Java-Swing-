package Billing;

//import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Billing.Helper.DB_Handler;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
//import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class Screen_3 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
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
					Screen_3 frame = new Screen_3();
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
	public Screen_3() throws ClassNotFoundException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel CPanel_2 = new JPanel();
		CPanel_2.setLayout(null);
		CPanel_2.setBackground(Color.WHITE);
		contentPane.add(CPanel_2, "Login");
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(SystemColor.textInactiveText);
		panel.setBounds(143, 0, 281, 251);
		CPanel_2.add(panel);
		
		JLabel lblNewLabel_4 = new JLabel("FIRST NAME:");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_4.setBounds(10, 26, 78, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("LAST NAME:");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_5.setBounds(10, 50, 78, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("MOBILE:");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_6.setBounds(10, 75, 78, 14);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("ADDRESS:");
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_7.setBounds(10, 100, 78, 14);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("AADHAAR:");
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_8.setBounds(10, 125, 78, 14);
		panel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("USER NAME:");
		lblNewLabel_9.setForeground(Color.WHITE);
		lblNewLabel_9.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_9.setBounds(10, 150, 78, 14);
		panel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("PASSWORD:");
		lblNewLabel_10.setForeground(Color.WHITE);
		lblNewLabel_10.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_10.setBounds(10, 175, 78, 14);
		panel.add(lblNewLabel_10);
		
		JButton btnNewButton_1 = new JButton("SIGNUP");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		        String insert  = "INSERT INTO users(First_Name,Last_Name,Mobile,Address,Aadhaar,User_Name,Password)"+ "VALUES(?,?,?,?,?,?,?)";
		        String fn = textField.getText();
		        String ln = textField_1.getText();
		        int m1 = Integer.parseInt(textField_2.getText());
		        String ad1 = textField_3.getText();
		        int ad2 = Integer.parseInt(textField_4.getText());
		        String u1= textField_5.getText();
		        String p1 = textField_6.getText();
		        try {
					preparedstatement = (PreparedStatement) connection.prepareStatement(insert);
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
		        try {
					preparedstatement.setString(1,fn);
					preparedstatement.setString(2,ln);
			        preparedstatement.setInt(3,m1);
			        preparedstatement.setString(4,ad1);
			        preparedstatement.setInt(5,ad2);
			        preparedstatement.setString(6,u1);
			        preparedstatement.setString(7,p1);
			        preparedstatement.executeUpdate();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        CardLayout c = (CardLayout)(contentPane.getLayout());
		        c.show(contentPane,"confirmation");
		        
		        
		        
			}
		});
		btnNewButton_1.setBounds(98, 217, 89, 23);
		panel.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(98, 21, 178, 20);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(98, 45, 178, 20);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(98, 70, 178, 20);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(98, 95, 178, 20);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(98, 120, 178, 20);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(98, 145, 178, 20);
		panel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(98, 170, 178, 20);
		panel.add(textField_6);
		
		BufferedImage myPicture_2=null;
		try {
			myPicture_2 = ImageIO.read(new File("C:\\Users\\dhruv\\Desktop\\Practicals\\Projects\\BillingSystem\\src\\Billing\\Download_4.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JLabel lblNewLabel_11 = new JLabel(new ImageIcon(myPicture_2));
		lblNewLabel_11.setBounds(10, 39, 133, 174);
		CPanel_2.add(lblNewLabel_11);
		
		JPanel CPanel_4 = new JPanel();
		contentPane.add(CPanel_4, "confirmation");
		CPanel_4.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaptionBorder);
		panel_1.setBounds(0, 0, 424, 251);
		CPanel_4.add(panel_1);
		panel_1.setLayout(null);
		
		JTextArea txtrNewUserCreated = new JTextArea();
		txtrNewUserCreated.setForeground(SystemColor.activeCaptionText);
		txtrNewUserCreated.setFont(new Font("Calibri", Font.BOLD, 15));
		txtrNewUserCreated.setBackground(SystemColor.activeCaptionBorder);
		txtrNewUserCreated.setText("NEW USER CREATED\r\n RETURN TO THE LOGIN PAGE TO CONTINUE");
		txtrNewUserCreated.setBounds(77, 85, 280, 50);
		panel_1.add(txtrNewUserCreated);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				try {
					Screen_2 sc_2 = new Screen_2();
					sc_2.setVisible(true);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 12));
		btnNewButton.setBackground(SystemColor.activeCaptionBorder);
		btnNewButton.setBounds(302, 211, 112, 29);
		panel_1.add(btnNewButton);
	}
}
