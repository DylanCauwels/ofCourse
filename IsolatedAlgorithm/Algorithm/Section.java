package Algorithm;

import java.util.ArrayList;

public class Section {
    private int uniqueId;
    private String classDays;
    private String startTime;
    private String endTime;
    private boolean waitlisted;
    private boolean open;

    public Section(int uniqueId, String classDays, String startTime, String endTime, boolean waitlisted, boolean open){
        this.uniqueId = uniqueId;
        this.waitlisted = waitlisted;
        this.open = open;
        this.classDays = classDays;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /** Getters Only, public should never have access to setting */
    public String getClassDays(){
        return classDays;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public boolean isOpen() {
        return open;
    }

    public boolean isWaitlisted() {
        return waitlisted;
    }
}
