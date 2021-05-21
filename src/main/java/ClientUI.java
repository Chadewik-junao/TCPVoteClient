import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

//界面UI
public class ClientUI extends JFrame  {
    JFrame root;
    JPanel vote;
    JButton voteit;
    JTextArea date;
    JTextField inputid,inputname;
    JComboBox choice, choicecandidate;
    TCPVoteMsg serverMsg;

    public ClientUI(ObjectOutputStream outputStream, ObjectInputStream inputStream)throws IOException ,ClassNotFoundException{
        outputStream.writeObject(new TCPVoteMsg(101));
        serverMsg=(TCPVoteMsg)inputStream.readObject();
        Voteresult=serverMsg.getVoteList();

        //chooseVote = new JButton("选择");
        root = new JFrame();

        inputid=new JTextField(5);
        inputname=new JTextField(5);
        root.setLayout(new FlowLayout());
        vote = new JPanel();
        choice = new JComboBox();
        date=new JTextArea();
        choice.addItem("选择投票");
        for (int i = 0; i < Voteresult.size(); i++) {
            Vote item = Voteresult.get(i);
            System.out.println(item.getVoteName());
            choice.addItem(item.getVoteName());
        }
        choice.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                int index = choice.getSelectedIndex();
                if (index > 0) index--;
                date.setText("投票编号：" + Voteresult.get(index).getVoteId() + "\n投票名：" + Voteresult.get(index).getVoteName() + "\n开始时间：" + Voteresult.get(index).getStartDate().toString() + "\n结束时间：" + Voteresult.get(index).getStopDate().toString() + "\n当前票数：" + Voteresult.get(index).getAllVotes()+"\n\n");
                try {
                    outputStream.writeObject(new TCPVoteMsg(201,Voteresult.get(index).getVoteId()));
                    serverMsg= (TCPVoteMsg) inputStream.readObject();
                    Candidateresult=serverMsg.getCandidateList();
                    for(Candidate i:Candidateresult){
                        date.append("\n候选人编号：" + i.getCandidateId() +" 候选人名字："+i.getCandidateName());
                    }

                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
            }
        });
        voteit=new JButton("投票");
        voteit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               int index=choice.getSelectedIndex();
               if(index>0)index--;
               TCPVoteMsg send=new TCPVoteMsg(301,Voteresult.get(index).getVoteId(),new Voter(Voteresult.get(index).getVoteId(),inputid.getText(),inputname.getText()));
                try {
                    outputStream.writeObject(send);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        //choicecandidate = new JComboBox();


        root.add(vote);
        //root.add(chooseVote);
        vote.add(choice);
        vote.add(date);
        vote.add(new JLabel("候选人id："));
        vote.add(inputid);
        vote.add(new JLabel("用户名："));
        vote.add(inputname);
        vote.add(voteit);


        root.setSize(700, 300);
        root.setLocation(500, 200);
        root.setResizable(false);
        root.setVisible(true);
        root.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void setVoteresult(List<Vote> voteresult) {
        Voteresult = voteresult;
    }

    public void setCandidateresult(List<Candidate> candidateresult) {
        Candidateresult = candidateresult;
    }

    List<Vote> Voteresult;
    List<Candidate> Candidateresult;


}
