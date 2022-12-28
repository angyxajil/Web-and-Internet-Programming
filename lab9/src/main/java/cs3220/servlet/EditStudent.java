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

@WebServlet("/EditStudent")
public class EditStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditStudent() {
		super();
	}

	// helper method to get the group the user selected
	private NewGroupEntry9 getGroup(int id) {
		// get all groups that are available
		@SuppressWarnings("unchecked")
		ArrayList<NewGroupEntry9> groupEntries = (ArrayList<NewGroupEntry9>) getServletContext()
				.getAttribute("groupEntries");
		// loop through all groups that are available
		for (NewGroupEntry9 currentGroup : groupEntries) {
			// if the group id's match
			if (currentGroup.getId() == id) {
				// return the current group that has matching id
				// System.out.println("group returned from getGroup():
				// "+currentGroup.getName());
				return currentGroup;
			}
		}
		return null;
	}

	// helper method to find the student based off of id
	private NewStudentEntry9 getStudent(int id) {
		// ArrayList holding students available
		@SuppressWarnings("unchecked")
		ArrayList<NewStudentEntry9> studentEntries = (ArrayList<NewStudentEntry9>) getServletContext()
				.getAttribute("studentEntries");
		// loop through all students in studentEntries arraylist
		for (NewStudentEntry9 currentStudent : studentEntries) {
			// if currentStudent id matches id parameter
			if (currentStudent.getStudentId() == id) {
				// return the student reference
				return currentStudent;
			}
		}
		// otherwise return nothing because nothing was found
		return null;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get the studentId parameter and save
		String studentId = request.getParameter("studentId");
		// find student with the studentId
		NewStudentEntry9 studentInfo = getStudent(Integer.parseInt(studentId));
		// save student info to use in the jsp
		request.setAttribute("studentInfo", studentInfo);
		// send the user to the EditStudentPage in the jsp
		request.getRequestDispatcher("/WEB-INF/EditStudent.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// find student with the studentId
		NewStudentEntry9 studentInfo = getStudent(Integer.parseInt(request.getParameter("studentId")));

		// get all values in the jsp and set the data in the arrayList
		studentInfo.setName(request.getParameter("nameInput"));
		studentInfo.setBirthYear(Integer.parseInt(request.getParameter("birthYearInput")));
		studentInfo.setParentName(request.getParameter("parentNameInput"));
		studentInfo.setParentEmail(request.getParameter("parentEmailInput"));

		// get the students new group (if any) and save
		NewGroupEntry9 group = null;
		if (Integer.parseInt(request.getParameter("groupDropdown")) == 0) {
			group = new NewGroupEntry9("No Group");
			studentInfo.setGroup(group);
			studentInfo.setGroupName("");
		} else {
			studentInfo.setGroup(getGroup(Integer.parseInt(request.getParameter("groupDropdown"))));
			studentInfo.setGroupName(getGroup(Integer.parseInt(request.getParameter("groupDropdown"))).getName());
		}

		// redirect the user to the studentListing page
		response.sendRedirect("ListStudent");
	}

}
