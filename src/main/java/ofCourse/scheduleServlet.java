package ofCourse;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class scheduleServlet
 */
@WebServlet("/schedule")
public class scheduleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String[] splited = request.getParameter("courses").split(" ");
			ArrayList<String> input = new ArrayList();
			for(int i = 0; i < (splited.length - 1); i+=2) {
				input.add(splited[i] + " " + splited[i + 1]);
			}
			response.sendRedirect("/schedule.jsp?input=" + request.getParameter("courses"));
		}
		catch (Exception e) {
			response.sendRedirect("/error.html");
		}
	}
}
