package PERTEMUAN_01;

import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Latihan_04 {
	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
        
        System.out.println("====================================================================");
        System.out.println("\t\t\t TOKO SERBAGUNA IBIK");
        System.out.println("====================================================================");
        
        System.out.print("Masukkan jumlah produk yang dibeli: ");
        int jumlah = input.nextInt();
        
        LocalDateTime waktu = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String terformat = waktu.format(format);
        System.out.println(terformat);
        
        int hargaPerRoti = 6300;
        int normal = jumlah * hargaPerRoti;
        
        double diskon = 0;
        if (jumlah >= 3) {
            int kelipatan = jumlah / 3;
            diskon = kelipatan * 0.05; 
             
            if (diskon > 1.0) {
                diskon = 1.0;
            }
        }
        
        double totalDiskon = normal * diskon;
        double totalHargaSetelahDiskon = normal - totalDiskon;
        
        System.out.println("ITEM\t\tQTY \t HARGA \t\t TOTAL");
        System.out.println("====================================================================");
        System.out.printf("ROTI ENAK \t%d\t RP 6.300,- \tRP %,d%n", jumlah, normal);
        System.out.println("====================================================================");
        System.out.printf("Diskon: %.0f%%%n", diskon * 100);
        System.out.printf("Sub Total : RP %,d%n", (int) totalHargaSetelahDiskon);
        
        input.close();
	}
}
