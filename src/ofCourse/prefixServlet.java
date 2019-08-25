package ofCourse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.googlecode.objectify.ObjectifyService;

/**
 * Servlet implementation class prefixServlet
 */
@WebServlet("/prefixes")
public class prefixServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Set<String> prefixes;
	Set<String> numbers;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession();
		List<Algorithm.Section> sections;
		ObjectifyService.register(Algorithm.Section.class);
		sections = ObjectifyService.ofy().load().type(Algorithm.Section.class).list();
		
		//instantiating HashSets
		prefixes = new HashSet<String>();
		numbers = new HashSet<String>();
		//installing data in unique-driven hashset
		for(int i = 0; i < sections.size(); i++) {
			prefixes.add(sections.get(i).getPrefix()); 
			numbers.add(sections.get(i).getNumber()); 
		}
		//removing any accidental null values
		prefixes.remove(null);
		numbers.remove(null);
		//setting session attributes
		sess.setAttribute("prefixes", prefixes);
		sess.setAttribute("numbers", numbers);
		response.sendRedirect("/courses.jsp?prefixes=set");	
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CSVReader read = CSVReader.getCSVReader();
		String result = read.inputFifty();
		response.sendRedirect("index.jsp?val=" + result);
	}
}
