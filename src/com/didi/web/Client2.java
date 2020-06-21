package com.didi.web;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.net.Socket;

public class Client2 {

    private  static final  int SERVER_PORT = 30000;
    private Socket socket ;
    private PrintStream ps ;
    private BufferedReader brServer ;
    private  BufferedReader keyIn;
}
