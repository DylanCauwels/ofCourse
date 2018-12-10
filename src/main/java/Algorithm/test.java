package Algorithm;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class test {
    public static void main(String[] args){
//        ArrayList<String> courses = new ArrayList<String>();
//        ArrayList<Section> Sections = new ArrayList<Section>();
//        courses.add("EE 312");
//        courses.add("EE 313");
//        userPreferences prefs = new userPreferences(courses, 6);
//        Query query = new Query(prefs);
//        try {
//            ArrayList<String> sections = query.getCourseSections("EE 312");
//            for (String s : sections) {
//                Sections.add(query.makeSection(s));
//            }
//            ArrayList<Professor> profs = query.searchProfessors("EBERLEIN");
//            //System.out.println("It seems to have worked!");
//        } catch(InterruptedException | ExecutionException e){ System.out.println("Error returning query"); }
        ArrayList<String> courses = new ArrayList<String>();
        courses.add("EE 312");
        courses.add("EE 313");
        courses.add("EE 422C");
        Algorithm alg1 = new Algorithm(courses);
        Schedule schedule = alg1.run();
        System.out.println(schedule.getCourses());
    }
}
