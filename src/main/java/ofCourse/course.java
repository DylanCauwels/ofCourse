package ofCourse;

import java.util.ArrayList;

public class course {
    private String name;
    private ArrayList<Section> sections;

    public course(ArrayList<Section> Sections, String courseAbbreviation){
        name = courseAbbreviation;
        sections = Sections;
    }

    public String getName(){
        return name;
    }

    public ArrayList<Section> getSections(){
        return sections;
    }

    public void removeSection(Section remove){
        if(sections.contains(remove)){
            sections.remove(remove);
        } else {
            System.out.println("Algorithm.course.java.removeSection:\n-Trying to remove a section not in list");
        }
    }
}
