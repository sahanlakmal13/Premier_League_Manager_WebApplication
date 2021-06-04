package OOP;

import java.io.Serializable;
//this class holds the played matches of the premier league
public class Match implements Serializable {//serializing to save and load as objects

    private Date w1790286MatchDate;//object of the Date class
    private String w1790286Club1Name;
    private int w1790286Club1Score;
    private String w1790286Club2Name;
    private int w1790286Club2Score;

    public Match(){}

    public Match(Date matchDate, String club1, int club1Score, String club2, int club2Score) {
        this.w1790286MatchDate = matchDate;
        this.w1790286Club1Name = club1;
        this.w1790286Club1Score = club1Score;
        this.w1790286Club2Name = club2;
        this.w1790286Club2Score = club2Score;
    }

    public Date getW1790286MatchDate() {
        return w1790286MatchDate;
    }

    public void setW1790286MatchDate(Date w1790286MatchDate) {
        this.w1790286MatchDate = w1790286MatchDate;
    }

    public String getW1790286Club1Name() {
        return w1790286Club1Name;
    }

    public void setW1790286Club1Name(String w1790286Club1Name) {
        this.w1790286Club1Name = w1790286Club1Name;
    }

    public int getW1790286Club1Score() {
        return w1790286Club1Score;
    }

    public void setW1790286Club1Score(int w1790286Club1Score) {
        this.w1790286Club1Score = w1790286Club1Score;
    }

    public String getW1790286Club2Name() {
        return w1790286Club2Name;
    }

    public void setW1790286Club2Name(String w1790286Club2Name) {
        this.w1790286Club2Name = w1790286Club2Name;
    }

    public int getW1790286Club2Score() {
        return w1790286Club2Score;
    }

    public void setW1790286Club2Score(int w1790286Club2Score) {
        this.w1790286Club2Score = w1790286Club2Score;
    }

    @Override
    public String toString() {//this will display the match details if a object was displayed
        return "{matchDate = "+ w1790286MatchDate +" club1Name = "+ w1790286Club1Name +" club1Score = "+ w1790286Club1Score + " club2Name = "+ w1790286Club2Name +
                " club2Score = "+ w1790286Club2Score +'}';
    }
}
