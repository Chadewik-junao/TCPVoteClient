import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
//主类，程序入口
public class VoteClient {
    public static void main(String args[]) throws Exception{
        SocketConnect socket=new SocketConnect();
        ObjectOutputStream outputStream = socket.getOutputStream();
        InputStream inputStream =socket.getinputStream();
        outputStream.writeObject(new TCPVoteMsg(301,"001"));
        outputStream.writeObject(new TCPVoteMsg(201,"001","00101"));
        outputStream.writeObject(new TCPVoteMsg(-1));
    }
}
