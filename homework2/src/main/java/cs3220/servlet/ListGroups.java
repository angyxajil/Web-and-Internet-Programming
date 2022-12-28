package cs3220.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220.model.GroupEntry;
import cs3220.model.StudentEntry;

@WebServlet("/GroupListing")
public class ListGroups extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListGroups() {
		super();
	}

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<GroupEntry> groupEntries = (ArrayList<GroupEntry>) getServletContext().getAttribute("groupEntries");
		ArrayList<StudentEntry> studentEntries = (ArrayList<StudentEntry>) getServletContext()
				.getAttribute("studentEntries");

		if (groupEntries.isEmpty() && studentEntries.isEmpty()) {
			request.getRequestDispatcher("/WEB-INF/GroupEntry.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/ListGroups.jsp").forward(request, response);

		}
	}
}