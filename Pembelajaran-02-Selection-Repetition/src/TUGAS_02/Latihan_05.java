package TUGAS_02;

import java.util.Scanner;

public class Latihan_05 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n;
		
		System.out.print("Enter the number of row: ");
		n = input.nextInt();
		
		int i = 1;
        while (i <= n) {
            int j = 1;
            int akiri = n - i;
            int akanan = n - i;
            while (akiri >= 0) {
                System.out.print("* ");
                akiri--;
            }
            while (j <= (2 * i - 2)) {
                System.out.print("  ");
                j++;
            }
            while (akanan >= 0) {
                System.out.print("* ");
                akanan--;
            }
            System.out.println();
            i++;
        }

        
        i = n;
        while (i > 0) {
            int j = 1;
            int bkiri = n - i;
            int bkanan = n - i;
            while (bkiri >= 0) {
                System.out.print("* ");
                bkiri--;
            }
            while (j <= (2 * i - 2)) {
                System.out.print("  ");
                j++;
            }
            while (bkanan >= 0) {
                System.out.print("* ");
                bkanan--;
            }
            System.out.println();
            i--;
        }

        input.close();
	}
}
