package com.ibik.pbo.Pembelajaran;

import java.util.ArrayList;
import javax.swing.JOptionPane;

class Resii {
    private String namaPengirim;
    private String namaPenerima;
    private double beratBarang;
    private double jarakTempuh;
    private double totalBiaya;

    public Resii(String namaPengirim, double beratBarang, double jarakTempuh, double totalBiaya) {
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

public class AppLogistik2 {
    public static void main(String[] args) {
        JOptionPane jop = new JOptionPane();
        ArrayList<Resii> daftarResi = new ArrayList<>();
        
        while (true) {
        int pil = Integer.parseInt(jop.showInputDialog(null, "Pilih Menu:\n1. Buat Pesanan\n2. Lacak Pesanan", jop.QUESTION_MESSAGE));
        
        switch(pil) {
        case 1:
        while (true) {
            String namaPengirim = jop.showInputDialog(null, "Masukkan Nama Pengirim:", "Input Data", JOptionPane.QUESTION_MESSAGE);

            if (namaPengirim == null) {
                int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda ingin keluar?", "Konfirmasi Keluar", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    break; 
                } else {
                    continue; 
                }
            }

            double beratBarang = 0;
            while (true) {
                try {
                    String input = jop.showInputDialog(null, "Masukkan Berat Barang (gram):", "Input Data", JOptionPane.QUESTION_MESSAGE);
                    if (input == null) {
                        int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda ingin keluar?", "Konfirmasi Keluar", JOptionPane.YES_NO_OPTION);
                        if (confirm == JOptionPane.YES_OPTION) {
                            break;  
                        } else {
                            continue; 
                        }
                    }
                    beratBarang = Double.parseDouble(input);
                    if (beratBarang <= 0) {
                        throw new NumberFormatException();
                    }
                    break;  
                } catch (NumberFormatException e) {
                    jop.showMessageDialog(null, "Input harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            double jarakTempuh = 0;
            while (true) {
                try {
                    String input = jop.showInputDialog(null, "Masukkan Jarak Tempuh (km):", "Input Data", JOptionPane.QUESTION_MESSAGE);
                    if (input == null) {
                        int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda ingin keluar?", "Konfirmasi Keluar", JOptionPane.YES_NO_OPTION);
                        if (confirm == JOptionPane.YES_OPTION) {
                            break;  
                        } else {
                            continue;  
                        }
                    }
                    jarakTempuh = Double.parseDouble(input);
                    if (jarakTempuh <= 0) {
                        throw new NumberFormatException();
                    }
                    break;  
                } catch (NumberFormatException e) {
                    jop.showMessageDialog(null, "Input harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            double biayaBerat = Math.ceil(beratBarang / 100) * 5000;
            double biayaJarak = Math.ceil(jarakTempuh / 10) * 8000;
            double totalBiaya = biayaBerat + biayaJarak;

            daftarResi.add(new Resii(namaPengirim, beratBarang, jarakTempuh, totalBiaya));

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
        case 2:
        String semuaResi = "";
        
        
        for (Resii resi : daftarResi) {
        semuaResi += "Nama Pengirim: " + resi.getNamaPengirim() + "\n" +
        "Berat Barang: " + resi.getBeratBarang() + " gr\n" +
        "Jarak Tempuh: " + resi.getJarakTempuh() + " km\n" +
        "Total Biaya: Rp " + resi.getTotalBiaya() + "\n\n";
        }
        jop.showMessageDialog(null, semuaResi, "Daftar Resi Pengiriman", JOptionPane.INFORMATION_MESSAGE);
        break;
        
        default:
        jop.showMessageDialog(null,  "Error", "Input Salah", JOptionPane.ERROR_MESSAGE);
        break;
        }
        
        int confirm = JOptionPane.showConfirmDialog(null, "Apakah ingin kembali ke menu?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            break;
        }
    }
}
}
