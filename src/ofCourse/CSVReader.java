package ofCourse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.String;
import java.net.URL;
import java.util.LinkedList;
import java.util.Queue;

import com.googlecode.objectify.ObjectifyService;

import Algorithm.Section;

import static com.googlecode.objectify.ObjectifyService.ofy;

public class CSVReader {
    Queue queue = new LinkedList();
    private static final CSVReader singleton = new CSVReader();
    
    public static void main(String[] args) throws FileNotFoundException {
        CSVReader obj = new CSVReader();
        obj.run();
    }

    private CSVReader() {
    	
    }
    
    public int getSize() {return queue.size();}
    public static CSVReader getCSVReader() {
    	return singleton;
    }
    
    public String run() throws FileNotFoundException {

    	ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream input = classLoader.getResourceAsStream("ofCourse/rawData.csv");
        BufferedReader br = null;
        String line = "";
        String[] section = new String[0];
        try {
        	br = new BufferedReader(new InputStreamReader(input));
        	String headerLine = br.readLine();
        	ObjectifyService.register(Algorithm.Section.class);
        	while ((line = br.readLine()) != null) {
        		section = line.split(",");
        		long uniqueId = Long.parseLong(section[0]);
        		String classDays = section[1];
        		String startTime = section[2];
        		String endTime = section[3];
        		String prefix = section[7].replaceAll("\\s+","");
        		String number = section[8];
        		String initial = section[5];
        		String name = section[4];
        		double rating = Double.parseDouble(section[6]);
        		double gpa = Double.parseDouble(section[9]);
	            Section sect = new Section(uniqueId, classDays, startTime, endTime, prefix, number, initial, name, rating, gpa);
	            queue.add(sect);
        	}
        	return "success";
	  } catch (IOException io) {
	  		return io.getMessage();
	  } 
    }
    
    public String inputFifty() {
    	try {
    		for(int i = 0; i < 50; i++) {
        		Section sect = (Section)queue.remove();
        		ofy().save().entity(sect).now();
    		}
    		return "success";
    	} catch (Exception e) {
    		return e.getMessage();
    	}

    }
}
