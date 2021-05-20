import javax.swing.*;
import java.awt.*;

//界面UI
public class ClientUI extends JFrame {
    JFrame root;
    JPanel vote;
    JButton chooseVote;

    public ClientUI() {
        chooseVote=new JButton("选择");
        root = new JFrame();
        root.setLayout(new FlowLayout());
        vote = new JPanel();
        root.add(vote);
        root.add(chooseVote);
        root.setSize(500, 400);
        root.setLocation(500, 200);
        root.setVisible(true);
        root.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
