package Pertemuan_4;

import javax.swing.JOptionPane;

public class Latihan_08 {
	public static void main(String[] Args) {
		JOptionPane jop = new JOptionPane();
		String[][] data = new String[3][3];
		
		
		for(int i = 0 ; i < 3 ; i++) {
				data[i][0] = jop.showInputDialog(null, "Masukkan Nama Lengkap:", "Data ke- " + (i + 1), jop.QUESTION_MESSAGE);
				data[i][1] = jop.showInputDialog(null, "Masukkan Alamat:", "Data ke- " + (i + 1), jop.QUESTION_MESSAGE);
				data[i][2] = jop.showInputDialog(null, "Masukkan No 'Telp:", "Data ke- " + (i + 1), jop.QUESTION_MESSAGE);
		}
		
		String info = "";
		
		
		for(int i = 0 ; i < 3 ; i++) {
			info += "Nama: " + data[i][0];
			info += "\nAlamat: " + data[i][1];
			info += "\nNo Telp: " + data[i][2] + "\n\n";
		}
		jop.showMessageDialog(null,  info, "Isi Data", jop.INFORMATION_MESSAGE);
	}
}
