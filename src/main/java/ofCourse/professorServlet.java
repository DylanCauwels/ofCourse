package ofCourse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.CompositeFilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;
import com.googlecode.objectify.ObjectifyService;

import static com.googlecode.objectify.ObjectifyService.ofy;
/**
 * Servlet implementation class professorServlet
 */
@WebServlet("/professors")
public class professorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession();
		ObjectifyService.register(Algorithm.Section.class);
		response.sendRedirect("/professors.jsp?initial=" + request.getParameter("initial") + 
				"&name=" + request.getParameter("name"));
		}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectifyService.register(Algorithm.Section.class);
		Algorithm.Section section = new Algorithm.Section(Long.parseLong(request.getParameter("uniqueId")), request.getParameter("classDays"), request.getParameter("startTime"), 
				request.getParameter("endTime"), request.getParameter("course"), request.getParameter("prefix"), request.getParameter("number"), request.getParameter("initial"), request.getParameter("name"));
		ofy().save().entity(section).now();
		response.sendRedirect("/index.jsp?input=success");
	}
}
