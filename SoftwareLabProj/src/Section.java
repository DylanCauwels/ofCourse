import java.util.ArrayList;
public class Section {
	private int uniqueId;
	private ArrayList<String> classDay;
	private String startTime;
	private String endTime;
	private boolean waitlisted;
	private boolean open;
	
	public Section(int uniqueId, ArrayList<String> classDay,String startTime, String endTime, boolean waitlisted, boolean open){
		this.uniqueId = uniqueId;
		this.classDay = classDay;
		this.startTime = startTime;
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
}
