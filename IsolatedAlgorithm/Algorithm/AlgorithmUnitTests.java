package Algorithm;

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
        Section s1 = new Section(13524, classDays, Start, End, false, true);
        Sec1.add(s1);
        course c1 = new course(Sec1, "EE312");
        Start = "1030";   // mw start 10:30am
        End = "1200";     // mw end 12pm
        Section s2 = new Section(13565, classDays, Start, End, false, true);
        Sec2.add(s2);
        course c2 = new course(Sec2, "EE313");
        Start = "1300";   // mw start 1pm
        End = "1430";     // mw end 2:30pm
        Section s3 = new Section(13700, classDays, Start, End, false, true);    // mw 1-2:30 and tth 2-3
        Sec3.add(s3);
        course c3 = new course(Sec3, "EE360C");
        Start = "1500";   // mw start 3pm
        End = "1630";     // mw end 4pm
        Section s4 = new Section(14000, classDays, Start, End, false, true);    // mw 3-4:30 and tth 1-2
        Sec4.add(s4);
        course c4 = new course(Sec4, "EE312");

        ArrayList<course> courses = new ArrayList<course>();
        courses.add(c1);
        courses.add(c2);
        courses.add(c3);
        courses.add(c4);

        ArrayList<Section> schedule = new ArrayList<Section>();








        //-----------------------------------------------------------------------------
        Algorithm a1 = new Algorithm(schedule, courses);
        schedule = a1.run();
        assertTrue(schedule.contains(courses.get(0).getSections().get(0)) &&
                schedule.contains(courses.get(1).getSections().get(0))
                && schedule.contains(courses.get(2).getSections().get(0))
                && schedule.contains(courses.get(3).getSections().get(0)));
    }
}