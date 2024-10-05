package Pertemuan_4;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

public class Latihan_09 {
	public static void main(String[] Args) {
		JOptionPane jop = new JOptionPane();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int n;
		
		String x = jop.showInputDialog(null, "Masukkan Jumlah Array: ");
		n = Integer.parseInt(x);
		
		
		for(int i = 0 ; i < n ; i++) {
			String y = jop.showInputDialog(null, "Masukkan Angka:", ("Data array ke-" + i), jop.QUESTION_MESSAGE);
			int tmp = Integer.parseInt(y);
			arr.add(tmp);
		}
		
		int tinggi = Collections.max(arr);
        int rendah = Collections.min(arr);
		
		StringBuilder output = new StringBuilder();
        for (int i = 0; i < n; i++) {
            output.append("x[").append(i).append("]=").append(arr.get(i)).append("\n");
        } 
        JOptionPane.showMessageDialog(null, output.toString() + "Nilai terbesar adalah " + tinggi 
        		+ "\nNilai terkecil adalah " + rendah, "Output Array", JOptionPane.INFORMATION_MESSAGE);
    
        
	}
}
