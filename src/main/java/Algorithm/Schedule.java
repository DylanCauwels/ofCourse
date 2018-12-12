package Algorithm;

import java.util.ArrayList;

public class Schedule {
    ArrayList<Section> courses;
    double score;

    public Schedule(ArrayList<Section> courses, double score) {
        this.courses = courses;
        this.score = score;
    }

    public ArrayList<Section> getCourses(){
        return courses;
    }

    public void addScore(double value) {
        score += value;
    }

    public double getScore() {
        return score;
    }
    public void updateText() {
    	Section.clearSchedule();
    	for(Section sec : courses) {
    		sec.getCalendarTime();
    	}
    }
}
