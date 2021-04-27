import java.sql.Date;

//投票类
public class Vote {
    private String voteId;//投票id
    private String voteName;//投票名
    private Date startDate, StopDate;//起止时间
    private int allVotes;//总票数

    public String getVoteId() {
        return voteId;
    }

    public String getVoteName() {
        return voteName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getStopDate() {
        return StopDate;
    }

    public int getAllVotes() {
        return allVotes;
    }


}
