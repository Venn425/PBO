package perpus;

import java.sql.*;
import java.util.Scanner;

public class SERPApp {

    // Konfigurasi koneksi database
    private static final String DB_URL = "jdbc:mysql://localhost:3306/search_engine";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Meminta kata kunci pencarian dari pengguna
        System.out.print("Masukkan kata kunci pencarian: ");
        String keyword = scanner.nextLine();

        // Membuat koneksi ke database dan menjalankan query
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            System.out.println("Koneksi ke database berhasil.");

            // Query SQL untuk mencari kata kunci dalam kolom content
            String sql = "SELECT title, url FROM web_pages WHERE content LIKE ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, "%" + keyword + "%");

                // Menjalankan query
                try (ResultSet resultSet = statement.executeQuery()) {
                    System.out.println("\nHasil pencarian:");
                    boolean found = false;

                    while (resultSet.next()) {
                        found = true;
                        String title = resultSet.getString("title");
                        String url = resultSet.getString("url");

                        System.out.println("- " + title + " (" + url + ")");
                    }

                    if (!found) {
                        System.out.println("Tidak ada hasil ditemukan untuk kata kunci: " + keyword);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        } finally {
            scanner.close(); // Menutup scanner untuk menghindari kebocoran sumber daya
        }
    }
}
