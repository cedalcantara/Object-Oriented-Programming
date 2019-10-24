package Final;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Add_Candidate {

	private JFrame frame;
	private JTextField stdno;
	private JTextField fname;
	private JTextField lname;
	//private JTextField position;
	private JTable table;


	public static void add() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Candidate window = new Add_Candidate();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Add_Candidate() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.setBounds(100, 100, 442, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblStudentNumber = new JLabel("Student Number:");
		lblStudentNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblStudentNumber.setHorizontalAlignment(SwingConstants.TRAILING);
		lblStudentNumber.setBounds(32, 49, 130, 13);
		frame.getContentPane().add(lblStudentNumber);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFirstName.setBounds(80, 82, 130, 13);
		frame.getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLastName.setBounds(80, 117, 82, 13);
		frame.getContentPane().add(lblLastName);
		
		JLabel lblPosition = new JLabel("Position:");
		lblPosition.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPosition.setBounds(99, 155, 82, 20);
		frame.getContentPane().add(lblPosition);
		
		stdno = new JTextField();
		stdno.setBounds(172, 48, 96, 19);
		frame.getContentPane().add(stdno);
		stdno.setColumns(10);
		
		fname = new JTextField();
		fname.setBounds(172, 81, 96, 19);
		frame.getContentPane().add(fname);
		fname.setColumns(10);
		
		lname = new JTextField();
		lname.setBounds(172, 116, 96, 19);
		frame.getContentPane().add(lname);
		lname.setColumns(10);
		
		
		/*position = new JTextField();
		position.setBounds(172, 158, 96, 19);
		frame.getContentPane().add(position);
		position.setColumns(10);
		*/
		
		JComboBox cb = new JComboBox();
		cb.setBounds(172, 158, 96, 19);
		frame.getContentPane().add(cb);
		cb.addItem("President");
		cb.addItem("Vice President");
		cb.addItem("Auditor");
		cb.addItem("Secretary");
		cb.addItem("Treasurer");
		

		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.setBounds(172, 191, 96, 22);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e){ 
				String zero ="0";
				try{ 
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				}catch(ClassNotFoundException cn) {
					System.out.println("There was a problem in your code");
					cn.printStackTrace();
				}
				try {
				String query = "INSERT INTO Candidates(studnum, fname, lname, pos, Votect) VALUES(?,?,?,?,?)"; 
				Connection con = DriverManager.getConnection("jdbc:ucanaccess://Database1.accdb"); 
				PreparedStatement pst = con.prepareStatement(query); 
				String pos = (String) cb.getSelectedItem();
				pst.setString(1, stdno.getText().toString()); 
				pst.setString(2, fname.getText().toString()); 
				pst.setString(3, lname.getText().toString()); 
				
				if(pos.equals("President")) {
					pst.setString(4, "PRES");}
				else if(pos.equals("Vice President")) {
					pst.setString(4, "VP");}
				else if(pos.equals("Auditor")) {
					pst.setString(4, "AUD");}
				else if(pos.equals("Secretary")) {
					pst.setString(4, "SEC");}
				else if(pos.equals("Treasurer")) {
					pst.setString(4, "TREA");}
pst.setString(5, zero);
				pst.execute(); 

				/*stdno.setText(null); 
				fname.setText(null); 
				lname.setText(null); 
				position.setText(null);
				*/
				JOptionPane.showMessageDialog(null, "Data successfully saved"); 
				frame.dispose();
				} catch(SQLException sql) {
					sql.printStackTrace();
				}
			}
			}); 
			frame.getContentPane().add(btnNewButton); 
			
			JButton btnShow = new JButton("Show data"); 
			btnShow.setBounds(172, 219, 96, 22);
			frame.getContentPane().add(btnShow);
			btnShow.addActionListener(new ActionListener() { 
			
			public void actionPerformed(ActionEvent e) { 
				try{ 
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				}catch(ClassNotFoundException cn) {
					System.out.println("There was a problem in your code");
					cn.printStackTrace();
				}
			try {
			String query = "SELECT * FROM Candidates WHERE studnum = " + "'" + JOptionPane.showInputDialog("Input Name to find") + "'";
			Connection con =DriverManager.getConnection("jdbc:ucanaccess://Database1.accdb"); 
			PreparedStatement pst =con.prepareStatement(query); 
			ResultSet rs = pst.executeQuery(); 
			String pos = (String) cb.getSelectedItem();
			
			fname.setText(rs.getString(2)); 
			lname.setText(rs.getString(3)); 
			//cb.set(rs.getString(4));
			
		
			}catch(SQLException sql) {
				sql.printStackTrace();
			}
			}
			}); 
			frame.getContentPane().add(btnShow); 
			
			frame.setVisible(true); 
			frame.setTitle("Add Candidate");
			frame.setSize(390, 355); 
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}	
 	}

