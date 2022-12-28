package cs3220.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220.model.NewGroupEntry9;
import cs3220.model.NewStudentEntry9;

@WebServlet("/ListGroups9")
public class ListGroups9 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListGroups9() {
		super();
	}

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ArrayList holding Groups available
		ArrayList<NewGroupEntry9> groupEntries = (ArrayList<NewGroupEntry9>) getServletContext()
				.getAttribute("groupEntries");

		// ArrayList holding students available
		ArrayList<NewStudentEntry9> studentEntries = (ArrayList<NewStudentEntry9>) getServletContext()
				.getAttribute("studentEntries");

		// if there are no groups then just show the "New Group" link
		if (groupEntries.isEmpty() && studentEntries.isEmpty()) {
			request.getRequestDispatcher("/WEB-INF/GroupEntry.jsp").forward(request, response);
		}
		// if there are groups then display them
		else {
			request.getRequestDispatcher("/WEB-INF/ListGroups.jsp").forward(request, response);

		}

	}

}