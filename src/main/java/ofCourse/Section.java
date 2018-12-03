package ofCourse;

import java.util.ArrayList;

public class Section {
	private int uniqueId;
	private ArrayList<Integer> classDay = new ArrayList<Integer>(7);
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
	
	public boolean isConflict(Section otherSection) {//not yet complete, is kind of wrong
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
	
	public void setClassDay(String classDays) {
		for(int i = 0 ; i < this.classDay.size() ; i++) {
			this.classDay.set(i, new Integer(0));
		}
		
		for(int i = 0 ; i < classDays.length() ; i++) {
			if(classDays.charAt(i) == 'M') {
				this.classDay.set(1, new Integer(1));
			}
			
			if(classDays.charAt(i) == 'T') {
				if(classDays.charAt(i + 1) == 'h') {
					this.classDay.set(4, new Integer(1));
				}else {
					this.classDay.set(2, new Integer(1));
				}
			}
			
			if(classDays.charAt(i) == 'W') {
				this.classDay.set(3, new Integer(1));
			}
			
			if(classDays.charAt(i) == 'F') {
				this.classDay.set(5, new Integer(1));
			}
			
		}
	}
}
