package com.ibik.pbo.Pembelajaran;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Tictactoe extends JFrame implements MouseListener {
   
	private static final long serialVersionUID = 1L;
	
	private JButton[][] buttons = new JButton[3][3];
    private boolean xTurn = true;
    private int scoreX = 0;
    private int scoreO = 0;
    private JLabel scoreLabel;

    public Tictactoe() {
        setTitle("Tic Tac Toe");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel board = new JPanel(new GridLayout(3, 3));
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(new Font("Arial", Font.BOLD, 40));
                buttons[i][j].setFocusPainted(false);
                buttons[i][j].addMouseListener(this);
                board.add(buttons[i][j]);
            }
        }

        scoreLabel = new JLabel("Score X: " + scoreX + " O: " + scoreO);
        scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(scoreLabel, BorderLayout.NORTH);
        add(board, BorderLayout.CENTER);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        if (!clickedButton.getText().isEmpty()) {
            return;
        }

        clickedButton.setText(xTurn ? "X" : "O");
        clickedButton.setEnabled(false);

        if (checkWin()) {
            String winner = xTurn ? "X" : "O";
            if (xTurn) {
                scoreX++;
            } else {
                scoreO++;
            }
            scoreLabel.setText("Score X: " + scoreX + " O: " + scoreO);

            JOptionPane.showMessageDialog(this, winner + " got point " + (xTurn ? scoreX : scoreO),
                    "Message", JOptionPane.INFORMATION_MESSAGE);
            resetBoard();
        } else if (isBoardFull()) {
            JOptionPane.showMessageDialog(this, "It's a draw!", "Message", JOptionPane.INFORMATION_MESSAGE);
            resetBoard();
        }

        xTurn = !xTurn;
    }

    private boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (buttons[i][0].getText().equals(buttons[i][1].getText()) &&
                buttons[i][0].getText().equals(buttons[i][2].getText()) &&
                !buttons[i][0].getText().isEmpty()) {
                return true;
            }
            if (buttons[0][i].getText().equals(buttons[1][i].getText()) &&
                buttons[0][i].getText().equals(buttons[2][i].getText()) &&
                !buttons[0][i].getText().isEmpty()) {
                return true;
            }
        }
        if (buttons[0][0].getText().equals(buttons[1][1].getText()) &&
            buttons[0][0].getText().equals(buttons[2][2].getText()) &&
            !buttons[0][0].getText().isEmpty()) {
            return true;
        }
        if (buttons[0][2].getText().equals(buttons[1][1].getText()) &&
            buttons[0][2].getText().equals(buttons[2][0].getText()) &&
            !buttons[0][2].getText().isEmpty()) {
            return true;
        }
        return false;
    }

    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j].getText().isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    private void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
                buttons[i][j].setEnabled(true);
            }
        }
        xTurn = true;
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Tictactoe game = new Tictactoe();
            game.setVisible(true);
        });
    }
}