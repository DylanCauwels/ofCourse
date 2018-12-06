package Algorithm;

import java.util.ArrayList;

public class Section {
    private int uniqueId;
    private int[][] classTime;
    private boolean waitlisted;
    private boolean open;

    public Section(int uniqueId, ArrayList<String> classDay, ArrayList<String> startTime, ArrayList<String> endTime, boolean waitlisted, boolean open){
        this.uniqueId = uniqueId;
        this.waitlisted = waitlisted;
        this.open = open;
        this.classTime = new int[7][92];

    }

    /** Converts Strings into int matrix days x time */
    private void setClassTime(ArrayList<String> days, ArrayList<String> start, ArrayList<String> end){
        for (int i = 0; i < days.size(); i++) {
            switch(days.get(i)){


            }
        }
    }

    private int timeToInt(String time, String AMPM){
        int hour = 0;
        int minute = 0;

        /** turn time into integers */
        for(int i = 0; i < time.length(); i++){
            if(time.charAt(i) == 58){
                hour = Integer.parseInt(time.substring(0, i));
                minute = Integer.parseInt(time.substring(i+1));
                break;
            }
        }

        switch(minute){
            case 0: minute = 0;
                break;
            case 15: minute = 1;
                break;
            case 30: minute = 2;
                break;
            case 45: minute = 3;
                break;
            default: System.out.println("minutes incorrectly parsed @ Algorithm.timeToInt");
                break;
        }

        /** turn time into index to populate time slots */
        int Time = (hour % 12) + minute;
        if(AMPM.equals("PM")){ Time +=  45; }
        return Time;
    }
}
