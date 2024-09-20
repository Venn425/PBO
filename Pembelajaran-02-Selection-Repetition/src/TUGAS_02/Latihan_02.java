package TUGAS_02;

import java.util.Scanner;

public class Latihan_02 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int npm;
		boolean prima  = true;
		
		System.out.print("Masukkan Nomor NPM: ");
		npm = input.nextInt();
		
		if (npm == 0 || npm == 1) {
		      prima = false;
		    }
		    else {
		      for (int i = 2; i <= npm / 2; i++) {
		        if (npm % i == 0) {
		          prima = false;
		          break;
		        }
		      }
		    } 
		     
		    if (prima)
		      System.out.println("Termasuk bilangan PRIMA");
		    else
		      System.out.println( "Bukan termasuk bilangan prima karena dapat dibagi 2");
	}
}
