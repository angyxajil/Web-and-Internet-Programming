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

import cs3220.model.NewGroupEntry9;
import cs3220.model.NewStudentEntry9;

@WebServlet(urlPatterns = "/NewStudent", loadOnStartup = 1)
public class NewStudent9 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NewStudent9() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		// create a list to track the groups available
		List<NewGroupEntry9> groupEntries = new ArrayList<NewGroupEntry9>();

		// create a list to track the groups available
		List<NewStudentEntry9> studentEntries = new ArrayList<NewStudentEntry9>();

		// set the attribute of groupEntries
		getServletContext().setAttribute("groupEntries", groupEntries);

		// set the attribute of studentEntries
		getServletContext().setAttribute("studentEntries", studentEntries);
	}

	@SuppressWarnings("unchecked")
	private NewGroupEntry9 getGroup(int id) {
		// get all groups that are available
		ArrayList<NewGroupEntry9> groupEntries = (ArrayList<NewGroupEntry9>) getServletContext()
				.getAttribute("groupEntries");
		// loop through all groups that are available
		for (NewGroupEntry9 currentGroup : groupEntries) {
			// if the group id's match
			if (currentGroup.getId() == id) {
				// return the current group that has matching id
				return currentGroup;
			}
		}
		return null;

	}

	@SuppressWarnings({ "unchecked", "unused" })
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ArrayList holding Groups available
		List<NewGroupEntry9> groupEntries = (ArrayList<NewGroupEntry9>) getServletContext()
				.getAttribute("groupEntries");

		// redirec the user to the NewStudentPage jsp
		request.getRequestDispatcher("/WEB-INF/NewStudent.jsp").forward(request, response);

	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// create a new student with correct group
		String name = request.getParameter("nameInput");
		int birthYear = Integer.parseInt(request.getParameter("birthYearInput"));
		String parentName = request.getParameter("parentNameInput");
		String parentEmail = request.getParameter("parentEmailInput");
		// check to make determine if student has group or not
		NewGroupEntry9 group = null;
		if (Integer.parseInt(request.getParameter("groupDropdown")) == 0) {
			group = new NewGroupEntry9("No Group");
		} else {
			group = getGroup(Integer.parseInt(request.getParameter("groupDropdown")));
		}
		group.addStudent();
		NewStudentEntry9 entry = new NewStudentEntry9(name, birthYear, parentName, parentEmail, group);

		// get and save the groupEntries attribute
		ArrayList<NewStudentEntry9> studentEntries = (ArrayList<NewStudentEntry9>) getServletContext()
				.getAttribute("studentEntries");
		// add the entry to groupEntries
		studentEntries.add(entry);

		// redirect user to GroupListingPage
		response.sendRedirect("ListStudent9");

	}

}