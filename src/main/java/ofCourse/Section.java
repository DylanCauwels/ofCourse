package ofCourse;

import java.util.ArrayList;

public class Section {
	private int uniqueId;
	private ArrayList<String> classDay;
	private String startTime;
	private String startAMPM;
	private String endTime;
	private String endAMPM;
	private boolean waitlisted;
	private boolean open;
	
	public Section(int uniqueId, ArrayList<String> classDay,String startTime, String endTime, boolean waitlisted, boolean open){
		String[] startTimeValues = startTime.split(" ");
		String[] endTimeValues = endTime.split(" ");
		this.uniqueId = uniqueId;
		this.classDay = classDay;
		this.startTime = startTimeValues[0];
		this.startAMPM = startTimeValues[1];
		this.endTime = endTimeValues[0];
		this.endAMPM = endTimeValues[1];
		this.endTime = endTime;
		this.waitlisted = waitlisted;
		this.open = open;
	}
	
	public void setWaitlist(boolean value) {
		this.waitlisted = value;
	}
	
	public void setOpen(boolean open) {
		this.open = open;
	}
	
	public boolean isConflict(Section otherSection) {
		String[] startOne = startTime.split(":");
		String[] startTwo = otherSection.startTime.split(":");
		int startOneHour = Integer.parseInt(startOne[0]);
		int startOneMin = Integer.parseInt(startOne[1]);
		int startTwoHour = Integer.parseInt(startTwo[0]);
		int startTwoMin = Integer.parseInt(startTwo[1]);
		
		if((startOneHour == startTwoHour) && (startOneMin == startTwoMin) && (startAMPM == endAMPM)) {
			return true;
		}
		
		if(startOneHour == 12) {	//assumes classes ends at :00 or :30 at a hour
			if(startOneMin == 0) {
				
			}else if(startOneMin == 30) {
				
			}
		}
		if(Integer.parseInt(startOne[0]) < 12) {
			
		}
		
		return false;
	}
}
