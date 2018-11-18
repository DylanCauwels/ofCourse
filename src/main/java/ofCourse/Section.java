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
		String[] timeOne = startTime.split(":");
		String[] timeTwo = otherSection.startTime.split(":");
		int startOne = Integer.parseInt(timeOne[0]);
		int endOne = Integer.parseInt(timeOne[1]);
		int startTwo = Integer.parseInt(timeTwo[0]);
		int endTwo = Integer.parseInt(timeTwo[1]);
		
		if((startOne == startTwo) && (startOne == endTwo) && (startAMPM == endAMPM)) {
			return true;
		}
		
		if(startOne == 12) {	//assumes classes ends at :00 or :30 at a hour
			if(endOne == 0) {
				
			}else if(endOne == 30) {
				
			}
		}
		if(Integer.parseInt(timeOne[0]) < 12) {
			
		}
		
		return false;
	}
}
