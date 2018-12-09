package ofCourse;

import java.util.ArrayList;
import java.util.Collection;


public class Algorithm {
    private static ArrayList<course> courses;
    private static ArrayList<Section> schedule;
    ArrayList<Schedule> scheduleList;

    /** "Courses" param should only contain courses not in "Schedule" param  */
    /** Schedule passed should already contain user specified section(s) */
    public Algorithm(ArrayList<Section> Schedule, ArrayList<course> Courses){
        courses = Courses;
        schedule = Schedule;
    }



    public Schedule run(){
    	scheduleList = new ArrayList<Schedule>(0);
    	opt(schedule , 0, 0);
    	
    	Schedule optimal = null;
    	for(int i = 0 ; i < scheduleList.size() ; i++) {
    		if(optimal == null) {
    			optimal = scheduleList.get(0);
    		}else {
    			double scoreOptimal = optimal.getScore();
    			double scoreSchedule = scheduleList.get(i).getScore();
    			if(scoreSchedule > scoreOptimal) {
    				optimal = scheduleList.get(i);
    			}
    		}
    	}
    	return optimal;
    }
    
    private void opt(ArrayList<Section> schedule, int courseIndex, double score){
    	if(courseIndex >= courses.size()) {
    		Schedule newSchedule = new Schedule(schedule, score);
    		scheduleList.add(newSchedule);
    		return;
    	}
    	course c = courses.get(courseIndex);
    	ArrayList<Section> courseSections = c.getSections();
    	
    	for(Section s : courseSections) {
    		ArrayList<Section> sched = (ArrayList<Section>) schedule.clone();
    		if(conflicts(s, sched)) {
    			continue;
    		}
    		//sched.add(s);
    		sched.add(s);
    		score = score + s.getRating();
    		opt(sched, courseIndex + 1, score);
    	}
    }

    private boolean conflicts(Section s, ArrayList<Section> schedule){
        for (Section e : schedule) {            // for each section
                if (isConflict(e, s)) {         // If doesn't conflict with course in question
                    return true;                // confirm conflict
                }
        }
        return false;                           // compatible with schedule
    }

    private boolean isConflict(Section s1, Section s2){
        /** Put Day Strings in easily comparable format */
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

        /** -- checking if conflict -- */
        for(int i = 0; i < 6; i++){
        /** if occurse on same day */
            if((days1.charAt(i) == days2.charAt(i))&&(days1.charAt(i) != '.')){
        /** -- Check for overlapping times -- */
                if((Integer.parseInt(s1.getStartTime()) >= Integer.parseInt(s2.getStartTime())) &&
                        (Integer.parseInt(s1.getStartTime()) < Integer.parseInt(s2.getEndTime()))){ return true; }
                if((Integer.parseInt(s1.getEndTime()) > Integer.parseInt(s2.getStartTime())) &&
                        (Integer.parseInt(s1.getEndTime()) <= Integer.parseInt(s2.getEndTime()))){ return true; }
            }
        }
        return false;
    }
}