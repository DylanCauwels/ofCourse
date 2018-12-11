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
		prefixes.add("AAS");
		prefixes.add("ACC");
		prefixes.add("ADD");
		prefixes.add("AET");
		prefixes.add("AFR");
		prefixes.add("AHC");
		prefixes.add("ALD");
		prefixes.add("AMS");
		prefixes.add("ANS");
		prefixes.add("ANT");
		prefixes.add("ARA");
		prefixes.add("ARC");
		prefixes.add("ARE");
		prefixes.add("ARH");
		prefixes.add("ART");
		prefixes.add("ASC");
		prefixes.add("ASL");
		prefixes.add("AST");
		sess.setAttribute("prefixes", prefixes);
		response.sendRedirect("/courses.jsp?origin=" + (String)request.getAttribute("origin"));
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession();
		ArrayList<String> numbers = new ArrayList();
		numbers.add("310");
		numbers.add("312");
		numbers.add("320");
		numbers.add("330");
		numbers.add("381");
		sess.setAttribute("numbers", numbers);
		response.sendRedirect("/courses.jsp?newDun");
	}
}
