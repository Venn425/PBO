package Pertemuan_4;

import java.util.Scanner;

public class Latihan_02 {
	public static void main(String[] Args) {
		Scanner input = new Scanner(System.in);
		int[] age = new int[5];
		
		for(int i = 0 ; i < age.length ; i++) {
			System.out.print("Masukkan Array ke-" + i + "= ");
			age[i] = input.nextInt();
		}
		
		for(int i = 0 ; i < age.length ; i++) {
			System.out.println("Array ke-" + i + "= " + age[i]);
		}
		
	}
}
