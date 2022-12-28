package cs3220.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Members
 */
@WebServlet("/Members")
public class Members extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Members() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html> <head> <title>Members</title></head><body>");
		out.println("<h2>Welcome to the Members Area </h2>");
		String user = (String) request.getSession().getAttribute("user");

		out.println("<form action='Members' method='post'>");
		out.println("<button>Logout</button></form>");

		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("Logout");
	}

}
