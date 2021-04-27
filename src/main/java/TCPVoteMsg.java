import java.io.Serializable;
import java.util.List;

public class   TCPVoteMsg implements Serializable {

    //自定义实体类，作为对象数据流传输，需要继承java.io.Serializable，使用对象进行序列化

    private int statusCode;
    //状态码
    private String voteId;
    private String candidateId;
    private List<Vote> voteList;
    private List<Candidate> candidateList;

    public TCPVoteMsg(int statusCode) {
        this.statusCode = statusCode;
    }

    public TCPVoteMsg(int statusCode, String voteId) {
        this.statusCode = statusCode;
        this.voteId = voteId;
    }

    public TCPVoteMsg(int statusCode, String voteId, String candidateId) {
        this.statusCode = statusCode;
        this.voteId = voteId;
        this.candidateId = candidateId;
    }


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
