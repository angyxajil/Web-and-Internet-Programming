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

@WebServlet("/AddFaculty")
public class AddFaculty extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public AddFaculty() {
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
			Statement stmnt = c.createStatement();
			ResultSet rs = stmnt.executeQuery("select * from department");

			List<Department> departments = new ArrayList<Department>();

			while (rs.next()) {
				Department entry = new Department();
				entry.setName(rs.getString("name"));
				departments.add(entry);
			}

			request.setAttribute("departments", departments);

		} catch (SQLException e) {
			throw new ServletException(e);
		} finally {
			try {
				if (c != null)
					c.close();
			} catch (SQLException e) {
				throw new ServletException(e);
			}
		}

		request.getRequestDispatcher("/WEB-INF/AddFaculty.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String departmentName = request.getParameter("department");

		String facultyName = request.getParameter("faculty");

		int isChair = 0;
		if (request.getParameter("chair") != null) {
			isChair = 1;
		}

		Faculty faculty = new Faculty(facultyName);

		Connection c = null;

		try {
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu74";
			String username = "cs3220stu74";
			String password = "2uUKwtvHi9Un";

			c = DriverManager.getConnection(url, username, password);

			Statement stmnt = c.createStatement();
			String sql = "insert into faculty (name,is_chair,department_name) values ('" + facultyName + "', '"
					+ isChair + "', '" + departmentName + "')";
			stmnt.executeUpdate(sql);

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

		response.sendRedirect("DisplayFaculty");
	}

}