package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Professor {
    String lastName;
    String initial;
    ArrayList<String> Sections;

    public Professor(String last, String initial, String sections){
        this.lastName = last;
        this.initial = initial;
        parseSections(sections);
    }

    public String getLastName() {
        return lastName;
    }

    public String getInitial() {
        return initial;
    }

    public ArrayList<String> getSections() {
        return Sections;
    }

    private void parseSections(String sections){
        Sections = new ArrayList(Arrays.asList(sections.split("\\s+")));
    }
}
