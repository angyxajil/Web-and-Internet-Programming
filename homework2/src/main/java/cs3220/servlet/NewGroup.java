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

@WebServlet(urlPatterns = "/NewGroup", loadOnStartup = 1)
public class NewGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NewGroup() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		List<GroupEntry> groupEntries = new ArrayList<GroupEntry>();
		List<StudentEntry> studentEntries = new ArrayList<StudentEntry>();

		getServletContext().setAttribute("groupEntries", groupEntries);
		getServletContext().setAttribute("studentEntries", studentEntries);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/NewGroup.jsp").forward(request, response);
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String groupName = request.getParameter("groupNameInput");
		GroupEntry entry = new GroupEntry(groupName);
		ArrayList<GroupEntry> groupEntries = (ArrayList<GroupEntry>) getServletContext().getAttribute("groupEntries");

		groupEntries.add(entry);

		response.sendRedirect("GroupListing");
	}

}
