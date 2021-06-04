package OOP;

public class SchoolFootballClub extends FootballClub{

    private String w1790286SchoolName;

    public SchoolFootballClub(String name, String location, int wins, int draws, int defeats, int receivedGoals,
                              int scoredGoals, int clubPoints, int numOfPlayedMatches, String schoolName) {
        super(name, location, wins, draws, defeats, receivedGoals, scoredGoals);
        this.w1790286SchoolName = schoolName;
    }

    public String getW1790286SchoolName() {

        return w1790286SchoolName;
    }

    public void setW1790286SchoolName(String w1790286SchoolName) {

        this.w1790286SchoolName = w1790286SchoolName;
    }

    @Override
    public String toString() {

        return "SchoolFootballClub { School Name = " + w1790286SchoolName +"}";
    }
}
