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
		initials.add("W");
		sess.setAttribute("initials", initials);
		response.sendRedirect("/professors.jsp?lastNamePref=" + request.getParameter("lastNamePref"));	
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession();
		ArrayList<String> names = new ArrayList();
		names.add("ADAIR");
		names.add("AWAS");
		names.add("BARBOUR");
		names.add("BECK");
		names.add("BREECKER");
		names.add("CARTER");
		names.add("COOK");
		names.add("EVANS");
		names.add("FAGELSON");
		names.add("FELKNER");
		names.add("GAGLIO");
		names.add("HENRY");
		names.add("LATHAM");
		names.add("MCDONALD");
		names.add("MCDANIEL");
		names.add("MEADOWS");
		names.add("MELCHER");
		names.add("NEITZKE");
		names.add("NEFF");
		names.add("NEHRING");
		names.add("OLMSTEAD");
		sess.setAttribute("names", names);
		response.sendRedirect("/professors.jsp?lastNamePref=" + request.getParameter("lastName"));
	}
}


