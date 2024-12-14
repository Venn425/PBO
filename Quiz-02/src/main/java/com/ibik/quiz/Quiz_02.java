package com.ibik.quiz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Quiz_02 {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/form_quiz";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";
	public static void main(String[] args) {
		JFrame fme = new JFrame("JDBC Project");
		fme.setSize(210, 335);
		fme.setLocationRelativeTo(null);
		fme.setLayout(null);
		fme.setDefaultCloseOperation(fme.EXIT_ON_CLOSE);
		
		JButton conn = new JButton("Connect DB");
		conn.setBounds(0, 0, 200, 100);
		fme.add(conn);
		
		JButton add = new JButton("Add Data");
		add.setBounds(0, 100, 200, 100);
		fme.add(add);
		
		JButton show = new JButton("Show Database");
		show.setBounds(0, 200, 200, 100);
		fme.add(show);
		
		conn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
		            if (connection != null) {
		            	JOptionPane.showMessageDialog(null, "Koneksi ke database berhasil!");
		            }
		        } catch (SQLException ex) {
		        	JOptionPane.showMessageDialog(null, "Koneksi ke database gagal: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		        }			
			}
		});
		
		add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				form mhs = new form();
				mhs.form();
			}
		});
		
		show.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				form mhs = new form();
				mhs.show();
			}
		});
		
		fme.setVisible(true);
	}	
}
