package ofCourse;
import java.io.IOException;

import java.util.ArrayList;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.googlecode.objectify.ObjectifyService;
import static com.googlecode.objectify.ObjectifyService.ofy;

import Algorithm.Section;
import java.util.*;

/**
 * Servlet implementation class nameServlet
 */
@WebServlet("/names")
public class nameServlet extends HttpServlet {
	private Set<String> initials;
	private Set<String> names;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession();
		List<Algorithm.Section> sections;
		ObjectifyService.register(Algorithm.Section.class);
		sections = ObjectifyService.ofy().load().type(Algorithm.Section.class).list();
		
		//instantiating HashSets
		initials = new HashSet<String>();
		names = new HashSet<String>();
		//installing data in unique-driven hashset
		for(int i = 0; i < sections.size(); i++) {
			initials.add(sections.get(i).getInitial()); 
			names.add(sections.get(i).getName()); 
		}
		//removing any accidental null values
		names.remove(null);
		initials.remove(null);
		//setting session attributes
		sess.setAttribute("initials", initials);
		sess.setAttribute("names", names);
		response.sendRedirect("/professors.jsp?names=set");	
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Section sect = new Section(00000, "MWF", "1000", "1100", "EE", "314", "M", "Ebby", 1.2, 3.4);
//		String result = sect.clearSchedule();
		response.sendRedirect("schedule.jsp/path=" + "testMutedCurrently");
	}
}



