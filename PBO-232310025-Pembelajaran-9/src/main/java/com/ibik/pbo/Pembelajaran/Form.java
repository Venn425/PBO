package com.ibik.pbo.Pembelajaran;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.sql.*;

public class Form {
	public void Nilai() {
		JFrame fme = new JFrame("Form Penilaian Mata Kuliah PBO");
        fme.setSize(800, 400);
        fme.setLocationRelativeTo(null);
        fme.setLayout(null);
        fme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setBounds(0, 0, 800, 30);
        panel.setOpaque(true);
        fme.add(panel);

        JMenuBar bar = new JMenuBar();

        JMenu File = new JMenu("File");
        bar.add(File);

        JMenu Edit = new JMenu("Edit");
        bar.add(Edit);

        JMenu Help = new JMenu("Help");
        bar.add(Help);

        JLabel Judul = new JLabel("FORM PENILAIAN MATAKULIAH PBO");
        Judul.setBounds(220, 0, 400, 30);
        Judul.setFont(new Font("arial", Font.BOLD, 20));
        panel.add(Judul);

        JLabel NPM = new JLabel("NPM");
        NPM.setBounds(30, 40, 80, 15);
        fme.add(NPM);

        JLabel Nama = new JLabel("Nama");
        Nama.setBounds(30, 120, 80, 15);
        fme.add(Nama);

        JLabel Nilai = new JLabel("Nilai");
        Nilai.setBounds(30, 200, 80, 15);
        fme.add(Nilai);

        JTextField TxNPM = new JTextField();
        TxNPM.setBounds(30, 70, 300, 30);
        fme.add(TxNPM);

        JTextField TxNama = new JTextField();
        TxNama.setBounds(30, 150, 300, 30);
        fme.add(TxNama);

        JRadioButton ab = new JRadioButton("A");
        ab.setBounds(50, 230, 40, 15);
        fme.add(ab);

        JRadioButton bb = new JRadioButton("B");
        bb.setBounds(95, 230, 40, 15);
        fme.add(bb);

        JRadioButton cb = new JRadioButton("C");
        cb.setBounds(135, 230, 40, 15);
        fme.add(cb);

        JRadioButton db = new JRadioButton("D");
        db.setBounds(175, 230, 40, 15);
        fme.add(db);

        JRadioButton eb = new JRadioButton("E");
        eb.setBounds(215, 230, 40, 15);
        fme.add(eb);

        JRadioButton fb = new JRadioButton("F");
        fb.setBounds(255, 230, 40, 15);
        fme.add(fb);

        ButtonGroup ButNilai = new ButtonGroup();
        ButNilai.add(ab);
        ButNilai.add(bb);
        ButNilai.add(cb);
        ButNilai.add(db);
        ButNilai.add(eb);
        ButNilai.add(fb);

        JButton Save = new JButton("Save");
        Save.setBounds(30, 260, 90, 30);
        fme.add(Save);

        JButton Delete = new JButton("Delete");
        Delete.setBounds(130, 260, 90, 30);
        fme.add(Delete);

        JButton Clear = new JButton("Clear");
        Clear.setBounds(230, 260, 90, 30);
        fme.add(Clear);

        String[] columnNames = {"NPM", "Nama", "Nilai"};
        DefaultTableModel DataNilai = new DefaultTableModel();
        DataNilai.setColumnIdentifiers(columnNames);

        JTable table = new JTable(DataNilai);
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(350, 40, 400, 200);
        fme.add(sp);
        
        String query = "SELECT npm, nama, nilai FROM student_score";
        try (Connection conn = connect.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            DataNilai.setRowCount(0);

            while (rs.next()) {
                String npm = rs.getString("npm");
                String nama = rs.getString("nama");
                String nilai = rs.getString("nilai");

                DataNilai.addRow(new Object[]{npm, nama, nilai});
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(fme, "Gagal memuat data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        Delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
		        
		        if (selectedRow == -1) {
		            JOptionPane.showMessageDialog(fme, "Pilih baris yang ingin dihapus", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }

		        String npm = table.getValueAt(selectedRow, 0).toString(); 
		        
		        int confirm = JOptionPane.showConfirmDialog(fme, "Apakah Anda yakin ingin menghapus data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
		        if (confirm == JOptionPane.YES_OPTION) {
		            String query = "DELETE FROM student_score WHERE npm = ?";
		            try (Connection conn = connect.getConnection();
		                 PreparedStatement stmt = conn.prepareStatement(query)) {
		                
		                stmt.setString(1, npm); 
		                int rowsAffected = stmt.executeUpdate();

		                if (rowsAffected > 0) {
		                    DataNilai.removeRow(selectedRow);
		                    JOptionPane.showMessageDialog(fme, "Data berhasil dihapus!", "Success", JOptionPane.INFORMATION_MESSAGE);
		                } else {
		                    JOptionPane.showMessageDialog(fme, "Data gagal dihapus!", "Error", JOptionPane.ERROR_MESSAGE);
		                }
		            } catch (SQLException ex) {
		                ex.printStackTrace();
		                JOptionPane.showMessageDialog(fme, "Terjadi kesalahan koneksi ke database: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		            }
		        }
			}
		});

        Save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String npm = TxNPM.getText();
            	String nama = TxNama.getText();
            	String nilai = "";

            	if (ab.isSelected()) nilai = "A";
            	else if (bb.isSelected()) nilai = "B";
            	else if (cb.isSelected()) nilai = "C";
            	else if (db.isSelected()) nilai = "D";
            	else if (eb.isSelected()) nilai = "E";
            	else if (fb.isSelected()) nilai = "F";

            	if (!npm.isEmpty() && !nama.isEmpty() && !nilai.isEmpty()) {
            	    DataNilai.addRow(new Object[]{npm, nama, nilai});
            	    
            	    String query = "INSERT INTO student_score (npm, nama, nilai) VALUES (?, ?, ?)";

            	    try (Connection conn = connect.getConnection();
            	         PreparedStatement stmt = conn.prepareStatement(query)) {

            	        stmt.setString(1, npm); 
            	        stmt.setString(2, nama); 
            	        stmt.setString(3, nilai);

            	        int rowsAffected = stmt.executeUpdate();
            	        if (rowsAffected > 0) {
            	            JOptionPane.showMessageDialog(fme, "Data berhasil disimpan ke database", "Success", JOptionPane.INFORMATION_MESSAGE);
            	        } else {
            	            JOptionPane.showMessageDialog(fme, "Gagal menyimpan data ke database", "Error", JOptionPane.ERROR_MESSAGE);
            	        }
            	    } catch (SQLException ex) {
            	        ex.printStackTrace();
            	        JOptionPane.showMessageDialog(fme, "Terjadi kesalahan: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            	    }
            	} else {
            	    JOptionPane.showMessageDialog(fme, "Semua kolom harus diisi", "Error", JOptionPane.ERROR_MESSAGE);
            	}
            }
        });

        fme.setJMenuBar(bar);
        fme.setVisible(true);
	}
}
