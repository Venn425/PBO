package Pembelajaran_3_Swing_1;

import javax.swing.JOptionPane;

public class Biodata {
	private String fullName, address;
	private int age, confirm;
	JOptionPane jop = new JOptionPane();
	
	public void setBiodata(String fullName, String address, int age) {
		this.fullName = fullName;
		this.address = address;
		this.age = age;
	}
	
	public void getBiodata() {
		String messages = "Fullname: " + fullName + "\n"
						+ "Address: " + address + "\n"
						+ "Age: " + age + "\n"; 
		
		jop.showMessageDialog(null, messages, "Biodata", jop.INFORMATION_MESSAGE);
		
	}
}
