package TUGAS_02;

import java.util.Scanner;

public class Latihan_04 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n;
		
		do {
		System.out.print("Masukkan angka inputan (Tidak Boleh <20): ");
		n = input.nextInt();
		}while(n < 20);
		
		System.out.print("DESC: Faktor " + n + " adalah ");
		for (int i = n; i > 0; i--) {
            if (n % i == 0) {
                System.out.print(i + " ");
            }
        }
        
        input.close();
	}
}
