package Algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class course implements Comparable{
    private String name;
    private ArrayList<Section> sections;

    public course(ArrayList<Section> Sections, String courseAbbreviation){
        name = courseAbbreviation;
        sections = Sections;
        Collections.sort(sections);
        System.out.println(sections);
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

    @Override
    public int compareTo(Object o) {
        if(this.sections.get(0).getRating() > ((course)o).getSections().get(0).getRating()){ return 1; }
        else if(this.sections.get(0).getRating() < ((course)o).getSections().get(0).getRating()){ return -1; }
        else { return 0; }
    }
}
