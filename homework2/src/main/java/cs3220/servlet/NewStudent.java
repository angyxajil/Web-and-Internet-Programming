package cs3220.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220.model.GroupEntry;
import cs3220.model.StudentEntry;

@WebServlet(urlPatterns = "/NewStudent", loadOnStartup = 1)
public class NewStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NewStudent() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		List<GroupEntry> groupEntries = new ArrayList<GroupEntry>();
		List<StudentEntry> studentEntries = new ArrayList<StudentEntry>();

		getServletContext().setAttribute("groupEntries", groupEntries);
		getServletContext().setAttribute("studentEntries", studentEntries);
	}

	@SuppressWarnings("unchecked")
	private GroupEntry getGroup(int id) {

		ArrayList<GroupEntry> groupEntries = (ArrayList<GroupEntry>) getServletContext().getAttribute("groupEntries");

		for (GroupEntry currentGroup : groupEntries) {
			if (currentGroup.getId() == id) {
				return currentGroup;
			}
		}

		return null;
	}

	@SuppressWarnings({ "unchecked", "unused" })
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<GroupEntry> groupEntries = (ArrayList<GroupEntry>) getServletContext().getAttribute("groupEntries");

		request.getRequestDispatcher("/WEB-INF/NewStudent.jsp").forward(request, response);

	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("nameInput");
		int birthYear = Integer.parseInt(request.getParameter("birthYearInput"));
		String parentName = request.getParameter("parentNameInput");
		String parentEmail = request.getParameter("parentEmailInput");
		GroupEntry group = null;

		if (Integer.parseInt(request.getParameter("groupDropdown")) == 0) {
			group = new GroupEntry("No Group");
		} else {
			group = getGroup(Integer.parseInt(request.getParameter("groupDropdown")));
		}

		group.addStudent();

		StudentEntry entry = new StudentEntry(name, birthYear, parentName, parentEmail, group);

		ArrayList<StudentEntry> studentEntries = (ArrayList<StudentEntry>) getServletContext()
				.getAttribute("studentEntries");

		studentEntries.add(entry);

		response.sendRedirect("StudentListing");

	}

}