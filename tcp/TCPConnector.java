package tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPConnector implements Client, Connection, Server{
    private Socket socket;

    @Override
    public Connection connect(String hostname, int port) throws IOException {
        this.socket = new Socket(hostname, port);
        return this;
    }

    @Override
    public OutputStream getOutputStream() throws IOException {
        return this.socket.getOutputStream();
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return this.socket.getInputStream();
    }

    @Override
    public Connection acceptConnection(int port) throws IOException {
        ServerSocket server = new ServerSocket(port);
        System.out.println("Waiting for client.");
        this.socket = server.accept();
        System.out.println("Client connected.");
        return this;
    }
}
