package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Myframe extends JFrame implements ActionListener {
    JButton button;
    JTextField t1,t2,t3;
    Label label1,label2,label3,label4,label5,label6,label7,label8,label9;
    String filename;
    Integer buffersize;
    Integer n_value;
    public Myframe(){
        button = new JButton();
        button.setBounds(50,250,150,40);
        button.addActionListener(this);
        button.setText("Start Producer");
        button.setFocusable(false);
        button.setFont(new Font("Comic Snas",Font.BOLD,10));
        button.setBackground(new Color(255,255,255));
        button.setBorder(BorderFactory.createEtchedBorder());


        t1=new JTextField();
        t1.setBounds(50,100, 300,30);

        t2=new JTextField();
        t2.setBounds(50,150, 300,30);

        t3=new JTextField();
        t3.setBounds(50,200, 300,30);



        label1 = new Label("N");
        label1.setBounds(350,100, 300,30);
        label1.setFont(new Font("Verdana", Font.BOLD, 18));

        label2 = new Label("Buffer Size");
        label2.setBounds(350,150, 300,30);
        label2.setFont(new Font("Verdana", Font.BOLD, 18));

        label3 = new Label("Output File");
        label3.setBounds(350,200, 300,30);
        label3.setFont(new Font("Verdana", Font.BOLD, 18));

        label4 = new Label("The Largest prime number");
        label4.setBounds(50,300, 450,30);
        label4.setFont(new Font("Verdana", Font.BOLD, 18));

        label5 = new Label("# of elements (prime number) generated");
        label5.setBounds(50,350, 450,30);
        label5.setFont(new Font("Verdana", Font.BOLD, 18));

        label6 = new Label("Time elapsed since the start of processing");
        label6.setBounds(50,400, 450,30);
        label6.setFont(new Font("Verdana", Font.BOLD, 18));


        label7 = new Label("-----");
        label7.setBounds(500,300, 300,30);

        label8 = new Label("-----");
        label8.setBounds(500,350, 300,30);

        label9 = new Label("-----");
        label9.setBounds(500,400, 300,30);




         // creates a frame
        this.setTitle("Assignment OS #1");//setstitle
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // EXIT_ON_CLOSE      -> kill the program
        // HIDE_ON_CLOSE      -> close but running in the background
        // DO_NOTHING_ON_CLOSE-> don't close program

        this.setResizable(false);          // prevent frame from being resized
        this.setSize(850,700); //set x-dimension
        this.setVisible(true);           // make frame visible


        this.setLayout(null);
        this.getContentPane().setBackground(Color.lightGray);
        //Color.color OR new Color(R,G,B) OR new Color(hexi-decimal value)
        this.add(button);
        this.add(t1);
        this.add(t2);
        this.add(t3);
        this.add(label1);
        this.add(label2);
        this.add(label3);
        this.add(label4);
        this.add(label5);
        this.add(label6);
        this.add(label7);
        this.add(label8);
        this.add(label9);
        // this.pack();
        this.setLayout(null);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
          String str1 = t1.getText();
          n_value = Integer.parseInt(str1);

           String str2 = t2.getText();
           buffersize = Integer.parseInt(str2);

           filename= t3.getText();

            /*System.out.println(n_value);
            System.out.println(buffersize);
            System.out.println(filename);*/

            Main.buf = new buffer(buffersize);
            producer P = new producer(Main.buf,n_value);
            consumer C = new consumer(Main.buf,n_value,filename);
            long start = System.currentTimeMillis(); //System.currentTimeMillis();
            P.start();
            C.start();
            //System.currentTimeMillis();

            while (P.isAlive()){
                label7.setText(Integer.toString(P.getLargest()));
                label8.setText(Integer.toString(P.getCtr()));
            }
            long finish = System.currentTimeMillis();
            long timeElapsed = finish - start ;
            label7.setText(Integer.toString(P.getLargest()));
            label7.setFont(new Font("Verdana", Font.BOLD, 18));

            label8.setText(Integer.toString(P.getCtr()));
            label8.setFont(new Font("Verdana", Font.BOLD, 18));

            label9.setText(Long.toString(timeElapsed) + " ms");
            label9.setFont(new Font("Verdana", Font.BOLD, 18));
        }
    }

}
