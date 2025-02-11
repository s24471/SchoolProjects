package com.company;

import javax.swing.*;
import java.awt.*;


public class Main extends JFrame {

    public static void main(String[] args) {
        new Main();
    }
    public Main()
    {
        SwingUtilities.invokeLater(
                () -> createGUI()
        );
    }

    protected void createGUI() {
        while (true) {
            JFrame jf = new JFrame();
            jf.setLocation(500, 500);
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            String x = JOptionPane.showInputDialog("Podaj od A do G: ");
            jf.setTitle(x);
            switch (x) {
                case "A":
                    jf.setLayout(new BorderLayout());
                    break;
                case "B":
                    jf.setLayout(new FlowLayout());
                    break;
                case "C":
                    jf.setLayout(new FlowLayout(FlowLayout.LEFT));
                    break;
                case "D":
                    jf.setLayout(new FlowLayout(FlowLayout.RIGHT));
                    break;
                case "E":
                    jf.setLayout(new GridLayout(1, 0));
                    break;
                case "F":
                    jf.setLayout(new GridLayout(0, 1));
                    break;
                case "G":
                    jf.setLayout(new GridLayout(3, 2));
                    break;
            }
            jf.add(new JButton("Przycisk 1"), BorderLayout.CENTER);
            jf.add(new JButton("P 2"), BorderLayout.NORTH);
            jf.add(new JButton("Wiekszy przycisk numer 3"), BorderLayout.WEST);
            jf.add(new JButton("Przycisk 4"), BorderLayout.SOUTH);
            jf.add(new JButton("P 5"), BorderLayout.EAST);
            jf.pack();
            jf.setVisible(true);
        }
    }
}
