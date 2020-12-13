package com.didi.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Clinet {

    public static void main(String[] args) throws IOException {

        Socket  s = new Socket("127.0.0.1" ,30000) ;

        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

        String line = br.readLine() ;
        System.out.println("来自服务器的数据"+ line);

        br.close();
        s.close();

    }
}