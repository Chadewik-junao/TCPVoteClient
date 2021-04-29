import java.io.*;
import java.net.Socket;

//套接字连接
public class SocketConnect {

    private String Addr = "127.0.0.1";
    private int Port = 10086;
    private Socket sock;
    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;

    public void close() throws IOException{
        outputStream.close();
        inputStream.close();
        sock.close();
    }
    public SocketConnect() {

        try {
            sock = new Socket(Addr, Port);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Socket getConnect() {
        return sock;
    }

    public ObjectOutputStream getOutputStream() {
        if (outputStream == null) {
            try {
                outputStream = new ObjectOutputStream(sock.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return outputStream;
    }

    public ObjectInputStream getinputStream() {
        if (inputStream == null) {
            try {
                inputStream = new ObjectInputStream(sock.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return inputStream;
    }

    public int getPort() {
        return Port;
    }

    public void setPort(int port) {
        Port = port;
    }

    public String getAddr() {
        return Addr;
    }

    public void setAddr(String addr) {
        Addr = addr;
    }
}
