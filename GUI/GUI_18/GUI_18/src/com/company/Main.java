package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {

    public static void main(String[] args) {
	    new Main();
    }
    JTextArea txta = new JTextArea();
    public Main(){

        InnerHandler handler = new InnerHandler();

        JFrame frame = new JFrame("Simple swing app");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JPanel p1 = new JPanel() ;
        p1.setBounds(0,0, 200,50);

        JButton b1 = new JButton("FR"); b1.setBackground(Color.red);    b1.addActionListener(handler);

        JButton b2 = new JButton("FG"); b2.addActionListener(handler);  b2.setBackground(Color.green);

        JButton b3 = new JButton("FB"); b3.addActionListener(handler);  b3.setBackground(Color.blue);

        p1.setLayout(new FlowLayout(FlowLayout.LEFT));
        p1.add(b1); p1.add(b2); p1.add(b3);

        JPanel p2 = new JPanel() ;
        p2.setBounds(230,0, 250,50);
        p2.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JButton b4 = new JButton("A");
        JButton b5 = new JButton("B");
        JButton b6 = new JButton("C");

        p2.add(b4);
        p2.add(b5);
        p2.add(b6);

        JPanel p3 = new JPanel(new GridLayout(3,3));
        for (int i = 0; i < 9; i++) {
            p3.add(new JButton(Integer.toString(i + 1)));
        }



        txta.append("Obszar tekstowy typu JTextArea");
        txtHandler handlertxt = new txtHandler();

        JScrollPane scroll = new JScrollPane (txta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        JPanel p4 = new JPanel(new GridLayout(3,1));

        JTextField txtf1 = new JTextField("Pole tekstowe 1 typu JTextField");
        txtf1.addActionListener(handlertxt);
        p4.add(txtf1);

        JTextField txtf2 = new JTextField("Pole tekstowe 2 typu JTextField");
        txtf2.addActionListener(handlertxt);
        p4.add(txtf2);

        JTextField txtf3 = new JTextField("Pole tekstowe 3 typu JTextField");
        txtf3.addActionListener(handlertxt);
        p4.add(txtf3);

        JPanel p34 = new JPanel(new BorderLayout());
        p34.add(p3, BorderLayout.WEST);
        p34.add(p4, BorderLayout.EAST);

        frame.setLayout(new BorderLayout());

        JPanel p12 = new JPanel();
        p12.setLayout(new BorderLayout());
        p12.add(p1, BorderLayout.WEST);
        p12.add(p2, BorderLayout.EAST);
        frame.add(p12, BorderLayout.NORTH);
        frame.add(scroll, BorderLayout.CENTER);
        frame.add(p34,BorderLayout.SOUTH);
        frame.pack();

        frame.setSize(500,500);
        frame.setLocation(500,500);
        frame.setVisible(true);


    }


    private class InnerHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {


            JButton jb = (JButton) (e.getSource());
            switch (jb.getText()){
                case "FR":
                    txta.setForeground(Color.red);
                    break;
                case "FG":
                    txta.setForeground(Color.GREEN);
                    break;
                case "FB":
                    txta.setForeground(Color.BLUE);
                    break;
            }
        }
    }
    private class txtHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JTextField jTextField = (JTextField) (e.getSource());
            String tmp = jTextField.getText();

            txta.append(tmp + '\n');
        }
    }
}
