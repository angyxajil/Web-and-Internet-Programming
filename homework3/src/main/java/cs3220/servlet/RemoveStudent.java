package cs3220.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RemoveStudent")
public class RemoveStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RemoveStudent() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get both parameters from the link
		int groupId = Integer.parseInt(request.getParameter("groupId"));
		int studentId = Integer.parseInt(request.getParameter("studentId"));
		int newGroupId = Types.NULL;

		// get the values of both tables
		Connection c = null;
		try {
			// info used for the database connection
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu74";
			String username = "cs3220stu74";
			String password = "2uUKwtvHi9Un";

			// connect to database and then get all values from department table
			c = DriverManager.getConnection(url, username, password);

			// executes sql statement so no special characters affect database
			String sql = "update hw3_students set group_id=" + newGroupId + ", group_name='No Group' where id="
					+ studentId;

			// set the values to be added to the database
			PreparedStatement pstmnt = c.prepareStatement(sql);

			// execute the database update
			pstmnt.executeUpdate();
		}
		// catch any problems with connecting to database
		catch (SQLException e) {
			throw new ServletException(e);
		}
		// if all went well, close off the connection to the mysql database
		finally {
			try {
				if (c != null)
					c.close();
			} catch (SQLException e) {
				throw new ServletException(e);
			}
		}

		// redirect the user to the EditGroupPage
		response.sendRedirect("EditGroup?groupId=" + groupId);
	}

}
