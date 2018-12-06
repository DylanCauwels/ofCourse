package Algorithm;

import java.util.ArrayList;

public class Algorithm {
    private static ArrayList<course> courses;
    private static ArrayList<Section> schedule;
    private static int[][] TimeSchedule;

    /** "Courses" param should only contain courses not in "Schedule" param  */
    /** Schedule passed should already contain user specified section(s) */
    public Algorithm(ArrayList<Section> Schedule, ArrayList<course> Courses){
        courses = Courses;
        schedule = Schedule;
        TimeSchedule = new int[7][92];
    }

    public ArrayList<Section> run(){
        /** mark time schedule with user specified section times */
        if(!schedule.isEmpty()) {
            for(Section e : schedule) {
                // TODO write schedule time method
            }
        }

        /** build compatible schedule */
        for(course c: courses){
            for(Section s: c.getSections()){
                //TODO figure out how to get day
                if(conflicts(s)){ c.getSections().remove(s); }  // if a section is already scheduled for same time slot
                else{
                    schedule.add(s);    // TODO: this currently adds first non-conflicting section. Make optimal
                    break;
                }
            }
        }
        return schedule;
    }

    private boolean conflicts(int day, int start, int end){
        for(int i = start; i < end; i++){
            if(TimeSchedule[day][i] == 1){ return true; }
        }
        return false;
    }
}