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

@WebServlet("/EditGroup")
public class EditGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditGroup() {
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

	@SuppressWarnings({ "unused", "unchecked" })
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<GroupEntry> groupEntries = (ArrayList<GroupEntry>) getServletContext().getAttribute("groupEntries");
		ArrayList<StudentEntry> studentEntries = (ArrayList<StudentEntry>) getServletContext()
				.getAttribute("studentEntries");

		String groupId = request.getParameter("groupId");
		GroupEntry groupInfo = getGroup(Integer.parseInt(groupId));

		request.setAttribute("groupInfo", groupInfo);
		request.setAttribute("groupId", groupId);

		request.getRequestDispatcher("/WEB-INF/EditGroup.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		GroupEntry groupInfo = getGroup(Integer.parseInt(request.getParameter("groupId")));

		groupInfo.setName(request.getParameter("groupNameInput"));

		response.sendRedirect("GroupListing");

	}

}
