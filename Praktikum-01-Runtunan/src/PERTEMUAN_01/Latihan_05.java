package PERTEMUAN_01;

import java.util.Scanner;

public class Latihan_05 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String text;
		
		System.out.print("Masukan Kalimat : ");
		text = input.nextLine();
		
		System.out.println("Hasil Pembesaran ==> " + text.toUpperCase());
		
		input.close();
	}
}
