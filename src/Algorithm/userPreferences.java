package Algorithm;

import java.util.ArrayList;

public class userPreferences {
    private ArrayList<String> desiredCourses;
    private int slider;     // 1-10   professorRating <---------|----> gradeDistribution

    public userPreferences(ArrayList<String> Courses, int slider){
        this.slider = slider;
        this.desiredCourses = Courses;
    }

    public int getSlider() {
        return slider;
    }

    public ArrayList<String> getDesiredCourses() {
        return desiredCourses;
    }
}
