package Final;

import java.awt.*;
import java.sql.*;

import javax.swing.*;
import java.awt.event.*;

public class Voting {
	private JFrame frmVoting;
	public static void Window1() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Voting window = new Voting();
					window.frmVoting.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Voting() {
		initialize();
	}

	private void initialize() {
		//PreparedStatement zero = null;
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			
		}catch(ClassNotFoundException cn) {
			System.out.println("There was a problem in your code");
			cn.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection("jdbc:ucanaccess://Database1.accdb");
			Statement stmt = con.createStatement();
		
			ResultSet rsPres = stmt.executeQuery("SELECT lname, fname FROM Candidates WHERE pos LIKE 'PRES'");
			ResultSet rsVp = stmt.executeQuery("SELECT lname, fname FROM Candidates WHERE pos LIKE 'VP'");
			ResultSet rsSec = stmt.executeQuery("SELECT lname, fname FROM Candidates WHERE pos LIKE 'SEC'");
			ResultSet rsAud = stmt.executeQuery("SELECT lname, fname FROM Candidates WHERE pos LIKE 'AUD'");
			ResultSet rsTrea = stmt.executeQuery("SELECT lname, fname FROM Candidates WHERE pos LIKE 'TREA'");
		frmVoting = new JFrame();
		frmVoting.setTitle("Voting");
		frmVoting.setBounds(100, 100, 450, 300);
		frmVoting.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmVoting.getContentPane().setLayout(null);
		
		//zero.setString(1, one);
		//zero.executeUpdate();
		
		JLabel lblPresident = new JLabel("President");
		lblPresident.setBounds(117, 52, 87, 14);
		frmVoting.getContentPane().add(lblPresident);
		
		JLabel lblVicePresident = new JLabel("Vice President");
		lblVicePresident.setBounds(103, 83, 101, 14);
		frmVoting.getContentPane().add(lblVicePresident);
		
		JComboBox cbPres = new JComboBox();
		cbPres.setBounds(206, 49, 136, 20);
		frmVoting.getContentPane().add(cbPres);
		while(rsPres.next()) {
			cbPres.addItem(rsPres.getString("lname")+", "+rsPres.getString("fname"));
	
		}
		
		JComboBox cbVice = new JComboBox();
		cbVice.setBounds(206, 80, 136, 20);
		frmVoting.getContentPane().add(cbVice);
		while(rsVp.next()) {
			cbVice.addItem(rsVp.getString("lname")+", "+rsVp.getString("fname"));
		}
		
		JLabel lblSecretary = new JLabel("Secretary");
		lblSecretary.setBounds(117, 115, 87, 14);
		frmVoting.getContentPane().add(lblSecretary);
		
		JComboBox cbSec = new JComboBox();
		cbSec.setBounds(206, 112, 136, 20);
		frmVoting.getContentPane().add(cbSec);
		while(rsSec.next()) {
			cbSec.addItem(rsSec.getString("lname")+", "+rsSec.getString("fname"));
		}
		
		JLabel lblAuditor = new JLabel("Auditor");
		lblAuditor.setBounds(117, 150, 46, 14);
		frmVoting.getContentPane().add(lblAuditor);
		
		JComboBox cbAud = new JComboBox();
		cbAud.setBounds(206, 147, 136, 20);
		frmVoting.getContentPane().add(cbAud);
		while(rsAud.next()) {
			cbAud.addItem(rsAud.getString("lname")+", "+rsAud.getString("fname"));
		}
		
		JLabel lblTreasurer = new JLabel("Treasurer");
		lblTreasurer.setBounds(117, 182, 87, 14);
		frmVoting.getContentPane().add(lblTreasurer);
		
		JComboBox cbTre = new JComboBox();
		cbTre.setBounds(206, 179, 136, 20);
		frmVoting.getContentPane().add(cbTre);
		while(rsTrea.next()) {
			cbTre.addItem(rsTrea.getString("lname")+", "+rsTrea.getString("fname"));
		}
		
		JButton btnVote = new JButton("Vote");
		btnVote.setBounds(181, 227, 89, 23);
		frmVoting.getContentPane().add(btnVote);
		btnVote.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e){ 
				
				try {
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
					
				}catch(ClassNotFoundException cn) {
					System.out.println("There was a problem in your code");
					cn.printStackTrace();
				}
				try{
					Connection con = DriverManager.getConnection("jdbc:ucanaccess://Database1.accdb");
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("SELECT fname, lname, pos, Votect FROM Candidates");
					String pres = (String) cbPres.getSelectedItem();
					String vp = (String) cbVice.getSelectedItem();
					String sec = (String) cbSec.getSelectedItem();
					String aud = (String) cbAud.getSelectedItem();
					String tre = (String) cbTre.getSelectedItem();
					
					while(rs.next()) {
						String rd = rs.getString("lname");
						
						if(pres.contains(rd)) {
						PreparedStatement upd = con.prepareStatement("UPDATE Candidates "+"SET Votect=? "+ "WHERE lname ='"+rd+"'");
						String prct = rs.getString("Votect");
						int presc = Integer.parseInt(prct);
						presc=presc+1;
						String stpc = String.valueOf(presc);
						upd.setString(1, stpc); 
						upd.executeUpdate();
						}
						
						if(sec.contains(rd)) {
							PreparedStatement upd = con.prepareStatement("UPDATE Candidates "+"SET Votect=? "+ "WHERE lname ='"+rd+"'");
							String secct = rs.getString("Votect");
							int secc = Integer.parseInt(secct);
							secc=secc+1;
							String stsc = String.valueOf(secc);
							upd.setString(1, stsc); 
							upd.executeUpdate();
							}
						
						if(vp.contains(rd)) {
							PreparedStatement upd = con.prepareStatement("UPDATE Candidates "+"SET Votect=? "+ "WHERE lname ='"+rd+"'");
							String vpct = rs.getString("Votect");
							int vpc = Integer.parseInt(vpct);
							vpc=vpc+1;
							String stvc = String.valueOf(vpc);
							upd.setString(1, stvc); 
							upd.executeUpdate();
							}
						
						if(aud.contains(rd)) {
							PreparedStatement upd = con.prepareStatement("UPDATE Candidates "+"SET Votect=? "+ "WHERE lname ='"+rd+"'");
							String audct = rs.getString("Votect");
							int audc = Integer.parseInt(audct);
							audc=audc+1;
							String staud = String.valueOf(audc);
							upd.setString(1, staud); 
							upd.executeUpdate();
							}
						if(tre.contains(rd)) {
							PreparedStatement upd = con.prepareStatement("UPDATE Candidates "+"SET Votect=? "+ "WHERE lname ='"+rd+"'");
							String trect = rs.getString("Votect");
							int trec = Integer.parseInt(trect);
							trec=trec+1;
							String sttrec = String.valueOf(trec);
							upd.setString(1, sttrec); 
							upd.executeUpdate();
							}
						}
					JOptionPane.showMessageDialog(null, "You've Successfuly Voted!"); 
					frmVoting.dispose();
				} catch(SQLException sql) {
					sql.printStackTrace();
					}

			}
		});
		
	}catch(SQLException sql) {
		sql.printStackTrace();
        }

}
}
