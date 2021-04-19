import java.io.Serializable;
import java.util.List;

public class TCPVoteMsg implements Serializable {

    //自定义实体类，作为对象数据流传输，需要继承java.io.Serializable，使用对象进行序列化

    private int statusCode;
    //状态码

    private List<Vote> voteList;
    private List<Candidate> candidateList;


    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public List<Vote> getVoteList() {
        return voteList;
    }

    public void setVoteList(List<Vote> voteList) {
        this.voteList = voteList;
    }

    public List<Candidate> getCandidateList() {
        return candidateList;
    }

    public void setCandidateList(List<Candidate> candidateList) {
        this.candidateList = candidateList;
    }
}
