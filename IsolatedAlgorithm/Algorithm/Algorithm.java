package Algorithm;

import java.util.ArrayList;

public class Algorithm {
    private static ArrayList<course> courses;
    private static ArrayList<Section> schedule;

    /** "Courses" param should only contain courses not in "Schedule" param  */
    /** Schedule passed should already contain user specified section(s) */
    public Algorithm(ArrayList<Section> Schedule, ArrayList<course> Courses){
        courses = Courses;
        schedule = Schedule;
    }

    public ArrayList<Section> run(){
        /** build compatible schedule */
        for(course c: courses){
            for(Section s: c.getSections()){
                if(!conflicts(s)){
                     schedule.add(s);
                     break;
                }
            }
        }
        return schedule;
    }

    private boolean conflicts(Section s){
        for (Section e : schedule) {                            // for each section
            if(isConflict(e, s)){ return true; }
        }
        return false;
    }

    private boolean isConflict(Section s1, Section s2){
        String days1 = s1.getClassDays();
        if(days1.length() == 0){
            days1 = "......";
        }else if(days1.charAt(0) != 'M'){
            days1 = "." + days1;
        }

        if(days1.length() < 2){
            days1 = days1 + ".....";
        }else if((days1.charAt(1) != 'T') && (days1.charAt(1) != '.')){
            days1 = days1.substring(0,1) + "." + days1.substring(1);
        }

        if(days1.length() < 3){
            days1 = days1 + "....";
        }else if((days1.charAt(2) != 'W') && (days1.charAt(2) != '.')){
            days1 = days1.substring(0,2) + "." + days1.substring(2);
        }

        if(days1.length() < 4){
            days1 = days1 + "...";
        }else if((days1.charAt(3) != 'T') && (days1.charAt(3) != '.')){
            days1 = days1.substring(0,3) + ".." + days1.substring(3);
        }

        if(days1.length() < 6){
            days1 = days1 + ".";
        }else if((days1.charAt(5) != 'F') && (days1.charAt(5) != '.')){
            days1 = days1.substring(0,5) + "." + days1.substring(5);
        }

        String days2 = s2.getClassDays();
        if(days2.length() == 0){
            days2 = "......";
        }else if(days2.charAt(0) != 'M'){
            days2 = "." + days2;
        }

        if(days2.length() < 2){
            days2 = days2 + ".....";
        }else if((days2.charAt(1) != 'T') && (days2.charAt(1) != '.')){
            days2 = days2.substring(0,1) + "." + days2.substring(1);
        }

        if(days2.length() < 3){
            days2 = days2 + "....";
        }else if((days2.charAt(2) != 'W') && (days2.charAt(2) != '.')){
            days2 = days2.substring(0,2) + "." + days2.substring(2);
        }

        if(days2.length() < 4){
            days2 = days2 + "...";
        }else if((days2.charAt(3) != 'T') && (days2.charAt(3) != '.')){
            days2 = days2.substring(0,3) + ".." + days2.substring(3);
        }

        if(days2.length() < 6){
            days2 = days2 + ".";
        }else if((days2.charAt(5) != 'F') && (days2.charAt(5) != '.')){
            days2 = days2.substring(0,5) + "." + days2.substring(5);
        }

        for(int i = 0; i < 6; i++){
            if((days1.charAt(i) == days2.charAt(i))&&(days1.charAt(i) != '.')){
                if((Integer.parseInt(s1.getStartTime()) >= Integer.parseInt(s2.getStartTime())) &&
                        (Integer.parseInt(s1.getStartTime()) < Integer.parseInt(s2.getEndTime()))){ return true; }
                if((Integer.parseInt(s1.getEndTime()) > Integer.parseInt(s2.getStartTime())) &&
                        (Integer.parseInt(s1.getEndTime()) <= Integer.parseInt(s2.getEndTime()))){ return true; }
            }
        }
        return false;
    }
}