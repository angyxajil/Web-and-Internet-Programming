package cs3220.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220.model.NewGroupEntry;
import cs3220.model.NewStudentEntry;

@WebServlet("/HomePage")
public class HomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HomePage() {
		super();
	}

	 public void init(ServletConfig config) throws ServletException {
	    	super.init(config);

	    	List<NewGroupEntry> groupEntries = new ArrayList<NewGroupEntry>();
	    	
	    	groupEntries.add(new NewGroupEntry("Minnows"));
			groupEntries.add(new NewGroupEntry("Dolphins"));

	    	List<NewStudentEntry> studentEntries = new ArrayList<NewStudentEntry>();
	    	
	    	studentEntries.add(new NewStudentEntry("John", 2018, "Sue", "sue@gmail.com",(new NewGroupEntry("Minnows"))));
	    	groupEntries.get(0).addStudent();
	    	
	        studentEntries.add(new NewStudentEntry("Jane", 2013, "Sue", "sue@gmail.com",(new NewGroupEntry("Dolphins"))));
	    	groupEntries.get(1).addStudent();

	        studentEntries.add(new NewStudentEntry("Luke", 2017, "Steven", "steve@gmail.com",(new NewGroupEntry("Minnows"))));
	    	groupEntries.get(0).addStudent();

	        studentEntries.add(new NewStudentEntry("Tina", 2015, "Paula", "paula@gmail.com",(new NewGroupEntry(""))));
	    	
	    	getServletContext().setAttribute("groupEntries", groupEntries);
	    	
	    	getServletContext().setAttribute("studentEntries", studentEntries);
	    
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		out.println("<html><head><title>Home Page</title></head><body>");

		out.println("<a href='ListStudent'>Students</a> | <a href='ListGroups'>Groups</a>");

		out.println("</body></html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}