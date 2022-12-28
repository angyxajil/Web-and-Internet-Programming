package cs3220.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		out.println("<html> <head> <title>Login</title></head><body>");

		out.println(
				"<form action='Login' method='post'>" + "Username: <input type='text' name='username'> <br><br>"
						+ "Password: <input type='text' name='password'> <br><br>" + "<button>Login</button></form>");
		
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String username = "cysun";
		String password = "abcd";

		if (request.getParameter("username").equals(username) && request.getParameter("password").equals(password)) {
			
			request.getSession().setAttribute("user", username);
			response.sendRedirect("Members");
			
		} else {
			response.sendRedirect("Login");
		}
	}
}