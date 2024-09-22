package TUGAS_02;

import java.util.Scanner;

public class Latihan_10 {
	private static void tampilMenu() {
		System.out.println("Menu:");
		System.out.println("1. Lihat Saldo");
		System.out.println("2. Setor Tunai");
		System.out.println("3. Tarik Tunai");
		System.out.println("4. Keluar");
		System.out.print("Pilihan menu: ");
	}
	
	public static void main(String[] args) {
	int pin = 232310025, masukPin, pilih;
	long saldo = 0;
	char x;
	Scanner input = new Scanner(System.in);
	
		do {
			System.out.print("Masukkan PIN anda: ");
			masukPin = input.nextInt();
			if(masukPin != pin) {
				System.out.println("PIN yang anda masukkan salah!\n");
			}
		}while(masukPin != pin);
	
		do {
		tampilMenu();
		pilih = input.nextInt();
			switch(pilih) {
			case 1:
				System.out.printf("Saldo anda sebesar: %d\n", saldo);
				break;
			case 2:
				System.out.print("Masukkan nominal uang yang akan disetor: ");
				long setor = input.nextLong();
				saldo += setor;
				System.out.printf("Saldo anda: %d\n", saldo);
				break;
			case 3:
				System.out.print("Masukkan nominal uang yang akan ditarik: ");
				long tarik = input.nextLong();
				if(saldo >= tarik) {
					saldo -= tarik;
					System.out.printf("Berhasil ditarik, saldo anda sat ini: %d\n", saldo);
				}else {
					System.out.println("Maaf Saldo anda tidak cukup!");
				}
				break;
			default:
				System.out.println("Anda keluar dari Menu!");
			}
			
			System.out.println("Apakah anda ingin melakukan transaksi lagi?(Y/N)");
			x = input.next().charAt(0);
			System.out.println("");
		}while(x == 'y' || x == 'Y');
	
	System.out.println("Terimakasih, Transaksi anda selesai!");
	}
}
