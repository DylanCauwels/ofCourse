package ofCourse;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class SectionTest {

	@Test
	public void testClassDay() {
		String classDay = "MW";
		ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(0, 1, 0, 1, 0, 0, 0));
		LegacySection newSection = new LegacySection(1 ,"", "", "", true, true);
		newSection.setClassDay(classDay);
		
		ArrayList<Integer> actual = newSection.getClassDay();
		
		assertEquals(actual, expected);
		
	   }

}
