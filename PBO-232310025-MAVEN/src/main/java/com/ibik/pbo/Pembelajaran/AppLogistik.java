package com.ibik.pbo.Pembelajaran;

import java.util.ArrayList;
import javax.swing.JOptionPane;

class Resi {
    private String namaPengirim;
    private String namaPenerima;
    private double beratBarang; 
    private double jarakTempuh; 
    private double totalBiaya;

    public Resi(String namaPengirim, double beratBarang, double jarakTempuh, double totalBiaya) {
        this.namaPengirim = namaPengirim;
        this.beratBarang = beratBarang;
        this.jarakTempuh = jarakTempuh;
        this.totalBiaya = totalBiaya;
    }

    public String getNamaPengirim() {
        return namaPengirim;
    }

    public double getBeratBarang() {
        return beratBarang;
    }

    public double getJarakTempuh() {
        return jarakTempuh;
    }

    public double getTotalBiaya() {
        return totalBiaya;
    }
}

public class AppLogistik {
    public static void main(String[] args) {
        JOptionPane jop = new JOptionPane();
        ArrayList<Resi> daftarResi = new ArrayList<>();

        while (true) {
            String namaPengirim = jop.showInputDialog(null, "Masukkan Nama Pengirim:", "Input Data", JOptionPane.QUESTION_MESSAGE);
            
            double beratBarang = Double.parseDouble(jop.showInputDialog(null, "Masukkan Berat Barang (gram):", "Input Data", JOptionPane.QUESTION_MESSAGE));
            double jarakTempuh = Double.parseDouble(jop.showInputDialog(null, "Masukkan Jarak Tempuh (km):", "Input Data", JOptionPane.QUESTION_MESSAGE));
            
            double biayaBerat = Math.ceil(beratBarang / 100) * 5000;
            double biayaJarak = Math.ceil(jarakTempuh / 10) * 8000;
            double totalBiaya = biayaBerat + biayaJarak;

            daftarResi.add(new Resi(namaPengirim, beratBarang, jarakTempuh, totalBiaya));

            jop.showMessageDialog(null, "Ringkasan Pengiriman:\n" + 
                                       "Nama Pengirim: " + namaPengirim + "\n" +  
                                       "Berat Barang: " + beratBarang + " gr\n" + 
                                       "Jarak Tempuh: " + jarakTempuh + " km\n" + 
                                       "Total Biaya: Rp " + totalBiaya, 
                                    "Ringkasan", JOptionPane.INFORMATION_MESSAGE);

            int confirm = JOptionPane.showConfirmDialog(null, "Apakah ingin menambahkan pengiriman lain?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (confirm != JOptionPane.YES_OPTION) {
                break;
            }
        }

        String semuaResi = "";
        for (Resi resi : daftarResi) {
            semuaResi += "Nama Pengirim: " + resi.getNamaPengirim() + "\n" +
                         "Berat Barang: " + resi.getBeratBarang() + " gr\n" +
                         "Jarak Tempuh: " + resi.getJarakTempuh() + " km\n" +
                         "Total Biaya: Rp " + resi.getTotalBiaya() + "\n\n";
        }
        jop.showMessageDialog(null, semuaResi, "Daftar Resi Pengiriman", JOptionPane.INFORMATION_MESSAGE);
    }
}
