package Pertemuan_03;

import javax.swing.JOptionPane;

public class Latihan_03 {
	private static void confirm() {
		int confirm;
		
		confirm = JOptionPane.showConfirmDialog(null, "Apakah anda ingin keluar?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
		if(confirm == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		Biodata bio = new Biodata();
		JOptionPane jop = new JOptionPane();
		
		String fullName, address, ageSTR;
		int age, confirmEX;
		
		do {
		fullName = jop.showInputDialog(null, "FullName:");
		if(fullName == null) {
			confirm();
			continue;
		}
		if(fullName.trim().isEmpty()) {
			jop.showMessageDialog(null, "Nama tidak boleh kosong", "Error", jop.ERROR_MESSAGE);
			continue;
		}
		
			address = jop.showInputDialog(null, "Address:");
			if(address == null) {
				confirm();
				continue;
			}
			if(address.trim().isEmpty()) {
				jop.showMessageDialog(null, "Alamat tidak boleh kosong", "Error", jop.ERROR_MESSAGE);
				continue;
			}
			if(address.length() > 10) {
				jop.showMessageDialog(null, "Inputan tidak boleh lebih dari 10 karakter", "Error", jop.ERROR_MESSAGE);
				continue;
			}

		ageSTR = jop.showInputDialog(null, "Age:");
		if(ageSTR == null) {
			confirm();
			continue;
		}
		if(ageSTR.trim().isEmpty()) {
			jop.showMessageDialog(null, "Umur tidak boleh kosong", "Error", jop.ERROR_MESSAGE);
			continue;
		}

		try {
			age = Integer.parseInt(ageSTR);
		}catch(NumberFormatException e) {
			jop.showMessageDialog(null, "Inputan Harus berupa angka", "Error", jop.ERROR_MESSAGE);
			continue;
		}
		break;
		}while(true);
		
		bio.setBiodata(fullName, address, age);
		bio.getBiodata();
	}
}
