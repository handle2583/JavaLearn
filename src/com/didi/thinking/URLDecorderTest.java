package com.didi.thinking;

import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLDecorderTest {

    public static void main(String[] args)throws Exception {

            String mime = URLEncoder.encode("李刚 j2ee" ,"utf-8") ;
        System.out.println(mime);

        String keyWord = URLDecoder.decode(mime ,"utf-8") ;
        System.out.println( keyWord);
    }
}
