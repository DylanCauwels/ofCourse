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
 * Servlet implementation class prefixServlet
 */
@WebServlet("/prefixes")
public class prefixServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession();
		ArrayList<String> prefixes = new ArrayList();
		prefixes.add("EE");
		prefixes.add("ME");
		prefixes.add("CS");
		sess.setAttribute("prefixes", prefixes);
		response.sendRedirect("/courses.jsp?origin=" + (String)request.getAttribute("origin"));
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession();
		ArrayList<String> numbers = new ArrayList();
		numbers.add("312");
		numbers.add("313");
		numbers.add("411");
		sess.setAttribute("numbers", numbers);
		response.sendRedirect("/courses.jsp?newDun");
	}
}
