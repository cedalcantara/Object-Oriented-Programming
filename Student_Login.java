package Final;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Student_Login extends JFrame {

	public JFrame frmStudentLogin;
	private JTextField textField;
	private JPasswordField passwordField;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student_Login window = new Student_Login();
					window.frmStudentLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Student_Login() {
		super("Student Login");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStudentLogin = new JFrame();
		frmStudentLogin.setTitle("Student Login");
		frmStudentLogin.setBounds(100, 100, 450, 300);
		frmStudentLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStudentLogin.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(90, 67, 75, 14);
		frmStudentLogin.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(90, 97, 75, 14);
		frmStudentLogin.getContentPane().add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(186, 64, 93, 20);
		frmStudentLogin.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(186, 94, 93, 20);
		frmStudentLogin.getContentPane().add(passwordField);
		passwordField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String uname = textField.getText();
				String pass = passwordField.getText();
				String zero= "0";
				String one= "1";
				PreparedStatement upd = null;
				try {
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
					
				}catch(ClassNotFoundException cn) {
					System.out.println("There was a problem in your code");
					cn.printStackTrace();
				}
				try{
					Connection con = DriverManager.getConnection("jdbc:ucanaccess://Database1.accdb");
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("SELECT Number, Password, Votestat FROM Student_Login");
					upd= con.prepareStatement("UPDATE Student_Login "+"SET Votestat=? " + "WHERE Password ='"+pass+"'");
					int i=1;
					int q=1;
					
					while (rs.next()) {
						String x = rs.getString("Number");
						String s = rs.getString("Password");
						String y = rs.getString("Votestat");
						int vstat = Integer.parseInt(y);
						
						if (uname.equals(x)&& pass.equals(s)&&zero.equals(y) )
						{
							i=0;
							q=0;
							break;
						}
						
						else if (uname.equals(x)&& pass.equals(s)&&vstat==1)
						{
							i=0;
							q=1;
							break;
						}
						else
							i=1;
					}
					
					if(i==0&&q==1)
					{
						JOptionPane.showMessageDialog(frmStudentLogin, "Student Already Voted!");
					}
					else if (i==1) {
						JOptionPane.showMessageDialog(frmStudentLogin, "Login Failed");
					}
					else if (i==0&&q==0) {
						JOptionPane.showMessageDialog(frmStudentLogin, "Login Success");
						frmStudentLogin.dispose();
						Voting.Window1();
					}
					upd.setString(1, one);
					upd.executeUpdate();
					
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
				String zero= "0";
				String one= "1";
				PreparedStatement upd = null;
				try {
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
					
				}catch(ClassNotFoundException cn) {
					System.out.println("There was a problem in your code");
					cn.printStackTrace();
				}
				try{
					Connection con = DriverManager.getConnection("jdbc:ucanaccess://Database1.accdb");
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("SELECT Number, Password, Votestat FROM Student_Login");
					upd= con.prepareStatement("UPDATE Student_Login "+"SET Votestat=? " + "WHERE Password ='"+pass+"'");
					int i=1;
					int q=1;
					
					while (rs.next()) {
						String x = rs.getString("Number");
						String s = rs.getString("Password");
						String y = rs.getString("Votestat");
						int vstat = Integer.parseInt(y);
						
						if (uname.equals(x)&& pass.equals(s)&&zero.equals(y) )
						{
							i=0;
							q=0;
							break;
						}
						
						else if (uname.equals(x)&& pass.equals(s)&&vstat==1)
						{
							i=0;
							q=1;
							break;
						}
						else
							i=1;
					}
					
					if(i==0&&q==1)
					{
						JOptionPane.showMessageDialog(frmStudentLogin, "Student Already Voted!");
					}
					else if (i==1) {
						JOptionPane.showMessageDialog(frmStudentLogin, "Login Failed");
					}
					else if (i==0&&q==0) {
						JOptionPane.showMessageDialog(frmStudentLogin, "Login Success");
						frmStudentLogin.dispose();
						Voting.Window1();
					}
					upd.setString(1, one);
					
					upd.executeUpdate();
					
				} catch(SQLException sql) {
					sql.printStackTrace();
					}

			}
		});
		button.setBounds(177, 163, 70, 22);
		frmStudentLogin.getContentPane().add(button);
		
		JLabel lblLoginAsAdmin = new JLabel("Login as admin");
		lblLoginAsAdmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg1) {
				
				frmStudentLogin.dispose();
				Admin_Login.NewWindow();
			}
		});
		lblLoginAsAdmin.setBounds(10, 236, 93, 14);
		frmStudentLogin.getContentPane().add(lblLoginAsAdmin);
	}
}
