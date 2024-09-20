package TUGAS_2;

import java.util.Scanner;

public class Quiz_01 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int a;
		
		System.out.print("Input besar persegi: ");
		a = input.nextInt();
		
		for (int i = 0 ; i < a ; i++) {
			for (int j = 0 ;  j < a ; j++) {
			System.out.print("* ");
		}
		System.out.print("\n");
	}
	input.close();
}
}
