package OOP;

import java.io.Serializable;

//this class holds the details about the all the clubs in premier league
public class SportsClub implements Serializable {//serializing to save and load as objects

    private String w1790286ClubName;
    private String w1790286ClubLocation;

    public SportsClub() {
    }

    public SportsClub(String name, String location){
        this.w1790286ClubName = name;
        this.w1790286ClubLocation = location;
    }

    public String getW1790286ClubName(){

        return w1790286ClubName;
    }
    public void setW1790286ClubName(String name){

        this.w1790286ClubName = name;
    }
    public String getW1790286ClubLocation(){

        return w1790286ClubLocation;
    }
    public void setW1790286ClubLocation(String location){

        this.w1790286ClubLocation = location;
    }

    @Override
    public String toString() {
        return "SportsClub{ clubName = "+ w1790286ClubName +", clubLocation = "+ w1790286ClubLocation +"}";
    }
}