package TUGAS_02;

import java.util.Scanner;

public class Latihan_06 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int pilih;
		char x;
		
		do {
		System.out.println("Menu Sarapan:");
		System.out.println("1. Nasi Goreng");
		System.out.println("2. Bubur Ayam");
		System.out.println("3. Soto Ayam");
		System.out.print("Pilihan Menu: ");
		pilih = input.nextInt();
		
		switch(pilih) {
		case 1:
			System.out.println("Anda memesan Nasi Goreng dengan harga Rp. 22.000,-");
			break;
		case 2:
			System.out.println("Anda memesan Bubur Aya dengan harga Rp. 15.000,-");
			break;
		case 3:
			System.out.println("Anda memesan Soto Ayam dengan harga Rp. 25.000,-");
			break;
		default:
			System.out.println("Maaf menu yang anda masukkan salah.");
			}
		
		System.out.println("Apakah anda akan memesan kembali(y/n)");
		x = input.next().charAt(0);
		System.out.println("\n");
		}while(x == 'y' || x == 'Y');
		
		input.close();
	}
}