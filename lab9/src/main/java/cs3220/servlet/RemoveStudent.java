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

@WebServlet("/RemoveStudent")
public class RemoveStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RemoveStudent() {
		super();
	}

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get both parameters from the link
		int groupId = Integer.parseInt(request.getParameter("groupId"));
		int studentId = Integer.parseInt(request.getParameter("studentId"));

		ArrayList<NewStudentEntry9> studentEntries = (ArrayList<NewStudentEntry9>) getServletContext()
				.getAttribute("studentEntries");

		// instantiate a NewStudentEntry to find the current student
		NewStudentEntry9 student = null;

		// loop through all students to find the correct student with studentId
		for (NewStudentEntry9 currentStudent : studentEntries) {
			// if the group id's match
			if (currentStudent.getStudentId() == studentId) {
				// return the current group that has matching id
				student = currentStudent;
				break;
			}
		}

		// set the currentStudent's group to a blank group and blank name
		if (student != null) {
			student.setGroup(new NewGroupEntry9("No Group"));
			student.setGroupName("");
		}

		// redirect the user to the EditGroupPage
		response.sendRedirect("EditGroup?groupId=" + groupId);
	}

}
