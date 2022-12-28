package cs3220.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220.model.GroupEntry;
import cs3220.model.StudentEntry;

@WebServlet("/StudentListing")
public class ListStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static int currentYear = Calendar.getInstance().get(Calendar.YEAR);

	public ListStudent() {
		super();
	}

	@SuppressWarnings({ "unchecked", "unused" })
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<GroupEntry> groupEntries = (ArrayList<GroupEntry>) getServletContext().getAttribute("groupEntries");
		ArrayList<StudentEntry> studentEntries = (ArrayList<StudentEntry>) getServletContext()
				.getAttribute("studentEntries");

		if (studentEntries.isEmpty()) {
			request.getRequestDispatcher("/WEB-INF/StudentEntry.jsp").forward(request, response);
		} else {

			request.setAttribute("currentYear", currentYear);
			request.getRequestDispatcher("/WEB-INF/ListStudent.jsp").forward(request, response);

		}
	}
}