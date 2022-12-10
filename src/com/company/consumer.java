package com.company;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class consumer extends Thread {
    buffer buf;
    String filename;
    Integer N;

    public consumer(buffer buf,Integer N,String filename) {
        this.buf = buf;
        this.N = N;
        this.filename = filename;
    }
    public void run() {
        for (int i = 1; i <= this.N; i++){
            File file = new File(this.filename);
            FileWriter fr = null;
            try {
                fr = new FileWriter(file,true);
            } catch (IOException e) {
                e.printStackTrace();
            }
            BufferedWriter br = new BufferedWriter(fr);
            String str=  Integer.toString((Integer) buf.consume());
           // System.out.println(str);
            try {
                br.write("\""+str+"\""+",");
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
          //  System.out.println(buf.consume());
        }


    }
}