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

@WebServlet("/EditStudent")
public class EditStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditStudent() {
		super();
	}

	private GroupEntry getGroup(int id) {

		@SuppressWarnings("unchecked")
		ArrayList<GroupEntry> groupEntries = (ArrayList<GroupEntry>) getServletContext().getAttribute("groupEntries");
		for (GroupEntry currentGroup : groupEntries) {
			if (currentGroup.getId() == id) {
				return currentGroup;
			}
		}

		return null;
	}

	private StudentEntry getStudent(int id) {

		@SuppressWarnings("unchecked")
		ArrayList<StudentEntry> studentEntries = (ArrayList<StudentEntry>) getServletContext()
				.getAttribute("studentEntries");
		for (StudentEntry currentStudent : studentEntries) {
			if (currentStudent.getStudentId() == id) {
				return currentStudent;
			}
		}

		return null;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String studentId = request.getParameter("studentId");
		StudentEntry studentInfo = getStudent(Integer.parseInt(studentId));

		request.setAttribute("studentInfo", studentInfo);

		request.getRequestDispatcher("/WEB-INF/EditStudent.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		StudentEntry studentInfo = getStudent(Integer.parseInt(request.getParameter("studentId")));

		studentInfo.setName(request.getParameter("nameInput"));
		studentInfo.setBirthYear(Integer.parseInt(request.getParameter("birthYearInput")));
		studentInfo.setParentName(request.getParameter("parentNameInput"));
		studentInfo.setParentEmail(request.getParameter("parentEmailInput"));

		GroupEntry group = null;

		if (Integer.parseInt(request.getParameter("groupDropdown")) == 0) {
			group = new GroupEntry("No Group");
			studentInfo.setGroup(group);
			studentInfo.setGroupName("");

		} else {
			studentInfo.setGroup(getGroup(Integer.parseInt(request.getParameter("groupDropdown"))));
			studentInfo.setGroupName(getGroup(Integer.parseInt(request.getParameter("groupDropdown"))).getName());
		}

		response.sendRedirect("StudentListing");
	}
}