package PERTEMUAN_01;

import java.util.Scanner;

public class Latihan_07 {
	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Masukkan teks: ");
        String teks = input.nextLine();
        
        String teksDiubah = merubah(teks);
        
        System.out.println("Tanpa Vokal: " + teksDiubah);
        
        input.close();
    }
	
	public static String merubah(String teks) {
        String vokal = "aeiouAEIOU";
        
        for (char c : vokal.toCharArray()) {
            teks = teks.replace(c, 'X');
        }
        
        return teks;
    }
}