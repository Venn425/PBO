package PERTEMUAN_01;

import java.util.Scanner;

public class Latihan_06 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int age, NPM;
		String FNm, LNm;
		
		
		System.out.print("Masukan Nama Depan: ");
		FNm = input.next();
		System.out.print("Masukan Nama Belakang: ");
		LNm = input.next();
		System.out.print("Masukan NPM: ");
		NPM = input.nextInt();
		System.out.print("Masukan Usia: ");
		age = input.nextInt();
		
		System.out.println("output: " + age + FNm.concat(LNm) + NPM);
		
		input.close();
	}
}
