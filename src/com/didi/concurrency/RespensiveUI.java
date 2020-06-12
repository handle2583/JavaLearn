package com.didi.concurrency;

public class RespensiveUI extends  Thread {


    private static volatile double d = 1 ;
    public RespensiveUI(){

        setDaemon(true);
        start();
    }

    public void run(){

        while (true){

            d = d+(Math.PI + Math.E)/(double) d  ;
        }
    }


    public static void main(String[] args) throws Exception{


        new RespensiveUI();
        System.in.read();
        System.out.println(d);
    }
}
