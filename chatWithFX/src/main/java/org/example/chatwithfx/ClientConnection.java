package org.example.chatwithfx;

import java.io.*;
import java.net.Socket;
import java.util.List;

public class ClientConnection implements Runnable {

    private BufferedReader in;
    private PrintWriter out;
    private List<ClientConnection> clientConnections;
    private String name;

    public ClientConnection(Socket socket, List<ClientConnection> clientConnections) throws IOException {
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
        this.clientConnections = clientConnections;
    }

    @Override
    public void run() {
        try {
            name = in.readLine();

            String message;
            while ((message = in.readLine()) != null) {
                printNewMessage(message, this);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void printNewMessage(String message, ClientConnection sender) {
        for (ClientConnection clientConnection : clientConnections) {
            if (clientConnection != sender) {
                clientConnection.out.println(clientConnection.name + ": " + message);
            } else {
                clientConnection.out.println("You: " + message);
            }
        }
    }


}
