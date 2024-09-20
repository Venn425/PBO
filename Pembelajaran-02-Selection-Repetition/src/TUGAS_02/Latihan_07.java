package TUGAS_02;

import java.util.Scanner;

public class Latihan_07 {
	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Resto menu = new Resto(); 
        char ulang;

        do {
            menu.pilihMenu();
            System.out.print("Apakah anda akan memesan kembali? (y/n): ");
            ulang = input.next().charAt(0);

            System.out.println();

        } while (ulang == 'y' || ulang == 'Y'); 
        System.out.println("Terimakasih telah memesan.");

        input.close();
    }
}
