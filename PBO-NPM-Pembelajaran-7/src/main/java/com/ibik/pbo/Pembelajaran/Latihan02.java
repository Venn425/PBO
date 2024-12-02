package com.ibik.pbo.Pembelajaran;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Latihan02 {

    public static void main(String[] args) {
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

                JOptionPane.showMessageDialog(fme, data, "Data Diri", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        fme.setVisible(true);
    }
}
