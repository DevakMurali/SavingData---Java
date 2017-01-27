package com.Murali.SavingData;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class SavingData {

	private JFrame frame;
	private JTextField txtTotal;
	private JTextField txtUser;
	
	JLabel lblTotal = new JLabel("");
	JLabel lblUser = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SavingData window = new SavingData();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SavingData() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Saved Data Test");
		frame.setBounds(100, 100, 400, 220);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User");
		lblNewLabel.setBounds(10, 21, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Total");
		lblNewLabel_1.setBounds(10, 81, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtTotal = new JTextField();
		txtTotal.setBounds(66, 78, 86, 20);
		frame.getContentPane().add(txtTotal);
		txtTotal.setColumns(10);
		
		txtUser = new JTextField();
		txtUser.setBounds(66, 18, 86, 20);
		frame.getContentPane().add(txtUser);
		txtUser.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//get the into from the text boxes and save that data in a file
				String user= txtUser.getText();
				String total = txtTotal.getText();
				
				DataStorage ds = new DataStorage();
				ds.saveData(user, total);
			}
		});
		btnSave.setBounds(63, 131, 89, 23);
		frame.getContentPane().add(btnSave);
		
		JButton btnLoad = new JButton("Load Data from File");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DataStorage ds = new DataStorage();
				ArrayList<String> ducks = ds.loadData();
				
				lblUser.setText(ducks.get(0));
				lblTotal.setText(ducks.get(1));
			}
		});
		btnLoad.setBounds(225, 17, 144, 23);
		frame.getContentPane().add(btnLoad);
		
		JLabel lblNewLabel_2 = new JLabel("Saved User:");
		lblNewLabel_2.setBounds(208, 58, 92, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Saved Total:");
		lblNewLabel_3.setBounds(208, 94, 92, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		
		lblUser.setBounds(310, 58, 46, 14);
		frame.getContentPane().add(lblUser);
		
		
		lblTotal.setBounds(310, 94, 46, 14);
		frame.getContentPane().add(lblTotal);
	}
}
