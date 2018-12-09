package ofCourse;

import junit.framework.TestCase;

import java.util.ArrayList;

public class AlgorithmUnitTests extends TestCase {
    public void test(){
        String classDays;
        String Start;
        String End;
        classDays = "MW";
        Start = "900";   // mw start 9am
        End = "1030";    // mw end 10:30am
        ArrayList<Section> Sec1 = new ArrayList<Section>();
        ArrayList<Section> Sec2 = new ArrayList<Section>();
        ArrayList<Section> Sec3 = new ArrayList<Section>();
        ArrayList<Section> Sec4 = new ArrayList<Section>();

        /** first test case ensures classes are being properly added to schedule
         *  only 4 courses with one section each and no conflicts */
        Section s1 = new Section(13524, classDays, Start, End, false, true, 2.0);
        Sec1.add(s1);

        Start = "1030";   // mw start 10:30am
        End = "1200";     // mw end 12pm
        Section s2 = new Section(13565, classDays, Start, End, false, true, 3.0);
        Sec2.add(s2);

        Start = "1300";   // mw start 1pm
        End = "1430";     // mw end 2:30pm
        Section s3 = new Section(13700, classDays, Start, End, false, true, 2.5);    // mw 1-2:30 and tth 2-3
        Sec3.add(s3);

        Start = "1500";   // mw start 3pm
        End = "1630";     // mw end 4pm
        Section s4 = new Section(14000, classDays, Start, End, false, true, 5.0);    // mw 3-4:30 and tth 1-2
        Sec4.add(s4);

        Start = "1230";   // mw start 12:30am
        End = "1400";     // mw end 2pm
        Section s5 = new Section(13665, classDays, Start, End, false, true, 3.6);
        Sec1.add(s5);

        Start = "1000";   // mw start 10:00
        End = "1130";     // mw end 11:30pm
        Section s6 = new Section(14785, classDays, Start, End, false, true, 4.5);
        Sec1.add(s6);

        Start = "1030";   // mw start 10:30am
        End = "1200";     // mw end 12pm
        Section s7 = new Section(16690, classDays, Start, End, false, true, 3.4);
        Sec2.add(s7);

        Start = "800";   // mw start 8:00am
        End = "930";     // mw end 9:30pm
        Section s8 = new Section(17800, classDays, Start, End, false, true, 2.9);
        Sec2.add(s8);

        course c1 = new course(Sec1, "EE312");
        course c2 = new course(Sec2, "EE313");
        course c3 = new course(Sec3, "EE360C");
        course c4 = new course(Sec4, "EE351K");

        ArrayList<course> courses = new ArrayList<course>();
        courses.add(c1);
        courses.add(c2);
        courses.add(c3);
        courses.add(c4);

        //Schedule schedules = new ArrayList<ArrayList<Section>>();
        ArrayList<Section> schedule = new ArrayList<Section>();
        //-------------------------------Test#1---------------------------------
        Algorithm a1 = new Algorithm(schedule, courses);
        Schedule schedules = a1.run();
        ArrayList<Section> s = schedules.getCoures();
        
        for(Section sec : s){
            System.out.println(s);
        }
        
        assertTrue(s.size() == 4);

        //-------------------------------Test#2---------------------------------

    }

//    public void test2(){
//        String classDays;
//        String Start;
//        String End;
//        classDays = "MW";
//        Start = "900";   // mw start 9am
//        End = "1030";    // mw end 10:30am
//        Section s1 = new Section(13524, classDays, Start, End, false, true);
//    }

}