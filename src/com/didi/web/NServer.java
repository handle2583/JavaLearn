package com.didi.web;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;

public class NServer {
    //多路复用器
    private Selector selector = null;

    private Charset charset = Charset.forName("UTF-8");

    public void init() throws IOException {

        //打开
        selector = Selector.open();
        //客户端服务
        ServerSocketChannel server = ServerSocketChannel.open();
        //地址
        InetSocketAddress isa = new InetSocketAddress("127.0.0.1", 30000);
        //绑定
        server.socket().bind(isa);
       //非阻塞模式
        server.configureBlocking(false);
      //注册
        server.register(selector, SelectionKey.OP_ACCEPT);
        //有io操作
        while (selector.select() > 0) {
            for (SelectionKey sk : selector.selectedKeys()) {
                selector.selectedKeys().remove(sk);
                //客户端的连接请求
                if (sk.isAcceptable()) {
                    SocketChannel sc = server.accept();
                    sc.configureBlocking(false);
                    sc.register(selector, SelectionKey.OP_READ);
                    sk.interestOps(SelectionKey.OP_ACCEPT);
                }
                //读取
                if (sk.isReadable()) {
                    SocketChannel sc = (SocketChannel) sk.channel();
                    ByteBuffer buff = ByteBuffer.allocate(1024);
                    String content = null;
                    try {
                        while (sc.read(buff) > 0) {
                            buff.flip();
                            content += charset.decode(buff);
                        }
                        System.out.println("---------" + content);
                        sk.interestOps(SelectionKey.OP_READ);
                    } catch (IOException e) {
                        sk.cancel();
                        if (sk.channel() != null) {
                            sk.channel().close();
                        }
                    }

                    if (content.length() > 0) {

                        for (SelectionKey key : selector.keys()) {

                            Channel targetChannel = key.channel();
                            if (targetChannel instanceof SocketChannel) {


                                SocketChannel dest = (SocketChannel) targetChannel;
                                dest.write(charset.encode(content));
                            }
                        }
                    }
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {

        new NServer().init();

    }
}
