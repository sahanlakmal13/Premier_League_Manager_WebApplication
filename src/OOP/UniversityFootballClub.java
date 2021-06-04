package OOP;

public class UniversityFootballClub extends FootballClub {

    private String w1790286UniversityName;

    public UniversityFootballClub(String name, String location, int wins, int draws, int defeats, int receivedGoals,
                                  int scoredGoals, int clubPoints, int numOfPlayedMatches, String universityName) {
        super(name, location, wins, draws, defeats, receivedGoals, scoredGoals);
        this.w1790286UniversityName = universityName;
    }

    public String getW1790286UniversityName() {
        return w1790286UniversityName;
    }

    public void setW1790286UniversityName(String uniName) {
        this.w1790286UniversityName = uniName;
    }

    @Override
    public String toString() {
        return "UniversityFootballClub { universityName = " + w1790286UniversityName +" }";
    }
}
