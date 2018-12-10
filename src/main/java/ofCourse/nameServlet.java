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
 * Servlet implementation class nameServlet
 */
@WebServlet("/names")
public class nameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sess = request.getSession();
		ArrayList<String> initials = new ArrayList();
		initials.add("M");
		initials.add("J");
		initials.add("Z");
		sess.setAttribute("initials", initials);
		response.sendRedirect("/professors.jsp?lastNamePref=" + request.getParameter("lastNamePref"));	
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession();
		ArrayList<String> names = new ArrayList();
		names.add("John");
		names.add("Steve");
		names.add("Ron");
		sess.setAttribute("names", names);
		response.sendRedirect("/professors.jsp?lastNamePref=" + request.getParameter("lastName"));
	}
}


