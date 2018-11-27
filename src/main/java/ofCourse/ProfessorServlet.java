package ofCourse;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ofCourse.Professor;

public class ProfessorServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Professor prof = new Professor("test");
		resp.sendRedirect("/index.jsp?test=" + prof.testServlet());	
	}
}
