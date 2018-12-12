package ofCourse;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Algorithm.Algorithm;
import Algorithm.Schedule;

/**
 * Servlet implementation class scheduleServlet
 */
@WebServlet("/schedule")
public class scheduleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String[] splited = request.getParameter("courses").split(" ");
//		ArrayList<String> input = new ArrayList();
//		for(int i = 0; i < (splited.length - 1); i+=2) {
//			input.add(splited[i] + " " + splited[i + 1]);
//		}
//		Algorithm alg = new Algorithm(input);
//		Schedule sched = alg.run();
		Main main = new Main();
		main.testGetCalendarTime();
//		if(sched != null) {
//			response.sendRedirect("/schedule.jsp?status=success");
//		} else {
//			response.sendRedirect("/schedule.jsp?status=fail");			
//		}
		response.sendRedirect("/schedule.jsp");
	}
}
