package com.didi.test;

public class Parcel4 {

    private class PContents implements Contents {
        private int i = 11;

        @Override
        public int value() {
            return i;
        }
    }


    protected class PDestination implements Destination {
        private String lable;
        private PDestination(String whereTo) {
            this.lable = whereTo;
        }
        @Override
        public String readLine() {
            return lable;
        }
    }

    public Destination destination(String s) {

        return new PDestination(s);
    }

    public Contents contents() {

        return new PContents();
    }
}
