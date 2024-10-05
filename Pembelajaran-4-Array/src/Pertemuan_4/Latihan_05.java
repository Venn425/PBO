package Pertemuan_4;

import javax.swing.JOptionPane;

public class Latihan_05 {
	public static void main(String[] Args) {
		JOptionPane jop = new JOptionPane();
		String[] data = new String[3];
		
		data[0] = jop.showInputDialog(null, "Masukkan Nama Lengkap:", "Data diri", jop.QUESTION_MESSAGE);
		data[1] = jop.showInputDialog(null, "Masukkan Alamat:", "Data diri", jop.QUESTION_MESSAGE);
		data[2] = jop.showInputDialog(null, "Masukkan No 'Telp:", "Data diri", jop.QUESTION_MESSAGE);
		
		String info = "Nama Lengkap: " + data[0] 
					+ "\nAlamat: " + data[1] 
					+ "\nNo Telp: " + data[2];
		
		jop.showMessageDialog(null,  info, "Message", jop.INFORMATION_MESSAGE);
	}
}	
