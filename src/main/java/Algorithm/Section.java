
package Algorithm;

import java.io.File;
import java.io.FileOutputStream;
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
    private String course;
    @Index private String prefix;    //course prefix
    @Index private String number;    //course number
    @Index private double rating;    //course rmp rating
    private String path = "/schedule_events/";
    @Index private String gpa;	     //course gpa average
    @Index private String initial;   //instructor first initial
    @Index private String name;		 //instructor last name

    public Section(long uniqueId, String classDays, String startTime, String endTime, String course, String prefix, String number, String initial, String name){
        this.uniqueId = uniqueId;
        this.classDays = classDays;
        this.startTime = startTime;
        this.endTime = endTime;
        this.course = course;
        this.prefix = prefix;
        this.number = number;
        this.initial = initial;
        this.name = name;
    }

    private Section() {}

    public String getUnique() {return Long.toString(uniqueId);}
    public String getGPA() {return gpa;}
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

    public String getLastName() {
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
           String contentName = "content" + ".txt";
           File fileContent = new File(path + contentName);

           if (fileContent.createNewFile())
           {
               System.out.println("File c is created!");
           } else {
               System.out.println("File c already exists.");
           }

           //Write Content
           FileOutputStream writer = new FileOutputStream(fileContent);
           writer.write(idString.getBytes());
           writer.flush();
           writer.close();


           String fileName = idString + ".txt";
           File file = new File(path + fileName);


           if (file.createNewFile())
           {
               System.out.println("File is created!");
           } else {
               System.out.println("File already exists.");
           }

           //Write Content
           FileOutputStream writer1 = new FileOutputStream(fileName);
           writer1.flush();
           writer1.close();
       }catch(Exception e){
           System.out.print(e);
       }
    }

    public void clearSchedule(){
        try {
            FileOutputStream writer = new FileOutputStream("content.txt");
            writer.flush();
            writer.close();
        } catch (Exception e) {
        	
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