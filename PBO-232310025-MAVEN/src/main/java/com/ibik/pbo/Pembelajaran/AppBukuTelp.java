package com.ibik.pbo.Pembelajaran;

import java.util.ArrayList;
import javax.swing.JOptionPane;

class DataDiri {
    private String namaLengkap;
    private String alamat;
    private String noTelp;

    public DataDiri(String namaLengkap, String alamat, String noTelp) {
        this.namaLengkap = namaLengkap;
        this.alamat = alamat;
        this.noTelp = noTelp;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getNoTelp() {
        return noTelp;
    }
}

public class AppBukuTelp {
    public static void main(String[] args) {
        JOptionPane jop = new JOptionPane();
        ArrayList<DataDiri> data = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            String x = jop.showInputDialog(null, "Masukkan Nama Lengkap:", "Data Diri", JOptionPane.QUESTION_MESSAGE);
            String y = jop.showInputDialog(null, "Masukkan Alamat:", "Data Diri", JOptionPane.QUESTION_MESSAGE);
            String z = jop.showInputDialog(null, "Masukkan No Telp:", "Data Diri", JOptionPane.QUESTION_MESSAGE);

            data.add(new DataDiri(x, y, z));
        }

        String info = "";
        for (DataDiri item : data) {
            info += "Nama Lengkap: " + item.getNamaLengkap() + 
                    "\nAlamat: " + item.getAlamat() + 
                    "\nNo Telp: " + item.getNoTelp() + "\n\n";
        }

        jop.showMessageDialog(null, info, "Buku Telepon", JOptionPane.INFORMATION_MESSAGE);
    }
}
