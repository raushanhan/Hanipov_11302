package org.example.chatwithfx;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {

    private static final List<ClientConnection> CLIENT_CONNECTIONS = new ArrayList<ClientConnection>();

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(1234)) {
            System.out.println("Server started");
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");
                ClientConnection clientConnection = new ClientConnection(socket, CLIENT_CONNECTIONS);
                CLIENT_CONNECTIONS.add(clientConnection);
                Thread thread = new Thread(clientConnection);
                thread.start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
