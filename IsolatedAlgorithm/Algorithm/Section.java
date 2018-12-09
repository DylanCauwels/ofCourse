package Algorithm;

import java.util.ArrayList;
import java.util.Random;

public class Section implements Comparable{
    private int uniqueId;
    private String classDays;
    private String startTime;
    private String endTime;
    private boolean waitlisted;
    private boolean open;
    private double rating;

    public Section(int uniqueId, String classDays, String startTime, String endTime, boolean waitlisted, boolean open, double Rating){
        this.uniqueId = uniqueId;
        this.waitlisted = waitlisted;
        this.open = open;
        this.classDays = classDays;
        this.startTime = startTime;
        this.endTime = endTime;
        this.rating = Rating;
    }

    public void setRating(double d){
        rating = d;
    }

    public double getRating(){
        return rating;
    }

    public String getClassDays(){
        return classDays;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String time){ startTime = time; }

    public String getEndTime() { return endTime; }

    public void setEndTime(String time){ endTime = time; }

    public boolean isOpen() {
        return open;
    }

    public boolean isWaitlisted() {
        return waitlisted;
    }

    @Override
    public int compareTo(Object o) {
        double temp = this.rating - ((Section)o).getRating();
        if(temp > 0){ return 1; }           // this > s2
        else if(temp < 0){ return -1; }     // this < s2
        else { return 0; }                  // this == s2
    }

    @Override
    public String toString(){
        return (uniqueId + " on days: " + classDays + " Start: " + startTime + "End: " + endTime);
    }
}
