package com.ibik.pbo.Pembelajaran;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;

public class Masuk {
	public void Login() {
		JFrame fme = new JFrame("Login");
        fme.setSize(300, 300);
        fme.setLocationRelativeTo(null);
        fme.setLayout(null);
        fme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(30, 30, 60, 15);
        fme.add(lblEmail);

        JTextField txtEmail = new JTextField();
        txtEmail.setBounds(100, 30, 150, 20);
        fme.add(txtEmail);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(30, 70, 60, 15);
        fme.add(lblPassword);

        JPasswordField txtPassword = new JPasswordField();
        txtPassword.setBounds(100, 70, 150, 20);
        fme.add(txtPassword);

        JCheckBox chkRemember = new JCheckBox("Remember Me");
        chkRemember.setBounds(30, 110, 150, 20);
        fme.add(chkRemember);

        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(50, 150, 80, 25);
        fme.add(btnLogin);

        JButton btnRegister = new JButton("Register");
        btnRegister.setBounds(140, 150, 100, 25);
        fme.add(btnRegister);

        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Register();
                fme.dispose();
            }
        });

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	 String email = txtEmail.getText().trim();
                 String password = new String(txtPassword.getPassword()).trim();

                 if (email.isEmpty() || password.isEmpty()) {
                     JOptionPane.showMessageDialog(fme, "Email dan Password tidak boleh kosong!", "Error", JOptionPane.ERROR_MESSAGE);
                     return;
                 }

                 String query = "SELECT * FROM mhstudent WHERE email = ? AND npm = ?";

                 try (Connection conn = connect.getConnection();
                      PreparedStatement stmt = conn.prepareStatement(query)) {

                     stmt.setString(1, email);
                     stmt.setString(2, password);

                     ResultSet rs = stmt.executeQuery();

                     if (rs.next()) {
                         JOptionPane.showMessageDialog(fme, "Login Berhasil!", "Success", JOptionPane.INFORMATION_MESSAGE);
                         fme.dispose(); 

                         Form data = new Form();
                         data.Nilai();
                     } else {
                         JOptionPane.showMessageDialog(fme, "Email/Password Salah", "Error", JOptionPane.ERROR_MESSAGE);
                     }

                 } catch (SQLException ex) {
                     ex.printStackTrace();
                     JOptionPane.showMessageDialog(fme, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                 }
            }
        });

        fme.setVisible(true);
            }
	
	public void Register() {
		JFrame fme = new JFrame("Register");
        fme.setSize(400, 450);
        fme.setLocationRelativeTo(null);
        fme.setLayout(null);
        fme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel Fullname = new JLabel("Fullname");
        Fullname.setBounds(40, 40, 60, 15);
        fme.add(Fullname);

        JTextField TxFullname = new JTextField();
        TxFullname.setBounds(170, 40, 150, 20);
        fme.add(TxFullname);

        JLabel Email = new JLabel("Email");
        Email.setBounds(40, 90, 60, 15);
        fme.add(Email);

        JTextField TxEmail = new JTextField();
        TxEmail.setBounds(170, 90, 150, 20);
        fme.add(TxEmail);

        JLabel NPM = new JLabel("NPM");
        NPM.setBounds(40, 140, 60, 15);
        fme.add(NPM);

        JTextField TxNPM = new JTextField();
        TxNPM.setBounds(170, 140, 150, 20);
        fme.add(TxNPM);

        JLabel Gender = new JLabel("Gender");
        Gender.setBounds(40, 190, 60, 15);
        fme.add(Gender);

        JRadioButton Female = new JRadioButton("Female");
        Female.setBounds(170, 190, 80, 15);
        fme.add(Female);

        JRadioButton Male = new JRadioButton("Male");
        Male.setBounds(260, 190, 80, 15);
        fme.add(Male);

        ButtonGroup gender = new ButtonGroup();
        gender.add(Female);
        gender.add(Male);

        JLabel Citi = new JLabel("Citizenship");
        Citi.setBounds(40, 240, 80, 15);
        fme.add(Citi);

        String country[] = {"Indonesia", "India", "Australia", "U.S.A", "England"};
        JComboBox<String> Citizen = new JComboBox<>(country);
        Citizen.setBounds(170, 240, 100, 20);
        fme.add(Citizen);

        JButton Submit = new JButton("Submit");
        Submit.setBounds(170, 300, 150, 30);
        fme.add(Submit);

        Submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String fullname = TxFullname.getText().trim();
                String email = TxEmail.getText().trim();
                String npmText = TxNPM.getText().trim();

                if (fullname.isEmpty() || email.isEmpty() || npmText.isEmpty() || 
                    (!Female.isSelected() && !Male.isSelected())) {
                    JOptionPane.showMessageDialog(fme, "Semua kolom harus diisi", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int npm;
                try {
                    npm = Integer.parseInt(npmText);
                    if (npm <= 0) {
                        throw new NumberFormatException();
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(fme, "NPM harus berupa angka positif.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String genderSelected = Female.isSelected() ? "Female" : "Male";
                String citizenship = Citizen.getSelectedItem().toString();

                String query = "INSERT INTO mhstudent(nama, npm, email, gender, citizenship) VALUES (?, ?, ?, ?, ?)";

		        try (Connection conn = connect.getConnection();
		             PreparedStatement stmt = conn.prepareStatement(query)) {

		            stmt.setString(1, fullname);
		            stmt.setInt(2, npm);
		            stmt.setString(3, email);
		            stmt.setString(4, genderSelected);
		            stmt.setString(5, citizenship);

		            int rowsAffected = stmt.executeUpdate();
		            if (rowsAffected > 0) {
		                JOptionPane.showMessageDialog(null, "Data berhasil dimasukkan!");
		                fme.dispose();
		                Masuk log = new Masuk();
		                log.Login();
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
	
	public static void main(String[] args) {
		Masuk log = new Masuk();
		log.Login();
	}
}
