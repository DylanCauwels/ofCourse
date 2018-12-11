package ofCourse;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class courseServlet
 */
@WebServlet("/courses")
public class courseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession();
		ArrayList<String> sections = new ArrayList();
		sections.add("32155");
		sections.add("NAULT");
		sections.add("C");
		sections.add("3.74");
		sections.add("4.6");
		sess.setAttribute("courses", sections);
		response.sendRedirect("/courses.jsp?prefix=" + request.getParameter("prefix") + "&number=" + request.getParameter("number"));
	}

}
