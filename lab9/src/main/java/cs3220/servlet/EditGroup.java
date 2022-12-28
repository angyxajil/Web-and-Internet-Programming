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

@WebServlet("/EditGroup")
public class EditGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditGroup() {
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
				return currentGroup;
			}
		}
		return null;

	}

	@SuppressWarnings({ "unused", "unchecked" })
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ArrayList holding Groups available
		ArrayList<NewGroupEntry9> groupEntries = (ArrayList<NewGroupEntry9>) getServletContext()
				.getAttribute("groupEntries");

		// ArrayList holding students available
		ArrayList<NewStudentEntry9> studentEntries = (ArrayList<NewStudentEntry9>) getServletContext()
				.getAttribute("studentEntries");

		// get the groupId parameter and save
		String groupId = request.getParameter("groupId");

		// find group with the id
		NewGroupEntry9 groupInfo = getGroup(Integer.parseInt(groupId));

		// save group info to use in the jsp
		request.setAttribute("groupInfo", groupInfo);
		// save group info to use in the jsp
		request.setAttribute("groupId", groupId);

		// send the user to the EditGroupPage in the jsp
		request.getRequestDispatcher("/WEB-INF/EditGroup.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// find group with the groupId
		NewGroupEntry9 groupInfo = getGroup(Integer.parseInt(request.getParameter("groupId")));

		// if the user changed anything then save the info onto the currentGroup
		groupInfo.setName(request.getParameter("groupNameInput"));

		// redirect the user to the GroupListing page
		response.sendRedirect("ListGroups9");

	}

}
