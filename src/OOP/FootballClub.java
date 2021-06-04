package OOP;

import java.io.Serializable;

//this class holds the details about the football clubs in premier league
public class FootballClub extends SportsClub implements Serializable,Comparable<FootballClub> {
    //serializing to save and load as objects
    //implements comparable interface to override and sort according to different field

    private int w1790286Wins;
    private int w1790286Draws;
    private int w1790286Defeats;
    private int w1790286ReceivedGoals;
    private int w1790286ScoredGoals;
    private int w1790286GoalDifference;
    private double w1790286GoalAverage;
    private int w1790286ClubPoints;
    private int w1790286NumOfPlayedMatches;

    public FootballClub(){}

    public FootballClub(String name, String location, int wins, int draws, int defeats, int receivedGoals, int scoredGoals) {
        super(name, location);
        this.w1790286Wins = wins;
        this.w1790286Draws = draws;
        this.w1790286Defeats = defeats;
        this.w1790286ReceivedGoals = receivedGoals;
        this.w1790286ScoredGoals = scoredGoals;
        this.w1790286GoalDifference = scoredGoals - receivedGoals;
        this.w1790286GoalAverage = Math.round(((scoredGoals+0.0) / receivedGoals)*1000)/1000.0;
        this.w1790286ClubPoints = (wins*3 + draws);
        this.w1790286NumOfPlayedMatches = wins + defeats + draws;
    }

    public int getW1790286Wins() {
        return w1790286Wins;
    }

    public void setW1790286Wins(int w1790286Wins) {
        this.w1790286Wins = w1790286Wins;
    }

    public int getW1790286Draws() {
        return w1790286Draws;
    }

    public void setW1790286Draws(int w1790286Draws) {
        this.w1790286Draws = w1790286Draws;
    }

    public int getW1790286Defeats() {
        return w1790286Defeats;
    }

    public void setW1790286Defeats(int w1790286Defeats) {
        this.w1790286Defeats = w1790286Defeats;
    }

    public int getW1790286ReceivedGoals() {
        return w1790286ReceivedGoals;
    }

    public void setW1790286ReceivedGoals(int w1790286ReceivedGoals) {
        this.w1790286ReceivedGoals = w1790286ReceivedGoals;
    }

    public int getW1790286ScoredGoals() {
        return w1790286ScoredGoals;
    }

    public void setW1790286ScoredGoals(int w1790286ScoredGoals) {
        this.w1790286ScoredGoals = w1790286ScoredGoals;
    }

    public int getW1790286GoalDifference() {
        return w1790286GoalDifference;
    }

    public void setW1790286GoalDifference(int w1790286GoalDifference) {
        this.w1790286GoalDifference = w1790286GoalDifference;
    }

    public double getW1790286GoalAverage() {
        return w1790286GoalAverage;
    }

    public void setW1790286GoalAverage(double w1790286GoalAverage) {
        this.w1790286GoalAverage = w1790286GoalAverage;
    }

    public int getW1790286ClubPoints() {
        return w1790286ClubPoints;
    }

    public void setW1790286ClubPoints(int w1790286ClubPoints) {
        this.w1790286ClubPoints = w1790286ClubPoints;
    }

    public int getW1790286NumOfPlayedMatches() {
        return w1790286NumOfPlayedMatches;
    }

    public void setW1790286NumOfPlayedMatches(int w1790286NumOfPlayedMatches) {
        this.w1790286NumOfPlayedMatches = w1790286NumOfPlayedMatches;
    }

    @Override
    public String toString() {//this will display the football club details if a object was displayed
        return "{wins = "+ w1790286Wins +" draws = "+ w1790286Draws +" defeats = "+ w1790286Defeats +" receivedGoals = "+ w1790286ReceivedGoals +
                " scoredGoals = "+ w1790286ScoredGoals + " clubPoints = "+ w1790286ClubPoints +" numOfPlayedMatches = "+ w1790286NumOfPlayedMatches +"}";
    }

    @Override
    public int compareTo(FootballClub fClub) {//this compares two objects at a time from football club
        int pointCompare = fClub.getW1790286ClubPoints() - this.getW1790286ClubPoints();//first it will compare objects with clubPoints field

        if (pointCompare != 0){//  first it will compare objects with clubPoints field
            return pointCompare;
        }
        else {
            return (fClub.getW1790286GoalDifference() - this.getW1790286GoalDifference());
        }
    }
}
