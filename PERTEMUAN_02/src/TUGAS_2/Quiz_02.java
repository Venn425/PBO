package TUGAS_2;

import java.util.Scanner;

public class Quiz_02 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int a;
		
		System.out.print("Input tinggi segitiga: ");
		a = input.nextInt();
		
		for (int i = 1 ; i <= a ; i++) {
			for (int j = 1 ;  j <= i ; j++) {
			System.out.print(i + " ");
		}
		System.out.print("\n");
	}
	input.close();
	}
}
