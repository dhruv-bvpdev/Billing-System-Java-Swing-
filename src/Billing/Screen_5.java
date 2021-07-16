package Billing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Billing.Helper.DB_Handler;

import java.awt.CardLayout;
import java.awt.SystemColor;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class Screen_5 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	static private DB_Handler DBhandler;
    static private Connection connection;
    static private PreparedStatement preparedstatement;
    private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Screen_5 frame = new Screen_5();
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
	public Screen_5() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel CPanel_6 = new JPanel();
		CPanel_6.setBackground(SystemColor.window);
		contentPane.add(CPanel_6, "IVPANEL");
		CPanel_6.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaptionBorder);
		panel.setBounds(148, 0, 276, 251);
		CPanel_6.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SERIAL NUMBER");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 32, 101, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ITEM NAME");
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 62, 101, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("BATCH NUMBER");
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 93, 101, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("QUANTITY");
		lblNewLabel_3.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_3.setBounds(10, 123, 101, 14);
		panel.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(111, 27, 155, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(111, 57, 155, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(111, 88, 155, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(111, 118, 155, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("UPDATE INVENTORY");
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
		        String insert  = "INSERT INTO inventory(Serial_Number,Item_name,Batch_Number,Quantity,Price)"+ "VALUES(?,?,?,?,?)";
		        String sn = textField.getText();
		        String in = textField_1.getText();
		        String bn = textField_2.getText();
		        int q = Integer.parseInt(textField_3.getText());
		        int pr = Integer.parseInt(textField_4.getText());
		        try {
					preparedstatement = (PreparedStatement) connection.prepareStatement(insert);
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
		        try {
					preparedstatement.setString(1,sn);
					preparedstatement.setString(2,in);
			        preparedstatement.setString(3,bn);
			        preparedstatement.setInt(4,q);
			        preparedstatement.setInt(5,pr);
			        preparedstatement.executeUpdate();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        CardLayout c = (CardLayout)(contentPane.getLayout());
		        c.show(contentPane,"confirmation_1");
			}
		});
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 11));
		btnNewButton.setBounds(73, 217, 125, 23);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_5 = new JLabel("PRICE");
		lblNewLabel_5.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_5.setBounds(10, 153, 101, 14);
		panel.add(lblNewLabel_5);
		
		textField_4 = new JTextField();
		textField_4.setBounds(111, 148, 155, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		BufferedImage myPicture_1=null;
		try {
			myPicture_1 = ImageIO.read(new File("C:\\Users\\dhruv\\Desktop\\Practicals\\Projects\\BillingSystem\\src\\Billing\\Download_5.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JLabel lblNewLabel_4 = new JLabel(new ImageIcon(myPicture_1));
		lblNewLabel_4.setBounds(2, 55, 136, 139);
		CPanel_6.add(lblNewLabel_4);
		
		JPanel CPanel_7 = new JPanel();
		CPanel_7.setBackground(SystemColor.activeCaptionBorder);
		contentPane.add(CPanel_7, "confirmation_1");
		CPanel_7.setLayout(null);
		
		JTextArea txtrInventoryUpdatedSuccessfully = new JTextArea();
		txtrInventoryUpdatedSuccessfully.setFont(new Font("Calibri", Font.BOLD, 16));
		txtrInventoryUpdatedSuccessfully.setBackground(SystemColor.activeCaptionBorder);
		txtrInventoryUpdatedSuccessfully.setBounds(74, 97, 298, 38);
		txtrInventoryUpdatedSuccessfully.setText("Inventory Updated Successfully...!!");
		txtrInventoryUpdatedSuccessfully.setEditable(false);
		CPanel_7.add(txtrInventoryUpdatedSuccessfully);
		
		JButton btnNewButton_1 = new JButton("Go Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Screen_4 sc_4 = new Screen_4();
				sc_4.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Calibri", Font.BOLD, 13));
		btnNewButton_1.setBounds(325, 217, 89, 23);
		CPanel_7.add(btnNewButton_1);
	}
}
