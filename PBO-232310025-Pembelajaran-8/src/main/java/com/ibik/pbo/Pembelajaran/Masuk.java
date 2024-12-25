package com.ibik.pbo.Pembelajaran;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                String email = txtEmail.getText();
                String password = new String(txtPassword.getPassword());

                if (email.equals("ven@gmail.com") && password.equals("12345")) {
                    JOptionPane.showMessageDialog(fme, "Login Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    fme.dispose();
                    Form data = new Form();
                    data.Nilai();
                } else {
                    JOptionPane.showMessageDialog(fme, "Invalid email or password", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        fme.setVisible(true);
            }
	
	public void Register() {
		JFrame fme = new JFrame("Latihan 02");
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

        JLabel Phone = new JLabel("Phone");
        Phone.setBounds(40, 140, 60, 15);
        fme.add(Phone);

        JTextField TxPhone = new JTextField();
        TxPhone.setBounds(170, 140, 150, 20);
        fme.add(TxPhone);

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
                String fullname = TxFullname.getText();
                String email = TxEmail.getText();
                String phone = TxPhone.getText();

                String genderSelected = "";
                if (Female.isSelected()) {
                    genderSelected = "Female";
                } else if (Male.isSelected()) {
                    genderSelected = "Male";
                }
                
                String citizenship = Citizen.getSelectedItem().toString();

                String data = "Fullname: " + fullname + "\n";
                data += "Email: " + email + "\n";
                data += "Phone: " + phone + "\n";
                data += "Gender: " + genderSelected + "\n";
                data += "Citizenship: " + citizenship;

                if (!fullname.isEmpty() && !email.isEmpty() && !phone.isEmpty() && !genderSelected.isEmpty()) {
                    JOptionPane.showMessageDialog(fme, data, "Berhasil Ditambahkan", JOptionPane.INFORMATION_MESSAGE);
                    Login();
                    fme.dispose();
                } else {
                    JOptionPane.showMessageDialog(fme, "Tidak Boleh Kosong", "Error", JOptionPane.ERROR_MESSAGE);
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
