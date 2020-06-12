package com.didi.concurrency;

public class Joining {

    public  static void main(String[] args){


        Sleeper
                sleepy = new Sleeper("Sleepy" ,10500),
                grumpy = new Sleeper("Grumpy",10500) ;

                Joiner dopey = new Joiner("Dopey" , sleepy) ,
                        doc = new Joiner("Doc" , grumpy)  ;

                grumpy.interrupt();
    }
}
