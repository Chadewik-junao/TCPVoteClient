import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
//主类，程序入口
public class VoteClient {
    public static void main(String args[]) throws Exception{
        SocketConnect socket=new SocketConnect();
//        ObjectOutputStream outputStream = socket.getOutputStream();
        ObjectOutputStream outputStream=socket.getOutputStream();
        ObjectInputStream inputStream =socket.getinputStream();
//        ObjectInputStream inputStream =socket.getinputStream();
//        while (true) {
            outputStream.writeObject(new TCPVoteMsg(101,"001"));
//            inputStream.readObject();
            TCPVoteMsg serverMsg=(TCPVoteMsg)inputStream.readObject();
//            TCPVoteMsg recall=(TCPVoteMsg)inputStream.readObject();
            System.out.println(serverMsg.getStatusCode());
//        }
        socket.close();


//        outputStream.writeObject(new TCPVoteMsg(201,"001","00101"));
//        serverMsg=(TCPVoteMsg)inputStream.readObject();
//        System.out.println(serverMsg.getStatusCode());
//        outputStream.writeObject(new TCPVoteMsg(-1));
    }
}
