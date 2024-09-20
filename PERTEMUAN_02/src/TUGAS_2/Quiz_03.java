package TUGAS_2;

import java.util.Scanner;

public class Quiz_03 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double jari, hasil;
		
		System.out.print("Input Jari-jari lingkaran: ");
		jari = input.nextDouble();
		
		hasil = Math.PI * jari * jari;
		
		System.out.printf("Luas lingkaran: %.1f", hasil);
	
		input.close();
	}
}
