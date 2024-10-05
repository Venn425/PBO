package Pertemuan_4;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Latihan_10 {
	public static void main(String[] Args) {
		JOptionPane jop = new JOptionPane();
		ArrayList<String> data = new ArrayList<String>();
		
		String x = jop.showInputDialog(null, "Masukkan Nama Lengkap:", "Data diri", jop.QUESTION_MESSAGE);
		data.add(x);
		String y = jop.showInputDialog(null, "Masukkan Alamat:", "Data diri", jop.QUESTION_MESSAGE);
		data.add(y);
		String z = jop.showInputDialog(null, "Masukkan No 'Telp:", "Data diri", jop.QUESTION_MESSAGE);
		data.add(z);
		
		String info = "Nama Lengkap: " + data.get(0) 
					+ "\nAlamat: " + data.get(1) 
					+ "\nNo Telp: " + data.get(2);
		
		jop.showMessageDialog(null,  info, "Message", jop.INFORMATION_MESSAGE);
	}
}
