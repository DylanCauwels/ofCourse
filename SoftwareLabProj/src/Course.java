import java.util.ArrayList;
public class Course {
	String courseName;
	String courseNumber;
	ArrayList<Section> sections;
	
	public Course(String courseName, String courseNumber){
		this.courseName = courseName;
		this.courseNumber= courseNumber;
	}
}
