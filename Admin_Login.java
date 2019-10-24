package Final;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Admin_Login{

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	public static void NewWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_Login window = new Admin_Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Admin_Login() {
		initialize();
	}

	private void initialize() {

		frame = new JFrame();
		frame.setTitle("Admin Login");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Admin Username");
		lblUsername.setBounds(90, 67, 150, 14);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(90, 97, 75, 14);
		frame.getContentPane().add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(200, 64, 93, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(200, 94, 93, 20);
		frame.getContentPane().add(passwordField);
		passwordField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String uname = textField.getText();
				String pass = passwordField.getText();
				try {
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
					
				}catch(ClassNotFoundException cn) {
					System.out.println("There was a problem in your code");
					cn.printStackTrace();
				}
				try{
					Connection con = DriverManager.getConnection("jdbc:ucanaccess://Database1.accdb");
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("SELECT Admin_num, pass FROM Admin_Login");
					int i=1;
					while (rs.next()) {
						String x = rs.getString("Admin_num");
						String s = rs.getString("pass");
						if (uname.equals(x)&& pass.equals(s) ) {
							//JOptionPane.showMessageDialog(frame, "Login Success");
							i=0;
							break;
						}
						else i=1;//JOptionPane.showMessageDialog(frame, "Login Failed");
						
							
					}
					if (i==1) {
						JOptionPane.showMessageDialog(frame, "Login Failed");
					}
					else if (i==0) {
						JOptionPane.showMessageDialog(frame, "Login Success");
						frame.dispose();
						Admin_Add.Add();
					}
				} catch(SQLException sql) {
					sql.printStackTrace();
					}

			}
		});
		
		Button button = new Button("Login");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String uname = textField.getText();
				String pass = passwordField.getText();
				try {
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
					
				}catch(ClassNotFoundException cn) {
					System.out.println("There was a problem in your code");
					cn.printStackTrace();
				}
				try{
					Connection con = DriverManager.getConnection("jdbc:ucanaccess://Database1.accdb");
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("SELECT Admin_num, pass FROM Admin_Login");
					int i=1;
					while (rs.next()) {
						String x = rs.getString("Admin_num");
						String s = rs.getString("pass");
						if (uname.equals(x)&& pass.equals(s) ) {
							//JOptionPane.showMessageDialog(frame, "Login Success");
							i=0;
							break;
						}
						else i=1;//JOptionPane.showMessageDialog(frame, "Login Failed");
						
							
					}
					if (i==1) {
						JOptionPane.showMessageDialog(frame, "Login Failed");
					}
					else if (i==0) {
						JOptionPane.showMessageDialog(frame, "Login Success");
						frame.dispose();
						Admin_Add.Add();
					}
				} catch(SQLException sql) {
					sql.printStackTrace();
					}

			}
		});
		button.setBounds(177, 163, 70, 22);
		frame.getContentPane().add(button);
		
		JLabel lblLoginAsStud = new JLabel("Login as Student");
		lblLoginAsStud.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg1) {
				
				frame.dispose();
				Student_Login.main(null);
			}
		});
		lblLoginAsStud.setBounds(10, 236, 150, 14);
		frame.getContentPane().add(lblLoginAsStud);
	}

}
