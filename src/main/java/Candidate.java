import java.io.Serializable;

//候选者类
public class Candidate implements Serializable {
    private String voteId;//投票id
    private String candidateId;//候选人编号
    private String candidateName;//候选人名字
    private int votes;//当前候选人获得票数
    private static final long serialVersionUID = 6666L;

    public String getVoteId() {
        return voteId;
    }

    public String getCandidateId() {
        return candidateId;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public int getVotes() {
        return votes;
    }


}
