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

@WebServlet(urlPatterns = "/NewGroup", loadOnStartup = 1)
public class NewGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NewGroup() {
		super();
	}

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");

			PrintWriter output = response.getWriter();
			
			output.println("<html><head><title>Add Group</title></head><body>");
			
			output.println("<form action='NewGroup' method='post'>");

			output.println("<table border=1 cellpadding=4> ");

			output.println("<tr><th>Name</th><td><input name='groupNameInput'></td></tr> ");

			output.println("<tr><td colspan='2'><button name='addButton'>Add</button></td></tr>");

			output.println("</table> </form> </body></html>");
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			String groupName = request.getParameter("groupNameInput");

			NewGroupEntry entry = new NewGroupEntry(groupName);
			
			@SuppressWarnings("unchecked")
			ArrayList<NewGroupEntry> groupEntries = (ArrayList<NewGroupEntry>) getServletContext().getAttribute("groupEntries");
					
			groupEntries.add(entry);
			
			response.sendRedirect("ListGroups");
		}

	}