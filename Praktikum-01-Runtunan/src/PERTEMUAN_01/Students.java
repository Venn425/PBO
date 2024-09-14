package PERTEMUAN_01;

public class Students {
	int NPM, SEM;
	float GPA;
	String NAMA, KELAS;
	
	void getNPM(int npm) {
		NPM = npm;
		System.out.println("NIM : " + NPM);
	}
	
	void getNAMA(String nama) {
		NAMA = nama;
		System.out.println("Nama : " + NAMA);
	}
	
	void getKELAS(String kelas) {
		KELAS = kelas;
		System.out.println("Kelas : " + KELAS);
	}
	
	void getSEM(int sem) {
		SEM = sem;
		System.out.println("Semester : " + SEM);
	}
	
	void getGPA(float gpa) {
		GPA = gpa;
		System.out.println("GPA : " + GPA);
	}
}
