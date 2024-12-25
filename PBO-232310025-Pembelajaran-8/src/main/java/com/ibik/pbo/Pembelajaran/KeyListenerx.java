package com.ibik.pbo.Pembelajaran;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KeyListenerx extends JFrame implements KeyListener {
   
    private static final long serialVersionUID = 1L;

    private int posX = 200, posY = 200, shapeSize = 50;
    private String currentShape = "Circle";

    public KeyListenerx() {
        setTitle("Key Listener - Shape Movement");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addKeyListener(this);
        setResizable(false);
        setFocusable(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, getWidth(), getHeight());

        if ("Circle".equals(currentShape)) {
            drawCircle(g);
        } else {
            drawSquare(g);
        }
    }

    private void drawCircle(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillOval(posX, posY, shapeSize, shapeSize);
    }

    private void drawSquare(Graphics g) {
        g.setColor(Color.ORANGE);
        g.fillRect(posX, posY, shapeSize, shapeSize);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_A || keyCode == KeyEvent.VK_LEFT) {
            posX -= 10;
        } else if (keyCode == KeyEvent.VK_D || keyCode == KeyEvent.VK_RIGHT) {
            posX += 10;
        } else if (keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_UP) {
            posY -= 10;
        } else if (keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_DOWN) {
            posY += 10;
        }

        if (posX <= 0 || posX + shapeSize >= getWidth() || posY <= 0 || posY + shapeSize >= getHeight()) {
            toggleShape();
        }

        repaint();
    }

    private void toggleShape() {
        currentShape = "Circle".equals(currentShape) ? "Square" : "Circle";
    }

    @Override public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            KeyListenerx frame = new KeyListenerx();
            frame.setVisible(true);
        });
    }
}
