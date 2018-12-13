package Algorithm;

import com.google.appengine.api.datastore.*;
import com.google.auth.oauth2.GoogleCredentials;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;


public class Query {

    private userPreferences prefs;      //
    ArrayList<course> courses;          // desired courses


    public Query(){}

    //input prefix and number (EE 313, EE 422C, etc.)
    //output ArrayList of unique numbers corresponding to sections
    public ArrayList<String> getCourseSections(String abbreviation) throws java.lang.InterruptedException, java.util.concurrent.ExecutionException {
        ArrayList<String> sections = new ArrayList<String>();
        ObjectifyService.register(Section.class);
		List<Section> courses = ObjectifyService.ofy().load().type(Section.class)
				.filter("course", abbreviation)
				.list();
		for(Section sect: courses) {
			sections.add(sect.getUnique());
		}
        return sections;
    }

    public Section makeSection(String section) throws java.lang.InterruptedException, java.util.concurrent.ExecutionException{
        //unique number 
    	//output the Section
        ObjectifyService.register(Section.class);      
        Map<Long, Section> courses = ObjectifyService.ofy().load()
        		.type(Section.class)
        		.ids(Long.parseLong(section));
		return courses.get(Long.parseLong(section));
    }
}
