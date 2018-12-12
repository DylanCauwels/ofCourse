
package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Parent;


@Entity
public class Section implements Comparable{
    @Id private long uniqueId;
    private String classDays; //days the class meets
    private String startTime; //time lecture starts
    private String endTime; 	 //time lecture ends
    @Index private String course;
    @Index private String prefix;    //course prefix
    @Index private String number;    //course number
    @Index private double rating;    //course rmp rating
    private static String coursePath = "src/main/webapp/schedule_events/";
    @Index private double gpa;	     //course gpa average
    @Index private String initial;   //instructor first initial
    @Index private String name;		 //instructor last name

    public Section(long uniqueId, String classDays, String startTime, String endTime, String prefix, String number, String initial, String name, double rating, double gpa){
        this.uniqueId = uniqueId;
        this.classDays = classDays;
        this.startTime = startTime;
        this.endTime = endTime;
        course = prefix + " " + number;
        this.prefix = prefix;
        this.number = number;
        this.initial = initial;
        this.name = name;
        this.rating = rating;
        this.gpa = gpa;
    }

    private Section() {
        this.uniqueId = 00001;
        this.classDays = "SS";
        this.startTime = "200";
        this.endTime = "300";
        this.prefix = "SkE";
        this.number = "311";
        course = prefix + " " + number;
        this.initial = "M";
        this.name = "Boy";
        this.rating = 0.1;
        this.gpa = 0.1;
    }

    public String getUnique() {
    	return Long.toString(uniqueId);}
    public String getGPA() {return Double.toString(gpa);}

    public String getRMP() {return Double.toString(rating);}
    public void setRating(double d){
        rating = d;
    }

    public double getRating(){
        return rating;
    }

    public String getClassDays(){
        return classDays;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String time){ startTime = time; }

    public String getInitial() {
    	return initial;
    }

    public String getName() {
    	return name;
    }

    public String getPrefix() {
    	return prefix;
    }

    public String getNumber() {
    	return number;
    }
    public void getCalendarTime() {
        String idString = Long.toString(uniqueId);
        while(idString.length() < 5){
            idString = "0" + idString;
        }


        String text = "";

        text = text.concat( "{ \"events\" : [ \n");

        if((startTime.length() < 4)) {
            startTime = "0" + startTime;
        }

        if((endTime.length() < 4)) {
            endTime = "0" + endTime;
        }

        for(int i = 0 ; i < classDays.length() ; i ++) {

            String dayStart = "";
            String timeStart = "";

            String dayEnd = "";
            String timeEnd = "";


            dayStart = dayString(i);
            timeStart = timeString(startTime);

            dayEnd = dayString(i);
            timeEnd = timeString(endTime);



            text += "{ \"title\":\"" + course + "\" , \"start\":\"2018-01-0"  + dayStart + "T" + timeStart +   "\", \"end\":\"2018-01-0"  + dayEnd + "T" + timeEnd + "\"},\n";
            //System.out.println(text);

            if(classDays.charAt(i) == 'T') {
                if(i < (classDays.length() - 1)) {
                    if(classDays.charAt(i + 1) == 'H') {
                        i++;
                    }
                }
            }

        }

        text = text.substring(0, text.length() - 2) +  "\n]}";

//        return text;


    	try{
//    		File dir = new File(coursePath);
//    		if(dir.createNewFile()){
//                System.out.println(coursePath+" File Created");
//            }else System.out.println("File "+coursePath+" already exists");


    		String filePath = idString + ".txt";
    		File file = new File(coursePath + filePath);
//    		try {
//    			BufferedWriter output = new BufferedWriter(new FileWriter(file));
//                output.write(text);
//                output.close();
//    		}catch(Exception e) {
//    			System.out.println(e);

//    		}
    		if(file.createNewFile()){
                System.out.println(filePath+"  Created");
            }else {
            	System.out.println(filePath+" already exists");
            }

//    		String fileName = idString + ".txt";
//
    		FileOutputStream fos = new FileOutputStream(coursePath + filePath);
    		fos.write(text.getBytes());
    		fos.flush();
    		fos.close();

    		String fileContentPath = "contents.txt";
    		File fileContent = new File(coursePath + fileContentPath);

    		if(fileContent.createNewFile()){
                System.out.println(fileContentPath +" Created");
            }else {
            	System.out.println("File "+ fileContentPath +" already exists");
            }

    		BufferedReader br = new BufferedReader(new FileReader(coursePath + fileContentPath));
    		boolean contained = false;


    		while(br.ready()) {
    			String line = br.readLine();
    			if(line.contains(idString)) {
    				contained = true;
    			}
    		}


    		if(!contained) {
    			BufferedWriter out = new BufferedWriter(new FileWriter(coursePath + fileContentPath, true));
    			out.write(idString + "\n");
                out.close();
    		}


    	}catch(Exception e) {
    		System.out.println("1" +e);
    	}
    }

    public static void clearSchedule(){
    	File dir = new File(coursePath);

		if(!dir.exists()) {
			try{
				dir.mkdir();
			}catch(Exception e) {
				System.out.println("directory failed to make");

			}
		}

		String fileContentPath = "contents.txt";
		File fileContent = new File(coursePath + fileContentPath);

		try{
			if(fileContent.createNewFile()){
				System.out.println(fileContentPath +" File Created");
			}else {
				System.out.println("File " + fileContentPath + " already exists");
			}

			BufferedWriter out = new BufferedWriter(new FileWriter(coursePath + fileContentPath));
			out.write("");
            out.close();


		}catch(Exception e) {
			System.out.println("2" + e);
		}
    }

    public String dayString(int i) {
        String day = "";
        if(classDays.charAt(i) == 'M') {
            day = "1";
        }else if(classDays.charAt(i) == 'T') {
            if(i < (classDays.length() - 1)) {
                if(classDays.charAt(i + 1) == 'H') {
                    day = "4";
                }else {
                    day = "2";
                }
            }else {
                day = "2";
            }
        }else if(classDays.charAt(i) == 'W') {
            day = "3";
        }else if(classDays.charAt(i) == 'F') {
            day = "5";
        }

        return day;
    }

    public String timeString(String classTime) {
        String time = "";
        time = classTime.substring(0, 2) + ":" + classTime.substring(2,4) + ":00";
        return time;
    }

    public String getEndTime() { return endTime; }

    public void setEndTime(String time){ endTime = time; }

    public String getCourse() { return course; }

    @Override
    public int compareTo(Object o) {
        double temp = this.rating - ((Section)o).getRating();
        if(temp > 0){ return 1; }           // this > s2
        else if(temp < 0){ return -1; }     // this < s2
        else { return 0; }                  // this == s2
    }

    @Override
    public String toString(){
        return (uniqueId + " on days: " + classDays + " Start: " + startTime + "End: " + endTime);
    }
}
