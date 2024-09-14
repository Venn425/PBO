package PERTEMUAN_01;

import java.util.Scanner;

public class Latihan_09 {
	static Students data = new Students();
		
		public static void main(String[] args) {
			Scanner inp =  new Scanner(System.in);
			
			System.out.println("Data Mahasiswa: ");
			
			System.out.print("NPM : ");
				int npm = inp.nextInt();
				inp.nextLine();	
			System.out.print("Nama : ");
				String nama = inp.nextLine();
			System.out.print("Kelas : ");
				String kls = inp.nextLine();	
			System.out.print("Semester : ");
				int sem = inp.nextInt();
			System.out.print("GPA : ");
				float gpa = inp.nextFloat();
			System.out.println("\n");
	
			data.getNAMA(nama);
			data.getNPM(npm);
			data.getKELAS(kls);
			data.getSEM(sem);
			data.getGPA(gpa);
			
			inp.close();
		}
}
