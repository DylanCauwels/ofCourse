import java.util.ArrayList;

public class Schedule {
	private ArrayList<Section> courses = new ArrayList<Section>();
	
	Schedule(){
		
	}
	
	ArrayList<Section> getCourses(){
		return courses;
	}
	
	void addSection(Section newSection) {
		for(Section courseSection : courses) {
			
		}
		courses.add(newSection);
	}
	
	void removeSection(Section oldSection) {
		courses.remove(oldSection);
	}
}
