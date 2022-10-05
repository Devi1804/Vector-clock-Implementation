package com.ds.process;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Process1 {

    public static void main(String[] args) throws IOException {
        //Start a server to listen:::
        listen();
    }

    public void send() throws IOException {
        //TODO: automate the process of sending messages to server.
        //client sending messages:
        Socket sock = new Socket("localhost",2022);
        BufferedReader br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        PrintWriter pw = new PrintWriter(sock.getOutputStream(),true);

        pw.println("Hie from process 1 to process 2!");
        pw.println("Process 1 says time is: "+System.currentTimeMillis());
    }

    public static void listen() throws IOException {
        ServerSocket servSock = new ServerSocket(2021);
        System.out.println("Process 1 starting to listen on port 2021.");
        Socket sock = null;
        sock = servSock.accept();
        System.out.println("Connection established!");

        InputStreamReader ip = new InputStreamReader(sock.getInputStream());
        BufferedReader br = new BufferedReader(ip);

        String msg = br.readLine();
        System.out.println("Client says: "+msg);
    }
}
