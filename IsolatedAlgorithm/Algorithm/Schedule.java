package Algorithm;

import java.util.ArrayList;

public class Schedule {
	ArrayList<Section> courses;
	double score; 
	
	public Schedule() {
		courses = new ArrayList<Section>(0);
		score = 0;
	}
	
	public void addScore(double value) {
		score += value;
	}
	
	public double getScore() {
		return score;
	}

}
