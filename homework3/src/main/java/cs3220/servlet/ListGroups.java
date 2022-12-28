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

import cs3220.model.NewGroupEntry;
import cs3220.model.NewStudentEntry;

@WebServlet("/ListGroups")
public class ListGroups extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListGroups() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get data from database
		Connection c = null;
		try {
			// info used for the database connection
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu74";
			String username = "cs3220stu74";
			String password = "2uUKwtvHi9Un";

			// connect to database and then get all values from department table
			c = DriverManager.getConnection(url, username, password);
			Statement stmnt1 = c.createStatement();
			Statement stmnt2 = c.createStatement();

			// execute first statement to get all values from hw3_students table
			ResultSet studentsResults = stmnt1.executeQuery("select * from hw3_students");

			// execute second statement to get all values from hw3_groups table
			ResultSet groupsResults = stmnt2.executeQuery("select * from hw3_groups");

			// create a list of groups and students
			List<NewGroupEntry> groupEntries = new ArrayList<NewGroupEntry>();
			List<NewStudentEntry> studentEntries = new ArrayList<NewStudentEntry>();

			// while there are still groups, create new group and add to arrayList
			while (groupsResults.next()) {
				// create a NewGroupEntry and get the name to set for the group
				NewGroupEntry group = new NewGroupEntry();
				group.setId(groupsResults.getInt("id"));
				group.setName(groupsResults.getString("name"));

				// add the group to arraylist of groups
				groupEntries.add(group);

			}

			// while there are still students, create new student and add to arrayList
			while (studentsResults.next()) {
				// (name, birth_year, parent_name, parent_email, group_id)
				// create a NewGroupEntry and get the name to set for the group
				NewStudentEntry student = new NewStudentEntry();
				student.setStudentId(studentsResults.getInt("id"));
				student.setName(studentsResults.getString("name"));
				student.setBirthYear(studentsResults.getInt("birth_year"));
				student.setParentName(studentsResults.getString("parent_name"));
				student.setParentEmail(studentsResults.getString("parent_email"));
				student.setGroupName(studentsResults.getString("group_name"));

				// add the group to arraylist of groups
				studentEntries.add(student);

			}

			// pass the list of groups and students to view in jsp
			request.setAttribute("groupEntries", groupEntries);
			request.setAttribute("studentEntries", studentEntries);

			request.getRequestDispatcher("/WEB-INF/ListGroups.jsp").forward(request, response);

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
	}

}