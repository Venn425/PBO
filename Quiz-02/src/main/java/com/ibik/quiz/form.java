package com.ibik.quiz;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class form {
	public static void form() {
		JFrame fme = new JFrame();
		fme.setSize(300, 400);
		fme.setLocationRelativeTo(null);
		fme.setLayout(null);
		fme.setDefaultCloseOperation(fme.DISPOSE_ON_CLOSE);
		
		JLabel Judul = new JLabel("FORM IBIK");
		Judul.setFont(new Font("Times new roman", Font.BOLD, 15));
		Judul.setBounds(100, 20, 150, 25);
		fme.add(Judul);
		
		JLabel NPM = new JLabel("NPM");
		NPM.setBounds(25, 65, 80, 15);
		fme.add(NPM);
		
		JLabel First = new JLabel("First Name");
		First.setBounds(25, 105, 80, 15);
		fme.add(First);
		
		JLabel Mid = new JLabel("Middle Name");
		Mid.setBounds(25, 145, 80, 15);
		fme.add(Mid);
		
		JLabel Last = new JLabel("Last Name");
		Last.setBounds(25, 185, 80, 15);
		fme.add(Last);
		
		JLabel Kelas = new JLabel("Kelas");
		Kelas.setBounds(25, 225, 80, 15);
		fme.add(Kelas);
		
		JTextField TxNPM = new JTextField();
		TxNPM.setBounds(130, 65, 130, 20);
		fme.add(TxNPM);

		JTextField TxFirst = new JTextField();
		TxFirst.setBounds(130, 105, 130, 20);
		fme.add(TxFirst);
		
		JTextField TxMid = new JTextField();
		TxMid.setBounds(130, 145, 130, 20);
		fme.add(TxMid);
		
		JTextField TxLast = new JTextField();
		TxLast.setBounds(130, 185, 130, 20);
		fme.add(TxLast);
		
		JTextField TxKelas = new JTextField();
		TxKelas.setBounds(130, 225, 130, 20);
		fme.add(TxKelas);
		
		JButton Submit = new JButton("Submit");
		Submit.setBounds(100, 275, 80, 40);
		fme.add(Submit);
		
		Submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int npm = Integer.parseInt(TxNPM.getText());
				String first = TxFirst.getText();
				String mid = TxMid.getText();
				String last = TxLast.getText();
				String kelas = TxKelas.getText();
				
				String query = "INSERT INTO form (npm, first_name, middle_name, last_name, kelas) VALUES (?, ?, ?, ?, ?)";

		        try (Connection conn = connect.getConnection();
		             PreparedStatement stmt = conn.prepareStatement(query)) {

		            stmt.setInt(1, npm);
		            stmt.setString(2, first);
		            stmt.setString(3, mid);
		            stmt.setString(4, last);
		            stmt.setString(5, kelas);

		            int rowsAffected = stmt.executeUpdate();
		            if (rowsAffected > 0) {
		                JOptionPane.showMessageDialog(null, "Data berhasil dimasukkan!");
		                fme.dispose();
		            } else {
		                JOptionPane.showMessageDialog(null, "Gagal memasukkan data!");
		            }

		        } catch (SQLException ex) {
		            ex.printStackTrace();
		        }			
			}
		});
		
		
		fme.setVisible(true);
	}
	
	public static void show() {
		JFrame fme = new JFrame();
		fme.setSize(500, 400);
		fme.setLocationRelativeTo(null);
		fme.setLayout(null);
		fme.setDefaultCloseOperation(fme.DISPOSE_ON_CLOSE);
		
		JLabel Judul = new JLabel("DATA MAHASISWA");
		Judul.setFont(new Font("Times new roman", Font.BOLD, 15));
		Judul.setBounds(170, 10, 150, 25);
		fme.add(Judul);
		
		String[] columnNames = {"NPM", "NAMA", "KELAS"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(30, 40, 430, 300);
        fme.add(scrollPane);
        
        try (Connection conn = connect.getConnection()) {
            String sql = "SELECT * FROM form;"; 

            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    tableModel.setRowCount(0); 
                    boolean found = false;

                    while (resultSet.next()) {
                        found = true;
                        int npm = resultSet.getInt("npm");
                        String nama = resultSet.getString("first_name");
                        
                        if (resultSet.getString("middle_name") != null) {
                            nama += " " + resultSet.getString("middle_name");
                        }
                        nama += " " + resultSet.getString("last_name");

                        String kelas = resultSet.getString("kelas");

                        tableModel.addRow(new Object[]{npm, nama, kelas});
                    }

                    if (!found) {
                        tableModel.addRow(new Object[]{"Tidak ada hasil ditemukan", "", ""});
                    }
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(fme, "Terjadi kesalahan: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        
        fme.setVisible(true);
	}
}
