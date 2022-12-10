package com.company;

import java.util.ArrayList;

class producer extends Thread {
    buffer buf;
    Integer N;
    Integer largest=0;
    Integer ctr=0;
    ArrayList<Integer> vctr = new ArrayList<>(1000000000);
    public producer(buffer buf,Integer N) {
        this.buf = buf;
        this.N = N;
    }
    public void run() {
        for (int i = 2; i <= this.N; i++)
        {
            boolean ff = true;
            for (int j=2;j<i;j++){
                if(i%j==0){
                    ff = false;
                }
            }
            if(ff){
                buf.produce(new Integer(i));
               this.largest = i;
               this.ctr++;
            }
        }
    }
    public Integer getCtr(){return this.ctr;}
  public Integer getLargest(){return this.largest;}


}
