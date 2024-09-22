package TUGAS_02;

import java.util.Scanner;

public class Resto {
	private long harga;

    public void chooseMenu() {
        Scanner input = new Scanner(System.in);
        int pilihan;

        System.out.println("Menu Sarapan:");
        System.out.println("1. Nasi Goreng");
        System.out.println("2. Bubur Ayam");
        System.out.println("3. Soto Ayam");
        System.out.print("Pilihan Menu: ");
        pilihan = input.nextInt();

        long hargaMenu = getPrices(pilihan);

        if (hargaMenu != -1) {
            System.out.println("Harga Menu: Rp. " + hargaMenu + ",-");
        } else {
            System.out.println("Maaf, menu yang anda masukkan salah.");
        }
    }

    private long getPrices(int menu) {
        switch (menu) {
            case 1:
                harga = 22000;
                break;
            case 2:
                harga = 15000;
                break;
            case 3:
                harga = 25000;
                break;
            default:
                return -1;
        }
        return harga;
    }
}
