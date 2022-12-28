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

@WebServlet(urlPatterns = "/NewGroup", loadOnStartup = 1)
public class NewGroup9 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NewGroup9() {
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// redirect the user to the NewGroupPage jsp
		request.getRequestDispatcher("/WEB-INF/NewGroup.jsp").forward(request, response);
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get the name that was used in the input
		String groupName = request.getParameter("groupNameInput");
		// create a NewGroupEntry with input name
		NewGroupEntry9 entry = new NewGroupEntry9(groupName);

		// get and save the groupEntries attribute
		ArrayList<NewGroupEntry9> groupEntries = (ArrayList<NewGroupEntry9>) getServletContext()
				.getAttribute("groupEntries");

		// add the entry to groupEntries
		groupEntries.add(entry);

		// redirect user to GroupListingPage
		response.sendRedirect("ListGroups9");
	}

}
