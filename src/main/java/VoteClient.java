import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class VoteClient {
    public static void main(String args[]) throws Exception{
        String Addr = "127.0.0.1";
        int Port = 10086;
        Socket sock = new Socket(Addr, Port);
        OutputStream out = sock.getOutputStream();
        Scanner sc=new Scanner(System.in);
        int next=sc.nextInt();
        out.close();
        sock.close();
    }
}
