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

    protected void createGUI()
    {
        JFrame jf = new JFrame("GUI_15");
        JTextArea txt = new JTextArea();
        txt.append("Dialog");
        txt.setForeground(Color.green);
        txt.setBackground(Color.red);
        Font bold = new Font("BOLD", Font.BOLD, 14);
        txt.setFont(bold);
        jf.add(txt);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // jf.setResizable(false);
        jf.setLocation(500, 500);
        jf.pack();
        jf.setVisible(true);
    }
}
