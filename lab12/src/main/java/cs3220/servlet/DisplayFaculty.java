package cs3220.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220.model.Department;
import cs3220.model.Faculty;

@WebServlet(urlPatterns = "/DisplayFaculty", loadOnStartup = 1)
public class DisplayFaculty extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public DisplayFaculty() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection c = null;

		try {

			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu74";
			String username = "cs3220stu74";
			String password = "2uUKwtvHi9Un";

			c = DriverManager.getConnection(url, username, password);
			Statement stmnt1 = c.createStatement();
			Statement stmnt2 = c.createStatement();

			ResultSet rs = stmnt1.executeQuery("select * from department");

			List<Department> departments = new ArrayList<Department>();

			while (rs.next()) {
				Department entry = new Department();
				entry.setName(rs.getString("name"));

				departments.add(entry);

				ResultSet facultyResult = stmnt2
						.executeQuery("select * from faculty where department_name=\"" + rs.getString("name") + "\"");

				while (facultyResult.next()) {

					Faculty newFacultyMember = new Faculty(facultyResult.getString("name"));

					boolean isChair = facultyResult.getBoolean("is_chair");
					if (isChair) {
						newFacultyMember.setChair(true);
					}
					entry.getFaculty().add(newFacultyMember);
				}
			}

			request.setAttribute("departments", departments);
		}

		catch (SQLException e) {
			throw new ServletException(e);
		}

		finally {
			try {
				if (c != null)
					c.close();
			} catch (SQLException e) {
				throw new ServletException(e);
			}
		}

		request.getRequestDispatcher("/WEB-INF/DisplayFaculty.jsp").forward(request, response);
	}

}