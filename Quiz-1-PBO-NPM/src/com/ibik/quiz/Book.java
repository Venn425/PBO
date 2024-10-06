package com.ibik.quiz;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Book {
	private ArrayList<String> judul = new ArrayList<>();
    private ArrayList<String> pengarang = new ArrayList<>();
    private ArrayList<String> penerbit = new ArrayList<>();
    private JOptionPane jop = new JOptionPane();
    String output = "";
    
    public void inputbuku(String judul, String pengarang, String penerbit) {
        this.judul.add(judul);
        this.pengarang.add(pengarang);
        this.penerbit.add(penerbit);
    }


    public void getBook(int index) {
          output += "Buku ke-" + (index + 1) + ": \n";
          output += "==========================================\n";
          output += "Judul: " + this.judul.get(index) + "\n";
          output += "Pengarang: " + this.pengarang.get(index) + "\n";
          output += "Penerbit: " + this.penerbit.get(index) + "\n-------------------------------\n";
    }


    public void TampilkanBuku() {
        if (judul.size() == 0) {
        	jop.showMessageDialog(null, "Message", "Tidak Ada Buku Yang Tersedai!", jop.INFORMATION_MESSAGE);
        } else {
            for (int i = 0; i < judul.size(); i++) {
            	getBook(i);   
            }
            jop.showMessageDialog(null, output, "Informasi Buku", jop.INFORMATION_MESSAGE);  
        }
    }
}
