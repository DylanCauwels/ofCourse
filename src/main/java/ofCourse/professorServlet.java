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
@WebServlet("/professors")
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
		sections.add("51585");
		sections.add("CS");
		sections.add("345");
		sections.add("4.5");
		sections.add("3.93");
		sections.add("51805");
		sections.add("CS");
		sections.add("386L");
		sections.add("4.5");
		sections.add("3.93");
		sess.setAttribute("professors", sections);
		response.sendRedirect("/professors.jsp?lastName=" + request.getParameter("lastName") + "&firstInitial=" + request.getParameter("firstInitial"));
	}

}
