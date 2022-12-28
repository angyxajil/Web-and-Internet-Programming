package cs3220.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220.model.NewGroupEntry;
import cs3220.model.NewStudentEntry;

@WebServlet("/ListGroups")
public class ListGroups extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListGroups() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		PrintWriter output = response.getWriter();

		@SuppressWarnings("unchecked")
		ArrayList<NewGroupEntry> groupEntries = (ArrayList<NewGroupEntry>) getServletContext()
				.getAttribute("groupEntries");

		@SuppressWarnings("unchecked")
		ArrayList<NewStudentEntry> studentEntries = (ArrayList<NewStudentEntry>) getServletContext()
				.getAttribute("studentEntries");

		output.println("<html><head><title>Group List</title></head><body>");

		output.println("<a href='NewGroup'>New Group</a> ");

		output.println("<form action='NewStudent' method='post'>");

		output.println("<table border='1' cellpadding='2'> ");

		output.println("<tr><th>Group</th><th>Members</th></tr> ");

		for (NewGroupEntry entry : groupEntries) {
			output.println("<tr>");
			output.println("<td>" + entry.getName() + "</td>");
			output.println("<td>");

			String seperator = "";
			
			for (NewStudentEntry student : studentEntries) {
				if (student.getGroup().getName() == entry.getName()) {
					output.print(seperator + student.getName());
					seperator = ", ";
				}
			}
			output.println("</td> </tr>");
		}

		output.println("<tr> <td>No Group</td><td>");

		String seperator = "";

		for (NewStudentEntry student : studentEntries) {
			if ((student.getGroup()).getName() == "No Group") {
				output.print(seperator + student.getName());
				seperator = ", ";
			}
		}

		output.println("</td></tr> </table> </form> </body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}