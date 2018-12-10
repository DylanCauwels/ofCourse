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
 * Servlet implementation class professorServlet
 */
@WebServlet("/professorServlet")
public class professorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public professorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession();
		ArrayList<String> sections = new ArrayList();
		sections.add("10100");
		sections.add("EE");
		sections.add("313");
		sections.add("6.9");
		sections.add("4.20");
		sections.add("10105");
		sections.add("EE");
		sections.add("461L");
		sections.add("3.4");
		sections.add("Tomato");
		sections.add("10110");
		sections.add("Cancer");
		sections.add("Herself");
		sections.add("1.2");
		sections.add("3");
		sess.setAttribute("professors", sections);
		response.sendRedirect("/professors.jsp?lastName=" + request.getParameter("lastName") + "&firstInitial=" + request.getParameter("firstInitial"));
	}

}
