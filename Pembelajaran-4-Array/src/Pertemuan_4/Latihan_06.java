package Pertemuan_4;

import javax.swing.JOptionPane;

public class Latihan_06 {
	public static void main(String[] Args) {
		JOptionPane jop = new JOptionPane();
		int[][] arrA = new int[2][2];
		int[][] arrB = new int[2][2];
		
		for(int i = 0 ; i < 2 ; i++) {
			for(int j = 0 ; j < 2 ; j++) {
				arrA[i][j] = Integer.parseInt(jop.showInputDialog(null, "Baris " + (i + 1) + " ke " + (j + 1), "Matriks A", jop.QUESTION_MESSAGE));
			}
		}
		
		for(int i = 0 ; i < 2 ; i++) {
			for(int j = 0 ; j < 2 ; j++) {
				arrB[i][j] = Integer.parseInt(jop.showInputDialog(null, "Baris " + (i + 1) + " ke " + (j + 1), "Matriks B", jop.QUESTION_MESSAGE));
			}
		}
		
		String matriks = "";
		
		matriks += "Matriks A:\n";
		for(int i = 0 ; i < 2 ; i++) {
			matriks += "|  ";
			for(int j = 0 ; j < 2 ; j++) {
				matriks += arrA[i][j] + "  ";
			}
			matriks += "|\n";
		}
		
		matriks += "Matriks B:\n";
		for(int i = 0 ; i < 2 ; i++) {
			matriks += "|  ";
			for(int j = 0 ; j < 2 ; j++) {
				matriks += arrB[i][j] + "  ";
			}
			matriks += "|\n";
		}
		
		jop.showMessageDialog(null,  matriks, "Output Matriks", jop.INFORMATION_MESSAGE);
	}
}
