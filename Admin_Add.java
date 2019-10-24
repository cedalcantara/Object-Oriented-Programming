package Final;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.event.*;

public class Admin_Add {

	private JFrame frmAdd;
	
	public static void Add() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_Add window = new Admin_Add();
					window.frmAdd.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Admin_Add() {
		initialize();
	}
	private void initialize() {
		frmAdd = new JFrame();
		frmAdd.setTitle("Administration");
		frmAdd.setBounds(100, 100, 450, 300);
		frmAdd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdd.getContentPane().setLayout(null);
		
		JButton btnAddVoter = new JButton("Add Voter");
		btnAddVoter.setBounds(150, 95, 164, 23);
		frmAdd.getContentPane().add(btnAddVoter);
		btnAddVoter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Add_Voter.add();
				frmAdd.dispose();
			}
		});

		JButton btnAddCandidate = new JButton("Add Candidate");
		btnAddCandidate.setBounds(150, 55, 164, 23);
		frmAdd.getContentPane().add(btnAddCandidate);
        btnAddCandidate.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				Add_Candidate.add();
				frmAdd.dispose();
			}
		});
        
        JButton btnDltCandidate = new JButton("Delete Candidate");
		btnDltCandidate.setBounds(150, 135, 164, 23);
		frmAdd.getContentPane().add(btnDltCandidate);
        btnDltCandidate.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Delete_Candidate.add();
				frmAdd.dispose();
			}
		});
        JButton btnUpdtCandidate = new JButton("Update Candidate");
		btnUpdtCandidate.setBounds(150, 175, 164, 23);
		frmAdd.getContentPane().add(btnUpdtCandidate);
		btnUpdtCandidate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Update_Candidate.add();
				frmAdd.dispose();
			}
		});
	
	}

}
