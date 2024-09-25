package Pembelajaran_3_Swing_1;

import javax.swing.JOptionPane;

public class Latihan_02 {
	public static void main(String[] args) {
		Biodata bio = new Biodata();
		JOptionPane jop = new JOptionPane();
		
		String fullName, address;
		int age;
		
		fullName = jop.showInputDialog(null, "FullName:");
		address = jop.showInputDialog(null, "Address:");
		age = Integer.parseInt(jop.showInputDialog(null, "Age:"));
		
		bio.setBiodata(fullName, address, age);
		bio.getBiodata();
	}
}
