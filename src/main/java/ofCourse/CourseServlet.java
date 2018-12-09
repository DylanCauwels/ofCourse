package ofCourse;


import static com.googlecode.objectify.ObjectifyService.ofy;

import com.googlecode.objectify.ObjectifyService;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

 

public class CourseServlet extends HttpServlet {
//	private static final Logger _logger = Logger.getLogger(CourseServlet.class.getName());
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//    	String title = req.getParameter("stuff");
    	
//    	String a = "Testing Servlet";
//    	HttpSession session = req.getSession();
//    	session.setAttribute("test", a);
    	DatabaseConnection conn = DatabaseConnection.getInstance();
    	ResultSet result = conn.getDistinctColumnResultSet("prefix");
    	if(result != null) {
            resp.sendRedirect("/courses.jsp?status=true");
            System.out.println(result.toString());
    	} else {
    		resp.sendRedirect("/courses.jsp?status=fail");
    	}
    }
}
