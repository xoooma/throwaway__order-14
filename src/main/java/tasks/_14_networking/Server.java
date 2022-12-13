package tasks._14_networking;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public Server(int port) {
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server started");

            System.out.println("Waiting for a client...");

            Socket socket = server.accept();
            System.out.println("Client accepted");

            DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

            String line = "";

            while (!line.equals("/server:stop")) {
                try {
                    line = dataInputStream.readUTF();
                    System.out.println(line);

                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            }
            System.out.println("Closing connection");

            socket.close();
            dataInputStream.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}