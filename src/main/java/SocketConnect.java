import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
//套接字连接
public class SocketConnect {

    private String Addr = "127.0.0.1";
    private int Port = 10086;
    private Socket sock;
    private OutputStream outStream;
    private InputStream inStream;

    public SocketConnect() {
        try {
            sock = new Socket(Addr, Port);
            outStream = sock.getOutputStream();
            inStream=sock.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Socket getConnect() {
        return sock;
    }

    public OutputStream getOutputStream() {
        return outStream;
    }

    public InputStream getInStream() {
        return inStream;
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
