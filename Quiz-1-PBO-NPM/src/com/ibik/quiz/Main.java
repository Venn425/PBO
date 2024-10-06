package com.ibik.quiz;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] Args) {
		JOptionPane jop = new JOptionPane();
		Book buku = new Book();
		int i = 0, confirm;
		String judul, pengarang, penerbit;
		
		do {
		int pil = Integer.parseInt(jop.showInputDialog(null, "1. Input Buku\n2. Output Buku\nMasukkan Menu", "Main Menu", jop.QUESTION_MESSAGE));
		
		switch(pil) {
		case 1:
			judul = jop.showInputDialog(null, "Input Judul", "Buku ke-" + (i + 1) + ": ", jop.QUESTION_MESSAGE);
			pengarang = jop.showInputDialog(null, "Input Pengarang", "Buku ke-" + (i + 1) + ": ", jop.QUESTION_MESSAGE);
			penerbit = jop.showInputDialog(null, "Input Penerbit", "Buku ke-" + (i + 1) + ": ", jop.QUESTION_MESSAGE);

            buku.inputbuku(judul, pengarang, penerbit);
            i++;
            break;
		case 2:
			buku.TampilkanBuku();
			break;
		default:
			jop.showMessageDialog(null,  "Message", "Pilihan Salah!", jop.INFORMATION_MESSAGE);	
		}
		
		confirm = (jop.showConfirmDialog(null, "Kembali Ke Menu?", "Message", jop.YES_NO_OPTION));
		}while(confirm == jop.YES_OPTION);
		
		
	}
}
