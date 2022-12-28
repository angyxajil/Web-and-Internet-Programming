package cs3220.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220.model.NewStudentEntry;

@WebServlet("/ListStudent")
public class ListStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static int currentYear = Calendar.getInstance().get(Calendar.YEAR);

	public ListStudent() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		PrintWriter output = response.getWriter();

		@SuppressWarnings("unchecked")
		ArrayList<NewStudentEntry> studentEntries = (ArrayList<NewStudentEntry>) getServletContext()
				.getAttribute("studentEntries");

		output.println("<html><head><title>Student List</title></head><body>");

		output.println("<a href='NewStudent'>New Student</a>");

		output.println("\n<form action='NewStudent' method='post'> </form>");

		output.println("<table border='1' cellpadding='2'> ");

		output.println("<tr><th>Student</th><th>Age</th><th>Parent</th><th>Email</th></tr> ");
		
		for (NewStudentEntry entry : studentEntries) {
			output.println("<tr>");
			output.println("<td>" + entry.getName() + "</td>");
			output.println("<td>" + (currentYear - entry.getBirthYear()) + "</td>");
			output.println("<td>" + entry.getParentName() + "</td>");
			output.println("<td>" + entry.getParentEmail() + "</td>");
			output.println("</tr>");
		}
		output.println("</td></tr> </table> </body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}