package Final;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Add_Voter extends JFrame {
	private JFrame frame;
	private JTextField stdno;
	private JPasswordField pw;
	
	public static void add() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Voter window = new Add_Voter();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Add_Voter() {
		super("Add Voter");
		initialize();
		
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.setBounds(100, 100, 442, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblStudentNumber = new JLabel("Add Student Number:");
		lblStudentNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblStudentNumber.setHorizontalAlignment(SwingConstants.TRAILING);
		lblStudentNumber.setBounds(32, 50, 200, 13);
		frame.getContentPane().add(lblStudentNumber);
		
		stdno = new JTextField();
		stdno.setBounds(120, 80, 200, 19);
		frame.getContentPane().add(stdno);
		stdno.setColumns(10);
		
		JLabel lblpw = new JLabel("Password:");
		lblpw.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblpw.setBounds(80, 120, 130, 13);
		frame.getContentPane().add(lblpw);
		
		pw = new JPasswordField();
		pw.setBounds(120, 150, 200, 19);
		frame.getContentPane().add(pw);
		pw.setColumns(10);
		pw.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e){ 
				try{ 
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				}catch(ClassNotFoundException cn) {
					System.out.println("There was a problem in your code");
					cn.printStackTrace();
				}
				try {
				String query = "INSERT INTO Student_Login(Number, Password, Votestat) VALUES(?,?,?)"; 
				Connection con = DriverManager.getConnection("jdbc:ucanaccess://Database1.accdb"); 
				PreparedStatement pst = con.prepareStatement(query); 
	
				pst.setString(1, stdno.getText().toString()); 
				pst.setString(2, pw.getText().toString());
				pst.setLong(3, 0);
				
				pst.execute();
				JOptionPane.showMessageDialog(null, "Data successfully saved"); 
				frame.dispose();
				} catch(SQLException sql) {
					sql.printStackTrace();
				}
			}
			}); 
		
		JButton btnNewButton = new JButton("Add Voter");
		btnNewButton.setBounds(172, 191, 96, 22);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e){ 
				try{ 
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				}catch(ClassNotFoundException cn) {
					System.out.println("There was a problem in your code");
					cn.printStackTrace();
				}
				try {
				String query = "INSERT INTO Student_Login(Number, Password) VALUES(?,?)"; 
				Connection con = DriverManager.getConnection("jdbc:ucanaccess://Database1.accdb"); 
				PreparedStatement pst = con.prepareStatement(query); 
	
				pst.setString(1, stdno.getText().toString()); 
				pst.setString(2, pw.getText().toString());
				pst.setLong(3, 0);
				
				pst.execute();
				JOptionPane.showMessageDialog(null, "Data successfully saved"); 
				frame.dispose();
				} catch(SQLException sql) {
					sql.printStackTrace();
				}
			}
			}); 
			frame.getContentPane().add(btnNewButton); 
	}
}
