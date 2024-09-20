package TUGAS_2;

import java.util.Scanner;

public class Quiz_04 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n, first = 0, sec = 1;
		
		System.out.println("# Program Java Deret Fibonacci #");
		System.out.println("======================================");
		System.out.print("Jumlahh Deret Fibonacci yang diinginkan: ");
		n = input.nextInt();
			
		for(int i = 0 ; i < n ; i++) {
			System.out.print(first + " ");
			
			int next = first + sec;
			first = sec;
			sec = next;
		}
	}
}
