package PERTEMUAN_01;

import java.util.Scanner;

public class Latihan_02 {
	static hitung_vol volume = new hitung_vol();
	
	public static void main(String[] args) {
		System.out.println("Program Menghitung Volume");
		
		float jari, tinggi;
		Scanner input = new Scanner(System.in);
		
		System.out.print("Masukkan Jari - Jari: ");
		jari = input.nextFloat();
		
		System.out.print("Masukkan Tinggi: ");
		tinggi = input.nextFloat();
		
		
		float volTabung = volume.voltabung(jari, tinggi);
		float volKerucut = volume.volkerucut(jari, tinggi);
		
		System.out.println("Volume Kerucut: " + volKerucut);
		System.out.println("Volume Tabung: " + volTabung);
		
		input.close();
	}
}
