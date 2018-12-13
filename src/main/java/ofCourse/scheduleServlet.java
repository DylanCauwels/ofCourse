package ofCourse;

import java.io.IOException;
import java.util.ArrayList;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Algorithm.Algorithm;
import Algorithm.AlgorithmTest;
import Algorithm.Schedule;
import Algorithm.Section;

/**
 * Servlet implementation class scheduleServlet
 */
@WebServlet("/schedule")
public class scheduleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private ArrayList<Section> courses;  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession();
		if(request.getParameter("courses") == null) {
			response.sendRedirect("/schedule.jsp?input=invalid");
		}
		String[] splited = request.getParameter("courses").split(" ");
		ArrayList<String> input = new ArrayList();
		for(int i = 0; i < (splited.length - 1); i+=2) {
			input.add(splited[i] + " " + splited[i + 1]);
		}
		try {
			Algorithm alg = new Algorithm(input);
			Schedule sched = alg.run();
			courses = sched.getCourses();
			sess.setAttribute("courses", courses);
			response.sendRedirect("/schedule.jsp?status=success&sched=" + sched.toString());			
		} catch (Exception e) {
			response.sendRedirect("/schedule.jsp?status=failure");			
		}

	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Main main = new Main();
		main.testGetCalendarTime();
		response.sendRedirect("/schedule.jsp?test");
	}
}
