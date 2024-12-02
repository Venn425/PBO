package com.ibik.pbo.Pembelajaran;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Latihan03 {

	public static void main(String[] args) {
		JFrame fme = new JFrame();
		fme.setSize(300, 300);
		fme.setLayout(null);;
		fme.setLocationRelativeTo(null);
		fme.setDefaultCloseOperation(fme.EXIT_ON_CLOSE);
		
		JLabel Email = new JLabel("Email");
		Email.setBounds(30, 30, 60, 15);
		fme.add(Email);
		
		JLabel Password = new JLabel("Password");
		Password.setBounds(30, 80, 60, 15);
		fme.add(Password);
		
		JCheckBox remember = new JCheckBox("Remember Password");
		remember.setBounds(30, 130, 180, 15);
		fme.add(remember);
		
		JButton Login = new JButton("Login");
		Login.setBounds(100, 180, 80, 30);
		fme.add(Login);
		
		JTextField TxEmail = new JTextField();
		TxEmail.setBounds(120, 30, 120, 20);
		fme.add(TxEmail);
		
		JPasswordField TxPassword = new JPasswordField();
		TxPassword.setBounds(120, 80, 120, 20);
		fme.add(TxPassword);
		
		Login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String Email = "steven@gmail.com";
				String Password = "12345";
				
				String InputEmail = TxEmail.getText();
				String InputPass = new String(TxPassword.getPassword());
				
				if (InputEmail.isEmpty() || InputPass.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Email dan Password tidak boleh kosong!", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }

		        if (InputEmail.equals(Email) && InputPass.equals(Password)) {
		            JOptionPane.showMessageDialog(null, "Selamat Datang, Steven!");

		            // Simulasi remember password
		            if (remember.isSelected()) {
		                JOptionPane.showMessageDialog(null, "Data Anda akan diingat!", "Info", JOptionPane.INFORMATION_MESSAGE);
		            }
		        } else {
		            JOptionPane.showMessageDialog(null, "Data yang Anda masukkan salah!", "Error", JOptionPane.ERROR_MESSAGE);
		        }
			}
		});
		
		
		
		
		fme.setVisible(true);
	}

}
