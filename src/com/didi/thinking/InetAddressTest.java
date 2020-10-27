package com.didi.thinking;

import java.net.InetAddress;

public class InetAddressTest {


    public static void main(String[] args) throws Exception{
        InetAddress ip = InetAddress.getByName("www.baidu.com") ;

        System.out.println(ip.isReachable(2000) );

        System.out.println(ip.getHostAddress());

        InetAddress local = InetAddress.getByAddress(new byte[]{127,0,0,1}) ;

        System.out.println(local.isReachable(5000));

        System.out.println(local.getCanonicalHostName());


    }
}
