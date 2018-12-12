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

import com.googlecode.objectify.ObjectifyService;

/**
 * Servlet implementation class courseServlet
 */
@WebServlet("/courses")
public class courseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession();
		ObjectifyService.register(Algorithm.Section.class);
		response.sendRedirect("/courses.jsp?prefix=" + request.getParameter("prefix") + 
				"&number=" + request.getParameter("number"));
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       	ObjectifyService.register(Algorithm.Section.class);
		CSVReader read = new CSVReader();
		String result = read.run();
		if(result == "success") {
			List<Algorithm.Section> sections = ObjectifyService.ofy().load().type(Algorithm.Section.class).list();
			response.sendRedirect("/index.jsp?populate=success&size=@");
		} else {
			response.sendRedirect("/index.jsp?fail=" + result);
		}
	}


}
