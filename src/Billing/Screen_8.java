package Billing;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.util.*;

import Billing.Helper.DB_Handler;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Screen_8 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
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
					Screen_8 frame = new Screen_8();
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
	public Screen_8() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 457);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel CPanel_1a = new JPanel();
		CPanel_1a.setBackground(SystemColor.activeCaptionBorder);
		contentPane.add(CPanel_1a, "bill_i");
		CPanel_1a.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NAME");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 16, 50, 14);
		CPanel_1a.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(63, 13, 115, 20);
		CPanel_1a.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("PHONE:");
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_1.setBounds(188, 18, 50, 14);
		CPanel_1a.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(247, 13, 115, 20);
		CPanel_1a.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("ADDRESS:");
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_2.setBounds(372, 16, 60, 14);
		CPanel_1a.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(442, 13, 115, 20);
		CPanel_1a.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("SEARCH");
		btnNewButton.setBackground(SystemColor.activeCaptionBorder);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s1 = textField.getText();
				String s2 = textField_1.getText();
				String s3 = textField_2.getText();
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
		        String query = "SELECT * FROM customer WHERE C_Name = ? and C_Phone=? and C_Address=?";
		        try {
					 PreparedStatement st= (PreparedStatement) connection.prepareStatement(query);
					 st.setString(1,s1);
					 st.setString(2,s2);
					 st.setString(3,s3);
					 ResultSet rs = st.executeQuery();
					 if(rs.next())
					 {
						 CardLayout c = (CardLayout)(contentPane.getLayout());
						 c.show(contentPane,"confirm_1");
						 int s31 = rs.getInt("Customer_ID");
						 textField_3.setText(Integer.toString(s31));
					 }
					 else
					 {
						 CardLayout c = (CardLayout)(contentPane.getLayout());
						 c.show(contentPane,"deny_1");
					 }
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
		        
		        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
		        Date date = new Date();  
		        textField_4.setText(formatter.format(date));
			}
		});
		btnNewButton.setBounds(603, 12, 150, 23);
		CPanel_1a.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("ID:");
		lblNewLabel_3.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_3.setBounds(10, 52, 50, 14);
		CPanel_1a.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(63, 47, 115, 20);
		CPanel_1a.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("DATE");
		lblNewLabel_4.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_4.setBounds(188, 50, 46, 14);
		CPanel_1a.add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(247, 47, 115, 20);
		CPanel_1a.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("CREATE NEW BILL");
		btnNewButton_1.setBackground(SystemColor.activeCaptionBorder);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s11_2 = textField.getText();
				String s11_3 = textField_4.getText();
				FileWriter bw_3;
				try {
					bw_3 = new FileWriter("src/billing/Users.txt", true);
					BufferedWriter bw2 = new BufferedWriter(bw_3);
			         PrintWriter out = new PrintWriter(bw2);
			         out.write(s11_2);
			         out.write(" ");
			         out.write(s11_3);
			         out.write(" ");
			         out.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				textField.setEditable(false);
				textField_1.setEditable(false);
				textField_2.setEditable(false);
				textField_3.setEditable(false);
				textField_4.setEditable(false);
				textField_5.setEditable(true);
				textField_6.setEditable(true);
				textField_7.setEditable(true);
				textField_8.setEditable(true);
				textField_9.setEditable(true);
				textField_10.setEditable(true);
			}
		});
		btnNewButton_1.setBounds(603, 46, 150, 23);
		CPanel_1a.add(btnNewButton_1);
		
		JLabel lblNewLabel_5 = new JLabel("PRODUCT NAME:");
		lblNewLabel_5.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_5.setBounds(10, 119, 99, 14);
		CPanel_1a.add(lblNewLabel_5);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setBounds(119, 114, 150, 20);
		CPanel_1a.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("BATCH NUMBER:");
		lblNewLabel_6.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_6.setBounds(10, 168, 99, 14);
		CPanel_1a.add(lblNewLabel_6);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setBounds(119, 163, 150, 20);
		CPanel_1a.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("QUANTITY:");
		lblNewLabel_7.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_7.setBounds(10, 217, 99, 14);
		CPanel_1a.add(lblNewLabel_7);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setBounds(119, 212, 150, 20);
		CPanel_1a.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("PRICE:");
		lblNewLabel_8.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_8.setBounds(10, 266, 99, 14);
		CPanel_1a.add(lblNewLabel_8);
		
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setBounds(119, 261, 150, 20);
		CPanel_1a.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("GROSS AMOUNT:");
		lblNewLabel_9.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_9.setBounds(10, 315, 107, 14);
		CPanel_1a.add(lblNewLabel_9);
		
		textField_9 = new JTextField();
		textField_9.setEditable(false);
		textField_9.setBounds(119, 310, 150, 20);
		CPanel_1a.add(textField_9);
		textField_9.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("GST %:");
		lblNewLabel_10.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_10.setBounds(372, 117, 107, 14);
		CPanel_1a.add(lblNewLabel_10);
		
		textField_10 = new JTextField();
		textField_10.setEditable(false);
		textField_10.setBounds(482, 112, 150, 20);
		CPanel_1a.add(textField_10);
		textField_10.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("TOTAL AMOUNT:");
		lblNewLabel_11.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_11.setBounds(372, 166, 107, 14);
		CPanel_1a.add(lblNewLabel_11);
		
		textField_11 = new JTextField();
		textField_11.setEditable(false);
		textField_11.setBounds(482, 163, 150, 20);
		CPanel_1a.add(textField_11);
		textField_11.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("SEARCH ITEM");
		btnNewButton_2.setBackground(SystemColor.activeCaptionBorder);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s31 = textField_5.getText();
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
		        String query = "SELECT * FROM inventory WHERE Item_Name = ?";
		        try {
					 PreparedStatement st= (PreparedStatement) connection.prepareStatement(query);
					 st.setString(1,s31);
					 ResultSet rs = st.executeQuery();
					 if(rs.next())
					 {
						 String s32 = rs.getString("Batch_Number");
						 textField_6.setText(s32);
						 String s33 = rs.getString("Price");
						 textField_8.setText(s33);
					 }
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}	
			}
		});
		btnNewButton_2.setBounds(10, 368, 115, 23);
		CPanel_1a.add(btnNewButton_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.window);
		panel.setBounds(779, 16, 235, 381);
		CPanel_1a.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setBounds(88, 168, 46, 14);
		panel.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("<html>Shoppers Lounge<br/>Address: B-3/67 Paschim Vihar New Delhi<br/>Phone: 9999xxx888<br/>******************************</html>");
		lblNewLabel_13.setBounds(10, 11, 215, 77);
		lblNewLabel_13.setHorizontalAlignment(JLabel.CENTER);
		panel.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("Customer");
		lblNewLabel_14.setBounds(10, 93, 58, 14);
		panel.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("Date");
		lblNewLabel_15.setBounds(10, 118, 46, 14);
		panel.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("**********************************");
		lblNewLabel_16.setBounds(10, 143, 215, 14);
		panel.add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("ITEMS");
		lblNewLabel_17.setBounds(10, 168, 46, 14);
		panel.add(lblNewLabel_17);
		
		JLabel lblNewLabel_18 = new JLabel("PRICE");
		lblNewLabel_18.setBounds(179, 168, 46, 14);
		panel.add(lblNewLabel_18);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(10, 185, 124, 160);
		panel.add(textArea);
		
		JLabel lblNewLabel_19 = new JLabel("Total");
		lblNewLabel_19.setBounds(10, 356, 46, 14);
		panel.add(lblNewLabel_19);
		
		JLabel lblNewLabel_20 = new JLabel("");
		lblNewLabel_20.setBounds(179, 356, 46, 14);
		panel.add(lblNewLabel_20);
		
		JLabel lblNewLabel_21 = new JLabel("");
		lblNewLabel_21.setBounds(89, 118, 68, 14);
		panel.add(lblNewLabel_21);
		
		JLabel lblNewLabel_22 = new JLabel("");
		lblNewLabel_22.setBounds(89, 93, 68, 14);
		panel.add(lblNewLabel_22);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(179, 185, 46, 160);
		panel.add(textArea_1);
		
		JButton btnNewButton_6 = new JButton("ADD NEW ITEM");
		btnNewButton_6.setBackground(SystemColor.activeCaptionBorder);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int p_113 = Integer.parseInt(textField_7.getText());
				int p_112 = Integer.parseInt(textField_8.getText());
				int p_114 = p_113 * p_112;
				String s12 = String.valueOf(p_114);
				try{
					FileWriter bw_1 = new FileWriter("src/billing/multiply.txt",true);
					BufferedWriter bw = new BufferedWriter(bw_1);
					PrintWriter out = new PrintWriter(bw);
				    out.write(s12);
				    out.write("\n");
				    out.close();
				   
				}catch(Exception ex){
				    ex.printStackTrace();
				}
				String s112 = textField_5.getText();
				 FileWriter bw_2;
				try {
					bw_2 = new FileWriter("src/billing/Users.txt", true);
					BufferedWriter bw1 = new BufferedWriter(bw_2);
			         PrintWriter out = new PrintWriter(bw1);
			         out.write(s112);
			         out.write(" ");
			         out.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				String s111 = textField_5.getText();
				int s211 = Integer.parseInt(textField_7.getText());
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
		        String query = "SELECT * FROM inventory WHERE Item_name = ?";
		        try {
					 PreparedStatement st= (PreparedStatement) connection.prepareStatement(query);
					 st.setString(1,s111);
					 ResultSet rs = st.executeQuery();
					 if(rs.next())
					 {
						 String i11 = rs.getString("Item_name");
						 int p113 = rs.getInt("Quantity");
						 int z11 = p113 - s211;
						 if(z11<0)
						 {
							 System.exit(1);
						 }
						 String query_1 = "UPDATE inventory SET Quantity = ? WHERE Item_name = ?";
						 PreparedStatement st_1= (PreparedStatement) connection.prepareStatement(query_1);
						 st_1.setInt(1,z11);
						 st_1.setString(2,i11);
						 st_1.executeUpdate();
					 }
					 
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
		         
				textField_5.setText("");
				textField_6.setText("");
				textField_7.setText("");
				textField_8.setText("");
			}
		});
		btnNewButton_6.setBounds(153, 368, 124, 23);
		CPanel_1a.add(btnNewButton_6);
		
		JButton btnNewButton_3 = new JButton("PRINT BILL");
		btnNewButton_3.setBackground(SystemColor.activeCaptionBorder);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{

		            FileInputStream fstream1 = new FileInputStream("src/billing/Users.txt");
		            DataInputStream in1 = new DataInputStream(fstream1);
		            BufferedReader br = new BufferedReader(new InputStreamReader(in1));
		            String strLine;
		            ArrayList list=new ArrayList();
		            while ((strLine = br.readLine()) != null){
		                list.add(strLine);
		            }
		            Iterator itr;
		            for (itr=list.iterator(); itr.hasNext(); ){
		                String str=itr.next().toString();
		                String [] splitSt =str.split(" ");
		                String name="",date="",i1="",i2="",i3="",i4="",i5="",i6="",i7="",i8="",i9="",i10="";
		                for (int i = 0 ; i < splitSt.length ; i++) {
		                    name=splitSt[0];
		                    date=splitSt[1];
		                    i1=splitSt[2];
		                    i2=splitSt[3];
		                    i3=splitSt[4];
		                    i4=splitSt[5];
		                    i5=splitSt[6];
		                    i6=splitSt[7];
		                    i7=splitSt[8];
		                    i8=splitSt[9];
		                    i9=splitSt[10];
		                    i10=splitSt[11];
		                }
		                lblNewLabel_22.setText(name);
		                lblNewLabel_21.setText(date);
		                textArea.append(i1+"\n");
		                textArea.append(i2+"\n");
		                textArea.append(i3+"\n");
		                textArea.append(i4+"\n");
		                textArea.append(i5+"\n");
		                textArea.append(i6+"\n");
		                textArea.append(i7+"\n");
		                textArea.append(i8+"\n");
		                textArea.append(i9+"\n");
		                textArea.append(i10+"\n");
		               
		                br.close();

		            }
		        } catch (FileNotFoundException e11) {
		            e11.printStackTrace();
		        } catch (IOException e12) {
		            e12.printStackTrace();
		        }
				
				Path path = Paths.get("src/billing/multiply.txt");

		        long lines = 0;
		        try {
		            lines = Files.lines(path).count();

		        } catch (IOException e23) {
		            e23.printStackTrace();
		        }
		        if (lines < 10) {

		            FileWriter bw_1;
					try {
						bw_1 = new FileWriter("src/billing/multiply.txt", true);
						 BufferedWriter bw = new BufferedWriter(bw_1);
				            PrintWriter out = new PrintWriter(bw);
				            for (int i = 0; i < 10-lines; i++)
				            {
				                out.write("\n");
				                out.write("Null");
				            }
				            out.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		           
		        }

		        try{
		            File file=new File("src/billing/multiply.txt");    
		            FileReader fr=new FileReader(file);  
		            BufferedReader br=new BufferedReader(fr);  
		            StringBuffer sb=new StringBuffer();    
		            String line;
		            while((line=br.readLine())!=null)
		            {
		                sb.append(line);      
		                sb.append("\n");     
		            }
		            String s12 = sb.toString();
		            textArea_1.append(s12);
		            fr.close();

		        } catch (FileNotFoundException e24) {
		            e24.printStackTrace();
		        } catch (IOException e25) {
		            e25.printStackTrace();
		        }
				
				try {
					Files.delete(Paths.get("src/billing/multiply.txt"));
					Files.delete(Paths.get("src/billing/Users.txt"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_3.setBounds(508, 217, 124, 23);
		CPanel_1a.add(btnNewButton_3);
		
		JButton btnNewButton_7 = new JButton("GROSS AMOUNT");
		btnNewButton_7.setBackground(SystemColor.activeCaptionBorder);
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				
				String fileName = "src/billing/multiply.txt";

			    try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName));) {
			      long sum = 0;
			     while(true) {
			        String lineRead = fileReader.readLine();
			        if (lineRead == null) {
			          break;
			        }
			        long num = Integer.parseInt(lineRead);
			        sum += num;
			      }
			      textField_9.setText(String.valueOf(sum));
			    }
			    catch (IOException ioex) {
			      System.err.println("Error");
			    }
			}
		});
		btnNewButton_7.setBounds(308, 368, 136, 23);
		CPanel_1a.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("TOTAL AMOUNT");
		btnNewButton_8.setBackground(SystemColor.activeCaptionBorder);
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ga = Integer.parseInt(textField_9.getText());
				int gst = Integer.parseInt(textField_10.getText());
				int total = ga + (ga*gst)/100;
				textField_11.setText(String.valueOf(total));
				lblNewLabel_20.setText(String.valueOf(total));
				
				File file_11 = new File("src/billing/Users.txt");
		        Scanner scanner = null;

		        try {
		            scanner = new Scanner(file_11);
		        } catch (FileNotFoundException e_12) {
		            e_12.printStackTrace();
		        }

		        int number = 0;
		        if (scanner.hasNextLine()) {
		            number = scanner.nextLine().split(" ").length;
		        }

		        scanner.close();

		        if (number < 12) {

		            FileWriter bw_4;
					try {
						bw_4 = new FileWriter("src/billing/Users.txt", true);
						BufferedWriter bw3 = new BufferedWriter(bw_4);
			            PrintWriter out = new PrintWriter(bw3);
			            for (int i = 0; i < 12-number; i++)
			            {
			                out.write(" ");
			                out.write("Null");
			            }
			            out.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		            
		            
		        }
		        
		        try(BufferedReader br = new BufferedReader(new FileReader("src/billing/Users.txt"))) {
		            StringBuilder sb = new StringBuilder();
		            String line;
					try {
						line = br.readLine();
						while (line != null) {
			                sb.append(line);
			                sb.append(System.lineSeparator(  ));

			                line = br.readLine();
			            }
			            String everything = sb.toString();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

		            
		        } catch (FileNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				} catch (IOException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}


		        try{

		            FileInputStream fstream = new FileInputStream("src/billing/Users.txt");
		            DataInputStream in = new DataInputStream(fstream);
		            BufferedReader br = new BufferedReader(new InputStreamReader(in));
		            String strLine;
		            ArrayList list=new ArrayList();
		            while ((strLine = br.readLine()) != null){
		                list.add(strLine);
		            }
		            Iterator itr;
		            for (itr=list.iterator(); itr.hasNext(); ){
		                String str=itr.next().toString();
		                String [] splitSt =str.split(" ");
		                String name="",date="",i1="",i2="",i3="",i4="",i5="",i6="",i7="",i8="",i9="",i10="";
		                for (int i = 0 ; i < splitSt.length ; i++) {
		                    name=splitSt[0];
		                    date=splitSt[1];
		                    i1=splitSt[2];
		                    i2=splitSt[3];
		                    i3=splitSt[4];
		                    i4=splitSt[5];
		                    i5=splitSt[6];
		                    i6=splitSt[7];
		                    i7=splitSt[8];
		                    i8=splitSt[9];
		                    i9=splitSt[10];
		                    i10=splitSt[11];

		                }
		                String insert  = "insert into purchases values('"+name+"','"+date+"','"+i1+"','"+i2+"','"+i3+"','"+i4+"','"+i5+"','"+i6+"','"+i7+"','"+i8+"','"+i9+"','"+i10+"')";
		                try {
							preparedstatement = (PreparedStatement) connection.prepareStatement(insert);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		                try {
							preparedstatement.executeUpdate();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

		            }
		            br.close();
		        } catch (FileNotFoundException e2) {
		            e2.printStackTrace();
		        } catch (IOException e3) {
		            e3.printStackTrace();
		        }
			}
		});
		btnNewButton_8.setBounds(473, 368, 136, 23);
		CPanel_1a.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("BACK TO MENU");
		btnNewButton_9.setBackground(SystemColor.activeCaptionBorder);
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
					Screen_2 sc12 = new Screen_2();
					sc12.setVisible(true);
					sc12.showcard();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_9.setBounds(619, 368, 134, 23);
		CPanel_1a.add(btnNewButton_9);
		
		
		JPanel CPanel_1b = new JPanel();
		CPanel_1b.setBackground(SystemColor.activeCaptionBorder);
		contentPane.add(CPanel_1b, "confirm_1");
		CPanel_1b.setLayout(null);
		
		JTextArea txtrCustomerFound = new JTextArea();
		txtrCustomerFound.setEditable(false);
		txtrCustomerFound.setFont(new Font("Calibri", Font.BOLD, 22));
		txtrCustomerFound.setBackground(SystemColor.activeCaptionBorder);
		txtrCustomerFound.setText("CUSTOMER FOUND...!!");
		txtrCustomerFound.setBounds(396, 158, 219, 80);
		CPanel_1b.add(txtrCustomerFound);
		
		JButton btnNewButton_4 = new JButton("Continue");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			CardLayout c = (CardLayout)(contentPane.getLayout());
			c.show(contentPane,"bill_i");
			}
		});
		btnNewButton_4.setBounds(925, 374, 89, 23);
		CPanel_1b.add(btnNewButton_4);
		
		JPanel CPanel_1c = new JPanel();
		CPanel_1c.setBackground(SystemColor.activeCaptionBorder);
		contentPane.add(CPanel_1c, "deny_1");
		CPanel_1c.setLayout(null);
		
		JTextArea txtrCustomerNotFound = new JTextArea();
		txtrCustomerNotFound.setBackground(SystemColor.activeCaptionBorder);
		txtrCustomerNotFound.setEditable(false);
		txtrCustomerNotFound.setFont(new Font("Calibri", Font.BOLD, 22));
		txtrCustomerNotFound.setText("CUSTOMER NOT FOUND...!!\r\n ADD HIM TO DATABASE ");
		txtrCustomerNotFound.setBounds(367, 153, 279, 60);
		CPanel_1c.add(txtrCustomerNotFound);
		
		JButton btnNewButton_5 = new JButton("ADD");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			    Screen_7 sc_7 = new Screen_7();
			    sc_7.setVisible(true);
			}
		});
		btnNewButton_5.setBounds(925, 374, 89, 23);
		CPanel_1c.add(btnNewButton_5);
	}
}
