package Billing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Billing.Helper.DB_Handler;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Screen_6 extends JFrame {

	private JPanel contentPane;
	private JTable table;
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
					Screen_6 frame = new Screen_6();
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
	public Screen_6() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 453, 335);
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
		
		JButton btnNewButton = new JButton("GO BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Screen_2 sc_2;
				try {
					sc_2 = new Screen_2();
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
		btnNewButton.setBounds(0, 273, 119, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("FETCH CUSTOMER INFO");
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
		        String query = "SELECT * FROM customer";
		        try {
					 PreparedStatement st= (PreparedStatement) connection.prepareStatement(query);
					 ResultSet rs = st.executeQuery();
					 DefaultTableModel t_1 = (DefaultTableModel) table.getModel();
					 t_1.addColumn("Customer_ID");
					 t_1.addColumn("C_Name");
					 t_1.addColumn("C_Phone");
					 t_1.addColumn("C_Address");
					 t_1.setRowCount(0);
					 while(rs.next())
					 {
						 Object o[] = {rs.getInt("Customer_ID"),rs.getString("C_Name"),rs.getInt("C_Phone"),rs.getString("C_Address")};
						 t_1.addRow(o);
					 }
						
		        }catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(115, 273, 175, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("ADD NEW CUSTOMER");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Screen_7 sc7 = new Screen_7();
				sc7.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(289, 273, 145, 23);
		contentPane.add(btnNewButton_2);
	}
}
