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
@WebServlet("/courseServlet")
public class courseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession();
		ArrayList<String> sections = new ArrayList();
		sections.add("10100");
		sections.add("Cauwels");
		sections.add("D");
		sections.add("5.0");
		sections.add("4.0");
		sections.add("10105");
		sections.add("Eberlein");
		sections.add("M");
		sections.add("-4.0");
		sections.add("0.1");
		sections.add("10110");
		sections.add("Cuevas");
		sections.add("A");
		sections.add("8.9 ");
		sections.add("10.0");
		sess.setAttribute("courses", sections);
		response.sendRedirect("/courses.jsp?prefix=" + request.getParameter("prefix") + "&number=" + request.getParameter("number"));
	}

}
