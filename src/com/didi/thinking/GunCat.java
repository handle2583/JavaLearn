package com.didi.thinking;

public class GunCat implements Cat {

    @Override
    public void info() {
        System.out.println("我是一只猎猫");
    }

    @Override
    public void run() {
        System.out.println("我跑得快");
    }
}
