package Billing;

import java.awt.CardLayout;

//import java.awt.BorderLayout;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Billing.Helper.DB_Handler;


//import java.awt.CardLayout;
import javax.swing.JScrollPane;
//import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Screen_4 extends JFrame {

	private JPanel contentPane;
	private JTable table;
	static private DB_Handler DBhandler;
    static private Connection connection;
    //static private PreparedStatement preparedstatement;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Screen_4 frame = new Screen_4();
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
	public Screen_4() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 434, 267);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		scrollPane.setViewportView(table);
		
		
		
		JButton btnNewButton = new JButton("Fetch Inventory Records");
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
		        String query = "SELECT * FROM inventory";
		        try {
					 PreparedStatement st= (PreparedStatement) connection.prepareStatement(query);
					 ResultSet rs = st.executeQuery();
					 DefaultTableModel t_1 = (DefaultTableModel) table.getModel();
					 t_1.addColumn("Serial_Number");
					 t_1.addColumn("Item_name");
					 t_1.addColumn("Batch_Number");
					 t_1.addColumn("Quantity");
					 t_1.addColumn("Price");
					 t_1.setRowCount(0);
					 while(rs.next())
					 {
						 Object o[] = {rs.getInt("Serial_Number"),rs.getString("Item_name"),rs.getString("Batch_Number"),rs.getInt("Quantity"),rs.getInt("Price")};
						 t_1.addRow(o);
					 }
						
		        }catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}	
			}
		});
		btnNewButton.setBounds(131, 272, 152, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Update Inventory");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Screen_5 sc5 = new Screen_5();
				sc5.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(282, 272, 152, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				try {
					Screen_2 sc_2 = new Screen_2();
					sc_2.setVisible(true);
					sc_2.showcard();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_2.setBounds(0, 272, 134, 23);
		contentPane.add(btnNewButton_2);
	}
}
