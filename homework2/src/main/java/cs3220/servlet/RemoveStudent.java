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

@WebServlet("/RemoveStudent")
public class RemoveStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RemoveStudent() {
		super();
	}

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int groupId = Integer.parseInt(request.getParameter("groupId"));
		int studentId = Integer.parseInt(request.getParameter("studentId"));

		ArrayList<StudentEntry> studentEntries = (ArrayList<StudentEntry>) getServletContext()
				.getAttribute("studentEntries");
		StudentEntry student = null;

		for (StudentEntry currentStudent : studentEntries) {
			if (currentStudent.getStudentId() == studentId) {
				student = currentStudent;
				break;
			}
		}

		if (student != null) {
			student.setGroup(new GroupEntry("No Group"));
			student.setGroupName("");
		}

		response.sendRedirect("EditGroup?groupId=" + groupId);
	}
}