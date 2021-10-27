package com.example.netty.one;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

public class Server {

    public static void main(String[] args) throws IOException {

        ByteBuffer buffer = ByteBuffer.allocate(16);

        ServerSocketChannel server = ServerSocketChannel.open();
        server.bind(new InetSocketAddress(8888));

        // 连接集合
        List<SocketChannel> channel = new ArrayList<>();
        while (true){
            SocketChannel accept = server.accept();
            channel.add(accept);

            for (SocketChannel socketChannel : channel) {
                buffer.flip();
                if (socketChannel.read(buffer) != -1) {

                }
                buffer.clear();
            }
        }
    }
}
