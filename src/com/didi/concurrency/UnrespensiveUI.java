package com.didi.concurrency;

public class UnrespensiveUI {

    private volatile  double d = 1 ;

    public  UnrespensiveUI() throws  Exception{
        while (d > 0 ){

            d = d+(Math.PI + Math.E)/(double) d ;

        }
        System.in.read();
    }
}
