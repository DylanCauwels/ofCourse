package ofCourse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.String;
import java.net.URL;

import com.googlecode.objectify.ObjectifyService;

import Algorithm.Section;

import static com.googlecode.objectify.ObjectifyService.ofy;

public class CSVReader {

    public static void main(String[] args) throws FileNotFoundException {
        CSVReader obj = new CSVReader();
        obj.run();
    }

    public String run() throws FileNotFoundException {
    	File file = new File("rawData.csv");
//    	String csv = file.getAbsolutePath();
//    	URL url = getClass().getResource("rawData.csv");
//    	String csv = url.toString();
    	String csv = System.getProperty("user.dir") + "/src/main/java/ofCourse/rawData.csv";
//    	/Users/dylancauwels/Documents/GitHub Repo's/ofCourse/src/main/java/ofCourse/rawData.csv
    	
//        FileInputStream csv = new FileInputStream(System.getProperty("user.dir") + ("/src/main/java/ofCourse/rawData.csv"));
//        FileDescriptor cs = csv.getFD();
        BufferedReader br = null;
        String line = "";
        String csvSplit = ",";
        String[] football = new String[0];
        try {
            br = new BufferedReader(new FileReader(csv));
            String headerLine = br.readLine();
            ObjectifyService.register(Algorithm.Section.class);
            while ((line = br.readLine()) != null) {
                football = line.split(csvSplit);
                long uniqueId = 0;
                String classDays = "";
                String startTime = "";
                String endTime = "";
                String prefix = "";
                String number = "";
                String initial = "";
                String name = "";
                double rating = 0;
                double gpa = 0;
                for(int i = 0; i < 10; i++) {
                    if (i == 0)
                    {
                        uniqueId = Long.parseLong(football[i]);
                    }
                    else if (i == 1)
                    {
                        classDays = football[i];
                    }
                    else if (i == 2)
                    {
                        startTime = football[i];
                    }
                    else if (i == 3)
                    {
                        endTime = football[i];
                    }
                    else if (i == 4)
                    {
                        name = football[i];
                    }
                    else if (i == 5)
                    {
                        initial = football[i];
                    }
                    else if (i == 6)
                    {
                        rating = Double.parseDouble(football[i]);
                    }
                    else if (i == 7)
                    {
                        prefix = football[i].replaceAll("\\s+","");
                    }
                    else if (i == 8)
                    {
                        number = football[i];
                    }
                    else if (i == 9)
                    {
                        gpa = Double.parseDouble(football[i]);
                    }
                }
                Section sect = new Section(uniqueId, classDays, startTime, endTime, prefix, number, initial, name, rating, gpa);
//                Section sect = new Section(11050, "MWF", "10000", "1100", "EE", "522C", "M", "Boy", 2.5, 6.9);
                ofy().save().entity(sect).now();
            }
            return "success";
        }
        catch (IOException io) {
            return io.getMessage();
        }
    }
}
