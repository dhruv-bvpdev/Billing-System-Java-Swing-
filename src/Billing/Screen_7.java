package Billing;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Billing.Helper.DB_Handler;

import java.awt.CardLayout;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class Screen_7 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
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
					Screen_7 frame = new Screen_7();
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
	public Screen_7() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel CPanel_7 = new JPanel();
		CPanel_7.setBackground(SystemColor.window);
		contentPane.add(CPanel_7, "AddC");
		CPanel_7.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaptionBorder);
		panel.setBounds(142, 0, 282, 251);
		CPanel_7.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CUSTOMER ID");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 47, 105, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CUSTOMER NAME");
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 88, 105, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CUSTOMER PHONE");
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 133, 110, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("ADDRESS");
		lblNewLabel_3.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_3.setBounds(10, 182, 110, 14);
		panel.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(125, 42, 147, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(125, 83, 147, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(125, 128, 147, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(125, 177, 147, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("CONFIRM");
		btnNewButton.addActionListener(new ActionListener() {
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
		        String insert  = "INSERT INTO customer(Customer_ID,C_Name,C_Phone,C_Address)"+ "VALUES(?,?,?,?)";
		        int ci = Integer.parseInt(textField.getText());
		        String cn = textField_1.getText();
		        int phn = Integer.parseInt(textField_2.getText());
		        String addr = textField_3.getText();
		        try {
					preparedstatement = (PreparedStatement) connection.prepareStatement(insert);
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
		        try {
					preparedstatement.setInt(1,ci);
					preparedstatement.setString(2,cn);
			        preparedstatement.setInt(3,phn);
			        preparedstatement.setString(4,addr);
			        preparedstatement.executeUpdate();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				CardLayout c = (CardLayout)(contentPane.getLayout());
				c.show(contentPane,"Confirmation_2");
			}
		});
		btnNewButton.setBounds(88, 217, 89, 23);
		panel.add(btnNewButton);
		
		BufferedImage myPicture_1=null;
		try {
			myPicture_1 = ImageIO.read(new File("C:\\Users\\dhruv\\Desktop\\Practicals\\Projects\\BillingSystem\\src\\Billing\\Download_6.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JLabel lblNewLabel_4 = new JLabel(new ImageIcon(myPicture_1));
		lblNewLabel_4.setBounds(10, 55, 128, 139);
		CPanel_7.add(lblNewLabel_4);
		
		JPanel CPanel_8 = new JPanel();
		CPanel_8.setBackground(SystemColor.activeCaptionBorder);
		contentPane.add(CPanel_8, "Confirmation_2");
		CPanel_8.setLayout(null);
		
		JTextArea txtrCustomerInformationAdded = new JTextArea();
		txtrCustomerInformationAdded.setFont(new Font("Calibri", Font.BOLD, 16));
		txtrCustomerInformationAdded.setText("CUSTOMER INFORMATION ADDED SUCCESSFULLY...!!");
		txtrCustomerInformationAdded.setBackground(SystemColor.activeCaptionBorder);
		txtrCustomerInformationAdded.setBounds(28, 93, 368, 44);
		CPanel_8.add(txtrCustomerInformationAdded);
		
		JButton btnNewButton_1 = new JButton("GO BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Screen_2 sc_22;
				try {
					sc_22 = new Screen_2();
					sc_22.setVisible(true);
					sc_22.showcard();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton_1.setBounds(325, 217, 89, 23);
		CPanel_8.add(btnNewButton_1);
	}
}
