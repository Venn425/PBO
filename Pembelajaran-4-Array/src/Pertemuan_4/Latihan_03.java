package Pertemuan_4;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Latihan_03 {
	
	public static void main(String[] Args) {
		Scanner input = new Scanner(System.in);
		JOptionPane jop = new JOptionPane();
		int n;
		
		String x = jop.showInputDialog(null, "Masukkan Jumlah Array: ");
		n = Integer.parseInt(x);
		int[] arr = new int[n];
		
		for(int i = 0 ; i < n ; i++) {
			String y = jop.showInputDialog(null, "Masukkan Angka:", ("Data array ke-" + i), jop.QUESTION_MESSAGE);
			arr[i] = Integer.parseInt(y);
		}
		
		
		StringBuilder output = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            output.append("x[").append(i).append("]=").append(arr[i]).append("\n");
        } 
        JOptionPane.showMessageDialog(null, output.toString(), "Hasil Input", JOptionPane.INFORMATION_MESSAGE);
    
		
	}
}
