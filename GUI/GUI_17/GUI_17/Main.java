package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame{

    Color[] colors = {Color.RED, Color.green, Color.BLUE};
    int index = 0;
    public static void main(String[] args) {
	    new Main();
    }

    public Main(){
        JFrame frame = new JFrame();
        JButton button = new JButton("kolorki");
        InnerHandler handler = new InnerHandler();
        button.addActionListener(handler);
        frame.add(button);
        frame.setVisible(true);
        frame.setSize(1000,1000);

    }



    private class InnerHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            JButton jb = (JButton)(e.getSource());
            jb.setBackground(colors[index%3]);
            index++;

        }
    }
}
