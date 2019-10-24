package Final;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Delete_Candidate extends JFrame {
	private JFrame frame;
	private JTextField stdno;
	private JTextField fname;
	private JTextField lname;
	private JTable table;
	public static void add() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete_Candidate window = new Delete_Candidate();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Delete_Candidate() {
		super("Delete Candidate");
		initialize();
	}
	private void initialize(){
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.setBounds(100, 100, 442, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblStudentNumber = new JLabel("Enter Student Number of Candidate to Delete:");
		lblStudentNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblStudentNumber.setHorizontalAlignment(SwingConstants.TRAILING);
		lblStudentNumber.setBounds(22, 49, 350, 13);
		frame.getContentPane().add(lblStudentNumber);
		
		JFrame frame2 = new JFrame();
		frame2.setTitle("Delete Candidate");
		frame2.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame2.setBounds(100, 100, 442, 300);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.getContentPane().setLayout(null);
		
		stdno = new JTextField();
		stdno.setBounds(172, 80, 100, 19);
		frame.getContentPane().add(stdno);
		stdno.setColumns(10);
	
		stdno.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e){ 
				String stdnum = stdno.getText();
				
				try {
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
					
				}catch(ClassNotFoundException cn) {
					System.out.println("There was a problem in your code");
					cn.printStackTrace();
				}
				try{
					Connection con = DriverManager.getConnection("jdbc:ucanaccess://Database1.accdb");
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("SELECT studnum, lname, fname, pos, Votect FROM Candidates");
					int i=1;
					
					while (rs.next()) {
						String x = rs.getString("studnum");
						if (stdnum.equals(x) )
						{
							i=0;
							String v =rs.getString("pos");
							String w = rs.getString("Votect");
							String y = rs.getString("fname");
							String z = rs.getString("lname");
							JLabel lblStudentNumber = new JLabel("Name: "+z+", "+y);
							lblStudentNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
							lblStudentNumber.setHorizontalAlignment(SwingConstants.TRAILING);
							lblStudentNumber.setBounds(50, 49, 200, 20);
							frame2.getContentPane().add(lblStudentNumber);
							
							JLabel lblFirstName = new JLabel("Position: " +v);
							lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 16));
							lblFirstName.setBounds(80, 82, 200, 13);
							frame2.getContentPane().add(lblFirstName);
							
							JLabel lblLastName = new JLabel("Current Vote Count: "+ w);
							lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
							lblLastName.setBounds(80, 117, 200, 13);
							frame2.getContentPane().add(lblLastName);
							
							break;
						}
						
						else
							i=1;
					}
					
				 if (i==1) {
						JOptionPane.showMessageDialog(frame, "Student Not Found!");
					}
					else if (i==0) {
						JOptionPane.showMessageDialog(frame, "Student Found!");
						frame.dispose();
							
						JLabel lblPosition = new JLabel("Are You Sure You Want to Delete?");
						lblPosition.setFont(new Font("Tahoma", Font.PLAIN, 16));
						lblPosition.setBounds(50, 155, 300, 20);
						frame2.getContentPane().add(lblPosition);
						
						JButton btnNewButton = new JButton("Yes");
						btnNewButton.setBounds(100, 191, 96, 22);
						frame2.getContentPane().add(btnNewButton);
						btnNewButton.addActionListener(new ActionListener() { 
							public void actionPerformed(ActionEvent e){ 
								try{ 
								Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
								}catch(ClassNotFoundException cn) {
									System.out.println("There was a problem in your code");
									cn.printStackTrace();
								}
								try {
								Connection con = DriverManager.getConnection("jdbc:ucanaccess://Database1.accdb");
								PreparedStatement upd = con.prepareStatement("DELETE FROM Candidates "+"WHERE studnum ='"+stdnum+"'");				
							
								upd.execute(); 

								JOptionPane.showMessageDialog(null, "Student Successfully Removed from the Records"); 
								frame2.dispose();
								} catch(SQLException sql) {
									sql.printStackTrace();
								}
							}
							}); 
						
						
							frame2.getContentPane().add(btnNewButton); 
							
							JButton btnNewButton2 = new JButton("No");
							btnNewButton2.setBounds(200, 191, 96, 22);
							frame2.getContentPane().add(btnNewButton2);
							btnNewButton2.addActionListener(new ActionListener() { 
								public void actionPerformed(ActionEvent e){
									JOptionPane.showMessageDialog(null, "Thank You!"); 
									frame2.dispose();
								}
								});
							frame2.setVisible(true);
					}
				} catch(SQLException sql) {
					sql.printStackTrace();
					}

			}
		});
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setBounds(172, 110, 96, 22);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e){ 
				String stdnum = stdno.getText();
				
				try {
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
					
				}catch(ClassNotFoundException cn) {
					System.out.println("There was a problem in your code");
					cn.printStackTrace();
				}
				try{
					Connection con = DriverManager.getConnection("jdbc:ucanaccess://Database1.accdb");
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("SELECT studnum, lname, fname FROM Candidates");
					int i=1;
					
					while (rs.next()) {
						String x = rs.getString("studnum");
						if (stdnum.equals(x) )
						{
							i=0;
							String y = rs.getString("fname");
							String z = rs.getString("lname");
							JLabel lblStudentNumber = new JLabel("Name: "+z+", "+y);
							lblStudentNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
							lblStudentNumber.setHorizontalAlignment(SwingConstants.TRAILING);
							lblStudentNumber.setBounds(95, 49, 200, 20);
							frame2.getContentPane().add(lblStudentNumber);
							break;
						}
						
						else
							i=1;
					}
					
				 if (i==1) {
						JOptionPane.showMessageDialog(frame, "Student Not Found!");
					}
					else if (i==0) {
						JOptionPane.showMessageDialog(frame, "Student Found!");
						frame.dispose();
						
					
						
						JLabel lblFirstName = new JLabel("First Name:");
						lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 16));
						lblFirstName.setBounds(80, 82, 130, 13);
						frame2.getContentPane().add(lblFirstName);
						
						JLabel lblLastName = new JLabel("Last Name:");
						lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
						lblLastName.setBounds(80, 117, 82, 13);
						frame2.getContentPane().add(lblLastName);
						
						JLabel lblPosition = new JLabel("Position:");
						lblPosition.setFont(new Font("Tahoma", Font.PLAIN, 16));
						lblPosition.setBounds(99, 155, 82, 20);
						frame2.getContentPane().add(lblPosition);
						
						/*JTextField stdno2 = new JTextField();
						stdno2.setBounds(172, 48, 96, 19);
						frame2.getContentPane().add(stdno2);
						stdno2.setColumns(10);
						*/
						JTextField fname2 = new JTextField();
						fname2.setBounds(172, 81, 96, 19);
						frame2.getContentPane().add(fname2);
						fname2.setColumns(10);
						
						JTextField lname2 = new JTextField();
						lname2.setBounds(172, 116, 96, 19);
						frame2.getContentPane().add(lname2);
						lname2.setColumns(10);
						
						JComboBox cb = new JComboBox();
						cb.setBounds(172, 158, 96, 19);
						frame2.getContentPane().add(cb);
						cb.addItem("President");
						cb.addItem("Vice President");
						cb.addItem("Auditor");
						cb.addItem("Secretary");
						cb.addItem("Treasurer");
						
						JButton btnNewButton = new JButton("Enter");
						btnNewButton.setBounds(172, 191, 96, 22);
						frame2.getContentPane().add(btnNewButton);
						btnNewButton.addActionListener(new ActionListener() { 
							public void actionPerformed(ActionEvent e){ 
								try{ 
								Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
								}catch(ClassNotFoundException cn) {
									System.out.println("There was a problem in your code");
									cn.printStackTrace();
								}
								try {
								Connection con = DriverManager.getConnection("jdbc:ucanaccess://Database1.accdb");
								PreparedStatement upd = con.prepareStatement("UPDATE Candidates "+"SET fname=?, " +"lname=?, "+"pos=? "+ "WHERE studnum ='"+stdnum+"'"); 
								String pos = (String) cb.getSelectedItem();
								String first =fname2.getText();
								String second =lname2.getText();
								//upd.setString(1, stdno.getText().toString()); 
								upd.setString(1, first); 
								upd.setString(2, second); 
								
								if(pos.equals("President")) {
									upd.setString(3, "PRES");}
								else if(pos.equals("Vice President")) {
									upd.setString(3, "VP");}
								else if(pos.equals("Auditor")) {
									upd.setString(3, "AUD");}
								else if(pos.equals("Secretary")) {
									upd.setString(3, "SEC");}
								else if(pos.equals("Treasurer")) {
									upd.setString(3, "TREA");}

								upd.executeUpdate(); 

								JOptionPane.showMessageDialog(null, "Data successfully saved"); 
								frame2.dispose();
								} catch(SQLException sql) {
									sql.printStackTrace();
								}
							}
							}); 
							frame2.getContentPane().add(btnNewButton); 
							frame2.setVisible(true);
					}
				} catch(SQLException sql) {
					sql.printStackTrace();
					}

			}
		});
			
			frame.getContentPane().add(btnNewButton); 
	}
}
