package PERTEMUAN_01;

import java.util.Scanner;

public class Latihan_01 {
	public static void main(String[] args) {
	double cel, far, rhe, kel;
		
	System.out.println("Program Mengubah Suhu");
	System.out.print("Masukkan Suhu dalam Celcius: ");
	try (Scanner input = new Scanner(System.in)) {
		cel = input.nextDouble();
	}
	far = (9.0 / 5.0 * cel) + 32;
	rhe = cel * (4.0 / 5.0);
	kel = cel + 273.15;
	
	System.out.println("Suhu Celcius ke Farenheit: " + far + " °F");
	System.out.println("Suhu Celcius ke Rheamur: " + rhe + " °R");
	System.out.println("Suhu Celcius ke Kelvin: " + kel + " K");
	}
}