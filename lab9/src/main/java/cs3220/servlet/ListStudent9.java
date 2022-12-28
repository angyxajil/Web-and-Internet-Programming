package cs3220.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220.model.NewGroupEntry9;
import cs3220.model.NewStudentEntry9;

@WebServlet("/ListStudent9")
public class ListStudent9 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static int currentYear = Calendar.getInstance().get(Calendar.YEAR);

	public ListStudent9() {
		super();
	}

	@SuppressWarnings({ "unchecked", "unused" })
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ArrayList holding Groups available
		ArrayList<NewGroupEntry9> groupEntries = (ArrayList<NewGroupEntry9>) getServletContext()
				.getAttribute("groupEntries");

		// ArrayList holding students available
		ArrayList<NewStudentEntry9> studentEntries = (ArrayList<NewStudentEntry9>) getServletContext()
				.getAttribute("studentEntries");

		// if there are no students then just show the "New Student" link
		if (studentEntries.isEmpty()) {
			// redirect user to the blank jsp page
			request.getRequestDispatcher("/WEB-INF/StudentEntry.jsp").forward(request, response);
		}
		// if there are students then display them
		else {
			// send the currentYear to the jsp
			request.setAttribute("currentYear", currentYear);
			// redirect the user to the student listing page
			request.getRequestDispatcher("/WEB-INF/ListStudent.jsp").forward(request, response);

		}
	}
}