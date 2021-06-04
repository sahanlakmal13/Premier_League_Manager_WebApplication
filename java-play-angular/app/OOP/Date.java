package OOP;

import java.io.Serializable;
//this class holds the dates of the played matches
public class Date implements Serializable { //serializing to save and load as objects

    private int w1790286Day;
    private int w1790286Month;
    private int w1790286Year;

    public Date(){}

    public Date(int day, int month, int year) {
        this.w1790286Day = day;
        this.w1790286Month = month;
        this.w1790286Year = year;
    }

    public int getW1790286Day() {
        return w1790286Day;
    }

    public void setW1790286Day(int w1790286Day) {
        this.w1790286Day = w1790286Day;
    }

    public int getW1790286Month() {
        return w1790286Month;
    }

    public void setW1790286Month(int w1790286Month) {
        this.w1790286Month = w1790286Month;
    }

    public int getW1790286Year() {
        return w1790286Year;
    }

    public void setW1790286Year(int w1790286Year) {
        this.w1790286Year = w1790286Year;
    }

    @Override
    public String toString() {
        return "Date - "+ w1790286Day + "/" + w1790286Month + "/" + w1790286Year;
    }//this will display the class fields if a object was displayed
}
