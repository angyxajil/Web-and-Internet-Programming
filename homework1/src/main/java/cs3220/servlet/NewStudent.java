package cs3220.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220.model.NewGroupEntry;
import cs3220.model.NewStudentEntry;

@WebServlet(urlPatterns = "/NewStudent", loadOnStartup = 1)
public class NewStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NewStudent() {
		super();
	}
    
    private NewGroupEntry getGroup(int id) {

    	@SuppressWarnings("unchecked")
		ArrayList<NewGroupEntry> groupEntries = (ArrayList<NewGroupEntry>) getServletContext().getAttribute("groupEntries");

    	for(NewGroupEntry currentGroup:groupEntries) {

    		if(currentGroup.getId() == id) {

    			return currentGroup;
    		}
    	}
    	
    	return null;	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		PrintWriter output = response.getWriter();
				
		@SuppressWarnings("unchecked")
		List<NewGroupEntry> groupEntries = (ArrayList<NewGroupEntry>) getServletContext().getAttribute("groupEntries");
		
		output.println("<html><head><title>Add Student</title></head><body>");

		output.println("<form action='NewStudent' method='post'>");

		output.println("<table border='1' cellpadding='2'>");

		output.println("<tr><th>Name</th><td><input type='text' name='nameInput'></td></tr>");

		output.println("<tr><th>Birth Year</th><td><input name='birthYearInput'></td></tr> ");

		output.println("<tr><th>Parent Name</th><td><input type='text' name='parentNameInput'></td></tr> ");

		output.println("<tr><th>Parent Email</th><td><input type='text' name='parentEmailInput'></td></tr>");

		output.println("<tr><th>Group</th><td><select name='groupDropdown'>");
		
		for(NewGroupEntry entry:groupEntries) {
			if(entry.getNumOfStudents()<5 && entry.getName()!="No Group") {
				output.println("<option value="+entry.getId()+">"+entry.getName()+"</option>");
			}
		}
		
		output.println("<option value='0'> </option></select></td></tr>");

		output.println("<tr><td colspan='2'><button name='addButton'>Add</button></td></tr>");

		output.println("</table> </form> </body></html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("nameInput");
		
		int birthYear = Integer.parseInt(request.getParameter("birthYearInput"));
		
		String parentName = request.getParameter("parentNameInput");
		
		String parentEmail = request.getParameter("parentEmailInput");
		
		NewGroupEntry group = null;
		
		if (Integer.parseInt(request.getParameter("groupDropdown")) == 0) {
			
			group = new NewGroupEntry("No Group");
		}
		else {
			group = getGroup(Integer.parseInt(request.getParameter("groupDropdown")));
		}
		
		group.addStudent();
		
		NewStudentEntry entry = new NewStudentEntry(name, birthYear, parentName, parentEmail, group);
		
		@SuppressWarnings("unchecked")
		ArrayList<NewStudentEntry> studentEntries = (ArrayList<NewStudentEntry>) getServletContext().getAttribute("studentEntries");
		
		studentEntries.add(entry);
		
		response.sendRedirect("ListStudent");
		
	}

}