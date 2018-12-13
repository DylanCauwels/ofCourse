package Algorithm;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class AlgorithmTest {
    public static void main(String[] args){
        ArrayList<String> courses = new ArrayList<String>();
        courses.add("EE 312");
        courses.add("EE 313");
        courses.add("EE 422C");
        Algorithm alg1 = new Algorithm(courses);
        Schedule schedule = alg1.run();
        System.out.println(schedule.getCourses());
    }
    
    public String runTest(){
        ArrayList<String> courses = new ArrayList<String>();
        courses.add("EE 312");
        courses.add("EE 313");
        courses.add("EE 422C");
        Algorithm alg1 = new Algorithm(courses);
        Schedule schedule = alg1.run();
        return schedule.toString();
    }
}
