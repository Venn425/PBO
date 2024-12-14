package perpus;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class SERPApp {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/DigiLib";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public static void FrameApp() {
        JFrame fme = new JFrame();
        fme.setSize(500, 500);
        fme.setLocationRelativeTo(null);
        fme.setLayout(null);
        fme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setBounds(0, 0, 500, 30);
        panel.setOpaque(true);
        fme.add(panel);

        JLabel Judul = new JLabel("Cari Buku");
        Judul.setBounds(220, 0, 400, 30);
        Judul.setFont(new Font("arial", Font.BOLD, 20));
        panel.add(Judul);

        JLabel Kata = new JLabel("Kata Kunci :");
        Kata.setBounds(30, 50, 100, 15);
        Kata.setFont(new Font("arial", Font.ITALIC, 16));
        fme.add(Kata);

        JTextField TxKata = new JTextField();
        TxKata.setBounds(130, 45, 250, 30);
        fme.add(TxKata);

        JButton Search = new JButton("Search");
        Search.setBounds(390, 45, 80, 30);
        fme.add(Search);

        String[] columnNames = {"Title", "URL"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(30, 100, 440, 300);
        fme.add(scrollPane);

        Search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String keyword = TxKata.getText().trim();
                if (keyword.isEmpty()) {
                    JOptionPane.showMessageDialog(fme, "Kata kunci tidak boleh kosong!", "Warning", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
                    String sql = "SELECT judul, penulis FROM Buku WHERE content LIKE ?";
                    try (PreparedStatement statement = conn.prepareStatement(sql)) {
                        statement.setString(1, "%" + keyword + "%");

                        try (ResultSet resultSet = statement.executeQuery()) {
                            tableModel.setRowCount(0);
                            boolean found = false;

                            while (resultSet.next()) {
                                found = true;
                                String judul = resultSet.getString("Judul");
                                String penulis = resultSet.getString("Penulis");
                                tableModel.addRow(new Object[]{judul, penulis});
                            }

                            if (!found) {
                                tableModel.addRow(new Object[]{"Tidak ada hasil ditemukan", ""});
                            }
                        }
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(fme, "Terjadi kesalahan: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        fme.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SERPApp::FrameApp);
    }
}
