package com.didi.test;

public class Parcel10 {


    public Destination destination(final String dest, final float price) {
        return new Destination() {

            private int cost;

            {
                cost = Math.round(price);
                if (cost > 100) {
                    System.out.println("Over Budget");

                }


            }

            private String label = dest;

            @Override
            public String readLine() {
                return label;
            }
        };


    }

    public static void main(String args[]) {
        Parcel10 parcel10 = new Parcel10();
        Destination d = parcel10.destination("didi", 101F);


    }
}
