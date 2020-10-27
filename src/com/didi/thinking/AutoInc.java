package com.didi.thinking;

import java.util.Random;

public class AutoInc {
    public static void main(String[] args) {

        int i = 0 ;
        int j = 0 ;
        System.out.println(i++);
        System.out.println(i);

        System.out.println(++j);
        System.out.println(j);


        System.out.println("1"+1);
        System.out.println(1+"1");


        for(int k= 1 ; k<101 ;k++){

            System.out.println(k);


        }

        Random random = new Random( );
        for (int m=0 ; m<10 ;m++){
            int n  = random.nextInt(26)+'a';
            switch(n) {
                case 'a':
                    System.out.println('a');
                    //break;
                case 'e':
                    System.out.println('e');
                   // break;
                case 'i':
                    System.out.println('i');
                  //  break;
                case 'o':
                    System.out.println('o');
                  //  break;
                case 'u':
                    System.out.println('u');
                  //  break;
                case 'y':
                    System.out.println('y');
                   // break;
                case 'w':
                    System.out.println('w');
                   // break;

            }

        }
    }
}
