package cs3220.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/NewGroup", loadOnStartup = 1)
public class NewGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NewGroup() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// redirect the user to the NewGroupPage jsp
		request.getRequestDispatcher("/WEB-INF/NewGroup.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get the name that was used in the input
		String groupName = request.getParameter("groupNameInput");

		// add group to database
		Connection c = null;
		try {
			// values to be passed to establish connection to the sql page
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu74";
			String username = "cs3220stu74";
			String password = "2uUKwtvHi9Un";

			// connect to the database
			c = DriverManager.getConnection(url, username, password);

			// executes sql statement so no special characters affect database
			String sql = "insert into hw3_groups (name) values (?)";

			// set the values to be added to the database
			PreparedStatement pstmnt = c.prepareStatement(sql);
			pstmnt.setString(1, groupName);

			// execute the database update
			pstmnt.executeUpdate();

		}
		// catch any problems with connection to sql server
		catch (SQLException e) {
			throw new ServletException(e);
		}
		// if all went well, be sure to close off the connection
		finally {
			try {
				if (c != null)
					c.close();
			} catch (SQLException e) {
				throw new ServletException(e);
			}
		}

		// redirect user to GroupListingPage
		response.sendRedirect("ListGroups");
	}

}
