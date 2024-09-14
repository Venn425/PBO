package PERTEMUAN_01;

import java.util.Scanner;

public class Latihan_08 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		String nama, kls;
		int  npm, sem;
		float ipk;
		
		System.out.println("Data Mahasiswa: ");
		System.out.print("NPM: ");
			npm = input.nextInt();
			input.nextLine();
		System.out.print("Nama Lengkap: ");
			nama = input.next();
			input.nextLine();
		System.out.print("Nama Kelas: ");
			kls = input.nextLine();
		System.out.print("Semester: ");
			sem = input.nextInt();
		System.out.print("IPK: ");
			ipk = input.nextFloat();
		
		System.out.println("\nNPM: " + npm);
		System.out.println("Nama Lengkap: " + nama);
		System.out.println("Nama Kelas: " + kls);
		System.out.println("Semester: " + sem);
		System.out.println("IPK: " + ipk);
		
		input.close();
	}
}
