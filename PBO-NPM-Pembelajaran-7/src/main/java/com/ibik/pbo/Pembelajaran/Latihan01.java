package com.ibik.pbo.Pembelajaran;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Latihan01 {

	public static void main(String[] args) {
		JFrame fme = new JFrame("Latihan 01");
		fme.setSize(300, 200);
		fme.setLocationRelativeTo(null);
		fme.setLayout(null);
		fme.setDefaultCloseOperation(fme.EXIT_ON_CLOSE);
		
		JButton hello = new JButton("こんにちは");
		hello.setBounds(15, 30, 100, 30);
		fme.add(hello);
		
		JButton every = new JButton("everyone");
		every.setBounds(170, 30, 100, 30);
		fme.add(every);
		
		JButton ibik = new JButton("ibik");
		ibik.setBounds(95, 100, 100, 30);
		fme.add(ibik);
		
		hello.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "こんにちは is a word for Hello", "You just click こんにちは", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		
		every.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Everyone is semuanya", "You just click Everyone", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		
		ibik.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "IBIk is an acronym for 'Institue Bisnis dan Informatika Kesatuan'", "You just click IBIK", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		
		fme.setVisible(true);
	}

}
